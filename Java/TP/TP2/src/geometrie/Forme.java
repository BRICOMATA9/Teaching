package geometrie;


public class Forme {

	protected Point centre;
	public Forme() {
	  centre=new Point(0,0);		
	}
	public Forme(Point centre) {
	this.centre=centre;		
	}
	public String toString(){
		return (centre.toString());
	}
	public void afficheForme(){
		System.out.println("\n\nLe centre de cette forme est :"+toString());	
	}
}
