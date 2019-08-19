// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.svggen;

import java.awt.Rectangle;
import java.awt.image.BufferedImageOp;

// Referenced classes of package org.apache.batik.svggen:
//            SVGSyntax, SVGFilterDescriptor

public interface SVGFilterConverter
    extends SVGSyntax
{

    public abstract SVGFilterDescriptor toSVG(BufferedImageOp bufferedimageop, Rectangle rectangle);

    public abstract java.util.List getDefinitionSet();
}
