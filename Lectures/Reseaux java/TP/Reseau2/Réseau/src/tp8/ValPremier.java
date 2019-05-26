package tp8;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ValPremier implements Callable<Long> {
    Long nombre;

    public boolean estPremier( long n ) {
        final long max = (long) Math.floor( Math.sqrt( n ) );
        for ( int i = 2; i <= max; i++ ) {
            if ( n % i == 0 )
                return false;
        }
        return true;
    }

    public ValPremier( Long n ) {
        this.nombre = n;
    }

    @Override
    public Long call() throws Exception {
        if ( estPremier( nombre ) )
            return nombre;
        else
            return 0L;
    }

    public static Long sommeLong( long n ) throws Exception {
        Long somme = 0L;
        for ( long i = 0; i <= n; i++ ) {
            somme += new ValPremier( i ).call();
        }
        return somme;
    }

    public static Long sommePremierConcur( int concur, long n ) throws InterruptedException, ExecutionException {
        ExecutorService pool = Executors.newFixedThreadPool( concur );
        Long somme = 0L;
        ArrayList<Future<Long>> futures = new ArrayList<>();
        for ( long i = 1; i < n; i++ ) {
            Future<Long> f = pool.submit( new ValPremier( i ) );
            futures.add( f );
        }
        for ( Future<Long> f : futures ) {
            somme += f.get();
        }
        // pool.shutdown();
        return somme;

    }

    public static void main( String[] args ) throws Exception {
        long d1 = System.nanoTime();
        System.out.println( sommeLong( 10000 ) );
        d1 = System.nanoTime() - d1;
        Long d2 = System.nanoTime();
        System.out.println( sommePremierConcur( 4, 10000 ) );
        d2 = System.nanoTime() - d2;
        System.out.println( d1 );
        System.out.println( d2 );
    }
}
