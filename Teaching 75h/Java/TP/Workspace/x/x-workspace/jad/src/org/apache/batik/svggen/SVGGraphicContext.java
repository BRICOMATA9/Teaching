// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.svggen;

import java.util.HashMap;
import java.util.Map;
import org.apache.batik.ext.awt.g2d.TransformStackElement;
import org.apache.batik.util.SVGConstants;

// Referenced classes of package org.apache.batik.svggen:
//            ErrorConstants, SVGGraphics2DRuntimeException

public class SVGGraphicContext
    implements SVGConstants, ErrorConstants
{

    public SVGGraphicContext(Map map, TransformStackElement atransformstackelement[])
    {
        if(map == null)
            throw new SVGGraphics2DRuntimeException("context map(s) should not be null");
        if(atransformstackelement == null)
        {
            throw new SVGGraphics2DRuntimeException("transformer stack should not be null");
        } else
        {
            context = map;
            transformStack = atransformstackelement;
            computeGroupAndGraphicElementContext();
            return;
        }
    }

    public SVGGraphicContext(Map map, Map map1, TransformStackElement atransformstackelement[])
    {
        if(map == null || map1 == null)
            throw new SVGGraphics2DRuntimeException("context map(s) should not be null");
        if(atransformstackelement == null)
        {
            throw new SVGGraphics2DRuntimeException("transformer stack should not be null");
        } else
        {
            groupContext = map;
            graphicElementContext = map1;
            transformStack = atransformstackelement;
            computeContext();
            return;
        }
    }

    public Map getContext()
    {
        return context;
    }

    public Map getGroupContext()
    {
        return groupContext;
    }

    public Map getGraphicElementContext()
    {
        return graphicElementContext;
    }

    public TransformStackElement[] getTransformStack()
    {
        return transformStack;
    }

    private void computeContext()
    {
        if(context != null)
        {
            return;
        } else
        {
            context = new HashMap(groupContext);
            context.putAll(graphicElementContext);
            return;
        }
    }

    private void computeGroupAndGraphicElementContext()
    {
        if(groupContext != null)
            return;
        groupContext = new HashMap(context);
        graphicElementContext = new HashMap();
        for(int i = 0; i < leafOnlyAttributes.length; i++)
        {
            Object obj = groupContext.get(leafOnlyAttributes[i]);
            if(obj == null)
                continue;
            if(!obj.equals(defaultValues[i]))
                graphicElementContext.put(leafOnlyAttributes[i], obj);
            groupContext.remove(leafOnlyAttributes[i]);
        }

    }

    private static final String leafOnlyAttributes[] = {
        "opacity", "filter", "clip-path"
    };
    private static final String defaultValues[] = {
        "1", "none", "none"
    };
    private Map context;
    private Map groupContext;
    private Map graphicElementContext;
    private TransformStackElement transformStack[];

}
