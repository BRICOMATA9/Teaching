// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package ydoc.doclets;

import com.sun.javadoc.AnnotationTypeDoc;
import com.sun.javadoc.AnnotationTypeElementDoc;

// Referenced classes of package ydoc.doclets:
//            M, A

final class K extends M
    implements AnnotationTypeDoc
{

    K(AnnotationTypeDoc annotationtypedoc)
    {
        super(annotationtypedoc);
    }

    private AnnotationTypeDoc H()
    {
        return (AnnotationTypeDoc)A();
    }

    public AnnotationTypeElementDoc[] elements()
    {
        return A.A(H().elements());
    }
}
