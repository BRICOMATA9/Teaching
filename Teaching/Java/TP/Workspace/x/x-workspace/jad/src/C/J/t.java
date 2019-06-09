// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.J;


public class t
{
    private static class _A extends java.awt.RenderingHints.Key
    {

        public boolean isCompatibleValue(Object obj)
        {
            return obj instanceof Double;
        }

        _A()
        {
            super(6001);
        }
    }


    public static java.awt.RenderingHints.Key A = new _A();

}
