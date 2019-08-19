// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.freehep.util;

import java.io.*;
import java.util.Properties;

public class Factory
{

    private Factory()
    {
    }

    public static String findFactory(String s, String s1, String s2)
    {
        String s3 = null;
        s3 = System.getProperty(s);
        if(s3 != null)
            return s3;
        break MISSING_BLOCK_LABEL_18;
        Object obj;
        obj;
        String s4 = System.getProperty("java.home");
        String s6 = s4 + File.separator + "lib" + File.separator + s1;
        File file = new File(s6);
        if(!file.exists())
            break MISSING_BLOCK_LABEL_128;
        Properties properties = new Properties();
        properties.load(new FileInputStream(file));
        s3 = properties.getProperty(s);
        if(s3 != null)
            return s3;
        break MISSING_BLOCK_LABEL_128;
        s4;
        s4.printStackTrace();
        String s5;
        String s7;
        s5 = "meta-inf/services/" + s;
        s7 = "META-INF/services/" + s;
        ClassLoader classloader = null;
        try
        {
            classloader = Class.forName("org.freehep.util.Factory").getClassLoader();
        }
        catch(ClassNotFoundException classnotfoundexception)
        {
            classnotfoundexception.printStackTrace();
        }
        java.io.InputStream inputstream = null;
        if(classloader == null)
            inputstream = ClassLoader.getSystemResourceAsStream(s5);
        else
            inputstream = classloader.getResourceAsStream(s5);
        if(inputstream == null)
            if(classloader == null)
                inputstream = ClassLoader.getSystemResourceAsStream(s7);
            else
                inputstream = classloader.getResourceAsStream(s7);
        if(inputstream == null)
            break MISSING_BLOCK_LABEL_308;
        BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(inputstream));
        s3 = bufferedreader.readLine();
        bufferedreader.close();
        if(s3 != null && !s3.equals(""))
            return s3;
        break MISSING_BLOCK_LABEL_308;
        Exception exception;
        exception;
        exception.printStackTrace();
        return s2;
    }

    public static Object loadFactory(String s, String s1, String s2)
    {
        String s3 = findFactory(s, s1, s2);
        Class class1;
        System.out.println("Loading factory: " + s3);
        class1 = Class.forName(s3);
        return class1.newInstance();
        Exception exception;
        exception;
        System.err.println("Unable to load factory: " + s3);
        exception.printStackTrace();
        return null;
    }
}
