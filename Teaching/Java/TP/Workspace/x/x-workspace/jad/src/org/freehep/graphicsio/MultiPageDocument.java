// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.freehep.graphicsio;

import java.awt.*;
import java.io.IOException;
import org.freehep.graphics2d.TagString;

public interface MultiPageDocument
{

    public abstract void setMultiPage(boolean flag);

    public abstract boolean isMultiPage();

    public abstract void setHeader(Font font, TagString tagstring, TagString tagstring1, TagString tagstring2, int i);

    public abstract void setFooter(Font font, TagString tagstring, TagString tagstring1, TagString tagstring2, int i);

    public abstract void openPage(Component component)
        throws IOException;

    public abstract void openPage(Dimension dimension, String s)
        throws IOException;

    public abstract void closePage()
        throws IOException;
}
