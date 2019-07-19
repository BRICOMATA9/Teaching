// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.svggen;

import java.util.List;
import org.apache.batik.ext.awt.g2d.GraphicContext;

// Referenced classes of package org.apache.batik.svggen:
//            SVGSyntax, SVGDescriptor

public interface SVGConverter
    extends SVGSyntax
{

    public abstract SVGDescriptor toSVG(GraphicContext graphiccontext);

    public abstract List getDefinitionSet();
}
