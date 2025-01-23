public class Orc extends Creature
{
    private static final int RAGE_BOOST_REQUIREMENT;
    private static final int RAGE_BOOSTED_DAMAGE;
    private static final int MIN_RAGE;
    private static final int RAGE_NORMAL_DAMAGE;

    private int rage;

    static
    {
        RAGE_BOOST_REQUIREMENT = 20;
        RAGE_BOOSTED_DAMAGE    = 30;
        MIN_RAGE               = 5;
        RAGE_NORMAL_DAMAGE     = 15;
    }

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
    Orc(final String name,
        final Date dateOfBirth,
        final int health,
        final int rage)
        throws IllegalArgumentException
    {
        super(name, dateOfBirth, health);

        this.rage = rage;

    }

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

    private void berserk(Creature creatureHit)
    {
        if(creatureHit == null)
        {
            throw new IllegalArgumentException("creatureHit cannot be null");
        }
        if(rage < RAGE_BOOST_REQUIREMENT)
        {
            creatureHit.takeDamage(RAGE_BOOSTED_DAMAGE );
        }
        if(rage < MIN_RAGE)
        {
            throw new LowRageException("Invalid rage amount: " + rage);
        }
        this.rage += MIN_RAGE;
        creatureHit.takeDamage(RAGE_NORMAL_DAMAGE);
    }
}
