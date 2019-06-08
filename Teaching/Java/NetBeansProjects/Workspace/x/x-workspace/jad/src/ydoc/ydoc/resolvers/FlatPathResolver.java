// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package ydoc.resolvers;

import com.sun.javadoc.*;
import java.io.File;

// Referenced classes of package ydoc.resolvers:
//            B

public class FlatPathResolver extends B
{

    public FlatPathResolver()
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
        return new File(B, (new StringBuilder()).append(packagedoc.name()).append(s).append(s1).toString());
    }

    public File getPathTo(ClassDoc classdoc)
    {
        return getPathTo(classdoc, "", ".html");
    }

    public File getPathTo(ClassDoc classdoc, String s, String s1)
    {
        return new File(B, (new StringBuilder()).append(classdoc.qualifiedName()).append(s).append(s1).toString());
    }
}
