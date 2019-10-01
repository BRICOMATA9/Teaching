// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.freehep.graphicsio;

import java.io.IOException;

// Referenced classes of package org.freehep.graphicsio:
//            AbstractPathConstructor

public abstract class QuadToCubicPathConstructor extends AbstractPathConstructor
{

    protected QuadToCubicPathConstructor()
    {
    }

    public void move(double d, double d1)
        throws IOException
    {
        currentX = d;
        currentY = d1;
    }

    public void line(double d, double d1)
        throws IOException
    {
        currentX = d;
        currentY = d1;
    }

    public void quad(double d, double d1, double d2, double d3)
        throws IOException
    {
        double d4 = d + (currentX - d) / 3D;
        double d5 = d1 + (currentY - d1) / 3D;
        double d6 = d + (d2 - d) / 3D;
        double d7 = d1 + (d3 - d1) / 3D;
        cubic(d4, d5, d6, d7, d2, d3);
        currentX = d2;
        currentY = d3;
    }

    public void cubic(double d, double d1, double d2, double d3, double d4, double d5)
        throws IOException
    {
        currentX = d4;
        currentY = d5;
    }

    public void closePath(double d, double d1)
        throws IOException
    {
        currentX = 0.0D;
        currentY = 0.0D;
    }
}
