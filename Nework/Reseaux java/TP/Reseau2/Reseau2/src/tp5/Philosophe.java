package tp5;

import java.util.concurrent.locks.Lock;

public class Philosophe implements Runnable {
    protected int  id;
    protected Lock baguetteGauche;
    protected Lock baguetteDroite;

    public Philosophe( int id, SharedLocks baguettes ) {
        this.id = id;
        this.baguetteGauche = baguettes.getLock( id );
        this.baguetteDroite = baguettes.getLock( id + 1 );
    }

    @Override
    public void run() {
        while ( true ) {

            System.out.println( "Philosophe " + id + " pense!" );
            baguetteGauche.lock();
            if ( baguetteDroite.tryLock() ) {
                try {
                    System.out.println( "Philosophe " + id + " mange!" );
                } finally {
                    baguetteGauche.unlock();
                    baguetteDroite.unlock();
                }
            } else {
                baguetteGauche.unlock();
            }
        }
    }
}
