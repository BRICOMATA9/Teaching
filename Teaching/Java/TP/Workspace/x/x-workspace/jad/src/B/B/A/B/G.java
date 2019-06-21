// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package B.B.A.B;

import B.B.C.J;
import C.E.B;
import java.util.HashMap;
import java.util.Map;

class G
{
    private static final class _B
        implements B
    {

        public String A(Object obj, Class class1)
            throws IllegalArgumentException
        {
            return A.D(obj);
        }

        public Object A(String s, Class class1)
            throws IllegalArgumentException
        {
            return A.C(s);
        }

        private final J A;

        _B(J j)
        {
            A = j;
        }
    }

    private static final class _C
        implements B
    {

        public String A(Object obj, Class class1)
            throws IllegalArgumentException
        {
            return B.E(obj);
        }

        public Object A(String s, Class class1)
            throws IllegalArgumentException
        {
            return B.B(s);
        }

        private final J B;

        _C(J j)
        {
            B = j;
        }
    }

    private static final class _F
        implements B
    {

        public String A(Object obj, Class class1)
            throws IllegalArgumentException
        {
            return obj == null ? "" : D.B(obj);
        }

        public Object A(String s, Class class1)
            throws IllegalArgumentException
        {
            return null != s && s.length() != 0 ? D.E(s) : null;
        }

        private final J D;

        _F(J j)
        {
            D = j;
        }
    }

    private static final class _G
        implements B
    {

        public String A(Object obj, Class class1)
            throws IllegalArgumentException
        {
            return E.C(obj);
        }

        public Object A(String s, Class class1)
            throws IllegalArgumentException
        {
            return E.A(s);
        }

        private final J E;

        _G(J j)
        {
            E = j;
        }
    }

    private static final class _D
        implements B
    {

        public String A(Object obj, Class class1)
            throws IllegalArgumentException
        {
            return C.A(obj);
        }

        public Object A(String s, Class class1)
            throws IllegalArgumentException
        {
            return C.F(s);
        }

        private final J C;

        _D(J j)
        {
            C = j;
        }
    }

    private static final class _E
        implements B
    {

        public String A(Object obj, Class class1)
            throws IllegalArgumentException
        {
            return (String)obj;
        }

        public Object A(String s, Class class1)
            throws IllegalArgumentException
        {
            return s;
        }

        private _E()
        {
        }

    }

    private static final class _A
        implements B
    {

        public String A(Object obj, Class class1)
            throws IllegalArgumentException
        {
            return obj.toString();
        }

        public Object A(String s, Class class1)
            throws IllegalArgumentException
        {
            return new Byte(s);
        }

        private _A()
        {
        }

    }


    static B A(Class class1)
    {
        return (B)A.get(class1);
    }

    static Class _mthclass$(String s)
    {
        return Class.forName(s);
        ClassNotFoundException classnotfoundexception;
        classnotfoundexception;
        throw new NoClassDefFoundError(classnotfoundexception.getMessage());
    }

    private static final Map A;

    static 
    {
        A = new HashMap();
        A.put(java.lang.Byte.class, new _A());
        A.put(java.lang.String.class, new _E());
        J j = new J();
        A.put(C.J._.class, new _D(j));
        A.put(java.awt.Color.class, new _F(j));
        A.put(java.lang.Double.class, new _C(j));
        A.put(java.awt.Font.class, new _B(j));
        A.put(C.J.O.class, new _G(j));
    }
}
