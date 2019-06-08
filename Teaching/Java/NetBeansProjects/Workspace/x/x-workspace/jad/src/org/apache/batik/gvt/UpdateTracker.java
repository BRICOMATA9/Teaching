// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.gvt;

import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import org.apache.batik.ext.awt.image.renderable.Filter;
import org.apache.batik.gvt.event.GraphicsNodeChangeAdapter;
import org.apache.batik.gvt.event.GraphicsNodeChangeEvent;

// Referenced classes of package org.apache.batik.gvt:
//            GraphicsNode, CompositeGraphicsNode

public class UpdateTracker extends GraphicsNodeChangeAdapter
{
    class ChngSrcRect extends java.awt.geom.Rectangle2D.Float
    {

        ChngSrcRect(Rectangle2D rectangle2d)
        {
            super((float)rectangle2d.getX(), (float)rectangle2d.getY(), (float)rectangle2d.getWidth(), (float)rectangle2d.getHeight());
        }
    }


    public UpdateTracker()
    {
        dirtyNodes = null;
        fromBounds = new HashMap();
    }

    public boolean hasChanged()
    {
        return dirtyNodes != null;
    }

    public java.util.List getDirtyAreas()
    {
        if(dirtyNodes == null)
            return null;
        LinkedList linkedlist = new LinkedList();
        Set set = dirtyNodes.keySet();
        Iterator iterator = set.iterator();
        do
        {
            if(!iterator.hasNext())
                break;
            WeakReference weakreference = (WeakReference)iterator.next();
            Object obj = (GraphicsNode)weakreference.get();
            if(obj != null)
            {
                AffineTransform affinetransform = (AffineTransform)dirtyNodes.get(weakreference);
                if(affinetransform != null)
                    affinetransform = new AffineTransform(affinetransform);
                Rectangle2D rectangle2d = (Rectangle2D)fromBounds.remove(weakreference);
                Rectangle2D rectangle2d1 = null;
                AffineTransform affinetransform1 = null;
                if(!(rectangle2d instanceof ChngSrcRect))
                {
                    rectangle2d1 = ((GraphicsNode) (obj)).getBounds();
                    affinetransform1 = ((GraphicsNode) (obj)).getTransform();
                    if(affinetransform1 != null)
                        affinetransform1 = new AffineTransform(affinetransform1);
                }
                do
                {
                    obj = ((GraphicsNode) (obj)).getParent();
                    if(obj == null)
                        break;
                    Filter filter = ((GraphicsNode) (obj)).getFilter();
                    if(filter != null)
                    {
                        rectangle2d1 = filter.getBounds2D();
                        affinetransform1 = null;
                    }
                    AffineTransform affinetransform2 = ((GraphicsNode) (obj)).getTransform();
                    WeakReference weakreference1 = ((GraphicsNode) (obj)).getWeakReference();
                    AffineTransform affinetransform3 = (AffineTransform)dirtyNodes.get(weakreference1);
                    if(affinetransform3 == null)
                        affinetransform3 = affinetransform2;
                    if(affinetransform3 != null)
                        if(affinetransform != null)
                            affinetransform.preConcatenate(affinetransform3);
                        else
                            affinetransform = new AffineTransform(affinetransform3);
                    if(affinetransform2 != null)
                        if(affinetransform1 != null)
                            affinetransform1.preConcatenate(affinetransform2);
                        else
                            affinetransform1 = new AffineTransform(affinetransform2);
                } while(true);
                if(obj == null)
                {
                    Object obj1 = rectangle2d;
                    if(obj1 != null && obj1 != NULL_RECT)
                    {
                        if(affinetransform != null)
                            obj1 = affinetransform.createTransformedShape(rectangle2d);
                        linkedlist.add(obj1);
                    }
                    if(rectangle2d1 != null)
                    {
                        Object obj2 = rectangle2d1;
                        if(affinetransform1 != null)
                            obj2 = affinetransform1.createTransformedShape(rectangle2d1);
                        if(obj2 != null)
                            linkedlist.add(obj2);
                    }
                }
            }
        } while(true);
        return linkedlist;
    }

    public Rectangle2D getNodeDirtyRegion(GraphicsNode graphicsnode, AffineTransform affinetransform)
    {
        WeakReference weakreference = graphicsnode.getWeakReference();
        AffineTransform affinetransform1 = (AffineTransform)dirtyNodes.get(weakreference);
        if(affinetransform1 == null)
            affinetransform1 = graphicsnode.getTransform();
        if(affinetransform1 != null)
        {
            affinetransform = new AffineTransform(affinetransform);
            affinetransform.concatenate(affinetransform1);
        }
        Rectangle2D rectangle2d = null;
        if(graphicsnode instanceof CompositeGraphicsNode)
        {
            CompositeGraphicsNode compositegraphicsnode = (CompositeGraphicsNode)graphicsnode;
            Iterator iterator = compositegraphicsnode.iterator();
            do
            {
                if(!iterator.hasNext())
                    break;
                GraphicsNode graphicsnode1 = (GraphicsNode)iterator.next();
                Rectangle2D rectangle2d1 = getNodeDirtyRegion(graphicsnode1, affinetransform);
                if(rectangle2d1 != null)
                    if(rectangle2d == null || rectangle2d == NULL_RECT)
                        rectangle2d = rectangle2d1;
                    else
                        rectangle2d = rectangle2d.createUnion(rectangle2d1);
            } while(true);
        } else
        {
            rectangle2d = (Rectangle2D)fromBounds.remove(weakreference);
            if(rectangle2d == null)
                rectangle2d = graphicsnode.getBounds();
            else
            if(rectangle2d == NULL_RECT)
                rectangle2d = null;
            if(rectangle2d != null)
                rectangle2d = affinetransform.createTransformedShape(rectangle2d).getBounds2D();
        }
        return rectangle2d;
    }

    public Rectangle2D getNodeDirtyRegion(GraphicsNode graphicsnode)
    {
        return getNodeDirtyRegion(graphicsnode, new AffineTransform());
    }

    public void changeStarted(GraphicsNodeChangeEvent graphicsnodechangeevent)
    {
        GraphicsNode graphicsnode = graphicsnodechangeevent.getGraphicsNode();
        WeakReference weakreference = graphicsnode.getWeakReference();
        boolean flag = false;
        if(dirtyNodes == null)
        {
            dirtyNodes = new HashMap();
            flag = true;
        } else
        if(!dirtyNodes.containsKey(weakreference))
            flag = true;
        if(flag)
        {
            AffineTransform affinetransform = graphicsnode.getTransform();
            if(affinetransform != null)
                affinetransform = (AffineTransform)affinetransform.clone();
            else
                affinetransform = new AffineTransform();
            dirtyNodes.put(weakreference, affinetransform);
        }
        GraphicsNode graphicsnode1 = graphicsnodechangeevent.getChangeSrc();
        Object obj = null;
        if(graphicsnode1 != null)
        {
            Rectangle2D rectangle2d = getNodeDirtyRegion(graphicsnode1);
            if(rectangle2d != null)
                obj = new ChngSrcRect(rectangle2d);
        } else
        {
            obj = graphicsnode.getBounds();
        }
        Object obj1 = (Rectangle2D)fromBounds.remove(weakreference);
        if(obj != null)
            if(obj1 != null && obj1 != NULL_RECT)
                obj1 = ((Rectangle2D) (obj1)).createUnion(((Rectangle2D) (obj)));
            else
                obj1 = obj;
        if(obj1 == null)
            obj1 = NULL_RECT;
        fromBounds.put(weakreference, obj1);
    }

    public void clear()
    {
        dirtyNodes = null;
    }

    Map dirtyNodes;
    Map fromBounds;
    protected static Rectangle2D NULL_RECT = new Rectangle();

}
