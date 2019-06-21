package Test1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;
import static java.util.stream.Collectors.*;
//import static java.

public class Test {

	public static <T,S> S methode (T t, Interface<T,S> i) {
		S s=i.f(t);
		return s;
	}
	
/*1	public static Set<String> colors (List<Apple> apples) {
		return apples.stream().map(Apple::getColor).collect(toSet());
	}*/
	
/*2	public static <T,S> Set<S> sets (List<T> ls, Function<T,S> f) {
		return ls.stream().map(f).collect(toSet());
	}
	
	public static Set<String> colors (List<Apple> apples) {
		return sets(apples,Apple::getColor);
	}*/
	
/*3	public static Set<Set<String>> destinationCities (List<Apple> apples) {
		//return sets(apples,Apple a -> a.getOrigin().getDestinations().stream().map(Market::getCity).collect(toSet());
		return apples.stream().map(Apple::getOrigin).map(Farm::getDestinations).map(Market::getCity).collect(toSet());
	}
	
	public static <T,S> Set<S> sets (List<T> ls, Function<T,S> f) {
		return ls.stream().map(f).collect(toSet());
	}
	
	public static <T,S> Set <S> flatSets (List<T> ls,Function<T,Set<S> >f){
		return ls.stream().flatMap(t -> f.apply(t).stream()).collect(toSet());
	}*/

/*4	public static Integer integerTotalPrice1 (List<Apple> apples){
		return apples.stream().mapToInt(a->a.getOrigin().getPrice()).reduce(0,Integer::sum);
	}
	
	public static Integer integerTotalPrice2 (List<Apple> apples){
		return apples.stream().mapToInt(a->a.getOrigin().getPrice().intValue()).sum();
	}*/
	
/*5	public static int totalNumberStalls(List<Apple> apples){
		return apples.stream()
							.flatMap(a->a.getOrigin().getDestinations().stream())
							.distinct()
							.mapToInt(Market::getnStalls)
							.sum();
	}*/
	
/*	public static Map <Character,List<Apple>> initial (List<Apple> apples){
		//return apples.stream().collect(Collectors.<Apple,?,Map<Character,List<Apple>>>groupingBy(aq))
		return apples.stream().collect(groupingBy(a->a.getOrigin().getNom().charAt(0)));
	}
	
	public static Map <Character,List<Apple>> initialPrices (List<Apple> apples){
		//return apples.stream().collect(Collectors.<Apple,?,Map<Character,List<Apple>>>groupingBy(aq))
		return apples.stream()
				.collect(groupingBy(a->a.getOrigin().getNom().charAt(0),
						summingInt(a -> a.getOrigin().getPrice())
						);
	}*/
	
/*7	public static Map<String,List<Apple>> mapDestinations (List<Apple> apples){
		return apples.stream().collect(groupingBy())
	}*/
	
/*8	public static Stream<Apple> randomApples(Farm origin){
		return generate(() -> new Apple (new Random(1000).nextInt(),"Rouge"),origin));
	}*/
	
	public static Stream<Apple> randomApples(Farm origin){
		return generate(() -> new Apple (new Random().nextInt(1000),"Rouge"),origin));
	}
	
	public static List<Apple> firstTen (List<Farm> origins){
		return origins.stream()
					.flatMap(o -> randomApples(o).filter(a->a.getWeight()<200).limit(10))
					.sorted(Comparator.comparingInt(Apple::getWeight))
					.collect(toList());
	}
	
	public static void main(String[] args) {
		
		Market market = new Market("java",3);
		List<Market> markets = new ArrayList<Market>(Arrays.asList(market));
		
		Farm farm = new Farm(2,3,markets);
		List<Farm> farms = new ArrayList<Farm>(Arrays.asList(farm));
		
		Apple apple = new Apple(2,"orange",farm);
		List<Apple> apples = new ArrayList<Apple>(Arrays.asList(new Apple(2,"orange",farm)));
		
		//1&2 colors(apples);
		//3 destinationCities(apples);
		
	}
}
