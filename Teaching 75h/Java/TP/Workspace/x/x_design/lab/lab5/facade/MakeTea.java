/**
 * Put the kettle on and we'll all have tea.
 */

public class MakeTea {
	public static void main(String[] args) {
		TeaCup blueCup = new TeaCup();
		Water water = new Water();
		TeaInfuser infuser = new TeaInfuser();
		Tea tea = new Tea("Earl Grey");
		
		infuser.addTea(tea);
		
		water.boilWater();
		
		blueCup.addWater(water);
		
		blueCup.setSteepTime(15);
		
		blueCup.steep();
	}

}
