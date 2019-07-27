// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.freehep.util;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class FastStack extends ArrayList
{

    public FastStack()
    {
        this(10);
    }

    public FastStack(int i)
    {
        super(i);
    }

    public Object push(Object obj)
    {
        add(obj);
        return obj;
    }

    public Object pop()
    {
        Object obj = peek();
        int i = size();
        remove(i - 1);
        return obj;
    }

    public Object peek()
    {
        int i = size();
        if(i == 0)
            throw new EmptyStackException();
        else
            return get(i - 1);
    }

    private static final long serialVersionUID = 0xfe7236cfdc361617L;
}
