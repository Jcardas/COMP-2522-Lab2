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

    private final int NO_HEALTH  = 0;
    private final int MIN_HEALTH = 1;
    private final int MAX_HEALTH = 100;

    private final String name;
    private final Date   dateOfBirth;
    private       int    health;

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
     * 1. Must be in the range of 1 - 100
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

    private void heal(final int healAmount)
    {
        // Code logic here...
    }

    private int getAgeYears()
    {
        // Code logic here...
    }

    private String getDetails()
    {
        // Code logic here...
    }

}