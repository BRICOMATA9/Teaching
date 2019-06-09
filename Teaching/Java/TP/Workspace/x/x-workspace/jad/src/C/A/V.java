// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.A;


// Referenced classes of package C.A:
//            H, E, T, J

class V
{
    class _A
        implements E
    {

        public boolean C()
        {
            return F != null;
        }

        public void B()
        {
            F = F.C;
        }

        public void G()
        {
            F = F.A;
        }

        public void A()
        {
            F = V.this.B;
        }

        public void E()
        {
            F = V.this.C;
        }

        public int F()
        {
            return V.this.A;
        }

        public Object D()
        {
            return F;
        }

        public T H()
        {
            return (T)F;
        }

        public J I()
        {
            return (J)F;
        }

        private H F;

        _A()
        {
            F = V.this.C;
        }
    }


    V()
    {
    }

    public int E()
    {
        return A;
    }

    boolean F()
    {
        return A == 0;
    }

    H D()
    {
        return C;
    }

    H B(H h)
    {
        return h.A();
    }

    public void A(H h)
    {
        A++;
        h.A(B);
        h.B(null);
        if(B != null)
        {
            B.B(h);
            B = h;
        } else
        {
            B = C = h;
        }
    }

    void A(H h, H h1, int i)
    {
        if(h1 == null)
        {
            A(h);
            return;
        }
        if(i == 1)
        {
            H h2 = h1.B();
            if(h2 != null)
                h2.B(h);
            else
                C = h;
            h.A(h2);
            h.B(h1);
            h1.A(h);
        } else
        {
            H h3 = h1.A();
            if(h3 != null)
                h3.A(h);
            else
                B = h;
            h.B(h3);
            h.A(h1);
            h1.B(h);
        }
        A++;
    }

    void C(H h)
    {
        H h1 = h.A();
        H h2 = h.B();
        A--;
        if(h1 != null)
            h1.A(h2);
        else
            B = h2;
        if(h2 != null)
            h2.B(h1);
        else
            C = h1;
    }

    H C()
    {
        return C;
    }

    void B()
    {
        C = null;
        B = null;
        A = 0;
    }

    E A()
    {
        return new _A();
    }

    private H C;
    private H B;
    private int A;



}
