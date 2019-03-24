package tp3;

public class Exercice2 implements Runnable {

    static int i = 0;

    public void run() {
        for ( int t = 0; t < 100000; t++ ) {
            i++;
            System.out.println( i );

        }

    }

    public static void main( String[] args ) {
        Thread t = new Thread( new Exercice2() );
        Thread t2 = new Thread( new Exercice2() );
        t.start();
        t2.start();
    }

}
