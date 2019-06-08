package geometrie;


public class Cercle extends Forme implements Perimsurf{
	private double  rayon;
	public Cercle(Point centre,double rayon){
	  super(centre);this.rayon=rayon;
	}
	public void setRayon(double rayon){
		this.rayon=rayon;
	}
	public double getRayon(){
		return rayon;
	}
	public boolean  estDansCercle(Point p){
		return  (p.getx()*p.getx() + p.gety()*p.gety() ) <= rayon*rayon;
	}

	public double surface(){
		return 3.14*rayon*rayon;
	}

	public double perimetre(){
		return 2*3.14*rayon;
	}
	public void afficheForme(){
		super.afficheForme();System.out.print("Cercle - ") ; 
	}

}
