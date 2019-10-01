// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.gvt;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

// Referenced classes of package org.apache.batik.gvt:
//            CompositeGraphicsNode, AbstractGraphicsNode, GraphicsNode

public class ImageNode extends CompositeGraphicsNode
{

    public ImageNode()
    {
        hitCheckChildren = false;
    }

    public void setVisible(boolean flag)
    {
        fireGraphicsNodeChangeStarted();
        isVisible = flag;
        invalidateGeometryCache();
        fireGraphicsNodeChangeCompleted();
    }

    public Rectangle2D getPrimitiveBounds()
    {
        if(!isVisible)
            return null;
        else
            return super.getPrimitiveBounds();
    }

    public void setHitCheckChildren(boolean flag)
    {
        hitCheckChildren = flag;
    }

    public boolean getHitCheckChildren()
    {
        return hitCheckChildren;
    }

    public void paint(Graphics2D graphics2d)
    {
        if(isVisible)
            super.paint(graphics2d);
    }

    public boolean contains(Point2D point2d)
    {
        switch(pointerEventType)
        {
        case 0: // '\0'
        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
            return isVisible && super.contains(point2d);

        case 4: // '\004'
        case 5: // '\005'
        case 6: // '\006'
        case 7: // '\007'
            return super.contains(point2d);

        case 8: // '\b'
            return false;
        }
        return false;
    }

    public GraphicsNode nodeHitAt(Point2D point2d)
    {
        if(hitCheckChildren)
            return super.nodeHitAt(point2d);
        else
            return contains(point2d) ? this : null;
    }

    public void setImage(GraphicsNode graphicsnode)
    {
        fireGraphicsNodeChangeStarted();
        invalidateGeometryCache();
        if(count == 0)
            ensureCapacity(1);
        children[0] = graphicsnode;
        ((AbstractGraphicsNode)graphicsnode).setParent(this);
        ((AbstractGraphicsNode)graphicsnode).setRoot(getRoot());
        count = 1;
        fireGraphicsNodeChangeCompleted();
    }

    public GraphicsNode getImage()
    {
        if(count > 0)
            return children[0];
        else
            return null;
    }

    protected boolean hitCheckChildren;
}
