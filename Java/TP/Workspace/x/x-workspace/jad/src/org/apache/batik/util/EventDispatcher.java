// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.util;

import java.awt.EventQueue;
import java.lang.reflect.InvocationTargetException;

public class EventDispatcher
{
    public static interface Dispatcher
    {

        public abstract void dispatch(Object obj, Object obj1);
    }


    public EventDispatcher()
    {
    }

    public static void fireEvent(final Dispatcher dispatcher, final java.util.List listeners, final Object evt, final boolean useEventQueue)
    {
        Object aobj[];
        Throwable throwable1;
        int i;
        if(useEventQueue && !EventQueue.isDispatchThread())
        {
            Runnable runnable = new Runnable() {

                public void run()
                {
                    EventDispatcher.fireEvent(dispatcher, listeners, evt, useEventQueue);
                }

            };
            try
            {
                EventQueue.invokeAndWait(runnable);
            }
            catch(InvocationTargetException invocationtargetexception)
            {
                invocationtargetexception.printStackTrace();
            }
            catch(InterruptedException interruptedexception) { }
            catch(ThreadDeath threaddeath)
            {
                throw threaddeath;
            }
            catch(Throwable throwable)
            {
                throwable.printStackTrace();
            }
            return;
        }
        aobj = null;
        throwable1 = null;
        i = 10;
_L2:
        if(--i == 0)
            break; /* Loop/switch isn't completed */
        try
        {
label0:
            {
                synchronized(listeners)
                {
                    if(listeners.size() != 0)
                        break label0;
                }
                return;
            }
        }
        catch(Throwable throwable2)
        {
            throwable1 = throwable2;
        }
        continue; /* Loop/switch isn't completed */
        aobj = listeners.toArray();
        list;
        JVM INSTR monitorexit ;
        break; /* Loop/switch isn't completed */
        exception;
        throw exception;
        if(true) goto _L2; else goto _L1
_L1:
        if(aobj == null)
        {
            if(throwable1 != null)
                throwable1.printStackTrace();
            return;
        } else
        {
            dispatchEvent(dispatcher, aobj, evt);
            return;
        }
    }

    protected static void dispatchEvent(Dispatcher dispatcher, Object aobj[], Object obj)
    {
        ThreadDeath threaddeath = null;
        int i = 0;
_L5:
        if(i >= aobj.length)
            break; /* Loop/switch isn't completed */
        Object aobj1[] = aobj;
        JVM INSTR monitorenter ;
        Object obj2 = aobj[i];
        if(obj2 != null) goto _L2; else goto _L1
_L2:
        aobj[i] = null;
        aobj1;
        JVM INSTR monitorexit ;
          goto _L3
        Exception exception;
        exception;
        throw exception;
_L3:
        dispatcher.dispatch(obj2, obj);
          goto _L1
        Object obj3;
        obj3;
        threaddeath = ((ThreadDeath) (obj3));
          goto _L1
        obj3;
        ((Throwable) (obj3)).printStackTrace();
_L1:
        i++;
        if(true) goto _L5; else goto _L4
        Object obj1;
        obj1;
        threaddeath = ((ThreadDeath) (obj1));
          goto _L4
        obj1;
        if(aobj[aobj.length - 1] != null)
            dispatchEvent(dispatcher, aobj, obj);
        ((Throwable) (obj1)).printStackTrace();
_L4:
        if(threaddeath != null)
            throw threaddeath;
        else
            return;
    }
}
