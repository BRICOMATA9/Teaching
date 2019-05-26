package tp5;

public class ImpPhilos2 {

    public static void main( String[] args ) {

        Baguettes baguettes = new Baguettes();

        Thread p0 = new Thread( new Philosophe2( 0, baguettes ) );
        Thread p1 = new Thread( new Philosophe2( 1, baguettes ) );
        Thread p2 = new Thread( new Philosophe2( 2, baguettes ) );
        Thread p3 = new Thread( new Philosophe2( 3, baguettes ) );
        Thread p4 = new Thread( new Philosophe2( 4, baguettes ) );

        p0.start();
        p1.start();
        p2.start();
        p3.start();
        p4.start();
    }

}
