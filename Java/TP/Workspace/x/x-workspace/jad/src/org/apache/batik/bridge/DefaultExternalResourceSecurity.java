// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.bridge;

import org.apache.batik.util.ParsedURL;

// Referenced classes of package org.apache.batik.bridge:
//            ExternalResourceSecurity, Messages

public class DefaultExternalResourceSecurity
    implements ExternalResourceSecurity
{

    public void checkLoadExternalResource()
    {
        if(se != null)
        {
            se.fillInStackTrace();
            throw se;
        } else
        {
            return;
        }
    }

    public DefaultExternalResourceSecurity(ParsedURL parsedurl, ParsedURL parsedurl1)
    {
        if(parsedurl1 == null)
        {
            se = new SecurityException(Messages.formatMessage("DefaultExternalResourceSecurity.error.cannot.access.document.url", new Object[] {
                parsedurl
            }));
        } else
        {
            String s = parsedurl1.getHost();
            String s1 = parsedurl.getHost();
            if(s != s1 && (s == null || !s.equals(s1)) && (parsedurl == null || !"data".equals(parsedurl.getProtocol())))
                se = new SecurityException(Messages.formatMessage("DefaultExternalResourceSecurity.error.external.resource.from.different.url", new Object[] {
                    parsedurl
                }));
        }
    }

    public static final String DATA_PROTOCOL = "data";
    public static final String ERROR_CANNOT_ACCESS_DOCUMENT_URL = "DefaultExternalResourceSecurity.error.cannot.access.document.url";
    public static final String ERROR_EXTERNAL_RESOURCE_FROM_DIFFERENT_URL = "DefaultExternalResourceSecurity.error.external.resource.from.different.url";
    protected SecurityException se;
}
