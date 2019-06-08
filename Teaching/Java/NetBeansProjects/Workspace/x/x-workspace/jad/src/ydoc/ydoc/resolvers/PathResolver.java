// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package ydoc.resolvers;

import com.sun.javadoc.*;
import java.io.File;

public interface PathResolver
{

    public abstract File getRootDirectory();

    public abstract void setRootDirectory(File file);

    public abstract File getPathTo(RootDoc rootdoc);

    public abstract File getPathTo(RootDoc rootdoc, String s, String s1);

    public abstract File getPathTo(PackageDoc packagedoc);

    public abstract File getPathTo(PackageDoc packagedoc, String s, String s1);

    public abstract File getPathTo(ClassDoc classdoc);

    public abstract File getPathTo(ClassDoc classdoc, String s, String s1);
}
