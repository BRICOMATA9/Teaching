/*
#	Le livre de Java, premier langage
#	A. Tasso
#	Chapitre 11 : Dessiner des objets 
#	Exercice   :  Support pour réaliser l'exercice 11.5 
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
    // si l'utilisateur clique sur le premier bouton, les formes se déplacent sur le bord gauche de la fenêtre
    case 1 : 
    break;
    // si l'utilisateur clique sur le second bouton, les formes s'alignent sur la forme se situant le plus à gauche
    case 2 : 
    break;
   }
 }
 
}