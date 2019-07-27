// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package ydoc.doclets;

import com.sun.javadoc.DocErrorReporter;
import com.sun.tools.doclets.internal.toolkit.Configuration;
import com.sun.tools.doclets.internal.toolkit.taglets.Taglet;
import com.sun.tools.doclets.internal.toolkit.taglets.TagletManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import ydoc.A.A;
import ydoc.A.A.H;
import ydoc.A.D;
import ydoc.A.F;
import ydoc.B.A.E;
import ydoc.B.C;
import ydoc.B.G;

// Referenced classes of package ydoc.doclets:
//            J, P

final class Q extends J
{
    private class _A
        implements Comparator
    {

        public int compare(Object obj, Object obj1)
        {
            if((obj instanceof Taglet) && (obj1 instanceof Taglet))
            {
                Integer integer = (Integer)B.get(((Taglet)obj).getName());
                Integer integer1 = (Integer)B.get(((Taglet)obj1).getName());
                if(integer != null)
                    if(integer1 == null)
                        return 1;
                    else
                        return integer.compareTo(integer1);
                if(integer1 != null)
                    return -1;
            }
            return 0;
        }

        private final Map B;
        final Q A;

        public _A(String as[])
        {
            A = Q.this;
            super();
            B = new HashMap(2 * as.length);
            HashMap hashmap = new HashMap();
            Taglet ataglet[] = G().getConstructorCustomTags();
            for(int i = 0; i < ataglet.length; i++)
                hashmap.put(ataglet[i].getClass().getName(), ataglet[i]);

            ataglet = G().getFieldCustomTags();
            for(int j = 0; j < ataglet.length; j++)
                hashmap.put(ataglet[j].getClass().getName(), ataglet[j]);

            ataglet = G().getInlineCustomTags();
            for(int k = 0; k < ataglet.length; k++)
                hashmap.put(ataglet[k].getClass().getName(), ataglet[k]);

            ataglet = G().getMethodCustomTags();
            for(int l = 0; l < ataglet.length; l++)
                hashmap.put(ataglet[l].getClass().getName(), ataglet[l]);

            ataglet = G().getOverviewCustomTags();
            for(int i1 = 0; i1 < ataglet.length; i1++)
                hashmap.put(ataglet[i1].getClass().getName(), ataglet[i1]);

            ataglet = G().getPackageCustomTags();
            for(int j1 = 0; j1 < ataglet.length; j1++)
                hashmap.put(ataglet[j1].getClass().getName(), ataglet[j1]);

            ataglet = G().getTypeCustomTags();
            for(int k1 = 0; k1 < ataglet.length; k1++)
                hashmap.put(ataglet[k1].getClass().getName(), ataglet[k1]);

            for(int l1 = 0; l1 < as.length; l1++)
            {
                Taglet taglet = (Taglet)hashmap.get(as[l1]);
                if(taglet != null)
                    B.put(taglet.getName(), new Integer(l1));
                else
                    B.put(as[l1], new Integer(l1));
            }

            Iterator iterator = hashmap.values().iterator();
            do
            {
                if(!iterator.hasNext())
                    break;
                String s = ((Taglet)iterator.next()).getName();
                if(!B.containsKey(s))
                    B.put(s, new Integer(-1));
            } while(true);
            B.put("y.eval", new Integer(-10));
            B.put("y.promo", new Integer(0x7fffffff));
        }
    }


    Q(Configuration configuration)
    {
        super(configuration);
        Q = null;
        P = true;
    }

    public int optionLength(String s)
    {
        if(s.equals("-noumltypegen"))
            return 1;
        if(s.equals("-noumlpackagegen"))
            return 1;
        if(s.equals("-noumloverviewgen"))
            return 1;
        if(s.equals("-nohtml"))
            return 1;
        if(s.equals("-resolver"))
            return 2;
        if(s.equals("-resolverpath"))
            return 2;
        if(s.equals("-ytag"))
            return 2;
        if(s.equals("-umlfileformat"))
            return 2;
        else
            return super.optionLength(s);
    }

    boolean A(String as[][], DocErrorReporter docerrorreporter)
    {
        return A(docerrorreporter);
    }

    void C(String as[][])
    {
        F = true;
        G = true;
        M = true;
        for(int i = 0; i < as.length; i++)
        {
            String s = as[i].length <= 0 ? "" : as[i][0].toLowerCase();
            if(s.equals("-noumltypegen"))
            {
                F = false;
                continue;
            }
            if(s.equals("-noumlpackagegen"))
            {
                G = false;
                continue;
            }
            if(s.equals("-noumloverviewgen"))
            {
                M = false;
                continue;
            }
            if(s.equals("-umlfileformat"))
            {
                ydoc.A.A.B().F(as[i][1]);
                D.A().B((new StringBuilder()).append("Overriding property 'uml_file_format' with value '").append(as[i][1]).append("'").toString());
            }
        }

    }

    void E(String as[][])
    {
        ArrayList arraylist = new ArrayList();
        LinkedHashSet linkedhashset = new LinkedHashSet();
        String s = null;
        String s1 = null;
        H h = H.J();
        A(new ydoc.B.A(h.E()));
        if(B() || 56979 != h.I())
            A(new G());
        Q = new E(this, true);
        A(Q);
        for(int i = 0; i < as.length; i++)
        {
            String s2 = as[i].length <= 0 ? "" : as[i][0].toLowerCase();
            if("-nohtml".equals(s2))
            {
                P = false;
                continue;
            }
            if("-tag".equals(s2) || "-taglet".equals(s2) || "-ytag".equals(s2))
            {
                linkedhashset.add(as[i][1]);
                continue;
            }
            if("-resolver".equals(s2))
            {
                s = as[i][1];
                continue;
            }
            if("-resolverpath".equals(s2))
                s1 = as[i][1];
        }

        if(s != null)
            A.A(s, s1);
        linkedhashset.addAll(arraylist);
        linkedhashset.add("y.uml");
        A(linkedhashset);
    }

    boolean A(String s)
    {
        return super.A(s) || s.equals("-noumltypegen") || s.equals("-noumlpackagegen") || s.equals("-noumloverviewgen") || s.equals("-nohtml") || s.equals("-ytag") || s.equals("-umlfileformat");
    }

    void A()
    {
        C.B = R;
    }

    void I()
    {
        C.B = R;
    }

    private void A(Set set)
    {
        int i = 0;
        String as[] = new String[set.size()];
        for(Iterator iterator = set.iterator(); iterator.hasNext();)
        {
            as[i] = (String)iterator.next();
            i++;
        }

        _A _la = new _A(as);
        Arrays.sort(G().getConstructorCustomTags(), _la);
        Arrays.sort(G().getFieldCustomTags(), _la);
        Arrays.sort(G().getInlineCustomTags(), _la);
        Arrays.sort(G().getMethodCustomTags(), _la);
        Arrays.sort(G().getOverviewCustomTags(), _la);
        Arrays.sort(G().getPackageCustomTags(), _la);
        Arrays.sort(G().getTypeCustomTags(), _la);
    }

    private static final ydoc.B.C._B R = new ydoc.B.C._A("powered by yWorks - http://www.yworks.com/", "http://www.yworks.com/");
    public E Q;
    public boolean P;

}
