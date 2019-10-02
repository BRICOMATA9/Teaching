// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.freehep.util;

import java.io.Serializable;
import java.util.*;

public class DoubleHashtable extends AbstractCollection
    implements Serializable
{

    public DoubleHashtable()
    {
        table = new Hashtable();
    }

    public void clear()
    {
        table.clear();
    }

    public void clear(Object obj)
    {
        Hashtable hashtable = get(obj);
        if(hashtable != null)
            hashtable.clear();
    }

    public Object clone()
        throws CloneNotSupportedException
    {
        throw new CloneNotSupportedException("DoubleHashtable.clone() is not (yet) supported.");
    }

    public boolean contains(Object obj)
    {
        if(obj == null)
            obj = this;
        for(Enumeration enumeration = table.keys(); enumeration.hasMoreElements();)
        {
            Hashtable hashtable = get(enumeration.nextElement());
            if(hashtable.contains(obj))
                return true;
        }

        return false;
    }

    public boolean containsKey(Object obj)
    {
        if(obj == null)
            obj = this;
        return table.containsKey(obj);
    }

    public boolean containsKey(Object obj, Object obj1)
    {
        if(obj1 == null)
            obj1 = this;
        Hashtable hashtable = get(obj);
        return hashtable == null ? false : hashtable.containsKey(obj1);
    }

    public Enumeration elements()
    {
        return new Enumeration() {

            public boolean hasMoreElements()
            {
                if(valueEnumeration == null || !valueEnumeration.hasMoreElements())
                {
                    if(!subtableEnumeration.hasMoreElements())
                        return false;
                    valueEnumeration = ((Hashtable)subtableEnumeration.nextElement()).elements();
                }
                return true;
            }

            public Object nextElement()
            {
                hasMoreElements();
                Object obj = valueEnumeration.nextElement();
                return obj != nullValue ? obj : null;
            }

            private Enumeration subtableEnumeration;
            private Enumeration valueEnumeration;
            private Object nullValue;

            
            {
                super();
                subtableEnumeration = table.elements();
                nullValue = DoubleHashtable.this;
            }
        };
    }

    public Iterator iterator()
    {
        return new Iterator() {

            public boolean hasNext()
            {
                if(valueIterator == null || !valueIterator.hasNext())
                {
                    if(!subtableIterator.hasNext())
                        return false;
                    java.util.Map.Entry entry = (java.util.Map.Entry)subtableIterator.next();
                    subtable = (Map)entry.getValue();
                    valueIterator = subtable.entrySet().iterator();
                }
                return true;
            }

            public Object next()
            {
                hasNext();
                java.util.Map.Entry entry = (java.util.Map.Entry)valueIterator.next();
                Object obj = entry.getValue();
                return obj != nullValue ? obj : null;
            }

            public void remove()
            {
                valueIterator.remove();
                if(subtable.isEmpty())
                    subtableIterator.remove();
            }

            private Iterator subtableIterator;
            private Map subtable;
            private Iterator valueIterator;
            private Object nullValue;

            
            {
                super();
                subtableIterator = table.entrySet().iterator();
                nullValue = DoubleHashtable.this;
            }
        };
    }

    public Hashtable get(Object obj)
    {
        if(obj == null)
            obj = this;
        return (Hashtable)table.get(obj);
    }

    public Object get(Object obj, Object obj1)
    {
        if(obj1 == null)
            obj1 = this;
        Hashtable hashtable = get(obj);
        Object obj2 = hashtable != null ? hashtable.get(obj1) : null;
        return obj2 != this ? obj2 : null;
    }

    public boolean isEmpty()
    {
        return table.isEmpty();
    }

    public Enumeration keys()
    {
        return table.keys();
    }

    public Enumeration keys(Object obj)
    {
        final Hashtable subtable = get(obj);
        return new Enumeration() {

            public boolean hasMoreElements()
            {
                return subkeys != null ? subkeys.hasMoreElements() : false;
            }

            public Object nextElement()
            {
                if(subkeys == null)
                {
                    throw new NoSuchElementException();
                } else
                {
                    Object obj1 = subkeys.nextElement();
                    return obj1 != nullKey ? obj1 : null;
                }
            }

            private Enumeration subkeys;
            private Object nullKey;

            
            {
                super();
                subkeys = subtable != null ? subtable.keys() : null;
                nullKey = DoubleHashtable.this;
            }
        };
    }

    public Object put(Object obj, Object obj1, Object obj2)
    {
        Hashtable hashtable = get(obj);
        if(hashtable == null)
        {
            hashtable = new Hashtable();
            if(obj == null)
                obj = this;
            table.put(obj, hashtable);
        }
        if(obj1 == null)
            obj1 = this;
        if(obj2 == null)
            obj2 = this;
        Object obj3 = hashtable.get(obj1);
        hashtable.put(obj1, obj2);
        return obj3 != this ? obj3 : null;
    }

    public Object remove(Object obj, Object obj1)
    {
        Hashtable hashtable = get(obj);
        if(hashtable == null)
            return null;
        if(obj1 == null)
            obj1 = this;
        Object obj2 = hashtable.remove(obj1);
        if(hashtable.isEmpty())
        {
            if(obj == null)
                obj = this;
            table.remove(obj);
        }
        return obj2 != this ? obj2 : null;
    }

    public int size()
    {
        int i = 0;
        for(Enumeration enumeration = table.keys(); enumeration.hasMoreElements();)
        {
            Object obj = enumeration.nextElement();
            Hashtable hashtable = get(obj);
            i += hashtable.size();
        }

        return i;
    }

    public String toString()
    {
        return "DoubleHashtable@" + hashCode();
    }

    private static final long serialVersionUID = 0xf86d73305fa24ef4L;
    private Hashtable table;

}
