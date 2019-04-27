package tp5;

public class Philosophe2 implements Runnable {

    protected int      id;
    protected Baguette gauche;
    protected Baguette droite;

    public Philosophe2( int id, Baguettes baguettes ) {
        this.id = id;
        this.gauche = baguettes.getBaguette( id );
        this.droite = baguettes.getBaguette( id + 1 );
    }

    @Override
    public void run() {
        while ( true ) {

            System.out.println( "Philosophe " + id + " pense!" );
            gauche.lock();
            try {
                Thread.sleep( 10 );
            } catch ( InterruptedException e ) {
                e.printStackTrace();
            }
            if ( droite.tryLock() ) {

                System.out.println( "Philosophe " + id + " mange!" );

                gauche.unlock();
                droite.unlock();
            } else {
                gauche.unlock();
            }
        }
    }
}
