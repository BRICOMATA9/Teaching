// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.svggen;

import java.util.*;
import org.apache.batik.util.SVGConstants;
import org.w3c.dom.Element;

// Referenced classes of package org.apache.batik.svggen:
//            StyleHandler, SVGGeneratorContext

public class DefaultStyleHandler
    implements StyleHandler, SVGConstants
{

    public DefaultStyleHandler()
    {
    }

    public void setStyle(Element element, Map map, SVGGeneratorContext svggeneratorcontext)
    {
        String s = element.getTagName();
        Iterator iterator = map.keySet().iterator();
        Object obj = null;
        do
        {
            if(!iterator.hasNext())
                break;
            String s1 = (String)iterator.next();
            if(element.getAttributeNS(null, s1).length() == 0 && appliesTo(s1, s))
                element.setAttributeNS(null, s1, (String)map.get(s1));
        } while(true);
    }

    protected boolean appliesTo(String s, String s1)
    {
        Vector vector = (Vector)ignoreAttributes.get(s1);
        if(vector == null)
            return true;
        else
            return !vector.contains(s);
    }

    static HashMap ignoreAttributes;

    static 
    {
        ignoreAttributes = new HashMap();
        Vector vector = new Vector();
        vector.addElement("font-size");
        vector.addElement("font-family");
        vector.addElement("font-style");
        vector.addElement("font-weight");
        ignoreAttributes.put("rect", vector);
        ignoreAttributes.put("circle", vector);
        ignoreAttributes.put("ellipse", vector);
        ignoreAttributes.put("polygon", vector);
        ignoreAttributes.put("polygon", vector);
        ignoreAttributes.put("line", vector);
        ignoreAttributes.put("path", vector);
    }
}
