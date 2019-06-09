// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.svggen;

import java.util.*;
import org.apache.batik.ext.awt.g2d.GraphicContext;
import org.w3c.dom.*;

// Referenced classes of package org.apache.batik.svggen:
//            SVGSyntax, ErrorConstants, SVGGraphics2DRuntimeException, SVGGraphicContextConverter, 
//            DOMGroupManager, SVGGeneratorContext, SVGBufferedImageOp, SVGComposite, 
//            SVGAlphaComposite, SVGGraphicContext, StyleHandler, SVGIDGenerator, 
//            ExtensionHandler

public class DOMTreeManager
    implements SVGSyntax, ErrorConstants
{

    public DOMTreeManager(GraphicContext graphiccontext, SVGGeneratorContext svggeneratorcontext, int i)
    {
        groupManagers = new Vector();
        genericDefSet = new LinkedList();
        if(graphiccontext == null)
            throw new SVGGraphics2DRuntimeException("gc should not be null");
        if(i <= 0)
            throw new SVGGraphics2DRuntimeException("maxGcOverrides should be greater than zero");
        if(svggeneratorcontext == null)
        {
            throw new SVGGraphics2DRuntimeException("generatorContext should not be null");
        } else
        {
            generatorContext = svggeneratorcontext;
            maxGCOverrides = i;
            recycleTopLevelGroup();
            defaultGC = gcConverter.toSVG(graphiccontext);
            return;
        }
    }

    public void addGroupManager(DOMGroupManager domgroupmanager)
    {
        if(domgroupmanager != null)
            groupManagers.addElement(domgroupmanager);
    }

    public void removeGroupManager(DOMGroupManager domgroupmanager)
    {
        if(domgroupmanager != null)
            groupManagers.removeElement(domgroupmanager);
    }

    public void appendGroup(Element element, DOMGroupManager domgroupmanager)
    {
        topLevelGroup.appendChild(element);
        int i = groupManagers.size();
        for(int j = 0; j < i; j++)
        {
            DOMGroupManager domgroupmanager1 = (DOMGroupManager)groupManagers.elementAt(j);
            if(domgroupmanager1 != domgroupmanager)
                domgroupmanager1.recycleCurrentGroup();
        }

    }

    protected void recycleTopLevelGroup()
    {
        recycleTopLevelGroup(true);
    }

    protected void recycleTopLevelGroup(boolean flag)
    {
        int i = groupManagers.size();
        for(int j = 0; j < i; j++)
        {
            DOMGroupManager domgroupmanager = (DOMGroupManager)groupManagers.elementAt(j);
            domgroupmanager.recycleCurrentGroup();
        }

        topLevelGroup = generatorContext.domFactory.createElementNS("http://www.w3.org/2000/svg", "g");
        if(flag)
        {
            filterConverter = new SVGBufferedImageOp(generatorContext);
            gcConverter = new SVGGraphicContextConverter(generatorContext);
        }
    }

    public void setTopLevelGroup(Element element)
    {
        if(element == null)
            throw new SVGGraphics2DRuntimeException("topLevelGroup should not be null");
        if(!"g".equalsIgnoreCase(element.getTagName()))
        {
            throw new SVGGraphics2DRuntimeException("topLevelGroup should be a group <g>");
        } else
        {
            recycleTopLevelGroup(false);
            topLevelGroup = element;
            return;
        }
    }

    public Element getRoot()
    {
        return getRoot(null);
    }

    public Element getRoot(Element element)
    {
        Element element1 = element;
        if(element1 == null)
            element1 = generatorContext.domFactory.createElementNS("http://www.w3.org/2000/svg", "svg");
        if(gcConverter.getCompositeConverter().getAlphaCompositeConverter().requiresBackgroundAccess())
            element1.setAttributeNS(null, "enable-background", "new");
        if(generatorContext.generatorComment != null)
        {
            org.w3c.dom.Comment comment = generatorContext.domFactory.createComment(generatorContext.generatorComment);
            element1.appendChild(comment);
        }
        applyDefaultRenderingStyle(element1);
        element1.appendChild(getGenericDefinitions());
        element1.appendChild(getTopLevelGroup());
        return element1;
    }

    public void applyDefaultRenderingStyle(Element element)
    {
        java.util.Map map = defaultGC.getGroupContext();
        generatorContext.styleHandler.setStyle(element, map, generatorContext);
    }

    public Element getGenericDefinitions()
    {
        Element element = generatorContext.domFactory.createElementNS("http://www.w3.org/2000/svg", "defs");
        for(Iterator iterator = genericDefSet.iterator(); iterator.hasNext(); element.appendChild((Element)iterator.next()));
        element.setAttributeNS(null, "id", "genericDefs");
        return element;
    }

    public ExtensionHandler getExtensionHandler()
    {
        return generatorContext.getExtensionHandler();
    }

    void setExtensionHandler(ExtensionHandler extensionhandler)
    {
        generatorContext.setExtensionHandler(extensionhandler);
    }

    public List getDefinitionSet()
    {
        List list = gcConverter.getDefinitionSet();
        list.removeAll(genericDefSet);
        list.addAll(filterConverter.getDefinitionSet());
        if(otherDefs != null)
        {
            list.addAll(otherDefs);
            otherDefs = null;
        }
        filterConverter = new SVGBufferedImageOp(generatorContext);
        gcConverter = new SVGGraphicContextConverter(generatorContext);
        return list;
    }

    public void addOtherDef(Element element)
    {
        if(otherDefs == null)
            otherDefs = new LinkedList();
        otherDefs.add(element);
    }

    public Element getTopLevelGroup()
    {
        boolean flag = true;
        return getTopLevelGroup(flag);
    }

    public Element getTopLevelGroup(boolean flag)
    {
        Element element = topLevelGroup;
        if(flag)
        {
            List list = getDefinitionSet();
            if(list.size() > 0)
            {
                Element element1 = null;
                NodeList nodelist = element.getElementsByTagName("defs");
                if(nodelist.getLength() > 0)
                    element1 = (Element)nodelist.item(0);
                if(element1 == null)
                {
                    element1 = generatorContext.domFactory.createElementNS("http://www.w3.org/2000/svg", "defs");
                    element1.setAttributeNS(null, "id", generatorContext.idGenerator.generateID("defs"));
                    element.insertBefore(element1, element.getFirstChild());
                }
                for(Iterator iterator = list.iterator(); iterator.hasNext(); element1.appendChild((Element)iterator.next()));
            }
        }
        recycleTopLevelGroup(false);
        return element;
    }

    public SVGBufferedImageOp getFilterConverter()
    {
        return filterConverter;
    }

    public SVGGraphicContextConverter getGraphicContextConverter()
    {
        return gcConverter;
    }

    SVGGeneratorContext getGeneratorContext()
    {
        return generatorContext;
    }

    Document getDOMFactory()
    {
        return generatorContext.domFactory;
    }

    StyleHandler getStyleHandler()
    {
        return generatorContext.styleHandler;
    }

    int maxGCOverrides;
    protected Vector groupManagers;
    protected List genericDefSet;
    SVGGraphicContext defaultGC;
    protected Element topLevelGroup;
    SVGGraphicContextConverter gcConverter;
    protected SVGGeneratorContext generatorContext;
    protected SVGBufferedImageOp filterConverter;
    protected List otherDefs;
}
