// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package B.B.A.B;


public class B extends RuntimeException
{

    public B(String s, byte byte0, String s1)
    {
        super(s1 + ": Property \"" + s + "\" not supported for " + A(byte0) + ".");
    }

    private static String A(byte byte0)
    {
        switch(byte0)
        {
        case 0: // '\0'
            return "NodeStyle";

        case 1: // '\001'
            return "LineStyle";
        }
        throw new IllegalArgumentException(Byte.toString(byte0));
    }
}
