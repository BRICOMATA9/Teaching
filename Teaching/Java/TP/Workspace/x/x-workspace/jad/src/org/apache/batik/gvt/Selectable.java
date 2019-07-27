// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.gvt;

import java.awt.Shape;

public interface Selectable
{

    public abstract boolean selectAt(double d, double d1);

    public abstract boolean selectTo(double d, double d1);

    public abstract boolean selectAll(double d, double d1);

    public abstract Object getSelection();

    public abstract Shape getHighlightShape();
}
