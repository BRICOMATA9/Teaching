// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package ydoc.B;

import com.sun.javadoc.Tag;

// Referenced classes of package ydoc.B:
//            C, D

public final class A extends C
{
    private static class _B
        implements D
    {

        public String A(Tag atag[], String s)
        {
            if(atag.length > 0)
                return (new StringBuilder()).append("<!-- ").append(C.B()).append("   ").append(C.C()).append("   ").append(B).append("...").append(" -->").append("\n").toString();
            else
                return "";
        }

        private final String B;

        _B(String s)
        {
            B = s;
        }
    }

    private static class _A
        implements D
    {

        public String A(Tag atag[], String s)
        {
            if(atag.length > 0)
                return (new StringBuilder()).append("<DT><a href=\"").append(C.C()).append("\">").append(C.B()).append("</a>").append("<!-- ").append(A).append("...").append(" -->").append("</DT>").append("<DD></DD>\n").append("\n").toString();
            else
                return "";
        }

        private final String A;

        _A(String s)
        {
            A = s;
        }
    }


    public A(String s)
    {
        this(s, false);
    }

    public A(String s, boolean flag)
    {
        super(((D) (flag ? ((D) (new _A(s))) : ((D) (new _B(s))))));
    }

    public String getName()
    {
        return "y.promo";
    }
}
