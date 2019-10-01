package facade.MakeTeaFacade;

public class TeaInfuser {
    private static final int INFUSE_TIME = 5;
	private Tea tea;
	
	public void addTea(Tea tea) {
        int x = 0;
		this.tea = tea;
        
		System.out.print("Adding " + tea.getflavor() + " to the infuser for 5 seconds");
		try { 
            while (x < INFUSE_TIME) {
                System.out.print(".");
                Thread.sleep(1000);
                x++;
            }
        } catch (InterruptedException ie) { }
        finally {
            System.out.println();
        }
	}

}
