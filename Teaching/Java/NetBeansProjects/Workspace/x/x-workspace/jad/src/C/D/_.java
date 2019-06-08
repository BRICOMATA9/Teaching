// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.D;

import java.util.Locale;

// Referenced classes of package C.D:
//            D

public class _ extends D
{

    public _(String s, Double double1)
    {
        super(s, double1);
        A(Double.TYPE);
        i = false;
        B(j, Locale.getDefault());
    }

    public _(String s, double d)
    {
        this(s, new Double(d));
    }

    public String C()
    {
        return "Double";
    }

    public void A(Object obj)
    {
        if((obj instanceof Double) || obj == null)
            super.A(obj);
        else
            throw new IllegalArgumentException("argument type mismatch");
    }

    public static final String m = "DoubleOptionItem.minValue";
    public static final String l = "DoubleOptionItem.maxValue";
    public static final String k = "DoubleOptionItem.precision";
    public static final String n = "DoubleOptionItem.unsigned";
    public static final String j = "DoubleOptionItem.locale";
    private boolean i;

}
