package adapter.IterateTestAdapter;

import java.util.Vector;
import java.util.Enumeration;

public class OldStyleList<T>
{
	/**
	 * Ignore that we are actually implementing
	 * this using a Vector (which does have
	 * an Iterator.) Just imagine we only have
	 * an Enumeration via the elements() method.
	 */
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
}
