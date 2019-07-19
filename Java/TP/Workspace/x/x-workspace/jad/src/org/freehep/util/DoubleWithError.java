// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.freehep.util;


public class DoubleWithError
{

    public DoubleWithError(double d, double d1)
    {
        value = d;
        error = d1;
        asymmetricError = false;
    }

    public DoubleWithError(double d, double d1, double d2)
    {
        value = d;
        error = d1;
        minError = d2;
        asymmetricError = true;
    }

    public void setError(double d)
    {
        error = d;
        asymmetricError = false;
    }

    public void setError(double d, double d1)
    {
        error = d;
        minError = d1;
        asymmetricError = true;
    }

    public double getError()
    {
        return error;
    }

    public double getPlusError()
    {
        return error;
    }

    public double getMinError()
    {
        return asymmetricError ? minError : error;
    }

    public boolean hasAsymmetricError()
    {
        return asymmetricError;
    }

    public void setValue(double d)
    {
        value = d;
    }

    public double getValue()
    {
        return value;
    }

    public String toString()
    {
        if(asymmetricError)
            return String.valueOf(value) + '+' + error + '-' + minError;
        else
            return String.valueOf(value) + '\261' + error;
    }

    static final char plusorminus = 177;
    static final char plus = 43;
    static final char minus = 45;
    private double value;
    private double error;
    private boolean asymmetricError;
    private double minError;
}
