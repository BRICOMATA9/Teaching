// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.bridge;

import java.util.Iterator;
import org.w3c.dom.Element;

// Referenced classes of package org.apache.batik.bridge:
//            BridgeContext

public interface BridgeExtension
{

    public abstract float getPriority();

    public abstract Iterator getImplementedExtensions();

    public abstract String getAuthor();

    public abstract String getContactAddress();

    public abstract String getURL();

    public abstract String getDescription();

    public abstract void registerTags(BridgeContext bridgecontext);

    public abstract boolean isDynamicElement(Element element);
}
