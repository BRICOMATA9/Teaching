// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.bridge;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Dimension2D;
import java.util.*;
import org.apache.batik.gvt.event.EventDispatcher;
import org.apache.batik.gvt.text.Mark;
import org.apache.batik.util.ParsedURL;
import org.apache.batik.util.XMLResourceDescriptor;
import org.w3c.dom.Element;
import org.w3c.dom.svg.SVGAElement;

// Referenced classes of package org.apache.batik.bridge:
//            UserAgent, BridgeExtension, DefaultScriptSecurity, ScriptSecurity, 
//            RelaxedExternalResourceSecurity, ExternalResourceSecurity

public class UserAgentAdapter
    implements UserAgent
{

    public UserAgentAdapter()
    {
        FEATURES = new HashSet();
        extensions = new HashSet();
    }

    public void addStdFeatures()
    {
        FEATURES.add("org.w3c.svg");
        FEATURES.add("org.w3c.svg.lang");
        FEATURES.add("org.w3c.svg.static");
    }

    public Dimension2D getViewportSize()
    {
        return new Dimension(1, 1);
    }

    public void displayMessage(String s)
    {
    }

    public void displayError(String s)
    {
        displayMessage(s);
    }

    public void displayError(Exception exception)
    {
        displayError(exception.getMessage());
    }

    public void showAlert(String s)
    {
    }

    public String showPrompt(String s)
    {
        return null;
    }

    public String showPrompt(String s, String s1)
    {
        return null;
    }

    public boolean showConfirm(String s)
    {
        return false;
    }

    public float getPixelUnitToMillimeter()
    {
        return 0.2645833F;
    }

    public float getPixelToMM()
    {
        return getPixelUnitToMillimeter();
    }

    public String getDefaultFontFamily()
    {
        return "Arial, Helvetica, sans-serif";
    }

    public float getMediumFontSize()
    {
        return 228.6F / (72F * getPixelUnitToMillimeter());
    }

    public float getLighterFontWeight(float f)
    {
        return getStandardLighterFontWeight(f);
    }

    public float getBolderFontWeight(float f)
    {
        return getStandardBolderFontWeight(f);
    }

    public String getLanguages()
    {
        return "en";
    }

    public String getMedia()
    {
        return "all";
    }

    public String getAlternateStyleSheet()
    {
        return null;
    }

    public String getUserStyleSheetURI()
    {
        return null;
    }

    public String getXMLParserClassName()
    {
        return XMLResourceDescriptor.getXMLParserClassName();
    }

    public boolean isXMLParserValidating()
    {
        return false;
    }

    public EventDispatcher getEventDispatcher()
    {
        return null;
    }

    public void openLink(SVGAElement svgaelement)
    {
    }

    public void setSVGCursor(Cursor cursor)
    {
    }

    public void setTextSelection(Mark mark, Mark mark1)
    {
    }

    public void deselectAll()
    {
    }

    public void runThread(Thread thread)
    {
    }

    public AffineTransform getTransform()
    {
        return null;
    }

    public void setTransform(AffineTransform affinetransform)
    {
    }

    public Point getClientAreaLocationOnScreen()
    {
        return new Point();
    }

    public boolean hasFeature(String s)
    {
        return FEATURES.contains(s);
    }

    public boolean supportExtension(String s)
    {
        return extensions.contains(s);
    }

    public void registerExtension(BridgeExtension bridgeextension)
    {
        for(Iterator iterator = bridgeextension.getImplementedExtensions(); iterator.hasNext(); extensions.add(iterator.next()));
    }

    public void handleElement(Element element, Object obj)
    {
    }

    public ScriptSecurity getScriptSecurity(String s, ParsedURL parsedurl, ParsedURL parsedurl1)
    {
        return new DefaultScriptSecurity(s, parsedurl, parsedurl1);
    }

    public void checkLoadScript(String s, ParsedURL parsedurl, ParsedURL parsedurl1)
        throws SecurityException
    {
        ScriptSecurity scriptsecurity = getScriptSecurity(s, parsedurl, parsedurl1);
        if(scriptsecurity != null)
            scriptsecurity.checkLoadScript();
    }

    public ExternalResourceSecurity getExternalResourceSecurity(ParsedURL parsedurl, ParsedURL parsedurl1)
    {
        return new RelaxedExternalResourceSecurity(parsedurl, parsedurl1);
    }

    public void checkLoadExternalResource(ParsedURL parsedurl, ParsedURL parsedurl1)
        throws SecurityException
    {
        ExternalResourceSecurity externalresourcesecurity = getExternalResourceSecurity(parsedurl, parsedurl1);
        if(externalresourcesecurity != null)
            externalresourcesecurity.checkLoadExternalResource();
    }

    public static float getStandardLighterFontWeight(float f)
    {
        int i = (int)((f + 50F) / 100F) * 100;
        switch(i)
        {
        case 100: // 'd'
            return 100F;

        case 200: 
            return 100F;

        case 300: 
            return 200F;

        case 400: 
            return 300F;

        case 500: 
            return 400F;

        case 600: 
            return 400F;

        case 700: 
            return 400F;

        case 800: 
            return 400F;

        case 900: 
            return 400F;
        }
        throw new IllegalArgumentException("Bad Font Weight: " + f);
    }

    public static float getStandardBolderFontWeight(float f)
    {
        int i = (int)((f + 50F) / 100F) * 100;
        switch(i)
        {
        case 100: // 'd'
            return 600F;

        case 200: 
            return 600F;

        case 300: 
            return 600F;

        case 400: 
            return 600F;

        case 500: 
            return 600F;

        case 600: 
            return 700F;

        case 700: 
            return 800F;

        case 800: 
            return 900F;

        case 900: 
            return 900F;
        }
        throw new IllegalArgumentException("Bad Font Weight: " + f);
    }

    protected Set FEATURES;
    protected Set extensions;
}
