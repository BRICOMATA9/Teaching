import java.util.*;
import java.util.function.Function;
import java.util.stream.*;

import static java.util.stream.Collectors.*;
import static java.util.stream.Stream.*;
import static java.util.Comparator.*;

public class Exo7 {
	
  // Question 7 Une solution possible, mais pas completement satisfaisante
  // Pouvez-vous faire mieux?
  
  public static List<Apple> applesForTheCity (List<Apple> apples, String c) {
  	return  apples.stream()
  				  .sorted(comparingInt(Apple::getWeight))
  				  .filter(a -> a.getDestinationCities()
  						  	    .anyMatch(c::equals))
  				  .collect(toList());
  }
  
  public static Map<String, List<Apple>> mapDestinations (List<Apple> apples) {
  	Stream <String> cities = apples.stream()
  			                   .flatMap(a -> a.getDestinationCities())
  			                   .distinct();
  	Map<String, List<Apple>> answer = new HashMap<>();       
  	cities.forEach(c -> answer.put(c,applesForTheCity(apples,c)));
  	return answer;
  }

  public static void main (String[] args) {
		Market m1 = new Market("Paris",3);
		Market m2 = new Market("Rome",3);
		Market m3 = new Market("London",3);
		Market m4 = new Market("Brest",3);

  	Farm f1 = new Farm ("Toto",3,12,new ArrayList<Market>(Arrays.asList(m1,m2,m3)));
  	Farm f2 = new Farm ("Diti",3,12,new ArrayList<>(Arrays.asList(m1,m2,m4)));
  	Farm f3 = new Farm ("Uutu",3,12,new ArrayList<>(Arrays.asList(m4,m2,m3)));

		Apple a1 = new Apple (2,"Black",f1);
		Apple a2 = new Apple (2,"Yellow",f1);
		Apple a3 = new Apple (2,"Red",f3);

		System.out.println(mapDestinations (new ArrayList<Apple>(Arrays.asList(a1,a2,a3))));

  }    
}
