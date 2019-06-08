// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package B.A.B;

import java.util.regex.Pattern;

public class A
{
    private static final class _A extends java.awt.RenderingHints.Key
    {

        public boolean isCompatibleValue(Object obj)
        {
            return obj == null || (obj instanceof A);
        }

        private _A()
        {
            super(0);
        }

    }


    public A()
    {
        A = 0;
    }

    public static final java.awt.RenderingHints.Key C = new _A();
    private final Pattern B = Pattern.compile("url\\(\\#(.+?)\\)");
    private int A;

}
