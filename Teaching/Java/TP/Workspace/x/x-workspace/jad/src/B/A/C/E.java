// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package B.A.C;

import C.J.Z;
import java.io.IOException;
import java.io.Writer;
import org.apache.batik.svggen.DOMTreeManager;
import org.apache.batik.svggen.SVGGraphics2D;
import org.w3c.dom.*;

// Referenced classes of package B.A.C:
//            C

public class E extends Z
{

    public E()
    {
    }

    public void A(C c)
    {
        H = c;
    }

    protected C C()
    {
        return H;
    }

    protected Document E()
    {
        return H.C();
    }

    protected Element D()
    {
        return H.D().getTopLevelGroup(false);
    }

    protected void B(Element element)
    {
        H.D().setTopLevelGroup(element);
    }

    protected Element A(String s)
    {
        return E().createElement(s);
    }

    protected CDATASection B(String s)
    {
        return E().createCDATASection(s);
    }

    protected void A(Element element)
    {
        C().D().getDOMTreeManager().addOtherDef(element);
    }

    protected void A(Node node, Writer writer)
        throws IOException
    {
        C().A(node, writer);
    }

    private C H;
}
