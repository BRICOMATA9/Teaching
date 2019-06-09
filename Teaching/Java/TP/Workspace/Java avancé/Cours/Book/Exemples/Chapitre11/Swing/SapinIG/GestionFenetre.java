/*
#	Le livre de Java 1er langage
#	A. Tasso
#	Chapitre 11 : Dessiner des objets
#	Section  : Modifier les modèles de présentation de l'interface
#	Fichier  : GestionFenetre.java
#	Class    : GestionFenetre
*/
import java.awt.event.*;
public class GestionFenetre extends WindowAdapter{
	public void windowClosing(WindowEvent e){
		System.exit(0);
	}
}