// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.graphdrawing.graphml.attr;

import org.graphdrawing.graphml.writer.GraphMLWriteContext;

public interface AttributeProvider
{

    public abstract int getContentType();

    public abstract String getName();

    public abstract Object getValue(GraphMLWriteContext graphmlwritecontext);
}
