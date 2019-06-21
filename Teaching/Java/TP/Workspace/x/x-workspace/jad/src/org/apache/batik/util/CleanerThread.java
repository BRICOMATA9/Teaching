// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.util;

import java.lang.ref.*;

public class CleanerThread extends Thread
{
    public static abstract class PhantomReferenceCleared extends PhantomReference
        implements ReferenceCleared
    {

        public PhantomReferenceCleared(Object obj)
        {
            PhantomReference(obj, CleanerThread.getReferenceQueue());
        }
    }

    public static abstract class WeakReferenceCleared extends WeakReference
        implements ReferenceCleared
    {

        public WeakReferenceCleared(Object obj)
        {
            WeakReference(obj, CleanerThread.getReferenceQueue());
        }
    }

    public static abstract class SoftReferenceCleared extends SoftReference
        implements ReferenceCleared
    {

        public SoftReferenceCleared(Object obj)
        {
            SoftReference(obj, CleanerThread.getReferenceQueue());
        }
    }

    public static interface ReferenceCleared
    {

        public abstract void cleared();
    }


    public static ReferenceQueue getReferenceQueue()
    {
        if(queue != null)
        {
            return queue;
        } else
        {
            queue = new ReferenceQueue();
            thread = new CleanerThread();
            return queue;
        }
    }

    protected CleanerThread()
    {
        setDaemon(true);
        start();
    }

    public void run()
    {
        do
        {
            java.lang.ref.Reference reference;
            try
            {
                reference = queue.remove();
            }
            catch(InterruptedException interruptedexception)
            {
                continue;
            }
            try
            {
                if(reference instanceof ReferenceCleared)
                {
                    ReferenceCleared referencecleared = (ReferenceCleared)reference;
                    referencecleared.cleared();
                }
            }
            catch(ThreadDeath threaddeath)
            {
                throw threaddeath;
            }
            catch(Throwable throwable)
            {
                throwable.printStackTrace();
            }
        } while(true);
    }

    static ReferenceQueue queue = null;
    static CleanerThread thread = null;

}
