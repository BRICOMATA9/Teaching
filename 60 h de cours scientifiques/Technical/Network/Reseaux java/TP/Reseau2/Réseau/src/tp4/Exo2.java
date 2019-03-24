package tp4;

public class Exo2 {
    protected static volatile boolean D1   = false; // volatile: interdire
                                                    // l'optimisation sur cette
                                                    // variable
    protected static volatile boolean D2   = false;
    protected static volatile int     turn = 1;
    public static int                 i    = 0;

    public static void main( String[] args ) throws InterruptedException {

        Thread t1 = new Thread( new Dekker() );
        Thread t2 = new Thread( new Dekker2() );

        t1.start();
        t2.start();
    }

}
