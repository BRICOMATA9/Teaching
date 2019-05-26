package tp5;

public class ImpPhilos {

    public static void main( String[] args ) {

        SharedLocks baguettes = new SharedLocks();

        Thread p0 = new Thread( new Philosophe( 0, baguettes ) );
        Thread p1 = new Thread( new Philosophe( 1, baguettes ) );
        Thread p2 = new Thread( new Philosophe( 2, baguettes ) );
        Thread p3 = new Thread( new Philosophe( 3, baguettes ) );
        Thread p4 = new Thread( new Philosophe( 4, baguettes ) );

        p0.start();
        p1.start();
        p2.start();
        p3.start();
        p4.start();
    }

}
