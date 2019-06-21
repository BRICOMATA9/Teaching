// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.util;

import java.lang.ref.SoftReference;
import java.util.HashMap;

// Referenced classes of package org.apache.batik.util:
//            CleanerThread

public class SoftReferenceCache
{
    class SoftRefKey extends CleanerThread.SoftReferenceCleared
    {

        public void cleared()
        {
            SoftReferenceCache softreferencecache = SoftReferenceCache.this;
            if(softreferencecache == null)
                return;
            synchronized(softreferencecache)
            {
                Object obj = softreferencecache.map.remove(key);
                if(this == obj)
                    softreferencecache.notifyAll();
                else
                    softreferencecache.map.put(key, obj);
            }
        }

        Object key;

        public SoftRefKey(Object obj, Object obj1)
        {
            SoftReferenceCleared(obj);
            key = obj1;
        }
    }


    protected SoftReferenceCache()
    {
        map = new HashMap();
    }

    public synchronized void flush()
    {
        map.clear();
        notifyAll();
    }

    protected final synchronized boolean isPresentImpl(Object obj)
    {
        if(!map.containsKey(obj))
            return false;
        Object obj1 = map.get(obj);
        if(obj1 == null)
            return true;
        SoftReference softreference = (SoftReference)obj1;
        obj1 = softreference.get();
        if(obj1 != null)
        {
            return true;
        } else
        {
            clearImpl(obj);
            return false;
        }
    }

    protected final synchronized boolean isDoneImpl(Object obj)
    {
        Object obj1 = map.get(obj);
        if(obj1 == null)
            return false;
        SoftReference softreference = (SoftReference)obj1;
        obj1 = softreference.get();
        if(obj1 != null)
        {
            return true;
        } else
        {
            clearImpl(obj);
            return false;
        }
    }

    protected final synchronized Object requestImpl(Object obj)
    {
        if(map.containsKey(obj))
        {
            Object obj1 = map.get(obj);
            do
            {
                if(obj1 != null)
                    break;
                try
                {
                    wait();
                }
                catch(InterruptedException interruptedexception) { }
                if(!map.containsKey(obj))
                    break;
                obj1 = map.get(obj);
            } while(true);
            if(obj1 != null)
            {
                SoftReference softreference = (SoftReference)obj1;
                obj1 = softreference.get();
                if(obj1 != null)
                    return obj1;
            }
        }
        map.put(obj, null);
        return null;
    }

    protected final synchronized void clearImpl(Object obj)
    {
        map.remove(obj);
        notifyAll();
    }

    protected final synchronized void putImpl(Object obj, Object obj1)
    {
        if(map.containsKey(obj))
        {
            SoftRefKey softrefkey = new SoftRefKey(obj1, obj);
            map.put(obj, softrefkey);
            notifyAll();
        }
    }

    HashMap map;
}
