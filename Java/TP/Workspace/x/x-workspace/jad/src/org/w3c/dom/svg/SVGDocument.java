// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.w3c.dom.svg;

import org.w3c.dom.Document;
import org.w3c.dom.events.DocumentEvent;

// Referenced classes of package org.w3c.dom.svg:
//            SVGSVGElement

public interface SVGDocument
    extends Document, DocumentEvent
{

    public abstract String getTitle();

    public abstract String getReferrer();

    public abstract String getDomain();

    public abstract String getURL();

    public abstract SVGSVGElement getRootElement();
}
