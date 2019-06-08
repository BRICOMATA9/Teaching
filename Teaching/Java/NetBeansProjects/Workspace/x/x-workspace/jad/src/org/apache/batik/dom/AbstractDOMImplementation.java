// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.dom;

import java.io.Serializable;
import org.apache.batik.dom.events.DocumentEventSupport;
import org.apache.batik.dom.util.HashTable;
import org.w3c.dom.DOMImplementation;

public abstract class AbstractDOMImplementation
    implements DOMImplementation, Serializable
{

    protected void registerFeature(String s, Object obj)
    {
        features.put(s.toLowerCase(), obj);
    }

    protected AbstractDOMImplementation()
    {
        registerFeature("XML", new String[] {
            "1.0", "2.0"
        });
        registerFeature("Events", "2.0");
        registerFeature("MouseEvents", "2.0");
        registerFeature("MutationEvents", "2.0");
        registerFeature("Traversal", "2.0");
        registerFeature("UIEvents", "2.0");
    }

    public boolean hasFeature(String s, String s1)
    {
        Object obj = features.get(s.toLowerCase());
        if(obj == null)
            return false;
        if(s1 == null || s1.length() == 0)
            return true;
        if(obj instanceof String)
            return s1.equals(obj);
        String as[] = (String[])obj;
        for(int i = 0; i < as.length; i++)
            if(s1.equals(as[i]))
                return true;

        return false;
    }

    public DocumentEventSupport createDocumentEventSupport()
    {
        return new DocumentEventSupport();
    }

    protected final HashTable features = new HashTable();
}
