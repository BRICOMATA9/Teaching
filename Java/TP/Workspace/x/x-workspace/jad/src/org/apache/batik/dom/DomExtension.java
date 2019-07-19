// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.dom;


// Referenced classes of package org.apache.batik.dom:
//            ExtensibleDOMImplementation

public interface DomExtension
{

    public abstract float getPriority();

    public abstract String getAuthor();

    public abstract String getContactAddress();

    public abstract String getURL();

    public abstract String getDescription();

    public abstract void registerTags(ExtensibleDOMImplementation extensibledomimplementation);
}
