// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package B.D.D;

import B.D.C.A;
import C.A.*;
import C.G.E;
import C.G.X;
import org.graphdrawing.graphml.writer.GraphMLWriteContext;
import org.graphdrawing.graphml.writer.XmlWriter;

public class V extends A
{

    public V()
    {
    }

    public void printKeyAttributes(GraphMLWriteContext graphmlwritecontext, XmlWriter xmlwriter)
    {
        xmlwriter.writeAttribute("yfiles.type", "portconstraints");
    }

    public void A(GraphMLWriteContext graphmlwritecontext, D d, Object obj, XmlWriter xmlwriter)
    {
        if(obj instanceof J)
        {
            J j = (J)obj;
            M m = d.B(E.C);
            M m1 = d.B(E.A);
            X x = m == null ? null : (X)m.D(j);
            Object obj1 = m1 == null ? null : m1.D(j);
            if(x != null || obj1 != null)
            {
                xmlwriter.writeStartElement("PortConstraint", "http://www.yworks.com/xml/graphml");
                xmlwriter.writeAttribute("endpoint", "source");
                if(x != null && (x.E() || !x.G()))
                {
                    xmlwriter.writeAttribute("side", A(x));
                    xmlwriter.writeAttribute("strong", String.valueOf(x.E()));
                }
                if(obj1 != null)
                    xmlwriter.writeAttribute("groupid", obj1.toString());
                xmlwriter.writeEndElement();
            }
            m = d.B(E.D);
            m1 = d.B(E.B);
            x = m == null ? null : (X)m.D(j);
            obj1 = m1 == null ? null : m1.D(j);
            if(x != null || obj1 != null)
            {
                xmlwriter.writeStartElement("PortConstraint", "http://www.yworks.com/xml/graphml");
                xmlwriter.writeAttribute("endpoint", "target");
                if(x != null && (x.E() || !x.G()))
                {
                    xmlwriter.writeAttribute("side", A(x));
                    xmlwriter.writeAttribute("strong", String.valueOf(x.E()));
                }
                if(obj1 != null)
                    xmlwriter.writeAttribute("groupid", obj1.toString());
                xmlwriter.writeEndElement();
            }
        }
    }

    String A(X x)
    {
        switch(x.F())
        {
        case 1: // '\001'
            return "north";

        case 2: // '\002'
            return "south";

        case 4: // '\004'
            return "east";

        case 8: // '\b'
            return "west";

        case 3: // '\003'
        case 5: // '\005'
        case 6: // '\006'
        case 7: // '\007'
        default:
            return "any_side";
        }
    }

    public void printKeyOutput(GraphMLWriteContext graphmlwritecontext, XmlWriter xmlwriter)
    {
    }
}
