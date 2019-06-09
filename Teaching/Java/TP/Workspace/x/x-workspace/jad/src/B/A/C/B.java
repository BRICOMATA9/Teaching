// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package B.A.C;

import java.util.ArrayList;
import java.util.Set;
import org.apache.batik.svggen.SVGStylingAttributes;
import org.apache.batik.svggen.SVGSyntax;
import org.w3c.dom.*;

final class B
    implements SVGSyntax
{

    public static void A(Node node, boolean flag)
    {
        NamedNodeMap namednodemap = node.getAttributes();
        if(namednodemap != null)
        {
            Element element = (Element)node;
            StringBuffer stringbuffer = new StringBuffer();
            int j = namednodemap.getLength();
            ArrayList arraylist = new ArrayList(j);
            for(int l = 0; l < j; l++)
            {
                Attr attr = (Attr)namednodemap.item(l);
                String s = attr.getName();
                if(!SVGStylingAttributes.set.contains(s))
                    continue;
                stringbuffer.append(s);
                stringbuffer.append(":");
                String s1 = attr.getValue();
                stringbuffer.append(s1);
                if(flag && "font-size".equals(s) && Character.isDigit(s1.charAt(s1.length() - 1)))
                    stringbuffer.append("px");
                stringbuffer.append(";");
                stringbuffer.append(" ");
                arraylist.add(attr.getName());
            }

            if(stringbuffer.length() > 0)
            {
                element.setAttributeNS(null, "style", stringbuffer.toString().trim());
                int i1 = 0;
                for(int j1 = arraylist.size(); i1 < j1; i1++)
                    element.removeAttribute((String)arraylist.get(i1));

            }
        }
        NodeList nodelist = node.getChildNodes();
        int i = nodelist.getLength();
        for(int k = 0; k < i; k++)
        {
            Node node1 = nodelist.item(k);
            A(node1, flag);
        }

    }
}
