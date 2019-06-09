// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.gvt;

import java.awt.AlphaComposite;
import java.awt.Composite;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.NoninvertibleTransformException;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.PrintStream;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;
import javax.swing.event.EventListenerList;
import org.apache.batik.ext.awt.RenderingHintsKeyExt;
import org.apache.batik.ext.awt.image.GraphicsUtil;
import org.apache.batik.ext.awt.image.renderable.ClipRable;
import org.apache.batik.ext.awt.image.renderable.Filter;
import org.apache.batik.gvt.event.GraphicsNodeChangeEvent;
import org.apache.batik.gvt.event.GraphicsNodeChangeListener;
import org.apache.batik.gvt.filter.GraphicsNodeRable;
import org.apache.batik.gvt.filter.GraphicsNodeRable8Bit;
import org.apache.batik.gvt.filter.Mask;
import org.apache.batik.util.HaltingThread;

// Referenced classes of package org.apache.batik.gvt:
//            GraphicsNode, CompositeGraphicsNode, RootGraphicsNode

public abstract class AbstractGraphicsNode
    implements GraphicsNode
{

    protected AbstractGraphicsNode()
    {
        isVisible = true;
        pointerEventType = 0;
        changeStartedEvent = null;
        changeCompletedEvent = null;
    }

    public WeakReference getWeakReference()
    {
        if(weakRef == null)
            weakRef = new WeakReference(this);
        return weakRef;
    }

    public int getPointerEventType()
    {
        return pointerEventType;
    }

    public void setPointerEventType(int i)
    {
        pointerEventType = i;
    }

    public void setTransform(AffineTransform affinetransform)
    {
        fireGraphicsNodeChangeStarted();
        transform = affinetransform;
        if(transform.getDeterminant() != 0.0D)
            try
            {
                inverseTransform = transform.createInverse();
            }
            catch(NoninvertibleTransformException noninvertibletransformexception)
            {
                throw new Error();
            }
        else
            inverseTransform = transform;
        if(parent != null)
            parent.invalidateGeometryCache();
        fireGraphicsNodeChangeCompleted();
    }

    public AffineTransform getTransform()
    {
        return transform;
    }

    public AffineTransform getInverseTransform()
    {
        return inverseTransform;
    }

    public AffineTransform getGlobalTransform()
    {
        AffineTransform affinetransform = new AffineTransform();
        for(Object obj = this; obj != null; obj = ((GraphicsNode) (obj)).getParent())
            if(((GraphicsNode) (obj)).getTransform() != null)
                affinetransform.preConcatenate(((GraphicsNode) (obj)).getTransform());

        return affinetransform;
    }

    public void setComposite(Composite composite1)
    {
        fireGraphicsNodeChangeStarted();
        invalidateGeometryCache();
        composite = composite1;
        fireGraphicsNodeChangeCompleted();
    }

    public Composite getComposite()
    {
        return composite;
    }

    public void setVisible(boolean flag)
    {
        fireGraphicsNodeChangeStarted();
        isVisible = flag;
        invalidateGeometryCache();
        fireGraphicsNodeChangeCompleted();
    }

    public boolean isVisible()
    {
        return isVisible;
    }

    public void setClip(ClipRable cliprable)
    {
        fireGraphicsNodeChangeStarted();
        invalidateGeometryCache();
        clip = cliprable;
        fireGraphicsNodeChangeCompleted();
    }

    public ClipRable getClip()
    {
        return clip;
    }

    public void setRenderingHint(java.awt.RenderingHints.Key key, Object obj)
    {
        fireGraphicsNodeChangeStarted();
        if(hints == null)
            hints = new RenderingHints(key, obj);
        else
            hints.put(key, obj);
        fireGraphicsNodeChangeCompleted();
    }

    public void setRenderingHints(Map map)
    {
        fireGraphicsNodeChangeStarted();
        if(hints == null)
            hints = new RenderingHints(map);
        else
            hints.putAll(map);
        fireGraphicsNodeChangeCompleted();
    }

    public void setRenderingHints(RenderingHints renderinghints)
    {
        fireGraphicsNodeChangeStarted();
        hints = renderinghints;
        fireGraphicsNodeChangeCompleted();
    }

    public RenderingHints getRenderingHints()
    {
        return hints;
    }

    public void setMask(Mask mask1)
    {
        fireGraphicsNodeChangeStarted();
        invalidateGeometryCache();
        mask = mask1;
        fireGraphicsNodeChangeCompleted();
    }

    public Mask getMask()
    {
        return mask;
    }

    public void setFilter(Filter filter1)
    {
        fireGraphicsNodeChangeStarted();
        invalidateGeometryCache();
        filter = filter1;
        fireGraphicsNodeChangeCompleted();
    }

    public Filter getFilter()
    {
        return filter;
    }

    public Filter getGraphicsNodeRable(boolean flag)
    {
        Object obj = null;
        if(graphicsNodeRable != null)
        {
            obj = (GraphicsNodeRable)graphicsNodeRable.get();
            if(obj != null)
                return ((Filter) (obj));
        }
        if(flag)
        {
            obj = new GraphicsNodeRable8Bit(this);
            graphicsNodeRable = new WeakReference(obj);
        }
        return ((Filter) (obj));
    }

    public Filter getEnableBackgroundGraphicsNodeRable(boolean flag)
    {
        Object obj = null;
        if(enableBackgroundGraphicsNodeRable != null)
        {
            obj = (GraphicsNodeRable)enableBackgroundGraphicsNodeRable.get();
            if(obj != null)
                return ((Filter) (obj));
        }
        if(flag)
        {
            obj = new GraphicsNodeRable8Bit(this);
            ((GraphicsNodeRable) (obj)).setUsePrimitivePaint(false);
            enableBackgroundGraphicsNodeRable = new WeakReference(obj);
        }
        return ((Filter) (obj));
    }

    public void paint(Graphics2D graphics2d)
    {
        if(composite != null && (composite instanceof AlphaComposite))
        {
            AlphaComposite alphacomposite = (AlphaComposite)composite;
            if((double)alphacomposite.getAlpha() < 0.001D)
                return;
        }
        Rectangle2D rectangle2d = getBounds();
        if(rectangle2d == null)
            return;
        Shape shape = graphics2d.getClip();
        Composite composite1 = graphics2d.getComposite();
        AffineTransform affinetransform = graphics2d.getTransform();
        RenderingHints renderinghints = null;
        if(hints != null)
        {
            renderinghints = graphics2d.getRenderingHints();
            graphics2d.addRenderingHints(hints);
        }
        if(transform != null)
            graphics2d.transform(transform);
        if(composite != null)
            graphics2d.setComposite(composite);
        if(clip != null)
            graphics2d.clip(clip.getClipPath());
        Shape shape1 = graphics2d.getClip();
        graphics2d.setRenderingHint(RenderingHintsKeyExt.KEY_AREA_OF_INTEREST, shape1);
        boolean flag = true;
        Shape shape2 = shape1;
        if(shape2 != null)
        {
            Rectangle2D rectangle2d1 = shape2.getBounds2D();
            if(!rectangle2d.intersects(rectangle2d1.getX(), rectangle2d1.getY(), rectangle2d1.getWidth(), rectangle2d1.getHeight()))
                flag = false;
        }
        if(flag)
        {
            boolean flag1 = false;
            if(clip != null && clip.getUseAntialiasedClip())
                flag1 = isAntialiasedClip(graphics2d.getTransform(), graphics2d.getRenderingHints(), clip.getClipPath());
            boolean flag2 = isOffscreenBufferNeeded();
            flag2 |= flag1;
            if(!flag2)
            {
                primitivePaint(graphics2d);
            } else
            {
                Object obj = null;
                if(filter == null)
                    obj = getGraphicsNodeRable(true);
                else
                    obj = filter;
                if(mask != null)
                {
                    if(mask.getSource() != obj)
                        mask.setSource(((Filter) (obj)));
                    obj = mask;
                }
                if(clip != null && flag1)
                {
                    if(clip.getSource() != obj)
                        clip.setSource(((Filter) (obj)));
                    obj = clip;
                }
                if(flag1)
                    graphics2d.setClip(null);
                Rectangle2D rectangle2d2 = ((Filter) (obj)).getBounds2D();
                graphics2d.clip(rectangle2d2);
                GraphicsUtil.drawImage(graphics2d, ((java.awt.image.renderable.RenderableImage) (obj)));
            }
        }
        if(renderinghints != null)
            graphics2d.setRenderingHints(renderinghints);
        graphics2d.setTransform(affinetransform);
        graphics2d.setClip(shape);
        if(composite != null)
            graphics2d.setComposite(composite1);
    }

    private void traceFilter(Filter filter1, String s)
    {
        System.out.println(s + filter1.getClass().getName());
        System.out.println(s + filter1.getBounds2D());
        Vector vector = filter1.getSources();
        int i = vector == null ? 0 : vector.size();
        s = s + "\t";
        for(int j = 0; j < i; j++)
        {
            Filter filter2 = (Filter)vector.elementAt(j);
            traceFilter(filter2, s);
        }

        System.out.flush();
    }

    protected boolean isOffscreenBufferNeeded()
    {
        return filter != null || mask != null || composite != null && !AlphaComposite.SrcOver.equals(composite);
    }

    protected boolean isAntialiasedClip(AffineTransform affinetransform, RenderingHints renderinghints, Shape shape)
    {
        if(shape == null)
            return false;
        Object obj = renderinghints.get(RenderingHintsKeyExt.KEY_TRANSCODING);
        if(obj == RenderingHintsKeyExt.VALUE_TRANSCODING_PRINTING || obj == RenderingHintsKeyExt.VALUE_TRANSCODING_VECTOR)
            return false;
        return !(shape instanceof Rectangle2D) || affinetransform.getShearX() != 0.0D || affinetransform.getShearY() != 0.0D;
    }

    public void fireGraphicsNodeChangeStarted(GraphicsNode graphicsnode)
    {
        if(changeStartedEvent == null)
            changeStartedEvent = new GraphicsNodeChangeEvent(this, 9800);
        changeStartedEvent.setChangeSrc(graphicsnode);
        fireGraphicsNodeChangeStarted(changeStartedEvent);
        changeStartedEvent.setChangeSrc(null);
    }

    public void fireGraphicsNodeChangeStarted()
    {
        if(changeStartedEvent == null)
            changeStartedEvent = new GraphicsNodeChangeEvent(this, 9800);
        else
            changeStartedEvent.setChangeSrc(null);
        fireGraphicsNodeChangeStarted(changeStartedEvent);
    }

    public void fireGraphicsNodeChangeStarted(GraphicsNodeChangeEvent graphicsnodechangeevent)
    {
        RootGraphicsNode rootgraphicsnode = getRoot();
        if(rootgraphicsnode == null)
            return;
        java.util.List list = rootgraphicsnode.getTreeGraphicsNodeChangeListeners();
        if(list == null)
            return;
        GraphicsNodeChangeListener graphicsnodechangelistener;
        for(Iterator iterator = list.iterator(); iterator.hasNext(); graphicsnodechangelistener.changeStarted(graphicsnodechangeevent))
            graphicsnodechangelistener = (GraphicsNodeChangeListener)iterator.next();

    }

    public void fireGraphicsNodeChangeCompleted()
    {
        if(changeCompletedEvent == null)
            changeCompletedEvent = new GraphicsNodeChangeEvent(this, 9801);
        RootGraphicsNode rootgraphicsnode = getRoot();
        if(rootgraphicsnode == null)
            return;
        java.util.List list = rootgraphicsnode.getTreeGraphicsNodeChangeListeners();
        if(list == null)
            return;
        GraphicsNodeChangeListener graphicsnodechangelistener;
        for(Iterator iterator = list.iterator(); iterator.hasNext(); graphicsnodechangelistener.changeCompleted(changeCompletedEvent))
            graphicsnodechangelistener = (GraphicsNodeChangeListener)iterator.next();

    }

    public CompositeGraphicsNode getParent()
    {
        return parent;
    }

    public RootGraphicsNode getRoot()
    {
        return root;
    }

    protected void setRoot(RootGraphicsNode rootgraphicsnode)
    {
        root = rootgraphicsnode;
    }

    protected void setParent(CompositeGraphicsNode compositegraphicsnode)
    {
        parent = compositegraphicsnode;
    }

    protected void invalidateGeometryCache()
    {
        if(parent != null)
            parent.invalidateGeometryCache();
        bounds = null;
    }

    public Rectangle2D getBounds()
    {
        if(bounds == null)
        {
            if(filter == null)
                bounds = getPrimitiveBounds();
            else
                bounds = filter.getBounds2D();
            if(bounds != null)
            {
                if(clip != null)
                {
                    Rectangle2D rectangle2d = clip.getClipPath().getBounds2D();
                    if(rectangle2d.intersects(bounds))
                        Rectangle2D.intersect(bounds, rectangle2d, bounds);
                }
                if(mask != null)
                {
                    Rectangle2D rectangle2d1 = mask.getBounds2D();
                    if(rectangle2d1.intersects(bounds))
                        Rectangle2D.intersect(bounds, rectangle2d1, bounds);
                }
            }
            bounds = normalizeRectangle(bounds);
            if(HaltingThread.hasBeenHalted())
                invalidateGeometryCache();
        }
        return bounds;
    }

    public Rectangle2D getTransformedBounds(AffineTransform affinetransform)
    {
        AffineTransform affinetransform1 = affinetransform;
        if(transform != null)
        {
            affinetransform1 = new AffineTransform(affinetransform);
            affinetransform1.concatenate(transform);
        }
        Rectangle2D rectangle2d = null;
        if(filter == null)
            rectangle2d = getTransformedPrimitiveBounds(affinetransform);
        else
            rectangle2d = affinetransform1.createTransformedShape(filter.getBounds2D()).getBounds2D();
        if(rectangle2d != null)
        {
            if(clip != null)
                Rectangle2D.intersect(rectangle2d, affinetransform1.createTransformedShape(clip.getClipPath()).getBounds2D(), rectangle2d);
            if(mask != null)
                Rectangle2D.intersect(rectangle2d, affinetransform1.createTransformedShape(mask.getBounds2D()).getBounds2D(), rectangle2d);
        }
        return rectangle2d;
    }

    public Rectangle2D getTransformedPrimitiveBounds(AffineTransform affinetransform)
    {
        Rectangle2D rectangle2d = getPrimitiveBounds();
        if(rectangle2d == null)
            return null;
        AffineTransform affinetransform1 = affinetransform;
        if(transform != null)
        {
            affinetransform1 = new AffineTransform(affinetransform);
            affinetransform1.concatenate(transform);
        }
        return affinetransform1.createTransformedShape(rectangle2d).getBounds2D();
    }

    public Rectangle2D getTransformedGeometryBounds(AffineTransform affinetransform)
    {
        Rectangle2D rectangle2d = getGeometryBounds();
        if(rectangle2d == null)
            return null;
        AffineTransform affinetransform1 = affinetransform;
        if(transform != null)
        {
            affinetransform1 = new AffineTransform(affinetransform);
            affinetransform1.concatenate(transform);
        }
        return affinetransform1.createTransformedShape(rectangle2d).getBounds2D();
    }

    public Rectangle2D getTransformedSensitiveBounds(AffineTransform affinetransform)
    {
        Rectangle2D rectangle2d = getSensitiveBounds();
        if(rectangle2d == null)
            return null;
        AffineTransform affinetransform1 = affinetransform;
        if(transform != null)
        {
            affinetransform1 = new AffineTransform(affinetransform);
            affinetransform1.concatenate(transform);
        }
        return affinetransform1.createTransformedShape(rectangle2d).getBounds2D();
    }

    public boolean contains(Point2D point2d)
    {
        Rectangle2D rectangle2d = getSensitiveBounds();
        if(rectangle2d == null || !rectangle2d.contains(point2d))
            return false;
        switch(pointerEventType)
        {
        case 0: // '\0'
        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
            return isVisible;

        case 4: // '\004'
        case 5: // '\005'
        case 6: // '\006'
        case 7: // '\007'
            return true;

        case 8: // '\b'
        default:
            return false;
        }
    }

    public boolean intersects(Rectangle2D rectangle2d)
    {
        Rectangle2D rectangle2d1 = getBounds();
        if(rectangle2d1 == null)
            return false;
        else
            return rectangle2d1.intersects(rectangle2d);
    }

    public GraphicsNode nodeHitAt(Point2D point2d)
    {
        return contains(point2d) ? this : null;
    }

    protected Rectangle2D normalizeRectangle(Rectangle2D rectangle2d)
    {
        if(rectangle2d == null)
            return null;
        if(rectangle2d.getWidth() < EPSILON)
        {
            if(rectangle2d.getHeight() < EPSILON)
            {
                AffineTransform affinetransform = getGlobalTransform();
                double d2 = Math.sqrt(affinetransform.getDeterminant());
                return new java.awt.geom.Rectangle2D.Double(rectangle2d.getX(), rectangle2d.getY(), EPSILON / d2, EPSILON / d2);
            }
            double d = rectangle2d.getHeight() * EPSILON;
            if(d < rectangle2d.getWidth())
                d = rectangle2d.getWidth();
            return new java.awt.geom.Rectangle2D.Double(rectangle2d.getX(), rectangle2d.getY(), d, rectangle2d.getHeight());
        }
        if(rectangle2d.getHeight() < EPSILON)
        {
            double d1 = rectangle2d.getWidth() * EPSILON;
            if(d1 < rectangle2d.getHeight())
                d1 = rectangle2d.getHeight();
            return new java.awt.geom.Rectangle2D.Double(rectangle2d.getX(), rectangle2d.getY(), rectangle2d.getWidth(), d1);
        } else
        {
            return rectangle2d;
        }
    }

    protected EventListenerList listeners;
    protected AffineTransform transform;
    protected AffineTransform inverseTransform;
    protected Composite composite;
    protected boolean isVisible;
    protected ClipRable clip;
    protected RenderingHints hints;
    protected CompositeGraphicsNode parent;
    protected RootGraphicsNode root;
    protected Mask mask;
    protected Filter filter;
    protected int pointerEventType;
    protected WeakReference graphicsNodeRable;
    protected WeakReference enableBackgroundGraphicsNodeRable;
    protected WeakReference weakRef;
    private Rectangle2D bounds;
    protected GraphicsNodeChangeEvent changeStartedEvent;
    protected GraphicsNodeChangeEvent changeCompletedEvent;
    static double EPSILON = 9.9999999999999995E-07D;

}
