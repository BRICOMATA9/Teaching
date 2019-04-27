package tp3;

public class Exercice3 {
    public static boolean flag = false;
    public static int     i    = 0;

    public static void main( String[] args ) {
        Thread p = new Thread( new Producteur() );

        Thread c = new Thread( new Consommateur( 0 ) );
        Thread c1 = new Thread( new Consommateur( 1 ) );
        Thread c2 = new Thread( new Consommateur( 2 ) );

        p.start();
        c.start();
        c1.start();
        c2.start();
    }

}
