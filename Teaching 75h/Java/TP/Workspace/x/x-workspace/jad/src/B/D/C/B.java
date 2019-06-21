// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package B.D.C;

import C.A.*;
import C.E.T;
import java.util.Iterator;
import org.graphdrawing.graphml.writer.GraphElementProvider;

public class B
    implements GraphElementProvider
{

    public B(D d)
    {
        B = true;
        A(d);
        C = new T() {

            public boolean B(Object obj)
            {
                return true;
            }

        };
    }

    private void A(D d)
    {
        D = d;
    }

    public boolean isDefaultDirected()
    {
        return B;
    }

    public Object getGraphObject()
    {
        return D;
    }

    public Iterator getNodeObjects()
    {
        return D.B();
    }

    public Iterator getEdgeObjects()
    {
        return D.C();
    }

    public int getNodeCount()
    {
        return D.I();
    }

    public int getEdgeCount()
    {
        return D.S();
    }

    public Object getSourceNode(Object obj)
    {
        return ((J)obj).G();
    }

    public Object getTargetNode(Object obj)
    {
        return ((J)obj).E();
    }

    public Object getSourcePort(Object obj)
    {
        return null;
    }

    public Object getTargetPort(Object obj)
    {
        return null;
    }

    public boolean isDirected(Object obj)
    {
        return C.B(obj);
    }

    public Iterator getEndpointObjects(Object obj)
    {
        return A;
    }

    public Iterator getHyperEdgeObjects()
    {
        return A;
    }

    public Iterator getPortObjects(Object obj)
    {
        return A;
    }

    public GraphElementProvider getNodeSubgraph(Object obj)
    {
        return null;
    }

    public int getHyperEdgeCount()
    {
        return 0;
    }

    protected D D;
    protected M C;
    protected boolean B;
    protected static final Iterator A = new Iterator() {

        public void remove()
        {
        }

        public boolean hasNext()
        {
            return false;
        }

        public Object next()
        {
            return null;
        }

    };

}
