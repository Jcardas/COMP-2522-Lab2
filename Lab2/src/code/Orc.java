public class Orc extends Creature
{
    private static final int RAGE_BOOST_REQUIREMENT;
    private static final int BERSERK_RAGE_INCREASE;
    private static final int RAGE_BOOST_MODIFIER;
    private static final int MIN_RAGE;
    private static final int MAX_RAGE;
    private static final int RAGE_NORMAL_DAMAGE;

    private int rage;

    static
    {
        RAGE_BOOST_REQUIREMENT = 20;
        RAGE_BOOST_MODIFIER    = 2;
        BERSERK_RAGE_INCREASE  = 5;
        MIN_RAGE               = 5;
        MAX_RAGE               = 30;
        RAGE_NORMAL_DAMAGE     = 15;
    }

    /**
     * <p>Constructs a new {@code Orc} object with the specified
     * {@code name}, {@code dateOfBirth}, {@code health}, and {@code rage}</p>
     * <p>
     * Validates input parameter and throws an exception if parameters are invalid.
     *
     * @param name        the name of the creature
     * @param dateOfBirth Date object for the creature's date of birth
     * @param health      The initial health of the creature
     * @param rage        The initial rage of the creature
     * @throws IllegalArgumentException if {@code rage} is negative or greater than {@code MAX_FIREPOWER}
     */
    Orc(final String name,
        final Date dateOfBirth,
        final int health,
        final int rage)
    throws IllegalArgumentException
    {
        super(name, dateOfBirth, health);

        validateRage(rage);

        this.rage = rage;

    }

    /*
     * Checks if rage is less than MIN_RAGE or greater than MAX_RAGE.
     * If true, throws an IllegalArgumentException.
     */
    private void validateRage(final int rage)
    {
        if(rage < MIN_RAGE)
        {
            throw new LowRageException("Rage too low.");
        }
        if(rage > MAX_RAGE)
        {
            throw new LowRageException("Rage too high.");
        }
    }

    /**
     * Overrides {@code getDetails} from parent class and adds the creature's
     * {@code rage} amount to the output.
     */
    @Override
    void getDetails()
    {
        super.getDetails();

        final StringBuilder details;
        details = new StringBuilder();

        details.append(" and has ");
        details.append(this.rage);
        details.append(" rage left.");

        System.out.println(details.toString());
    }

    /**
     * Gets the current rage amount.
     *
     * @return int rage.
     */
    int getRage()
    {
        return this.rage;
    }

    /**
     * <p>Damages the {@link Creature} object {@code creatureHit}</p>
     * <p>Increases {@code rage} by {@code BERSERK_RAGE_INCREASE}.</p>
     *
     * <p>If {@code rage} exceeds {@code RAGE_BOOST_REQUIREMENT}, deals double damage ({@code RAGE_BOOSTED_DAMAGE})
     * to the passed Creature object {@code creatureHit}</p>
     *
     * @throws IllegalArgumentException if {@code creatureHut} is {@code null}
     * @throws LowRageException         if {@code rage} is less than {@code MIN_RAGE}
     */
    void berserk(Creature creatureHit)
    {
        if(creatureHit == null)
        {
            throw new IllegalArgumentException("creatureHit cannot be null");
        }
        if(rage > RAGE_BOOST_REQUIREMENT)
        {
            creatureHit.takeDamage(RAGE_NORMAL_DAMAGE * RAGE_BOOST_MODIFIER);
            this.rage += BERSERK_RAGE_INCREASE;
        }
        if(rage < MIN_RAGE)
        {
            throw new LowRageException("rage too low: [" + rage + "]");
        } else if(rage < RAGE_BOOST_REQUIREMENT)
        {
            creatureHit.takeDamage(RAGE_NORMAL_DAMAGE);
            this.rage += BERSERK_RAGE_INCREASE;
        }
    }
}
