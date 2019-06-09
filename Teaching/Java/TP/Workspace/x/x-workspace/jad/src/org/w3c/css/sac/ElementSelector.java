// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.w3c.css.sac;


// Referenced classes of package org.w3c.css.sac:
//            SimpleSelector

public interface ElementSelector
    extends SimpleSelector
{

    public abstract String getNamespaceURI();

    public abstract String getLocalName();
}
