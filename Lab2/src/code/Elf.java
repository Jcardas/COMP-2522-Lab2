/**
 * Represents an Elf which extends {@code Creature} with a mana amount.
 * Includes methods for castSpell and restoreMana.
 *
 * @author Armaan Brar
 * @author Justin Cardas
 * @author Mohammad Sadeghi
 */
public class Elf extends Creature
{
    private final static int MIN_MANA;
    private final static int MAX_MANA;
    private final static int MANA_SPELL_COST;
    private final static int SPELL_POWER;

    static
    {
        MIN_MANA = 0;
        MAX_MANA = 50;
        MANA_SPELL_COST = 5;
        SPELL_POWER = 10;
    }

    private int mana;

    /**
     * <p>Constructs a new {@code Elf} object with the specified
     * {@code name}, {@code dateOfBirth}, {@code health}, and {@code mana}</p>
     *
     * Validates input parameter and throws an exception if parameters are invalid.
     *
     * @param name          the name of the creature
     * @param dateOfBirth   Date object for the creature's date of birth
     * @param health        The initial health of the creature
     * @param mana          The initial mana of the creature
     * @throws IllegalArgumentException if {@code mana} is negative or greater than {@code MAX_MANA}
     */
    public Elf(String name,
               Date dateOfBirth,
               int health,
               int mana)
               //Throws IllegalArgumentException if parameters are invalid.
               throws IllegalArgumentException
    {
        super(name, dateOfBirth, health);
        validateMana(mana);

        this.mana = mana;
    }

    /*
     * Checks if {@code mana} is less than {@code MIN_MANA} or greater than
     * {@code MAX_MANA}, if either is true, throw exception.
     */
    private static void validateMana(final int mana)
    {
        if(mana < MIN_MANA || mana > MAX_MANA)
        {
            throw new IllegalArgumentException("Invalid mana: " + mana);
        }
    }

    /**
     * Overrides {@code getDetails} from parent class and adds the creature's
     * {@code mana} amount to the output.
     */
    @Override
    void getDetails()
    {
        super.getDetails();

        final StringBuilder details;
        details = new StringBuilder();

        details.append(" and has ");
        details.append(this.mana);
        details.append(" mana left.");

        System.out.println(details.toString());
    }

    /*
     * <p>Reduces {@code mana} by {@code MANA_SPELL_COST} and deals {@code SPELL_POWER}
     * amount of damage to a creature. If {@code mana} is less than {@code MANA_SPELL_COST}
     * throw checked exception {@link LowManaException}.
     */
    void castSpell(Creature creatureHit)
    throws LowManaException
    {
        if(creatureHit == null)
        {
            throw new IllegalArgumentException("Creature hit cannot be null");
        }
        if(this.mana < MANA_SPELL_COST)
        {
            throw new LowManaException("Mana is too low to cast spell " + "[" + this.mana + "]");
        }
        this.mana -= MANA_SPELL_COST;
        creatureHit.takeDamage(SPELL_POWER);
    }

    /*
     * Restores mana based on amount provided. Amount cannot be negative or
     * exceed {@code MAX_MANA}
     */
    void restoreMana(int amount)
    {
        if(amount < MIN_MANA || amount > MAX_MANA)
        {
            throw new IllegalArgumentException("Invalid mana amount: " + amount);
        }

        // Adds the mana amount to current mana,
        // or sets the mana to MAX_MANA, whichever is lower.
        this.mana = Math.min(this.mana + amount, MAX_MANA);
    }
}
