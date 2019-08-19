// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.C;

import java.util.EventObject;

public class F extends EventObject
{

    public F(Object obj, int i)
    {
        super(obj);
        A = i;
    }

    public int A()
    {
        return A;
    }

    private int A;
}
