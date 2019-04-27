package tp3;

public class Thread2 extends Exercice4 implements Runnable {

    @Override
    public void run() {
        while ( true ) {
            while ( x2 ) {
                x2 = false;
                while ( x1 )
                    x1 = false;
            }
            System.out.println( "Moi le Thread 2 ai fini mon travail!" );

        }
    }

}
