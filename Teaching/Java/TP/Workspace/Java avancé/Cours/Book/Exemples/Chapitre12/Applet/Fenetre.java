/*
#	Le livre de Java 1er langage
#	A. Tasso
#	Chapitre 12 : Java et Internet
#	Section  : Une application côté client : l'applet
#	Fichier  : Fenetre.java
#	Class    : Fenetre
*/

import java.awt.*;
import java.applet.*;
public class Fenetre extends Applet {
	public	final static int HT = 300;
        public 	final static int LG = 300;

        public void init()	{
           Dessin D;
	   setSize(HT, LG);     // taille de la fenetre
	   setBackground(Color.darkGray);
           setLayout(new BorderLayout());
 	   add(D = new Dessin(), "Center"); 
           add(new DesBoutons(D), "South"); 

	}
}