import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;

public class Exo2 {

	public static void main(String[] args) {
	
		Map<String,List<Integer>> map1 = new HashMap<>();
		
		//Values
		List<Integer>list1=new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
		List<Integer>list2=new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
		List<Integer>list3=new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));

		//Keys
		map1.put("ECE1", list1);
		map1.put("ECE2", list2);
		map1.put("ECE3", list3);

		System.out.println(map1.keySet());
		System.out.println(map1.values());
	}
}
