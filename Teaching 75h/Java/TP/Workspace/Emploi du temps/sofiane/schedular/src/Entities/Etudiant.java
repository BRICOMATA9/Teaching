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
public class Etudiant {
    private int id;
    private String nom,prenom,niveau;
    private Groupe groupe;

    public Etudiant(int id, String nom, String prenom, String niveau,Groupe groupe) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.niveau = niveau;
        this.groupe=groupe;
    }

    public Etudiant(String nom, String prenom, String niveau, Groupe groupe) {
        this.nom = nom;
        this.prenom = prenom;
        this.niveau = niveau;
        this.groupe = groupe;
    }

    public Etudiant() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public Groupe getGroupe() {
        return groupe;
    }

    public void setGroupe(Groupe groupe) {
        this.groupe = groupe;
    }
    
}
