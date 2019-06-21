// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package ydoc.B;

import com.sun.javadoc.Tag;

// Referenced classes of package ydoc.B:
//            C

public class G extends C
{

    public G()
    {
        super(null);
    }

    public String getName()
    {
        return "y.eval";
    }

    public String toString(Tag atag[])
    {
        if(atag.length > 0)
            return C;
        else
            return "";
    }

    private final String C = (new StringBuilder()).append("<DT><hr><center><h1>").append(B()).append("</h1></center><hr></DT><DD></DD>\n").toString();
}
