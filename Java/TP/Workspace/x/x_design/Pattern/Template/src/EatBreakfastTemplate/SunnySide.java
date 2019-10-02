package EatBreakfastTemplate;

public class SunnySide extends AbstractBreakaFast {
	public void crackEggs(int n) {
		System.out.println("Cracking " + n + " eggs.");
	}
	
	public void prepare() {
		System.out.println("Never stir sunny side up!");
	}
	
	public void cook() {
		System.out.println("Cooking the eggs sunny side up.");
	}

}
