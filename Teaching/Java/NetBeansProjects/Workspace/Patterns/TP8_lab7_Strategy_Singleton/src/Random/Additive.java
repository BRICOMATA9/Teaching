package Random;

public class Additive implements RandomSequence {

	private int max;

	public Additive (int max) {
		this.max=max;
	}

	public int linear(max)  {
		int number = 0;

		java.util.Random randomNumber = new java.util.Random();
		number = 1+ (int)(max * randomNumber.nextFloat());

		return number;
	}

	public int getNext() {
		return linear(3);
	}
}
