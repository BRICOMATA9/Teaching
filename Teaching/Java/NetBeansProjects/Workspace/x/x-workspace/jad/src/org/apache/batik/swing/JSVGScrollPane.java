// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.swing;

import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.apache.batik.bridge.*;
import org.apache.batik.gvt.GraphicsNode;
import org.apache.batik.swing.gvt.JGVTComponentListener;
import org.apache.batik.swing.svg.GVTTreeBuilderEvent;
import org.apache.batik.swing.svg.GVTTreeBuilderListener;
import org.apache.batik.swing.svg.SVGDocumentLoaderAdapter;
import org.apache.batik.swing.svg.SVGDocumentLoaderEvent;
import org.w3c.dom.events.Event;
import org.w3c.dom.events.EventListener;
import org.w3c.dom.svg.SVGDocument;
import org.w3c.dom.svg.SVGSVGElement;

// Referenced classes of package org.apache.batik.swing:
//            JSVGCanvas

public class JSVGScrollPane extends JPanel
{
    protected class ScrollListener extends ComponentAdapter
        implements JGVTComponentListener, GVTTreeBuilderListener, UpdateManagerListener
    {

        public void componentTransformChanged(ComponentEvent componentevent)
        {
            if(isReady)
                resizeScrollBars();
        }

        public void componentResized(ComponentEvent componentevent)
        {
            if(isReady)
                resizeScrollBars();
        }

        public void gvtBuildPrepare(GVTTreeBuilderEvent gvttreebuilderevent)
        {
            isReady = false;
            vertical.setVisible(false);
            horizontalPanel.setVisible(false);
            cornerBox.setVisible(false);
        }

        public void gvtBuildCompleted(GVTTreeBuilderEvent gvttreebuilderevent)
        {
            isReady = true;
            viewBox = null;
        }

        public void updateCompleted(UpdateManagerEvent updatemanagerevent)
        {
            if(viewBox == null)
            {
                resizeScrollBars();
                return;
            }
            Rectangle2D rectangle2d = getViewBoxRect();
            if(rectangle2d.getX() != viewBox.getX() || rectangle2d.getY() != viewBox.getY() || rectangle2d.getWidth() != viewBox.getWidth() || rectangle2d.getHeight() != viewBox.getHeight())
            {
                viewBox = rectangle2d;
                resizeScrollBars();
            }
        }

        public void gvtBuildCancelled(GVTTreeBuilderEvent gvttreebuilderevent)
        {
        }

        public void gvtBuildFailed(GVTTreeBuilderEvent gvttreebuilderevent)
        {
        }

        public void gvtBuildStarted(GVTTreeBuilderEvent gvttreebuilderevent)
        {
        }

        public void managerStarted(UpdateManagerEvent updatemanagerevent)
        {
        }

        public void managerSuspended(UpdateManagerEvent updatemanagerevent)
        {
        }

        public void managerResumed(UpdateManagerEvent updatemanagerevent)
        {
        }

        public void managerStopped(UpdateManagerEvent updatemanagerevent)
        {
        }

        public void updateStarted(UpdateManagerEvent updatemanagerevent)
        {
        }

        public void updateFailed(UpdateManagerEvent updatemanagerevent)
        {
        }

        protected boolean isReady;

        protected ScrollListener()
        {
            isReady = false;
        }
    }

    protected class SBListener
        implements ChangeListener
    {

        public synchronized void stateChanged(ChangeEvent changeevent)
        {
            if(ignoreScrollChange)
                return;
            Object obj = changeevent.getSource();
            if(!(obj instanceof BoundedRangeModel))
                return;
            int i = isVertical ? vertical.getValue() : horizontal.getValue();
            BoundedRangeModel boundedrangemodel = (BoundedRangeModel)obj;
            if(boundedrangemodel.getValueIsAdjusting())
            {
                if(!inDrag)
                {
                    inDrag = true;
                    startValue = i;
                } else
                {
                    AffineTransform affinetransform;
                    if(isVertical)
                        affinetransform = AffineTransform.getTranslateInstance(0.0D, startValue - i);
                    else
                        affinetransform = AffineTransform.getTranslateInstance(startValue - i, 0.0D);
                    canvas.setPaintingTransform(affinetransform);
                }
            } else
            {
                if(inDrag)
                {
                    inDrag = false;
                    if(i == startValue)
                    {
                        canvas.setPaintingTransform(new AffineTransform());
                        return;
                    }
                }
                setScrollPosition();
            }
        }

        protected boolean inDrag;
        protected int startValue;
        protected boolean isVertical;

        public SBListener(boolean flag)
        {
            inDrag = false;
            isVertical = flag;
        }
    }

    class SVGScrollDocumentLoaderListener extends SVGDocumentLoaderAdapter
    {

        public void documentLoadingCompleted(SVGDocumentLoaderEvent svgdocumentloaderevent)
        {
            SVGSVGElement svgsvgelement = svgdocumentloaderevent.getSVGDocument().getRootElement();
            svgsvgelement.addEventListener("SVGZoom", new EventListener() {

                public void handleEvent(Event event)
                {
                    if(!(event.getTarget() instanceof SVGSVGElement))
                    {
                        return;
                    } else
                    {
                        SVGSVGElement svgsvgelement1 = (SVGSVGElement)event.getTarget();
                        scaleChange(svgsvgelement1.getCurrentScale());
                        return;
                    }
                }

            }, false);
        }


        SVGScrollDocumentLoaderListener()
        {
        }
    }


    public JSVGScrollPane(JSVGCanvas jsvgcanvas)
    {
        viewBox = null;
        ignoreScrollChange = false;
        canvas = jsvgcanvas;
        jsvgcanvas.setRecenterOnResize(false);
        vertical = new JScrollBar(1, 0, 0, 0, 0);
        horizontal = new JScrollBar(0, 0, 0, 0, 0);
        horizontalPanel = new JPanel(new BorderLayout());
        horizontalPanel.add(horizontal, "Center");
        cornerBox = Box.createRigidArea(new Dimension(vertical.getPreferredSize().width, horizontal.getPreferredSize().height));
        horizontalPanel.add(cornerBox, "East");
        hsbListener = createScrollBarListener(false);
        horizontal.getModel().addChangeListener(hsbListener);
        vsbListener = createScrollBarListener(true);
        vertical.getModel().addChangeListener(vsbListener);
        horizontalPanel.setVisible(false);
        vertical.setVisible(false);
        setLayout(new BorderLayout());
        add(jsvgcanvas, "Center");
        add(vertical, "East");
        add(horizontalPanel, "South");
        jsvgcanvas.addSVGDocumentLoaderListener(new SVGScrollDocumentLoaderListener());
        ScrollListener scrolllistener = new ScrollListener();
        addComponentListener(scrolllistener);
        jsvgcanvas.addJGVTComponentListener(scrolllistener);
        jsvgcanvas.addGVTTreeBuilderListener(scrolllistener);
        jsvgcanvas.addUpdateManagerListener(scrolllistener);
    }

    protected SBListener createScrollBarListener(boolean flag)
    {
        return new SBListener(flag);
    }

    public JSVGCanvas getCanvas()
    {
        return canvas;
    }

    public void reset()
    {
        viewBox = null;
        horizontalPanel.setVisible(false);
        vertical.setVisible(false);
        revalidate();
    }

    protected void setScrollPosition()
    {
        checkAndSetViewBoxRect();
        if(viewBox == null)
            return;
        AffineTransform affinetransform = canvas.getRenderingTransform();
        AffineTransform affinetransform1 = canvas.getViewBoxTransform();
        if(affinetransform == null)
            affinetransform = new AffineTransform();
        if(affinetransform1 == null)
            affinetransform1 = new AffineTransform();
        Rectangle rectangle = affinetransform1.createTransformedShape(viewBox).getBounds();
        int i = 0;
        int j = 0;
        if(rectangle.x < 0)
            i -= rectangle.x;
        if(rectangle.y < 0)
            j -= rectangle.y;
        int k = horizontal.getValue() - i;
        int l = vertical.getValue() - j;
        affinetransform.preConcatenate(AffineTransform.getTranslateInstance(-k, -l));
        canvas.setRenderingTransform(affinetransform);
    }

    protected void resizeScrollBars()
    {
        ignoreScrollChange = true;
        checkAndSetViewBoxRect();
        if(viewBox == null)
            return;
        AffineTransform affinetransform = canvas.getViewBoxTransform();
        if(affinetransform == null)
            affinetransform = new AffineTransform();
        Rectangle rectangle = affinetransform.createTransformedShape(viewBox).getBounds();
        int i = rectangle.width;
        int j = rectangle.height;
        int k = 0;
        int l = 0;
        if(rectangle.x > 0)
            i += rectangle.x;
        else
            k -= rectangle.x;
        if(rectangle.y > 0)
            j += rectangle.y;
        else
            l -= rectangle.y;
        vertical.setValue(l);
        horizontal.setValue(k);
        Dimension dimension = updateScrollbarVisibility(k, l, i, j);
        vertical.setValues(l, dimension.height, 0, j);
        horizontal.setValues(k, dimension.width, 0, i);
        vertical.setBlockIncrement((int)(0.9F * (float)dimension.height));
        horizontal.setBlockIncrement((int)(0.9F * (float)dimension.width));
        vertical.setUnitIncrement((int)(0.2F * (float)dimension.height));
        horizontal.setUnitIncrement((int)(0.2F * (float)dimension.width));
        ignoreScrollChange = false;
    }

    protected Dimension updateScrollbarVisibility(int i, int j, int k, int l)
    {
        Dimension dimension = canvas.getSize();
        int i1 = dimension.width;
        int j1 = dimension.width;
        int k1 = dimension.height;
        int l1 = dimension.height;
        if(vertical.isVisible())
            i1 += vertical.getPreferredSize().width;
        else
            j1 -= vertical.getPreferredSize().width;
        if(horizontalPanel.isVisible())
            k1 += horizontal.getPreferredSize().height;
        else
            l1 -= horizontal.getPreferredSize().height;
        boolean flag = l > k1 || vertical.getValue() != 0;
        boolean flag1 = k > i1 || horizontal.getValue() != 0;
        Dimension dimension1 = new Dimension();
        if(flag)
        {
            if(flag1)
            {
                horizontalPanel.setVisible(true);
                vertical.setVisible(true);
                cornerBox.setVisible(true);
                dimension1.width = j1;
                dimension1.height = l1;
            } else
            {
                vertical.setVisible(true);
                dimension1.width = j1;
                if(k > j1)
                {
                    horizontalPanel.setVisible(true);
                    cornerBox.setVisible(true);
                    dimension1.height = l1;
                } else
                {
                    horizontalPanel.setVisible(false);
                    cornerBox.setVisible(false);
                    dimension1.height = k1;
                }
            }
        } else
        if(flag1)
        {
            horizontalPanel.setVisible(true);
            dimension1.height = l1;
            if(l > l1)
            {
                vertical.setVisible(true);
                cornerBox.setVisible(true);
                dimension1.width = j1;
            } else
            {
                vertical.setVisible(false);
                cornerBox.setVisible(false);
                dimension1.width = i1;
            }
        } else
        {
            vertical.setVisible(false);
            horizontalPanel.setVisible(false);
            cornerBox.setVisible(false);
            dimension1.width = i1;
            dimension1.height = k1;
        }
        return dimension1;
    }

    protected void checkAndSetViewBoxRect()
    {
        if(viewBox != null)
        {
            return;
        } else
        {
            viewBox = getViewBoxRect();
            return;
        }
    }

    protected Rectangle2D getViewBoxRect()
    {
        SVGDocument svgdocument = canvas.getSVGDocument();
        if(svgdocument == null)
            return null;
        SVGSVGElement svgsvgelement = svgdocument.getRootElement();
        if(svgsvgelement == null)
            return null;
        String s = svgsvgelement.getAttributeNS(null, "viewBox");
        if(s.length() != 0)
        {
            float af[] = ViewBox.parseViewBoxAttribute(svgsvgelement, s);
            return new Float(af[0], af[1], af[2], af[3]);
        }
        GraphicsNode graphicsnode = canvas.getGraphicsNode();
        if(graphicsnode == null)
            return null;
        else
            return (Rectangle2D)graphicsnode.getBounds().clone();
    }

    public void scaleChange(float f)
    {
    }

    protected JSVGCanvas canvas;
    protected JPanel horizontalPanel;
    protected JScrollBar vertical;
    protected JScrollBar horizontal;
    protected Component cornerBox;
    protected SBListener hsbListener;
    protected SBListener vsbListener;
    protected Rectangle2D viewBox;
    protected boolean ignoreScrollChange;
}
