// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.extension;

import org.apache.batik.dom.AbstractDocument;
import org.apache.batik.dom.util.DOMUtilities;
import org.w3c.dom.DOMException;

// Referenced classes of package org.apache.batik.extension:
//            StylableExtensionElement

public abstract class PrefixableStylableExtensionElement extends StylableExtensionElement
{

    protected PrefixableStylableExtensionElement()
    {
        prefix = null;
    }

    public PrefixableStylableExtensionElement(String s, AbstractDocument abstractdocument)
    {
        super(s, abstractdocument);
        prefix = null;
        setPrefix(s);
    }

    public String getNodeName()
    {
        return prefix != null && !prefix.equals("") ? prefix + ":" + getLocalName() : getLocalName();
    }

    public void setPrefix(String s)
        throws DOMException
    {
        if(isReadonly())
            throw createDOMException((short)7, "readonly.node", new Object[] {
                new Integer(getNodeType()), getNodeName()
            });
        if(s != null && !s.equals("") && !DOMUtilities.isValidName(s))
        {
            throw createDOMException((short)5, "prefix", new Object[] {
                new Integer(getNodeType()), getNodeName(), s
            });
        } else
        {
            prefix = s;
            return;
        }
    }

    protected String prefix;
}
