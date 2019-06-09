// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.gvt;

import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;

// Referenced classes of package org.apache.batik.gvt:
//            AbstractGraphicsNode, GraphicsNode

public class ProxyGraphicsNode extends AbstractGraphicsNode
{

    public ProxyGraphicsNode()
    {
    }

    public void setSource(GraphicsNode graphicsnode)
    {
        source = graphicsnode;
    }

    public GraphicsNode getSource()
    {
        return source;
    }

    public void primitivePaint(Graphics2D graphics2d)
    {
        if(source != null)
            source.paint(graphics2d);
    }

    public Rectangle2D getPrimitiveBounds()
    {
        if(source == null)
            return null;
        else
            return source.getBounds();
    }

    public Rectangle2D getTransformedPrimitiveBounds(AffineTransform affinetransform)
    {
        if(source == null)
            return null;
        AffineTransform affinetransform1 = affinetransform;
        if(transform != null)
        {
            affinetransform1 = new AffineTransform(affinetransform);
            affinetransform1.concatenate(transform);
        }
        return source.getTransformedPrimitiveBounds(affinetransform1);
    }

    public Rectangle2D getGeometryBounds()
    {
        if(source == null)
            return null;
        else
            return source.getGeometryBounds();
    }

    public Rectangle2D getTransformedGeometryBounds(AffineTransform affinetransform)
    {
        if(source == null)
            return null;
        AffineTransform affinetransform1 = affinetransform;
        if(transform != null)
        {
            affinetransform1 = new AffineTransform(affinetransform);
            affinetransform1.concatenate(transform);
        }
        return source.getTransformedGeometryBounds(affinetransform1);
    }

    public Rectangle2D getSensitiveBounds()
    {
        if(source == null)
            return null;
        else
            return source.getSensitiveBounds();
    }

    public Shape getOutline()
    {
        if(source == null)
            return null;
        else
            return source.getOutline();
    }

    protected GraphicsNode source;
}
