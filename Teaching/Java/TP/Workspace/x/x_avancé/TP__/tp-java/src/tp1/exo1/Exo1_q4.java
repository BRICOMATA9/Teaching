package tp1.exo1;
import java.util.*;
import java.util.stream.Collectors;
public class Exo1_q4 {
	
	public static <T> Collection<T> toCollection (Collection<Collection> col){
		
		Collection<T> toReturn = new ArrayList<T>();
		
		for(Collection<T> item : col){
			for(T itemInside : item){
				toReturn.add(itemInside);
			}
		}
		
		return toReturn;
		
	}

	public static void main(String[] args) {
		Collection<Integer> list1 = new ArrayList<Integer>(); list1.add(1);
		Collection<Integer> list2 = new ArrayList<Integer>(); list2.add(2);
		Collection<Integer> listEmpty = new ArrayList<Integer>();
		
		Collection<Collection> listOfLists= new ArrayList<Collection>(); listOfLists.add(list1);listOfLists.add(list2);listOfLists.add(listEmpty);
		
		System.out.println(listOfLists);
		System.out.println(Exo1_q4.toCollection(listOfLists));
		
		Collection list = Exo1_q4.toCollection(listOfLists);
		
		System.out.println(
				list1.stream().filter(( a )-> {return a <10;}).collect(Collectors.toList())
				
				);

	}

}
