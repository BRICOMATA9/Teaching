// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.bridge;

import org.apache.batik.gvt.GraphicsNode;

public class StyleReference
{

    public StyleReference(GraphicsNode graphicsnode, String s)
    {
        node = graphicsnode;
        styleAttribute = s;
    }

    public GraphicsNode getGraphicsNode()
    {
        return node;
    }

    public String getStyleAttribute()
    {
        return styleAttribute;
    }

    private GraphicsNode node;
    private String styleAttribute;
}
