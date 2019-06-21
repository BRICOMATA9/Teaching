// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.w3c.dom.svg;

import org.w3c.dom.DOMException;

// Referenced classes of package org.w3c.dom.svg:
//            SVGPathSeg

public interface SVGPathSegArcAbs
    extends SVGPathSeg
{

    public abstract float getX();

    public abstract void setX(float f)
        throws DOMException;

    public abstract float getY();

    public abstract void setY(float f)
        throws DOMException;

    public abstract float getR1();

    public abstract void setR1(float f)
        throws DOMException;

    public abstract float getR2();

    public abstract void setR2(float f)
        throws DOMException;

    public abstract float getAngle();

    public abstract void setAngle(float f)
        throws DOMException;

    public abstract boolean getLargeArcFlag();

    public abstract void setLargeArcFlag(boolean flag)
        throws DOMException;

    public abstract boolean getSweepFlag();

    public abstract void setSweepFlag(boolean flag)
        throws DOMException;
}
