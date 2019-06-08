// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.gvt;

import java.awt.*;
import java.awt.geom.*;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.apache.batik.ext.awt.image.renderable.ClipRable;
import org.apache.batik.ext.awt.image.renderable.Filter;
import org.apache.batik.gvt.filter.Mask;

// Referenced classes of package org.apache.batik.gvt:
//            CompositeGraphicsNode, RootGraphicsNode

public interface GraphicsNode
{

    public abstract WeakReference getWeakReference();

    public abstract int getPointerEventType();

    public abstract void setPointerEventType(int i);

    public abstract void setTransform(AffineTransform affinetransform);

    public abstract AffineTransform getTransform();

    public abstract AffineTransform getInverseTransform();

    public abstract AffineTransform getGlobalTransform();

    public abstract void setComposite(Composite composite);

    public abstract Composite getComposite();

    public abstract void setVisible(boolean flag);

    public abstract boolean isVisible();

    public abstract void setClip(ClipRable cliprable);

    public abstract ClipRable getClip();

    public abstract void setRenderingHint(java.awt.RenderingHints.Key key, Object obj);

    public abstract void setRenderingHints(Map map);

    public abstract void setRenderingHints(RenderingHints renderinghints);

    public abstract RenderingHints getRenderingHints();

    public abstract void setMask(Mask mask);

    public abstract Mask getMask();

    public abstract void setFilter(Filter filter);

    public abstract Filter getFilter();

    public abstract Filter getGraphicsNodeRable(boolean flag);

    public abstract Filter getEnableBackgroundGraphicsNodeRable(boolean flag);

    public abstract void paint(Graphics2D graphics2d);

    public abstract void primitivePaint(Graphics2D graphics2d);

    public abstract CompositeGraphicsNode getParent();

    public abstract RootGraphicsNode getRoot();

    public abstract Rectangle2D getBounds();

    public abstract Rectangle2D getTransformedBounds(AffineTransform affinetransform);

    public abstract Rectangle2D getPrimitiveBounds();

    public abstract Rectangle2D getTransformedPrimitiveBounds(AffineTransform affinetransform);

    public abstract Rectangle2D getGeometryBounds();

    public abstract Rectangle2D getTransformedGeometryBounds(AffineTransform affinetransform);

    public abstract Rectangle2D getSensitiveBounds();

    public abstract Rectangle2D getTransformedSensitiveBounds(AffineTransform affinetransform);

    public abstract boolean contains(Point2D point2d);

    public abstract boolean intersects(Rectangle2D rectangle2d);

    public abstract GraphicsNode nodeHitAt(Point2D point2d);

    public abstract Shape getOutline();

    public static final int VISIBLE_PAINTED = 0;
    public static final int VISIBLE_FILL = 1;
    public static final int VISIBLE_STROKE = 2;
    public static final int VISIBLE = 3;
    public static final int PAINTED = 4;
    public static final int FILL = 5;
    public static final int STROKE = 6;
    public static final int ALL = 7;
    public static final int NONE = 8;
    public static final AffineTransform IDENTITY = new AffineTransform();

}
