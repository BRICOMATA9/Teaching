// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.w3c.css.sac;


public interface Locator
{

    public abstract String getURI();

    public abstract int getLineNumber();

    public abstract int getColumnNumber();
}
