// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.bridge;

import java.awt.geom.Dimension2D;

// Referenced classes of package org.apache.batik.bridge:
//            Viewport, UserAgent

public class UserAgentViewport
    implements Viewport
{

    public UserAgentViewport(UserAgent useragent)
    {
        userAgent = useragent;
    }

    public float getWidth()
    {
        return (float)userAgent.getViewportSize().getWidth();
    }

    public float getHeight()
    {
        return (float)userAgent.getViewportSize().getHeight();
    }

    private UserAgent userAgent;
}
