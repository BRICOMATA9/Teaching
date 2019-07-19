// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.B;

import C.A.R;
import C.C.A;
import C.C.C;
import C.E.M;
import C.G.F;
import C.G.P;
import C.G.c;
import C.G.d;
import C.G.j;
import C.G.n;
import C.G.u;
import C.G.w;
import C.J.K;
import C.J.b;
import C.J.h;
import C.J.v;
import java.awt.Dimension;
import java.lang.reflect.InvocationTargetException;
import javax.swing.SwingUtilities;

// Referenced classes of package C.B:
//            A

public abstract class D extends C.B.A
{

    protected D(String s, String s1, String s2)
    {
        super(s, s1, s2);
        M = true;
        K = true;
        N = false;
    }

    protected void A(j j1)
    {
        A(j1, M);
    }

    private j C(j j1)
    {
        if(N)
        {
            b b1 = B();
            u u1 = new u();
            if(b1.B(c.A) == null)
            {
                L = new v(b1, true);
                b1.A(c.A, L);
            }
            if(b1.B(c.B) == null)
            {
                J = new v(b1, false);
                b1.A(c.B, J);
            }
            u1.A(j1);
            return u1;
        } else
        {
            return j1;
        }
    }

    private void N()
    {
        b b1 = B();
        if(L != null)
        {
            b1.D(c.A);
            L = null;
        }
        if(J != null)
        {
            b1.D(c.B);
            J = null;
        }
    }

    protected void A(j j1, boolean flag)
    {
        final b graph = B();
        if(I() == null)
        {
            B(C(j1));
        } else
        {
            graph.A(j.C, h.A(graph));
            graph.A(j.B, h.B(graph));
            if(j1 instanceof d)
            {
                d d1 = (d)j1;
                Dimension dimension = I().getSize();
                if(d1.Q() instanceof w)
                {
                    w w1 = (w)d1.Q();
                    w1.A(dimension.getWidth(), dimension.getHeight());
                    double d3 = I()._() ? I().Y() : 0.0D;
                    w1.F(0.0D);
                    if(d3 > 0.0D)
                        w1.E(d3);
                    else
                        w1.E(45D);
                }
            }
            j1 = C(j1);
            try
            {
                if(flag)
                {
                    if(K())
                    {
                        F f = (new P(j1)).b(graph);
                        A(I(), f);
                    } else
                    if(L())
                    {
                        final F result = (new P(j1)).b(graph);
                        try
                        {
                            SwingUtilities.invokeAndWait(new Runnable() {

                                public void run()
                                {
                                    n.A(graph, result);
                                }

                            });
                        }
                        catch(InterruptedException interruptedexception) { }
                        catch(InvocationTargetException invocationtargetexception)
                        {
                            Throwable throwable = invocationtargetexception.getTargetException();
                            if(throwable instanceof RuntimeException)
                                throw (RuntimeException)throwable;
                            if(throwable instanceof Error)
                                throw (Error)throwable;
                        }
                    } else
                    {
                        (new P(j1)).A(graph);
                        graph.d();
                    }
                } else
                {
                    j1.A(graph);
                }
            }
            catch(R r)
            {
                C.E.M.A(r);
            }
            catch(C.F.D d2)
            {
                throw d2;
            }
            catch(Exception exception)
            {
                C.E.M.A(exception);
            }
            B().c();
        }
        N();
        break MISSING_BLOCK_LABEL_359;
        Exception exception1;
        exception1;
        N();
        throw exception1;
    }

    protected void A(K k, F f)
    {
        C c1 = M();
        C.J.d d1 = B(k, f);
        c1.A(k);
        c1.A(C.C.A.A(d1));
    }

    protected C M()
    {
        C c1 = new C();
        return c1;
    }

    protected C.J.d B(K k, F f)
    {
        return new C.J.d(k, f);
    }

    private void B(j j1)
    {
        b b1 = B();
        b1.A(j.C, h.A(b1));
        b1.A(j.B, h.B(b1));
        j1.A(b1);
    }

    protected boolean L()
    {
        return !SwingUtilities.isEventDispatchThread() && I().isShowing();
    }

    public boolean K()
    {
        return K;
    }

    public void A(boolean flag)
    {
        K = flag;
    }

    private boolean M;
    private boolean K;
    private boolean N;
    private C.A.M L;
    private C.A.M J;
}
