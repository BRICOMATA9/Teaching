// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.gvt;

import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import org.apache.batik.ext.awt.image.GraphicsUtil;
import org.apache.batik.ext.awt.image.renderable.Filter;

// Referenced classes of package org.apache.batik.gvt:
//            AbstractGraphicsNode

public class RasterImageNode extends AbstractGraphicsNode
{

    public RasterImageNode()
    {
    }

    public void setImage(Filter filter)
    {
        fireGraphicsNodeChangeStarted();
        invalidateGeometryCache();
        image = filter;
        fireGraphicsNodeChangeCompleted();
    }

    public Filter getImage()
    {
        return image;
    }

    public Rectangle2D getImageBounds()
    {
        if(image == null)
            return null;
        else
            return (Rectangle2D)image.getBounds2D().clone();
    }

    public Filter getGraphicsNodeRable()
    {
        return image;
    }

    public void primitivePaint(Graphics2D graphics2d)
    {
        if(image == null)
        {
            return;
        } else
        {
            GraphicsUtil.drawImage(graphics2d, image);
            return;
        }
    }

    public Rectangle2D getPrimitiveBounds()
    {
        if(image == null)
            return null;
        else
            return image.getBounds2D();
    }

    public Rectangle2D getGeometryBounds()
    {
        if(image == null)
            return null;
        else
            return image.getBounds2D();
    }

    public Rectangle2D getSensitiveBounds()
    {
        if(image == null)
            return null;
        else
            return image.getBounds2D();
    }

    public Shape getOutline()
    {
        if(image == null)
            return null;
        else
            return image.getBounds2D();
    }

    protected Filter image;
}
