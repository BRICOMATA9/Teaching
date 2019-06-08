// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package ydoc.filters;

import com.sun.javadoc.ClassDoc;
import com.sun.javadoc.Doc;
import java.util.HashSet;
import java.util.Set;

// Referenced classes of package ydoc.filters:
//            DocFilter

public class A
    implements DocFilter
{

    public A(int i)
    {
        A = i;
        B = new HashSet(i);
    }

    public boolean accept(Doc doc)
    {
        if(doc instanceof ClassDoc)
        {
            ClassDoc classdoc = (ClassDoc)doc;
            if(classdoc.qualifiedName().startsWith("java.") || classdoc.qualifiedName().startsWith("javax."))
                return true;
            if(B.size() < A)
            {
                B.add(classdoc.qualifiedName());
                return true;
            } else
            {
                return B.contains(classdoc.qualifiedName());
            }
        } else
        {
            return true;
        }
    }

    private final int A;
    private final Set B;
}
