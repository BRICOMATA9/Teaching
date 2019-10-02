// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.E;

import java.io.*;
import java.util.StringTokenizer;
import javax.swing.SwingUtilities;

// Referenced classes of package C.E:
//            N, A

public class M
{

    public M()
    {
    }

    public static final void A(Object obj)
    {
        System.err.println(obj);
        if(obj instanceof Exception)
            ((Exception)obj).printStackTrace(System.err);
    }

    public static final void A(Object obj, Object obj1)
    {
        if(B(obj))
            System.err.println(obj.getClass().getName() + " : " + obj1);
    }

    public static final void A(Object obj, int i, Object obj1)
    {
        if(A < i)
            return;
        if(B(obj))
            System.err.println(obj.getClass().getName() + " : " + obj1);
    }

    public static boolean B(Object obj)
    {
        String s = obj.getClass().getName();
        return A(s);
    }

    public static boolean A(String s)
    {
        if(C == null)
            return false;
        for(StringTokenizer stringtokenizer = new StringTokenizer(C, ":"); stringtokenizer.hasMoreTokens();)
        {
            String s1 = stringtokenizer.nextToken();
            if(s.startsWith(s1))
                return true;
        }

        return false;
    }

    public static void A(Exception exception)
    {
        if(SwingUtilities.isEventDispatchThread() || B)
        {
            N.A(null, "Exception", exception);
            return;
        } else
        {
            exception.printStackTrace(System.err);
            return;
        }
    }

    private static String C;
    public static final int A;
    private static boolean B;

    static 
    {
        C = null;
_L2:
        if(C.E.A.B() == 0L)
            break; /* Loop/switch isn't completed */
        if(C.E.A.B() < 0L)
        {
            System.err.println("yFiles Evaluation Version");
            break; /* Loop/switch isn't completed */
        }
        try
        {
            long l = System.currentTimeMillis() / 1000L;
            if(C.E.A.B() - l < 0L)
            {
                System.err.println("Evaluation time expired\n");
                System.exit(1);
                continue; /* Loop/switch isn't completed */
            }
            if(C.E.A.A() - l > 0L)
            {
                System.err.println("Evaluation time expired\n");
                System.exit(1);
                continue; /* Loop/switch isn't completed */
            }
            System.err.println("yFiles: Remaining Evaluation Period: " + (C.E.A.B() - l) / 0x15180L + " days");
            break; /* Loop/switch isn't completed */
        }
        catch(RuntimeException runtimeexception)
        {
            System.exit(1);
        }
        if(true) goto _L2; else goto _L1
_L1:
label0:
        {
            int i = 0;
            try
            {
                if(System.getProperty("y.debug.level") != null)
                    i = Integer.parseInt(System.getProperty("y.debug.level"));
                C = System.getProperty("y.debug");
                String s = System.getProperty("y.debug.file");
                if(s != null)
                {
                    FileInputStream fileinputstream = new FileInputStream(new File(s));
                    BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(fileinputstream));
                    String s1;
                    while((s1 = bufferedreader.readLine()) != null) 
                        if(C == null)
                            C = s1;
                        else
                            C = C + ":" + s1;
                    bufferedreader.close();
                    fileinputstream.close();
                }
            }
            catch(Exception exception)
            {
                A = i;
                break label0;
            }
            finally
            {
                A = i;
                throw exception1;
            }
            A = i;
            break label0;
        }
    }
}
