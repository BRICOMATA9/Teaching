package Exercice_1;

import java.util.Collection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.HashSet;

public class Exo2 {

	public static <T> void toArrayList(Map<String,Collection<T>> map) {
		map.replaceAll((k,v) -> k.startsWith("*")? new ArrayList<T>(v):v);
	}

	public static <S,T> List<T> methode(Map<S,List<T>> map) {
		List<T> list2 = new ArrayList<T>();
		map.forEach((k,v) -> {for(T elm:v) list2.add(elm);});
		return list2;
	}

	public static void main(String[] args) {
		Collection<String>list1=new HashSet<String>(Arrays.asList("aghiles"));
		Collection<String>list2=new ArrayList<String>(Arrays.asList("djoudi"));
		Collection<String>list3=new ArrayList<String>(Arrays.asList("paris"));
		Map<String,Collection<String>> map = new HashMap<>();

		map.put("UPEC1", list1);
		map.put("*UPEC2", list2);
		map.put("UPEC3", list3);

		toArrayList(map);
		map.forEach((k,v) -> System.out.println(k+","+v));
	}
}
