package tp5;

public class Baguette {
    protected int     id;
    protected boolean state;

    public Baguette( int id ) {
        this.id = id;
        state = true; // baguette libre
    }

    public synchronized void prendre() { // prendre la baguette
        while ( !this.state ) {
            try {
                wait();
            } catch ( InterruptedException e ) {
                e.printStackTrace();
            }
        }
        this.state = false;
    }

    public synchronized boolean essayerDePrendre() {
        if ( state ) {
            prendre();
            return true;
        }

        return false;
    }

    public synchronized void deposer() { // deposer la baguette
        this.state = true;
        notify();
    }

}
