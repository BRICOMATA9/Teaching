package Singleton;

public class MathLibrary {

	private static MathLibrary instance;


	private MathLibrary() {}

	public synchronized static MathLibrary getInstance() {
		if (instance == null)
			instance = new MathLibrary();
		return instance;		
	}

	public int someMathMethod() {
		return -1;
	}
	
	public double anotherMathMethod() {
		return 0;
	}

	public static void main(String[] args) {
		MathLibrary mathLibrary = MathLibrary.getInstance();
		System.out.println(mathLibrary.someMathMethod());
	}
}
