
public class Rectangle extends Quadrilatere {
	private double longueur,largeur;
	public Rectangle(Point a, Point b, Point c, Point d, double longueur, double largeur, Point centre) {   super(a,b,c,d,centre);
		               this.longueur=longueur;
		               this.largeur=largeur;
	}
	public void setLongueur(double longueur){
		this.longueur=longueur;
	}
	public void setLargeur(double largeur){
		this.largeur=largeur;
	}
	public double getLongueur(){
		return longueur;
	}
	public double getLargeur(){
		return largeur;
	}
	public double surface(){
		return longueur*largeur;
	}
	public double perimetre(){
		return (longueur+largeur)*2;
	}
	public void afficheForme(){
		super.afficheForme();System.out.println("Rectangle") ; 
	}

}
