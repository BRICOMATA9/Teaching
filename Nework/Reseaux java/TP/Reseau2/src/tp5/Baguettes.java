package tp5;

public class Baguettes {
    public static final int LOCKS_NUMBER = 5;
    private Baguette[]      baguettes;

    public Baguettes() {
        this.baguettes = new Baguette[LOCKS_NUMBER];
        for ( int i = 0; i < LOCKS_NUMBER; i++ ) {
            baguettes[i] = new Baguette( i );
        }
    }

    public Baguette getBaguette( int id ) {
        return baguettes[id % LOCKS_NUMBER];
    }

}
