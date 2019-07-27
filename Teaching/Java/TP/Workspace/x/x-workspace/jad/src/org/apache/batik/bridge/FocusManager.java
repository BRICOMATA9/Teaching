// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.bridge;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.events.*;

public class FocusManager
{
    protected class MouseOutTacker
        implements EventListener
    {

        public void handleEvent(Event event)
        {
            EventTarget eventtarget = event.getTarget();
            fireDOMFocusOutEvent(eventtarget);
        }

        protected MouseOutTacker()
        {
        }
    }

    protected class MouseOverTacker
        implements EventListener
    {

        public void handleEvent(Event event)
        {
            EventTarget eventtarget = event.getTarget();
            fireDOMFocusInEvent(eventtarget);
        }

        protected MouseOverTacker()
        {
        }
    }

    protected class DOMFocusOutTracker
        implements EventListener
    {

        public void handleEvent(Event event)
        {
            lastFocusEventTarget = null;
        }

        protected DOMFocusOutTracker()
        {
        }
    }

    protected class DOMFocusInTracker
        implements EventListener
    {

        public void handleEvent(Event event)
        {
            if(lastFocusEventTarget != null && lastFocusEventTarget != event.getTarget())
                fireDOMFocusOutEvent(lastFocusEventTarget);
            lastFocusEventTarget = event.getTarget();
        }

        protected DOMFocusInTracker()
        {
        }
    }

    protected class MouseClickTacker
        implements EventListener
    {

        public void handleEvent(Event event)
        {
            MouseEvent mouseevent = (MouseEvent)event;
            fireDOMActivateEvent(event.getTarget(), mouseevent.getDetail());
        }

        protected MouseClickTacker()
        {
        }
    }


    public FocusManager(Document document1)
    {
        document = document1;
        EventTarget eventtarget = (EventTarget)document1;
        mouseclickListener = new MouseClickTacker();
        eventtarget.addEventListener("click", mouseclickListener, true);
        mouseoverListener = new MouseOverTacker();
        eventtarget.addEventListener("mouseover", mouseoverListener, true);
        mouseoutListener = new MouseOutTacker();
        eventtarget.addEventListener("mouseout", mouseoutListener, true);
        domFocusInListener = new DOMFocusInTracker();
        eventtarget.addEventListener("DOMFocusIn", domFocusInListener, true);
        domFocusOutListener = new DOMFocusOutTracker();
        eventtarget.addEventListener("DOMFocusOut", domFocusOutListener, true);
    }

    public EventTarget getCurrentEventTarget()
    {
        return lastFocusEventTarget;
    }

    public void dispose()
    {
        if(document == null)
        {
            return;
        } else
        {
            EventTarget eventtarget = (EventTarget)document;
            eventtarget.removeEventListener("click", mouseclickListener, true);
            eventtarget.removeEventListener("mouseover", mouseoverListener, true);
            eventtarget.removeEventListener("mouseout", mouseoutListener, true);
            eventtarget.removeEventListener("DOMFocusIn", domFocusInListener, true);
            eventtarget.removeEventListener("DOMFocusOut", domFocusOutListener, true);
            lastFocusEventTarget = null;
            document = null;
            return;
        }
    }

    protected void fireDOMFocusInEvent(EventTarget eventtarget)
    {
        DocumentEvent documentevent = (DocumentEvent)((Element)eventtarget).getOwnerDocument();
        UIEvent uievent = (UIEvent)documentevent.createEvent("UIEvents");
        uievent.initUIEvent("DOMFocusIn", true, false, null, 0);
        eventtarget.dispatchEvent(uievent);
    }

    protected void fireDOMFocusOutEvent(EventTarget eventtarget)
    {
        DocumentEvent documentevent = (DocumentEvent)((Element)eventtarget).getOwnerDocument();
        UIEvent uievent = (UIEvent)documentevent.createEvent("UIEvents");
        uievent.initUIEvent("DOMFocusOut", true, false, null, 0);
        eventtarget.dispatchEvent(uievent);
    }

    protected void fireDOMActivateEvent(EventTarget eventtarget, int i)
    {
        DocumentEvent documentevent = (DocumentEvent)((Element)eventtarget).getOwnerDocument();
        UIEvent uievent = (UIEvent)documentevent.createEvent("UIEvents");
        uievent.initUIEvent("DOMActivate", true, true, null, i);
        eventtarget.dispatchEvent(uievent);
    }

    protected EventTarget lastFocusEventTarget;
    protected Document document;
    protected EventListener mouseclickListener;
    protected EventListener domFocusInListener;
    protected EventListener domFocusOutListener;
    protected EventListener mouseoverListener;
    protected EventListener mouseoutListener;
}
