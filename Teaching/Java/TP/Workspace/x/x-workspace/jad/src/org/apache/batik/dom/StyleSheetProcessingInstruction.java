// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.dom;

import org.apache.batik.dom.util.DOMUtilities;
import org.apache.batik.dom.util.HashTable;
import org.w3c.dom.DOMException;
import org.w3c.dom.Node;
import org.w3c.dom.stylesheets.LinkStyle;
import org.w3c.dom.stylesheets.StyleSheet;

// Referenced classes of package org.apache.batik.dom:
//            AbstractProcessingInstruction, StyleSheetFactory, AbstractDocument

public class StyleSheetProcessingInstruction extends AbstractProcessingInstruction
    implements LinkStyle
{

    protected StyleSheetProcessingInstruction()
    {
    }

    public StyleSheetProcessingInstruction(String s, AbstractDocument abstractdocument, StyleSheetFactory stylesheetfactory)
    {
        ownerDocument = abstractdocument;
        setData(s);
        factory = stylesheetfactory;
    }

    public boolean isReadonly()
    {
        return readonly;
    }

    public void setReadonly(boolean flag)
    {
        readonly = flag;
    }

    public void setNodeName(String s)
    {
    }

    public String getTarget()
    {
        return "xml-stylesheet";
    }

    public StyleSheet getSheet()
    {
        if(sheet == null)
            sheet = factory.createStyleSheet(this, getPseudoAttributes());
        return sheet;
    }

    public HashTable getPseudoAttributes()
    {
        if(pseudoAttributes == null)
        {
            pseudoAttributes = new HashTable();
            pseudoAttributes.put("alternate", "no");
            pseudoAttributes.put("media", "all");
            DOMUtilities.parseStyleSheetPIData(data, pseudoAttributes);
        }
        return pseudoAttributes;
    }

    public void setData(String s)
        throws DOMException
    {
        super.setData(s);
        sheet = null;
        pseudoAttributes = null;
    }

    protected Node newNode()
    {
        return new StyleSheetProcessingInstruction();
    }

    protected boolean readonly;
    protected transient StyleSheet sheet;
    protected StyleSheetFactory factory;
    protected transient HashTable pseudoAttributes;
}
