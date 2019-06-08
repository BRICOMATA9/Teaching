package Exercice_2;

import java.util.Iterator;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

public class Exo2 {

	public static <K,V> Map<V,Collection<K>> inverser (Map<K,V> m){
		Map<V,Collection<K>> map = new HashMap<V,Collection<K>>();

		for(V valeur:m.values()){
			Collection<K> keys = new ArrayList<K>();
			for(K key:m.keySet())
				if (m.get(key).equals(valeur))
					keys.add(key);
			map.put(valeur,keys);
		}
		return map;
	}

	public static void main (String[] args) {

		Map<Integer,String> map1 = new HashMap<Integer,String>();
		Map<String,Collection<Integer>> map2 = new HashMap<String,Collection<Integer>>();

		map1.put(1,"A");
		map1.put(2,"B");
		map1.put(10,"A");
		map1.put(22,"Z");

		map2 = inverser(map1);
		map2.get("A").remove(1);
		System.out.println(map2);

		map2.remove("A");
		System.out.println(map2);



	} 
}
