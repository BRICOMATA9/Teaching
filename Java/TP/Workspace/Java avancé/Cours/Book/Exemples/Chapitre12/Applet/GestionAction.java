/*
#	Le livre de Java 1er langage
#	A. Tasso
#	Chapitre 12 : Java et Internet
#	Section  : Une application côté client : l'applet
#	Fichier  : GestionAction.java
#	Class    : GestionAction
*/

import java.awt.*;
import java.awt.event.*;
public class GestionAction implements ActionListener {
 private int quelBouton;
 private Dessin d;

 public GestionAction( int numero, Dessin d) {
  quelBouton = numero;
  this.d = d;
 }

 public void actionPerformed(ActionEvent e) {
  switch (quelBouton) {
   case 2 : System.exit(0);
   break;
   case 1 :  d.nouveau();
   break;
  }                
 }
}