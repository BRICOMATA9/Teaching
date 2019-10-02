// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package ydoc.B;

import com.sun.javadoc.Doc;
import com.sun.javadoc.Tag;
import com.sun.tools.doclets.internal.toolkit.taglets.*;

// Referenced classes of package ydoc.B:
//            B

class F
    implements Taglet
{

    public F(String s, B b, boolean flag, boolean flag1, boolean flag2, boolean flag3, boolean flag4, 
            boolean flag5, boolean flag6, boolean flag7, String s1, String s2)
    {
        A = s;
        G = b;
        E = flag;
        D = flag1;
        I = flag2;
        L = flag3;
        H = flag4;
        F = flag5;
        K = flag6;
        J = flag7;
        B = s1;
        C = s2;
    }

    public String getName()
    {
        return A;
    }

    public boolean inField()
    {
        return D;
    }

    public boolean inConstructor()
    {
        return I;
    }

    public boolean inMethod()
    {
        return L;
    }

    public boolean inOverview()
    {
        return H;
    }

    public boolean inPackage()
    {
        return F;
    }

    public boolean inType()
    {
        return K;
    }

    public boolean isInlineTag()
    {
        return J;
    }

    public TagletOutput getTagletOutput(Tag tag, TagletWriter tagletwriter)
        throws IllegalArgumentException
    {
        TagletOutput tagletoutput = tagletwriter.getOutputInstance();
        tagletoutput.setOutput(G.A(new Tag[] {
            tag
        }, B, tagletwriter));
        return tagletoutput;
    }

    public TagletOutput getTagletOutput(Doc doc, TagletWriter tagletwriter)
        throws IllegalArgumentException
    {
        Tag atag[] = doc.tags(getName());
        if(atag.length > 0)
        {
            Tag atag1[] = {
                atag[0]
            };
            if(E)
                atag1 = atag;
            String s = atag1.length <= 1 ? B : C;
            TagletOutput tagletoutput = tagletwriter.getOutputInstance();
            tagletoutput.setOutput(G.A(atag1, s, tagletwriter));
            return tagletoutput;
        } else
        {
            return null;
        }
    }

    private final String A;
    private final B G;
    private final boolean E;
    private final boolean D;
    private final boolean I;
    private final boolean L;
    private final boolean H;
    private final boolean F;
    private final boolean K;
    private final boolean J;
    private final String B;
    private final String C;
}
