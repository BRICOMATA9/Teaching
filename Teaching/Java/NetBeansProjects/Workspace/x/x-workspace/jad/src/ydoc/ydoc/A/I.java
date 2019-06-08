// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package ydoc.A;

import java.io.PrintStream;

// Referenced classes of package ydoc.A:
//            G

public final class I
{

    public static char[] D()
    {
        char ac[] = new char[A.length];
        for(int i = 0; i < A.length; i++)
            ac[i] = (char)A[i];

        return ac;
    }

    public static long C()
    {
        return 0x1365a6c9edbL;
    }

    public static String E()
    {
        return "yDoc version 3.0_02 (JDK 1.5) build Wed Mar 28 18:48:49 GMT+01:00 2012";
    }

    private static String A()
    {
        return (new StringBuilder()).append("Java version ").append(System.getProperty("java.version")).append(" (").append(System.getProperty("java.vm.name")).append(" on ").append(System.getProperty("os.name")).append(")").toString();
    }

    private static String B()
    {
        String s = System.getProperty("java.version");
        G g = new G();
        if(g.A("1.5", s) <= 0 && g.A("1.7", s) > 0)
            return "yDoc and Java versions are compatible.";
        else
            return "yDoc and Java versions are *not* compatible.";
    }

    public static void main(String args[])
    {
        System.out.println(E());
        System.out.println(A());
        System.out.println(B());
    }

    private static final int A[] = {
        51, 46, 48, 95, 48, 50
    };

}
