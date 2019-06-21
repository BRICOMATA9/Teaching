// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.bridge;

import java.net.URL;
import java.net.URLClassLoader;
import java.security.*;
import java.util.Enumeration;

public class DocumentJarClassLoader extends URLClassLoader
{

    public DocumentJarClassLoader(URL url, URL url1)
    {
        super(new URL[] {
            url
        });
        documentCodeSource = null;
        if(url1 != null)
            documentCodeSource = new CodeSource(url1, (java.security.cert.Certificate[])null);
    }

    protected PermissionCollection getPermissions(CodeSource codesource)
    {
        Policy policy = Policy.getPolicy();
        PermissionCollection permissioncollection = null;
        if(policy != null)
            permissioncollection = policy.getPermissions(codesource);
        if(documentCodeSource != null)
        {
            PermissionCollection permissioncollection1 = super.getPermissions(documentCodeSource);
            if(permissioncollection != null)
            {
                for(Enumeration enumeration = permissioncollection1.elements(); enumeration.hasMoreElements(); permissioncollection.add((Permission)enumeration.nextElement()));
            } else
            {
                permissioncollection = permissioncollection1;
            }
        }
        return permissioncollection;
    }

    protected CodeSource documentCodeSource;
}
