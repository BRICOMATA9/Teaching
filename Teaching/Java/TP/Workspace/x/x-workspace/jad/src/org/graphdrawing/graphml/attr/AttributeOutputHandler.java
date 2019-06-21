// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.graphdrawing.graphml.attr;

import org.graphdrawing.graphml.writer.*;

// Referenced classes of package org.graphdrawing.graphml.attr:
//            AttributeConstants, AttributeProvider

public class AttributeOutputHandler
    implements OutputHandler, AttributeConstants
{

    public AttributeOutputHandler(AttributeProvider attributeprovider)
    {
        provider = attributeprovider;
    }

    public AttributeProvider getAttributeProvider()
    {
        return provider;
    }

    public void printKeyAttributes(GraphMLWriteContext graphmlwritecontext, XmlWriter xmlwriter)
    {
        String s = null;
        switch(provider.getContentType())
        {
        case 4: // '\004'
            s = "double";
            break;

        case 1: // '\001'
            s = "int";
            break;

        case 3: // '\003'
            s = "float";
            break;

        case 2: // '\002'
            s = "long";
            break;

        case 5: // '\005'
            s = "string";
            break;

        case 6: // '\006'
            s = "boolean";
            break;

        default:
            throw new RuntimeException("Unknown content type: " + provider.getContentType());
        }
        xmlwriter.writeAttribute("attr.name", provider.getName());
        xmlwriter.writeAttribute("attr.type", s);
    }

    public void printKeyOutput(GraphMLWriteContext graphmlwritecontext, XmlWriter xmlwriter)
    {
    }

    public void printDataAttributes(GraphMLWriteContext graphmlwritecontext, XmlWriter xmlwriter)
    {
    }

    public void printDataOutput(GraphMLWriteContext graphmlwritecontext, XmlWriter xmlwriter)
    {
        Object obj = provider.getValue(graphmlwritecontext);
        if(obj != null)
            xmlwriter.writeText(obj.toString());
    }

    private AttributeProvider provider;
}
