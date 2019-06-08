/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author hajji
 */
public class Cours {
    private int id;
    private Groupe groupe;
    private Enseignant enseignant;
    private String matiere;
    private Creneau creneau;

    public Cours(int id, Groupe groupe, Enseignant enseignant, String matiere, Creneau creneau) {
        this.id = id;
        this.groupe = groupe;
        this.enseignant = enseignant;
        this.matiere = matiere;
        this.creneau = creneau;
    }

    public Cours(Groupe groupe, Enseignant enseignant, String matiere, Creneau creneau) {
        this.groupe = groupe;
        this.enseignant = enseignant;
        this.matiere = matiere;
        this.creneau = creneau;
    }

    public Cours() {
    }

    public Cours(Groupe groupe, Enseignant enseignant, String matiere) {
        this.groupe = groupe;
        this.enseignant = enseignant;
        this.matiere = matiere;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Groupe getGroupe() {
        return groupe;
    }

    public void setGroupe(Groupe groupe) {
        this.groupe = groupe;
    }

    public Enseignant getEnseignant() {
        return enseignant;
    }

    public void setEnseignant(Enseignant enseignant) {
        this.enseignant = enseignant;
    }

    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }
    
}
