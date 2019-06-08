// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package ydoc.doclets;

import com.sun.javadoc.*;
import java.util.*;

// Referenced classes of package ydoc.doclets:
//            A, J

class V
{
    private static final class _A
        implements Tag
    {

        public String name()
        {
            return A;
        }

        public Doc holder()
        {
            return B;
        }

        public String kind()
        {
            return A;
        }

        public String text()
        {
            return C;
        }

        public Tag[] inlineTags()
        {
            return new Tag[0];
        }

        public Tag[] firstSentenceTags()
        {
            return new Tag[0];
        }

        public SourcePosition position()
        {
            return null;
        }

        public String toString()
        {
            return (new StringBuilder()).append(A).append(" ").append(C).toString();
        }

        final Doc B;
        final String A;
        final String C;

        public _A(Doc doc, String s, String s1)
        {
            B = doc;
            A = s.charAt(0) != '@' ? (new StringBuilder()).append('@').append(s).toString() : s;
            C = s1;
        }
    }

    private static final class _B
    {

        public void A(Tag tag)
        {
            String s = tag.name();
            if(A(s))
            {
                ((List)A.get(s)).add(ydoc.doclets.A.A(tag));
            } else
            {
                ArrayList arraylist = new ArrayList(1);
                arraylist.add(ydoc.doclets.A.A(tag));
                A.put(s, arraylist);
            }
        }

        public Tag[] B(String s)
        {
            String s1 = s;
            if(s1.charAt(0) != '@')
                s1 = (new StringBuilder()).append('@').append(s1).toString();
            List list = (List)A.get(s1);
            if(list == null)
                return B;
            else
                return (Tag[])(Tag[])list.toArray(new Tag[list.size()]);
        }

        public Tag[] A()
        {
            ArrayList arraylist = new ArrayList(A.size());
            for(Iterator iterator = A.entrySet().iterator(); iterator.hasNext(); arraylist.addAll((List)((java.util.Map.Entry)iterator.next()).getValue()));
            return (Tag[])(Tag[])arraylist.toArray(new Tag[arraylist.size()]);
        }

        public boolean A(String s)
        {
            return A.containsKey(s);
        }

        void A(Tag atag[])
        {
            for(int i = 0; i < atag.length; i++)
            {
                String s = atag[i].name();
                if(s != null)
                {
                    s = s.trim();
                    if(s.charAt(0) == '@')
                        s = s.substring(1);
                }
                if(!"y.uml".equals(s))
                    A(atag[i]);
            }

        }

        private static final Tag B[] = new Tag[0];
        private final Map A = new HashMap();


        public _B()
        {
        }
    }


    static V B(Doc doc)
    {
        if(doc instanceof MemberDoc)
            return new V(doc);
        if(doc instanceof ClassDoc)
            return A((ClassDoc)doc);
        if(doc instanceof PackageDoc)
            return B((PackageDoc)doc);
        if(doc instanceof RootDoc)
            return B((RootDoc)doc);
        else
            return new V(doc);
    }

    static V A(ClassDoc classdoc)
    {
        V v = new V(classdoc);
        v.B(classdoc);
        return v;
    }

    static V B(PackageDoc packagedoc)
    {
        V v = new V(packagedoc);
        v.A(packagedoc);
        return v;
    }

    static V B(RootDoc rootdoc)
    {
        V v = new V(rootdoc);
        v.A(rootdoc);
        return v;
    }

    private V(Doc doc)
    {
        B.A(doc.tags());
        Tag atag[] = doc.inlineTags();
        C = new Tag[atag.length];
        for(int i = 0; i < atag.length; i++)
            C[i] = ydoc.doclets.A.A(atag[i]);

        atag = doc.firstSentenceTags();
        A = new Tag[atag.length];
        for(int j = 0; j < atag.length; j++)
            A[j] = ydoc.doclets.A.A(atag[j]);

    }

    Tag[] C()
    {
        return B.A();
    }

    Tag[] A(String s)
    {
        return B.B(s);
    }

    SeeTag[] D()
    {
        Tag atag[] = B.B("see");
        SeeTag aseetag[] = new SeeTag[atag.length];
        for(int i = 0; i < aseetag.length; i++)
            aseetag[i] = (SeeTag)atag[i];

        return aseetag;
    }

    public Tag[] B()
    {
        return C;
    }

    public Tag[] A()
    {
        return A;
    }

    private void B(ClassDoc classdoc)
    {
        if(A(classdoc, D.F))
        {
            String s = classdoc.name();
            String s1 = classdoc.containingPackage().name();
            String s2 = "".equals(s1) ? "_unnamed_package" : s1;
            A(classdoc, "y.uml", (new StringBuilder()).append(s2).append(" ").append(s).toString());
        }
        A(classdoc);
    }

    private void A(PackageDoc packagedoc)
    {
        if(A(((Doc) (packagedoc)), D.G))
            A(((Doc) (packagedoc)), "y.uml", packagedoc.name());
        A(((Doc) (packagedoc)));
    }

    private void A(RootDoc rootdoc)
    {
        if(A(((Doc) (rootdoc)), D.M))
            A(((Doc) (rootdoc)), "y.uml");
        A(((Doc) (rootdoc)));
    }

    private boolean A(Doc doc, boolean flag)
    {
        return !B.A("y.uml") && (flag || doc.tags("y.uml").length > 0);
    }

    private void A(Doc doc)
    {
        if(D.B() && !B.A("y.eval"))
            A(doc, "y.eval");
        if(!B.A("y.promo"))
            A(doc, "y.promo");
    }

    private void A(Doc doc, String s)
    {
        A(doc, s, "");
    }

    private void A(Doc doc, String s, String s1)
    {
        B.A(new _A(doc, s, s1));
    }

    static J D;
    private final _B B = new _B();
    private final Tag C[];
    private final Tag A[];
}
