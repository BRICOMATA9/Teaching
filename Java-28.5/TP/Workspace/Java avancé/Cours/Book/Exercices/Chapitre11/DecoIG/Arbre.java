/*
#	Le livre de Java, premier langage
#	A. Tasso
#	Chapitre 11 : Dessiner des objets 
#	Exercice   : 11.1 et 11.2 
#	Fichier    : Arbre.java
#	Class      : Arbre
*/

import java.awt.*;
class Arbre {
	int [][] sapin ;
	public Arbre(int nl) {  
		int nc = 2*nl-1;
		sapin = new int[nl][nc];
		int milieu = sapin[0].length/2;
		for ( int j = 0 ; j < nl ; j++) {
			for ( int i = -j; i <= j; i++) {
				sapin[j][milieu+i] = (int ) (5*Math.random()+1);
			}
		}	
	}
	public void dessine(Graphics g) {
		Color Vert = Color.green;
		for (int i = 0; i < sapin.length; i++) {	 
			for (int j = 0; j < sapin[0].length; j++) {
				switch(sapin[i][j]) {
					case 1 : Vert = Color.green;
						 new Triangle(i, j, g, Vert);  
					         break;
					case 2 : Vert = Vert.brighter();		
					         new Triangle(i, j, g, Vert);  
					         break;
					case 3 : Vert = Vert.darker();
						 new Triangle(i, j, g, Vert); 
					         break;
					case 4 : Vert = Vert.brighter();
						 new Triangle(i, j, g, Vert);
					         break;
					case 5 : Vert = Vert.darker();
						 new Triangle(i, j, g, Vert); 
					         break;
					case 6 : Vert = Vert.brighter();
						 new Triangle(i, j, g, Vert); 
					         break;
				}
			}
		}
		for (int i = 0; i < sapin.length; i++) 	 
		for (int j = 0; j < sapin[0].length; j++) {
			if (sapin[i][j] == 1)  new Boule(i, j, g);
     }
	}
}
  