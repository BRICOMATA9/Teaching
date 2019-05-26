package tp3;

public class Consommateur extends Exercice3 implements Runnable {

    int id = 0;

    public Consommateur( int i ) {
        this.id = i;
    }

    @Override
    public void run() {
        while ( true ) {
            if ( flag ) {
                System.out.println( "Je suis le consommateur: " + this.id );
                System.out.println( "La variable i a pour valeur: " + i );

                flag = false;
                try {
                    Thread.sleep( 1 );
                } catch ( InterruptedException e ) {
                    e.printStackTrace();
                }
            }
        }
    }
}
