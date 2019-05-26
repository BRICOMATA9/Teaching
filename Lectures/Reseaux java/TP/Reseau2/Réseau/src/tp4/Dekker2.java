package tp4;

public class Dekker2 extends Exo2 implements Runnable {

    @Override
    public void run() {
        for ( int t = 0; t < 200000; t++ ) {
            System.out.println( "NC S!" );
            D2 = true;
            while ( D1 ) {
                if ( turn == 1 ) {
                    D2 = false;
                    while ( turn != 2 ) {
                        try {
                            Thread.sleep( 10 );
                        } catch ( InterruptedException e ) {
                            e.printStackTrace();
                        }
                    }
                    D2 = true;
                }
            }
            i++;
            System.out.println( i );
            turn = 1;
            D2 = false;
        }

    }

}
