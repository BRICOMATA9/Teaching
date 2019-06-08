// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.E;

import C.A.I;
import java.util.Collection;
import java.util.Iterator;

public class O
{

    public O(int i)
    {
        C = new Object[i + 1];
        D = 0;
        B = D + i + 1;
        E = A = D;
    }

    public O(Collection collection, int i)
    {
        this(collection.iterator(), i);
    }

    public O(Iterator iterator, int i)
    {
        this(i);
        for(; iterator.hasNext(); A(iterator.next()));
    }

    public O(I i, int j)
    {
        this(j);
        for(; i.C(); i.B())
            A(i.D());

    }

    public Object E()
    {
        Object obj = C[E++];
        if(E == B)
            E = D;
        return obj;
    }

    public Object D()
    {
        Object obj = C[E++];
        if(E == B)
            E = D;
        return obj;
    }

    public void B(Object obj)
    {
        C[A++] = obj;
        if(A == B)
            A = D;
    }

    public void A(Object obj)
    {
        C[A++] = obj;
        if(A == B)
            A = D;
    }

    public void A()
    {
        E = A = D;
    }

    public int C()
    {
        int i = A - E;
        return i >= 0 ? i : (B - D) + i;
    }

    public boolean B()
    {
        return E == A;
    }

    public String toString()
    {
        String s = "size=[" + C() + ']';
        for(int i = E; i < A && i < B; i++)
            s = s + ' ' + C[i].toString();

        if(A < E)
        {
            for(int j = D; j < A; j++)
                s = s + ' ' + C[j].toString();

        }
        return s;
    }

    private Object C[];
    private int D;
    private int B;
    private int E;
    private int A;
}
