// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.K;

import java.awt.geom.Rectangle2D;

// Referenced classes of package C.K:
//            M

public final class A
{

    public static int A(double d, double d1, double d2, double d3, 
            double d4, double d5)
    {
        d2 -= d;
        d3 -= d1;
        d4 -= d;
        d5 -= d1;
        double d6 = d4 * d3 - d5 * d2;
        return d6 >= 0.0D ? d6 <= 0.0D ? 0 : -1 : 1;
    }

    public static double A(double d)
    {
        return (d * 180D) / 3.1415926535897931D;
    }

    public static M B(double d, double d1, double d2, double d3, 
            double d4, double d5)
    {
        double d6 = d4 - d2;
        double d7 = d5 - d3;
        double d8 = d6 * d6 + d7 * d7;
        double d9 = 0.0D;
        if(d8 != 0.0D)
        {
            d9 = ((d - d2) * d6 + (d1 - d3) * d7) / d8;
            d9 = Math.min(1.0D, Math.max(0.0D, d9));
        }
        return new M(d2 * (1.0D - d9) + d4 * d9, d3 * (1.0D - d9) + d5 * d9);
    }

    public static Rectangle2D A(Rectangle2D rectangle2d, Rectangle2D rectangle2d1, Rectangle2D rectangle2d2)
    {
        if(rectangle2d2 == null)
            rectangle2d2 = new java.awt.geom.Rectangle2D.Double();
        if(rectangle2d2 != rectangle2d1)
        {
            rectangle2d2.setRect(rectangle2d);
            if(rectangle2d2.getWidth() < 0.0D || rectangle2d2.getHeight() < 0.0D)
                rectangle2d2.setRect(rectangle2d1);
            else
            if(rectangle2d1.getWidth() >= 0.0D && rectangle2d1.getHeight() >= 0.0D)
                rectangle2d2.add(rectangle2d1);
        } else
        if(rectangle2d2.getWidth() < 0.0D || rectangle2d2.getHeight() < 0.0D)
            rectangle2d2.setRect(rectangle2d);
        else
        if(rectangle2d.getWidth() >= 0.0D && rectangle2d.getHeight() >= 0.0D)
            rectangle2d2.add(rectangle2d);
        return rectangle2d2;
    }
}
