// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.bridge;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.geom.AffineTransform;
import java.awt.geom.Dimension2D;
import org.apache.batik.gvt.event.EventDispatcher;
import org.apache.batik.gvt.text.Mark;
import org.apache.batik.util.ParsedURL;
import org.w3c.dom.Element;
import org.w3c.dom.svg.SVGAElement;

// Referenced classes of package org.apache.batik.bridge:
//            BridgeExtension, ScriptSecurity, ExternalResourceSecurity

public interface UserAgent
{

    public abstract EventDispatcher getEventDispatcher();

    public abstract Dimension2D getViewportSize();

    public abstract void displayError(Exception exception);

    public abstract void displayMessage(String s);

    public abstract void showAlert(String s);

    public abstract String showPrompt(String s);

    public abstract String showPrompt(String s, String s1);

    public abstract boolean showConfirm(String s);

    public abstract float getPixelUnitToMillimeter();

    public abstract float getPixelToMM();

    public abstract float getMediumFontSize();

    public abstract float getLighterFontWeight(float f);

    public abstract float getBolderFontWeight(float f);

    public abstract String getDefaultFontFamily();

    public abstract String getLanguages();

    public abstract String getUserStyleSheetURI();

    public abstract void openLink(SVGAElement svgaelement);

    public abstract void setSVGCursor(Cursor cursor);

    public abstract void setTextSelection(Mark mark, Mark mark1);

    public abstract void deselectAll();

    public abstract String getXMLParserClassName();

    public abstract boolean isXMLParserValidating();

    public abstract AffineTransform getTransform();

    public abstract void setTransform(AffineTransform affinetransform);

    public abstract String getMedia();

    public abstract String getAlternateStyleSheet();

    public abstract Point getClientAreaLocationOnScreen();

    public abstract boolean hasFeature(String s);

    public abstract boolean supportExtension(String s);

    public abstract void registerExtension(BridgeExtension bridgeextension);

    public abstract void handleElement(Element element, Object obj);

    public abstract ScriptSecurity getScriptSecurity(String s, ParsedURL parsedurl, ParsedURL parsedurl1);

    public abstract void checkLoadScript(String s, ParsedURL parsedurl, ParsedURL parsedurl1)
        throws SecurityException;

    public abstract ExternalResourceSecurity getExternalResourceSecurity(ParsedURL parsedurl, ParsedURL parsedurl1);

    public abstract void checkLoadExternalResource(ParsedURL parsedurl, ParsedURL parsedurl1)
        throws SecurityException;
}
