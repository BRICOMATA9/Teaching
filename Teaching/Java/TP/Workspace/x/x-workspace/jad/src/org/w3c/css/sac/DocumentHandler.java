// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.w3c.css.sac;


// Referenced classes of package org.w3c.css.sac:
//            CSSException, InputSource, SACMediaList, SelectorList, 
//            LexicalUnit

public interface DocumentHandler
{

    public abstract void startDocument(InputSource inputsource)
        throws CSSException;

    public abstract void endDocument(InputSource inputsource)
        throws CSSException;

    public abstract void comment(String s)
        throws CSSException;

    public abstract void ignorableAtRule(String s)
        throws CSSException;

    public abstract void namespaceDeclaration(String s, String s1)
        throws CSSException;

    public abstract void importStyle(String s, SACMediaList sacmedialist, String s1)
        throws CSSException;

    public abstract void startMedia(SACMediaList sacmedialist)
        throws CSSException;

    public abstract void endMedia(SACMediaList sacmedialist)
        throws CSSException;

    public abstract void startPage(String s, String s1)
        throws CSSException;

    public abstract void endPage(String s, String s1)
        throws CSSException;

    public abstract void startFontFace()
        throws CSSException;

    public abstract void endFontFace()
        throws CSSException;

    public abstract void startSelector(SelectorList selectorlist)
        throws CSSException;

    public abstract void endSelector(SelectorList selectorlist)
        throws CSSException;

    public abstract void property(String s, LexicalUnit lexicalunit, boolean flag)
        throws CSSException;
}
