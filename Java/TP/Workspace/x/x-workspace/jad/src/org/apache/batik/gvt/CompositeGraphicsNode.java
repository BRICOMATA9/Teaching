// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.gvt;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import org.apache.batik.util.HaltingThread;

// Referenced classes of package org.apache.batik.gvt:
//            AbstractGraphicsNode, GraphicsNode, RootGraphicsNode

public class CompositeGraphicsNode extends AbstractGraphicsNode
    implements List
{
    private class ListItr extends Itr
        implements ListIterator
    {

        public boolean hasPrevious()
        {
            return cursor != 0;
        }

        public Object previous()
        {
            Object obj;
            obj = get(--cursor);
            checkForComodification();
            lastRet = cursor;
            return obj;
            IndexOutOfBoundsException indexoutofboundsexception;
            indexoutofboundsexception;
            checkForComodification();
            throw new NoSuchElementException();
        }

        public int nextIndex()
        {
            return cursor;
        }

        public int previousIndex()
        {
            return cursor - 1;
        }

        public void set(Object obj)
        {
            if(lastRet == -1)
                throw new IllegalStateException();
            checkForComodification();
            try
            {
                CompositeGraphicsNode.this.set(lastRet, obj);
                expectedModCount = modCount;
            }
            catch(IndexOutOfBoundsException indexoutofboundsexception)
            {
                throw new ConcurrentModificationException();
            }
        }

        public void add(Object obj)
        {
            checkForComodification();
            try
            {
                CompositeGraphicsNode.this.add(cursor++, obj);
                lastRet = -1;
                expectedModCount = modCount;
            }
            catch(IndexOutOfBoundsException indexoutofboundsexception)
            {
                throw new ConcurrentModificationException();
            }
        }

        ListItr(int i)
        {
            cursor = i;
        }
    }

    private class Itr
        implements Iterator
    {

        public boolean hasNext()
        {
            return cursor != count;
        }

        public Object next()
        {
            Object obj;
            obj = get(cursor);
            checkForComodification();
            lastRet = cursor++;
            return obj;
            IndexOutOfBoundsException indexoutofboundsexception;
            indexoutofboundsexception;
            checkForComodification();
            throw new NoSuchElementException();
        }

        public void remove()
        {
            if(lastRet == -1)
                throw new IllegalStateException();
            checkForComodification();
            try
            {
                CompositeGraphicsNode.this.remove(lastRet);
                if(lastRet < cursor)
                    cursor--;
                lastRet = -1;
                expectedModCount = modCount;
            }
            catch(IndexOutOfBoundsException indexoutofboundsexception)
            {
                throw new ConcurrentModificationException();
            }
        }

        final void checkForComodification()
        {
            if(modCount != expectedModCount)
                throw new ConcurrentModificationException();
            else
                return;
        }

        int cursor;
        int lastRet;
        int expectedModCount;

        private Itr()
        {
            cursor = 0;
            lastRet = -1;
            expectedModCount = modCount;
        }

    }


    public CompositeGraphicsNode()
    {
        backgroundEnableRgn = null;
    }

    public List getChildren()
    {
        return this;
    }

    public void setBackgroundEnable(java.awt.geom.Rectangle2D rectangle2d)
    {
        backgroundEnableRgn = rectangle2d;
    }

    public java.awt.geom.Rectangle2D getBackgroundEnable()
    {
        return backgroundEnableRgn;
    }

    public void setVisible(boolean flag)
    {
        isVisible = flag;
    }

    public void primitivePaint(java.awt.Graphics2D graphics2d)
    {
        if(count == 0)
            return;
        for(int i = 0; i < count; i++)
        {
            if(HaltingThread.hasBeenHalted())
                return;
            GraphicsNode graphicsnode = children[i];
            if(graphicsnode != null)
                graphicsnode.paint(graphics2d);
        }

    }

    protected void invalidateGeometryCache()
    {
        super.invalidateGeometryCache();
        geometryBounds = null;
        primitiveBounds = null;
        sensitiveBounds = null;
        outline = null;
    }

    public java.awt.geom.Rectangle2D getPrimitiveBounds()
    {
        if(primitiveBounds != null)
            if(primitiveBounds == NULL_RECT)
                return null;
            else
                return primitiveBounds;
        int i = 0;
        java.awt.geom.Rectangle2D rectangle2d = null;
        do
        {
            if(rectangle2d != null || i >= count)
                break;
            rectangle2d = children[i++].getTransformedBounds(GraphicsNode.IDENTITY);
        } while((i & 0xf) != 0 || !HaltingThread.hasBeenHalted());
        if(HaltingThread.hasBeenHalted())
        {
            invalidateGeometryCache();
            return null;
        }
        if(rectangle2d == null)
        {
            primitiveBounds = NULL_RECT;
            return null;
        }
        primitiveBounds = rectangle2d;
        Object obj = null;
        do
        {
            if(i >= count)
                break;
            java.awt.geom.Rectangle2D rectangle2d1 = children[i++].getTransformedBounds(GraphicsNode.IDENTITY);
            if(rectangle2d1 != null)
            {
                if(primitiveBounds == null)
                    return null;
                primitiveBounds.add(rectangle2d1);
            }
        } while((i & 0xf) != 0 || !HaltingThread.hasBeenHalted());
        if(HaltingThread.hasBeenHalted())
            invalidateGeometryCache();
        return primitiveBounds;
    }

    public static java.awt.geom.Rectangle2D getTransformedBBox(java.awt.geom.Rectangle2D rectangle2d, java.awt.geom.AffineTransform affinetransform)
    {
        if(affinetransform == null || rectangle2d == null)
            return rectangle2d;
        double d = rectangle2d.getX();
        double d1 = rectangle2d.getWidth();
        double d2 = rectangle2d.getY();
        double d3 = rectangle2d.getHeight();
        double d4 = affinetransform.getScaleX();
        double d5 = affinetransform.getScaleY();
        if(d4 < 0.0D)
        {
            d = -(d + d1);
            d4 = -d4;
        }
        if(d5 < 0.0D)
        {
            d2 = -(d2 + d3);
            d5 = -d5;
        }
        return new java.awt.geom.Rectangle2D.Float((float)(d * d4 + affinetransform.getTranslateX()), (float)(d2 * d5 + affinetransform.getTranslateY()), (float)(d1 * d4), (float)(d3 * d5));
    }

    public java.awt.geom.Rectangle2D getTransformedPrimitiveBounds(java.awt.geom.AffineTransform affinetransform)
    {
        java.awt.geom.AffineTransform affinetransform1 = affinetransform;
        if(transform != null)
        {
            affinetransform1 = new java.awt.geom.AffineTransform(affinetransform);
            affinetransform1.concatenate(transform);
        }
        if(affinetransform1 == null || affinetransform1.getShearX() == 0.0D && affinetransform1.getShearY() == 0.0D)
            return getTransformedBBox(getPrimitiveBounds(), affinetransform1);
        int i = 0;
        java.awt.geom.Rectangle2D rectangle2d;
        for(rectangle2d = null; rectangle2d == null && i < count; rectangle2d = children[i++].getTransformedBounds(affinetransform1));
        Object obj = null;
        do
        {
            if(i >= count)
                break;
            java.awt.geom.Rectangle2D rectangle2d1 = children[i++].getTransformedBounds(affinetransform1);
            if(rectangle2d1 != null)
                rectangle2d.add(rectangle2d1);
        } while(true);
        return rectangle2d;
    }

    public java.awt.geom.Rectangle2D getGeometryBounds()
    {
        if(geometryBounds == null)
        {
            int i;
            for(i = 0; geometryBounds == null && i < count; geometryBounds = children[i++].getTransformedGeometryBounds(GraphicsNode.IDENTITY));
            Object obj = null;
            do
            {
                if(i >= count)
                    break;
                java.awt.geom.Rectangle2D rectangle2d = children[i++].getTransformedGeometryBounds(GraphicsNode.IDENTITY);
                if(rectangle2d != null)
                {
                    if(geometryBounds == null)
                        return getGeometryBounds();
                    geometryBounds.add(rectangle2d);
                }
            } while(true);
        }
        return geometryBounds;
    }

    public java.awt.geom.Rectangle2D getTransformedGeometryBounds(java.awt.geom.AffineTransform affinetransform)
    {
        java.awt.geom.AffineTransform affinetransform1 = affinetransform;
        if(transform != null)
        {
            affinetransform1 = new java.awt.geom.AffineTransform(affinetransform);
            affinetransform1.concatenate(transform);
        }
        if(affinetransform1 == null || affinetransform1.getShearX() == 0.0D && affinetransform1.getShearY() == 0.0D)
            return getTransformedBBox(getGeometryBounds(), affinetransform1);
        java.awt.geom.Rectangle2D rectangle2d = null;
        int i;
        for(i = 0; rectangle2d == null && i < count; rectangle2d = children[i++].getTransformedGeometryBounds(affinetransform1));
        Object obj = null;
        do
        {
            if(i >= count)
                break;
            java.awt.geom.Rectangle2D rectangle2d1 = children[i++].getTransformedGeometryBounds(affinetransform1);
            if(rectangle2d1 != null)
                rectangle2d.add(rectangle2d1);
        } while(true);
        return rectangle2d;
    }

    public java.awt.geom.Rectangle2D getSensitiveBounds()
    {
        if(sensitiveBounds != null)
            return sensitiveBounds;
        int i;
        for(i = 0; sensitiveBounds == null && i < count; sensitiveBounds = children[i++].getTransformedSensitiveBounds(GraphicsNode.IDENTITY));
        Object obj = null;
        do
        {
            if(i >= count)
                break;
            java.awt.geom.Rectangle2D rectangle2d = children[i++].getTransformedSensitiveBounds(GraphicsNode.IDENTITY);
            if(rectangle2d != null)
            {
                if(sensitiveBounds == null)
                    return getSensitiveBounds();
                sensitiveBounds.add(rectangle2d);
            }
        } while(true);
        return sensitiveBounds;
    }

    public java.awt.geom.Rectangle2D getTransformedSensitiveBounds(java.awt.geom.AffineTransform affinetransform)
    {
        java.awt.geom.AffineTransform affinetransform1 = affinetransform;
        if(transform != null)
        {
            affinetransform1 = new java.awt.geom.AffineTransform(affinetransform);
            affinetransform1.concatenate(transform);
        }
        if(affinetransform1 == null || affinetransform1.getShearX() == 0.0D && affinetransform1.getShearY() == 0.0D)
            return getTransformedBBox(getSensitiveBounds(), affinetransform1);
        java.awt.geom.Rectangle2D rectangle2d = null;
        int i;
        for(i = 0; rectangle2d == null && i < count; rectangle2d = children[i++].getTransformedSensitiveBounds(affinetransform1));
        Object obj = null;
        do
        {
            if(i >= count)
                break;
            java.awt.geom.Rectangle2D rectangle2d1 = children[i++].getTransformedSensitiveBounds(affinetransform1);
            if(rectangle2d1 != null)
                rectangle2d.add(rectangle2d1);
        } while(true);
        return rectangle2d;
    }

    public boolean contains(java.awt.geom.Point2D point2d)
    {
        java.awt.geom.Rectangle2D rectangle2d = getSensitiveBounds();
        if(count > 0 && rectangle2d != null && rectangle2d.contains(point2d))
        {
            java.awt.geom.Point2D point2d1 = null;
            Object obj = null;
            for(int i = 0; i < count; i++)
            {
                java.awt.geom.AffineTransform affinetransform = children[i].getInverseTransform();
                java.awt.geom.Point2D point2d2;
                if(affinetransform != null)
                {
                    point2d1 = affinetransform.transform(point2d, point2d1);
                    point2d2 = point2d1;
                } else
                {
                    point2d2 = point2d;
                }
                if(children[i].contains(point2d2))
                    return true;
            }

        }
        return false;
    }

    public GraphicsNode nodeHitAt(java.awt.geom.Point2D point2d)
    {
        java.awt.geom.Rectangle2D rectangle2d = getSensitiveBounds();
        if(count > 0 && rectangle2d != null && rectangle2d.contains(point2d))
        {
            java.awt.geom.Point2D point2d1 = null;
            Object obj = null;
            for(int i = count - 1; i >= 0; i--)
            {
                java.awt.geom.AffineTransform affinetransform = children[i].getInverseTransform();
                java.awt.geom.Point2D point2d2;
                if(affinetransform != null)
                {
                    point2d1 = affinetransform.transform(point2d, point2d1);
                    point2d2 = point2d1;
                } else
                {
                    point2d2 = point2d;
                }
                GraphicsNode graphicsnode = children[i].nodeHitAt(point2d2);
                if(graphicsnode != null)
                    return graphicsnode;
            }

        }
        return null;
    }

    public java.awt.Shape getOutline()
    {
        if(outline != null)
            return outline;
        outline = new java.awt.geom.GeneralPath();
        for(int i = 0; i < count; i++)
        {
            java.awt.Shape shape = children[i].getOutline();
            if(shape == null)
                continue;
            java.awt.geom.AffineTransform affinetransform = children[i].getTransform();
            if(affinetransform != null)
                ((java.awt.geom.GeneralPath)outline).append(affinetransform.createTransformedShape(shape), false);
            else
                ((java.awt.geom.GeneralPath)outline).append(shape, false);
        }

        return outline;
    }

    protected void setRoot(RootGraphicsNode rootgraphicsnode)
    {
        super.setRoot(rootgraphicsnode);
        for(int i = 0; i < count; i++)
        {
            GraphicsNode graphicsnode = children[i];
            ((AbstractGraphicsNode)graphicsnode).setRoot(rootgraphicsnode);
        }

    }

    public int size()
    {
        return count;
    }

    public boolean isEmpty()
    {
        return count == 0;
    }

    public boolean contains(Object obj)
    {
        return indexOf(obj) >= 0;
    }

    public Iterator iterator()
    {
        return new Itr();
    }

    public Object[] toArray()
    {
        GraphicsNode agraphicsnode[] = new GraphicsNode[count];
        for(int i = 0; i < count; i++)
            agraphicsnode[i] = children[i];

        return agraphicsnode;
    }

    public Object[] toArray(Object aobj[])
    {
        if(aobj.length < count)
            aobj = new GraphicsNode[count];
        System.arraycopy(children, 0, ((Object) (aobj)), 0, count);
        if(aobj.length > count)
            aobj[count] = null;
        return aobj;
    }

    public Object get(int i)
    {
        checkRange(i);
        return children[i];
    }

    public Object set(int i, Object obj)
    {
        if(!(obj instanceof GraphicsNode))
            throw new IllegalArgumentException(obj + " is not a GraphicsNode");
        checkRange(i);
        GraphicsNode graphicsnode = (GraphicsNode)obj;
        fireGraphicsNodeChangeStarted(graphicsnode);
        if(graphicsnode.getParent() != null)
            graphicsnode.getParent().getChildren().remove(graphicsnode);
        GraphicsNode graphicsnode1 = children[i];
        children[i] = graphicsnode;
        ((AbstractGraphicsNode)graphicsnode).setParent(this);
        ((AbstractGraphicsNode)graphicsnode1).setParent(null);
        ((AbstractGraphicsNode)graphicsnode).setRoot(getRoot());
        ((AbstractGraphicsNode)graphicsnode1).setRoot(null);
        invalidateGeometryCache();
        fireGraphicsNodeChangeCompleted();
        return graphicsnode1;
    }

    public boolean add(Object obj)
    {
        if(!(obj instanceof GraphicsNode))
            throw new IllegalArgumentException(obj + " is not a GraphicsNode");
        GraphicsNode graphicsnode = (GraphicsNode)obj;
        fireGraphicsNodeChangeStarted(graphicsnode);
        if(graphicsnode.getParent() != null)
            graphicsnode.getParent().getChildren().remove(graphicsnode);
        ensureCapacity(count + 1);
        children[count++] = graphicsnode;
        ((AbstractGraphicsNode)graphicsnode).setParent(this);
        ((AbstractGraphicsNode)graphicsnode).setRoot(getRoot());
        invalidateGeometryCache();
        fireGraphicsNodeChangeCompleted();
        return true;
    }

    public void add(int i, Object obj)
    {
        if(!(obj instanceof GraphicsNode))
            throw new IllegalArgumentException(obj + " is not a GraphicsNode");
        if(i > count || i < 0)
            throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + count);
        GraphicsNode graphicsnode = (GraphicsNode)obj;
        fireGraphicsNodeChangeStarted(graphicsnode);
        if(graphicsnode.getParent() != null)
            graphicsnode.getParent().getChildren().remove(graphicsnode);
        ensureCapacity(count + 1);
        System.arraycopy(children, i, children, i + 1, count - i);
        children[i] = graphicsnode;
        count++;
        ((AbstractGraphicsNode)graphicsnode).setParent(this);
        ((AbstractGraphicsNode)graphicsnode).setRoot(getRoot());
        invalidateGeometryCache();
        fireGraphicsNodeChangeCompleted();
    }

    public boolean addAll(Collection collection)
    {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(int i, Collection collection)
    {
        throw new UnsupportedOperationException();
    }

    public boolean remove(Object obj)
    {
        if(!(obj instanceof GraphicsNode))
            throw new IllegalArgumentException(obj + " is not a GraphicsNode");
        GraphicsNode graphicsnode = (GraphicsNode)obj;
        if(graphicsnode.getParent() != this)
            return false;
        int i;
        for(i = 0; graphicsnode != children[i]; i++);
        remove(i);
        return true;
    }

    public Object remove(int i)
    {
        checkRange(i);
        GraphicsNode graphicsnode = children[i];
        fireGraphicsNodeChangeStarted(graphicsnode);
        modCount++;
        int j = count - i - 1;
        if(j > 0)
            System.arraycopy(children, i + 1, children, i, j);
        children[--count] = null;
        if(count == 0)
            children = null;
        ((AbstractGraphicsNode)graphicsnode).setParent(null);
        ((AbstractGraphicsNode)graphicsnode).setRoot(null);
        invalidateGeometryCache();
        fireGraphicsNodeChangeCompleted();
        return graphicsnode;
    }

    public boolean removeAll(Collection collection)
    {
        throw new UnsupportedOperationException();
    }

    public boolean retainAll(Collection collection)
    {
        throw new UnsupportedOperationException();
    }

    public void clear()
    {
        throw new UnsupportedOperationException();
    }

    public boolean containsAll(Collection collection)
    {
        for(Iterator iterator1 = collection.iterator(); iterator1.hasNext();)
            if(!contains(iterator1.next()))
                return false;

        return true;
    }

    public int indexOf(Object obj)
    {
        if(obj == null || !(obj instanceof GraphicsNode))
            return -1;
        if(((GraphicsNode)obj).getParent() == this)
        {
            for(int i = 0; i < count; i++)
                if(obj == children[i])
                    return i;

        }
        return -1;
    }

    public int lastIndexOf(Object obj)
    {
        if(obj == null || !(obj instanceof GraphicsNode))
            return -1;
        if(((GraphicsNode)obj).getParent() == this)
        {
            for(int i = count - 1; i >= 0; i--)
                if(obj == children[i])
                    return i;

        }
        return -1;
    }

    public ListIterator listIterator()
    {
        return listIterator(0);
    }

    public ListIterator listIterator(int i)
    {
        if(i < 0 || i > count)
            throw new IndexOutOfBoundsException("Index: " + i);
        else
            return new ListItr(i);
    }

    public List subList(int i, int j)
    {
        throw new UnsupportedOperationException();
    }

    private void checkRange(int i)
    {
        if(i >= count || i < 0)
            throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + count);
        else
            return;
    }

    public void ensureCapacity(int i)
    {
        if(children == null)
            children = new GraphicsNode[4];
        modCount++;
        int j = children.length;
        if(i > j)
        {
            GraphicsNode agraphicsnode[] = children;
            int k = (j * 3) / 2 + 1;
            if(k < i)
                k = i;
            children = new GraphicsNode[k];
            System.arraycopy(agraphicsnode, 0, children, 0, count);
        }
    }

    public static final java.awt.geom.Rectangle2D VIEWPORT = new java.awt.Rectangle();
    public static final java.awt.geom.Rectangle2D NULL_RECT = new java.awt.Rectangle();
    protected GraphicsNode children[];
    protected int count;
    protected int modCount;
    protected java.awt.geom.Rectangle2D backgroundEnableRgn;
    private java.awt.geom.Rectangle2D geometryBounds;
    private java.awt.geom.Rectangle2D primitiveBounds;
    private java.awt.geom.Rectangle2D sensitiveBounds;
    private java.awt.Shape outline;

}
