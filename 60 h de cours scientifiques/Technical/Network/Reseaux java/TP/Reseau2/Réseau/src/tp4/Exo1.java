package tp4;

public class Exo1 {
    public static int turn = 1;

    public static void main( String[] args ) {
        Thread t1 = new Thread( new Thread1() );
        Thread t2 = new Thread( new Thread2() );

        t1.start();
        t2.start();
    }

}
