// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.E;

import java.lang.reflect.Constructor;

// Referenced classes of package C.E:
//            F

public class Y extends F
{

    public Y(Class class1)
    {
        super(class1);
        G = class1;
    }

    public Y(Class class1, Class class2)
    {
        super(class2);
        G = class1;
    }

    protected Object A(String s)
        throws IllegalArgumentException
    {
        Constructor constructor = G.getConstructor(new Class[] {
            java.lang.String.class
        });
        return constructor.newInstance(new Object[] {
            s
        });
        Exception exception;
        exception;
        throw new IllegalArgumentException("Could not deserialize " + s + " " + exception);
    }

    protected String A(Object obj)
        throws IllegalArgumentException
    {
        return obj.toString();
    }

    private Class G;
}
