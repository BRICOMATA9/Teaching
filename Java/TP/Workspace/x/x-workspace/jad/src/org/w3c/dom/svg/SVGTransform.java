// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.w3c.dom.svg;


// Referenced classes of package org.w3c.dom.svg:
//            SVGMatrix

public interface SVGTransform
{

    public abstract short getType();

    public abstract SVGMatrix getMatrix();

    public abstract float getAngle();

    public abstract void setMatrix(SVGMatrix svgmatrix);

    public abstract void setTranslate(float f, float f1);

    public abstract void setScale(float f, float f1);

    public abstract void setRotate(float f, float f1, float f2);

    public abstract void setSkewX(float f);

    public abstract void setSkewY(float f);

    public static final short SVG_TRANSFORM_UNKNOWN = 0;
    public static final short SVG_TRANSFORM_MATRIX = 1;
    public static final short SVG_TRANSFORM_TRANSLATE = 2;
    public static final short SVG_TRANSFORM_SCALE = 3;
    public static final short SVG_TRANSFORM_ROTATE = 4;
    public static final short SVG_TRANSFORM_SKEWX = 5;
    public static final short SVG_TRANSFORM_SKEWY = 6;
}
