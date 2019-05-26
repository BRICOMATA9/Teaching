package tp4;

public class Peterson2 extends Exo3 implements Runnable {

    @Override
    public void run() {
        while ( true ) {
            System.out.println( "NC S" );
            D2 = true;
            turn = 1;
            while ( D1 && turn != 2 ) {
                try {
                    Thread.sleep( 10 );
                } catch ( InterruptedException e ) {
                    e.printStackTrace();
                }
            }
            System.out.println( "SC S" );
            D2 = false;
        }

    }

}
