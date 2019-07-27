// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.freehep.graphics2d;

import java.awt.Dimension;
import java.util.HashMap;
import java.util.Map;

public class ScreenConstants
{

    public ScreenConstants()
    {
    }

    public static Dimension getSize(String s)
    {
        Dimension dimension = (Dimension)sizes.get(s);
        return dimension == null ? UNDEFINED : dimension;
    }

    public static final String VGA = "600x480";
    public static final String SVGA = "800x600";
    public static final String XGA = "1024x768";
    public static final String SXGA = "1280x1024";
    public static final String SXGA_PLUS = "1400x1050";
    public static final String UXGA = "1600x1200";
    public static final String WSXGA_PLUS = "1680x1050";
    public static final String WUXGA = "1920x1200";
    private static Dimension UNDEFINED = new Dimension(0, 0);
    private static final Map sizes;

    static 
    {
        sizes = new HashMap();
        sizes.put("600x480", new Dimension(640, 480));
        sizes.put("800x600", new Dimension(800, 600));
        sizes.put("1024x768", new Dimension(1024, 768));
        sizes.put("1280x1024", new Dimension(1280, 1024));
        sizes.put("1400x1050", new Dimension(1400, 1050));
        sizes.put("1600x1200", new Dimension(1600, 1200));
    }
}
