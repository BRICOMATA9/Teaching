// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package B.D.A;

import java.io.StringReader;
import org.xml.sax.*;

public class B
    implements EntityResolver
{

    public B()
    {
    }

    public InputSource resolveEntity(String s, String s1)
        throws SAXException
    {
        if(s1.equals("http://graphml.graphdrawing.org/dtds/graphml.dtd") || s1.equals("http://www.graphdrawing.org/dtds/graphml.dtd"))
        {
            InputSource inputsource = new InputSource(new StringReader("<!ELEMENT graphml  ((desc)?,(key)*,((data)|(graph))*)><!ELEMENT locator EMPTY><!ATTLIST locator    xmlns:xlink   CDATA    #FIXED    \"http://www.w3.org/TR/2000/PR-xlink-20001220/\"    xlink:href    CDATA    #REQUIRED    xlink:type    (simple) #FIXED    \"simple\"><!ELEMENT desc (#PCDATA)><!ELEMENT graph    ((desc)?,((((data)|(node)|(edge)|(hyperedge))*)|(locator)))><!ATTLIST graph    id          ID                    #IMPLIED    edgedefault (directed|undirected) #REQUIRED><!ELEMENT node   (desc?,(((data|port)*,graph?)|locator))><!ATTLIST node    id        ID      #REQUIRED><!ELEMENT port ((desc)?,((data)|(port))*)><!ATTLIST port    name    NMTOKEN  #REQUIRED><!ELEMENT edge ((desc)?,(data)*,(graph)?)><!ATTLIST edge    id         ID           #IMPLIED    source     IDREF        #REQUIRED    sourceport NMTOKEN      #IMPLIED    target     IDREF        #REQUIRED    targetport NMTOKEN      #IMPLIED    directed   (true|false) #IMPLIED><!ELEMENT hyperedge  ((desc)?,((data)|(endpoint))*,(graph)?)><!ATTLIST hyperedge    id     ID      #IMPLIED><!ELEMENT endpoint ((desc)?)><!ATTLIST endpoint          id    ID             #IMPLIED    node  IDREF          #REQUIRED    port  NMTOKEN        #IMPLIED     type  (in|out|undir) \"undir\"><!ELEMENT key (#PCDATA)><!ATTLIST key    id  ID                                            #REQUIRED    for (graph|node|edge|hyperedge|port|endpoint|all) \"all\"><!ELEMENT data  (#PCDATA)><!ATTLIST data    key      IDREF        #REQUIRED    id       ID           #IMPLIED>"));
            inputsource.setSystemId("http://graphml.graphdrawing.org/dtds/graphml.dtd");
            return inputsource;
        } else
        {
            throw new SAXException("Unknown System Identifier: " + s1);
        }
    }
}
