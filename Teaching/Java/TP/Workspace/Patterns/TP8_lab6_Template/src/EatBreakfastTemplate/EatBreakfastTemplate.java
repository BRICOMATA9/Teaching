package EatBreakfastTemplate;

public class EatBreakfastTemplate {
	public static void main(String[] args) {

		AbstractBreakaFast temp1 = new Omelette();
		temp1.templateMethod(2);

		System.out.println("");		

		AbstractBreakaFast temp2 = new SunnySide();
		temp2.templateMethod(3);

		System.out.println("");
		

		AbstractBreakaFast temp3 = new ScrambledEggs();
		temp3.templateMethod(1);
	}
}
