// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package B.D.D;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.io.*;
import java.util.Iterator;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriter;
import javax.imageio.stream.MemoryCacheImageOutputStream;
import org.graphdrawing.graphml.reader.GraphMLParseContext;
import org.graphdrawing.graphml.reader.GraphMLParseErrorHandler;
import org.graphdrawing.graphml.util.Base64;
import org.graphdrawing.graphml.writer.*;
import org.w3c.dom.*;

class H
    implements org.graphdrawing.graphml.reader.GraphMLParseContext.ResourceDecoder, org.graphdrawing.graphml.writer.GraphMLWriteContext.ResourceEncoder
{

    H()
    {
    }

    public Object decode(Node node, GraphMLParseContext graphmlparsecontext)
    {
        NodeList nodelist;
        int i;
        if(node == null)
            return null;
        nodelist = node.getChildNodes();
        i = 0;
_L4:
        if(i >= nodelist.getLength()) goto _L2; else goto _L1
_L1:
        byte abyte0[];
        ByteArrayInputStream bytearrayinputstream;
        Node node1 = nodelist.item(i);
        if(node1.getNodeType() != 3)
            continue; /* Loop/switch isn't completed */
        String s = node1.getNodeValue();
        String s1 = null;
        Node node2 = node.getAttributes().getNamedItem("format");
        if(node2 != null)
            s1 = node2.getNodeValue();
        if(s1 == null)
            s1 = "png";
        abyte0 = Base64.decode(s);
        bytearrayinputstream = null;
        BufferedImage bufferedimage;
        bytearrayinputstream = new ByteArrayInputStream(abyte0);
        bufferedimage = ImageIO.read(bytearrayinputstream);
        GraphicsDevice agraphicsdevice[];
        int j;
        GraphicsEnvironment graphicsenvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        agraphicsdevice = graphicsenvironment.getScreenDevices();
        j = 0;
_L3:
        int k;
        int l;
        BufferedImage bufferedimage2;
        Graphics2D graphics2d;
        if(j >= agraphicsdevice.length)
            break MISSING_BLOCK_LABEL_329;
        GraphicsDevice graphicsdevice = agraphicsdevice[j];
        GraphicsConfiguration agraphicsconfiguration[] = graphicsdevice.getConfigurations();
        if(agraphicsconfiguration.length <= 0)
            break MISSING_BLOCK_LABEL_292;
        GraphicsConfiguration graphicsconfiguration = agraphicsconfiguration[0];
        k = bufferedimage.getWidth(null);
        l = bufferedimage.getHeight(null);
        bufferedimage2 = graphicsconfiguration.createCompatibleImage(k, l, bufferedimage.getColorModel().getTransparency());
        graphics2d = (Graphics2D)bufferedimage2.getGraphics();
        graphics2d.setBackground(new Color(255, 255, 255, 0));
        graphics2d.clearRect(0, 0, k, l);
        graphics2d.drawImage(bufferedimage, 0, 0, null);
        break MISSING_BLOCK_LABEL_264;
        exception2;
        graphics2d.dispose();
        throw exception2;
        BufferedImage bufferedimage3;
        Exception exception2;
        graphics2d.dispose();
        bufferedimage3 = bufferedimage2;
        return bufferedimage3;
        j++;
          goto _L3
        Exception exception1;
        exception1;
        BufferedImage bufferedimage1;
        graphmlparsecontext.getErrorHandler().warning("yext.graphml.graph2D.ImageNodeRealizerSerializer.ImageConverter#decode", "Returning raw image IO image", exception1, graphmlparsecontext);
        bufferedimage1 = bufferedimage;
        return bufferedimage1;
        continue; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        graphmlparsecontext.getErrorHandler().warning("yext.graphml.graph2D.ImageNodeRealizerSerializer.ImageConverter#decode", "Unable to decode image resource", exception, graphmlparsecontext);
        continue; /* Loop/switch isn't completed */
        local;
        if(bytearrayinputstream != null)
            try
            {
                bytearrayinputstream.close();
            }
            catch(IOException ioexception) { }
        JVM INSTR ret 24;
        i++;
          goto _L4
_L2:
        return null;
    }

    public void encode(Object obj, XmlWriter xmlwriter, GraphMLWriteContext graphmlwritecontext)
    {
        String s;
        ImageWriter imagewriter;
        BufferedImage bufferedimage;
        ByteArrayOutputStream bytearrayoutputstream;
        MemoryCacheImageOutputStream memorycacheimageoutputstream;
        Image image = (Image)obj;
        s = null;
        String s1 = "png";
        imagewriter = (ImageWriter)ImageIO.getImageWritersBySuffix(s1).next();
        if(imagewriter == null)
            break MISSING_BLOCK_LABEL_182;
        bufferedimage = new BufferedImage(image.getWidth(null), image.getHeight(null), 2);
        Graphics2D graphics2d = bufferedimage.createGraphics();
        graphics2d.drawImage(image, 0, 0, null);
        graphics2d.dispose();
        bytearrayoutputstream = new ByteArrayOutputStream();
        memorycacheimageoutputstream = new MemoryCacheImageOutputStream(bytearrayoutputstream);
        imagewriter.setOutput(memorycacheimageoutputstream);
        imagewriter.write(bufferedimage);
        s = Base64.encodeToString(bytearrayoutputstream.toByteArray(), true);
        try
        {
            memorycacheimageoutputstream.close();
        }
        catch(IOException ioexception) { }
        break MISSING_BLOCK_LABEL_182;
        IOException ioexception1;
        ioexception1;
        graphmlwritecontext.getErrorHandler().warning("yext.graphml.graph2D.ImageNodeRealizerSerializer.ImageConverter#encode", "Unable to encode image resource", ioexception1, graphmlwritecontext);
        try
        {
            memorycacheimageoutputstream.close();
        }
        catch(IOException ioexception2) { }
        break MISSING_BLOCK_LABEL_182;
        Exception exception;
        exception;
        try
        {
            memorycacheimageoutputstream.close();
        }
        catch(IOException ioexception3) { }
        throw exception;
        if(s != null)
            xmlwriter.writeText(s);
        return;
    }
}
