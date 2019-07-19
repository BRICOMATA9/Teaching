// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.svggen;

import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.*;

class NullOp
    implements BufferedImageOp
{

    NullOp()
    {
    }

    public BufferedImage filter(BufferedImage bufferedimage, BufferedImage bufferedimage1)
    {
        Graphics2D graphics2d = bufferedimage1.createGraphics();
        graphics2d.drawImage(bufferedimage, 0, 0, null);
        graphics2d.dispose();
        return bufferedimage1;
    }

    public Rectangle2D getBounds2D(BufferedImage bufferedimage)
    {
        return new Rectangle(0, 0, bufferedimage.getWidth(), bufferedimage.getHeight());
    }

    public BufferedImage createCompatibleDestImage(BufferedImage bufferedimage, ColorModel colormodel)
    {
        BufferedImage bufferedimage1 = null;
        if(colormodel == null)
            colormodel = bufferedimage.getColorModel();
        bufferedimage1 = new BufferedImage(colormodel, colormodel.createCompatibleWritableRaster(bufferedimage.getWidth(), bufferedimage.getHeight()), colormodel.isAlphaPremultiplied(), null);
        return bufferedimage1;
    }

    public Point2D getPoint2D(Point2D point2d, Point2D point2d1)
    {
        if(point2d1 == null)
            point2d1 = new java.awt.geom.Point2D.Double();
        point2d1.setLocation(point2d.getX(), point2d.getY());
        return point2d1;
    }

    public RenderingHints getRenderingHints()
    {
        return null;
    }
}
