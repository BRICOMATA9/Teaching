// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.E;

import java.io.PrintStream;

public final class D
{

    public static boolean A(Object obj)
    {
        if(obj instanceof Boolean)
            return ((Boolean)obj).booleanValue();
        try
        {
            if(obj == null)
                System.err.println("WARNING: YUtil.getBool cannot convert to boolean");
        }
        catch(Exception exception)
        {
            System.err.println("WARNING: YUtil.getBool cannot convert to boolean");
        }
        return false;
    }

    public static double B(Object obj)
    {
        if(obj instanceof Number)
            return ((Number)obj).doubleValue();
        Double double1;
        if(!(obj instanceof String) || ((String)obj).length() <= 0)
            break MISSING_BLOCK_LABEL_49;
        double1 = new Double((String)obj);
        return double1.doubleValue();
        try
        {
            if(obj == null)
                System.err.println("WARNING: YUtil.getDouble cannot convert to double");
        }
        catch(Exception exception)
        {
            System.err.println("WARNING: YUtil.getDouble cannot convert to double");
        }
        return 0.0D;
    }
}
