// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package ydoc.A;

import A.B.G;
import B.C.A.B;
import C.H.F;
import C.J.K;
import C.J.b;
import java.awt.GraphicsEnvironment;

public final class C
{

    private static void B()
    {
        int i = 0;
        try
        {
            new F();
        }
        catch(Error error)
        {
            i |= 1;
            A++;
        }
        try
        {
            new B.A.C.C();
        }
        catch(Error error1)
        {
            i |= 1;
            A++;
        }
        try
        {
            new B();
        }
        catch(Error error2)
        {
            i |= 1;
            A++;
        }
        try
        {
            new b();
        }
        catch(Error error3)
        {
            i |= 2;
            A++;
        }
        try
        {
            new K();
        }
        catch(Error error4)
        {
            i |= 2;
            A++;
        }
        try
        {
            new G();
        }
        catch(Error error5)
        {
            i |= 2;
            A++;
        }
        if(i != 0)
            if(i == 2 && !GraphicsEnvironment.isHeadless())
                B.append("Invalid graphics mode. Try running in headless mode.\n");
            else
                B.append("Resource loading failed. Try having docletpath point to ydoc.jar exclusively.\n");
    }

    public static int A()
    {
        return A;
    }

    public static String C()
    {
        return B.toString();
    }

    private static int A = 0;
    private static StringBuffer B = new StringBuffer();

    static 
    {
        B();
    }
}
