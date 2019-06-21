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
public class Salle {
    private int id;
    private String type;
    private String libelle;
    private Salle successeur;
    private Salle predecesseur;
    private int capacite;

    public Salle(int id, String type, String libelle, Salle successeur, Salle predecesseur, int capacite) {
        this.id = id;
        this.type = type;
        this.libelle = libelle;
        this.successeur = successeur;
        this.predecesseur = predecesseur;
        this.capacite = capacite;
    }

    public Salle(String type, String libelle, Salle successeur, Salle predecesseur, int capacite) {
        this.type = type;
        this.libelle = libelle;
        this.successeur = successeur;
        this.predecesseur = predecesseur;
        this.capacite = capacite;
    }

    public Salle() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Salle getSuccesseur() {
        return successeur;
    }

    public void setSuccesseur(Salle successeur) {
        this.successeur = successeur;
    }

    public Salle getPredecesseur() {
        return predecesseur;
    }

    public void setPredecesseur(Salle predecesseur) {
        this.predecesseur = predecesseur;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    @Override
    public String toString() {
        return   libelle;
    }

    
    
}
