// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.util;

import java.net.URL;
import java.security.Policy;

// Referenced classes of package org.apache.batik.util:
//            Messages, BatikSecurityManager

public class ApplicationSecurityEnforcer
{

    public ApplicationSecurityEnforcer(Class class1, String s, String s1)
    {
        ApplicationSecurityEnforcer(class1, s);
    }

    public ApplicationSecurityEnforcer(Class class1, String s)
    {
        appMainClass = class1;
        securityPolicy = s;
        appMainClassRelativeURL = class1.getName().replace('.', '/') + ".class";
    }

    public void enforceSecurity(boolean flag)
    {
        SecurityManager securitymanager = System.getSecurityManager();
        if(securitymanager != null && securitymanager != lastSecurityManagerInstalled)
            throw new SecurityException(Messages.getString("ApplicationSecurityEnforcer.message.security.exception.alien.security.manager"));
        if(flag)
        {
            System.setSecurityManager(null);
            installSecurityManager();
        } else
        if(securitymanager != null)
        {
            System.setSecurityManager(null);
            lastSecurityManagerInstalled = null;
        }
    }

    public URL getPolicyURL()
    {
        ClassLoader classloader = appMainClass.getClassLoader();
        URL url = classloader.getResource(securityPolicy);
        if(url == null)
            throw new NullPointerException(Messages.formatMessage("ApplicationSecurityEnforcer.message.null.pointer.exception.no.policy.file", new Object[] {
                securityPolicy
            }));
        else
            return url;
    }

    public void installSecurityManager()
    {
        Policy policy = Policy.getPolicy();
        BatikSecurityManager batiksecuritymanager = new BatikSecurityManager();
        ClassLoader classloader = appMainClass.getClassLoader();
        String s = System.getProperty("java.security.policy");
        if(s == null || s.equals(""))
        {
            URL url = getPolicyURL();
            System.setProperty("java.security.policy", url.toString());
        }
        URL url1 = classloader.getResource(appMainClassRelativeURL);
        if(url1 == null)
            throw new Error(appMainClassRelativeURL);
        String s1 = url1.toString();
        if(s1.startsWith("jar:"))
            setJarBase(s1);
        else
            setDevBase(s1);
        System.setSecurityManager(batiksecuritymanager);
        lastSecurityManagerInstalled = batiksecuritymanager;
        policy.refresh();
        if(s == null || s.equals(""))
            System.setProperty("java.security.policy", "");
    }

    private void setJarBase(String s)
    {
        String s1 = System.getProperty("app.jar.base");
        if(s1 == null)
        {
            s = s.substring("jar:".length());
            int i = s.indexOf("!/" + appMainClassRelativeURL);
            if(i == -1)
                throw new Error();
            String s2 = s.substring(0, i);
            i = s2.lastIndexOf('/');
            if(i == -1)
                s2 = "";
            else
                s2 = s2.substring(0, i);
            System.setProperty("app.jar.base", s2);
        }
    }

    private void setDevBase(String s)
    {
        String s1 = System.getProperty("app.dev.base");
        if(s1 == null)
        {
            int i = s.indexOf("classes/" + appMainClassRelativeURL);
            if(i == -1)
                throw new Error();
            String s2 = s.substring(0, i);
            System.setProperty("app.dev.base", s2);
        }
    }

    public static final String EXCEPTION_ALIEN_SECURITY_MANAGER = "ApplicationSecurityEnforcer.message.security.exception.alien.security.manager";
    public static final String EXCEPTION_NO_POLICY_FILE = "ApplicationSecurityEnforcer.message.null.pointer.exception.no.policy.file";
    public static final String PROPERTY_JAVA_SECURITY_POLICY = "java.security.policy";
    public static final String JAR_PROTOCOL = "jar:";
    public static final String JAR_URL_FILE_SEPARATOR = "!/";
    public static final String PROPERTY_APP_DEV_BASE = "app.dev.base";
    public static final String PROPERTY_APP_JAR_BASE = "app.jar.base";
    public static final String APP_MAIN_CLASS_DIR = "classes/";
    protected Class appMainClass;
    protected String securityPolicy;
    protected String appMainClassRelativeURL;
    protected BatikSecurityManager lastSecurityManagerInstalled;
}
