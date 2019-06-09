package Exercice_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Exo3 {

	public static <K,V> void append(Map<String,V> map,String k,V v) {
		map.compute(k,(c, l) -> v);
	}
	
	public static void main(String[] args) {
		List<String>list1=new ArrayList<String>(Arrays.asList("aghiles"));
		List<String>list2=new ArrayList<String>(Arrays.asList("djoudi"));
		List<String>list3=new ArrayList<String>(Arrays.asList("paris"));
		Map<String,List<String>> map = new HashMap<>();

		map.put("UPEC1", list1);
		map.put("UPEC2", list2);
		map.put("UPEC3", list3);

		append(map,"Créteil",list1);
		map.forEach((k,v) -> System.out.println(k+","+v));
	}
}
