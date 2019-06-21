// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package B.D.D;

import B.D.C.B;
import C.A.*;
import C.J.A.G;
import java.util.Iterator;
import org.graphdrawing.graphml.writer.GraphElementProvider;

public class M extends B
{

    public M(D d)
    {
        super(d);
        F = false;
        G = false;
        H = C.J.A.G.H(d);
        if(H != null)
            E = new S(H.B(null));
        else
            E = new S(d.H());
    }

    private M(D d, T t, G g)
    {
        super(d);
        F = false;
        G = false;
        G = true;
        H = g;
        E = new S(g.B(t));
        if(g.C(t))
            F = true;
    }

    public Iterator getEdgeObjects()
    {
        if(H == null)
            return super.getEdgeObjects();
        if(G && !F)
            return A;
        else
            return super.getEdgeObjects();
    }

    public Iterator getNodeObjects()
    {
        if(H == null)
            return super.getNodeObjects();
        if(E != null)
            return E.iterator();
        else
            return super.getNodeObjects();
    }

    public GraphElementProvider getNodeSubgraph(Object obj)
    {
        if(H == null)
            return super.getNodeSubgraph(obj);
        T t = (T)obj;
        if(!H.M(t))
        {
            if(H.C(t))
                return new M(H.P(t), t, H);
            else
                return new M(D, t, H);
        } else
        {
            return null;
        }
    }

    public Object getSourceNode(Object obj)
    {
        if(H == null)
            return super.getSourceNode(obj);
        J j = (J)obj;
        if(H.C(j))
            return H.D(j);
        else
            return super.getSourceNode(j);
    }

    public Object getTargetNode(Object obj)
    {
        if(H == null)
            return super.getTargetNode(obj);
        J j = (J)obj;
        if(H.C(j))
            return H.B(j);
        else
            return super.getTargetNode(j);
    }

    protected G H;
    private S E;
    private boolean F;
    private boolean G;
}
