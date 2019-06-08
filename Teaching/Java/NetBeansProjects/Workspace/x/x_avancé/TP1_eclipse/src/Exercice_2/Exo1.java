package Exercice_2;

import java.util.Iterator;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

public class Exo1 {

	public static <K,V> Map<V,Collection<K>> inverser (Map<K,V> m){
		Map<V,Collection<K>> map = new HashMap<V,Collection<K>>();		

		for(V valeur:m.values()){
			Collection<K> keys = new ArrayList<K>();
			for(K key:m.keySet())
				if (m.get(key).equals(valeur))
					keys.add(key);
			map.put(valeur,keys);
		}

/*
		for(K key1:m.keySet()){
			Collection<K> keys = new ArrayList<K>();
			for(K key:m.keySet())
				if (m.get(key1).equals(m.get(key)))
					keys.add(key);
			map.put(m.get(key1),keys);
		}*/
		return map;
	}

	public static void main (String[] args){

		Map<Integer,String> map = new HashMap<Integer,String>();

		map.put(1,"A");
		map.put(2,"B");
		map.put(10,"A");
		map.put(22,"Z");

		System.out.println(inverser(map));
		
		
	} 
}
