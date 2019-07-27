// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package ydoc.doclets;

import java.lang.reflect.Method;

class N
{
    private static final class _B extends N
    {

        boolean A(Object obj, Object obj1)
        {
            return false;
        }

        private _B()
        {
        }

    }

    private static final class _A extends N
    {

        boolean A(Object obj, Object obj1)
        {
            Object obj2 = A.invoke(obj, new Object[] {
                obj1
            });
            return ((Boolean)obj2).booleanValue();
            Exception exception;
            exception;
            return false;
        }

        private final Method A;

        _A(Method method)
        {
            A = method;
        }
    }


    private N()
    {
    }

    boolean A(Object obj, Object obj1)
    {
        throw new InternalError("Badly shrinked");
    }

    static N A(Class class1, String s, Class class2)
    {
        int i = 0x7fffffff;
        Method method = null;
        Method amethod[] = class1.getMethods();
        for(int j = 0; j < amethod.length; j++)
        {
            if(!s.equals(amethod[j].getName()))
                continue;
            Class aclass[] = amethod[j].getParameterTypes();
            if(aclass.length != 1)
                continue;
            int k = A(aclass[0], class2);
            if(k > -1 && i > k)
            {
                i = k;
                method = amethod[j];
            }
        }

        if(method == null)
            return new _B();
        else
            return new _A(method);
    }

    private static int A(Class class1, Class class2)
    {
        int i = 0;
        for(Class class3 = class2; class3 != null; class3 = class3.getSuperclass())
        {
            if(class3.equals(class1))
                return i;
            i++;
        }

        return -1;
    }

}
