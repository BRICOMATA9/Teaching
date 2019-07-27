// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package ydoc.resolvers;

import com.sun.javadoc.*;
import com.sun.tools.doclets.internal.toolkit.util.DirectoryManager;
import java.io.File;

// Referenced classes of package ydoc.resolvers:
//            B

public class StandardPathResolver extends B
{

    public StandardPathResolver()
    {
    }

    public File getPathTo(RootDoc rootdoc)
    {
        return getPathTo(rootdoc, "-summary", ".html");
    }

    public File getPathTo(RootDoc rootdoc, String s, String s1)
    {
        return new File(B, (new StringBuilder()).append("overview").append(s).append(s1).toString());
    }

    public File getPathTo(PackageDoc packagedoc)
    {
        return getPathTo(packagedoc, "-summary", ".html");
    }

    public File getPathTo(PackageDoc packagedoc, String s, String s1)
    {
        return new File(B, DirectoryManager.getPathToPackage(packagedoc, (new StringBuilder()).append("package").append(s).append(s1).toString()));
    }

    public File getPathTo(ClassDoc classdoc)
    {
        return new File(B, DirectoryManager.getPathToClass(classdoc));
    }

    public File getPathTo(ClassDoc classdoc, String s, String s1)
    {
        return new File(B, DirectoryManager.getPathToPackage(classdoc.containingPackage(), (new StringBuilder()).append(classdoc.name()).append(s).append(s1).toString()));
    }
}
