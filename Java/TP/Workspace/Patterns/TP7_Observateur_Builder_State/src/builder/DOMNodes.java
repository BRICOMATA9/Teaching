package builder;

import java.util.Iterator;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DOMNodes implements Iterable<Node> {

	private NodeList nodes;

	public DOMNodes(NodeList nodes) {
		this.nodes = nodes;
	}

	@Override
	public Iterator<Node> iterator() {
		return new Iterator<Node>() {

			private int i=0;
			
			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}

			@Override
			public Node next() {
				return nodes.item(i++);
			}

			@Override
			public boolean hasNext() {
				return i < nodes.getLength();
			}
		};
	}

}
