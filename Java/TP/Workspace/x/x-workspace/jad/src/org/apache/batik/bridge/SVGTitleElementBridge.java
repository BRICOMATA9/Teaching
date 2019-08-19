// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.bridge;


// Referenced classes of package org.apache.batik.bridge:
//            SVGDescriptiveElementBridge, Bridge

public class SVGTitleElementBridge extends SVGDescriptiveElementBridge
{

    public SVGTitleElementBridge()
    {
    }

    public String getLocalName()
    {
        return "title";
    }

    public Bridge getInstance()
    {
        return new SVGTitleElementBridge();
    }
}
