// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package ydoc.filters;

import com.sun.javadoc.Doc;
import java.util.List;

// Referenced classes of package ydoc.filters:
//            DocFilter

public class ExcludeFilter
    implements DocFilter
{

    public ExcludeFilter()
    {
    }

    public boolean accept(Doc doc)
    {
        return doc.tags("y.exclude").length <= 0;
    }

    public static void register(List list)
    {
        list.add(new ExcludeFilter());
    }
}
