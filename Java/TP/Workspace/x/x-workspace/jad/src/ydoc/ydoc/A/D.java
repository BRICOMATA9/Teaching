// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package ydoc.A;

import java.io.FileOutputStream;
import java.io.PrintStream;

// Referenced classes of package ydoc.A:
//            F

public final class D
{

    public static void A(int i)
    {
        switch(i)
        {
        case 0: // '\0'
            D = true;
            F = false;
            C = false;
            A = true;
            break;

        case 1: // '\001'
            D = false;
            F = true;
            C = true;
            A = false;
            try
            {
                G = (new StringBuilder()).append(System.getProperty("user.dir")).append(System.getProperty("file.separator")).append("ydocErr.log").toString();
                System.setErr(new PrintStream(new FileOutputStream(G)));
                break;
            }
            catch(Exception exception)
            {
                D = true;
                F = false;
                C = false;
                A = true;
                E.C((new StringBuilder()).append("Cannot log exceptions : ").append(exception.getMessage()).append("\n").append("Will run in debug mode.").toString());
            }
            break;

        case 2: // '\002'
            D = false;
            F = false;
            C = true;
            A = false;
            break;

        default:
            D = false;
            F = false;
            C = false;
            A = true;
            break;
        }
    }

    public static F A()
    {
        return E;
    }

    public static void A(F f)
    {
        E = f;
    }

    public static void A(Exception exception)
    {
        A(exception, null);
    }

    public static void A(Exception exception, String s)
    {
        if(!C && A)
        {
            if(s != null)
                E.A(s);
            if(!D)
                E.A(exception.toString());
            if(D)
                exception.printStackTrace();
        }
        if(F)
        {
            if(s != null)
            {
                E.A(s);
                System.err.println(s);
            }
            exception.printStackTrace();
        }
    }

    public static void A(Error error, String s)
    {
        if(s != null)
            E.A(s);
        if(!D)
            E.A(error.toString());
        if(D || F)
        {
            if(F && s != null)
                System.err.println(s);
            error.printStackTrace();
        }
    }

    public static void B(String s)
    {
        E.A(s);
    }

    public static void A(String s)
    {
        E.B(s);
    }

    public static void C(String s)
    {
        E.C(s);
    }

    private static String G;
    private static boolean D = false;
    private static boolean F = false;
    private static boolean C = false;
    private static boolean A = true;
    private static final F B;
    private static F E;

    static 
    {
        B = new F() {

            public void A(String s)
            {
                System.err.println(s);
            }

            public void B(String s)
            {
                System.out.println(s);
            }

            public void C(String s)
            {
                System.out.println(s);
            }

        };
        E = B;
    }
}
