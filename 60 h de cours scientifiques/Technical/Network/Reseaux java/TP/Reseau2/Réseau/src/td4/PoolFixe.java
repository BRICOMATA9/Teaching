package td4;

import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;

public class PoolFixe implements Executor {
    ArrayList<Thread>       threads;
    BlockingQueue<Runnable> works = new LinkedBlockingQueue<>();

    public PoolFixe( int nombre ) {
        this.threads = new ArrayList<>();
        for ( int i = 0; i < nombre; i++ ) {
            Thread t = new Thread( new MyWorker( works ) );
            t.start();
            threads.add( t );
        }

    }

    @Override
    public void execute( Runnable command ) {
        works.add( command );
    }

    public static void main( String[] args ) {
        PoolFixe pool = new PoolFixe( 5 );
        for ( int i = 0; i < 10; i++ ) {
            pool.execute( new Job( i ) );
        }

        MyWorker worker = new MyWorker( pool.works );
        worker.run();
    }

    public <T> Future<T> submit( Callable<T> c ) {
        return null;
    }

}
