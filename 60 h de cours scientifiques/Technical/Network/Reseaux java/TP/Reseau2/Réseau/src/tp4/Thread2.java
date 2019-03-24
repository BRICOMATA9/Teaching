package tp4;

public class Thread2 extends Exo1 implements Runnable {

    @Override
    public void run() {
        while ( true ) {
            System.out.println( "NC S!" );
            while ( turn != 2 ) {
                try {
                    Thread.sleep( 10 );
                } catch ( InterruptedException e ) {
                    e.printStackTrace();
                }
            }
            System.out.println( "SC S" );

            turn = 1;
        }

    }
}
