package facade.MakeTeaFacade;

public class TeaCup {
	public static final int DEFAULT_STEEP = 60;
	
	private TeaInfuser infuser;
	private Water water;
	private int steepTime = DEFAULT_STEEP;
	
	public void infuseTea(TeaInfuser infuser) {
		this.infuser = infuser;
	}
	
	public void addWater(Water water) {
		this.water = water;
	}
	
	public void setSteepTime(int steepTime) {
		this.steepTime = steepTime;
	}
	
	public void steep() {
        int x = 0;
        
		System.out.print("Steeping tea for " + steepTime + " seconds");
		try {
            while (x < steepTime) {
                System.out.print(".");
                x++;
                Thread.sleep(1000);
            }
			
		}
		catch (InterruptedException ie) { }
        finally { System.out.println(); }
		
		System.out.println("Your tea is ready to drink!");
	}
	

}
