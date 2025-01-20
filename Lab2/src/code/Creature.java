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
public class Creature
{

    // Instance Variables

    // Health
    private static final int NO_HEALTH;
    private static final int MIN_HEALTH;
    private static final int MAX_HEALTH;

    // Year
    private static final int CURRENT_YEAR;

    static
    {
        // Health Constants
        NO_HEALTH = 0;
        MIN_HEALTH = 1;
        MAX_HEALTH = 100;

        // Year Constants
        CURRENT_YEAR = 2025;
    }

    private final String name;
    private final Date   dateOfBirth;
    private       int    health;

    /**
     * <p>Constructs a new {@code Creature} object with the specified
     * {@code name}, {@code dateOfBirth}, and {@code health}</p>
     *
     * <p>Validates the input parameters and throws an {@link IllegalArgumentException}
     * if the parameters are invalid.</p>
     *
     * @param name the name of the creature.
     * @param dateOfBirth the Date object of the date of birth of the creature.
     * @param health the initial health of the creature.
     * @throws IllegalArgumentException if any of the following:
     * <ul>
     *     <li>{@code name} is {@code null} or empty.</li>
     *     <li>{@code dateOfBirth} is {@code null}.</li>
     *     <li>{@code health} is negative.</li>
     * </ul>
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


        this.name        = name;
        this.dateOfBirth = dateOfBirth;
        this.health      = health;
    }

    /**
     * Validates the given name based on specific criteria:
     * 1. Must not be null
     * 2. Must not be empty
     *
     * @param name the name to be validated
     */
    private void validateName(final String name)
    {
        if(name == null || name.isBlank())
        {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
    }

    /**
     * Validates the given date of birth based on specific criteria:
     * 1. Must not be in the future
     *
     * @param dateOfBirth the date of birth to be validated
     */
    private void validateDOB(final Date dateOfBirth)
    {

    }

    /**
     * Validates the given health based on specific criteria:
     * 1. Must be in the range of MIN_HEALTH - MAX_HEALTH
     *
     * @param health the health amount being validated
     */
    private void validateHealth(final int health)
    {
        if(health < NO_HEALTH || health > MAX_HEALTH)
        {
            throw new IllegalArgumentException("Health must be between " + MIN_HEALTH + " and " + MAX_HEALTH);
        }
    }

    /**
     * Checks if the creature is alive or not, based on its health.
     *
     * @return true if health of creature is greater than 0, false otherwise
     */
    private boolean isAlive()
    {
        return this.health > 0;
    }

    /**
     * Updates creatures health by damage taken.
     * Reduces health of creature by damage amount.
     * If health goes below zero it is set to zero.
     * If damage is negative a DamageException is thrown.
     *
     * @param damage amount of damage taken
     */
    private void takeDamage(final int damage)
    {
        if(damage < 0)
        {
            throw new DamageException("Damage cannot be negative");
        }
        this.health -= damage;

        if(this.health < 0)
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
    private void heal(final int healAmount)
    {
        if(healAmount < NO_HEALTH)
        {
            throw new HealingException("Healing amount cannot be negative.");
        }

        // Checks if healing would exceed maximum health,
        // if so, set current health to maximum health.
        // Otherwise, heal the creature by healAmount.
        this.health = (this.health + healAmount > MAX_HEALTH) ? MAX_HEALTH : this.health + healAmount;
    }

    /**
     * <p>Returns the age of the creature in years
     * by subtracting the year of birth from the {@code CURRENT_YEAR}</p>
     *
     * @return int - age in years.
     */
    private int getAgeYears()
    {
        // Returns age of the creature by subtracting the year of birth from the current year.
        return CURRENT_YEAR - this.dateOfBirth.getYear();
    }

    /**
     * <p>Prints the creature's name, dateOfBirth, age, and health in a formatted string</p>
     */
    private void getDetails()
    {

        final StringBuilder details;

        details = new StringBuilder();

        details.append(this.name);
        details.append("born on ");
        details.append(dateOfBirth);
        details.append(" (");
        details.append(this.getAgeYears());
        details.append(") has ");
        details.append(this.health);
        details.append(" health.");

        System.out.print(details);
    }
}