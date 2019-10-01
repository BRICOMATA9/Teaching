// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.w3c.dom.svg;

import org.w3c.dom.css.CSSStyleDeclaration;
import org.w3c.dom.css.CSSValue;

// Referenced classes of package org.w3c.dom.svg:
//            SVGAnimatedString

public interface SVGStylable
{

    public abstract SVGAnimatedString getClassName();

    public abstract CSSStyleDeclaration getStyle();

    public abstract CSSValue getPresentationAttribute(String s);
}
