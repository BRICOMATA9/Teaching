// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package ydoc.doclets;

import com.sun.javadoc.*;
import ydoc.filters.B;

// Referenced classes of package ydoc.doclets:
//            V

abstract class O
    implements Doc
{

    O(Doc doc)
    {
        A = doc;
        B = null;
    }

    Doc A()
    {
        return A;
    }

    V B()
    {
        if(B == null)
            B = ydoc.doclets.V.B(A);
        return B;
    }

    public String toString()
    {
        return A.toString();
    }

    public String commentText()
    {
        return A.commentText();
    }

    public SourcePosition position()
    {
        return A.position();
    }

    public SeeTag[] seeTags()
    {
        return B().D();
    }

    public Tag[] tags()
    {
        return B().C();
    }

    public Tag[] tags(String s)
    {
        return B().A(s);
    }

    public Tag[] inlineTags()
    {
        return B().B();
    }

    public Tag[] firstSentenceTags()
    {
        return B().A();
    }

    public String getRawCommentText()
    {
        return A.getRawCommentText();
    }

    public void setRawCommentText(String s)
    {
        A.setRawCommentText(s);
    }

    public int compareTo(Object obj)
    {
        if(obj instanceof O)
            return A.compareTo(((O)obj).A());
        else
            return A.compareTo(obj);
    }

    public boolean equals(Object obj)
    {
        if(obj instanceof O)
            return A.equals(((O)obj).A());
        else
            return A.equals(obj);
    }

    public int hashCode()
    {
        return A.hashCode();
    }

    public boolean isField()
    {
        return A.isField();
    }

    public boolean isMethod()
    {
        return A.isMethod();
    }

    public boolean isConstructor()
    {
        return A.isConstructor();
    }

    public boolean isInterface()
    {
        return A.isInterface();
    }

    public boolean isException()
    {
        return A.isException();
    }

    public boolean isError()
    {
        return A.isError();
    }

    public boolean isOrdinaryClass()
    {
        return A.isOrdinaryClass();
    }

    public boolean isClass()
    {
        return A.isClass();
    }

    public String name()
    {
        return A.name();
    }

    public boolean isIncluded()
    {
        return A.isIncluded() && ydoc.filters.B.A(A);
    }

    public boolean isEnumConstant()
    {
        return A.isEnumConstant();
    }

    public boolean isAnnotationTypeElement()
    {
        return A.isAnnotationTypeElement();
    }

    public boolean isEnum()
    {
        return A.isEnum();
    }

    public boolean isAnnotationType()
    {
        return A.isAnnotationType();
    }

    private final Doc A;
    private V B;
}
