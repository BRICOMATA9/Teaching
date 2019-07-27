// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.freehep.graphics2d;

import java.awt.Color;
import java.awt.color.ColorSpace;

public class PrintColor extends Color
{

    private static void testColorValueRange(float f)
    {
        boolean flag = false;
        String s = "";
        if(f < 0.0F || f > 1.0F)
        {
            flag = true;
            s = s + " asGray";
        }
        if(flag)
            throw new IllegalArgumentException("PrintColor parameter outside of expected range:" + s);
        else
            return;
    }

    public PrintColor(float f, float f1, float f2, float f3, boolean flag)
    {
        this(f, f1, f2, 1.0F, f3, flag);
    }

    public PrintColor(float f, float f1, float f2, float f3, float f4, boolean flag)
    {
        super(f, f1, f2, f3);
        asGray = f4;
        asBlack = flag;
        testColorValueRange(f4);
    }

    public PrintColor(Color color, float f, boolean flag)
    {
        super(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha());
        asGray = f;
        asBlack = flag;
        testColorValueRange(f);
    }

    public float getAsGray()
    {
        return asGray;
    }

    public boolean getAsBlack()
    {
        return asBlack;
    }

    public PrintColor getColor(int i)
    {
        switch(i)
        {
        case 0: // '\0'
            return this;

        case 1: // '\001'
            return new PrintColor(getAsGray(), getAsGray(), getAsGray(), (float)getAlpha() / 255F, getAsGray(), getAsBlack());

        case 2: // '\002'
            if(getAsBlack())
                return new PrintColor(Color.black, getAsGray(), getAsBlack());
            else
                return new PrintColor(Color.white, getAsGray(), getAsBlack());
        }
        throw new IllegalArgumentException("ColorMode on PrintColor out of range: " + i);
    }

    public static PrintColor createPrintColor(Color color)
    {
        if(color == null)
            return null;
        if(color instanceof PrintColor)
            return (PrintColor)color;
        float af[] = ColorSpace.getInstance(1003).fromRGB(color.getRGBComponents(null));
        if(af[0] == 0.0F)
            af[0] = 1.0F;
        else
        if(af[0] == 1.0F)
            af[0] = 0.0F;
        return new PrintColor(color, af[0], !color.equals(Color.black));
    }

    public static Color getDefaultColor(int i)
    {
        if(i < 0 || i >= defaultColors.length)
            throw new IllegalArgumentException("PrintColor.getDefaultColor index outside of expected range: " + i);
        else
            return createPrintColor(defaultColors[i]);
    }

    public static Color mixColor(Color color, Color color1)
    {
        int i = (color.getRed() + color1.getRed()) / 2;
        int j = (color.getGreen() + color1.getGreen()) / 2;
        int k = (color.getBlue() + color1.getBlue()) / 2;
        return new Color(i, j, k);
    }

    public int hashCode()
    {
        return super.hashCode();
    }

    public boolean equals(Object obj)
    {
        return super.equals(obj) && (obj instanceof PrintColor) && ((PrintColor)obj).asGray == asGray && ((PrintColor)obj).asBlack == asBlack;
    }

    public String toString()
    {
        return super.toString() + ", asGray: " + asGray + ", asBlack: " + asBlack;
    }

    public static PrintColor invert(Color color)
    {
        PrintColor printcolor = createPrintColor(color);
        return new PrintColor(new Color(printcolor.getRGB() ^ 0x808080), (printcolor.getAsGray() + 0.5F) % 1.0F, !printcolor.getAsBlack());
    }

    public static final int COLOR = 0;
    public static final int GRAYSCALE = 1;
    public static final int BLACK_AND_WHITE = 2;
    protected static Color defaultColors[];
    protected float asGray;
    protected boolean asBlack;

    static 
    {
        defaultColors = (new Color[] {
            Color.RED, Color.GREEN, Color.BLUE, Color.CYAN, Color.MAGENTA, Color.YELLOW, Color.ORANGE, Color.PINK, Color.WHITE, Color.LIGHT_GRAY, 
            Color.GRAY, Color.DARK_GRAY, Color.BLACK
        });
    }
}
