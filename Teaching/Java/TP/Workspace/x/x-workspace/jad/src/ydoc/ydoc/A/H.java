// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package ydoc.A;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

// Referenced classes of package ydoc.A:
//            D, G

public final class H
{

    public static String A(String s)
    {
        return A(s, "UTF-8");
        UnsupportedEncodingException unsupportedencodingexception;
        unsupportedencodingexception;
        D.A(unsupportedencodingexception);
        return s;
    }

    public static String A(String s, String s1)
        throws UnsupportedEncodingException
    {
        if(G.A)
            return URLDecoder.decode(s, s1);
        else
            return URLDecoder.decode(s);
    }
}
