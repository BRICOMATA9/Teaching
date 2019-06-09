// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.E;

import java.util.Random;

public class E extends Random
{

    public E()
    {
    }

    public E(long l)
    {
        super(l);
    }

    public int nextInt(int i)
    {
        if(i <= 0)
            throw new IllegalArgumentException("n must be positive");
        int j;
        int k;
        do
        {
            j = next(31);
            k = j % i;
        } while((j - k) + (i - 1) < 0);
        return k;
    }
}
