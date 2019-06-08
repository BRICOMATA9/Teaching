package question1;

import java.util.Observable;
import java.util.ArrayList;

public class ConcreteSubject extends Observable {

	/** ConcreteSubject est composé d'une liste list */
	private ArrayList<String> list;

	public ConcreteSubject() {
		list = new ArrayList<String>();
	}

	public void insert(String name) {
		list.add(name);
		setChanged();
		notifyObservers(name);
	}

	public String toString() {
		return list.toString();
	}

}
