public class Orc extends Creature
{

    private final int rage;

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

    }
}
