// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.E;


// Referenced classes of package C.E:
//            B

public abstract class F
    implements B
{

    protected F(Class class1)
    {
        F = class1;
    }

    public Object A(String s, Class class1)
        throws IllegalArgumentException
    {
        if(s == null)
            return null;
        if(class1 == null)
            throw new NullPointerException("Must provide asClass argument!");
        if(!F.isAssignableFrom(class1))
            throw new IllegalArgumentException(this + " cannot parse " + s + " as " + class1);
        else
            return A(s);
    }

    public String A(Object obj, Class class1)
        throws IllegalArgumentException
    {
        if(obj == null)
            return null;
        if(class1 == null)
            throw new NullPointerException("Must provide asClass argument!");
        if(!F.isAssignableFrom(class1))
            throw new IllegalArgumentException(this + " cannot serializer " + obj + " as " + class1);
        else
            return A(obj);
    }

    protected abstract Object A(String s)
        throws IllegalArgumentException;

    protected abstract String A(Object obj)
        throws IllegalArgumentException;

    protected Class F;
}
