// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.freehep.util;

import java.io.*;
import java.net.URL;
import java.util.*;

public class Service
{

    private Service()
    {
    }

    public static Collection providers(Class class1, ClassLoader classloader)
    {
        ArrayList arraylist;
        ArrayList arraylist1;
        Enumeration enumeration;
        arraylist = new ArrayList();
        arraylist1 = new ArrayList();
        String s = "META-INF/services/" + class1.getName();
        try
        {
            enumeration = classloader != null ? classloader.getResources(s) : ClassLoader.getSystemResources(s);
        }
        catch(IOException ioexception)
        {
            System.err.println("Service: cannot load " + s);
            return arraylist;
        }
_L2:
        URL url;
        InputStream inputstream;
        BufferedReader bufferedreader;
        if(!enumeration.hasMoreElements())
            break; /* Loop/switch isn't completed */
        url = (URL)enumeration.nextElement();
        inputstream = null;
        bufferedreader = null;
        inputstream = url.openStream();
        bufferedreader = new BufferedReader(new InputStreamReader(inputstream, "utf-8"));
        for(String s2 = bufferedreader.readLine(); s2 != null; s2 = bufferedreader.readLine())
        {
            int i = s2.indexOf('#');
            if(i >= 0)
                s2 = s2.substring(0, i);
            s2 = s2.trim();
            int j = s2.indexOf(' ');
            if(j >= 0)
                s2 = s2.substring(0, j);
            s2 = s2.trim();
            if(s2.length() > 0 && !arraylist1.contains(s2))
                arraylist1.add(s2);
        }

        try
        {
            if(inputstream != null)
                inputstream.close();
            if(bufferedreader != null)
                bufferedreader.close();
        }
        catch(IOException ioexception1)
        {
            System.err.println("Service: problem with: " + url);
        }
        continue; /* Loop/switch isn't completed */
        IOException ioexception2;
        ioexception2;
        System.err.println("Service: problem with: " + url);
        try
        {
            if(inputstream != null)
                inputstream.close();
            if(bufferedreader != null)
                bufferedreader.close();
        }
        catch(IOException ioexception3)
        {
            System.err.println("Service: problem with: " + url);
        }
        if(true) goto _L2; else goto _L1
        Exception exception1;
        exception1;
        try
        {
            if(inputstream != null)
                inputstream.close();
            if(bufferedreader != null)
                bufferedreader.close();
        }
        catch(IOException ioexception4)
        {
            System.err.println("Service: problem with: " + url);
        }
        throw exception1;
_L1:
        for(Iterator iterator = arraylist1.iterator(); iterator.hasNext();)
        {
            String s1 = (String)iterator.next();
            try
            {
                arraylist.add(Class.forName(s1, true, classloader).newInstance());
            }
            catch(ClassNotFoundException classnotfoundexception)
            {
                System.err.println("Service: cannot find class: " + s1);
            }
            catch(InstantiationException instantiationexception)
            {
                System.err.println("Service: cannot instantiate: " + s1);
            }
            catch(IllegalAccessException illegalaccessexception)
            {
                System.err.println("Service: illegal access to: " + s1);
            }
            catch(NoClassDefFoundError noclassdeffounderror)
            {
                System.err.println("Service: " + noclassdeffounderror + " for " + s1);
            }
            catch(Exception exception)
            {
                System.err.println("Service: exception for: " + s1 + " " + exception);
            }
        }

        return arraylist;
    }

    public static Collection providers(Class class1)
    {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        return providers(class1, classloader);
    }

    public static Collection installedProviders(Class class1)
    {
        ClassLoader classloader = ClassLoader.getSystemClassLoader();
        ClassLoader classloader1 = null;
        for(; classloader != null; classloader = classloader.getParent())
            classloader1 = classloader;

        return providers(class1, classloader1);
    }
}
