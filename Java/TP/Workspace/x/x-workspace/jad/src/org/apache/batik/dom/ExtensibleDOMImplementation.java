// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.dom;

import java.util.*;
import org.apache.batik.css.engine.CSSContext;
import org.apache.batik.css.engine.CSSEngine;
import org.apache.batik.css.engine.value.ShorthandManager;
import org.apache.batik.css.engine.value.ValueManager;
import org.apache.batik.css.parser.ExtendedParser;
import org.apache.batik.css.parser.ExtendedParserWrapper;
import org.apache.batik.dom.util.DOMUtilities;
import org.apache.batik.dom.util.DoublyIndexedTable;
import org.apache.batik.i18n.Localizable;
import org.apache.batik.i18n.LocalizableSupport;
import org.apache.batik.util.Service;
import org.apache.batik.util.XMLResourceDescriptor;
import org.w3c.css.sac.Parser;
import org.w3c.dom.*;
import org.w3c.dom.css.DOMImplementationCSS;
import org.w3c.dom.css.ViewCSS;

// Referenced classes of package org.apache.batik.dom:
//            AbstractDOMImplementation, StyleSheetFactory, DomExtension, AbstractStylableDocument, 
//            GenericElement, GenericElementNS, AbstractDocument

public abstract class ExtensibleDOMImplementation extends AbstractDOMImplementation
    implements DOMImplementationCSS, StyleSheetFactory, Localizable
{
    public static interface ElementFactory
    {

        public abstract Element create(String s, Document document);
    }


    public ExtensibleDOMImplementation()
    {
        initLocalizable();
        DomExtension domextension;
        for(Iterator iterator = getDomExtensions().iterator(); iterator.hasNext(); domextension.registerTags(this))
            domextension = (DomExtension)iterator.next();

    }

    public void setLocale(Locale locale)
    {
        localizableSupport.setLocale(locale);
    }

    public Locale getLocale()
    {
        return localizableSupport.getLocale();
    }

    protected void initLocalizable()
    {
        localizableSupport = new LocalizableSupport("org.apache.batik.dom.resources.Messages", getClass().getClassLoader());
    }

    public String formatMessage(String s, Object aobj[])
        throws MissingResourceException
    {
        return localizableSupport.formatMessage(s, aobj);
    }

    public void registerCustomElementFactory(String s, String s1, ElementFactory elementfactory)
    {
        if(customFactories == null)
            customFactories = new DoublyIndexedTable();
        customFactories.put(s, s1, elementfactory);
    }

    public void registerCustomCSSValueManager(ValueManager valuemanager)
    {
        if(customValueManagers == null)
            customValueManagers = new LinkedList();
        customValueManagers.add(valuemanager);
    }

    public void registerCustomCSSShorthandManager(ShorthandManager shorthandmanager)
    {
        if(customShorthandManagers == null)
            customShorthandManagers = new LinkedList();
        customShorthandManagers.add(shorthandmanager);
    }

    public CSSEngine createCSSEngine(AbstractStylableDocument abstractstylabledocument, CSSContext csscontext)
    {
        String s = XMLResourceDescriptor.getCSSParserClassName();
        Parser parser;
        try
        {
            parser = (Parser)Class.forName(s).newInstance();
        }
        catch(ClassNotFoundException classnotfoundexception)
        {
            throw new DOMException((short)15, formatMessage("css.parser.class", new Object[] {
                s
            }));
        }
        catch(InstantiationException instantiationexception)
        {
            throw new DOMException((short)15, formatMessage("css.parser.creation", new Object[] {
                s
            }));
        }
        catch(IllegalAccessException illegalaccessexception)
        {
            throw new DOMException((short)15, formatMessage("css.parser.access", new Object[] {
                s
            }));
        }
        ExtendedParser extendedparser = ExtendedParserWrapper.wrap(parser);
        ValueManager avaluemanager[];
        if(customValueManagers == null)
        {
            avaluemanager = new ValueManager[0];
        } else
        {
            avaluemanager = new ValueManager[customValueManagers.size()];
            Iterator iterator = customValueManagers.iterator();
            int i = 0;
            while(iterator.hasNext()) 
                avaluemanager[i++] = (ValueManager)iterator.next();
        }
        ShorthandManager ashorthandmanager[];
        if(customShorthandManagers == null)
        {
            ashorthandmanager = new ShorthandManager[0];
        } else
        {
            ashorthandmanager = new ShorthandManager[customShorthandManagers.size()];
            Iterator iterator1 = customShorthandManagers.iterator();
            int j = 0;
            while(iterator1.hasNext()) 
                ashorthandmanager[j++] = (ShorthandManager)iterator1.next();
        }
        CSSEngine cssengine = createCSSEngine(abstractstylabledocument, csscontext, extendedparser, avaluemanager, ashorthandmanager);
        abstractstylabledocument.setCSSEngine(cssengine);
        return cssengine;
    }

    public abstract CSSEngine createCSSEngine(AbstractStylableDocument abstractstylabledocument, CSSContext csscontext, ExtendedParser extendedparser, ValueManager avaluemanager[], ShorthandManager ashorthandmanager[]);

    public abstract ViewCSS createViewCSS(AbstractStylableDocument abstractstylabledocument);

    public Element createElementNS(AbstractDocument abstractdocument, String s, String s1)
    {
        if(s == null)
            return new GenericElement(s1.intern(), abstractdocument);
        if(customFactories != null)
        {
            String s2 = DOMUtilities.getLocalName(s1);
            ElementFactory elementfactory = (ElementFactory)customFactories.get(s, s2);
            if(elementfactory != null)
                return elementfactory.create(DOMUtilities.getPrefix(s1), abstractdocument);
        }
        return new GenericElementNS(s.intern(), s1.intern(), abstractdocument);
    }

    protected static synchronized List getDomExtensions()
    {
        if(extensions != null)
            return extensions;
        extensions = new LinkedList();
        Iterator iterator = Service.providers(org.apache.batik.dom.DomExtension.class);
label0:
        do
        {
            if(!iterator.hasNext())
                break;
            DomExtension domextension = (DomExtension)iterator.next();
            float f = domextension.getPriority();
            ListIterator listiterator = extensions.listIterator();
            DomExtension domextension1;
            do
            {
                if(!listiterator.hasNext())
                {
                    listiterator.add(domextension);
                    continue label0;
                }
                domextension1 = (DomExtension)listiterator.next();
            } while(domextension1.getPriority() <= f);
            listiterator.previous();
            listiterator.add(domextension);
        } while(true);
        return extensions;
    }

    protected DoublyIndexedTable customFactories;
    protected List customValueManagers;
    protected List customShorthandManagers;
    protected static final String RESOURCES = "org.apache.batik.dom.resources.Messages";
    protected LocalizableSupport localizableSupport;
    protected static List extensions = null;

}
