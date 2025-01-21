public class main
{
    public static void main(final String[] args)
    {

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
