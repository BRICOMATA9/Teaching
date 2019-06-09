package Interface;

import Interface.Dialogue;
import java.awt.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.*;
import java.awt.image.BufferedImage;
import java.net.*;

//	Cette classe est untilisé pour afficher une image donnee dans une fenetre 

public class ShowImage extends JPanel {// La classe ShowImage etend la class JPanel 
    private BufferedImage  image; // L'attribut image contiendra l'image a afficher 
    private static int x,y;//Ces variables contiendront la largeur et la longueur de l'image
	

  public ShowImage(URL chemin,int x,int y) { // Le coonstructeur prend en parametre le chemin de l'image sa largeur et sa longueur 
    try { // on essaie d'ouvrire le fichier reference par son chemin
  		//File input = new File(chemin);//On ouvre un fichier qui contient l'image
      image = ImageIO.read(chemin);// On lis le fichier et on met l'image dans l'attribut image
      this.x = x;//On affecte la largeur de l'image a celle entre en argument "x"
      this.y = y;//On affecte la longueur de l'image a celle entre en argument "y"
    } catch (IOException ie) {// Si une erreur survient lors de l'ouverture de l'image on affiche un message d'erreur
      new Dialogue(ie.getMessage());//On affiche une boite de dialogue avec le type d'erreur rencontré
    }
  }

  public void paint(Graphics g) {// cette méthode permet d'afficher le contenu de l'image
    g.drawImage(image, 0, 0, x, y, this);// On affiche l'image a partir du point (0,0) de la fenetre avec une largeur x et une logueur y 
  }
}
