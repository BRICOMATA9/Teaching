// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.freehep.util;

import org.openide.util.Lookup;
import org.openide.util.MetaInfServicesLookup;
import org.openide.util.lookup.*;

public class FreeHEPLookup extends Lookup
{
    private class MyProxyLookup extends ProxyLookup
    {

        private void setLookups(Lookup lookup1, Lookup lookup2)
        {
            super.setLookups(new Lookup[] {
                lookup1, lookup2
            });
        }


        MyProxyLookup(Lookup lookup1, Lookup lookup2)
        {
            super(new Lookup[] {
                lookup1, lookup2
            });
        }
    }

    private class DontAsk extends org.openide.util.lookup.AbstractLookup.Pair
    {

        protected boolean creatorOf(Object obj)
        {
            return obj == instance;
        }

        public String getDisplayName()
        {
            return instance.toString();
        }

        public String getId()
        {
            return id;
        }

        public Object getInstance()
        {
            return instance;
        }

        public Class getType()
        {
            return instance.getClass();
        }

        protected boolean instanceOf(Class class1)
        {
            return class1.isInstance(instance);
        }

        public boolean equals(Object obj)
        {
            if(obj instanceof DontAsk)
            {
                DontAsk dontask = (DontAsk)obj;
                return dontask.instance == instance && dontask.id.equals(id);
            } else
            {
                return false;
            }
        }

        public int hashCode()
        {
            return instance.hashCode() + id.hashCode();
        }

        private static final long serialVersionUID = 0xa41baf67b93874fdL;
        private Object instance;
        private String id;

        DontAsk(Object obj, String s)
        {
            super();
            id = s;
            instance = obj;
        }
    }


    private FreeHEPLookup()
    {
        proxy = new MyProxyLookup(contentLookup, Lookup.getDefault());
    }

    public static FreeHEPLookup instance()
    {
        return theLookup;
    }

    public void add(Object obj)
    {
        ic.add(obj);
    }

    public void add(Object obj, String s)
    {
        ic.addPair(new DontAsk(obj, s));
    }

    public void add(Object obj, String as[])
    {
        for(int i = 0; i < as.length; i++)
            ic.addPair(new DontAsk(obj, as[i]));

    }

    public void remove(Object obj)
    {
        ic.remove(obj);
    }

    public void remove(Object obj, String s)
    {
        ic.removePair(new DontAsk(obj, s));
    }

    public void remove(Object obj, String as[])
    {
        for(int i = 0; i < as.length; i++)
            ic.removePair(new DontAsk(obj, as[i]));

    }

    public void setClassLoader(ClassLoader classloader)
    {
        MetaInfServicesLookup metainfserviceslookup = new MetaInfServicesLookup(classloader);
        proxy.setLookups(contentLookup, metainfserviceslookup);
    }

    public org.openide.util.Lookup.Result lookup(org.openide.util.Lookup.Template template)
    {
        return proxy.lookup(template);
    }

    public Object lookup(Class class1)
    {
        return proxy.lookup(class1);
    }

    private static InstanceContent ic;
    private static AbstractLookup contentLookup;
    private static FreeHEPLookup theLookup = new FreeHEPLookup();
    private MyProxyLookup proxy;

    static 
    {
        ic = new InstanceContent();
        contentLookup = new AbstractLookup(ic);
    }
}
