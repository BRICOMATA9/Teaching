package vue;

import java.util.Scanner;
import modele.*;

public class LabyConsole {
	Scanner in = new Scanner(System.in); // lire au clavier

	public String lireFichier() {
		String s;
		s = in.next();
		return "labyrinthe.txt";
	}

	public char menu() {
		String choix;
		System.out.println("1 Déplacer automatique en profondeur");
		System.out.println("2 Déplacer aléatoire");
		System.out.println("0 Quitter");

		Scanner sc = new Scanner(System.in);
		System.out.println("Entrez votre choix :");
		choix = sc.next();

		return choix.charAt(0);
	}

	public void affiche(Case c) {
		System.out.println("ligne = " + c.getPositionY() + " colonne=" + c.getPositionX());
	}

	public void affiche(Labyrinthe laby) {
		// Lire les cases du labyrinthe
		for (int y = 0; y < laby.getTailleY(); y++) { // lignes
			for (int x = 0; x < laby.getTailleX(); x++) {
				Case c = laby.getCase(y, x);
				if (c instanceof CaseMur) {
					System.out.print("/");
				} else {
					if (c.getVisited()) {
						System.out.print("+");
					} else {
						System.out.print("-");
					}
				}
			}
			System.out.println();
		}
	}
}
