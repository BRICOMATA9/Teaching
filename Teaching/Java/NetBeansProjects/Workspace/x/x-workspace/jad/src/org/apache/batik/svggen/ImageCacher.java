// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.svggen;

import java.io.*;
import java.util.*;
import java.util.zip.Adler32;
import java.util.zip.Checksum;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

// Referenced classes of package org.apache.batik.svggen:
//            SVGSyntax, ErrorConstants, SVGGraphics2DIOException, DOMTreeManager, 
//            SVGGeneratorContext, SVGIDGenerator

public abstract class ImageCacher
    implements SVGSyntax, ErrorConstants
{
    public static class External extends ImageCacher
    {

        Object getCacheableData(ByteArrayOutputStream bytearrayoutputstream)
        {
            return bytearrayoutputstream;
        }

        boolean imagesMatch(Object obj, Object obj1)
            throws SVGGraphics2DIOException
        {
            boolean flag = false;
            try
            {
                FileInputStream fileinputstream = new FileInputStream((File)obj);
                int i = fileinputstream.available();
                byte abyte0[] = new byte[i];
                byte abyte1[] = ((ByteArrayOutputStream)obj1).toByteArray();
                for(int j = 0; j != i; j += fileinputstream.read(abyte0, j, i - j));
                flag = Arrays.equals(abyte0, abyte1);
            }
            catch(IOException ioexception)
            {
                throw new SVGGraphics2DIOException("could not read image File " + ((File)obj).getName());
            }
            return flag;
        }

        ImageCacheEntry createEntry(int i, Object obj, int j, int k, SVGGeneratorContext svggeneratorcontext)
            throws SVGGraphics2DIOException
        {
            File file = null;
            try
            {
                do
                {
                    if(file != null)
                        break;
                    String s = svggeneratorcontext.idGenerator.generateID(prefix);
                    file = new File(imageDir, s + suffix);
                    if(file.exists())
                        file = null;
                } while(true);
                FileOutputStream fileoutputstream = new FileOutputStream(file);
                ((ByteArrayOutputStream)obj).writeTo(fileoutputstream);
                ((ByteArrayOutputStream)obj).close();
            }
            catch(IOException ioexception)
            {
                throw new SVGGraphics2DIOException("could not write image File " + file.getName());
            }
            return new ImageCacheEntry(i, file, file.getName());
        }

        private String imageDir;
        private String prefix;
        private String suffix;

        public External(String s, String s1, String s2)
        {
            imageDir = s;
            prefix = s1;
            suffix = s2;
        }
    }

    public static class Embedded extends ImageCacher
    {

        public void setDOMTreeManager(DOMTreeManager domtreemanager)
        {
            if(domTreeManager != domtreemanager)
            {
                domTreeManager = domtreemanager;
                imageCache = new Hashtable();
            }
        }

        Object getCacheableData(ByteArrayOutputStream bytearrayoutputstream)
        {
            return "data:image/png;base64," + bytearrayoutputstream.toString();
        }

        boolean imagesMatch(Object obj, Object obj1)
        {
            return obj.equals(obj1);
        }

        ImageCacheEntry createEntry(int i, Object obj, int j, int k, SVGGeneratorContext svggeneratorcontext)
        {
            String s = svggeneratorcontext.idGenerator.generateID("image");
            addToTree(s, (String)obj, j, k, svggeneratorcontext);
            return new ImageCacheEntry(i, obj, "#" + s);
        }

        private void addToTree(String s, String s1, int i, int j, SVGGeneratorContext svggeneratorcontext)
        {
            Document document = domTreeManager.getDOMFactory();
            Element element = document.createElementNS("http://www.w3.org/2000/svg", "image");
            element.setAttributeNS(null, "id", s);
            element.setAttributeNS(null, "width", Integer.toString(i));
            element.setAttributeNS(null, "height", Integer.toString(j));
            element.setAttributeNS("http://www.w3.org/1999/xlink", "xlink:href", s1);
            domTreeManager.addOtherDef(element);
        }

        public Embedded()
        {
        }
    }

    private class ImageCacheEntry
    {

        public int checksum;
        public Object src;
        public String href;

        public ImageCacheEntry(int i, Object obj, String s)
        {
            checksum = i;
            src = obj;
            href = s;
        }
    }


    public ImageCacher()
    {
        domTreeManager = null;
        imageCache = new Hashtable();
        checkSum = new Adler32();
    }

    public ImageCacher(DOMTreeManager domtreemanager)
    {
        this();
        setDOMTreeManager(domtreemanager);
    }

    public void setDOMTreeManager(DOMTreeManager domtreemanager)
    {
        if(domtreemanager == null)
        {
            throw new IllegalArgumentException();
        } else
        {
            domTreeManager = domtreemanager;
            return;
        }
    }

    public DOMTreeManager getDOMTreeManager()
    {
        return domTreeManager;
    }

    public String lookup(ByteArrayOutputStream bytearrayoutputstream, int i, int j, SVGGeneratorContext svggeneratorcontext)
        throws SVGGraphics2DIOException
    {
        int k;
        String s;
        Object obj;
        LinkedList linkedlist;
label0:
        {
            k = getChecksum(bytearrayoutputstream.toByteArray());
            Integer integer = new Integer(k);
            s = null;
            obj = getCacheableData(bytearrayoutputstream);
            linkedlist = (LinkedList)imageCache.get(integer);
            if(linkedlist == null)
            {
                linkedlist = new LinkedList();
                imageCache.put(integer, linkedlist);
                break label0;
            }
            ListIterator listiterator = linkedlist.listIterator(0);
            ImageCacheEntry imagecacheentry1;
            do
            {
                if(!listiterator.hasNext())
                    break label0;
                imagecacheentry1 = (ImageCacheEntry)listiterator.next();
            } while(imagecacheentry1.checksum != k || !imagesMatch(imagecacheentry1.src, obj));
            s = imagecacheentry1.href;
        }
        if(s == null)
        {
            ImageCacheEntry imagecacheentry = createEntry(k, obj, i, j, svggeneratorcontext);
            linkedlist.add(imagecacheentry);
            s = imagecacheentry.href;
        }
        return s;
    }

    abstract Object getCacheableData(ByteArrayOutputStream bytearrayoutputstream);

    abstract boolean imagesMatch(Object obj, Object obj1)
        throws SVGGraphics2DIOException;

    abstract ImageCacheEntry createEntry(int i, Object obj, int j, int k, SVGGeneratorContext svggeneratorcontext)
        throws SVGGraphics2DIOException;

    int getChecksum(byte abyte0[])
    {
        checkSum.reset();
        checkSum.update(abyte0, 0, abyte0.length);
        return (int)checkSum.getValue();
    }

    DOMTreeManager domTreeManager;
    Hashtable imageCache;
    Checksum checkSum;
}
