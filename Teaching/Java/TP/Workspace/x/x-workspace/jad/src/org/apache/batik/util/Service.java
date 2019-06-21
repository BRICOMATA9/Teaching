// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.util;

import java.io.*;
import java.net.URL;
import java.util.*;

public class Service
{

    public Service()
    {
    }

    public static synchronized Iterator providers(Class class1)
    {
        Object obj;
        ClassLoader classloader;
        Enumeration enumeration;
        String s = "META-INF/services/" + class1.getName();
        obj = (List)providerMap.get(s);
        if(obj != null)
            return ((List) (obj)).iterator();
        obj = new ArrayList();
        providerMap.put(s, obj);
        classloader = null;
        try
        {
            classloader = class1.getClassLoader();
        }
        catch(SecurityException securityexception) { }
        if(classloader == null)
            classloader = (org.apache.batik.util.Service.class).getClassLoader();
        if(classloader == null)
            return ((List) (obj)).iterator();
        try
        {
            enumeration = classloader.getResources(s);
        }
        catch(IOException ioexception)
        {
            return ((List) (obj)).iterator();
        }
_L4:
        if(!enumeration.hasMoreElements())
            break; /* Loop/switch isn't completed */
        BufferedReader bufferedreader;
        String s1;
        URL url = (URL)enumeration.nextElement();
        java.io.InputStream inputstream = url.openStream();
        InputStreamReader inputstreamreader = new InputStreamReader(inputstream, "UTF-8");
        bufferedreader = new BufferedReader(inputstreamreader);
        s1 = bufferedreader.readLine();
_L2:
        if(s1 == null)
            continue; /* Loop/switch isn't completed */
        int i = s1.indexOf('#');
        if(i != -1)
            s1 = s1.substring(0, i);
        s1 = s1.trim();
        if(s1.length() == 0)
        {
            s1 = bufferedreader.readLine();
            continue; /* Loop/switch isn't completed */
        }
        try
        {
            Object obj1 = classloader.loadClass(s1).newInstance();
            ((List) (obj)).add(obj1);
        }
        catch(Exception exception1) { }
        s1 = bufferedreader.readLine();
        if(true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        if(true) goto _L4; else goto _L3
_L3:
        return ((List) (obj)).iterator();
    }

    static HashMap providerMap = new HashMap();

}
