package exo1;

import java.util.*;

public class Exo1_q3 {

	public static <T> Map<Integer, T > toMap (ArrayList <T> array){
		Map<Integer, T> map = new HashMap<Integer, T>();
		for(int i=0; i <array.size(); i++){
			map.put(i, array.get(i));
		}
		return map;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<String> array = new ArrayList<String>();
		array.add("toto");
		array.add("tata");
		
		System.out.println(Exo1_q3.toMap(array));
	}

}
