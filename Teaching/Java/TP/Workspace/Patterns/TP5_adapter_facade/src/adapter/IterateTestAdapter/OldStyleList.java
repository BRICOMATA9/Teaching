package adapter.IterateTestAdapter;

import java.util.Vector;
import java.util.Enumeration;
import java.util.Iterator;

public class OldStyleList<T> {

	private Vector<T> v;

	public OldStyleList() {
		v = new Vector<T>();
	}

	public boolean add(T e) {
		return v.add(e);
	}

	public Enumeration<T> elements() {
		return v.elements();
	}

	public Iterator<T> iterator() {
		return v.iterator();
	}
}
