// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package ydoc.doclets;

import com.sun.javadoc.*;
import ydoc.A.A.H;
import ydoc.A.*;

// Referenced classes of package ydoc.doclets:
//            A, J, g, C

public class YStandard
{

    public static boolean start(RootDoc rootdoc)
    {
        boolean flag;
        A(rootdoc);
        A().B(ydoc.doclets.A.A(rootdoc));
        A().C();
        H h = H.J();
        if(h.I() == 56979)
        {
            D.A(new F(rootdoc) {

                public void A(String s)
                {
                    A.printError(s);
                }

                public void B(String s)
                {
                    A.printNotice(s);
                }

                public void C(String s)
                {
                    A.printWarning(s);
                }

                final RootDoc A;

            
            {
                A = rootdoc;
                super();
            }
            });
            try
            {
                B().A(rootdoc);
                flag = true;
            }
            catch(Exception exception)
            {
                D.A(exception);
                flag = false;
            }
        } else
        {
            flag = false;
        }
        ydoc.A.B.B().A();
        break MISSING_BLOCK_LABEL_90;
        Exception exception1;
        exception1;
        ydoc.A.B.B().A();
        throw exception1;
        return flag;
    }

    public static int optionLength(String s)
    {
        return B().A(s);
    }

    public static boolean validOptions(String as[][], DocErrorReporter docerrorreporter)
    {
        return B().A(as, docerrorreporter);
    }

    public static LanguageVersion languageVersion()
    {
        return B().B();
    }

    private static J A()
    {
        return B().A();
    }

    private static g B()
    {
        if(A == null)
            A = new C();
        return A;
    }

    private static void A(DocErrorReporter docerrorreporter)
    {
        int ai[] = {
            89, 83, 116, 97, 110, 100, 97, 114, 100, 32, 
            68, 111, 99, 108, 101, 116, 32, 118, 101, 114, 
            115, 105, 111, 110, 32
        };
        StringBuffer stringbuffer = new StringBuffer();
        for(int i = 0; i < ai.length; i++)
            stringbuffer.append((char)ai[i]);

        char ac[] = I.D();
        for(int j = 0; j < ac.length; j++)
            stringbuffer.append(ac[j]);

        docerrorreporter.printNotice(stringbuffer.toString());
    }

    private static g A;
}
