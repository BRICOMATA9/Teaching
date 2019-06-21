// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.freehep.util;

import java.text.*;
import java.util.Locale;

// Referenced classes of package org.freehep.util:
//            DoubleWithError

public class ScientificFormat extends Format
{

    public ScientificFormat()
    {
        sigDigit = 5;
        maxWidth = 8;
        sciNote = false;
    }

    public ScientificFormat(int i, int j, boolean flag)
    {
        sigDigit = 5;
        maxWidth = 8;
        sciNote = false;
        setSigDigits(i);
        setMaxWidth(j);
        setScientificNotationStyle(flag);
    }

    public StringBuffer format(Object obj, StringBuffer stringbuffer, FieldPosition fieldposition)
    {
        if(obj instanceof Number)
        {
            String s = format(((Number)obj).doubleValue());
            return stringbuffer.append(s);
        }
        if(obj instanceof DoubleWithError)
        {
            DoubleWithError doublewitherror = (DoubleWithError)obj;
            stringbuffer.append(format(doublewitherror.getValue()));
            if(doublewitherror.hasAsymmetricError())
            {
                stringbuffer.append('+');
                int i = resolveErrorSigDigit(doublewitherror.getValue(), doublewitherror.getPlusError());
                stringbuffer.append(format(doublewitherror.getPlusError(), i));
                stringbuffer.append('-');
                i = resolveErrorSigDigit(doublewitherror.getValue(), doublewitherror.getMinError());
                stringbuffer.append(format(doublewitherror.getMinError(), i));
            } else
            {
                stringbuffer.append('\261');
                int j = resolveErrorSigDigit(doublewitherror.getValue(), doublewitherror.getError());
                stringbuffer.append(format(doublewitherror.getError(), j));
            }
            return stringbuffer;
        } else
        {
            throw new IllegalArgumentException("Cannot format given Object as a Number");
        }
    }

    public Object parseObject(String s, ParsePosition parseposition)
    {
        return null;
    }

    public int getSigDigits()
    {
        return sigDigit;
    }

    public int getMaxWidth()
    {
        return maxWidth;
    }

    public boolean getScientificNotationStyle()
    {
        return sciNote;
    }

    public void setSigDigits(int i)
    {
        if(i < 1)
        {
            throw new IllegalArgumentException("sigDigit");
        } else
        {
            sigDigit = i;
            decimalFormat = null;
            return;
        }
    }

    public void setMaxWidth(int i)
    {
        if(i < 3)
        {
            throw new IllegalArgumentException("maxWidth");
        } else
        {
            maxWidth = i;
            return;
        }
    }

    public void setScientificNotationStyle(boolean flag)
    {
        sciNote = flag;
    }

    private double Log10(double d)
    {
        if(d == 0.0D)
            return 0.0D;
        else
            return Math.log(d) * k;
    }

    private int resolveErrorSigDigit(double d, double d1)
    {
        d1 = Math.abs(d1);
        d = Math.abs(d);
        if(d1 == 0.0D || Double.isInfinite(d1) || Double.isNaN(d1) || d1 >= d)
            return sigDigit;
        if(d == 0.0D || Double.isInfinite(d) || Double.isNaN(d))
            return sigDigit;
        int i = (int)Math.round(Log10(d1 / d));
        int j = sigDigit + i;
        if(j < 1)
            return 1;
        else
            return j;
    }

    private DecimalFormat getDecimalFormat(int i)
    {
        StringBuffer stringbuffer = new StringBuffer("0.");
        for(int j = 1; j < i; j++)
            stringbuffer.append('0');

        stringbuffer.append("E0");
        return new DecimalFormat(stringbuffer.toString(), new DecimalFormatSymbols(Locale.US));
    }

    public String format(double d)
    {
        return format(d, sigDigit);
    }

    private String format(double d, int i)
    {
        if(Double.isInfinite(d))
            return maxWidth >= 8 ? "Infinite" : "INF";
        if(Double.isNaN(d))
            return "NaN";
        if(decimalFormat == null)
            decimalFormat = getDecimalFormat(sigDigit);
        DecimalFormat decimalformat = i != sigDigit ? getDecimalFormat(i) : decimalFormat;
        String s = decimalformat.format(d);
        if(sciNote)
            return s;
        int j = s.indexOf('E');
        int l = Integer.parseInt(s.substring(j + 1)) + 1;
        if(l > maxWidth)
            return s;
        if(l < -maxWidth + i + 1)
            return s;
        int i1 = s.charAt(0) != '-' ? 0 : 1;
        StringBuffer stringbuffer = new StringBuffer(s.substring(i1, i1 + 1) + s.substring(i1 + 2, j));
        if(l >= i)
        {
            for(int j1 = i; j1 < l; j1++)
                stringbuffer.append('0');

        } else
        if(l < 0)
        {
            stringbuffer.insert(0, ".");
            for(int k1 = l; k1 < 0; k1++)
                stringbuffer.insert(1, '0');

        } else
        {
            stringbuffer.insert(l, '.');
        }
        if(i1 > 0)
            stringbuffer.insert(0, '-');
        return stringbuffer.toString();
    }

    private int sigDigit;
    private int maxWidth;
    private boolean sciNote;
    private DecimalFormat decimalFormat;
    private static final long serialVersionUID = 0xef964091c92addbdL;
    private static final double k = 1.0D / Math.log(10D);

}
