// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.util;


public class HaltingThread extends Thread
{

    public HaltingThread()
    {
        beenHalted = false;
    }

    public HaltingThread(Runnable runnable)
    {
        Thread(runnable);
        beenHalted = false;
    }

    public HaltingThread(String s)
    {
        Thread(s);
        beenHalted = false;
    }

    public HaltingThread(Runnable runnable, String s)
    {
        Thread(runnable, s);
        beenHalted = false;
    }

    public boolean isHalted()
    {
        HaltingThread haltingthread = this;
        JVM INSTR monitorenter ;
        return beenHalted;
        Exception exception;
        exception;
        throw exception;
    }

    public void halt()
    {
        synchronized(this)
        {
            beenHalted = true;
        }
    }

    public void clearHalted()
    {
        synchronized(this)
        {
            beenHalted = false;
        }
    }

    public static void haltThread()
    {
        haltThread(Thread.currentThread());
    }

    public static void haltThread(Thread thread)
    {
        if(thread instanceof HaltingThread)
            ((HaltingThread)thread).halt();
    }

    public static boolean hasBeenHalted()
    {
        return hasBeenHalted(Thread.currentThread());
    }

    public static boolean hasBeenHalted(Thread thread)
    {
        if(thread instanceof HaltingThread)
            return ((HaltingThread)thread).isHalted();
        else
            return false;
    }

    protected boolean beenHalted;
}
