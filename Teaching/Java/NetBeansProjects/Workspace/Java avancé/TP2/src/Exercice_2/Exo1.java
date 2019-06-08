package Exercice_2;

import java.util.Collection;
import java.util.ArrayList;
import java.util.Arrays;

public class Exo1 {

	public Object _valeur = new Object();
	public Class <?> _clef = _valeur.getClass();

	public Exo1 (Object valeur,Class<?> clef){
		_valeur=valeur;
		_clef=clef;
	
	}

	public Object getValeur(Class <?> clef){
		if (_clef==clef) return _valeur;
		return null;
	}

	public static void main(String[] args) {
		Integer valeur1 = new Integer(3);		
		Double valeur2 = new Double(4);
		String valeur3 = new String("hghg");

		Exo1 o1 = new Exo1(valeur1,valeur1.getClass());
		Exo1 o2 = new Exo1(valeur2,valeur2.getClass());
		Exo1 o3 = new Exo1(valeur3,valeur3.getClass());

		Collection <Exo1> map = new ArrayList<Exo1>();

		map.add(o1);
		map.add(o2);
		map.add(o3);

		for(Exo1 e:map)
			if (e.getValeur(valeur3.getClass())!=null)
				System.out.println(e.getValeur(valeur3.getClass()));
	}
}
