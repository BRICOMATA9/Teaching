package controleur;

import java.io.File;
import modele.*;
import vue.LabyConsole;

public class TestLaby {

	private static Labyrinthe laby;
	private static LabyConsole console;

	public TestLaby(File fic) throws FileFormatException {
		laby = new Labyrinthe(fic);
	}

	 //Déplacement récursif en profondeur dans le labyrinthe
	public boolean deplacerDFS(int ligne, int colonne) {
		boolean stop = false;
		Case macase;

		// Si la sortie, on s'arrête
		if (colonne == laby.getArriveeX() && ligne == laby.getArriveeY()) {
			System.out.println("ARRIVEE");
			stop = true;
		} else {
			// visiter la case
			macase = laby.getCase(ligne, colonne);
			macase.setVisited();

			// afficher position de la case visitée et le labyrinthe
			console.affiche(macase);
			console.affiche(laby);

			// visiter récursivemet tous les voisins non marqués de macase
			for (int i = 0; i < macase.getNbVoisins(); i++) {
				Case voisin = macase.getVoisin(i);
				if (!stop && !voisin.getVisited()) {
					stop = deplacerDFS(voisin.getPositionY(), voisin.getPositionX());
				}
			}
		}
		return stop;
	}

	public boolean deplacerAuto() {
		boolean stop = false;
		Case macase;

		while (!stop) {
			try {
				// se déplacer aléatoirement
				laby.autoMove();

				// afficher position de la case visitée et le labyrinthe
				macase = laby.getCase(laby.getCurrentPositionY(), laby.getCurrentPositionX());
				console.affiche(macase);
				console.affiche(laby);
				
				// Si la sortie, on s'arrête
				if (laby.getCurrentPositionX() == laby.getArriveeX() && laby.getCurrentPositionY() == laby.getArriveeY()) {
					System.out.println("ARRIVEE");
					stop = true;
				}
			} catch (ImpossibleMoveException ex) {

			}

		}
		return stop;
	}

	//public void 
	public static void main(String[] args) {
		try {
			// 1 Lire le fichier
			console = new LabyConsole(); //  instancier la console
			System.out.println("Entrez le nom du fichier du labyrinthe :");
			String nomlaby = console.lireFichier(); // récupérer le nom du fichier

			// 2 initialiser le labyrinthe
			TestLaby test;
			test = new TestLaby(new File(nomlaby)); // instancier le labyrinthe à partir du fichier
			console.affiche(laby); // affiche le labyrinthe en console

			// 3 Lancer le jeux
			char choix = console.menu(); // afficher le menu labyrinthe en mode console

			switch (choix) {
				case '1': // en profendeur
					test.deplacerDFS(laby.getDepartY(), laby.getDepartX());
					break;
				case '2': // aléatoire 
					test.deplacerAuto();
					break;
				case '0':
					System.exit(0);
					break;
				default:
					System.out.println("Erreur de choix");
			}
		} catch (FileFormatException ffe) {
			System.out.println("Problème de format du fichier !");
		}
	}
}
