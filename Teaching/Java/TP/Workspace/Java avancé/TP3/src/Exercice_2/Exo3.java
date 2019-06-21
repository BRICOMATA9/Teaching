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

public class Exo3 {

	public static <U,T> U fold(Collection<T> c, U u, BiFunction<U,T,U> f) {
		for(T t:c)
		  u = f.apply(u,t);
		return u;
	}
	
	public static void main(String[] args) {

		List<String>list4=new ArrayList<String>(Arrays.asList("aghiles","djoudi"));
		List<String>list5=new ArrayList<String>(Arrays.asList("djoudi"));
		List<String>list6=new ArrayList<String>(Arrays.asList("paris"));

		Map<String,List<String>> map2 = new HashMap<>();

		map2.put("UPEC1", list4);
		map2.put("UPEC2", list5);
		map2.put("UPEC3", list6);

		System.out.println(fold(list4,"",(a,b)-> a+b));
	}
}
