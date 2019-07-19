// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.H;

import java.io.IOException;

public class H extends IOException
{

    public H(byte byte0)
    {
        super("Incompatible version number found : " + byte0);
    }

    public H(byte byte0, byte byte1)
    {
        super("Expected version " + byte0 + " but found : " + byte1);
    }

    public H()
    {
    }

    public H(String s)
    {
        super(s);
    }
}
