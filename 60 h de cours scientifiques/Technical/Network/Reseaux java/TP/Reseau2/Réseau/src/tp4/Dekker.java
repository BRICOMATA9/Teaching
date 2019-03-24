package tp4;

public class Dekker extends Exo2 implements Runnable {

    @Override
    public void run() {
        for ( int t = 0; t < 200000; t++ ) {
            System.out.println( "NC T!" );
            D1 = true; // je demande d'entree en SC
            while ( D2 ) { // Tanque S a demandé a entrer en SC
                if ( turn == 2 ) { // Si c'est le tour de S
                    D1 = false; // j'annule ma demande
                    while ( turn != 1 ) { // j'attend mon tour
                        try {
                            Thread.sleep( 10 );
                        } catch ( InterruptedException e ) {
                            e.printStackTrace();
                        }
                    }
                    D1 = true; // je relance ma demande
                }
            }
            i++;
            System.out.println( i );

            turn = 2;
            D1 = false;
        }

    }

}
