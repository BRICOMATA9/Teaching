// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.freehep.graphicsio;

import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.io.IOException;

// Referenced classes of package org.freehep.graphicsio:
//            PathConstructor

public abstract class AbstractPathConstructor
    implements PathConstructor
{

    protected AbstractPathConstructor()
    {
        currentX = 0.0D;
        currentY = 0.0D;
    }

    public void flush()
        throws IOException
    {
        currentX = 0.0D;
        currentY = 0.0D;
    }

    public boolean addPath(Shape shape)
        throws IOException
    {
        return addPath(shape, null);
    }

    public boolean addPath(Shape shape, AffineTransform affinetransform)
        throws IOException
    {
        return addPath(((PathConstructor) (this)), shape, affinetransform);
    }

    public static boolean addPath(PathConstructor pathconstructor, Shape shape, AffineTransform affinetransform)
        throws IOException
    {
        PathIterator pathiterator = shape.getPathIterator(affinetransform);
        double ad[] = new double[6];
        double d = 0.0D;
        double d1 = 0.0D;
        for(; !pathiterator.isDone(); pathiterator.next())
        {
            int i = pathiterator.currentSegment(ad);
            switch(i)
            {
            case 0: // '\0'
                pathconstructor.move(ad[0], ad[1]);
                d = ad[0];
                d1 = ad[1];
                break;

            case 1: // '\001'
                pathconstructor.line(ad[0], ad[1]);
                break;

            case 2: // '\002'
                pathconstructor.quad(ad[0], ad[1], ad[2], ad[3]);
                break;

            case 3: // '\003'
                pathconstructor.cubic(ad[0], ad[1], ad[2], ad[3], ad[4], ad[5]);
                break;

            case 4: // '\004'
                pathconstructor.closePath(d, d1);
                break;
            }
        }

        pathconstructor.flush();
        return pathiterator.getWindingRule() == 0;
    }

    public static boolean isEvenOdd(Shape shape)
    {
        return shape.getPathIterator(null).getWindingRule() == 0;
    }

    protected double currentX;
    protected double currentY;
}
