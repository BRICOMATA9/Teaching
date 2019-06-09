package tp1.exo2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Exo2_q1 {
	
	public static <V,K> Map <V,K> reverse (Map<K,V> mapInput){
		Map<V,K> mapOutput = new HashMap<V,K>();
		Set keys = mapInput.keySet();
		Iterator it = keys.iterator();
		
		while(it.hasNext()){
			K  k = (K) it.next();
			V  v =  mapInput.get(k);
			mapOutput.put(v,k);
			
		}
		
		return  mapOutput;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Map <Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "A");
		map.put(2, "B");
		System.out.println(Exo2_q1.reverse(map));
	}

}
