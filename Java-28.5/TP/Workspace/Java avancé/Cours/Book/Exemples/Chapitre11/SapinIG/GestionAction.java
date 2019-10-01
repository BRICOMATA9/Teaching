/*
#	Le livre de Java 1er langage
#	A. Tasso
#	Chapitre 11 : Dessiner des objets
#	Section  : Les événements
#	Fichier  : GestionAction.java
#	Class    : GestionAction
*/
import java.awt.*;
import java.awt.event.*;
public class GestionAction implements ActionListener {
 private int n;
 private Dessin d;
 public GestionAction( int n, Dessin d) {
	this.n = n;
	this.d = d;
 }
 public void actionPerformed(ActionEvent e) {
	switch (n)  {
		case 2 : System.exit(0);
		break;
		case 1 :  d.nouveau();
		break;
	} 
 }
}