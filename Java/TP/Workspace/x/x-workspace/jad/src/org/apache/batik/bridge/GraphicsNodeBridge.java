// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.bridge;

import org.apache.batik.gvt.GraphicsNode;
import org.w3c.dom.Element;

// Referenced classes of package org.apache.batik.bridge:
//            Bridge, BridgeContext

public interface GraphicsNodeBridge
    extends Bridge
{

    public abstract GraphicsNode createGraphicsNode(BridgeContext bridgecontext, Element element);

    public abstract void buildGraphicsNode(BridgeContext bridgecontext, Element element, GraphicsNode graphicsnode);

    public abstract boolean isComposite();

    public abstract boolean getDisplay(Element element);

    public abstract Bridge getInstance();
}
