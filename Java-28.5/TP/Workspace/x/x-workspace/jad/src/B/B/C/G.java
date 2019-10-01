// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package B.B.C;

import B.B.A.B.C;
import B.B.A.H;
import B.D.C.A;
import C.A.D;
import C.A.M;
import java.io.IOException;
import java.util.List;
import org.graphdrawing.graphml.writer.GraphMLWriteContext;
import org.graphdrawing.graphml.writer.XmlWriter;

// Referenced classes of package B.B.C:
//            B

public class G extends A
{

    public G()
    {
    }

    public void A(GraphMLWriteContext graphmlwritecontext, D d, Object obj, XmlWriter xmlwriter)
    {
        if(graphmlwritecontext.getContainers().size() > 1)
            return;
        M m = d.B(B.C3);
        if(m != null)
            A((C)m.D(d), xmlwriter);
        else
            A(null, xmlwriter);
    }

    public void A(C c, XmlWriter xmlwriter)
    {
        if(c == null)
            c = H.C().A();
        try
        {
            B.B.A.B.H h = new B.B.A.B.H();
            h.A(true);
            h.A(c, xmlwriter);
        }
        catch(IOException ioexception)
        {
            throw new RuntimeException(ioexception.getMessage());
        }
    }

    public void printKeyOutput(GraphMLWriteContext graphmlwritecontext, XmlWriter xmlwriter)
    {
    }

    public void printKeyAttributes(GraphMLWriteContext graphmlwritecontext, XmlWriter xmlwriter)
    {
        xmlwriter.writeAttribute("yfiles.type", "uml-style");
    }
}
