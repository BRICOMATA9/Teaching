package Exo1;

public class Apple {
	private final Integer weight;
	private final String color;
	private final Farm origin;
	
	public Apple (Integer weight, String color, Farm origin){
		this.weight=weight;
		this.color=color;
		this.origin=origin;
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
