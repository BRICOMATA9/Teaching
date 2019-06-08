import java.util.*;
import java.util.function.Function;
import java.util.stream.*;

import static java.util.stream.Collectors.*;
import static java.util.stream.Stream.*;
import static java.util.Comparator.*;


public class Exo1 {

	//Questions 1,2,3

	public static <T,S> Set<S> mapToSet (List<T> ls,Function<T,S> f) {
		return ls.stream()
				.map(f)
				.collect(toSet());
	}

	//Question 1

	public static Set<String> colors (List<Apple> apples) {
		return mapToSet (apples,Apple::getColor);
	}
    
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

			System.out.println(colors(new ArrayList<Apple>(Arrays.asList(a1,a2,a3))));

    }    
    
}
