package question1;

import java.util.Observable;
import java.util.Observer;
import java.util.Stack;

/**
 * Décrivez votre classe ConcreteObserver ici.
 * 
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class ConcreteObserver implements Observer {

	private Stack<Observable> senders;
	private Stack<Object> arguments;

	public ConcreteObserver() {
		senders = new Stack<Observable>();
		arguments = new Stack<Object>();
	}

	/**
	 * implémentation de la seule méthode de l'interface java.util.Observer à
	 * chaque exécution de cette méthode, celle-ci se contente d'empiler les
	 * paramètres transmis observable et arg respectivement dans 2 piles senders
	 * et arguments
	 */
	public void update(Observable observable, Object arg) {
		senders.push(observable);
		arguments.push(arg);
	}

	public Stack<Observable> senders() {
		return senders;
	}

	public Stack<Object> arguments() {
		return arguments;
	}
	
}
