// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.extension;

import java.net.MalformedURLException;
import java.net.URL;
import org.apache.batik.css.engine.CSSStylableElement;
import org.apache.batik.css.engine.StyleMap;
import org.apache.batik.dom.AbstractDocument;
import org.apache.batik.dom.svg.XMLBaseSupport;
import org.w3c.dom.Node;
import org.w3c.dom.css.CSSStyleDeclaration;
import org.w3c.dom.css.CSSValue;
import org.w3c.dom.svg.SVGAnimatedString;
import org.w3c.dom.svg.SVGStylable;

// Referenced classes of package org.apache.batik.extension:
//            ExtensionElement

public abstract class StylableExtensionElement extends ExtensionElement
    implements CSSStylableElement, SVGStylable
{

    protected StylableExtensionElement()
    {
    }

    protected StylableExtensionElement(String s, AbstractDocument abstractdocument)
    {
        super(s, abstractdocument);
    }

    public StyleMap getComputedStyleMap(String s)
    {
        return computedStyleMap;
    }

    public void setComputedStyleMap(String s, StyleMap stylemap)
    {
        computedStyleMap = stylemap;
    }

    public String getXMLId()
    {
        return getAttributeNS(null, "id");
    }

    public String getCSSClass()
    {
        return getAttributeNS(null, "class");
    }

    public URL getCSSBase()
    {
        if(cssBase != null)
            break MISSING_BLOCK_LABEL_49;
        String s = XMLBaseSupport.getCascadedXMLBase(this);
        if(s == null)
            return null;
        try
        {
            cssBase = new URL(XMLBaseSupport.getCascadedXMLBase(this));
        }
        catch(MalformedURLException malformedurlexception)
        {
            malformedurlexception.printStackTrace();
            throw new InternalError();
        }
        return cssBase;
    }

    public boolean isPseudoInstanceOf(String s)
    {
        if(s.equals("first-child"))
        {
            Node node;
            for(node = getPreviousSibling(); node != null && node.getNodeType() != 1; node = node.getPreviousSibling());
            return node == null;
        } else
        {
            return false;
        }
    }

    public CSSStyleDeclaration getStyle()
    {
        throw new InternalError("Not implemented");
    }

    public CSSValue getPresentationAttribute(String s)
    {
        throw new InternalError("Not implemented");
    }

    public SVGAnimatedString getClassName()
    {
        throw new InternalError("Not implemented");
    }

    protected URL cssBase;
    protected StyleMap computedStyleMap;
}
