// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.bridge;


// Referenced classes of package org.apache.batik.bridge:
//            UpdateManagerEvent

public interface UpdateManagerListener
{

    public abstract void managerStarted(UpdateManagerEvent updatemanagerevent);

    public abstract void managerSuspended(UpdateManagerEvent updatemanagerevent);

    public abstract void managerResumed(UpdateManagerEvent updatemanagerevent);

    public abstract void managerStopped(UpdateManagerEvent updatemanagerevent);

    public abstract void updateStarted(UpdateManagerEvent updatemanagerevent);

    public abstract void updateCompleted(UpdateManagerEvent updatemanagerevent);

    public abstract void updateFailed(UpdateManagerEvent updatemanagerevent);
}
