// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.bridge;

import org.apache.batik.gvt.GraphicsNode;
import org.w3c.dom.Element;
import org.w3c.dom.svg.SVGDocument;

// Referenced classes of package org.apache.batik.bridge:
//            Messages

public class BridgeException extends RuntimeException
{

    public BridgeException(Element element, String s, Object aobj[])
    {
        e = element;
        code = s;
        params = aobj;
    }

    public Element getElement()
    {
        return e;
    }

    public void setLineNumber(int i)
    {
        line = i;
    }

    public void setGraphicsNode(GraphicsNode graphicsnode)
    {
        node = graphicsnode;
    }

    public GraphicsNode getGraphicsNode()
    {
        return node;
    }

    public String getMessage()
    {
        String s1 = "<Unknown Element>";
        SVGDocument svgdocument = null;
        if(e != null)
        {
            svgdocument = (SVGDocument)e.getOwnerDocument();
            s1 = e.getLocalName();
        }
        String s;
        if(svgdocument == null)
            s = "<Unknown Document>";
        else
            s = svgdocument.getURL();
        Object aobj[] = new Object[params.length + 3];
        aobj[0] = s;
        aobj[1] = new Integer(line);
        aobj[2] = s1;
        for(int i = 0; i < params.length; i++)
            aobj[i + 3] = params[i];

        return Messages.formatMessage(code, aobj);
    }

    public String getCode()
    {
        return code;
    }

    protected Element e;
    protected String code;
    protected Object params[];
    protected int line;
    protected GraphicsNode node;
}
