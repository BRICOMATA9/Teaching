// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.freehep.graphics2d;

import java.awt.Color;

public class WebColor extends Color
{

    public WebColor(int i, int j, int k)
    {
        super(((i + 25) / 51) * 51, ((j + 25) / 51) * 51, ((k + 25) / 51) * 51);
    }

    public WebColor(Color color)
    {
        this(color.getRed(), color.getGreen(), color.getBlue());
    }

    public WebColor(float f, float f1, float f2)
    {
        this((int)(f * 255F), (int)(f1 * 255F), (int)(f2 * 255F));
    }

    public static WebColor create(Color color)
    {
        if(color == null)
            return null;
        if(color instanceof WebColor)
            return (WebColor)color;
        else
            return new WebColor(color);
    }

    private static final int space = 51;
    private static final int space2 = 25;
    public static final WebColor white;
    public static final WebColor WHITE;
    public static final WebColor lightGray;
    public static final WebColor LIGHT_GRAY;
    public static final WebColor gray;
    public static final WebColor GRAY;
    public static final WebColor darkGray;
    public static final WebColor DARK_GRAY;
    public static final WebColor black;
    public static final WebColor BLACK;
    public static final WebColor red;
    public static final WebColor RED;
    public static final WebColor pink;
    public static final WebColor PINK;
    public static final WebColor orange;
    public static final WebColor ORANGE;
    public static final WebColor yellow;
    public static final WebColor YELLOW;
    public static final WebColor green;
    public static final WebColor GREEN;
    public static final WebColor magenta;
    public static final WebColor MAGENTA;
    public static final WebColor cyan;
    public static final WebColor CYAN;
    public static final WebColor blue;
    public static final WebColor BLUE;

    static 
    {
        white = new WebColor(Color.WHITE);
        WHITE = white;
        lightGray = new WebColor(Color.LIGHT_GRAY);
        LIGHT_GRAY = lightGray;
        gray = new WebColor(Color.GRAY);
        GRAY = gray;
        darkGray = new WebColor(Color.DARK_GRAY);
        DARK_GRAY = darkGray;
        black = new WebColor(Color.BLACK);
        BLACK = black;
        red = new WebColor(Color.RED);
        RED = red;
        pink = new WebColor(Color.PINK);
        PINK = pink;
        orange = new WebColor(Color.ORANGE);
        ORANGE = orange;
        yellow = new WebColor(Color.YELLOW);
        YELLOW = yellow;
        green = new WebColor(Color.GREEN);
        GREEN = green;
        magenta = new WebColor(Color.MAGENTA);
        MAGENTA = magenta;
        cyan = new WebColor(Color.CYAN);
        CYAN = cyan;
        blue = new WebColor(Color.BLUE);
        BLUE = blue;
    }
}
