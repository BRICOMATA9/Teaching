// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package B.B.B;

import java.util.ArrayList;
import java.util.List;

// Referenced classes of package B.B.B:
//            C, B, G

public class E
    implements C, Cloneable
{

    public E()
    {
        A = new ArrayList();
        B = new ArrayList();
        D = "";
        F = "";
    }

    public List F()
    {
        return A;
    }

    public void A(List list)
    {
        A = list;
    }

    public int C()
    {
        return C;
    }

    public void A(int i)
    {
        C = i;
    }

    public String E()
    {
        return D;
    }

    public void A(String s)
    {
        D = s;
    }

    public List A()
    {
        return B;
    }

    public void B(List list)
    {
        B = list;
    }

    public byte B()
    {
        return E;
    }

    public void A(byte byte0)
    {
        E = byte0;
    }

    public String D()
    {
        return F;
    }

    public void B(String s)
    {
        F = s;
    }

    public Object clone()
    {
        E e;
        e = (E)super.clone();
        e.A = new ArrayList(A.size());
        for(int i = 0; i < A.size(); i++)
            e.A.add(((B)A.get(i)).clone());

        e.B = new ArrayList(B.size());
        for(int j = 0; j < B.size(); j++)
            e.B.add(((G)B.get(j)).clone());

        return e;
        CloneNotSupportedException clonenotsupportedexception;
        clonenotsupportedexception;
        return null;
    }

    public static final Object G = "Classifier#DP_KEY";
    private String D;
    private String F;
    private byte E;
    private int C;
    private List A;
    private List B;

}
