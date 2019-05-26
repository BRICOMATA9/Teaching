package tp4;

public class Exo3 {
    protected static boolean D1   = false;
    protected static boolean D2   = false;
    protected static int     turn = 1;

    public static void main( String[] args ) {
        Thread t1 = new Thread( new Peterson1() );
        Thread t2 = new Thread( new Peterson2() );

        t1.start();
        t2.start();

    }

}
