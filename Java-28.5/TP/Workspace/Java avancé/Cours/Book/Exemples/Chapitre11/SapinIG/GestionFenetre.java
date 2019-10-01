/*
#	Le livre de Java 1er langage
#	A. Tasso
#	Chapitre 11 : Dessiner des objets
#	Section  : Les événements
#	Fichier  : GestionFenetre.java
#	Class    : GestionFenetre
*/
import java.awt.event.*;
public class GestionFenetre extends WindowAdapter{
	public void windowClosing(WindowEvent e){
		System.exit(0);
	}
}