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


    private void validateFirePower(final int firePower)
    {
        if (firePower < MIN_FIREPOWER)
        {
            throw new IllegalArgumentException("Firepower cannot be negative.");
        }
    }

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

    void breathFire(final Creature creatureHit)
    {
        if (creatureHit == null)
        {
            throw new IllegalArgumentException("creatureHit cannot be null.");
        }
        if (this.firePower < FIREPOWER_COST)
        {
            throw new LowFirePowerException("Fire power too low. " + "[" + this.firePower + "]");
        }

        // Reduce firePower by 10, cause creature hit to take 20 damage.
        this.firePower -= FIREPOWER_COST;
        creatureHit.takeDamage(FIREPOWER_DAMAGE);
    }

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
