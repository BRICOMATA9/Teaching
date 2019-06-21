// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package A.C;

import B.B.A.B.C;
import B.B.A.B.E;
import java.util.Iterator;
import java.util.MissingResourceException;

public class D
    implements B.B.A.B.C._D
{

    public static D F()
    {
        return E;
    }

    private D()
    {
        F = null;
    }

    public Iterator B()
    {
        return E().B();
    }

    public Iterator A()
    {
        return E().A();
    }

    private E E()
    {
        if(F == null)
        {
            java.net.URL url = getClass().getResource("java-style-property-descriptors.xml");
            if(url != null)
                F = B.B.A.B.E.A(url);
            else
                throw new MissingResourceException("java-style-property-descriptors.xml", null, null);
        }
        return F;
    }

    private static final D E = new D();
    private E F;

}
