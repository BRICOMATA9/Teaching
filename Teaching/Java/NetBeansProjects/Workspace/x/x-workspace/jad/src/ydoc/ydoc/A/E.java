// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package ydoc.A;

import java.io.File;
import java.io.IOException;
import java.net.*;
import java.util.StringTokenizer;

public class E extends URLClassLoader
{

    public static E B(String s, String s1)
    {
        return A(A(s, s1), null, true);
    }

    public static E A(String s, ClassLoader classloader)
    {
        return A(s, classloader, true);
    }

    public static E A(String s, ClassLoader classloader, boolean flag)
    {
        String s1 = null;
        if(flag)
        {
            s1 = A(System.getProperty("env.class.path"), s1);
            s1 = A(System.getProperty("java.class.path"), s1);
        }
        s1 = A(s, s1);
        return new E(A(s1), classloader);
    }

    private E(URL aurl[], ClassLoader classloader)
    {
        super(aurl, classloader);
    }

    private static String A(String s, String s1)
    {
        if(s == null || s.length() == 0)
            return s1 == null ? "." : s1;
        if(s1 == null || s1.length() == 0)
            return s;
        else
            return (new StringBuilder()).append(s).append(File.pathSeparator).append(s1).toString();
    }

    private static URL[] A(String s)
    {
        StringTokenizer stringtokenizer = new StringTokenizer(s, File.pathSeparator);
        URL aurl[] = new URL[stringtokenizer.countTokens()];
        int i = 0;
        do
        {
            if(!stringtokenizer.hasMoreTokens())
                break;
            URL url = A(new File(stringtokenizer.nextToken()));
            if(url != null)
                aurl[i++] = url;
        } while(true);
        if(aurl.length != i)
        {
            URL aurl1[] = new URL[i];
            System.arraycopy(aurl, 0, aurl1, 0, i);
            aurl = aurl1;
        }
        return aurl;
    }

    private static URL A(File file)
    {
        String s;
        try
        {
            s = file.getCanonicalPath();
        }
        catch(IOException ioexception)
        {
            s = file.getAbsolutePath();
        }
        s = s.replace(File.separatorChar, '/');
        if(!s.startsWith("/"))
            s = (new StringBuilder()).append("/").append(s).toString();
        if(!file.isFile())
            s = (new StringBuilder()).append(s).append("/").toString();
        return new URL("file", "", s);
        MalformedURLException malformedurlexception;
        malformedurlexception;
        throw new IllegalArgumentException("file");
    }
}
