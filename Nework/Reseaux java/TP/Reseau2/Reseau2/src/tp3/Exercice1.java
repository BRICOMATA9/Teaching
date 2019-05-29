package tp3;

public class Exercice1 implements Runnable {
    int i = 0;

    @Override
    public void run() {

        for ( i = 0; i < 100; i++ ) {
            System.out.println( i );
            try {
                Thread.sleep( 10 );
            } catch ( InterruptedException e ) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

    public static void main( String[] args ) {
        Thread t = new Thread( new Exercice1() );
        Thread t2 = new Thread( new Exercice1() );
        t.start();
        t2.start();
    }

}
