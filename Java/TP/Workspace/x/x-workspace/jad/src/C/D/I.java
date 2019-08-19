// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.D;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package C.D:
//            D, h, A, c

public class I extends D
    implements h
{

    public I(String s, Object aobj[], Object obj)
    {
        super(s, obj);
        d = aobj;
        e = new A(aobj);
        b = new HashMap();
        if(e.C(obj) < 0)
        {
            if(aobj != null && aobj.length > 0)
                V = aobj[0];
            T = true;
        }
    }

    public I(String s, Object aobj[], int i)
    {
        this(s, aobj, aobj == null || i <= -1 || i >= aobj.length ? null : aobj[i]);
    }

    public String C()
    {
        return "Enum";
    }

    public void B(int i)
    {
        Object aobj[] = e.P();
        if(aobj != null && i > -1 && i < aobj.length)
            A(aobj[i]);
        else
            B(true);
    }

    public int I()
    {
        return e.C(W);
    }

    public Object[] J()
    {
        return e.P();
    }

    public Object[] H()
    {
        return e.P();
    }

    public void B(String s)
    {
        Object aobj[] = e.P();
        if(F().equals(Integer.TYPE))
        {
            try
            {
                B(Math.max(0, Math.min(aobj.length - 1, Integer.parseInt(s))));
            }
            catch(NumberFormatException numberformatexception)
            {
                B(true);
            }
        } else
        {
            if(aobj != null)
                if(s != null)
                {
                    for(int i = 0; i < aobj.length; i++)
                        if(aobj[i] != null && s.equals(aobj[i].toString()))
                        {
                            A(aobj[i]);
                            return;
                        }

                } else
                {
                    for(int j = 0; j < aobj.length; j++)
                        if(s == aobj[j])
                        {
                            A(aobj[j]);
                            return;
                        }

                }
            G();
        }
    }

    public void B(boolean flag)
    {
        super.B(flag || e.C(W) < 0);
    }

    public void A(Object obj)
    {
        super.A(obj);
        super.B(e.C(obj) < 0);
    }

    public void G()
    {
        super.G();
        Object aobj[] = H();
        if(C.D.c.A(((Object) (aobj)), ((Object) (d))))
        {
            e.A(d);
            B(g, ((Object) (aobj)), ((Object) (d)));
        }
        super.B(e.C(W) < 0);
    }

    static Class _mthclass$(String s)
    {
        return Class.forName(s);
        ClassNotFoundException classnotfoundexception;
        classnotfoundexception;
        throw new NoClassDefFoundError(classnotfoundexception.getMessage());
    }

    public static final String h = "EnumOptionItem.itemListener";
    public static final String a = "EnumOptionItem.renderer";
    public static final String f = "backupEnum";
    public static final String c = "backupValue";
    public static final String g = "enum";
    private A e;
    private Map b;
    private Object d[];

}
