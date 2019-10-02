// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.swing;

import java.awt.Image;
import java.beans.SimpleBeanInfo;

public class JSVGCanvasBeanInfo extends SimpleBeanInfo
{

    public JSVGCanvasBeanInfo()
    {
        iconColor16x16 = loadImage("resources/batikColor16x16.gif");
        iconMono16x16 = loadImage("resources/batikMono16x16.gif");
        iconColor32x32 = loadImage("resources/batikColor32x32.gif");
        iconMono32x32 = loadImage("resources/batikMono32x32.gif");
    }

    public Image getIcon(int i)
    {
        switch(i)
        {
        case 1: // '\001'
            return iconColor16x16;

        case 3: // '\003'
            return iconMono16x16;

        case 2: // '\002'
            return iconColor32x32;

        case 4: // '\004'
            return iconMono32x32;
        }
        return null;
    }

    protected Image iconColor16x16;
    protected Image iconMono16x16;
    protected Image iconColor32x32;
    protected Image iconMono32x32;
}
