package tp4;

public class Peterson1 extends Exo3 implements Runnable {

    @Override
    public void run() {
        while ( true ) {
            System.out.println( "NC T" );
            D1 = true;
            turn = 2;
            while ( D2 && turn != 1 ) {
                try {
                    Thread.sleep( 10 );
                } catch ( InterruptedException e ) {
                    e.printStackTrace();
                }
            }
            System.out.println( "SC T" );
            D1 = false;
        }

    }

}
