package tp4;

public class Thread1 extends Exo1 implements Runnable {
    int i = 0;

    @Override
    public void run() {
        while ( true ) {
            System.out.println( "NC T!" );
            while ( i != 0 ) {
            }
            while ( turn != 1 ) {
                try {
                    Thread.sleep( 10 );
                } catch ( InterruptedException e ) {
                    e.printStackTrace();
                }
            }
            System.out.println( "SC T" );
            i++;
            turn = 2;
        }

    }

}
