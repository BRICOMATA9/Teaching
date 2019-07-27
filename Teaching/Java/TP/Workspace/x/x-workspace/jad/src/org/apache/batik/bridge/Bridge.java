// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.bridge;


public interface Bridge
{

    public abstract String getNamespaceURI();

    public abstract String getLocalName();

    public abstract Bridge getInstance();
}
