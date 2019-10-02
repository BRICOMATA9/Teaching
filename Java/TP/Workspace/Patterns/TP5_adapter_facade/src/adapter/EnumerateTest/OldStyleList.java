package adapter.EnumerateTest;

import java.util.Vector;
import java.util.Enumeration;

public class OldStyleList<T> {

	private Vector<T> v;

	public OldStyleList() {
		v = new Vector<T>();
	}

	public boolean add(T e) {
		return v.add(e);
	}

	public Enumeration elements() {
		return v.elements();
	}
}
