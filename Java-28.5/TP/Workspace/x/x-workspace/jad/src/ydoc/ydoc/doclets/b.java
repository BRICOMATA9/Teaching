// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package ydoc.doclets;

import com.sun.javadoc.ClassDoc;
import com.sun.javadoc.SerialFieldTag;

// Referenced classes of package ydoc.doclets:
//            E, A

class b extends E
    implements SerialFieldTag
{

    public b(SerialFieldTag serialfieldtag)
    {
        super(serialfieldtag);
    }

    private SerialFieldTag C()
    {
        return (SerialFieldTag)A();
    }

    public String fieldName()
    {
        return C().fieldName();
    }

    public String fieldType()
    {
        return C().fieldType();
    }

    public ClassDoc fieldTypeDoc()
    {
        return A.B(C().fieldTypeDoc());
    }

    public String description()
    {
        return C().description();
    }

    public int compareTo(Object obj)
    {
        if(obj instanceof b)
            return C().compareTo(((b)obj).C());
        else
            return C().compareTo(obj);
    }
}
