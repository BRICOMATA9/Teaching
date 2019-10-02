// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.util;

import java.util.Iterator;
import java.util.NoSuchElementException;

// Referenced classes of package org.apache.batik.util:
//            DoublyLinkedList, HaltingThread

public class RunnableQueue
    implements Runnable
{
    protected static class LockableLink extends Link
    {

        public boolean isLocked()
        {
            return locked;
        }

        public synchronized void lock()
            throws InterruptedException
        {
            locked = true;
            notify();
            wait();
        }

        public synchronized void unlock()
            throws InterruptedException
        {
            while(!locked) 
                wait();
            notify();
        }

        protected boolean locked;

        public LockableLink(Runnable runnable)
        {
            Link(runnable);
        }
    }

    protected static class Link extends DoublyLinkedList.Node
    {

        public void unlock()
            throws InterruptedException
        {
        }

        public Runnable runnable;

        public Link(Runnable runnable1)
        {
            runnable = runnable1;
        }
    }

    public static class RunHandlerAdapter
        implements RunHandler
    {

        public void runnableStart(RunnableQueue runnablequeue, Runnable runnable)
        {
        }

        public void runnableInvoked(RunnableQueue runnablequeue, Runnable runnable)
        {
        }

        public void executionSuspended(RunnableQueue runnablequeue)
        {
        }

        public void executionResumed(RunnableQueue runnablequeue)
        {
        }

        public RunHandlerAdapter()
        {
        }
    }

    public static interface RunHandler
    {

        public abstract void runnableStart(RunnableQueue runnablequeue, Runnable runnable);

        public abstract void runnableInvoked(RunnableQueue runnablequeue, Runnable runnable);

        public abstract void executionSuspended(RunnableQueue runnablequeue);

        public abstract void executionResumed(RunnableQueue runnablequeue);
    }

    public static class RunnableQueueState
    {

        public String getValue()
        {
            return value;
        }

        public String toString()
        {
            return "[RunnableQueueState: " + value + "]";
        }

        final String value;

        private RunnableQueueState(String s)
        {
            value = s.intern();
        }

    }


    public RunnableQueue()
    {
        stateLock = new Object();
        list = new DoublyLinkedList();
        preemptCount = 0;
    }

    public static RunnableQueue createRunnableQueue()
    {
        RunnableQueue runnablequeue = new RunnableQueue();
        synchronized(runnablequeue)
        {
            HaltingThread haltingthread = new HaltingThread(runnablequeue, "RunnableQueue-" + threadCount++);
            haltingthread.setDaemon(true);
            haltingthread.start();
            while(runnablequeue.getThread() == null) 
                try
                {
                    runnablequeue.wait();
                }
                catch(InterruptedException interruptedexception) { }
        }
        return runnablequeue;
    }

    public void run()
    {
        synchronized(this)
        {
            runnableQueueThread = (HaltingThread)Thread.currentThread();
            notify();
        }
_L2:
        Link link;
        Runnable runnable;
label0:
        {
            if(HaltingThread.hasBeenHalted())
                break; /* Loop/switch isn't completed */
            synchronized(stateLock)
            {
                if(state == RUNNING)
                {
                    if(wasResumed)
                    {
                        wasResumed = false;
                        executionResumed();
                    }
                } else
                {
                    while(state != RUNNING) 
                    {
                        state = SUSPENDED;
                        stateLock.notifyAll();
                        executionSuspended();
                        try
                        {
                            stateLock.wait();
                        }
                        catch(InterruptedException interruptedexception1) { }
                    }
                    wasResumed = false;
                    executionResumed();
                }
            }
            InterruptedException interruptedexception2;
            synchronized(list)
            {
                if(state != SUSPENDING)
                    break label0;
            }
            continue; /* Loop/switch isn't completed */
        }
        link = (Link)list.pop();
        if(preemptCount != 0)
            preemptCount--;
        if(link != null)
            break MISSING_BLOCK_LABEL_205;
        try
        {
            list.wait();
        }
        // Misplaced declaration of an exception variable
        catch(InterruptedException interruptedexception2) { }
        doublylinkedlist;
        JVM INSTR monitorexit ;
        continue; /* Loop/switch isn't completed */
        runnable = link.runnable;
        doublylinkedlist;
        JVM INSTR monitorexit ;
        runnableStart(runnable);
        try
        {
            runnable.run();
        }
        catch(ThreadDeath threaddeath)
        {
            throw threaddeath;
        }
        catch(Throwable throwable)
        {
            throwable.printStackTrace();
        }
        link.unlock();
        runnableInvoked(runnable);
        if(true) goto _L2; else goto _L1
_L1:
        break MISSING_BLOCK_LABEL_305;
        InterruptedException interruptedexception;
        interruptedexception;
        if(true)
            break MISSING_BLOCK_LABEL_305;
        local;
        synchronized(this)
        {
            runnableQueueThread = null;
        }
        JVM INSTR ret 8;
    }

    public HaltingThread getThread()
    {
        return runnableQueueThread;
    }

    public void invokeLater(Runnable runnable)
    {
        if(runnableQueueThread == null)
            throw new IllegalStateException("RunnableQueue not started or has exited");
        synchronized(list)
        {
            list.push(new Link(runnable));
            list.notify();
        }
    }

    public void invokeAndWait(Runnable runnable)
        throws InterruptedException
    {
        if(runnableQueueThread == null)
            throw new IllegalStateException("RunnableQueue not started or has exited");
        if(runnableQueueThread == Thread.currentThread())
            throw new IllegalStateException("Cannot be called from the RunnableQueue thread");
        LockableLink lockablelink = new LockableLink(runnable);
        synchronized(list)
        {
            list.push(lockablelink);
            list.notify();
        }
        lockablelink.lock();
    }

    public void preemptLater(Runnable runnable)
    {
        if(runnableQueueThread == null)
            throw new IllegalStateException("RunnableQueue not started or has exited");
        synchronized(list)
        {
            list.add(preemptCount, new Link(runnable));
            preemptCount++;
            list.notify();
        }
    }

    public void preemptAndWait(Runnable runnable)
        throws InterruptedException
    {
        if(runnableQueueThread == null)
            throw new IllegalStateException("RunnableQueue not started or has exited");
        if(runnableQueueThread == Thread.currentThread())
            throw new IllegalStateException("Cannot be called from the RunnableQueue thread");
        LockableLink lockablelink = new LockableLink(runnable);
        synchronized(list)
        {
            list.add(preemptCount, lockablelink);
            preemptCount++;
            list.notify();
        }
        lockablelink.lock();
    }

    public RunnableQueueState getQueueState()
    {
        Object obj = stateLock;
        JVM INSTR monitorenter ;
        return state;
        Exception exception;
        exception;
        throw exception;
    }

    public void suspendExecution(boolean flag)
    {
label0:
        {
            if(runnableQueueThread == null)
                throw new IllegalStateException("RunnableQueue not started or has exited");
            synchronized(stateLock)
            {
                wasResumed = false;
                if(state != SUSPENDED)
                    break label0;
                stateLock.notifyAll();
            }
            return;
        }
        if(state == RUNNING)
        {
            state = SUSPENDING;
            synchronized(list)
            {
                list.notify();
            }
        }
        if(flag)
            while(state == SUSPENDING) 
                try
                {
                    stateLock.wait();
                }
                catch(InterruptedException interruptedexception) { }
        obj;
        JVM INSTR monitorexit ;
          goto _L1
        exception1;
        throw exception1;
_L1:
    }

    public void resumeExecution()
    {
        if(runnableQueueThread == null)
            throw new IllegalStateException("RunnableQueue not started or has exited");
        synchronized(stateLock)
        {
            wasResumed = true;
            if(state != RUNNING)
            {
                state = RUNNING;
                stateLock.notifyAll();
            }
        }
    }

    public Object getIteratorLock()
    {
        return list;
    }

    public Iterator iterator()
    {
        return new Iterator() {

            public boolean hasNext()
            {
                if(head == null)
                    return false;
                if(link == null)
                    return true;
                else
                    return link != head;
            }

            public Object next()
            {
                if(head == null || head == link)
                    throw new NoSuchElementException();
                if(link == null)
                {
                    link = (Link)head.getNext();
                    return head.runnable;
                } else
                {
                    Runnable runnable = link.runnable;
                    link = (Link)link.getNext();
                    return runnable;
                }
            }

            public void remove()
            {
                throw new UnsupportedOperationException();
            }

            Link head;
            Link link;

            
            {
                head = (Link)list.getHead();
            }
        };
    }

    public synchronized void setRunHandler(RunHandler runhandler)
    {
        runHandler = runhandler;
    }

    public synchronized RunHandler getRunHandler()
    {
        return runHandler;
    }

    protected synchronized void executionSuspended()
    {
        if(runHandler != null)
            runHandler.executionSuspended(this);
    }

    protected synchronized void executionResumed()
    {
        if(runHandler != null)
            runHandler.executionResumed(this);
    }

    protected synchronized void runnableStart(Runnable runnable)
    {
        if(runHandler != null)
            runHandler.runnableStart(this, runnable);
    }

    protected synchronized void runnableInvoked(Runnable runnable)
    {
        if(runHandler != null)
            runHandler.runnableInvoked(this, runnable);
    }

    public static final RunnableQueueState RUNNING = new RunnableQueueState("Running");
    public static final RunnableQueueState SUSPENDING = new RunnableQueueState("Suspending");
    public static final RunnableQueueState SUSPENDED = new RunnableQueueState("Suspended");
    protected RunnableQueueState state;
    protected Object stateLock;
    protected boolean wasResumed;
    protected DoublyLinkedList list;
    protected int preemptCount;
    protected RunHandler runHandler;
    protected HaltingThread runnableQueueThread;
    private static int threadCount;

}
