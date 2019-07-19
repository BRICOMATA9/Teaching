// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package ydoc.doclets;

import com.sun.javadoc.*;

// Referenced classes of package ydoc.doclets:
//            A

final class Z
    implements AnnotationDesc
{
    static class _A
        implements com.sun.javadoc.AnnotationDesc.ElementValuePair
    {

        public boolean equals(Object obj)
        {
            if(obj instanceof _A)
                A.equals(((_A)obj).A);
            return A.equals(obj);
        }

        public int hashCode()
        {
            return A.hashCode();
        }

        public String toString()
        {
            return A.toString();
        }

        public AnnotationTypeElementDoc element()
        {
            return ydoc.doclets.A.B(A.element());
        }

        public AnnotationValue value()
        {
            return A.value();
        }

        private final com.sun.javadoc.AnnotationDesc.ElementValuePair A;

        public _A(com.sun.javadoc.AnnotationDesc.ElementValuePair elementvaluepair)
        {
            A = elementvaluepair;
        }
    }


    public Z(AnnotationDesc annotationdesc)
    {
        A = annotationdesc;
    }

    public boolean equals(Object obj)
    {
        if(obj instanceof Z)
            A.equals(((Z)obj).A);
        return A.equals(obj);
    }

    public int hashCode()
    {
        return A.hashCode();
    }

    public String toString()
    {
        return A.toString();
    }

    public AnnotationTypeDoc annotationType()
    {
        return ydoc.doclets.A.B(A.annotationType());
    }

    public com.sun.javadoc.AnnotationDesc.ElementValuePair[] elementValues()
    {
        return ydoc.doclets.A.A(A.elementValues());
    }

    private final AnnotationDesc A;
}
