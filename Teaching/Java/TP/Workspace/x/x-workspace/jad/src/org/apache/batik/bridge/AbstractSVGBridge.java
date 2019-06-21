// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.bridge;

import org.apache.batik.util.SVGConstants;

// Referenced classes of package org.apache.batik.bridge:
//            Bridge

public abstract class AbstractSVGBridge
    implements Bridge, SVGConstants
{

    protected AbstractSVGBridge()
    {
    }

    public String getNamespaceURI()
    {
        return "http://www.w3.org/2000/svg";
    }

    public Bridge getInstance()
    {
        return this;
    }
}
