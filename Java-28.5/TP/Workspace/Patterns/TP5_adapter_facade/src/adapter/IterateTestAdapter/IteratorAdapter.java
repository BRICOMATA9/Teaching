package adapter.IterateTestAdapter;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;
import java.util.Enumeration;

public class IteratorAdapter<T> implements Enumeration<T> {
	private Iterator<T> iterator;
	
	public IteratorAdapter(Iterator<T> iterator) {
		this.iterator = iterator;
	}

	public boolean hasMoreElements() {
		return iterator.hasNext();
	}

	public T nextElement() {
		return iterator.next();
	} 

}
