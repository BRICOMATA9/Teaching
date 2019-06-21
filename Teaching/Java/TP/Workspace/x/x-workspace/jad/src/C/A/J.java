// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.A;


// Referenced classes of package C.A:
//            H, D, T

public class J extends H
{

    protected J(D d, T t, J j, T t1, J j1, int i, int k)
    {
        d.B(this, t, j, t1, j1, i, k);
    }

    public D K()
    {
        return D;
    }

    public int L()
    {
        if(D.B)
            D.D();
        return F;
    }

    public T G()
    {
        return H;
    }

    public T E()
    {
        return I;
    }

    public T A(T t)
    {
        return H != t ? H : I;
    }

    public boolean H()
    {
        return I == H;
    }

    public String toString()
    {
        return G() + " -> " + E();
    }

    protected void D()
    {
        E = K = G = J = null;
    }

    public J F()
    {
        return E;
    }

    public J C()
    {
        return K;
    }

    public J J()
    {
        return G;
    }

    public J I()
    {
        return J;
    }

    void A(D d, T t, T t1, int i)
    {
        A(i);
        D = d;
        H = t;
        I = t1;
    }

    void A(D d)
    {
        D = d;
    }

    J E;
    J K;
    J G;
    J J;
    T H;
    T I;
    int F;
    D D;
}
