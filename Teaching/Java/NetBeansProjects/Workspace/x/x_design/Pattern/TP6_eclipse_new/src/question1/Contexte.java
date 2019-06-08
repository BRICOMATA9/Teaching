package question1;

import java.util.Iterator;

public interface Contexte extends Iterable {

	public Integer lire(String adresse);
	public void ecrire(String adresse, Integer valeur);
	public Iterator<String> iterator();

}