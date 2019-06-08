// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.dom;

import org.w3c.dom.*;

// Referenced classes of package org.apache.batik.dom:
//            AbstractText, AbstractDocument

public class GenericText extends AbstractText
{

    protected GenericText()
    {
    }

    public GenericText(String s, AbstractDocument abstractdocument)
    {
        ownerDocument = abstractdocument;
        setNodeValue(s);
    }

    public String getNodeName()
    {
        return "#text";
    }

    public short getNodeType()
    {
        return 3;
    }

    public boolean isReadonly()
    {
        return readonly;
    }

    public void setReadonly(boolean flag)
    {
        readonly = flag;
    }

    protected Text createTextNode(String s)
    {
        return getOwnerDocument().createTextNode(s);
    }

    protected Node newNode()
    {
        return new GenericText();
    }

    protected boolean readonly;
}
