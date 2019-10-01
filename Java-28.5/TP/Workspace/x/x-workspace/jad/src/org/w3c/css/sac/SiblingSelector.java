// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.w3c.css.sac;


// Referenced classes of package org.w3c.css.sac:
//            Selector, SimpleSelector

public interface SiblingSelector
    extends Selector
{

    public abstract short getNodeType();

    public abstract Selector getSelector();

    public abstract SimpleSelector getSiblingSelector();

    public static final short ANY_NODE = 201;
}
