package Exercice_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Exo1 {

	public static <S,T> List<T> accepte(Map<S,List<T>> map) {
		List<T> list = new ArrayList<T>();
		for(List<T> l:map.values()) list.addAll(l);
//		map.forEach((k,v) -> {list.addAll(v);});
		return list;
	}

	public static void main(String[] args) {
		List<String>list1=new ArrayList<String>(Arrays.asList("aghiles"));
		List<String>list2=new ArrayList<String>(Arrays.asList("djoudi"));
		List<String>list3=new ArrayList<String>(Arrays.asList("paris"));

		Map<String,List<String>> map = new HashMap<>();

		map.put("1", list1);
		map.put("2", list2);
		map.put("3", list3);
		
		for(String s:accepte(map))
			System.out.println(s);
	}
}
