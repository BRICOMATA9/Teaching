package Exercice_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Collection;
	
public class Exo2 {

	public static void collection_vide (Collection<? extends Collection <?>> c){

		for(Iterator <? extends Collection <?>> i=c.iterator();i.hasNext();){
			Collection <?> elem = i.next();
			if (elem.isEmpty())
				i.remove();
		}
	}

	public static void main (String[] args){
	
		Collection <Integer> col = new ArrayList<Integer>(Arrays.asList(0,1,2,3,4,5));
		Collection <Integer> col_vide = new ArrayList<Integer>();
		Collection <Collection<Integer>> col2 = new ArrayList<Collection<Integer>>();

		col2.add(col_vide);
		col2.add(col);
		col2.add(col_vide);

		System.out.println(col2);
		collection_vide(col2);
		System.out.println(col2);
	} 
}
