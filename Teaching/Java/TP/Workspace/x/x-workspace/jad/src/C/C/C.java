// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.C;

import C.A.P;
import C.A.Y;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Timer;

// Referenced classes of package C.C:
//            F, B, E

public class C
{
    private static final class _C
        implements Runnable
    {

        public void run()
        {
            A.C();
        }

        private final B A;

        public _C(B b)
        {
            A = b;
        }
    }

    private static final class _D
        implements Runnable
    {

        public void A(double d)
        {
            B = d;
        }

        public void run()
        {
            A.A(B);
        }

        private final B A;
        private double B;

        public _D(B b)
        {
            A = b;
            B = 0.0D;
        }
    }

    private static final class _E
        implements Runnable
    {

        public void run()
        {
            A.A();
        }

        private final B A;

        public _E(B b)
        {
            A = b;
        }
    }

    private final class _A
        implements java.awt.event.ActionListener
    {

        public void actionPerformed(java.awt.event.ActionEvent actionevent)
        {
label0:
            {
                boolean flag = true;
                synchronized(J)
                {
                    if(J != null)
                        break label0;
                }
                return;
            }
            boolean flag1;
            flag1 = !J.isEmpty();
            if(flag1)
            {
                for(P p = J.I(); p != null; p = p.C())
                {
                    _B _lb = (_B)p.A();
                    if(_lb.A())
                        J.A(p);
                }

            }
            y;
            JVM INSTR monitorexit ;
              goto _L1
            exception;
            throw exception;
_L1:
            if(flag1)
                B(I);
            else
                C.this.C();
            return;
        }

        private _A()
        {
        }

    }

    private final class _B
    {

        boolean A()
        {
            if(A < 0L)
            {
                long l = B.B();
                C = 0L >= l ? 0L : (long)((double)l / F);
                A = System.currentTimeMillis();
            }
            double d = 0L >= C ? 1.0D : (double)(System.currentTimeMillis() - A) / (double)C;
            if(d < 1.0D)
            {
                B.A(d);
                return false;
            } else
            {
                B.A(1.0D);
                B.C();
                return true;
            }
        }

        private final B B;
        private long C;
        private long A;

        _B(B b)
        {
            B = b;
            C = -1L;
            A = -1L;
        }
    }


    public C()
    {
        this(1.0D, true);
    }

    public C(double d, boolean flag)
    {
        D = new F(this, 3);
        I = new F(this, 0);
        E = new F(this, 4);
        B = 120;
        F = d;
        J = new Y();
        H = new ArrayList(2);
        A = null;
        G = flag;
        L = true;
        K = true;
    }

    public void A(E e)
    {
        if(e == null)
            return;
        synchronized(H)
        {
            H.add(e);
        }
    }

    public boolean D()
    {
        return K;
    }

    public boolean A()
    {
        return G;
    }

    public void A(B b)
    {
        K = java.awt.EventQueue.isDispatchThread();
        if(G)
            B(b);
        else
            C(b);
    }

    private void C(B b)
    {
        if(A == null)
            B(D);
        A(new _E(b));
        synchronized(J)
        {
            J.add(new _B(b));
        }
        B();
    }

    private void B(B b)
    {
        A(D);
        A(new _E(b));
        _D _ld = new _D(b);
        long l = b.B();
        long l1 = 0L >= l ? 0L : (long)((double)l / F);
        if(l1 > 0L)
        {
            long l2 = Math.max(1L, 1000L / (long)B);
            double d = 0.0D;
            long l3 = 0L;
            long l4 = System.currentTimeMillis();
            for(; d < 1.0D; d = (double)(System.currentTimeMillis() - l4) / (double)l1)
            {
                _ld.A(d);
                A(_ld);
                A(I);
                l3 += l2;
                long l5 = (l3 - System.currentTimeMillis()) + l4;
                if(l5 <= 10L)
                    continue;
                try
                {
                    Thread.sleep(l5);
                }
                catch(Exception exception) { }
            }

        }
        _ld.A(1.0D);
        A(_ld);
        A(I);
        A(new _C(b));
        A(E);
    }

    private void B()
    {
        if(A == null)
        {
            A = new Timer(1000 / B, new _A());
            A.setInitialDelay(0);
            A.start();
        }
    }

    private void C()
    {
        if(A != null)
        {
            A.stop();
            A = null;
            B(E);
        }
    }

    private void A(Runnable runnable)
    {
        if(L && !java.awt.EventQueue.isDispatchThread())
            try
            {
                java.awt.EventQueue.invokeAndWait(runnable);
            }
            catch(InvocationTargetException invocationtargetexception)
            {
                if(invocationtargetexception.getTargetException() instanceof RuntimeException)
                    throw (RuntimeException)invocationtargetexception.getTargetException();
                if(invocationtargetexception.getTargetException() instanceof Error)
                    throw (Error)invocationtargetexception.getTargetException();
                else
                    throw new RuntimeException(invocationtargetexception.toString());
            }
            catch(InterruptedException interruptedexception) { }
        else
            runnable.run();
    }

    private void A(final F event)
    {
        if(null != H && !H.isEmpty())
            if(L && !java.awt.EventQueue.isDispatchThread())
            {
                final E al[] = (E[])H.toArray(C);
                try
                {
                    java.awt.EventQueue.invokeAndWait(new Runnable() {

                        public void run()
                        {
                            int k = 0;
                            for(int l = al.length; k < l; k++)
                                al[k].A(event);

                        }

                    });
                }
                catch(InvocationTargetException invocationtargetexception)
                {
                    if(invocationtargetexception.getTargetException() instanceof RuntimeException)
                        throw (RuntimeException)invocationtargetexception.getTargetException();
                    if(invocationtargetexception.getTargetException() instanceof Error)
                        throw (Error)invocationtargetexception.getTargetException();
                    else
                        throw new RuntimeException(invocationtargetexception.toString());
                }
                catch(InterruptedException interruptedexception) { }
            } else
            {
                E ae[] = (E[])H.toArray(C);
                int i = 0;
                for(int j = ae.length; i < j; i++)
                    ae[i].A(event);

            }
    }

    private void B(F f)
    {
label0:
        {
            synchronized(H)
            {
                if(!H.isEmpty())
                    break label0;
            }
            return;
        }
        E ae[] = (E[])H.toArray(C);
        int i = 0;
        for(int j = ae.length; i < j; i++)
            ae[i].A(f);

        list;
        JVM INSTR monitorexit ;
          goto _L1
        exception;
        throw exception;
_L1:
    }

    private static final E C[] = new E[0];
    private final F D;
    private final F I;
    private final F E;
    private int B;
    private double F;
    private final Y J;
    private final List H;
    private Timer A;
    private boolean G;
    private boolean L;
    private boolean K;






}
