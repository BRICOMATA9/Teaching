// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.bridge;

import java.awt.color.ICC_Profile;
import java.io.IOException;
import org.apache.batik.dom.svg.SVGOMDocument;
import org.apache.batik.dom.util.XLinkSupport;
import org.apache.batik.ext.awt.color.ICCColorSpaceExt;
import org.apache.batik.ext.awt.color.NamedProfileCache;
import org.apache.batik.util.ParsedURL;
import org.w3c.dom.*;

// Referenced classes of package org.apache.batik.bridge:
//            AbstractSVGBridge, ErrorConstants, BridgeException, BridgeContext, 
//            UserAgent

public class SVGColorProfileElementBridge extends AbstractSVGBridge
    implements ErrorConstants
{

    public SVGColorProfileElementBridge()
    {
        cache = new NamedProfileCache();
    }

    public String getLocalName()
    {
        return "color-profile";
    }

    public ICCColorSpaceExt createICCColorSpaceExt(BridgeContext bridgecontext, Element element, String s)
    {
        ICCColorSpaceExt icccolorspaceext = cache.request(s.toLowerCase());
        if(icccolorspaceext != null)
            return icccolorspaceext;
        Document document = element.getOwnerDocument();
        NodeList nodelist = document.getElementsByTagNameNS("http://www.w3.org/2000/svg", "color-profile");
        int i = nodelist.getLength();
        Element element1 = null;
        for(int j = 0; j < i; j++)
        {
            Node node = nodelist.item(j);
            if(node.getNodeType() != 1)
                continue;
            Element element2 = (Element)node;
            String s3 = element2.getAttributeNS(null, "name");
            if(s.equalsIgnoreCase(s3))
                element1 = element2;
        }

        if(element1 == null)
            return null;
        String s1 = XLinkSupport.getXLinkHref(element1);
        ICC_Profile icc_profile = null;
        if(s1 != null)
        {
            String s2 = ((SVGOMDocument)document).getURL();
            ParsedURL parsedurl = new ParsedURL(s2, s1);
            if(!parsedurl.complete())
                throw new BridgeException(element, "uri.malformed", new Object[] {
                    s1
                });
            try
            {
                ParsedURL parsedurl1 = null;
                if(s2 != null)
                    parsedurl1 = new ParsedURL(s2);
                bridgecontext.getUserAgent().checkLoadExternalResource(parsedurl, parsedurl1);
                icc_profile = ICC_Profile.getInstance(parsedurl.openStream());
            }
            catch(IOException ioexception)
            {
                throw new BridgeException(element, "uri.io", new Object[] {
                    s1
                });
            }
            catch(SecurityException securityexception)
            {
                throw new BridgeException(element, "uri.unsecure", new Object[] {
                    s1
                });
            }
        }
        if(icc_profile == null)
        {
            return null;
        } else
        {
            int k = convertIntent(element1);
            ICCColorSpaceExt icccolorspaceext1 = new ICCColorSpaceExt(icc_profile, k);
            cache.put(s.toLowerCase(), icccolorspaceext1);
            return icccolorspaceext1;
        }
    }

    private static int convertIntent(Element element)
    {
        String s = element.getAttributeNS(null, "rendering-intent");
        if(s.length() == 0)
            return 4;
        if("perceptual".equals(s))
            return 0;
        if("auto".equals(s))
            return 4;
        if("relative-colorimetric".equals(s))
            return 1;
        if("absolute-colorimetric".equals(s))
            return 2;
        if("saturation".equals(s))
            return 3;
        else
            throw new BridgeException(element, "attribute.malformed", new Object[] {
                "rendering-intent", s
            });
    }

    public NamedProfileCache cache;
}
