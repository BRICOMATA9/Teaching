// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package B.D.D;

import C.A.T;
import C.J.A.G;
import org.graphdrawing.graphml.writer.*;

public class L extends XMLAttributesProviderAdapter
{

    public L(G g)
    {
        A = g;
    }

    public void printNodeAttributes(GraphMLWriteContext graphmlwritecontext, XmlWriter xmlwriter)
    {
        Object obj = graphmlwritecontext.getCurrentContainer();
        if(A.A((T)obj))
            xmlwriter.writeAttribute("yfiles.foldertype", "group");
        if(A.C((T)obj))
            xmlwriter.writeAttribute("yfiles.foldertype", "folder");
    }

    private G A;
}
