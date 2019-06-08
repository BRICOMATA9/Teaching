// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package ydoc.doclets;

import com.sun.javadoc.*;

// Referenced classes of package ydoc.doclets:
//            O, A

final class U extends O
    implements RootDoc
{

    U(RootDoc rootdoc)
    {
        super(rootdoc);
    }

    private RootDoc C()
    {
        return (RootDoc)A();
    }

    String[][] D()
    {
        return C().options();
    }

    public ClassDoc[] classes()
    {
        return A.A(C().classes());
    }

    public ClassDoc classNamed(String s)
    {
        return A.B(C().classNamed(s));
    }

    public PackageDoc packageNamed(String s)
    {
        return A.A(C().packageNamed(s));
    }

    public ClassDoc[] specifiedClasses()
    {
        return A.A(C().specifiedClasses());
    }

    public PackageDoc[] specifiedPackages()
    {
        return A.A(C().specifiedPackages());
    }

    public String[][] options()
    {
        String as[][] = C().options();
        String as1[][] = new String[as.length][];
        int i = 0;
        for(int j = 0; j < as.length; j++)
        {
            String s = as[j][0].toLowerCase();
            if(!"-tag".equals(s) && !"-taglet".equals(s) && !"-tagletpath".equals(s))
                as1[i++] = as[j];
        }

        String as2[][] = new String[i][];
        System.arraycopy(as1, 0, as2, 0, i);
        return as2;
    }

    public void printError(SourcePosition sourceposition, String s)
    {
        C().printError(sourceposition, s);
    }

    public void printError(String s)
    {
        C().printError(s);
    }

    public void printWarning(SourcePosition sourceposition, String s)
    {
        C().printWarning(sourceposition, s);
    }

    public void printWarning(String s)
    {
        C().printWarning(s);
    }

    public void printNotice(SourcePosition sourceposition, String s)
    {
        C().printNotice(sourceposition, s);
    }

    public void printNotice(String s)
    {
        C().printNotice(s);
    }
}
