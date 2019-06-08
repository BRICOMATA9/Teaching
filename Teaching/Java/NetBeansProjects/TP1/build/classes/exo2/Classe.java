package exo2;

import java.util.*;

public class Classe {

    private ArrayList<Etudiant> liste;

    public Classe() {
        liste = new ArrayList<Etudiant>();
    }

    public void ajouteUnEtudiant() {
        liste.add(new Etudiant());
    }

    public void afficheLesEtudiants() {
        int nbEtudiants = liste.size();
        if (nbEtudiants > 0) {
            for (Etudiant e : liste) {
                System.out.println(e);
//                e.afficheUnEtudiant();
            }
        } else {
            System.out.println("Il n'y a pas d'etudiant dans cette liste");
        }
    }
}
