// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.w3c.dom.svg;

import org.w3c.dom.DOMException;
import org.w3c.dom.events.EventTarget;
import org.w3c.dom.smil.ElementTimeControl;

// Referenced classes of package org.w3c.dom.svg:
//            SVGElement, SVGTests, SVGExternalResourcesRequired

public interface SVGAnimationElement
    extends SVGElement, SVGTests, SVGExternalResourcesRequired, ElementTimeControl, EventTarget
{

    public abstract SVGElement getTargetElement();

    public abstract float getStartTime();

    public abstract float getCurrentTime();

    public abstract float getSimpleDuration()
        throws DOMException;
}
