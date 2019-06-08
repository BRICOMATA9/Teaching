package question3;

import question3.tp3.*;

import java.awt.*;
import javax.swing.*;
import java.util.Observer;
import java.util.Observable;

public class AppletteCalculette extends JApplet {

	public void init() {
		JRootPane rootPane = this.getRootPane();
		rootPane.putClientProperty("defeatSystemEventQueueCheck", Boolean.TRUE);
		
		PileModele<Integer> modele = new PileModele<Integer>(new Pile2<Integer>(5));
		Vue vue = new Vue(modele);
		modele.addObserver(vue);
		Controleur controle = new Controleur(modele);

		setLayout(new GridLayout(2, 1));
		add(vue);
		add(controle);
		setVisible(true);

	}

}
