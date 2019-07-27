// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.dom;

import org.w3c.dom.DOMException;
import org.w3c.dom.Node;

// Referenced classes of package org.apache.batik.dom:
//            AbstractAttr, AbstractDocument

public class GenericAttr extends AbstractAttr
{

    protected GenericAttr()
    {
    }

    public GenericAttr(String s, AbstractDocument abstractdocument)
        throws DOMException
    {
        super(s, abstractdocument);
        setNodeName(s);
    }

    public boolean isReadonly()
    {
        return readonly;
    }

    public void setReadonly(boolean flag)
    {
        readonly = flag;
    }

    protected Node newNode()
    {
        return new GenericAttr();
    }

    protected boolean readonly;
}
