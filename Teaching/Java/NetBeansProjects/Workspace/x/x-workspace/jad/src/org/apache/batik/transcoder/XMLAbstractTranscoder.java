// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.transcoder;

import java.io.IOException;
import org.apache.batik.dom.util.DocumentFactory;
import org.apache.batik.dom.util.SAXDocumentFactory;
import org.apache.batik.transcoder.keys.BooleanKey;
import org.apache.batik.transcoder.keys.DOMImplementationKey;
import org.apache.batik.transcoder.keys.StringKey;
import org.apache.batik.util.XMLResourceDescriptor;
import org.w3c.dom.*;

// Referenced classes of package org.apache.batik.transcoder:
//            AbstractTranscoder, TranscodingHints, TranscoderException, TranscoderInput, 
//            ErrorHandler, TranscoderOutput

public abstract class XMLAbstractTranscoder extends AbstractTranscoder
{

    protected XMLAbstractTranscoder()
    {
        hints.put(KEY_XML_PARSER_VALIDATING, Boolean.FALSE);
    }

    public void transcode(TranscoderInput transcoderinput, TranscoderOutput transcoderoutput)
        throws TranscoderException
    {
        Document document = null;
        String s = transcoderinput.getURI();
        if(transcoderinput.getDocument() != null)
        {
            document = transcoderinput.getDocument();
        } else
        {
            String s1 = (String)hints.get(KEY_XML_PARSER_CLASSNAME);
            String s2 = (String)hints.get(KEY_DOCUMENT_ELEMENT_NAMESPACE_URI);
            String s3 = (String)hints.get(KEY_DOCUMENT_ELEMENT);
            DOMImplementation domimplementation = (DOMImplementation)hints.get(KEY_DOM_IMPLEMENTATION);
            if(s1 == null)
                s1 = XMLResourceDescriptor.getXMLParserClassName();
            if(domimplementation == null)
            {
                handler.fatalError(new TranscoderException("Unspecified transcoding hints: KEY_DOM_IMPLEMENTATION"));
                return;
            }
            if(s2 == null)
            {
                handler.fatalError(new TranscoderException("Unspecified transcoding hints: KEY_DOCUMENT_ELEMENT_NAMESPACE_URI"));
                return;
            }
            if(s3 == null)
            {
                handler.fatalError(new TranscoderException("Unspecified transcoding hints: KEY_DOCUMENT_ELEMENT"));
                return;
            }
            DocumentFactory documentfactory = createDocumentFactory(domimplementation, s1);
            boolean flag = ((Boolean)hints.get(KEY_XML_PARSER_VALIDATING)).booleanValue();
            documentfactory.setValidating(flag);
            try
            {
                if(transcoderinput.getInputStream() != null)
                    document = documentfactory.createDocument(s2, s3, transcoderinput.getURI(), transcoderinput.getInputStream());
                else
                if(transcoderinput.getReader() != null)
                    document = documentfactory.createDocument(s2, s3, transcoderinput.getURI(), transcoderinput.getReader());
                else
                if(transcoderinput.getXMLReader() != null)
                    document = documentfactory.createDocument(s2, s3, transcoderinput.getURI(), transcoderinput.getXMLReader());
                else
                if(s != null)
                    document = documentfactory.createDocument(s2, s3, s);
            }
            catch(DOMException domexception)
            {
                handler.fatalError(new TranscoderException(domexception));
            }
            catch(IOException ioexception)
            {
                ioexception.printStackTrace();
                handler.fatalError(new TranscoderException(ioexception));
            }
        }
        if(document != null)
            try
            {
                transcode(document, s, transcoderoutput);
            }
            catch(TranscoderException transcoderexception)
            {
                handler.fatalError(transcoderexception);
                return;
            }
    }

    protected DocumentFactory createDocumentFactory(DOMImplementation domimplementation, String s)
    {
        return new SAXDocumentFactory(domimplementation, s);
    }

    protected abstract void transcode(Document document, String s, TranscoderOutput transcoderoutput)
        throws TranscoderException;

    public static final TranscodingHints.Key KEY_XML_PARSER_CLASSNAME = new StringKey();
    public static final TranscodingHints.Key KEY_XML_PARSER_VALIDATING = new BooleanKey();
    public static final TranscodingHints.Key KEY_DOCUMENT_ELEMENT = new StringKey();
    public static final TranscodingHints.Key KEY_DOCUMENT_ELEMENT_NAMESPACE_URI = new StringKey();
    public static final TranscodingHints.Key KEY_DOM_IMPLEMENTATION = new DOMImplementationKey();

}
