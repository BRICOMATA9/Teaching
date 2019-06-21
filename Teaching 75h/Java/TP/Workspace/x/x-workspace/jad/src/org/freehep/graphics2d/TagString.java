// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.freehep.graphics2d;


public class TagString
{

    public TagString(String s)
    {
        string = s;
    }

    public int hashCode()
    {
        return string.hashCode();
    }

    public boolean equals(Object obj)
    {
        return string.equals(obj);
    }

    public String toString()
    {
        return string;
    }

    private String string;
}
