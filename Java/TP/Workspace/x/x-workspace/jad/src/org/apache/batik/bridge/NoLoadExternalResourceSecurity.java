// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.bridge;


// Referenced classes of package org.apache.batik.bridge:
//            ExternalResourceSecurity, Messages

public class NoLoadExternalResourceSecurity
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

    public NoLoadExternalResourceSecurity()
    {
        se = new SecurityException(Messages.formatMessage("NoLoadExternalResourceSecurity.error.no.external.resource.allowed", null));
    }

    public static final String ERROR_NO_EXTERNAL_RESOURCE_ALLOWED = "NoLoadExternalResourceSecurity.error.no.external.resource.allowed";
    protected SecurityException se;
}
