package preliminaire;

import java.util.Map;
import java.util.TreeMap;
import java.util.Iterator;

public class Memoire implements Contexte {

    private Map<String, Integer> table;

    public Memoire() {
        table = new TreeMap<String, Integer>();
    }

    public Integer lire(String adresse) {
        Integer valeur = table.get(adresse);
        if (valeur == null) throw new RuntimeException();
        return valeur;
    }

    public void ecrire(String adresse, Integer valeur) {
        table.put(adresse, valeur);
    }

    public String toString() {
        return table.toString();
    }

    public Iterator<String> iterator() {
        return table.keySet().iterator();
    }
    
}