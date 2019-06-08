// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.w3c.dom.svg;

import org.w3c.dom.events.EventTarget;

// Referenced classes of package org.w3c.dom.svg:
//            SVGElement, SVGUseElement, SVGElementInstanceList

public interface SVGElementInstance
    extends EventTarget
{

    public abstract SVGElement getCorrespondingElement();

    public abstract SVGUseElement getCorrespondingUseElement();

    public abstract SVGElementInstance getParentNode();

    public abstract SVGElementInstanceList getChildNodes();

    public abstract SVGElementInstance getFirstChild();

    public abstract SVGElementInstance getLastChild();

    public abstract SVGElementInstance getPreviousSibling();

    public abstract SVGElementInstance getNextSibling();
}
