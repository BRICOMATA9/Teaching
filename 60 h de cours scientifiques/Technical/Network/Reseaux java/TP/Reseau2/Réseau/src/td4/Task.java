package td4;

import java.util.concurrent.Callable;

class Task<V> implements Runnable {
    Callable<V>   callable;
    FutureImpl<V> future;

    public Task( Callable<V> call ) throws InterruptedException, Exception {
        callable = call;
        future = new FutureImpl<>();

    }

    @Override
    public void run() {

    }

}
