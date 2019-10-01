// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.J;

import java.beans.PropertyChangeEvent;

// Referenced classes of package C.J:
//            b

public class IA extends PropertyChangeEvent
{

    public IA(b b, Object obj, String s, Object obj1, Object obj2)
    {
        super(b, s, obj1, obj2);
        A = obj;
    }

    public String getPropertyName()
    {
        return super.getPropertyName();
    }

    private Object A;
}
