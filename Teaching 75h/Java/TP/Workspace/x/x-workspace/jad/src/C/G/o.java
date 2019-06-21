// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.G;

import C.K.G;

// Referenced classes of package C.G:
//            y, Q

public class o
    implements y, Q
{

    public o(double d, double d1)
    {
        this(d, d1, (byte)0);
    }

    public o(double d, double d1, byte byte0)
    {
        B(d, d1);
        A(byte0);
    }

    public G J()
    {
        return new G(F, I, G, E);
    }

    public void B(double d, double d1)
    {
        G = d;
        E = d1;
    }

    public double D()
    {
        return G;
    }

    public double F()
    {
        return E;
    }

    public void A(double d, double d1)
    {
        F = d;
        I = d1;
    }

    public double E()
    {
        return F;
    }

    public double H()
    {
        return I;
    }

    public void A(byte byte0)
    {
        H = byte0;
    }

    public byte G()
    {
        return H;
    }

    public String toString()
    {
        return J().toString() + " " + I();
    }

    private String I()
    {
        switch(H)
        {
        case 1: // '\001'
            return "PLACE_AT_SOURCE";

        case 2: // '\002'
            return "PLACE_AT_TARGET";

        case 4: // '\004'
            return "PLACE_AT_CENTER";

        case 0: // '\0'
            return "PLACE_ANYWHERE";

        case 3: // '\003'
        default:
            return "ILLEGAL_PLACEMENT: " + H;
        }
    }

    private double F;
    private double I;
    private double G;
    private double E;
    private byte H;
}
