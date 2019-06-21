package facade.MakeTeaFacade;

public class TeaFacade {
	private TeaCup blueCup;
	private Water water;
	private TeaInfuser infuser;
	private Tea tea;

	public TeaFacade (TeaCup blueCup,Water water,TeaInfuser infuser) {
		this.blueCup = blueCup;
		this.water = water;
		this.infuser = infuser;
	}

	public void makeTea(String teaType) {
		this.tea = new Tea("Earl Grey");
/*		
		Runnable runnable = new Runnable() { 
			public void run() { 
				infuser.addTea(tea);
			}
		};
		Thread t3 = new Thread(runnable);
		t3.start();
*/

		this.infuser.addTea(this.tea);
		this.water.boilWater();
		this.blueCup.addWater(this.water);
		this.blueCup.setSteepTime(15);
		this.blueCup.steep();
	}
}
