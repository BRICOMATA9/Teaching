/*
#	Le livre de Java, premier langage
#	A. Tasso
#	Chapitre 11 : Dessiner des objets 
#	Exercice   : 11.3 et 11.4 
#	Fichier    : GestionFenetre.java
#	Class      : GestionFenetre
*/

import java.awt.event.*;
public class GestionFenetre extends WindowAdapter{
	public void windowClosing(WindowEvent e) {
	 	System.exit(0);
	}
}