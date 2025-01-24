/**
 * Models a creature with a given name, date of birth and health amount.
 * Includes methods for checking if it's alive, taking damage,
 * healing, getting its age in years and getting its details.
 *
 * @author Mohammad Sadeghi
 * @author Justin Cardas
 * @author Armaan
 * @version 1.0
 */
class Creature
{

    // Instance Variables

    // Health
    private static final int NO_HEALTH;
    private static final int MIN_HEALTH;
    private static final int MAX_HEALTH;

    // Year
    private static final int CURRENT_YEAR;
    private static final int CURRENT_MONTH;
    private static final int CURRENT_DAY;

    static
    {
        // Health Constants
        NO_HEALTH = 0;
        MIN_HEALTH = 1;
        MAX_HEALTH = 100;

        // Year Constants
        CURRENT_YEAR = 2025;
        CURRENT_MONTH = 1;
        CURRENT_DAY = 23;
    }

    private final String name;
    private final Date dateOfBirth;
    private int health;

    /**
     * <p>Constructs a new {@code Creature} object with the specified
     * {@code name}, {@code dateOfBirth}, and {@code health}</p>
     *
     * <p>Validates the input parameters and throws an {@link IllegalArgumentException}
     * if the parameters are invalid.</p>
     *
     * @param name        the name of the creature.
     * @param dateOfBirth the Date object of the date of birth of the creature.
     * @param health      the initial health of the creature.
     * @throws IllegalArgumentException if any of the following:
     *                                  <ul>
     *                                      <li>{@code name} is {@code null} or empty.</li>
     *                                      <li>{@code dateOfBirth} is {@code null}.</li>
     *                                      <li>{@code health} is negative.</li>
     *                                  </ul>
     */
    Creature(final String name,
             final Date dateOfBirth,
             final int health)
    // Throws IllegalArgumentException if parameters are invalid.
            throws IllegalArgumentException
    {

        validateName(name);
        validateDOB(dateOfBirth);
        validateHealth(health);


        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.health = health;
    }

    /**
     * @return String name of the creature.
     */
    public String getName()
    {
        return name;
    }

    /**
     * @return Date object date of birth of the creature.
     */
    public Date getDateOfBirth()
    {
        return dateOfBirth;
    }

    /**
     * @return int health of the creature.
     */
    public int getHealth()
    {
        return health;
    }

    /*
     * Validates the given name based on specific criteria:
     * 1. Must not be null
     * 2. Must not be empty
     *
     */
    private void validateName(final String name)
    {
        if (name == null || name.isBlank())
        {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
    }

    /*
     * Validates the given date of birth based on specific criteria:
     * 1. Must not be in the future
     *
     */
    private void validateDOB(final Date dateOfBirth)
    {
        //throw an IllegalArgumentException if no date of birth is given
        if (dateOfBirth == null)
        {
            throw new IllegalArgumentException("Date of birth cannot be null");
        }

        //throw an IllegalArgumentException if year of date of birth is in the future
        if (dateOfBirth.getYear() > CURRENT_YEAR)
        {
            throw new IllegalArgumentException("Date of birth cannot be in the future");
        }

        if (dateOfBirth.getYear() == CURRENT_YEAR)
        {
            //throw an IllegalArgumentException if month of date of birth is in the future of the current year
            if (dateOfBirth.getMonth() > CURRENT_MONTH)
            {
                throw new IllegalArgumentException("Date of birth cannot be in the future");
            }

            //throw an IllegalArgumentException if day of date of birth is in the future of the current year and current month
            if (dateOfBirth.getMonth() == CURRENT_MONTH && dateOfBirth.getDay() > CURRENT_DAY)
            {
                throw new IllegalArgumentException("Date of birth cannot be in the future");
            }
        }
    }

    /*
     * Validates the given health based on specific criteria:
     * 1. Must be in the range of MIN_HEALTH - MAX_HEALTH
     *
     */
    private void validateHealth(final int health)
    {
        if (health < NO_HEALTH || health > MAX_HEALTH)
        {
            throw new IllegalArgumentException("Health must be between " + MIN_HEALTH + " and " + MAX_HEALTH);
        }
    }

    /**
     * Checks if the creature is alive or not, based on its health.
     *
     * @return true if health of creature is greater than 0, false otherwise
     */
    boolean isAlive()
    {
        return this.health > NO_HEALTH;
    }

    /**
     * Updates creatures health by damage taken.
     * Reduces health of creature by damage amount.
     * If health goes below zero it is set to zero.
     * If damage is negative a DamageException is thrown.
     *
     * @param damage amount of damage taken
     */
    void takeDamage(final int damage)
    {
        if (damage < NO_HEALTH)
        {
            throw new DamageException("Damage cannot be negative");
        }
        this.health -= damage;

        if (this.health < NO_HEALTH)
        {
            this.health = NO_HEALTH;
        }
    }

    /**
     * <p>Updates creatures health by healing applied.</p>
     * <p>Increases a creatures health by {@code healAmount}</p>
     * <p>If health increases past {@code MAX_HEALTH} it is set to {@code MAX_HEALTH}</p>
     * <p>If {@code healAmount} is negative, a {@code HealingException} is thrown</p>
     *
     * @param healAmount amount of healing to apply
     */
    void heal(final int healAmount)
    {
        if (healAmount < NO_HEALTH)
        {
            throw new HealingException("Healing amount cannot be negative.");
        }

        // Adds the healAmount to current health, or sets the health to MAX_HEALTH, whichever is lower.
        this.health = Math.min(this.health + healAmount, MAX_HEALTH);
    }

    /**
     * <p>Returns the age of the creature in years
     * by subtracting the year of birth from the {@code CURRENT_YEAR}</p>
     *
     * @return int - age in years.
     */
    int getAgeYears()
    {
        // Returns age of the creature by subtracting the year of birth from the current year.
        return CURRENT_YEAR - this.dateOfBirth.getYear();
    }

    /**
     * <p>Prints the creature's name, dateOfBirth, age, and health in a formatted string</p>
     */
    void getDetails()
    {
        final StringBuilder details;

        details = new StringBuilder();

        details.append(this.name);
        details.append(", born on ");
        details.append(dateOfBirth);
        details.append(" (");
        details.append(this.getAgeYears());
        details.append(") has ");
        details.append(this.health);
        details.append(" health");

        System.out.print(details);
    }
}