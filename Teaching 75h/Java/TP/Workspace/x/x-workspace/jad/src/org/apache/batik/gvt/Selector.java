// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.gvt;

import org.apache.batik.gvt.event.GraphicsNodeChangeListener;
import org.apache.batik.gvt.event.GraphicsNodeKeyListener;
import org.apache.batik.gvt.event.GraphicsNodeMouseListener;
import org.apache.batik.gvt.event.SelectionListener;

public interface Selector
    extends GraphicsNodeMouseListener, GraphicsNodeKeyListener, GraphicsNodeChangeListener
{

    public abstract Object getSelection();

    public abstract boolean isEmpty();

    public abstract void addSelectionListener(SelectionListener selectionlistener);

    public abstract void removeSelectionListener(SelectionListener selectionlistener);
}
