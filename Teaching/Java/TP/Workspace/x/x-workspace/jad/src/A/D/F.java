// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package A.D;

import A.C.A;
import B.B.C.E;
import C.A.*;
import C.J.b;
import org.graphdrawing.graphml.reader.dom.DOMGraphMLParseContext;
import org.w3c.dom.Node;

final class F extends E
{

    public F(int i)
    {
        super(i);
    }

    protected void A(DOMGraphMLParseContext domgraphmlparsecontext, D d, Object obj, boolean flag, Node node)
    {
        if(flag)
            return;
        if(obj instanceof J)
        {
            A a = A.C.A.A((b)d);
            a.B((J)obj);
        } else
        if(obj instanceof T)
        {
            A a1 = A.C.A.A((b)d);
            a1.A((T)obj, false, null, null);
        }
    }
}
