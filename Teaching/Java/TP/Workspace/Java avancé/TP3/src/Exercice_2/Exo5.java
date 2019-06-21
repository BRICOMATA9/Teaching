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

public class Exo5 {

	public static <U,T> U fold(Collection<T> c, U u, BiFunction<U,T,U> f,BiFunction<U,T,U> g) {
		for(T t:c){
		  u = f.apply(u,t);
		  u = g.apply(u,t);
		}
		return u;
	}
	
	public static void main(String[] args) {
		List<Integer>list1=new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
		List<Integer>list2=new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
		List<Integer>list3=new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));

		List<String>list4=new ArrayList<String>(Arrays.asList("aghiles","djoudi"));
		List<String>list5=new ArrayList<String>(Arrays.asList("djoudi"));
		List<String>list6=new ArrayList<String>(Arrays.asList("paris"));

		Map<String,List<Integer>> map1 = new HashMap<>();
		Map<String,List<String>> map2 = new HashMap<>();

		map1.put("UPEC1", list1);
		map1.put("UPEC2", list2);
		map1.put("UPEC3", list3);
		map2.put("UPEC1", list4);
		map2.put("UPEC2", list5);
		map2.put("UPEC3", list6);

		System.out.println(fold(list1,0,(a,b)-> a+b,(a,b)-> a*b));
/*
		for(String s:methode(map))
			System.out.println(s);

		toArrayList(map);
		map.forEach((k,v) -> System.out.println(k+","+v));
		append(map,"aye",list1);
		map.forEach((k,v) -> System.out.println(k+","+v));*/
	}
}
