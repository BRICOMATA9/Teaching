/*
#	Le livre de Java, premier langage
#	A. Tasso
#	Chapitre 11 : Dessiner des objets 
#	Exercice   : 11.5 
#	Fichier    : GestionAction.java
#	Class      : GestionAction
*/

import java.awt.event.*;
import javax.swing.*;
public class GestionAction implements ActionListener {
 private int n;
 private DessinFormes d;
 private static int modèle=0;
 private JFrame j;
 public GestionAction( int n, DessinFormes d, JFrame j) {
	this.n = n;
	this.d = d;
 	this.j = j;
 }
 
 public void actionPerformed(ActionEvent e) {
  switch (n)  {
    case 1 : d.deplacerGaucheScene();
    break;
    case 2 : d.deplacerGaucheFormes();
    break;
   }
 }
 
}