package Exercice_2;

import java.util.Iterator;
import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.function.BiFunction;

public class Exo4 {

	public static <U,T> U fold(Collection<T> c, U u, BiFunction<U,T,U> f) {
		for(T t:c)
		  u = f.apply(u,t);
		return u;
	}
	
	public static void main(String[] args) {
		List<Integer>list1=new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
		List<Integer>list2=new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
		List<Integer>list3=new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));

		Map<String,List<Integer>> map1 = new HashMap<>();
		Map<String,List<String>> map2 = new HashMap<>();

		map1.put("UPEC1", list1);
		map1.put("UPEC2", list2);
		map1.put("UPEC3", list3);

		System.out.println(fold(list1,0,(a,b)-> a+b));
	}
}
