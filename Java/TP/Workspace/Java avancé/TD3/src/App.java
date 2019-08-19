import java.util.*;
import java.util.function.Function;
import java.util.stream.*;

import static java.util.stream.Collectors.*;
import static java.util.stream.Stream.*;
import static java.util.Comparator.*;


public class App {

	//Questions 1,2,3
	
	public static <T,S> Set<S> mapToSet (List<T> ls,Function<T,S> f) {
		return ls.stream()
				.map(f)
				.collect(toSet());
	}
	public static <T,S> Set<S> flatMapToSet (List<T> ls,Function<T,Stream<S>> f) {
		return ls.stream()
				.flatMap(f)
				.collect(toSet());
	}
	
	//Question 1
    public static Set<String> colors (List<Apple> apples) {
    	return mapToSet (apples,Apple::getColor);
    }
    
    //Question 2
    public static Set<Farm> origins (List<Apple> apples) {
    	return mapToSet (apples,Apple::getOrigin);
    }
    
    //Question 3
    public static Set<String> destinationCities (List<Apple> apples) {
    	return flatMapToSet (apples, Apple::getDestinationCities);
    }
    
    //Question 4 (Version 1)
    
    public static Integer integerTotalPrice (List<Apple> apples) {
    	return apples.stream()
    			     .map(a->a.getOrigin().getPrice())
    			     .reduce(0, Integer::sum);
    }
    
    // Question 4 (Version 2)
    public static int intTotalPrice (List<Apple> apples) {
    	return apples.stream()
    				.mapToInt(a -> a.getOrigin().getPrice().intValue())
    				.sum();
    }
    
    // Question 5
    
    public static int totalNumberStalls (List<Apple> apples) {
    	return apples.stream()
    			.flatMap(a -> a.getOrigin().getDestinations().stream())
    			.distinct()
    			.mapToInt(Market::getnStalls)
    			.sum();
    }
    
    // Question 6, simplifiée
    
    public static Map<Character, List<Apple>> initial (List<Apple> apples) {
    	return apples.stream()
    				 .collect(groupingBy(a -> a.getOrigin().getName().charAt(0)
    						 			)
    						 );
    }
    
    // Question 6
    public static Map<Character, Integer> initialPrices (List<Apple> apples) {
    	return apples.stream()
    				 .collect(groupingBy(a -> a.getOrigin().getName().charAt(0),
    						              summingInt(a -> a.getOrigin().getPrice())
    						              )
    						 );
    }
    
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
    	Stream<String> cities = apples.stream()
    			                   .flatMap(a-> a.getDestinationCities())
    			                   .distinct();
    	Map<String, List<Apple>> answer = new HashMap<>();       
    	cities.forEach(c -> answer.put(c,applesForTheCity(apples,c)));
    	return answer;
    }
    	
    //Question 8
    
    public static Stream<Apple> randomApples (Farm origin) {
    	return generate(() -> new Apple(new Random().nextInt(1000),"Rouge",origin));
    }
    
    //Question 9
    
    public static List<Apple> firstTen (List<Farm> origins) {
    	return origins.stream()
    			      .flatMap(o -> randomApples(o)
    			    		        .filter(a -> a.getWeight()<200)
    			    		        .limit(10)
    			    		   )
    			      .sorted(comparingInt(Apple::getWeight))
    			      .collect(toList());
    }
    
    public static void main (String[] args) {
    	Farm f1 = new Farm ("Toto",3,12,new ArrayList<>());
    	Farm f2 = new Farm ("Titi",3,12,new ArrayList<>());
    	Farm f3 = new Farm ("Tutu",3,12,new ArrayList<>());
    	
    	f1.getDestinations().add(new Market("Paris",3));
    	f1.getDestinations().add(new Market("Rome",3));
    	f1.getDestinations().add(new Market("London",3));
    	f2.getDestinations().add(new Market("Paris",3));
    	f2.getDestinations().add(new Market("Lyon",3));
    	f3.getDestinations().add(new Market("Paris",3));
    	f3.getDestinations().add(new Market("London",3));
    	f3.getDestinations().add(new Market("Rennes",3));
    	f3.getDestinations().add(new Market("Brest",3));
    	f3.getDestinations().add(new Market("Pau",3));

    	
    	List<Farm> origins = Arrays.asList(f1,f2,f3);
    	List<Apple> apples = firstTen (origins);
    	//apples.forEach(a -> System.out.println("Pomme: "+ a.getWeight() + " " + a.getOrigin().getName()));
        
    	Map<String,List<Apple>> map = mapDestinations(apples);
    	map.forEach((s,l)-> {System.out.print(s + ": ");
    	                     l.forEach(a-> System.out.print("Pomme: "+ a.getOrigin().getName() + " "+ a.getWeight() + " "));
    	                     System.out.println();}
    				);
    }
    
    
    
    
}
