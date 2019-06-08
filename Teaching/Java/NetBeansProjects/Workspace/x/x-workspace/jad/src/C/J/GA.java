// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.J;

import C.H.H;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.io.*;

// Referenced classes of package C.J:
//            U, f, G, W, 
//            n, Q

public class GA extends U
{
    private static final class _A
    {

        public float A(float f1)
        {
            return ((C * f1 + D) * f1 + A) * f1 + B;
        }

        float B;
        float A;
        float D;
        float C;

        public _A(float f1, float f2, float f3, float f4)
        {
            B = f1;
            A = f2;
            D = f3;
            C = f4;
        }
    }


    public GA()
    {
    }

    public GA(U u)
    {
        super(u);
    }

    public U A(U u)
    {
        return new GA(u);
    }

    public f A(double d, double d1, f f1, int i)
    {
        f f2 = new f(this, d, d1);
        D(f2, f1, i);
        return f2;
    }

    public void D(f f1, f f2, int i)
    {
        if(i == 0)
            A2.A(f1, A2.C(f2));
        else
            A2.B(f1, A2.C(f2));
        C4();
    }

    protected byte A(Point2D point2d, Point2D point2d1)
    {
        if(i() == 0)
            return W.A(this, r, point2d, point2d1);
        int i = i() + 2;
        int ai[] = new int[i];
        int ai1[] = new int[i];
        Y y = C2();
        Y y1 = m();
        n n1 = k();
        n n2 = s();
        int j = 0;
        ai[j] = (int)n1.B(y);
        ai1[j] = (int)n1.A(y);
        j++;
        for(Q q = t(); q.C();)
        {
            f f1 = q.J();
            ai[j] = (int)f1.A();
            ai1[j] = (int)f1.C();
            q.B();
            j++;
        }

        ai[j] = (int)n2.B(y1);
        ai1[j] = (int)n2.A(y1);
        _A a_la[] = A(i - 1, ai);
        _A a_la1[] = A(i - 1, ai1);
        r.reset();
        r.moveTo(a_la[0].A(0.0F), a_la1[0].A(0.0F));
        for(int k = 0; k < a_la.length; k++)
        {
            for(int l = 1; l <= 12; l++)
            {
                float f2 = (float)l / 12F;
                r.lineTo(a_la[k].A(f2), a_la1[k].A(f2));
            }

        }

        return W.A(this, r, r = new GeneralPath(1, i() + 4), point2d, point2d1);
    }

    public void B(ObjectOutputStream objectoutputstream)
        throws IOException
    {
        objectoutputstream.writeByte(0);
        super.B(objectoutputstream);
    }

    public void G(ObjectInputStream objectinputstream)
        throws IOException, ClassNotFoundException
    {
        switch(objectinputstream.readByte())
        {
        case 0: // '\0'
            super.G(objectinputstream);
            break;

        default:
            throw new H();
        }
    }

    private _A[] A(int i, int ai[])
    {
        float af[] = new float[i + 1];
        float af1[] = new float[i + 1];
        float af2[] = new float[i + 1];
        af[0] = 0.5F;
        for(int j = 1; j < i; j++)
            af[j] = 1.0F / (4F - af[j - 1]);

        af[i] = 1.0F / (2.0F - af[i - 1]);
        af1[0] = (float)(3 * (ai[1] - ai[0])) * af[0];
        for(int k = 1; k < i; k++)
            af1[k] = ((float)(3 * (ai[k + 1] - ai[k - 1])) - af1[k - 1]) * af[k];

        af1[i] = ((float)(3 * (ai[i] - ai[i - 1])) - af1[i - 1]) * af[i];
        af2[i] = af1[i];
        for(int l = i - 1; l >= 0; l--)
            af2[l] = af1[l] - af[l] * af2[l + 1];

        _A a_la[] = new _A[i];
        for(int i1 = 0; i1 < i; i1++)
            a_la[i1] = new _A(ai[i1], af2[i1], (float)(3 * (ai[i1 + 1] - ai[i1])) - 2.0F * af2[i1] - af2[i1 + 1], (float)(2 * (ai[i1] - ai[i1 + 1])) + af2[i1] + af2[i1 + 1]);

        return a_la;
    }
}
