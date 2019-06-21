
public class EatBreakfast {
	public static void main(String[] args) {
		ScrambledEggs scrambled = new ScrambledEggs();
		scrambled.crackEggs(2);
		scrambled.stirEggs();
		scrambled.cooking();
		scrambled.serve();
		
		Omelette omelette = new Omelette();
		omelette.crackingEggs(3);
		omelette.prepareEggs();
		omelette.cook();
		omelette.serve();
		
		SunnySide sunny = new SunnySide();
		sunny.crackEggs(1);
		sunny.prepare();
		sunny.cook();
		sunny.serve();
	}

}
