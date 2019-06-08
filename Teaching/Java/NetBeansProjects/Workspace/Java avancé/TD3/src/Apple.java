import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Apple {
	private final Integer weight ;
	private final String color ;
	private final Farm origin ;
	
	public Stream<String> getDestinationCities() {
		return origin.getDestinations()
				     .stream()
				     .map(Market::getCity);
	}
	
	public Farm getOrigin() {
		return origin;
	}
	
	public String getColor() {
		return color;
	}
	
	public Integer getWeight() {
		return weight;
	}
	
	public Apple (Integer w, String c, Farm o) {
		weight=w;
		color=c;
		origin=o;
	}
	
	public String toString() {
		return weight+" "+color;
	}
	
}
