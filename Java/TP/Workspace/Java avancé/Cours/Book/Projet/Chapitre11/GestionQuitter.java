/*
#	Le livre de Java 1er langage
#	A. Tasso
#	Chapitre 11 : Dessiner des objets
#	Section  : Projet  - Les types utilisés dans cette applications sont définis dans le répertoire commun
#	Fichier  : GestionQUitter.java
#	Class    : GestionQuitter
*/

import java.awt.event.*;

public class GestionQuitter extends WindowAdapter implements ActionListener {
 
  public void actionPerformed(ActionEvent e) {
   System.exit(0);
 }
  public void windowClosing(WindowEvent e) {
   System.exit(0);
 }
}