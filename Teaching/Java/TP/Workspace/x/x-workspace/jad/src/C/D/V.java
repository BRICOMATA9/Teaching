// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.D;

import java.beans.*;

// Referenced classes of package C.D:
//            Z

class V extends Z
    implements PropertyChangeListener, VetoableChangeListener
{

    public V(Object obj)
    {
        super(obj);
    }

    public void propertyChange(PropertyChangeEvent propertychangeevent)
    {
        A(propertychangeevent);
    }

    public void vetoableChange(PropertyChangeEvent propertychangeevent)
        throws PropertyVetoException
    {
        A(propertychangeevent, false);
    }
}
