// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.bridge;

import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import org.apache.batik.ext.awt.geom.RectListManager;
import org.apache.batik.gvt.renderer.ImageRenderer;

public class RepaintManager
{

    public RepaintManager(ImageRenderer imagerenderer)
    {
        renderer = imagerenderer;
    }

    public Collection updateRendering(Collection collection)
        throws InterruptedException
    {
        renderer.flush(collection);
        ArrayList arraylist = new ArrayList(collection.size());
        AffineTransform affinetransform = renderer.getTransform();
        Rectangle rectangle;
        for(Iterator iterator = collection.iterator(); iterator.hasNext(); arraylist.add(rectangle))
        {
            Shape shape = (Shape)iterator.next();
            shape = affinetransform.createTransformedShape(shape);
            Rectangle2D rectangle2d = shape.getBounds2D();
            int i = (int)Math.floor(rectangle2d.getX());
            int j = (int)Math.floor(rectangle2d.getY());
            int k = (int)Math.ceil(rectangle2d.getX() + rectangle2d.getWidth());
            int l = (int)Math.ceil(rectangle2d.getY() + rectangle2d.getHeight());
            rectangle = new Rectangle(i - 1, j - 1, (k - i) + 3, (l - j) + 3);
        }

        RectListManager rectlistmanager = null;
        try
        {
            rectlistmanager = new RectListManager(arraylist);
            rectlistmanager.mergeRects(10000, 10);
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
        renderer.repaint(rectlistmanager);
        return rectlistmanager;
    }

    public void setupRenderer(AffineTransform affinetransform, boolean flag, Shape shape, int i, int j)
    {
        renderer.setTransform(affinetransform);
        renderer.setDoubleBuffered(flag);
        renderer.updateOffScreen(i, j);
        renderer.clearOffScreen();
    }

    public BufferedImage getOffScreen()
    {
        return renderer.getOffScreen();
    }

    static final int COPY_OVERHEAD = 10000;
    static final int COPY_LINE_OVERHEAD = 10;
    protected ImageRenderer renderer;
}
