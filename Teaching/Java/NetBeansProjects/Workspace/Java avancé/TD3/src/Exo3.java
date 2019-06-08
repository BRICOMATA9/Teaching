import java.util.*;
import java.util.function.Function;
import java.util.stream.*;

import static java.util.stream.Collectors.*;
import static java.util.stream.Stream.*;
import static java.util.Comparator.*;

public class Exo3 {

	public static Set<String> flatMapToSet1 (List<Apple> ls) {
		return ls.stream()
				.flatMap(a -> a.getOrigin().getDestinations()
				     														.stream()
				     														.map(Market::getCity))
				.collect(toSet());
	}

	public static Set<Stream> mapToSet2 (List<Apple> ls) {
		return ls.stream()
				.map(a -> a.getOrigin().getDestinations()
				     														.stream()
				     														.map(Market::getCity))
				.collect(toSet());
	}

/*
	//Questions 1,2,3

	public static <T,S> Set<S> flatMapToSet (List<T> ls,Function<T,Stream<S>> f) {
		return ls.stream()
				.flatMap(f)
				.collect(toSet());
	}*/


/*
  //Question 3
  public static Set<String> destinationCities (List<Apple> apples) {
  	return flatMapToSet (apples, Apple::getDestinationCities);
  }
	
  //Question 3
	public static Set<String> destinationCities1 (List<Apple> apples) {
		return flatMapToSet (apples, a -> a.getOrigin().getDestinations()
				     														.stream()
				     														.map(Market::getCity)
												);
	}*/
    
  public static void main (String[] args) {
		Market m1 = new Market("Paris",3);
		Market m2 = new Market("Rome",3);
		Market m3 = new Market("London",3);
		Market m4 = new Market("Brest",3);

  	Farm f1 = new Farm ("Toto",3,12,new ArrayList<Market>(Arrays.asList(m1,m2,m3)));
  	Farm f2 = new Farm ("Titi",3,12,new ArrayList<>(Arrays.asList(m1,m2,m4)));
  	Farm f3 = new Farm ("Tutu",3,12,new ArrayList<>(Arrays.asList(m4,m2,m3)));

		Apple a1 = new Apple (2,"Black",f1);
		Apple a2 = new Apple (2,"Yellow",f2);
		Apple a3 = new Apple (2,"Red",f3);

		System.out.println(flatMapToSet1(new ArrayList<Apple>(Arrays.asList(a1,a2,a3))));

  }    
}
