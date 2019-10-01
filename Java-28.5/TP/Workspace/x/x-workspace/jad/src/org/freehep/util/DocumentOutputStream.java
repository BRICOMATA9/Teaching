// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.freehep.util;

import java.io.IOException;
import java.io.OutputStream;
import javax.swing.text.*;

public class DocumentOutputStream extends OutputStream
{

    public DocumentOutputStream(Document document, AttributeSet attributeset)
    {
        one = new byte[1];
        doc = document;
        a = attributeset;
    }

    public DocumentOutputStream(Document document)
    {
        this(document, null);
    }

    public void write(int i)
        throws IOException
    {
        one[0] = (byte)i;
        write(one, 0, 1);
    }

    public void write(byte abyte0[], int i, int j)
        throws IOException
    {
        try
        {
            doc.insertString(doc.getLength(), new String(abyte0, i, j), a);
        }
        catch(BadLocationException badlocationexception)
        {
            throw new IOException(badlocationexception.getMessage());
        }
    }

    private byte one[];
    private Document doc;
    private AttributeSet a;
}
