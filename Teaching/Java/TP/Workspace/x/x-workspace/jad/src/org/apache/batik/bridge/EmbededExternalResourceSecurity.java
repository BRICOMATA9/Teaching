// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.bridge;

import org.apache.batik.util.ParsedURL;

// Referenced classes of package org.apache.batik.bridge:
//            ExternalResourceSecurity, Messages

public class EmbededExternalResourceSecurity
    implements ExternalResourceSecurity
{

    public void checkLoadExternalResource()
    {
        if(se != null)
            throw se;
        else
            return;
    }

    public EmbededExternalResourceSecurity(ParsedURL parsedurl)
    {
        if(parsedurl == null || !"data".equals(parsedurl.getProtocol()))
            se = new SecurityException(Messages.formatMessage("EmbededExternalResourceSecurity.error.external.esource.not.embeded", new Object[] {
                parsedurl
            }));
    }

    public static final String DATA_PROTOCOL = "data";
    public static final String ERROR_EXTERNAL_RESOURCE_NOT_EMBEDED = "EmbededExternalResourceSecurity.error.external.esource.not.embeded";
    protected SecurityException se;
}
