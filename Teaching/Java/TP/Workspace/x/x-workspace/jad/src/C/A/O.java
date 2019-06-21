// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.A;

import java.util.Stack;
import java.util.Vector;

// Referenced classes of package C.A:
//            N, X, V, H, 
//            K, L

class O
{

    O(int i, int j)
    {
        B = i;
        D = j;
        A = new Stack();
        for(int k = B - 1; k >= 0; k--)
            A.push(new Integer(k));

        C = new Vector();
    }

    private int A(V v)
    {
        int i;
        if(A.empty())
        {
            A(v, B, B + D);
            for(int j = (B + D) - 1; j > B; j--)
                A.push(new Integer(j));

            i = B;
            B += D;
        } else
        {
            i = ((Integer)A.pop()).intValue();
        }
        return i;
    }

    K B(V v, String s)
    {
        int i = A(v);
        N n = new N(i, s, this);
        C.addElement(n);
        A(v, i);
        return n;
    }

    L A(V v, String s)
    {
        int i = A(v);
        X x = new X(i, s, this);
        C.addElement(x);
        A(v, i);
        return x;
    }

    void A(V v, int i, int j)
    {
        for(H h = v.D(); h != null; h = v.B(h))
        {
            Object aobj[] = new Object[j];
            System.arraycopy(((Object) (h.B)), 0, ((Object) (aobj)), 0, i);
            h.B = aobj;
        }

    }

    void A(H h, int i, int j)
    {
        Object aobj[] = new Object[j];
        System.arraycopy(((Object) (h.B)), 0, ((Object) (aobj)), 0, i);
        h.B = aobj;
    }

    void A(V v, int i)
    {
        for(H h = v.D(); h != null; h = v.B(h))
            h.B[i] = null;

    }

    void A(K k, V v)
    {
        if(k instanceof N)
        {
            N n = (N)k;
            if(n.C != this)
                throw new IllegalArgumentException("Map does not belong to this graph!");
            if(n.A())
                throw new IllegalStateException("Map has been already disposed !");
            n.B();
            int i = ((N)k).F;
            if(!A.contains(new Integer(i)))
            {
                A(v, i);
                A.push(new Integer(i));
                C.removeElement(k);
            }
        }
    }

    void A(L l, V v)
    {
        if(l instanceof X)
        {
            X x = (X)l;
            if(x.K != this)
                throw new IllegalArgumentException("Map does not belong to this graph!");
            if(x.C())
                throw new IllegalStateException("Map has been already disposed !");
            x.D();
            int i = x.N;
            if(!A.contains(new Integer(i)))
            {
                A(v, i);
                A.push(new Integer(i));
                C.removeElement(l);
            }
        }
    }

    int B;
    int D;
    Stack A;
    Vector C;
}
