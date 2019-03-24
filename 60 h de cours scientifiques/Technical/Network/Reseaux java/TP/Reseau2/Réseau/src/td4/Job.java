package td4;

public class Job implements Runnable {
    int id;

    public Job( int i ) {
        this.id = i;
    }

    @Override
    public void run() {

        System.out.println( "Job" + id + " Debut!" );
        try {
            Thread.sleep( 100 );
        } catch ( InterruptedException e ) {
            e.printStackTrace();
        }
        System.out.println( "Job" + id + " Fin!" );
    }

}
