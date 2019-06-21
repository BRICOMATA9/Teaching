// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.dom;

import org.w3c.dom.DOMException;
import org.w3c.dom.Node;

// Referenced classes of package org.apache.batik.dom:
//            AbstractAttrNS, AbstractDocument

public class GenericAttrNS extends AbstractAttrNS
{

    protected GenericAttrNS()
    {
    }

    public GenericAttrNS(String s, String s1, AbstractDocument abstractdocument)
        throws DOMException
    {
        super(s, s1, abstractdocument);
        setNodeName(s1);
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
        return new GenericAttrNS();
    }

    protected boolean readonly;
}
