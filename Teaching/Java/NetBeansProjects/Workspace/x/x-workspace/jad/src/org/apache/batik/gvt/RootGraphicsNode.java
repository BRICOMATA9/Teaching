// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.gvt;

import java.util.LinkedList;
import java.util.List;
import org.apache.batik.gvt.event.GraphicsNodeChangeListener;

// Referenced classes of package org.apache.batik.gvt:
//            CompositeGraphicsNode

public class RootGraphicsNode extends CompositeGraphicsNode
{

    public RootGraphicsNode()
    {
        treeGraphicsNodeChangeListeners = null;
    }

    public RootGraphicsNode getRoot()
    {
        return this;
    }

    public List getTreeGraphicsNodeChangeListeners()
    {
        if(treeGraphicsNodeChangeListeners == null)
            treeGraphicsNodeChangeListeners = new LinkedList();
        return treeGraphicsNodeChangeListeners;
    }

    public void addTreeGraphicsNodeChangeListener(GraphicsNodeChangeListener graphicsnodechangelistener)
    {
        getTreeGraphicsNodeChangeListeners().add(graphicsnodechangelistener);
    }

    public void removeTreeGraphicsNodeChangeListener(GraphicsNodeChangeListener graphicsnodechangelistener)
    {
        getTreeGraphicsNodeChangeListeners().remove(graphicsnodechangelistener);
    }

    List treeGraphicsNodeChangeListeners;
}
