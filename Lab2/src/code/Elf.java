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

    public Elf(String name,
               Date dateOfBirth,
               int health,
               int mana)
            //Throws IllegalArgumentException if parameters are invalid
               throws IllegalArgumentException
    {
        super(name, dateOfBirth, health);
        validateMana(mana);

        this.mana = mana;
    }

    private static void validateMana(final int mana)
    {
        if(mana < MIN_MANA || mana > MAX_MANA)
        {
            throw new IllegalArgumentException("Invalid mana: " + mana);
        }
    }

    @Override
    void getDetails()
    {
        super.getDetails();

        final StringBuilder details;
        details = new StringBuilder();

        details.append(" and has ");
        details.append(this.mana);
        details.append(" mana left.");
    }

    private void castSpell(Creature creatureHit)
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
        creatureHit.takeDamage( SPELL_POWER );
    }

    private void restoreMana(int amount)
    {
        if(amount < MIN_MANA || amount > MAX_MANA)
        {
            throw new IllegalArgumentException("Invalid mana amount: " + amount);
        }
        this.mana = Math.min(this.mana + amount, MAX_MANA);
    }
}
