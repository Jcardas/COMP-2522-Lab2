public class CreatureTest
{
    public static void main(final String[] args)
    {

        // Creature Objects
        final Date d1;
        d1 = new Date(20, 1, 2006);

        final Date d2;
        d2 = new Date(15, 7, 2005);

        final Date d3;
        d3 = new Date(21, 4, 2000);

        final Dragon dragon_1;
        dragon_1 = new Dragon("Zartan", d1, 100, 0);

        final Elf elf_1;
        elf_1 = new Elf("Sir Elfizar", d2, 50, 0);

        final Orc orc_1;
        orc_1 = new Orc("Grunk", d3, 75, 25);

        dragon_1.getDetails();
        elf_1.getDetails();
        orc_1.getDetails();

        if(dragon_1 instanceof Dragon)
        {
            System.out.println(dragon_1.getName() + " is an instance of Dragon.");
            System.out.println("Exact class: " + dragon_1.getClass().getSimpleName());
        }

        if(elf_1 instanceof Elf)
        {
            System.out.println(elf_1.getName() + " is an instance of Elf.");
            System.out.println("Exact class: " + elf_1.getClass().getSimpleName());
        }

        if(orc_1 instanceof Orc)
        {
            System.out.println(orc_1.getName() + " is an instance of Orc.");
            System.out.println("Exact class: " + orc_1.getClass().getSimpleName());
        }

        // The battle:

        System.out.println("The battle begins...\n");

        // Dragon tries to breath fire against elf,
        // catches LowFirePowerException if the Dragon doesn't have enough firePower.
        System.out.println(dragon_1.getName() + " tries to breathe fire against " + elf_1.getName() + "...");
        try
        {
            dragon_1.breathFire(elf_1);
            System.out.println(dragon_1.getName() + " successfully breathed fire against " + elf_1.getName() + ". " +
                               elf_1.getName() + " has " + elf_1.getHealth() + " health left.\n");
        } catch(LowFirePowerException e)
        {
            System.out.println(dragon_1.getName() + " " + e.getMessage() + "\n");
        }

        // Elf tries to cast spell against dragon,
        // Catches LowManaException if the elf doesn't have enough mana.
        System.out.println(elf_1.getName() + " tries to cast a spell against " + dragon_1.getName() + "...");
        try
        {
            elf_1.castSpell(dragon_1);
            System.out.println(elf_1.getName() + " successfully casted a spell against " + dragon_1.getName() + ". " +
                               dragon_1.getName() + " has " + dragon_1.getHealth() + " health left.\n");

        } catch(LowManaException e)
        {
            System.out.println(elf_1.getName() + " " + e.getMessage() + "\n");
        }

        // Orc goes berserk against elf.
        // LowRageException is unchecked, so there is no need to try / catch.
        System.out.println(orc_1.getName() + " tries to go berserk against " + elf_1.getName() + "...");
        orc_1.berserk(elf_1);
        System.out.println(orc_1.getName() + " successfully berserked " + elf_1.getName() +
                           ". Orc's rage is now " + orc_1.getRage() + ", and " +
                           elf_1.getName() + " has " + elf_1.getHealth() + " health left.\n");

        System.out.println("All actions have been attempted!");
    }
}
