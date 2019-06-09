// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.D;

import java.beans.*;
import java.util.*;
import javax.swing.event.SwingPropertyChangeSupport;

// Referenced classes of package C.D:
//            X, Q, c

class Z
    implements X, Q
{

    public Z(Object obj)
    {
        s = obj;
        q = null;
        p = null;
    }

    public Object C(String s1)
    {
        if(p == null)
            return null;
        else
            return p.get(s1);
    }

    public void C(String s1, Object obj)
    {
        if(p == null)
            p = new HashMap();
        Object obj1 = p.get(s1);
        if(c.A(obj1, obj))
        {
            if(obj != null)
                p.put(s1, obj);
            else
                p.remove(s1);
            D(s1, obj1, obj);
        }
    }

    public void B(PropertyChangeListener propertychangelistener)
    {
        if(propertychangelistener != null)
        {
            if(q == null)
                q = new SwingPropertyChangeSupport(s);
            q.addPropertyChangeListener(propertychangelistener);
        }
    }

    protected void D(String s1, Object obj, Object obj1)
    {
        if(q != null)
            q.firePropertyChange(s1, obj, obj1);
    }

    protected void A(PropertyChangeEvent propertychangeevent)
    {
        if(q != null)
            q.firePropertyChange(propertychangeevent);
    }

    public void B(VetoableChangeListener vetoablechangelistener)
    {
        if(vetoablechangelistener != null)
        {
            if(r == null)
                r = new ArrayList();
            r.add(vetoablechangelistener);
        }
    }

    protected void C(String s1, Object obj, Object obj1)
        throws PropertyVetoException
    {
        PropertyChangeEvent propertychangeevent = new PropertyChangeEvent(s, s1, obj, obj1);
        B(propertychangeevent);
    }

    protected void B(PropertyChangeEvent propertychangeevent)
        throws PropertyVetoException
    {
        A(propertychangeevent, true);
    }

    void A(PropertyChangeEvent propertychangeevent, boolean flag)
        throws PropertyVetoException
    {
        Object obj = propertychangeevent.getOldValue();
        Object obj1 = propertychangeevent.getNewValue();
        Object obj2 = propertychangeevent.getSource();
        String s1 = propertychangeevent.getPropertyName();
        if(obj != null && obj1 != null && obj.equals(obj1))
            return;
        ArrayList arraylist = new ArrayList();
        synchronized(this)
        {
            if(r != null)
                arraylist.addAll(r);
            if(o != null && s1 != null && o.containsKey(s1))
                arraylist.addAll((List)o.get(s1));
        }
        if(!arraylist.isEmpty())
            try
            {
                for(Iterator iterator = arraylist.iterator(); iterator.hasNext(); ((VetoableChangeListener)iterator.next()).vetoableChange(propertychangeevent));
            }
            catch(PropertyVetoException propertyvetoexception)
            {
                if(flag)
                {
                    PropertyChangeEvent propertychangeevent1 = new PropertyChangeEvent(obj2, s1, obj1, obj);
                    for(Iterator iterator1 = arraylist.iterator(); iterator1.hasNext();)
                        try
                        {
                            ((VetoableChangeListener)iterator1.next()).vetoableChange(propertychangeevent1);
                        }
                        catch(PropertyVetoException propertyvetoexception1) { }

                }
                throw propertyvetoexception;
            }
    }

    protected PropertyChangeSupport q;
    protected Map p;
    private final Object s;
    private List r;
    private Map o;
}
