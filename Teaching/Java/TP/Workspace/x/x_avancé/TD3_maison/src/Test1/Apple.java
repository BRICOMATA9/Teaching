package Test1;

import java.util.stream.Stream;

public class Apple {
	private final Integer weight;
	private final String color;
	private final Farm origin;
	
	public Apple (Integer weight, String color, Farm origin){
		this.weight=weight;
		this.color=color;
		this.origin=origin;
	}
	
	public Stream <String> getDestinationCities(){
		return origin.getDestinations().stream().map(Market::getCity);
	}

	public Integer getWeight() {
		return weight;
	}

	public String getColor() {
		return color;
	}

	public Farm getOrigin() {
		return origin;
	}

}
