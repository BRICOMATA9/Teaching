// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package B.D.A;

import C.A.*;
import java.util.List;
import org.graphdrawing.graphml.reader.dom.DOMGraphMLParseContext;
import org.graphdrawing.graphml.reader.dom.DOMInputHandler;
import org.w3c.dom.Node;

public abstract class C
    implements DOMInputHandler
{

    public C()
    {
    }

    public void parseData(DOMGraphMLParseContext domgraphmlparsecontext, boolean flag, Node node)
    {
        int i = domgraphmlparsecontext.getContainers().size();
        Object obj = null;
        Object obj2 = null;
        D d = null;
        if(i > 0)
            obj = domgraphmlparsecontext.getCurrentContainer();
        if(obj instanceof D)
            d = (D)obj;
        else
        if((obj instanceof T) || (obj instanceof J))
        {
            obj2 = obj;
            if(i > 1)
            {
                Object obj1 = domgraphmlparsecontext.getSecondToCurrentContainer();
                if(obj1 instanceof D)
                    d = (D)obj1;
            }
        }
        A(domgraphmlparsecontext, d, obj2, flag, node);
    }

    public void applyDefault(DOMGraphMLParseContext domgraphmlparsecontext)
    {
        int i = domgraphmlparsecontext.getContainers().size();
        Object obj = null;
        Object obj2 = null;
        D d = null;
        if(i > 0)
            obj = domgraphmlparsecontext.getCurrentContainer();
        if(obj instanceof D)
            d = (D)obj;
        else
        if((obj instanceof T) || (obj instanceof J))
        {
            obj2 = obj;
            if(i > 1)
            {
                Object obj1 = domgraphmlparsecontext.getSecondToCurrentContainer();
                if(obj1 instanceof D)
                    d = (D)obj1;
            }
        }
        A(domgraphmlparsecontext, d, obj2);
    }

    protected abstract void A(DOMGraphMLParseContext domgraphmlparsecontext, D d, Object obj, boolean flag, Node node);

    protected abstract void A(DOMGraphMLParseContext domgraphmlparsecontext, D d, Object obj);
}
