// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.w3c.css.sac;

import java.io.InputStream;
import java.io.Reader;

public class InputSource
{

    public InputSource()
    {
    }

    public InputSource(String s)
    {
        setURI(s);
    }

    public InputSource(Reader reader)
    {
        setCharacterStream(reader);
    }

    public void setURI(String s)
    {
        uri = s;
    }

    public String getURI()
    {
        return uri;
    }

    public void setByteStream(InputStream inputstream)
    {
        byteStream = inputstream;
    }

    public InputStream getByteStream()
    {
        return byteStream;
    }

    public void setEncoding(String s)
    {
        encoding = s;
    }

    public String getEncoding()
    {
        return encoding;
    }

    public void setCharacterStream(Reader reader)
    {
        characterStream = reader;
    }

    public Reader getCharacterStream()
    {
        return characterStream;
    }

    public void setTitle(String s)
    {
        title = s;
    }

    public String getTitle()
    {
        return title;
    }

    public void setMedia(String s)
    {
        media = s;
    }

    public String getMedia()
    {
        if(media == null)
            return "all";
        else
            return media;
    }

    private String uri;
    private InputStream byteStream;
    private String encoding;
    private Reader characterStream;
    private String title;
    private String media;
}
