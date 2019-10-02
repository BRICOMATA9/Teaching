
public abstract class Forme {

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
	System.out.println("Le centre de cette forme est :"+toString());	
}
public abstract double surface();

public abstract double perimetre();

/*public double perimetre() {
	return 0;
}
public double surface() {
	return 0;
}*/


}
