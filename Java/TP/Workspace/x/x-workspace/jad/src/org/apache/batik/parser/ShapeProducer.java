// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.parser;

import java.awt.Shape;

public interface ShapeProducer
{

    public abstract Shape getShape();

    public abstract void setWindingRule(int i);

    public abstract int getWindingRule();
}
