/*
#	Le livre de Java 1er langage
#	A. Tasso
#	Chapitre 12 : Java et Internet
#	Section  : Une application côté client : l'applet
#	Fichier  : GestionFenetre.java
#	Class    : GestionFenetre
*/

import java.awt.event.*;

public class GestionFenetre extends WindowAdapter {
   public void windowClosing(WindowEvent e) {
	 System.exit(0);
   }
}