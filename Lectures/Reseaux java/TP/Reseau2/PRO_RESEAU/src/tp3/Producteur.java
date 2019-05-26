package tp3;

public class Producteur extends Exercice3 implements Runnable {

    @Override
    public void run() {
        while ( true ) {
            if ( !flag ) {
                i++;
                flag = true;
            }
        }
    }
}
