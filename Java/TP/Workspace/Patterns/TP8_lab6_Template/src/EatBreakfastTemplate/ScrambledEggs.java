package EatBreakfastTemplate;

public class ScrambledEggs extends AbstractBreakaFast {
	public void crackEggs(int num) {
		System.out.println("Cracking " + num + " eggs");
	}
	
	public void prepare() {
		System.out.println("Stirring and adding milk to the eggs");
	}
	
	public void cook() {
		System.out.println("Scrambling the eggs.");
	}

}
