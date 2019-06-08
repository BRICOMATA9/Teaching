// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.parser;

import org.w3c.dom.Element;

// Referenced classes of package org.apache.batik.parser:
//            ParseException, LengthParser, LengthHandler

public abstract class UnitProcessor
{
    public static interface Context
    {

        public abstract Element getElement();

        public abstract float getPixelUnitToMillimeter();

        public abstract float getPixelToMM();

        public abstract float getFontSize();

        public abstract float getXHeight();

        public abstract float getViewportWidth();

        public abstract float getViewportHeight();
    }

    public static class UnitResolver
        implements LengthHandler
    {

        public void startLength()
            throws ParseException
        {
        }

        public void lengthValue(float f)
            throws ParseException
        {
            value = f;
        }

        public void em()
            throws ParseException
        {
            unit = 3;
        }

        public void ex()
            throws ParseException
        {
            unit = 4;
        }

        public void in()
            throws ParseException
        {
            unit = 8;
        }

        public void cm()
            throws ParseException
        {
            unit = 6;
        }

        public void mm()
            throws ParseException
        {
            unit = 7;
        }

        public void pc()
            throws ParseException
        {
            unit = 10;
        }

        public void pt()
            throws ParseException
        {
            unit = 9;
        }

        public void px()
            throws ParseException
        {
            unit = 5;
        }

        public void percentage()
            throws ParseException
        {
            unit = 2;
        }

        public void endLength()
            throws ParseException
        {
        }

        public float value;
        public short unit;

        public UnitResolver()
        {
            unit = 1;
        }
    }


    protected UnitProcessor()
    {
    }

    public static float svgToObjectBoundingBox(String s, String s1, short word0, Context context)
        throws ParseException
    {
        LengthParser lengthparser = new LengthParser();
        UnitResolver unitresolver = new UnitResolver();
        lengthparser.setLengthHandler(unitresolver);
        lengthparser.parse(s);
        return svgToObjectBoundingBox(unitresolver.value, unitresolver.unit, word0, context);
    }

    public static float svgToObjectBoundingBox(float f, short word0, short word1, Context context)
    {
        switch(word0)
        {
        case 1: // '\001'
            return f;

        case 2: // '\002'
            return f / 100F;

        case 3: // '\003'
        case 4: // '\004'
        case 5: // '\005'
        case 6: // '\006'
        case 7: // '\007'
        case 8: // '\b'
        case 9: // '\t'
        case 10: // '\n'
            return svgToUserSpace(f, word0, word1, context);
        }
        throw new Error();
    }

    public static float svgToUserSpace(String s, String s1, short word0, Context context)
        throws ParseException
    {
        LengthParser lengthparser = new LengthParser();
        UnitResolver unitresolver = new UnitResolver();
        lengthparser.setLengthHandler(unitresolver);
        lengthparser.parse(s);
        return svgToUserSpace(unitresolver.value, unitresolver.unit, word0, context);
    }

    public static float svgToUserSpace(float f, short word0, short word1, Context context)
    {
        switch(word0)
        {
        case 1: // '\001'
        case 5: // '\005'
            return f;

        case 7: // '\007'
            return f / context.getPixelUnitToMillimeter();

        case 6: // '\006'
            return (f * 10F) / context.getPixelUnitToMillimeter();

        case 8: // '\b'
            return (f * 25.4F) / context.getPixelUnitToMillimeter();

        case 9: // '\t'
            return (f * 25.4F) / (72F * context.getPixelUnitToMillimeter());

        case 10: // '\n'
            return (f * 25.4F) / (6F * context.getPixelUnitToMillimeter());

        case 3: // '\003'
            return emsToPixels(f, word1, context);

        case 4: // '\004'
            return exsToPixels(f, word1, context);

        case 2: // '\002'
            return percentagesToPixels(f, word1, context);
        }
        throw new Error();
    }

    public static float userSpaceToSVG(float f, short word0, short word1, Context context)
    {
        switch(word0)
        {
        case 1: // '\001'
        case 5: // '\005'
            return f;

        case 7: // '\007'
            return f * context.getPixelUnitToMillimeter();

        case 6: // '\006'
            return (f * context.getPixelUnitToMillimeter()) / 10F;

        case 8: // '\b'
            return (f * context.getPixelUnitToMillimeter()) / 25.4F;

        case 9: // '\t'
            return (f * (72F * context.getPixelUnitToMillimeter())) / 25.4F;

        case 10: // '\n'
            return (f * (6F * context.getPixelUnitToMillimeter())) / 25.4F;

        case 3: // '\003'
            return pixelsToEms(f, word1, context);

        case 4: // '\004'
            return pixelsToExs(f, word1, context);

        case 2: // '\002'
            return pixelsToPercentages(f, word1, context);
        }
        throw new Error();
    }

    protected static float percentagesToPixels(float f, short word0, Context context)
    {
        if(word0 == 2)
        {
            float f1 = context.getViewportWidth();
            return (f1 * f) / 100F;
        }
        if(word0 == 1)
        {
            float f2 = context.getViewportHeight();
            return (f2 * f) / 100F;
        } else
        {
            double d = context.getViewportWidth();
            double d1 = context.getViewportHeight();
            double d2 = Math.sqrt(d * d + d1 * d1) / Math.sqrt(2D);
            return (float)((d2 * (double)f) / 100D);
        }
    }

    protected static float pixelsToPercentages(float f, short word0, Context context)
    {
        if(word0 == 2)
        {
            float f1 = context.getViewportWidth();
            return (f * 100F) / f1;
        }
        if(word0 == 1)
        {
            float f2 = context.getViewportHeight();
            return (f * 100F) / f2;
        } else
        {
            double d = context.getViewportWidth();
            double d1 = context.getViewportHeight();
            double d2 = Math.sqrt(d * d + d1 * d1) / Math.sqrt(2D);
            return (float)(((double)f * 100D) / d2);
        }
    }

    protected static float pixelsToEms(float f, short word0, Context context)
    {
        return f / context.getFontSize();
    }

    protected static float emsToPixels(float f, short word0, Context context)
    {
        return f * context.getFontSize();
    }

    protected static float pixelsToExs(float f, short word0, Context context)
    {
        float f1 = context.getXHeight();
        return f / f1 / context.getFontSize();
    }

    protected static float exsToPixels(float f, short word0, Context context)
    {
        float f1 = context.getXHeight();
        return f * f1 * context.getFontSize();
    }

    public static final short HORIZONTAL_LENGTH = 2;
    public static final short VERTICAL_LENGTH = 1;
    public static final short OTHER_LENGTH = 0;
}
