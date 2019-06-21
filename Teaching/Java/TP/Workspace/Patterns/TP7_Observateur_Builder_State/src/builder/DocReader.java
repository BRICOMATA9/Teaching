package builder;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class DocReader {

	private NodeConverter converter;
	private String fileName;

	public DocReader(NodeConverter converter, String fileName) {
		this.converter=converter;
		this.fileName=fileName;
	}

	public void build() {

		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			
			Document document = documentBuilder.parse(fileName);
			DOMNodes projectNodes = new DOMNodes(document.getElementsByTagName("project"));
			for (Node node : projectNodes) {
				converter.ReadProject(getNodeAttribute(node, "title"));
				converter.ReadEmail(getNodeAttribute(node,"tutormail"));
				converter.ReadSupervisor(getNodeAttribute(node, "tutorname"));
				converter.ReadDescription(node.getNodeValue());
			}
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private String getNodeAttribute(Node node, String attributeName) {
		return node.getAttributes().getNamedItem(attributeName).getNodeValue();
	}
	
}
