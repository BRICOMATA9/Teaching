package tp3;

public class Thread1 extends Exercice4 implements Runnable {

    @Override
    public void run() {
        while ( true ) {
            while ( !x1 ) {
                try {
                    Thread.sleep( 1 );
                } catch ( InterruptedException e ) {
                    e.printStackTrace();
                }
            }
            x1 = false;
            while ( !x2 ) {
                try {
                    Thread.sleep( 1 );
                } catch ( InterruptedException e ) {
                    e.printStackTrace();
                }
            }
            x2 = false;

            System.out.println( "Moi le Thread 1 ai fini mon travail!" );
            x1 = true;
            x2 = true;
        }
    }

}
