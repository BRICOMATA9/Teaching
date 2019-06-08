// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package A.D;

import B.D.C.A;
import C.A.D;
import C.A.J;
import C.A.M;
import C.A.T;
import org.graphdrawing.graphml.writer.GraphMLWriteContext;
import org.graphdrawing.graphml.writer.XmlWriter;

final class C extends A
{

    C()
    {
    }

    public void A(GraphMLWriteContext graphmlwritecontext, D d, Object obj, XmlWriter xmlwriter)
    {
        if(obj instanceof J)
            A(d, (J)obj, xmlwriter);
        else
        if(obj instanceof T)
            A(d, (T)obj, xmlwriter);
    }

    public void printKeyAttributes(GraphMLWriteContext graphmlwritecontext, XmlWriter xmlwriter)
    {
        xmlwriter.writeAttribute("yfiles.type", "umlentityinformation");
    }

    public void printKeyOutput(GraphMLWriteContext graphmlwritecontext, XmlWriter xmlwriter)
    {
    }

    private void A(D d, T t, XmlWriter xmlwriter)
    {
        M m = d.B(A.C.A.L);
        if(m != null)
        {
            A.C.A._D _ld = (A.C.A._D)m.D(t);
            if(_ld == null)
                return;
            xmlwriter.writeStartElement("NodeInfo", C());
            xmlwriter.writeAttribute("name", _ld.E());
            if(_ld.B() != null)
                xmlwriter.writeAttribute("namespace", _ld.B());
            xmlwriter.writeAttribute("type", _ld.A().toString());
            xmlwriter.writeAttribute("detailed", _ld.F() ? "true" : "false");
            xmlwriter.writeAttribute("foreign", _ld.G() ? "true" : "false");
            xmlwriter.writeAttribute("relationcount", _ld.C());
            xmlwriter.writeEndElement();
        }
    }

    private void A(D d, J j, XmlWriter xmlwriter)
    {
        M m = d.B(A.C.A.D);
        if(m != null)
        {
            A.C.A._F _lf = (A.C.A._F)m.D(j);
            if(_lf == null)
                return;
            xmlwriter.writeStartElement("EdgeInfo", C());
            xmlwriter.writeAttribute("type", _lf.B().toString());
            xmlwriter.writeAttribute("foreign", _lf.C() ? "true" : "false");
            xmlwriter.writeAttribute("multiplicity", _lf.A());
            xmlwriter.writeEndElement();
        }
    }

    private String C()
    {
        return "http://www.yworks.com/xml/graphml";
    }
}
