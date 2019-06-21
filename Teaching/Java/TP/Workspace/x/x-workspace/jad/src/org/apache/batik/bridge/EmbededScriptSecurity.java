// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.bridge;

import org.apache.batik.util.ParsedURL;

// Referenced classes of package org.apache.batik.bridge:
//            ScriptSecurity, Messages

public class EmbededScriptSecurity
    implements ScriptSecurity
{

    public void checkLoadScript()
    {
        if(se != null)
            throw se;
        else
            return;
    }

    public EmbededScriptSecurity(String s, ParsedURL parsedurl, ParsedURL parsedurl1)
    {
        if(parsedurl1 == null)
            se = new SecurityException(Messages.formatMessage("DefaultScriptSecurity.error.cannot.access.document.url", new Object[] {
                parsedurl
            }));
        else
        if(!parsedurl1.equals(parsedurl) && (parsedurl == null || !"data".equals(parsedurl.getProtocol())))
            se = new SecurityException(Messages.formatMessage("EmbededScriptSecurity.error.script.not.embeded", new Object[] {
                parsedurl
            }));
    }

    public static final String DATA_PROTOCOL = "data";
    public static final String ERROR_CANNOT_ACCESS_DOCUMENT_URL = "DefaultScriptSecurity.error.cannot.access.document.url";
    public static final String ERROR_SCRIPT_NOT_EMBEDED = "EmbededScriptSecurity.error.script.not.embeded";
    protected SecurityException se;
}
