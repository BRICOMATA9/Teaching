// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.svggen;

import java.awt.Rectangle;
import java.awt.image.BufferedImageOp;
import java.awt.image.ByteLookupTable;
import java.awt.image.LookupOp;
import java.awt.image.LookupTable;
import java.util.Map;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

// Referenced classes of package org.apache.batik.svggen:
//            AbstractSVGFilterConverter, SVGFilterDescriptor, SVGGeneratorContext, SVGIDGenerator, 
//            SVGGraphics2DRuntimeException

public class SVGLookupOp extends AbstractSVGFilterConverter
{

    public SVGLookupOp(SVGGeneratorContext svggeneratorcontext)
    {
        super(svggeneratorcontext);
    }

    public SVGFilterDescriptor toSVG(BufferedImageOp bufferedimageop, Rectangle rectangle)
    {
        if(bufferedimageop instanceof LookupOp)
            return toSVG((LookupOp)bufferedimageop);
        else
            return null;
    }

    public SVGFilterDescriptor toSVG(LookupOp lookupop)
    {
        SVGFilterDescriptor svgfilterdescriptor = (SVGFilterDescriptor)descMap.get(lookupop);
        Document document = generatorContext.domFactory;
        if(svgfilterdescriptor == null)
        {
            Element element = document.createElementNS("http://www.w3.org/2000/svg", "filter");
            Element element1 = document.createElementNS("http://www.w3.org/2000/svg", "feComponentTransfer");
            String as[] = convertLookupTables(lookupop);
            Element element2 = document.createElementNS("http://www.w3.org/2000/svg", "feFuncR");
            Element element3 = document.createElementNS("http://www.w3.org/2000/svg", "feFuncG");
            Element element4 = document.createElementNS("http://www.w3.org/2000/svg", "feFuncB");
            Element element5 = null;
            String s = "table";
            if(as.length == 1)
            {
                element2.setAttributeNS(null, "type", s);
                element3.setAttributeNS(null, "type", s);
                element4.setAttributeNS(null, "type", s);
                element2.setAttributeNS(null, "tableValues", as[0]);
                element3.setAttributeNS(null, "tableValues", as[0]);
                element4.setAttributeNS(null, "tableValues", as[0]);
            } else
            if(as.length >= 3)
            {
                element2.setAttributeNS(null, "type", s);
                element3.setAttributeNS(null, "type", s);
                element4.setAttributeNS(null, "type", s);
                element2.setAttributeNS(null, "tableValues", as[0]);
                element3.setAttributeNS(null, "tableValues", as[1]);
                element4.setAttributeNS(null, "tableValues", as[2]);
                if(as.length == 4)
                {
                    element5 = document.createElementNS("http://www.w3.org/2000/svg", "feFuncA");
                    element5.setAttributeNS(null, "type", s);
                    element5.setAttributeNS(null, "tableValues", as[3]);
                }
            }
            element1.appendChild(element2);
            element1.appendChild(element3);
            element1.appendChild(element4);
            if(element5 != null)
                element1.appendChild(element5);
            element.appendChild(element1);
            element.setAttributeNS(null, "id", generatorContext.idGenerator.generateID("componentTransfer"));
            StringBuffer stringbuffer = new StringBuffer("url(");
            stringbuffer.append("#");
            stringbuffer.append(element.getAttributeNS(null, "id"));
            stringbuffer.append(")");
            svgfilterdescriptor = new SVGFilterDescriptor(stringbuffer.toString(), element);
            defSet.add(element);
            descMap.put(lookupop, svgfilterdescriptor);
        }
        return svgfilterdescriptor;
    }

    private String[] convertLookupTables(LookupOp lookupop)
    {
        LookupTable lookuptable = lookupop.getTable();
        int i = lookuptable.getNumComponents();
        if(i != 1 && i != 3 && i != 4)
            throw new SVGGraphics2DRuntimeException("BufferedImage LookupOp should have 1, 3 or 4 lookup arrays");
        StringBuffer astringbuffer[] = new StringBuffer[i];
        for(int j = 0; j < i; j++)
            astringbuffer[j] = new StringBuffer();

        if(!(lookuptable instanceof ByteLookupTable))
        {
            int ai[] = new int[i];
            int ai1[] = new int[i];
            int l = lookuptable.getOffset();
            for(int j1 = 0; j1 < l; j1++)
            {
                for(int j2 = 0; j2 < i; j2++)
                {
                    astringbuffer[j2].append(doubleString((double)j1 / 255D));
                    astringbuffer[j2].append(" ");
                }

            }

            for(int k1 = l; k1 <= 255; k1++)
            {
                for(int k2 = 0; k2 < i; k2++)
                    ai[k2] = k1;

                lookuptable.lookupPixel(ai, ai1);
                for(int l2 = 0; l2 < i; l2++)
                {
                    astringbuffer[l2].append(doubleString((double)ai1[l2] / 255D));
                    astringbuffer[l2].append(" ");
                }

            }

        } else
        {
            byte abyte0[] = new byte[i];
            byte abyte1[] = new byte[i];
            int i1 = lookuptable.getOffset();
            for(int l1 = 0; l1 < i1; l1++)
            {
                for(int i3 = 0; i3 < i; i3++)
                {
                    astringbuffer[i3].append(doubleString((double)l1 / 255D));
                    astringbuffer[i3].append(" ");
                }

            }

            for(int i2 = 0; i2 <= 255; i2++)
            {
                for(int j3 = 0; j3 < i; j3++)
                    abyte0[j3] = (byte)(0xff & i2);

                ((ByteLookupTable)lookuptable).lookupPixel(abyte0, abyte1);
                for(int k3 = 0; k3 < i; k3++)
                {
                    astringbuffer[k3].append(doubleString((double)(0xff & abyte1[k3]) / 255D));
                    astringbuffer[k3].append(" ");
                }

            }

        }
        String as[] = new String[i];
        for(int k = 0; k < i; k++)
            as[k] = astringbuffer[k].toString().trim();

        return as;
    }

    private static final double GAMMA = 0.41666666666666669D;
    private static final int linearToSRGBLut[];
    private static final int sRGBToLinear[];

    static 
    {
        linearToSRGBLut = new int[256];
        sRGBToLinear = new int[256];
        for(int i = 0; i < 256; i++)
        {
            float f = (float)i / 255F;
            if((double)f <= 0.0031308D)
                f *= 12.92F;
            else
                f = 1.055F * (float)Math.pow(f, 0.41666666666666669D) - 0.055F;
            linearToSRGBLut[i] = Math.round(f * 255F);
            f = (float)i / 255F;
            if((double)f <= 0.04045D)
                f /= 12.92F;
            else
                f = (float)Math.pow((f + 0.055F) / 1.055F, 2.3999999999999999D);
            sRGBToLinear[i] = Math.round(f * 255F);
        }

    }
}
