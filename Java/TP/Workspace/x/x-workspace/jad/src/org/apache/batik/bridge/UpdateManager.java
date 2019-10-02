// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.bridge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.apache.batik.gvt.GraphicsNode;
import org.apache.batik.gvt.RootGraphicsNode;
import org.apache.batik.gvt.UpdateTracker;
import org.apache.batik.gvt.renderer.ImageRenderer;
import org.apache.batik.util.EventDispatcher;
import org.apache.batik.util.HaltingThread;
import org.apache.batik.util.RunnableQueue;
import org.w3c.dom.Document;
import org.w3c.dom.events.DocumentEvent;
import org.w3c.dom.events.Event;
import org.w3c.dom.events.EventTarget;

// Referenced classes of package org.apache.batik.bridge:
//            BridgeContext, ScriptingEnvironment, RepaintManager, UpdateManagerEvent, 
//            NoRepaintRunnable, UpdateManagerListener

public class UpdateManager
{
    protected class UpdateManagerRunHander extends org.apache.batik.util.RunnableQueue.RunHandlerAdapter
    {

        public void runnableStart(RunnableQueue runnablequeue, Runnable runnable)
        {
            if(running && !(runnable instanceof NoRepaintRunnable) && outOfDateTime == 0L)
                outOfDateTime = System.currentTimeMillis();
        }

        public void runnableInvoked(RunnableQueue runnablequeue, Runnable runnable)
        {
            if(running && !(runnable instanceof NoRepaintRunnable))
                repaint();
        }

        public void executionSuspended(RunnableQueue runnablequeue)
        {
            synchronized(UpdateManager.this)
            {
                if(suspendCalled)
                {
                    running = false;
                    UpdateManagerEvent updatemanagerevent = new UpdateManagerEvent(this, null, null);
                    fireEvent(UpdateManager.suspendedDispatcher, updatemanagerevent);
                }
            }
        }

        public void executionResumed(RunnableQueue runnablequeue)
        {
            synchronized(UpdateManager.this)
            {
                if(suspendCalled && !running)
                {
                    running = true;
                    suspendCalled = false;
                    UpdateManagerEvent updatemanagerevent = new UpdateManagerEvent(this, null, null);
                    fireEvent(UpdateManager.resumedDispatcher, updatemanagerevent);
                }
            }
        }

        protected UpdateManagerRunHander()
        {
        }
    }


    public UpdateManager(BridgeContext bridgecontext, GraphicsNode graphicsnode, Document document1)
    {
        listeners = Collections.synchronizedList(new LinkedList());
        outOfDateTime = 0L;
        bridgeContext = bridgecontext;
        bridgeContext.setUpdateManager(this);
        document = document1;
        updateRunnableQueue = RunnableQueue.createRunnableQueue();
        runHandler = createRunHandler();
        updateRunnableQueue.setRunHandler(runHandler);
        graphicsNode = graphicsnode;
        scriptingEnvironment = new ScriptingEnvironment(bridgecontext);
    }

    public synchronized void dispatchSVGLoadEvent()
        throws InterruptedException
    {
        scriptingEnvironment.loadScripts();
        scriptingEnvironment.dispatchSVGLoadEvent();
    }

    public void dispatchSVGZoomEvent()
        throws InterruptedException
    {
        scriptingEnvironment.dispatchSVGZoomEvent();
    }

    public void dispatchSVGScrollEvent()
        throws InterruptedException
    {
        scriptingEnvironment.dispatchSVGScrollEvent();
    }

    public void dispatchSVGResizeEvent()
        throws InterruptedException
    {
        scriptingEnvironment.dispatchSVGResizeEvent();
    }

    public void manageUpdates(final ImageRenderer r)
    {
        updateRunnableQueue.preemptLater(new Runnable() {

            public void run()
            {
                synchronized(UpdateManager.this)
                {
                    running = true;
                    updateTracker = new UpdateTracker();
                    RootGraphicsNode rootgraphicsnode = graphicsNode.getRoot();
                    if(rootgraphicsnode != null)
                        rootgraphicsnode.addTreeGraphicsNodeChangeListener(updateTracker);
                    repaintManager = new RepaintManager(r);
                    UpdateManagerEvent updatemanagerevent = new UpdateManagerEvent(UpdateManager.this, null, null);
                    fireEvent(UpdateManager.startedDispatcher, updatemanagerevent);
                    started = true;
                }
            }

        });
        resume();
    }

    public BridgeContext getBridgeContext()
    {
        return bridgeContext;
    }

    public RunnableQueue getUpdateRunnableQueue()
    {
        return updateRunnableQueue;
    }

    public RepaintManager getRepaintManager()
    {
        return repaintManager;
    }

    public UpdateTracker getUpdateTracker()
    {
        return updateTracker;
    }

    public Document getDocument()
    {
        return document;
    }

    public ScriptingEnvironment getScriptingEnvironment()
    {
        return scriptingEnvironment;
    }

    public synchronized boolean isRunning()
    {
        return running;
    }

    public synchronized void suspend()
    {
        if(updateRunnableQueue.getQueueState() == RunnableQueue.RUNNING)
            updateRunnableQueue.suspendExecution(false);
        suspendCalled = true;
    }

    public synchronized void resume()
    {
        if(updateRunnableQueue.getQueueState() != RunnableQueue.RUNNING)
            updateRunnableQueue.resumeExecution();
    }

    public synchronized void interrupt()
    {
        if(updateRunnableQueue.getThread() == null)
        {
            return;
        } else
        {
            updateRunnableQueue.preemptLater(new Runnable() {

                public void run()
                {
                    synchronized(UpdateManager.this)
                    {
                        if(started)
                        {
                            dispatchSVGUnLoadEvent();
                        } else
                        {
                            running = false;
                            scriptingEnvironment.interrupt();
                            updateRunnableQueue.getThread().halt();
                        }
                    }
                }

            });
            resume();
            return;
        }
    }

    public void dispatchSVGUnLoadEvent()
    {
        if(!started)
        {
            throw new IllegalStateException("UpdateManager not started.");
        } else
        {
            updateRunnableQueue.preemptLater(new Runnable() {

                public void run()
                {
                    synchronized(UpdateManager.this)
                    {
                        Event event = ((DocumentEvent)document).createEvent("SVGEvents");
                        event.initEvent("SVGUnload", false, false);
                        ((EventTarget)document.getDocumentElement()).dispatchEvent(event);
                        running = false;
                        scriptingEnvironment.interrupt();
                        updateRunnableQueue.getThread().halt();
                        bridgeContext.dispose();
                        UpdateManagerEvent updatemanagerevent = new UpdateManagerEvent(UpdateManager.this, null, null);
                        fireEvent(UpdateManager.stoppedDispatcher, updatemanagerevent);
                    }
                }

            });
            resume();
            return;
        }
    }

    public void updateRendering(java.awt.geom.AffineTransform affinetransform, boolean flag, java.awt.Shape shape, int i, int j)
    {
        repaintManager.setupRenderer(affinetransform, flag, shape, i, j);
        ArrayList arraylist = new ArrayList(1);
        arraylist.add(shape);
        updateRendering(((List) (arraylist)), false);
    }

    public void updateRendering(java.awt.geom.AffineTransform affinetransform, boolean flag, boolean flag1, java.awt.Shape shape, int i, int j)
    {
        repaintManager.setupRenderer(affinetransform, flag, shape, i, j);
        ArrayList arraylist = new ArrayList(1);
        arraylist.add(shape);
        updateRendering(((List) (arraylist)), flag1);
    }

    protected void updateRendering(List list, boolean flag)
    {
        try
        {
            UpdateManagerEvent updatemanagerevent = new UpdateManagerEvent(this, repaintManager.getOffScreen(), null);
            fireEvent(updateStartedDispatcher, updatemanagerevent);
            java.util.Collection collection = repaintManager.updateRendering(list);
            ArrayList arraylist = new ArrayList(collection);
            updatemanagerevent = new UpdateManagerEvent(this, repaintManager.getOffScreen(), arraylist, flag);
            fireEvent(updateCompletedDispatcher, updatemanagerevent);
        }
        catch(ThreadDeath threaddeath)
        {
            UpdateManagerEvent updatemanagerevent1 = new UpdateManagerEvent(this, null, null);
            fireEvent(updateFailedDispatcher, updatemanagerevent1);
            throw threaddeath;
        }
        catch(Throwable throwable)
        {
            UpdateManagerEvent updatemanagerevent2 = new UpdateManagerEvent(this, null, null);
            fireEvent(updateFailedDispatcher, updatemanagerevent2);
        }
    }

    protected void repaint()
    {
label0:
        {
            if(!updateTracker.hasChanged())
                return;
            long l = System.currentTimeMillis();
            if(l - outOfDateTime >= MIN_REPAINT_TIME)
                break MISSING_BLOCK_LABEL_85;
            synchronized(updateRunnableQueue.getIteratorLock())
            {
                Iterator iterator = updateRunnableQueue.iterator();
                do
                    if(!iterator.hasNext())
                        break label0;
                while(iterator.next() instanceof NoRepaintRunnable);
            }
            return;
        }
        obj;
        JVM INSTR monitorexit ;
        break MISSING_BLOCK_LABEL_85;
        exception;
        throw exception;
        List list = updateTracker.getDirtyAreas();
        updateTracker.clear();
        if(list != null)
            updateRendering(list, false);
        outOfDateTime = 0L;
        return;
    }

    public void addUpdateManagerListener(UpdateManagerListener updatemanagerlistener)
    {
        listeners.add(updatemanagerlistener);
    }

    public void removeUpdateManagerListener(UpdateManagerListener updatemanagerlistener)
    {
        listeners.remove(updatemanagerlistener);
    }

    protected void fireEvent(org.apache.batik.util.EventDispatcher.Dispatcher dispatcher, Object obj)
    {
        EventDispatcher.fireEvent(dispatcher, listeners, obj, false);
    }

    protected org.apache.batik.util.RunnableQueue.RunHandler createRunHandler()
    {
        return new UpdateManagerRunHander();
    }

    static final long MIN_REPAINT_TIME;
    protected BridgeContext bridgeContext;
    protected Document document;
    protected RunnableQueue updateRunnableQueue;
    protected org.apache.batik.util.RunnableQueue.RunHandler runHandler;
    protected boolean running;
    protected boolean suspendCalled;
    protected List listeners;
    protected ScriptingEnvironment scriptingEnvironment;
    protected RepaintManager repaintManager;
    protected UpdateTracker updateTracker;
    protected GraphicsNode graphicsNode;
    protected boolean started;
    long outOfDateTime;
    static org.apache.batik.util.EventDispatcher.Dispatcher startedDispatcher = new org.apache.batik.util.EventDispatcher.Dispatcher() {

        public void dispatch(Object obj, Object obj1)
        {
            ((UpdateManagerListener)obj).managerStarted((UpdateManagerEvent)obj1);
        }

    };
    static org.apache.batik.util.EventDispatcher.Dispatcher stoppedDispatcher = new org.apache.batik.util.EventDispatcher.Dispatcher() {

        public void dispatch(Object obj, Object obj1)
        {
            ((UpdateManagerListener)obj).managerStopped((UpdateManagerEvent)obj1);
        }

    };
    static org.apache.batik.util.EventDispatcher.Dispatcher suspendedDispatcher = new org.apache.batik.util.EventDispatcher.Dispatcher() {

        public void dispatch(Object obj, Object obj1)
        {
            ((UpdateManagerListener)obj).managerSuspended((UpdateManagerEvent)obj1);
        }

    };
    static org.apache.batik.util.EventDispatcher.Dispatcher resumedDispatcher = new org.apache.batik.util.EventDispatcher.Dispatcher() {

        public void dispatch(Object obj, Object obj1)
        {
            ((UpdateManagerListener)obj).managerResumed((UpdateManagerEvent)obj1);
        }

    };
    static org.apache.batik.util.EventDispatcher.Dispatcher updateStartedDispatcher = new org.apache.batik.util.EventDispatcher.Dispatcher() {

        public void dispatch(Object obj, Object obj1)
        {
            ((UpdateManagerListener)obj).updateStarted((UpdateManagerEvent)obj1);
        }

    };
    static org.apache.batik.util.EventDispatcher.Dispatcher updateCompletedDispatcher = new org.apache.batik.util.EventDispatcher.Dispatcher() {

        public void dispatch(Object obj, Object obj1)
        {
            ((UpdateManagerListener)obj).updateCompleted((UpdateManagerEvent)obj1);
        }

    };
    static org.apache.batik.util.EventDispatcher.Dispatcher updateFailedDispatcher = new org.apache.batik.util.EventDispatcher.Dispatcher() {

        public void dispatch(Object obj, Object obj1)
        {
            ((UpdateManagerListener)obj).updateFailed((UpdateManagerEvent)obj1);
        }

    };

    static 
    {
label0:
        {
            long l = 20L;
            try
            {
                String s = System.getProperty("org.apache.batik.min_repaint_time", "20");
                l = Long.parseLong(s);
            }
            catch(SecurityException securityexception)
            {
                MIN_REPAINT_TIME = l;
                break label0;
            }
            catch(NumberFormatException numberformatexception)
            {
                MIN_REPAINT_TIME = l;
                break label0;
            }
            finally
            {
                MIN_REPAINT_TIME = l;
                throw exception;
            }
            MIN_REPAINT_TIME = l;
            break label0;
        }
    }
}
