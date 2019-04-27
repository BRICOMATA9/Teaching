package tp3;

public class Exercice4 {
    protected static boolean x1 = true;
    protected static boolean x2 = true;

    public static void main( String[] args ) {
        Thread t1 = new Thread( new Thread1() );
        Thread t2 = new Thread( new Thread2() );

        t1.start();
        t2.start();
    }
}
