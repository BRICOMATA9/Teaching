package tp5;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SharedLocks {
    public static final int LOCKS_NUMBER = 5;
    private Lock[]          locks;

    public SharedLocks() {
        this.locks = new Lock[LOCKS_NUMBER];
        for ( int i = 0; i < LOCKS_NUMBER; i++ ) {
            locks[i] = new ReentrantLock();
        }
    }

    public Lock getLock( int id ) {
        return locks[id % LOCKS_NUMBER];
    }
}
