// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package ydoc.doclets;

import com.sun.javadoc.*;
import com.sun.tools.doclets.Taglet;
import com.sun.tools.doclets.formats.html.ConfigurationImpl;
import com.sun.tools.doclets.internal.toolkit.taglets.TagletManager;
import java.io.*;
import ydoc.A.A.H;
import ydoc.A.*;
import ydoc.resolvers.FlatPathResolver;

// Referenced classes of package ydoc.doclets:
//            g, A, J, V, 
//            P, Q

public class JDocsSimple
    implements g
{

    public static boolean start(RootDoc rootdoc)
    {
        boolean flag;
        A(rootdoc);
        E().B(ydoc.doclets.A.A(rootdoc));
        E().A(rootdoc);
        H h = H.J();
        if(h.I() == 56979)
        {
            ydoc.A.D.A(new F(rootdoc) {

                public void A(String s)
                {
                    B.printError(s);
                }

                public void B(String s)
                {
                    B.printNotice(s);
                }

                public void C(String s)
                {
                    B.printWarning(s);
                }

                final RootDoc B;

            
            {
                B = rootdoc;
                super();
            }
            });
            try
            {
                D().A(rootdoc);
                flag = true;
            }
            catch(Exception exception)
            {
                ydoc.A.D.A(exception);
                flag = false;
            }
        } else
        {
            flag = false;
        }
        ydoc.A.B.B().A();
        break MISSING_BLOCK_LABEL_91;
        Exception exception1;
        exception1;
        ydoc.A.B.B().A();
        throw exception1;
        return flag;
    }

    public static int optionLength(String s)
    {
        return D().A(s);
    }

    public static boolean validOptions(String as[][], DocErrorReporter docerrorreporter)
    {
        return D().A(as, docerrorreporter);
    }

    public static LanguageVersion languageVersion()
    {
        return D().B();
    }

    private static J E()
    {
        return D().A();
    }

    private static g D()
    {
        if(A == null)
            A = new JDocsSimple();
        return A;
    }

    private static void A(DocErrorReporter docerrorreporter)
    {
        int ai[] = {
            74, 68, 111, 99, 115, 83, 105, 109, 112, 108, 
            101, 32, 68, 111, 99, 108, 101, 116, 32, 118, 
            101, 114, 115, 105, 111, 110, 32
        };
        StringBuffer stringbuffer = new StringBuffer();
        for(int i = 0; i < ai.length; i++)
            stringbuffer.append((char)ai[i]);

        char ac[] = I.D();
        for(int j = 0; j < ac.length; j++)
            stringbuffer.append(ac[j]);

        docerrorreporter.printNotice(stringbuffer.toString());
    }

    JDocsSimple()
    {
        B = null;
    }

    public void A(RootDoc rootdoc)
    {
        ydoc.doclets.V.D = A();
        RootDoc rootdoc1 = ydoc.doclets.A.A(rootdoc);
        A().B(rootdoc1);
        A().setOptions();
        A().A.A(A(), A().A.getRootDirectory());
        A(((Doc) (rootdoc1)));
        PackageDoc apackagedoc[] = rootdoc1.specifiedPackages();
        for(int i = 0; i < apackagedoc.length; i++)
        {
            A().A.A(A(), A().A.getPathTo(apackagedoc[i]).getParentFile());
            A(((Doc) (apackagedoc[i])));
            ClassDoc aclassdoc[] = apackagedoc[i].allClasses();
            for(int j = 0; j < aclassdoc.length; j++)
                A(((Doc) (aclassdoc[j])));

        }

    }

    public LanguageVersion B()
    {
        return LanguageVersion.JAVA_1_5;
    }

    public int A(String s)
    {
        return A().optionLength(s);
    }

    public boolean A(String as[][], DocErrorReporter docerrorreporter)
    {
        return A().validOptions(as, docerrorreporter);
    }

    public J A()
    {
        if(B == null)
        {
            B = C();
            B.A.A(new FlatPathResolver());
        }
        return B;
    }

    private J C()
    {
        return new Q(ConfigurationImpl.getInstance());
    }

    private void A(Doc doc)
    {
        A().G().checkTags(doc, doc.tags(), false);
        A().G().checkTags(doc, doc.inlineTags(), true);
        ydoc.B.A.E e = ((Q)A()).Q;
        if(e == null)
            return;
        boolean flag = ((Q)A()).P;
        com.sun.javadoc.Tag atag[] = doc.tags(e.getName());
        if(atag.length > 0)
        {
            String s = e.toString(atag);
            if(s != null && s.length() > 0)
            {
                A().G().seenCustomTag(e.getName());
                if(flag)
                    try
                    {
                        A(s, doc);
                    }
                    catch(IOException ioexception)
                    {
                        ydoc.A.D.A(ioexception);
                    }
            }
        }
    }

    private void A(String s, Doc doc)
        throws IOException
    {
        File file;
        FileWriter filewriter;
        if(doc instanceof ClassDoc)
            file = A().A.getPathTo((ClassDoc)doc);
        else
        if(doc instanceof PackageDoc)
            file = A().A.getPathTo((PackageDoc)doc);
        else
            file = A().A.getPathTo((RootDoc)doc);
        filewriter = null;
        filewriter = new FileWriter(file);
        filewriter.write("<html>\n");
        filewriter.write(s);
        filewriter.write("</html>\n");
        if(filewriter != null)
            filewriter.close();
        break MISSING_BLOCK_LABEL_128;
        Exception exception;
        exception;
        if(filewriter != null)
            filewriter.close();
        throw exception;
    }

    private static g A;
    private J B;
}
