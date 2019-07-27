// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package ydoc.resolvers;

import java.io.File;

// Referenced classes of package ydoc.resolvers:
//            PathResolver

abstract class B
    implements PathResolver
{

    B()
    {
        B = A;
    }

    public File getRootDirectory()
    {
        return B;
    }

    public void setRootDirectory(File file)
    {
        if(file == null)
            file = A;
        B = file;
    }

    private static final File A = new File(System.getProperty("user.dir"));
    File B;

}
