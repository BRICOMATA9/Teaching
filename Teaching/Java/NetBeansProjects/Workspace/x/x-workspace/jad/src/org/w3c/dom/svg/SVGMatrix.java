// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.w3c.dom.svg;

import org.w3c.dom.DOMException;

// Referenced classes of package org.w3c.dom.svg:
//            SVGException

public interface SVGMatrix
{

    public abstract float getA();

    public abstract void setA(float f)
        throws DOMException;

    public abstract float getB();

    public abstract void setB(float f)
        throws DOMException;

    public abstract float getC();

    public abstract void setC(float f)
        throws DOMException;

    public abstract float getD();

    public abstract void setD(float f)
        throws DOMException;

    public abstract float getE();

    public abstract void setE(float f)
        throws DOMException;

    public abstract float getF();

    public abstract void setF(float f)
        throws DOMException;

    public abstract SVGMatrix multiply(SVGMatrix svgmatrix);

    public abstract SVGMatrix inverse()
        throws SVGException;

    public abstract SVGMatrix translate(float f, float f1);

    public abstract SVGMatrix scale(float f);

    public abstract SVGMatrix scaleNonUniform(float f, float f1);

    public abstract SVGMatrix rotate(float f);

    public abstract SVGMatrix rotateFromVector(float f, float f1)
        throws SVGException;

    public abstract SVGMatrix flipX();

    public abstract SVGMatrix flipY();

    public abstract SVGMatrix skewX(float f);

    public abstract SVGMatrix skewY(float f);
}
