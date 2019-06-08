// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.G;


// Referenced classes of package C.G:
//            k, j, I

public abstract class g
    implements k
{

    public g()
    {
        this(null);
    }

    public g(j j1)
    {
        y = j1;
    }

    public void A(j j1)
    {
        y = j1;
    }

    public j _()
    {
        return y;
    }

    protected void D(I i)
    {
        if(y != null)
            y.A(i);
    }

    private j y;
}
