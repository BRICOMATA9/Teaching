// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.B;

import C.D.Y;
import C.D.a;
import C.E.R;
import C.J.K;
import C.J.b;
import java.util.MissingResourceException;
import javax.swing.SwingUtilities;

// Referenced classes of package C.B:
//            B

public abstract class A
{
    class _A
        implements Runnable
    {

        public void run()
        {
            if(A)
                if(B)
                {
                    try
                    {
                        SwingUtilities.invokeAndWait(new Runnable() {

                            public void run()
                            {
                                C.N();
                                C.b();
                            }

                        });
                    }
                    catch(Exception exception) { }
                } else
                {
                    C.N();
                    C.b();
                }
            try
            {
                G();
            }
            finally
            {
                if(A)
                    if(B)
                        try
                        {
                            SwingUtilities.invokeAndWait(new Runnable() {

                                public void run()
                                {
                                    C.P();
                                }

                            });
                        }
                        catch(Exception exception2) { }
                    else
                        C.P();
            }
        }

        private final boolean A;
        private final boolean B;
        private final b C;


        public _A(boolean flag, boolean flag1)
        {
            A = flag;
            B = flag1;
            C = A.this.B();
        }
    }


    public A(String s, String s1, String s2)
    {
        B = new R();
        A = s;
        F = s1;
        H = s2;
        E = true;
    }

    public String E()
    {
        return A;
    }

    public void B(b b1)
    {
        I = b1;
    }

    protected b B()
    {
        return I;
    }

    protected K I()
    {
        C.J.FA fa = B().i();
        if(fa != null && (fa instanceof K))
            return (K)fa;
        else
            return null;
    }

    public Y C()
    {
        if(G == null)
            G = F();
        if(G != null && G.O() == null)
            try
            {
                a a1 = new a();
                a1.B(getClass().getName());
                G.A(a1);
            }
            catch(MissingResourceException missingresourceexception) { }
        return G;
    }

    protected Y F()
    {
        throw new InternalError("Badly shrinked");
    }

    public void A(b b1)
    {
        A(b1, false);
    }

    private void A(b b1, boolean flag)
    {
        B(b1);
        C = 0;
        if(flag)
        {
            Thread thread = A(((Runnable) (new _A(A(), SwingUtilities.isEventDispatchThread()))));
            thread.start();
            break MISSING_BLOCK_LABEL_88;
        }
        B().N();
        if(A())
            B().b();
        G();
        B().P();
        break MISSING_BLOCK_LABEL_88;
        Exception exception;
        exception;
        B().P();
        throw exception;
    }

    protected Thread A(Runnable runnable)
    {
        Thread thread = new Thread(runnable);
        thread.setPriority(1);
        return thread;
    }

    protected void H()
    {
    }

    protected abstract void D();

    protected void J()
    {
    }

    protected void G()
    {
        D.A();
        H();
        D.D();
        D();
        D.B();
        J();
        D.C();
        break MISSING_BLOCK_LABEL_87;
        Object obj;
        obj;
        D.C();
        throw obj;
        obj;
        D.A(((Throwable) (obj)));
        throw obj;
        obj;
        D.A(((Throwable) (obj)));
        throw obj;
        obj;
        D.A(((Throwable) (obj)));
    }

    public boolean A()
    {
        return E;
    }

    private short C;
    private String A;
    private String F;
    private String H;
    private R B;
    private b I;
    private Y G;
    private boolean E;
    protected final B D = new B(this);
}
