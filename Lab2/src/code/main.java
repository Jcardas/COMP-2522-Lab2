public class main
{
    public static void main(final String[] args)
    {

        /*
         TO DO:

        Unchecked Exceptions:
        - DamageException: Thrown when an invalid damage amount is applied.
        - HealingException: Thrown when an invalid healing amount is applied.
        - LowRageException: Thrown when an Orc cannot go berserk due to insufficient rage.

        Checked Exceptions:
        - LowFirePowerException: Thrown when a Dragon tries to breathe fire with insufficient firePower.
        - LowManaException: Thrown when an Elf tries to cast a spell with insufficient mana.
         */


        //Testing

        Date d1 = new Date(15, 7, 2004);

        Dragon c1 = new Dragon("john", d1, 25, 50);
        Dragon c2 = new Dragon("Dragor", d1, 50, 50);

        c1.getDetails();

        c2.getDetails();

        c1.breathFire(c2);

        c2.getDetails();

    }
}
