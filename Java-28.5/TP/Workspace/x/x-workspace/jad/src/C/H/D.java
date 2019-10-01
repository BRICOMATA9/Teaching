// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.H;

import java.awt.Image;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Enumeration;

// Referenced classes of package C.H:
//            J, E

class D extends J
{
    private static final class _A
    {

        public int B;
        public int D;
        public int A;
        public boolean C;

        _A(int i1, int j1, int k1, boolean flag)
        {
            B = i1;
            D = j1;
            A = k1;
            C = flag;
        }
    }


    public D(Image image, OutputStream outputstream)
        throws IOException
    {
        super(image, outputstream);
        m = false;
        S = 0;
        O = 12;
        N = 4096;
        _ = new int[5003];
        Y = new int[5003];
        f = 5003;
        R = 0;
        h = false;
        a = 0;
        Q = 0;
        i = new byte[256];
    }

    protected void A(int i1, int j1)
        throws IOException
    {
        c = i1;
        Z = j1;
        n = new int[j1][i1];
    }

    protected void A(int i1, int j1, int k1, int l1, int ai[], int i2, int j2)
        throws IOException
    {
        for(int k2 = 0; k2 < l1; k2++)
            System.arraycopy(ai, k2 * j2 + i2, n[j1 + k2], i1, k1);

    }

    protected void B()
        throws IOException
    {
        int i1 = 255;
        for(int j1 = i1 << 24 | i1 << 16 | i1 << 8 | i1; !A(j1); j1 = i1 << 24 | i1 << 16 | i1 << 8 | i1)
            i1 = i1 << 1 & 0xff;

    }

    protected boolean A(int i1)
        throws IOException
    {
        int j1 = -1;
        int k1 = -1;
        k = new E();
        int l1 = 0;
        for(int i2 = 0; i2 < Z; i2++)
        {
            int j2 = i2 * c;
            for(int l2 = 0; l2 < c; l2++)
            {
                int i3 = n[i2][l2] & i1;
                n[i2][l2] = i3;
                boolean flag = i3 >>> 24 < 128;
                if(flag)
                    if(j1 < 0)
                    {
                        j1 = l1;
                        k1 = i3;
                    } else
                    if(i3 != k1)
                        n[i2][l2] = i3 = k1;
                _A _la = (_A)k.B(i3);
                if(_la == null)
                {
                    if(l1 >= 256)
                        return false;
                    _la = new _A(i3, 1, l1, flag);
                    l1++;
                    k.A(i3, _la);
                } else
                {
                    _la.D++;
                }
            }

        }

        byte byte0;
        if(l1 <= 2)
            byte0 = 1;
        else
        if(l1 <= 4)
            byte0 = 2;
        else
        if(l1 <= 16)
            byte0 = 4;
        else
            byte0 = 8;
        int k2 = 1 << byte0;
        byte abyte0[] = new byte[k2];
        byte abyte1[] = new byte[k2];
        byte abyte2[] = new byte[k2];
        for(Enumeration enumeration = k.elements(); enumeration.hasMoreElements();)
        {
            _A _la1 = (_A)enumeration.nextElement();
            abyte0[_la1.A] = (byte)(_la1.B >> 16 & 0xff);
            abyte1[_la1.A] = (byte)(_la1.B >> 8 & 0xff);
            abyte2[_la1.A] = (byte)(_la1.B & 0xff);
        }

        A(D, c, Z, m, (byte)0, j1, byte0, abyte0, abyte1, abyte2);
        return true;
    }

    byte B(int i1, int j1)
        throws IOException
    {
        _A _la = (_A)k.B(n[j1][i1]);
        if(_la == null)
            throw new IOException("color not found");
        else
            return (byte)_la.A;
    }

    static void A(OutputStream outputstream, String s)
        throws IOException
    {
        byte abyte0[] = s.getBytes();
        outputstream.write(abyte0);
    }

    void A(OutputStream outputstream, int i1, int j1, boolean flag, byte byte0, int k1, int l1, 
            byte abyte0[], byte abyte1[], byte abyte2[])
        throws IOException
    {
        l = i1;
        W = j1;
        M = flag;
        int k2 = 1 << l1;
        int j2;
        int i2 = j2 = 0;
        j = i1 * j1;
        S = 0;
        int l2;
        if(l1 <= 1)
            l2 = 2;
        else
            l2 = l1;
        e = 0;
        d = 0;
        A(outputstream, "GIF89a");
        A(i1, outputstream);
        A(j1, outputstream);
        byte byte1 = -128;
        byte1 |= 0x70;
        byte1 |= (byte)(l1 - 1);
        A(byte1, outputstream);
        A(byte0, outputstream);
        A((byte)0, outputstream);
        for(int i3 = 0; i3 < k2; i3++)
        {
            A(abyte0[i3], outputstream);
            A(abyte1[i3], outputstream);
            A(abyte2[i3], outputstream);
        }

        if(k1 != -1)
        {
            A((byte)33, outputstream);
            A((byte)-7, outputstream);
            A((byte)4, outputstream);
            A((byte)1, outputstream);
            A((byte)0, outputstream);
            A((byte)0, outputstream);
            A((byte)k1, outputstream);
            A((byte)0, outputstream);
        }
        A((byte)44, outputstream);
        A(i2, outputstream);
        A(j2, outputstream);
        A(i1, outputstream);
        A(j1, outputstream);
        if(flag)
            A((byte)64, outputstream);
        else
            A((byte)0, outputstream);
        A((byte)l2, outputstream);
        C(l2 + 1, outputstream);
        A((byte)0, outputstream);
        A((byte)59, outputstream);
    }

    void G()
    {
        e++;
        if(e == l)
        {
            e = 0;
            if(!M)
                d++;
            else
                switch(S)
                {
                default:
                    break;

                case 0: // '\0'
                    d += 8;
                    if(d >= W)
                    {
                        S++;
                        d = 4;
                    }
                    break;

                case 1: // '\001'
                    d += 8;
                    if(d >= W)
                    {
                        S++;
                        d = 2;
                    }
                    break;

                case 2: // '\002'
                    d += 4;
                    if(d >= W)
                    {
                        S++;
                        d = 1;
                    }
                    break;

                case 3: // '\003'
                    d += 2;
                    break;
                }
        }
    }

    int F()
        throws IOException
    {
        if(j == 0)
        {
            return -1;
        } else
        {
            j--;
            byte byte0 = B(e, d);
            G();
            return byte0 & 0xff;
        }
    }

    void A(int i1, OutputStream outputstream)
        throws IOException
    {
        A((byte)(i1 & 0xff), outputstream);
        A((byte)(i1 >> 8 & 0xff), outputstream);
    }

    void A(byte byte0, OutputStream outputstream)
        throws IOException
    {
        outputstream.write(byte0);
    }

    final int C(int i1)
    {
        return (1 << i1) - 1;
    }

    void C(int i1, OutputStream outputstream)
        throws IOException
    {
        V = i1;
        h = false;
        g = V;
        U = C(g);
        P = 1 << i1 - 1;
        X = P + 1;
        R = P + 2;
        E();
        int j2 = F();
        int i3 = 0;
        for(int j1 = f; j1 < 0x10000; j1 *= 2)
            i3++;

        i3 = 8 - i3;
        int l2 = f;
        B(l2);
        B(P, outputstream);
label0:
        do
        {
            int i2;
            if((i2 = F()) == -1)
                break;
            int k1 = (i2 << O) + j2;
            int l1 = i2 << i3 ^ j2;
            if(_[l1] == k1)
            {
                j2 = Y[l1];
                continue;
            }
            if(_[l1] >= 0)
            {
                int k2 = l2 - l1;
                if(l1 == 0)
                    k2 = 1;
                do
                {
                    if((l1 -= k2) < 0)
                        l1 += l2;
                    if(_[l1] != k1)
                        continue;
                    j2 = Y[l1];
                    continue label0;
                } while(_[l1] >= 0);
            }
            B(j2, outputstream);
            j2 = i2;
            if(R < N)
            {
                Y[l1] = R++;
                _[l1] = k1;
            } else
            {
                A(outputstream);
            }
        } while(true);
        B(j2, outputstream);
        B(X, outputstream);
    }

    void B(int i1, OutputStream outputstream)
        throws IOException
    {
        a &= T[Q];
        if(Q > 0)
            a |= i1 << Q;
        else
            a = i1;
        for(Q += g; Q >= 8; Q -= 8)
        {
            B((byte)(a & 0xff), outputstream);
            a >>= 8;
        }

        if(R > U || h)
            if(h)
            {
                U = C(g = V);
                h = false;
            } else
            {
                g++;
                if(g == O)
                    U = N;
                else
                    U = C(g);
            }
        if(i1 == X)
        {
            for(; Q > 0; Q -= 8)
            {
                B((byte)(a & 0xff), outputstream);
                a >>= 8;
            }

            B(outputstream);
        }
    }

    void A(OutputStream outputstream)
        throws IOException
    {
        B(f);
        R = P + 2;
        h = true;
        B(P, outputstream);
    }

    void B(int i1)
    {
        for(int j1 = 0; j1 < i1; j1++)
            _[j1] = -1;

    }

    void E()
    {
        b = 0;
    }

    void B(byte byte0, OutputStream outputstream)
        throws IOException
    {
        i[b++] = byte0;
        if(b >= 254)
            B(outputstream);
    }

    void B(OutputStream outputstream)
        throws IOException
    {
        if(b > 0)
        {
            outputstream.write(b);
            outputstream.write(i, 0, b);
            b = 0;
        }
    }

    private boolean m;
    int c;
    int Z;
    int n[][];
    E k;
    int l;
    int W;
    boolean M;
    int e;
    int d;
    int j;
    int S;
    int g;
    int O;
    int U;
    int N;
    int _[];
    int Y[];
    int f;
    int R;
    boolean h;
    int V;
    int P;
    int X;
    int a;
    int Q;
    int T[] = {
        0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 
        1023, 2047, 4095, 8191, 16383, 32767, 65535
    };
    int b;
    byte i[];
}
