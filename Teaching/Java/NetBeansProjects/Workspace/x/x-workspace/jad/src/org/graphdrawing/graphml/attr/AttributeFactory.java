// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.graphdrawing.graphml.attr;

import org.graphdrawing.graphml.reader.GraphMLParseContext;

// Referenced classes of package org.graphdrawing.graphml.attr:
//            AttributeConstants

public interface AttributeFactory
    extends AttributeConstants
{

    public abstract void defineAttribute(String s, int i, int j);

    public abstract void createAttribute(GraphMLParseContext graphmlparsecontext, String s, String s1);
}
