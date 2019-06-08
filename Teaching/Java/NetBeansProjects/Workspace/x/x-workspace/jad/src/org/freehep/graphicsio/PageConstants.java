// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.freehep.graphicsio;

import java.awt.Dimension;
import java.awt.Insets;
import java.util.HashMap;
import java.util.Map;

public class PageConstants
{

    private PageConstants()
    {
    }

    public static final String[] getOrientationList()
    {
        return (new String[] {
            "Portrait", "Landscape"
        });
    }

    public static final String[] getSizeList()
    {
        return (new String[] {
            "International", "A4", "Letter", "A3", "Legal", "A5", "A6", "Executive", "Ledger"
        });
    }

    public static final Dimension getSize(String s)
    {
        return getSize(s, "Portrait");
    }

    public static final Dimension getSize(String s, String s1)
    {
        Dimension dimension = (Dimension)sizeTable.get(s);
        if(s1.equals("Portrait"))
            return dimension;
        else
            return new Dimension(dimension.height, dimension.width);
    }

    public static final Insets getMargins(String s)
    {
        return (Insets)marginTable.get(s);
    }

    public static final Insets getMargins(Insets insets, String s)
    {
        if(s.equals("Portrait"))
            return insets;
        else
            return new Insets(insets.left, insets.bottom, insets.right, insets.top);
    }

    public static final String ORIENTATION = "Orientation";
    public static final String PORTRAIT = "Portrait";
    public static final String LANDSCAPE = "Landscape";
    public static final String BEST_FIT = "Best Fit";
    public static final String PAGE_SIZE = "PageSize";
    public static final String INTERNATIONAL = "International";
    public static final String A3 = "A3";
    public static final String A4 = "A4";
    public static final String A5 = "A5";
    public static final String A6 = "A6";
    public static final String CUSTOM_PAGE_SIZE = "Custom PageSize";
    public static final String LETTER = "Letter";
    public static final String LEGAL = "Legal";
    public static final String EXECUTIVE = "Executive";
    public static final String LEDGER = "Ledger";
    private static final Map sizeTable;
    public static final String PAGE_MARGINS = "PageMargins";
    public static final String SMALL = "Small";
    public static final String MEDIUM = "Medium";
    public static final String LARGE = "Large";
    private static final Map marginTable;
    public static final String FIT_TO_PAGE = "FitToPage";
    public static final String TRANSPARENT = "Transparent";
    public static final String BACKGROUND = "Background";
    public static final String BACKGROUND_COLOR = "BackgroundColor";

    static 
    {
        sizeTable = new HashMap();
        sizeTable.put("International", new Dimension(595, 791));
        sizeTable.put("A3", new Dimension(842, 1191));
        sizeTable.put("A4", new Dimension(595, 842));
        sizeTable.put("A5", new Dimension(420, 595));
        sizeTable.put("A6", new Dimension(298, 420));
        sizeTable.put("Letter", new Dimension(612, 791));
        sizeTable.put("Legal", new Dimension(612, 1009));
        sizeTable.put("Executive", new Dimension(539, 720));
        sizeTable.put("Ledger", new Dimension(791, 1225));
        marginTable = new HashMap();
        marginTable.put("Small", new Insets(20, 20, 20, 20));
        marginTable.put("Medium", new Insets(30, 30, 30, 30));
        marginTable.put("Large", new Insets(40, 40, 40, 40));
    }
}
