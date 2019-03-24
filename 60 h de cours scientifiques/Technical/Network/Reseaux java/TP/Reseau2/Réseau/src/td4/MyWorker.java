package td4;

import java.util.concurrent.BlockingQueue;

public class MyWorker implements Runnable {
    BlockingQueue<Runnable> works;

    public MyWorker( BlockingQueue<Runnable> works ) {
        this.works = works;
    }

    @Override
    public void run() {
        while ( true ) {
            try {
                works.take().run();
            } catch ( InterruptedException e ) {
                e.printStackTrace();
            }
        }

    }
}
