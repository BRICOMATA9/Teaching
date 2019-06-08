package Random;

public class Congruential implements RandomSequence {

	private int max;

	public Congruential (int max) {
		this.max=max;
	}

	public int congruential(int max) {
		int number = 0;

		java.util.Random randomNumber = new java.util.Random();
		number = 1+ (int)(max * randomNumber.nextFloat());

		return number;
	}

	public int getNext() {
		return congruential(max);
	}
}

