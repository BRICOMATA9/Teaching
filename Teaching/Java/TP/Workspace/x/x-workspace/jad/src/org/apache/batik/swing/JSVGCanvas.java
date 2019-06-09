// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.swing;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.AffineTransform;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Map;
import java.util.WeakHashMap;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.ToolTipManager;
import org.apache.batik.bridge.UserAgent;
import org.apache.batik.gvt.GraphicsNode;
import org.apache.batik.swing.gvt.AbstractImageZoomInteractor;
import org.apache.batik.swing.gvt.AbstractPanInteractor;
import org.apache.batik.swing.gvt.AbstractResetTransformInteractor;
import org.apache.batik.swing.gvt.AbstractRotateInteractor;
import org.apache.batik.swing.gvt.AbstractZoomInteractor;
import org.apache.batik.swing.gvt.Interactor;
import org.apache.batik.swing.gvt.JGVTComponent;
import org.apache.batik.swing.svg.JSVGComponent;
import org.apache.batik.swing.svg.SVGDocumentLoaderEvent;
import org.apache.batik.swing.svg.SVGUserAgent;
import org.apache.batik.util.XMLConstants;
import org.apache.batik.util.gui.JErrorPane;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.events.Event;
import org.w3c.dom.events.EventListener;
import org.w3c.dom.events.EventTarget;
import org.w3c.dom.svg.SVGDocument;

// Referenced classes of package org.apache.batik.swing:
//            Messages

public class JSVGCanvas extends JSVGComponent
{
    protected class ToolTipRunnable
        implements Runnable
    {

        public void run()
        {
            setToolTipText(theToolTip);
            if(theToolTip != null)
            {
                MouseEvent mouseevent = new MouseEvent(JSVGCanvas.this, 504, System.currentTimeMillis(), 0, locationListener.getLastX(), locationListener.getLastY(), 0, false);
                ToolTipManager.sharedInstance().mouseEntered(mouseevent);
                mouseevent = new MouseEvent(JSVGCanvas.this, 503, System.currentTimeMillis(), 0, locationListener.getLastX(), locationListener.getLastY(), 0, false);
                ToolTipManager.sharedInstance().mouseMoved(mouseevent);
            } else
            {
                MouseEvent mouseevent1 = new MouseEvent(JSVGCanvas.this, 503, System.currentTimeMillis(), 0, locationListener.getLastX(), locationListener.getLastY(), 0, false);
                ToolTipManager.sharedInstance().mouseMoved(mouseevent1);
            }
        }

        String theToolTip;

        public ToolTipRunnable(String s)
        {
            theToolTip = s;
        }
    }

    protected class ToolTipModifier
        implements EventListener
    {

        public void handleEvent(Event event)
        {
            if(matchLastToolTipEvent(event.getTimeStamp(), event.getTarget()))
                return;
            setLastToolTipEvent(event.getTimeStamp(), event.getTarget());
            EventTarget eventtarget = lastTarget;
            if("mouseover".equals(event.getType()))
                lastTarget = event.getTarget();
            else
            if("mouseout".equals(event.getType()))
            {
                org.w3c.dom.events.MouseEvent mouseevent = (org.w3c.dom.events.MouseEvent)event;
                lastTarget = mouseevent.getRelatedTarget();
            }
            if(toolTipMap != null)
            {
                Object obj = toolTipMap.get(lastTarget);
                String s;
                if(obj == null)
                    s = null;
                else
                    s = (String)obj;
                if(eventtarget != lastTarget)
                    EventQueue.invokeLater(new ToolTipRunnable(s));
            }
        }

        protected CanvasUserAgent canvasUserAgent;

        public ToolTipModifier()
        {
        }
    }

    protected class LocationListener extends MouseMotionAdapter
    {

        public void mouseMoved(MouseEvent mouseevent)
        {
            lastX = mouseevent.getX();
            lastY = mouseevent.getY();
        }

        public int getLastX()
        {
            return lastX;
        }

        public int getLastY()
        {
            return lastY;
        }

        protected int lastX;
        protected int lastY;

        public LocationListener()
        {
            lastX = 0;
            lastY = 0;
        }
    }

    public class ScrollDownAction extends ScrollAction
    {

        public ScrollDownAction(int i)
        {
            super(0.0D, -i);
        }
    }

    public class ScrollUpAction extends ScrollAction
    {

        public ScrollUpAction(int i)
        {
            super(0.0D, i);
        }
    }

    public class ScrollLeftAction extends ScrollAction
    {

        public ScrollLeftAction(int i)
        {
            super(i, 0.0D);
        }
    }

    public class ScrollRightAction extends ScrollAction
    {

        public ScrollRightAction(int i)
        {
            super(-i, 0.0D);
        }
    }

    public class ScrollAction extends AffineAction
    {

        public ScrollAction(double d, double d1)
        {
            super(AffineTransform.getTranslateInstance(d, d1));
        }
    }

    public class RotateAction extends AffineAction
    {

        public RotateAction(double d)
        {
            super(AffineTransform.getRotateInstance(d));
        }
    }

    public class ZoomOutAction extends ZoomAction
    {

        ZoomOutAction()
        {
            super(0.5D);
        }
    }

    public class ZoomInAction extends ZoomAction
    {

        ZoomInAction()
        {
            super(2D);
        }
    }

    public class ZoomAction extends AffineAction
    {

        public ZoomAction(double d)
        {
            super(AffineTransform.getScaleInstance(d, d));
        }

        public ZoomAction(double d, double d1)
        {
            super(AffineTransform.getScaleInstance(d, d1));
        }
    }

    protected class CanvasSVGListener extends org.apache.batik.swing.svg.JSVGComponent.SVGListener
    {

        public void documentLoadingStarted(SVGDocumentLoaderEvent svgdocumentloaderevent)
        {
            documentLoadingStarted(svgdocumentloaderevent);
            setToolTipText(null);
        }

        protected CanvasSVGListener()
        {
        }
    }


    public JSVGCanvas()
    {
        JSVGCanvas(null, true, true);
        addMouseMotionListener(locationListener);
    }

    public JSVGCanvas(SVGUserAgent svguseragent, boolean flag, boolean flag1)
    {
        JSVGComponent(svguseragent, flag, flag1);
        isZoomInteractorEnabled = true;
        isImageZoomInteractorEnabled = true;
        isPanInteractorEnabled = true;
        isRotateInteractorEnabled = true;
        isResetTransformInteractorEnabled = true;
        pcs = new PropertyChangeSupport(this);
        locationListener = new LocationListener();
        toolTipMap = null;
        toolTipListener = new ToolTipModifier();
        lastTarget = null;
        setPreferredSize(new Dimension(200, 200));
        setMinimumSize(new Dimension(100, 100));
        java.util.List list = getInteractors();
        list.add(zoomInteractor);
        list.add(imageZoomInteractor);
        list.add(panInteractor);
        list.add(rotateInteractor);
        list.add(resetTransformInteractor);
        installActions();
        if(flag)
        {
            addMouseListener(new MouseAdapter() {

                public void mousePressed(MouseEvent mouseevent)
                {
                    requestFocus();
                }

            });
            installKeyboardActions();
        }
        addMouseMotionListener(locationListener);
    }

    protected void installActions()
    {
        ActionMap actionmap = getActionMap();
        actionmap.put("ScrollRight", new ScrollRightAction(10));
        actionmap.put("ScrollLeft", new ScrollLeftAction(10));
        actionmap.put("ScrollUp", new ScrollUpAction(10));
        actionmap.put("ScrollDown", new ScrollDownAction(10));
        actionmap.put("FastScrollRight", new ScrollRightAction(30));
        actionmap.put("FastScrollLeft", new ScrollLeftAction(30));
        actionmap.put("FastScrollUp", new ScrollUpAction(30));
        actionmap.put("FastScrollDown", new ScrollDownAction(30));
        actionmap.put("ZoomIn", new ZoomInAction());
        actionmap.put("ZoomOut", new ZoomOutAction());
        actionmap.put("ResetTransform", new ResetTransformAction());
    }

    public void setDisableInteractions(boolean flag)
    {
        setDisableInteractions(flag);
        ActionMap actionmap = getActionMap();
        actionmap.get("ScrollRight").setEnabled(!flag);
        actionmap.get("ScrollLeft").setEnabled(!flag);
        actionmap.get("ScrollUp").setEnabled(!flag);
        actionmap.get("ScrollDown").setEnabled(!flag);
        actionmap.get("FastScrollRight").setEnabled(!flag);
        actionmap.get("FastScrollLeft").setEnabled(!flag);
        actionmap.get("FastScrollUp").setEnabled(!flag);
        actionmap.get("FastScrollDown").setEnabled(!flag);
        actionmap.get("ZoomIn").setEnabled(!flag);
        actionmap.get("ZoomOut").setEnabled(!flag);
        actionmap.get("ResetTransform").setEnabled(!flag);
    }

    protected void installKeyboardActions()
    {
        InputMap inputmap = getInputMap(0);
        KeyStroke keystroke = KeyStroke.getKeyStroke(39, 0);
        inputmap.put(keystroke, "ScrollRight");
        keystroke = KeyStroke.getKeyStroke(37, 0);
        inputmap.put(keystroke, "ScrollLeft");
        keystroke = KeyStroke.getKeyStroke(38, 0);
        inputmap.put(keystroke, "ScrollUp");
        keystroke = KeyStroke.getKeyStroke(40, 0);
        inputmap.put(keystroke, "ScrollDown");
        keystroke = KeyStroke.getKeyStroke(39, 1);
        inputmap.put(keystroke, "FastScrollRight");
        keystroke = KeyStroke.getKeyStroke(37, 1);
        inputmap.put(keystroke, "FastScrollLeft");
        keystroke = KeyStroke.getKeyStroke(38, 1);
        inputmap.put(keystroke, "FastScrollUp");
        keystroke = KeyStroke.getKeyStroke(40, 1);
        inputmap.put(keystroke, "FastScrollDown");
        keystroke = KeyStroke.getKeyStroke(73, 2);
        inputmap.put(keystroke, "ZoomIn");
        keystroke = KeyStroke.getKeyStroke(79, 2);
        inputmap.put(keystroke, "ZoomOut");
        keystroke = KeyStroke.getKeyStroke(84, 2);
        inputmap.put(keystroke, "ResetTransform");
    }

    public void addPropertyChangeListener(PropertyChangeListener propertychangelistener)
    {
        pcs.addPropertyChangeListener(propertychangelistener);
    }

    public void removePropertyChangeListener(PropertyChangeListener propertychangelistener)
    {
        pcs.removePropertyChangeListener(propertychangelistener);
    }

    public void addPropertyChangeListener(String s, PropertyChangeListener propertychangelistener)
    {
        pcs.addPropertyChangeListener(s, propertychangelistener);
    }

    public void removePropertyChangeListener(String s, PropertyChangeListener propertychangelistener)
    {
        pcs.removePropertyChangeListener(s, propertychangelistener);
    }

    public void setEnableZoomInteractor(boolean flag)
    {
        if(isZoomInteractorEnabled != flag)
        {
            boolean flag1 = isZoomInteractorEnabled;
            isZoomInteractorEnabled = flag;
            if(isZoomInteractorEnabled)
                getInteractors().add(zoomInteractor);
            else
                getInteractors().remove(zoomInteractor);
            pcs.firePropertyChange("enableZoomInteractor", flag1, flag);
        }
    }

    public boolean getEnableZoomInteractor()
    {
        return isZoomInteractorEnabled;
    }

    public void setEnableImageZoomInteractor(boolean flag)
    {
        if(isImageZoomInteractorEnabled != flag)
        {
            boolean flag1 = isImageZoomInteractorEnabled;
            isImageZoomInteractorEnabled = flag;
            if(isImageZoomInteractorEnabled)
                getInteractors().add(imageZoomInteractor);
            else
                getInteractors().remove(imageZoomInteractor);
            pcs.firePropertyChange("enableImageZoomInteractor", flag1, flag);
        }
    }

    public boolean getEnableImageZoomInteractor()
    {
        return isImageZoomInteractorEnabled;
    }

    public void setEnablePanInteractor(boolean flag)
    {
        if(isPanInteractorEnabled != flag)
        {
            boolean flag1 = isPanInteractorEnabled;
            isPanInteractorEnabled = flag;
            if(isPanInteractorEnabled)
                getInteractors().add(panInteractor);
            else
                getInteractors().remove(panInteractor);
            pcs.firePropertyChange("enablePanInteractor", flag1, flag);
        }
    }

    public boolean getEnablePanInteractor()
    {
        return isPanInteractorEnabled;
    }

    public void setEnableRotateInteractor(boolean flag)
    {
        if(isRotateInteractorEnabled != flag)
        {
            boolean flag1 = isRotateInteractorEnabled;
            isRotateInteractorEnabled = flag;
            if(isRotateInteractorEnabled)
                getInteractors().add(rotateInteractor);
            else
                getInteractors().remove(rotateInteractor);
            pcs.firePropertyChange("enableRotateInteractor", flag1, flag);
        }
    }

    public boolean getEnableRotateInteractor()
    {
        return isRotateInteractorEnabled;
    }

    public void setEnableResetTransformInteractor(boolean flag)
    {
        if(isResetTransformInteractorEnabled != flag)
        {
            boolean flag1 = isResetTransformInteractorEnabled;
            isResetTransformInteractorEnabled = flag;
            if(isResetTransformInteractorEnabled)
                getInteractors().add(resetTransformInteractor);
            else
                getInteractors().remove(resetTransformInteractor);
            pcs.firePropertyChange("enableResetTransformInteractor", flag1, flag);
        }
    }

    public boolean getEnableResetTransformInteractor()
    {
        return isResetTransformInteractorEnabled;
    }

    public String getURI()
    {
        return uri;
    }

    public void setURI(String s)
    {
        String s1 = uri;
        uri = s;
        if(uri != null)
            loadSVGDocument(uri);
        else
            setSVGDocument(null);
        pcs.firePropertyChange("URI", s1, uri);
    }

    protected UserAgent createUserAgent()
    {
        return new CanvasUserAgent();
    }

    protected org.apache.batik.swing.gvt.JGVTComponent.Listener createListener()
    {
        return new CanvasSVGListener();
    }

    protected void installSVGDocument(SVGDocument svgdocument)
    {
        if(svgDocument != null)
        {
            org.w3c.dom.svg.SVGSVGElement svgsvgelement = svgDocument.getRootElement();
            svgsvgelement.removeEventListener("mouseover", toolTipListener, false);
            svgsvgelement.removeEventListener("mouseout", toolTipListener, false);
            lastTarget = null;
        }
        if(toolTipMap != null)
            toolTipMap.clear();
        if(svgdocument != null)
        {
            org.w3c.dom.svg.SVGSVGElement svgsvgelement1 = svgdocument.getRootElement();
            svgsvgelement1.addEventListener("mouseover", toolTipListener, false);
            svgsvgelement1.addEventListener("mouseout", toolTipListener, false);
        }
        installSVGDocument(svgdocument);
    }

    public void setLastToolTipEvent(long l, EventTarget eventtarget)
    {
        lastToolTipEventTimeStamp = l;
        lastToolTipEventTarget = eventtarget;
    }

    public boolean matchLastToolTipEvent(long l, EventTarget eventtarget)
    {
        return lastToolTipEventTimeStamp == l && lastToolTipEventTarget == eventtarget;
    }

    public static final String SCROLL_RIGHT_ACTION = "ScrollRight";
    public static final String SCROLL_LEFT_ACTION = "ScrollLeft";
    public static final String SCROLL_UP_ACTION = "ScrollUp";
    public static final String SCROLL_DOWN_ACTION = "ScrollDown";
    public static final String FAST_SCROLL_RIGHT_ACTION = "FastScrollRight";
    public static final String FAST_SCROLL_LEFT_ACTION = "FastScrollLeft";
    public static final String FAST_SCROLL_UP_ACTION = "FastScrollUp";
    public static final String FAST_SCROLL_DOWN_ACTION = "FastScrollDown";
    public static final String ZOOM_IN_ACTION = "ZoomIn";
    public static final String ZOOM_OUT_ACTION = "ZoomOut";
    public static final String RESET_TRANSFORM_ACTION = "ResetTransform";
    private boolean isZoomInteractorEnabled;
    private boolean isImageZoomInteractorEnabled;
    private boolean isPanInteractorEnabled;
    private boolean isRotateInteractorEnabled;
    private boolean isResetTransformInteractorEnabled;
    protected PropertyChangeSupport pcs;
    protected String uri;
    protected LocationListener locationListener;
    protected Map toolTipMap;
    protected EventListener toolTipListener;
    protected EventTarget lastTarget;
    protected long lastToolTipEventTimeStamp;
    protected EventTarget lastToolTipEventTarget;
    protected Interactor zoomInteractor = new AbstractZoomInteractor() {

        public boolean startInteraction(InputEvent inputevent)
        {
            int i = inputevent.getModifiers();
            return inputevent.getID() == 501 && (i & 0x10) != 0 && (i & 2) != 0;
        }

    };
    protected Interactor imageZoomInteractor = new AbstractImageZoomInteractor() {

        public boolean startInteraction(InputEvent inputevent)
        {
            int i = inputevent.getModifiers();
            return inputevent.getID() == 501 && (i & 4) != 0 && (i & 1) != 0;
        }

    };
    protected Interactor panInteractor = new AbstractPanInteractor() {

        public boolean startInteraction(InputEvent inputevent)
        {
            int i = inputevent.getModifiers();
            return inputevent.getID() == 501 && (i & 0x10) != 0 && (i & 1) != 0;
        }

    };
    protected Interactor rotateInteractor = new AbstractRotateInteractor() {

        public boolean startInteraction(InputEvent inputevent)
        {
            int i = inputevent.getModifiers();
            return inputevent.getID() == 501 && (i & 4) != 0 && (i & 2) != 0;
        }

    };
    protected Interactor resetTransformInteractor = new AbstractResetTransformInteractor() {

        public boolean startInteraction(InputEvent inputevent)
        {
            int i = inputevent.getModifiers();
            return inputevent.getID() == 500 && (i & 4) != 0 && (i & 1) != 0 && (i & 2) != 0;
        }

    };




}
