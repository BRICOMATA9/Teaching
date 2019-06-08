// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.freehep.graphicsio;


public class FontConstants
{

    private FontConstants()
    {
    }

    public static final String[] getEmbedFontsAsList()
    {
        return (new String[] {
            "Type1", "Type3"
        });
    }

    public static final String EMBED_FONTS = "EmbedFonts";
    public static final String EMBED_FONTS_AS = "EmbedFontsAs";
    public static final String EMBED_FONTS_TYPE1 = "Type1";
    public static final String EMBED_FONTS_TYPE3 = "Type3";
    public static final String TEXT_AS_SHAPES = "TEXT_AS_SHAPES";
}
