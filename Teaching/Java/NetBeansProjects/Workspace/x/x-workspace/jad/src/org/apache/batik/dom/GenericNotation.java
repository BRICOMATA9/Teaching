// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.dom;

import org.w3c.dom.Node;

// Referenced classes of package org.apache.batik.dom:
//            AbstractNotation, AbstractDocument

public class GenericNotation extends AbstractNotation
{

    protected GenericNotation()
    {
    }

    public GenericNotation(String s, String s1, String s2, AbstractDocument abstractdocument)
    {
        ownerDocument = abstractdocument;
        setNodeName(s);
        setPublicId(s1);
        setSystemId(s2);
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
        return new GenericNotation();
    }

    protected boolean readonly;
}
