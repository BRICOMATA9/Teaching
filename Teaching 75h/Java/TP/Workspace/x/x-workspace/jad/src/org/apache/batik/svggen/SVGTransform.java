// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.svggen;

import java.util.Stack;
import org.apache.batik.ext.awt.g2d.*;

// Referenced classes of package org.apache.batik.svggen:
//            AbstractSVGConverter, SVGTransformDescriptor, SVGGeneratorContext, SVGDescriptor

public class SVGTransform extends AbstractSVGConverter
{

    public SVGTransform(SVGGeneratorContext svggeneratorcontext)
    {
        super(svggeneratorcontext);
    }

    public SVGDescriptor toSVG(GraphicContext graphiccontext)
    {
        return new SVGTransformDescriptor(toSVGTransform(graphiccontext));
    }

    public final String toSVGTransform(GraphicContext graphiccontext)
    {
        return toSVGTransform(graphiccontext.getTransformStack());
    }

    public final String toSVGTransform(TransformStackElement atransformstackelement[])
    {
        StringBuffer stringbuffer = new StringBuffer();
        int i = atransformstackelement.length;
        Stack stack = new Stack() {

            public Object push(Object obj)
            {
                Object obj1;
                if(((TransformStackElement)obj).isIdentity())
                {
                    obj1 = pop();
                } else
                {
                    super.push(obj);
                    obj1 = null;
                }
                return obj1;
            }

            public Object pop()
            {
                Object obj = null;
                if(!super.empty())
                    obj = super.pop();
                return obj;
            }

        };
        boolean flag = false;
        int j = 0;
        boolean flag3 = false;
        boolean flag4 = false;
        TransformStackElement transformstackelement;
        for(transformstackelement = null; j < i; transformstackelement = (TransformStackElement)stack.push(transformstackelement))
        {
            int i1 = j;
            if(transformstackelement == null)
            {
                transformstackelement = (TransformStackElement)atransformstackelement[j].clone();
                i1++;
            }
            boolean flag1 = true;
            int l = i1;
            do
            {
                if(l >= i)
                    break;
                boolean flag2 = transformstackelement.concatenate(atransformstackelement[l]);
                if(!flag2)
                    break;
                l++;
            } while(true);
            j = l;
        }

        if(transformstackelement != null)
            stack.push(transformstackelement);
        int j1 = stack.size();
        for(int k = 0; k < j1; k++)
        {
            stringbuffer.append(convertTransform((TransformStackElement)stack.elementAt(k)));
            stringbuffer.append(" ");
        }

        String s = stringbuffer.toString().trim();
        return s;
    }

    final String convertTransform(TransformStackElement transformstackelement)
    {
        StringBuffer stringbuffer = new StringBuffer();
        double ad[] = transformstackelement.getTransformParameters();
        switch(transformstackelement.getType().toInt())
        {
        case 0: // '\0'
            if(!transformstackelement.isIdentity())
            {
                stringbuffer.append("translate");
                stringbuffer.append("(");
                stringbuffer.append(doubleString(ad[0]));
                stringbuffer.append(",");
                stringbuffer.append(doubleString(ad[1]));
                stringbuffer.append(")");
            }
            break;

        case 1: // '\001'
            if(!transformstackelement.isIdentity())
            {
                stringbuffer.append("rotate");
                stringbuffer.append("(");
                stringbuffer.append(doubleString(radiansToDegrees * ad[0]));
                stringbuffer.append(")");
            }
            break;

        case 2: // '\002'
            if(!transformstackelement.isIdentity())
            {
                stringbuffer.append("scale");
                stringbuffer.append("(");
                stringbuffer.append(doubleString(ad[0]));
                stringbuffer.append(",");
                stringbuffer.append(doubleString(ad[1]));
                stringbuffer.append(")");
            }
            break;

        case 3: // '\003'
            if(!transformstackelement.isIdentity())
            {
                stringbuffer.append("matrix");
                stringbuffer.append("(");
                stringbuffer.append(1);
                stringbuffer.append(",");
                stringbuffer.append(doubleString(ad[1]));
                stringbuffer.append(",");
                stringbuffer.append(doubleString(ad[0]));
                stringbuffer.append(",");
                stringbuffer.append(1);
                stringbuffer.append(",");
                stringbuffer.append(0);
                stringbuffer.append(",");
                stringbuffer.append(0);
                stringbuffer.append(")");
            }
            break;

        case 4: // '\004'
            if(!transformstackelement.isIdentity())
            {
                stringbuffer.append("matrix");
                stringbuffer.append("(");
                stringbuffer.append(doubleString(ad[0]));
                stringbuffer.append(",");
                stringbuffer.append(doubleString(ad[1]));
                stringbuffer.append(",");
                stringbuffer.append(doubleString(ad[2]));
                stringbuffer.append(",");
                stringbuffer.append(doubleString(ad[3]));
                stringbuffer.append(",");
                stringbuffer.append(doubleString(ad[4]));
                stringbuffer.append(",");
                stringbuffer.append(doubleString(ad[5]));
                stringbuffer.append(")");
            }
            break;

        default:
            throw new Error();
        }
        return stringbuffer.toString();
    }

    private static double radiansToDegrees = 57.295779513082323D;

}
