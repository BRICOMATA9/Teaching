package Interface;

import java.awt.*;
import javax.swing.*;
import java.lang.*;
import java.net.*;

public class Windows extends JFrame // La classe Windows etend la classe JFrame
{
		private int largeur = 500; // La variable longueur recoit la largeur de la fenetre
		private int longueur = 600; // La variable largeur recoit la longueur de la fenetre
		public BarreMenus menuBar;//L'attribut menuBar contient la Bar de menu
    public Windows(String titre,URL image) // Le constructeur Windows prend en argument le titre de la fenetre 
    {
        super(titre); // Le titre de la fenetre recoit l'argument en entre
        setSize(new Dimension(largeur ,longueur)); // On donne une dimension a la fenetre  
        setResizable(false); //On desactive le redimensionnement de la fenetre pour fixe la taille de l'image    
        menuBar = new BarreMenus(this);// On insere une barre de menu
        getContentPane().add(new ShowImage(image,largeur ,longueur));
        //On insere aussi une image indentifier par un chemin et on lui donne la longueur et la largeur de la fenetre
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        setVisible (true);// On active l'affichage de la fenetre 
    }  		
}
