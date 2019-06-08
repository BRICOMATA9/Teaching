// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.w3c.dom.svg;

import org.w3c.dom.DOMException;

// Referenced classes of package org.w3c.dom.svg:
//            SVGException, SVGTransform, SVGMatrix

public interface SVGTransformList
{

    public abstract int getNumberOfItems();

    public abstract void clear()
        throws DOMException;

    public abstract SVGTransform initialize(SVGTransform svgtransform)
        throws DOMException, SVGException;

    public abstract SVGTransform getItem(int i)
        throws DOMException;

    public abstract SVGTransform insertItemBefore(SVGTransform svgtransform, int i)
        throws DOMException, SVGException;

    public abstract SVGTransform replaceItem(SVGTransform svgtransform, int i)
        throws DOMException, SVGException;

    public abstract SVGTransform removeItem(int i)
        throws DOMException;

    public abstract SVGTransform appendItem(SVGTransform svgtransform)
        throws DOMException, SVGException;

    public abstract SVGTransform createSVGTransformFromMatrix(SVGMatrix svgmatrix);

    public abstract SVGTransform consolidate();
}
