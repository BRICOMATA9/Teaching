package Exercice_1;

import java.util.Collection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class Exo3 {

	public static <T> void  insere (Collection<T> c,Map<T,T> m){

		for(T elm:c)
			m.put(elm,elm);			

	}

	public static void main (String[] args){
	
		Collection <Integer> col = new ArrayList<Integer>(Arrays.asList(0,1,2,3,4,5));
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();

		insere(col,map);
		System.out.println(map);
		
		
	} 
}
