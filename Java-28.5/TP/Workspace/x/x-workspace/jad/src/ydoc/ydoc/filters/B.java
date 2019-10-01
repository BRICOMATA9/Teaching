// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package ydoc.filters;

import com.sun.javadoc.Doc;
import java.lang.reflect.Method;
import java.util.*;
import ydoc.A.D;
import ydoc.A.E;

// Referenced classes of package ydoc.filters:
//            DocFilter

public final class B
{

    public static List A(Doc adoc[])
    {
        ArrayList arraylist = new ArrayList(adoc.length);
        for(int i = 0; i < adoc.length; i++)
            if(A(adoc[i]))
                arraylist.add(adoc[i]);

        return arraylist;
    }

    public static boolean A(Doc doc)
    {
        if(doc == null)
            return true;
        for(Iterator iterator = B.iterator(); iterator.hasNext();)
            if(!((DocFilter)iterator.next()).accept(doc))
                return false;

        return true;
    }

    public static void A()
    {
        B.clear();
    }

    public static void A(DocFilter docfilter)
    {
        B.add(docfilter);
    }

    public static void A(String s, String s1)
    {
        try
        {
            int i = B.size();
            E e = E.A(s1, A);
            Class class1 = e.loadClass(s);
            Method method = class1.getMethod("register", new Class[] {
                Class.forName("java.util.List")
            });
            method.invoke(null, new Object[] {
                B
            });
            if(B.size() > i)
                D.A((new StringBuilder()).append("Registered Filter ").append(s).append(" ...").toString());
        }
        catch(Exception exception)
        {
            D.A(exception, (new StringBuilder()).append("Filter ").append(s).append(" not registered.").toString());
        }
    }

    private static ClassLoader B()
    {
        DocFilter docfilter = new DocFilter() {

            public boolean accept(Doc doc)
            {
                return true;
            }

        };
        return docfilter.getClass().getClassLoader();
    }

    private static final List B = new ArrayList();
    private static final ClassLoader A = B();

}
