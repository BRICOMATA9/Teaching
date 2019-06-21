// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.dom;

import org.apache.batik.css.engine.CSSEngine;
import org.w3c.dom.*;
import org.w3c.dom.css.CSSStyleDeclaration;
import org.w3c.dom.css.DocumentCSS;
import org.w3c.dom.stylesheets.StyleSheetList;
import org.w3c.dom.views.AbstractView;
import org.w3c.dom.views.DocumentView;

// Referenced classes of package org.apache.batik.dom:
//            AbstractDocument, ExtensibleDOMImplementation

public abstract class AbstractStylableDocument extends AbstractDocument
    implements DocumentCSS, DocumentView
{

    protected AbstractStylableDocument()
    {
    }

    protected AbstractStylableDocument(DocumentType documenttype, DOMImplementation domimplementation)
    {
        super(documenttype, domimplementation);
    }

    public void setCSSEngine(CSSEngine cssengine)
    {
        cssEngine = cssengine;
    }

    public CSSEngine getCSSEngine()
    {
        return cssEngine;
    }

    public StyleSheetList getStyleSheets()
    {
        throw new RuntimeException(" !!! Not implemented");
    }

    public AbstractView getDefaultView()
    {
        if(defaultView == null)
        {
            ExtensibleDOMImplementation extensibledomimplementation = (ExtensibleDOMImplementation)implementation;
            defaultView = extensibledomimplementation.createViewCSS(this);
        }
        return defaultView;
    }

    public void clearViewCSS()
    {
        defaultView = null;
        if(cssEngine != null)
            cssEngine.dispose();
        cssEngine = null;
    }

    public CSSStyleDeclaration getOverrideStyle(Element element, String s)
    {
        throw new RuntimeException(" !!! Not implemented");
    }

    protected transient AbstractView defaultView;
    protected transient CSSEngine cssEngine;
}
