// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.freehep.graphics2d;

import java.awt.Graphics2D;
import java.awt.font.TextAttribute;
import java.awt.font.TextLayout;
import java.awt.geom.AffineTransform;
import java.text.AttributedString;
import java.util.*;
import org.freehep.graphics2d.font.FontUtilities;

// Referenced classes of package org.freehep.graphics2d:
//            TagHandler, TagString

public class GenericTagHandler extends TagHandler
{
    private class AttributeEntry
    {

        protected void apply(AttributedString attributedstring)
        {
            attributedstring.addAttribute(textAttribute, value, begin, end);
        }

        private int begin;
        private int end;
        private TextAttribute textAttribute;
        private Object value;

        protected AttributeEntry(int i, int j, TextAttribute textattribute, Object obj)
        {
            super();
            begin = i;
            end = j;
            textAttribute = textattribute;
            value = obj;
        }
    }


    public GenericTagHandler(Graphics2D graphics2d)
    {
        graphics = graphics2d;
        clearedText = new StringBuffer();
        tags = new Hashtable();
    }

    public void print(TagString tagstring, double d, double d1, double d2)
    {
        fontFamilyStack = new Stack();
        clearedText = new StringBuffer();
        attributes = new Vector();
        superscriptCorrection = d2;
        parse(tagstring);
        for(; tags.size() > 0; closeTag((String)tags.keys().nextElement()));
        AttributedString attributedstring = new AttributedString(clearedText.toString(), FontUtilities.getAttributes(graphics.getFont()));
        for(int i = 0; i < attributes.size(); i++)
            ((AttributeEntry)attributes.elementAt(i)).apply(attributedstring);

        graphics.drawString(attributedstring.getIterator(), (float)d, (float)d1);
    }

    public TextLayout createTextLayout(TagString tagstring, double d)
    {
        fontFamilyStack = new Stack();
        clearedText = new StringBuffer();
        attributes = new Vector();
        superscriptCorrection = d;
        parse(tagstring);
        for(; tags.size() > 0; closeTag((String)tags.keys().nextElement()));
        AttributedString attributedstring = new AttributedString(clearedText.toString(), FontUtilities.getAttributes(graphics.getFont()));
        for(int i = 0; i < attributes.size(); i++)
            ((AttributeEntry)attributes.elementAt(i)).apply(attributedstring);

        return new TextLayout(attributedstring.getIterator(), graphics.getFontRenderContext());
    }

    protected String openTag(String s)
    {
        if(!tags.containsKey(s))
            tags.put(s, new Integer(clearedText.length()));
        return "";
    }

    protected String closeTag(String s)
    {
        if(!tags.containsKey(s))
            return super.closeTag(s);
        int i = ((Integer)tags.get(s)).intValue();
        tags.remove(s);
        if(s.equalsIgnoreCase("b"))
            attributes.add(new AttributeEntry(i, clearedText.length(), TextAttribute.WEIGHT, TextAttribute.WEIGHT_BOLD));
        else
        if(s.equalsIgnoreCase("i"))
            attributes.add(new AttributeEntry(i, clearedText.length(), TextAttribute.POSTURE, TextAttribute.POSTURE_OBLIQUE));
        else
        if(s.equalsIgnoreCase("s") || s.equalsIgnoreCase("strike"))
            attributes.add(new AttributeEntry(i, clearedText.length(), TextAttribute.STRIKETHROUGH, TextAttribute.STRIKETHROUGH_ON));
        else
        if(s.equalsIgnoreCase("udash"))
            attributes.add(new AttributeEntry(i, clearedText.length(), TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_LOW_DASHED));
        else
        if(s.equalsIgnoreCase("udot"))
            attributes.add(new AttributeEntry(i, clearedText.length(), TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_LOW_DOTTED));
        else
        if(s.equalsIgnoreCase("u"))
            attributes.add(new AttributeEntry(i, clearedText.length(), TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON));
        else
        if(s.equalsIgnoreCase("tt"))
            attributes.add(new AttributeEntry(i, clearedText.length(), TextAttribute.FAMILY, fontFamilyStack.pop()));
        else
        if(!s.equalsIgnoreCase("v"))
            if(s.equalsIgnoreCase("over"))
                attributes.add(new AttributeEntry(i, clearedText.length(), TextAttribute.UNDERLINE, UNDERLINE_OVERLINE));
            else
            if(s.equalsIgnoreCase("sup"))
            {
                attributes.add(new AttributeEntry(i, clearedText.length(), TextAttribute.TRANSFORM, AffineTransform.getTranslateInstance(0.0D, superscriptCorrection)));
                attributes.add(new AttributeEntry(i, clearedText.length(), TextAttribute.SUPERSCRIPT, TextAttribute.SUPERSCRIPT_SUPER));
            } else
            if(s.equalsIgnoreCase("sub"))
            {
                attributes.add(new AttributeEntry(i, clearedText.length(), TextAttribute.TRANSFORM, AffineTransform.getTranslateInstance(0.0D, -superscriptCorrection)));
                attributes.add(new AttributeEntry(i, clearedText.length(), TextAttribute.SUPERSCRIPT, TextAttribute.SUPERSCRIPT_SUB));
            } else
            {
                return super.closeTag(s);
            }
        return "";
    }

    protected String text(String s)
    {
        clearedText.append(s);
        return s;
    }

    public static Integer UNDERLINE_OVERLINE = new Integer(128);
    private Graphics2D graphics;
    private StringBuffer clearedText;
    private Vector attributes;
    private Hashtable tags;
    private Stack fontFamilyStack;
    private double superscriptCorrection;

}
