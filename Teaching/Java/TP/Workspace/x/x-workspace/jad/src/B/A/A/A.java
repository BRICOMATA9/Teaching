// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package B.A.A;

import C.A.Y;
import java.util.*;

public class A
    implements Cloneable
{
    private static final class _B
    {

        public String toString()
        {
            return A;
        }

        private final String A;

        private _B(String s)
        {
            A = s;
        }

    }

    private static final class _A extends java.awt.RenderingHints.Key
    {

        public boolean isCompatibleValue(Object obj)
        {
            return obj == null || (obj instanceof _B);
        }

        private _A()
        {
            super(0);
        }

    }


    public static final java.awt.RenderingHints.Key K = new _A();
    public static final Object B = new _B("force vectorization");
    public static final Object C = new _B("force rasterization");
    public static final Object E = new _B("default");
    private static final Map H = Collections.synchronizedMap(new WeakHashMap(11));
    private static final Map I = Collections.synchronizedMap(new WeakHashMap(11));
    private static final Y J = new Y();
    private static int A = 10;
    private static int G = 0x186a0;
    private static boolean D = true;
    private static double F = 0.90000000000000002D;

}
