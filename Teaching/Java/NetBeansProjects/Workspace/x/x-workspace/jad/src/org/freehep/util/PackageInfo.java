// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.freehep.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PackageInfo
{

    private PackageInfo()
    {
    }

    public static String getName(Class class1, String s)
    {
        return getInfo(class1, s, "TITLE");
    }

    public static String getVersion(Class class1, String s)
    {
        return getInfo(class1, s, "VERSION");
    }

    public static String getInfo(Class class1, String s, String s1)
    {
        Package package1 = class1.getPackage();
        String s2 = null;
        if(package1 != null)
            if(s1.equals("TITLE"))
                s2 = package1.getSpecificationTitle();
            else
            if(s1.equals("VERSION"))
                s2 = package1.getSpecificationVersion();
        if(s2 == null)
            try
            {
                Properties properties = new Properties();
                InputStream inputstream = class1.getResourceAsStream("/" + s + "-version.txt");
                properties.load(inputstream);
                inputstream.close();
                s2 = properties.getProperty(s1);
            }
            catch(IOException ioexception) { }
            catch(NullPointerException nullpointerexception) { }
        return s2;
    }
}
