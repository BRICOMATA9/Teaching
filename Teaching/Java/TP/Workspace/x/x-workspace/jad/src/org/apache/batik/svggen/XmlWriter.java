// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.svggen;

import java.io.*;
import org.apache.batik.util.SVGConstants;
import org.w3c.dom.*;

// Referenced classes of package org.apache.batik.svggen:
//            SVGGraphics2DIOException, SVGGraphics2DRuntimeException

class XmlWriter
    implements SVGConstants
{
    static class IndentWriter extends Writer
    {

        public void setIndentLevel(int i)
        {
            indentLevel = i;
        }

        public int getIndentLevel()
        {
            return indentLevel;
        }

        public void printIndent()
            throws IOException
        {
label0:
            {
                proxied.write(XmlWriter.EOL);
                int i = indentLevel;
                do
                {
                    if(i <= 0)
                        break label0;
                    if(i <= XmlWriter.SPACES_LEN)
                        break;
                    proxied.write(XmlWriter.SPACES, 0, XmlWriter.SPACES_LEN);
                    i -= XmlWriter.SPACES_LEN;
                } while(true);
                proxied.write(XmlWriter.SPACES, 0, i);
            }
            column = indentLevel;
        }

        public Writer getProxied()
        {
            return proxied;
        }

        public int getColumn()
        {
            return column;
        }

        public void write(int i)
            throws IOException
        {
            column++;
            proxied.write(i);
        }

        public void write(char ac[])
            throws IOException
        {
            column += ac.length;
            proxied.write(ac);
        }

        public void write(char ac[], int i, int j)
            throws IOException
        {
            column += j;
            proxied.write(ac, i, j);
        }

        public void write(String s)
            throws IOException
        {
            column += s.length();
            proxied.write(s);
        }

        public void write(String s, int i, int j)
            throws IOException
        {
            column += j;
            proxied.write(s, i, j);
        }

        public void flush()
            throws IOException
        {
            proxied.flush();
        }

        public void close()
            throws IOException
        {
            column = -1;
            proxied.close();
        }

        protected Writer proxied;
        protected int indentLevel;
        protected int column;

        public IndentWriter(Writer writer)
        {
            if(writer == null)
            {
                throw new SVGGraphics2DRuntimeException("proxy should not be null");
            } else
            {
                proxied = writer;
                return;
            }
        }
    }


    XmlWriter()
    {
    }

    private static void writeXml(Attr attr, IndentWriter indentwriter)
        throws IOException
    {
        String s = attr.getName();
        indentwriter.write(s);
        indentwriter.write("=\"");
        writeChildrenXml(attr, indentwriter);
        indentwriter.write(34);
    }

    private static void writeChildrenXml(Attr attr, IndentWriter indentwriter)
        throws IOException
    {
        char ac[] = attr.getValue().toCharArray();
        if(ac == null)
            return;
        int i = ac.length;
        int j = 0;
        int k;
        for(k = 0; k < i; k++)
        {
            char c = ac[k];
            switch(c)
            {
            case 60: // '<'
                indentwriter.write(ac, j, k - j);
                j = k + 1;
                indentwriter.write("&lt;");
                break;

            case 62: // '>'
                indentwriter.write(ac, j, k - j);
                j = k + 1;
                indentwriter.write("&gt;");
                break;

            case 38: // '&'
                indentwriter.write(ac, j, k - j);
                j = k + 1;
                indentwriter.write("&amp;");
                break;

            case 39: // '\''
                indentwriter.write(ac, j, k - j);
                j = k + 1;
                indentwriter.write("&apos;");
                break;

            case 34: // '"'
                indentwriter.write(ac, j, k - j);
                j = k + 1;
                indentwriter.write("&quot;");
                break;
            }
        }

        indentwriter.write(ac, j, k - j);
    }

    private static void writeXml(Comment comment, IndentWriter indentwriter)
        throws IOException
    {
        char ac[] = comment.getData().toCharArray();
        if(ac == null)
        {
            indentwriter.write("<!---->");
            return;
        }
        indentwriter.write("<!--");
        boolean flag = false;
        int i = ac.length;
        int j = 0;
        int k;
        for(k = 0; k < i; k++)
        {
            char c = ac[k];
            if(c == '-')
            {
                if(flag)
                {
                    indentwriter.write(ac, j, k - j);
                    j = k;
                    indentwriter.write(32);
                }
                flag = true;
            } else
            {
                flag = false;
            }
        }

        indentwriter.write(ac, j, k - j);
        if(flag)
            indentwriter.write(32);
        indentwriter.write("-->");
    }

    private static void writeXml(Text text, IndentWriter indentwriter)
        throws IOException
    {
        writeXml(text, indentwriter, false);
    }

    private static void writeXml(Text text, IndentWriter indentwriter, boolean flag)
        throws IOException
    {
        char ac[] = text.getData().toCharArray();
        if(ac == null)
        {
            System.err.println("Null text data??");
            return;
        }
        int i = ac.length;
        int j = 0;
        int k = 0;
        if(flag)
        {
label0:
            do
            {
                if(k >= i)
                    break;
                char c = ac[k];
                switch(c)
                {
                default:
                    break label0;

                case 9: // '\t'
                case 10: // '\n'
                case 13: // '\r'
                case 32: // ' '
                    k++;
                    break;
                }
            } while(true);
            j = k;
        }
        do
        {
            if(k >= i)
                break;
            char c1 = ac[k];
            switch(c1)
            {
            default:
                break;

            case 9: // '\t'
            case 10: // '\n'
            case 13: // '\r'
            case 32: // ' '
                if(!flag)
                    break;
                int l = k;
                k++;
label1:
                do
                {
                    if(k >= i)
                        break;
                    switch(ac[k])
                    {
                    default:
                        break label1;

                    case 9: // '\t'
                    case 10: // '\n'
                    case 13: // '\r'
                    case 32: // ' '
                        k++;
                        break;
                    }
                } while(true);
                if(k == i)
                {
                    indentwriter.write(ac, j, l - j);
                    return;
                }
                continue;

            case 60: // '<'
                indentwriter.write(ac, j, k - j);
                j = k + 1;
                indentwriter.write("&lt;");
                break;

            case 62: // '>'
                indentwriter.write(ac, j, k - j);
                j = k + 1;
                indentwriter.write("&gt;");
                break;

            case 38: // '&'
                indentwriter.write(ac, j, k - j);
                j = k + 1;
                indentwriter.write("&amp;");
                break;
            }
            k++;
        } while(true);
        indentwriter.write(ac, j, k - j);
    }

    private static void writeXml(CDATASection cdatasection, IndentWriter indentwriter)
        throws IOException
    {
        char ac[] = cdatasection.getData().toCharArray();
        if(ac == null)
        {
            indentwriter.write("<![CDATA[]]>");
            return;
        }
        indentwriter.write("<![CDATA[");
        int i = ac.length;
        int j = 0;
        int k;
        for(k = 0; k < i;)
        {
            char c = ac[k];
            if(c == ']' && k + 2 < ac.length && ac[k + 1] == ']' && ac[k + 2] == '>')
            {
                indentwriter.write(ac, j, k - j);
                j = k + 1;
                indentwriter.write("]]]]><![CDATA[>");
            } else
            {
                k++;
            }
        }

        indentwriter.write(ac, j, k - j);
        indentwriter.write("]]>");
    }

    private static void writeXml(Element element, IndentWriter indentwriter)
        throws IOException, SVGGraphics2DIOException
    {
        indentwriter.write("</", 0, 1);
        indentwriter.write(element.getTagName());
        NamedNodeMap namednodemap = element.getAttributes();
        if(namednodemap != null)
        {
            int i = namednodemap.getLength();
            for(int j = 0; j < i; j++)
            {
                Attr attr = (Attr)namednodemap.item(j);
                indentwriter.write(32);
                writeXml(attr, indentwriter);
            }

        }
        if(!element.hasChildNodes())
        {
            indentwriter.write(" />", 0, 3);
        } else
        {
            indentwriter.write(" />", 2, 1);
            writeChildrenXml(element, indentwriter);
            indentwriter.write("</", 0, 2);
            indentwriter.write(element.getTagName());
            indentwriter.write(" />", 2, 1);
        }
    }

    private static void writeChildrenXml(Element element, IndentWriter indentwriter)
        throws IOException, SVGGraphics2DIOException
    {
        NodeList nodelist = element.getChildNodes();
        if(nodelist == null)
            return;
        int i = nodelist.getLength();
        int j = 0;
        j = indentwriter.getIndentLevel();
        try
        {
            indentwriter.setIndentLevel(j + 2);
            for(int k = 0; k < i; k++)
            {
                if(nodelist.item(k).getNodeType() != 3)
                    indentwriter.printIndent();
                writeXml(nodelist.item(k), indentwriter);
            }

        }
        finally
        {
            indentwriter.setIndentLevel(j);
            if(i > 0 && nodelist.item(i - 1).getNodeType() != 3)
                indentwriter.printIndent();
        }
    }

    private static void writeDocumentHeader(IndentWriter indentwriter)
        throws IOException
    {
        String s = null;
        if(indentwriter.getProxied() instanceof OutputStreamWriter)
            s = java2std(((OutputStreamWriter)indentwriter.getProxied()).getEncoding());
        indentwriter.write("<?xml version=\"1.0\"");
        if(s != null)
        {
            indentwriter.write(" encoding=\"");
            indentwriter.write(s);
            indentwriter.write(34);
        }
        indentwriter.write("?>");
        indentwriter.write(EOL);
        indentwriter.write(EOL);
        indentwriter.write("<!DOCTYPE svg PUBLIC '");
        indentwriter.write("-//W3C//DTD SVG 1.0//EN");
        indentwriter.write("' '");
        indentwriter.write("http://www.w3.org/TR/2001/REC-SVG-20010904/DTD/svg10.dtd");
        indentwriter.write("'");
        indentwriter.write(">");
        indentwriter.write(EOL);
    }

    private static void writeXml(Document document, IndentWriter indentwriter)
        throws IOException, SVGGraphics2DIOException
    {
        writeDocumentHeader(indentwriter);
        NodeList nodelist = document.getChildNodes();
        writeXml(nodelist, indentwriter);
    }

    private static void writeXml(NodeList nodelist, IndentWriter indentwriter)
        throws IOException, SVGGraphics2DIOException
    {
        int i = nodelist.getLength();
        if(i == 0)
            return;
        for(int j = 0; j < i; j++)
        {
            Node node = nodelist.item(j);
            writeXml(node, ((Writer) (indentwriter)));
            indentwriter.write(EOL);
        }

    }

    static String java2std(String s)
    {
        if(s == null)
            return null;
        if(s.startsWith("ISO8859_"))
            return "ISO-8859-" + s.substring(8);
        if(s.startsWith("8859_"))
            return "ISO-8859-" + s.substring(5);
        if("ASCII7".equalsIgnoreCase(s) || "ASCII".equalsIgnoreCase(s))
            return "US-ASCII";
        if("UTF8".equalsIgnoreCase(s))
            return "UTF-8";
        if(s.startsWith("Unicode"))
            return "UTF-16";
        if("SJIS".equalsIgnoreCase(s))
            return "Shift_JIS";
        if("JIS".equalsIgnoreCase(s))
            return "ISO-2022-JP";
        if("EUCJIS".equalsIgnoreCase(s))
            return "EUC-JP";
        else
            return s;
    }

    public static void writeXml(Node node, Writer writer)
        throws SVGGraphics2DIOException
    {
        try
        {
            IndentWriter indentwriter = null;
            if(writer instanceof IndentWriter)
                indentwriter = (IndentWriter)writer;
            else
                indentwriter = new IndentWriter(writer);
            switch(node.getNodeType())
            {
            case 2: // '\002'
                writeXml((Attr)node, indentwriter);
                break;

            case 8: // '\b'
                writeXml((Comment)node, indentwriter);
                break;

            case 3: // '\003'
                writeXml((Text)node, indentwriter);
                break;

            case 4: // '\004'
                writeXml((CDATASection)node, indentwriter);
                break;

            case 9: // '\t'
                writeXml((Document)node, indentwriter);
                break;

            case 11: // '\013'
                writeDocumentHeader(indentwriter);
                NodeList nodelist = node.getChildNodes();
                writeXml(nodelist, indentwriter);
                break;

            case 1: // '\001'
                writeXml((Element)node, indentwriter);
                break;

            case 5: // '\005'
            case 6: // '\006'
            case 7: // '\007'
            case 10: // '\n'
            default:
                throw new SVGGraphics2DRuntimeException("Unable to write node of type " + node.getClass().getName());
            }
        }
        catch(IOException ioexception)
        {
            throw new SVGGraphics2DIOException(ioexception);
        }
    }

    private static String EOL;
    private static final String TAG_END = " />";
    private static final String TAG_START = "</";
    private static final String SPACE = " ";
    private static final char SPACES[] = {
        ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 
        ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 
        ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '
    };
    private static final int SPACES_LEN = SPACES.length;

    static 
    {
        String s;
        try
        {
            s = System.getProperty("line.separator", "\n");
        }
        catch(SecurityException securityexception)
        {
            s = "\n";
        }
        EOL = s;
    }



}
