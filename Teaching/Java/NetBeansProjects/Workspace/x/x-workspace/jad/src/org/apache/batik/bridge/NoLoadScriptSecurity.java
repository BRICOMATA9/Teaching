// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.bridge;


// Referenced classes of package org.apache.batik.bridge:
//            ScriptSecurity, Messages

public class NoLoadScriptSecurity
    implements ScriptSecurity
{

    public void checkLoadScript()
    {
        throw se;
    }

    public NoLoadScriptSecurity(String s)
    {
        se = new SecurityException(Messages.formatMessage("NoLoadScriptSecurity.error.no.script.of.type.allowed", new Object[] {
            s
        }));
    }

    public static final String ERROR_NO_SCRIPT_OF_TYPE_ALLOWED = "NoLoadScriptSecurity.error.no.script.of.type.allowed";
    protected SecurityException se;
}
