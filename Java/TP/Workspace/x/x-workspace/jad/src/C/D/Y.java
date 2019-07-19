// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.D;

import C.E.D;
import java.io.*;
import java.lang.ref.WeakReference;
import java.util.*;

// Referenced classes of package C.D:
//            X, b, Z, V, 
//            R, _, I, j, 
//            F, J, d, L, 
//            f, E, O

public class Y
    implements X, b
{
    private static final class _A
        implements L
    {

        public boolean equals(Object obj)
        {
            return obj instanceof _A;
        }

        private O F;

        public _A(String s)
        {
            F = new O();
            F.A(false);
            try
            {
                F.A(s);
            }
            catch(MissingResourceException missingresourceexception) { }
        }
    }


    public static J K()
    {
        return C0;
    }

    public static L M()
    {
        return C5;
    }

    private static void A(Y y)
    {
        C2.put(y.N(), new WeakReference(y));
    }

    public Y(String s)
    {
        this(null, null, s);
    }

    public Y(L l, J j1, String s)
    {
        AA = null;
        if(l == null)
            l = M();
        if(j1 == null)
            j1 = K();
        BA = l;
        C7 = j1;
        B5 = s;
        C8 = new Z(this);
        C6 = new V(this);
        C3 = null;
        CB = new ArrayList(1);
        CC = new Vector(10);
        C1 = CA = new R("");
        A(C1);
        CC.add(C1);
        L();
    }

    public String N()
    {
        return B5;
    }

    public F A(String s, double d1)
    {
        _ _l = new _(s, d1);
        A(((F) (_l)));
        return _l;
    }

    public I A(String s, Object aobj[], int i)
    {
        I k = new I(s, aobj, i);
        A(((F) (k)));
        return k;
    }

    public F A(String s, boolean flag)
    {
        j j1 = new j(s, flag);
        A(((F) (j1)));
        return j1;
    }

    public F A(F f)
    {
        f.A(C6);
        f.A(C6);
        C1.add(f);
        A(C1, f);
        A(C1.A(), f);
        return f;
    }

    public double F(String s)
    {
        return C.E.D.B(E(s));
    }

    public boolean H(String s)
    {
        return C.E.D.A(E(s));
    }

    public int G(String s)
    {
        return ((I)D(s)).I();
    }

    public Object E(String s)
    {
        return D(s).E();
    }

    public F D(String s)
    {
        F f = null;
label0:
        for(int i = 0; i < CC.size(); i++)
        {
            R r = C(i);
            int k = 0;
            do
            {
                if(k >= r.size())
                    continue label0;
                if(r.A(k).D().equals(s))
                {
                    f = r.A(k);
                    continue label0;
                }
                k++;
            } while(true);
        }

        if(f == null)
            throw new IllegalArgumentException("No such Option: [" + s + "]");
        else
            return f;
    }

    public R C(int i)
    {
        return (R)CC.elementAt(i);
    }

    public void A(OutputStream outputstream)
    {
        PrintStream printstream = new PrintStream(outputstream);
        String s = "\"";
        printstream.println("<OPTIONHANDLER name=" + s + N() + s + ">");
        for(int i = 0; i < CC.size(); i++)
        {
            R r = C(i);
            if(r != CA)
                printstream.println("<SECTION name=" + s + r.A() + s + ">");
            for(int k = 0; k < r.size(); k++)
            {
                F f = r.A(k);
                printstream.print("<ITEM name=" + s + f.D() + s + " " + "value" + "=" + s + f.E() + s + " " + "type" + "=" + s + f.C() + s);
                if(f instanceof I)
                {
                    printstream.print(" range=" + s);
                    Object aobj[] = ((I)f).J();
                    for(int l = 0; l < aobj.length - 1; l++)
                        printstream.print(aobj[l] + ":");

                    printstream.print(aobj[aobj.length - 1] + s);
                }
                printstream.print(">");
                printstream.println("</ITEM>");
            }

            printstream.println("</SECTION>");
        }

        printstream.println("</OPTIONHANDLER>");
        printstream.close();
    }

    public String toString()
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        A(bytearrayoutputstream);
        return bytearrayoutputstream.toString();
    }

    public boolean A(J j1)
    {
        Map map = j1.A(N());
        if(map != null)
            return A(map);
        else
            return false;
    }

    private boolean A(String s, F f)
    {
        if(C7 != null)
        {
            if(AA == null)
                AA = C7.A(N());
            if(AA != null)
                return A(s, f, AA);
        }
        return false;
    }

    private boolean A(F f, String s)
    {
        if(s == null)
        {
            f.B(true);
            return false;
        } else
        {
            f.B(s);
            f.B(false);
            return true;
        }
    }

    private boolean A(String s, F f, Map map)
    {
        Map map1 = null;
        if(CA.A().equals(s))
        {
            map1 = map;
        } else
        {
            Object obj = map.get(s);
            if(obj instanceof Map)
                map1 = (Map)obj;
        }
        if(map1 != null)
        {
            Object obj1 = map1.get(f.D());
            if(obj1 == null && map1.containsKey(f.D()) || (obj1 instanceof String))
                return A(f, (String)obj1);
        }
        return false;
    }

    private boolean A(Map map)
    {
        boolean flag = false;
        for(Iterator iterator = CC.iterator(); iterator.hasNext();)
        {
            R r = (R)iterator.next();
            if(r == CA)
            {
                Iterator iterator1 = r.iterator();
                while(iterator1.hasNext()) 
                {
                    F f = (F)iterator1.next();
                    Object obj2 = map.get(f.D());
                    if(obj2 == null && map.containsKey(f.D()) || (obj2 instanceof String))
                        flag |= A(f, (String)obj2);
                }
            } else
            {
                Object obj = map.get(r.A());
                if(obj instanceof Map)
                {
                    Map map1 = (Map)obj;
                    Iterator iterator2 = r.iterator();
                    while(iterator2.hasNext()) 
                    {
                        F f1 = (F)iterator2.next();
                        Object obj1 = map1.get(f1.D());
                        if(obj1 == null && map1.containsKey(f1.D()) || (obj1 instanceof String))
                            flag |= A(f1, (String)obj1);
                    }
                }
            }
        }

        return flag;
    }

    public L O()
    {
        return BA;
    }

    public void A(L l)
    {
        BA = l;
    }

    private void A(R r)
    {
        String s = N();
        String s1 = null;
        if(s != null && s.length() > 0)
            s1 = s;
        if(s1 != null)
            r.A(R.B, s1);
    }

    private void A(R r, F f)
    {
        String s = N();
        String s1 = r.A();
        String s2 = null;
        if(s1 != null && s1.length() > 0)
            s2 = s1;
        if(s != null && s.length() > 0)
            if(s2 != null)
                s2 = s + "." + s2;
            else
                s2 = s;
        if(s2 != null)
            f.B(F.F, s2);
    }

    private void L()
    {
        A(this);
    }

    static Class _mthclass$(String s)
    {
        return Class.forName(s);
        ClassNotFoundException classnotfoundexception;
        classnotfoundexception;
        throw new NoClassDefFoundError(classnotfoundexception.getMessage());
    }

    static Map C2 = new HashMap();
    private static L C5;
    private static J C0;
    private static f C9 = new d();
    private static L C4;
    protected L BA;
    protected J C7;
    String B5;
    Vector CC;
    R C1;
    private E C3;
    private R CA;
    private List CB;
    private final Z C8;
    private final V C6;
    Map AA;

    static 
    {
        try
        {
            C4 = new _A((C.D.Y.class).getName());
        }
        catch(Exception exception) { }
    }
}
