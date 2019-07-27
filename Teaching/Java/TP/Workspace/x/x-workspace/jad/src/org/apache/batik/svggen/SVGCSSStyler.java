// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.svggen;

import java.util.Set;
import java.util.Vector;
import org.w3c.dom.*;

// Referenced classes of package org.apache.batik.svggen:
//            SVGSyntax, SVGStylingAttributes

public class SVGCSSStyler
    implements SVGSyntax
{

    public SVGCSSStyler()
    {
    }

    public static void style(Node node)
    {
        NamedNodeMap namednodemap = node.getAttributes();
        if(namednodemap != null)
        {
            Element element = (Element)node;
            StringBuffer stringbuffer = new StringBuffer();
            int j = namednodemap.getLength();
            Vector vector = new Vector();
            for(int l = 0; l < j; l++)
            {
                Attr attr = (Attr)namednodemap.item(l);
                if(SVGStylingAttributes.set.contains(attr.getName()))
                {
                    stringbuffer.append(attr.getName());
                    stringbuffer.append(CSS_PROPERTY_VALUE_SEPARATOR);
                    stringbuffer.append(attr.getValue());
                    stringbuffer.append(CSS_RULE_SEPARATOR);
                    stringbuffer.append(SPACE);
                    vector.addElement(attr.getName());
                }
            }

            if(stringbuffer.length() > 0)
            {
                element.setAttributeNS(null, "style", stringbuffer.toString().trim());
                int i1 = vector.size();
                for(int j1 = 0; j1 < i1; j1++)
                    element.removeAttribute((String)vector.elementAt(j1));

            }
        }
        NodeList nodelist = node.getChildNodes();
        int i = nodelist.getLength();
        for(int k = 0; k < i; k++)
        {
            Node node1 = nodelist.item(k);
            style(node1);
        }

    }

    private static String CSS_PROPERTY_VALUE_SEPARATOR = ":";
    private static String CSS_RULE_SEPARATOR = ";";
    private static String SPACE = " ";

}
