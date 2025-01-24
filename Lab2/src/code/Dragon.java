/**
 * <P>Represents a dragon which extends {@code Creature} with a firePower amount.</P>
 *
 * <p>Includes methods for breathing fire, and restoring firePower.</p>
 *
 * @author Justin Cardasddr5 ram
 * @author Mohammad Sadeghi
 * @author Armaan Brar
 * @version 1.0
 */
class Dragon extends Creature
{
    private static final int MIN_FIREPOWER;
    private static final int MAX_FIREPOWER;
    private static final int FIREPOWER_COST;
    private static final int FIREPOWER_DAMAGE;

    static
    {
        MIN_FIREPOWER = 0;
        MAX_FIREPOWER = 100;
        FIREPOWER_COST = 10;
        FIREPOWER_DAMAGE = 20;
    }

    private int firePower;

    /**
     * <p>Constructs a new {@code Dragon} object with the specified
     * {@code name}, {@code dateOfBirth}, {@code health}, and {@code firePower}</p>
     * <p>
     * Validates input parameter and throws an exception if parameters are invalid.
     *
     * @param name        the name of the creature
     * @param dateOfBirth Date object for the creature's date of birth
     * @param health      The initial health of the creature
     * @param firePower   The initial firePower of the creature
     * @throws IllegalArgumentException if {@code firePower} is negative or greater than {@code MAX_FIREPOWER}
     */
    Dragon(final String name,
           final Date dateOfBirth,
           final int health,
           final int firePower)
            throws IllegalArgumentException
    {
        super(name, dateOfBirth, health);

        validateFirePower(firePower);

        this.firePower = firePower;
    }


    /*
     * Checks if firePower is less than MIN_FIREPOWER.
     * If true, throws an IllegalArgumentException.
     */
    private void validateFirePower(final int firePower)
    {
        if (firePower < MIN_FIREPOWER)
        {
            throw new IllegalArgumentException("Firepower cannot be negative.");
        }
    }

    /**
     * Overrides {@code getDetails} from parent class and adds the creature's
     * {@code firePower} amount to the output.
     */
    @Override
    void getDetails()
    {
        super.getDetails();

        final StringBuilder details;

        details = new StringBuilder();

        details.append(" and has ");
        details.append(this.firePower);
        details.append(" fire power left.");

        System.out.println(details.toString());
    }

    /**
     * <p>Reduces {@code firePower} by {@code FIREPOWER_COST} and deals {@code FIREPOWER_DAMAGE}
     * amount of damage to a creature.</p>
     * <p>If {@code firePower} is less than {@code FIREPOWER_COST}
     * throw checked exception {@link LowFirePowerException}.</p>
     *
     * @param creatureHit The creature object to be affected.
     * @throws LowFirePowerException if the current firePower amount is lower than FIREPOWER_COST.
     **/
    void breathFire(final Creature creatureHit)
    throws LowFirePowerException
    {
        if(creatureHit == null)
        {
            throw new IllegalArgumentException("creatureHit cannot be null.");
        }
        if(this.firePower < FIREPOWER_COST)
        {
            throw new LowFirePowerException("couldn't breath fire. Fire power too low. " + "[" + this.firePower + "]");
        }

        // Reduce firePower by 10, cause creature hit to take 20 damage.
        this.firePower -= FIREPOWER_COST;
        creatureHit.takeDamage(FIREPOWER_DAMAGE);
    }

    /**
     * <p>Restores firePower based on amount provided. Amount cannot be negative.</p>
     * <p>If amount will exceed MAX_FIREPOWER, set the current firePower to MAX_FIREPOWER instead.</p>
     *
     * @param amount The amount of firePower to restore.
     * @throws IllegalArgumentException if the current firePower amount is less than MIN_FIREPOWER.
     **/
    void restoreFirePower(int amount)
    {
        if (amount < MIN_FIREPOWER)
        {
            throw new IllegalArgumentException("Firepower cannot be negative");
        }

        // Adds the firePower amount to current firePower,
        // or sets the firePower to MAX_FIREPOWER, whichever is lower.
        this.firePower = Math.min(this.firePower + amount, MAX_FIREPOWER);
    }
}
