// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package ydoc.doclets;

import com.sun.javadoc.AnnotationTypeElementDoc;
import com.sun.javadoc.AnnotationValue;

// Referenced classes of package ydoc.doclets:
//            G

final class L extends G
    implements AnnotationTypeElementDoc
{

    L(AnnotationTypeElementDoc annotationtypeelementdoc)
    {
        super(annotationtypeelementdoc);
    }

    private AnnotationTypeElementDoc N()
    {
        return (AnnotationTypeElementDoc)A();
    }

    public AnnotationValue defaultValue()
    {
        return N().defaultValue();
    }
}
