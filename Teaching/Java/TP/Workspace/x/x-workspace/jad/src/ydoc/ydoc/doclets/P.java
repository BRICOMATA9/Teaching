// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package ydoc.doclets;

import com.sun.javadoc.*;
import com.sun.tools.doclets.internal.toolkit.util.DirectoryManager;
import java.io.File;
import ydoc.A.D;
import ydoc.A.E;
import ydoc.resolvers.PathResolver;
import ydoc.resolvers.StandardPathResolver;

// Referenced classes of package ydoc.doclets:
//            J

public class P
    implements PathResolver
{

    P()
    {
        this("PathResolver", ((PathResolver) (new StandardPathResolver())));
    }

    P(String s, PathResolver pathresolver)
    {
        D = s;
        E = pathresolver;
    }

    public void A(PathResolver pathresolver)
    {
        E = pathresolver;
    }

    public File getRootDirectory()
    {
        return E.getRootDirectory();
    }

    public void setRootDirectory(File file)
    {
        E.setRootDirectory(file);
    }

    public File getPathTo(RootDoc rootdoc)
    {
        return E.getPathTo(rootdoc);
    }

    public File getPathTo(RootDoc rootdoc, String s, String s1)
    {
        return E.getPathTo(rootdoc, s, s1);
    }

    public File getPathTo(PackageDoc packagedoc)
    {
        return E.getPathTo(packagedoc);
    }

    public File getPathTo(PackageDoc packagedoc, String s, String s1)
    {
        return E.getPathTo(packagedoc, s, s1);
    }

    public File getPathTo(ClassDoc classdoc)
    {
        return E.getPathTo(classdoc);
    }

    public File getPathTo(ClassDoc classdoc, String s, String s1)
    {
        return E.getPathTo(classdoc, s, s1);
    }

    public void A(J j, File file)
    {
        DirectoryManager.createDirectory(j, file.getAbsolutePath());
    }

    void A(String s, String s1)
    {
        try
        {
            E e = ydoc.A.E.A(s1, getClass().getClassLoader());
            Class class1 = e.loadClass(s);
            E = (PathResolver)class1.newInstance();
            String s3 = (new StringBuilder()).append("Registered ").append(D).append(" ").append(s).append(" ...").toString();
            ydoc.A.D.A(s3);
        }
        catch(Exception exception)
        {
            String s2 = (new StringBuilder()).append(D).append(" ").append(s).append(" not registered.").toString();
            ydoc.A.D.A(exception, s2);
        }
    }

    private final String D;
    private PathResolver E;
}
