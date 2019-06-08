/*
#	Le livre de Java 1er langage
#	A. Tasso
#	Chapitre 12 : Java et Internet
#	Section  : ... et des JavaBeans
#	Fichier  : CercleBean.java
#	Class    : CercleBean
*/
package librairieDeBean ;

import java.io.Serializable;
public class CercleBean		implements java.io.Serializable {

	private int  rayon ;
	private double perimetre;
	public void setRayon(int r){
		rayon = r;
	}
	public int getRayon(){
		return rayon;
	}
	public double getPerimetre() {
		perimetre = 2*Math.PI*rayon;
		return perimetre;
	}
} // Fin de Bean Cercle