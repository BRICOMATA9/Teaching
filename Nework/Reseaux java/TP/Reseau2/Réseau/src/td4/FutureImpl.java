package td4;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class FutureImpl<V> implements Future<V> {
    V       v    = null;
    boolean bool = false;

    public boolean isDone() {
        return bool;
    }

    @Override
    public boolean cancel( boolean mayInterruptIfRunning ) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isCancelled() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public V get( long timeout, TimeUnit unit ) throws InterruptedException, ExecutionException, TimeoutException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public V get() throws InterruptedException, ExecutionException {
        synchronized ( this ) {
            if ( !bool )
                wait();
            return v;
        }
    }

    public synchronized void set( V v ) {
        this.v = v;
        bool = true;
        notifyAll();
    }
}
