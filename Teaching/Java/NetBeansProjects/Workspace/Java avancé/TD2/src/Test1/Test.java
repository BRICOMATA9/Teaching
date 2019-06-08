package Test1;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static <T,S> S methode (T t, Interface<T,S> i) {
		S s=i.f(t);
		return s;
	}
	
	public static void main(String[] args) {
		Market market = new Market("Boumerdes",3);
		List<Market> markets = new ArrayList<Market>();
		markets.add(market);

		Farm farm = new Farm(2,3,markets);
		List<Farm> farms = new ArrayList<Farm>();
		farms.add(farm);

		Apple apple = new Apple(2,"orange",farm);
		List<Apple> apples = new ArrayList<Apple>();
		apples.add(apple);

		System.out.println(methode(apple,a -> a.getOrigin().getDestinations().get(0).getCity()));
	}
}
