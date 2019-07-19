// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package A.D;

import B.D.C.A;
import C.A.*;
import C.J.*;
import java.util.Map;
import org.graphdrawing.graphml.writer.GraphMLWriteContext;
import org.graphdrawing.graphml.writer.XmlWriter;

// Referenced classes of package A.D:
//            D

final class E extends A
{

    E()
    {
    }

    public void A(GraphMLWriteContext graphmlwritecontext, D d, Object obj, XmlWriter xmlwriter)
    {
        M m = d.B(D.C4);
        if(m == null)
            return;
        Map map = (Map)m.D(d);
        if(obj instanceof T)
        {
            Y y = ((b)d).U((T)obj);
            int i = y.L();
            if(i > 0)
            {
                xmlwriter.writeStartElement("LabelReferences", A());
                for(int k = 0; k < i; k++)
                {
                    C.J.DA da = y.A(k);
                    Object obj1 = map.get(da);
                    xmlwriter.writeStartElement("Link", A());
                    if(obj1 instanceof String)
                        xmlwriter.writeAttribute("href", (String)obj1);
                    xmlwriter.writeEndElement();
                }

                xmlwriter.writeEndElement();
            }
        } else
        if(obj instanceof J)
        {
            U u = ((b)d).R((J)obj);
            int j = u.w();
            if(j > 0)
            {
                xmlwriter.writeStartElement("LabelReferences", A());
                for(int l = 0; l < j; l++)
                {
                    C.J.N n = u.D(l);
                    Object obj2 = map.get(n);
                    xmlwriter.writeStartElement("Link", A());
                    if(obj2 instanceof String)
                        xmlwriter.writeAttribute("href", (String)obj2);
                    xmlwriter.writeEndElement();
                }

                xmlwriter.writeEndElement();
            }
        }
    }

    public void printKeyAttributes(GraphMLWriteContext graphmlwritecontext, XmlWriter xmlwriter)
    {
        xmlwriter.writeAttribute("yfiles.type", "labelreferences");
    }

    public void printKeyOutput(GraphMLWriteContext graphmlwritecontext, XmlWriter xmlwriter)
    {
    }

    private String A()
    {
        return "http://www.yworks.com/xml/graphml";
    }
}
