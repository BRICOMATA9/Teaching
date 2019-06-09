/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.List;

/**
 *
 * @author hajji
 */
public class Groupe {
    private int id;
    private String libelle;
    private List<Etudiant> listetudiant;

    public Groupe(int id, String libelle, List<Etudiant> listetudiant) {
        this.id = id;
        this.libelle = libelle;
        this.listetudiant = listetudiant;
    }

    public Groupe(int id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }

    public Groupe() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public List<Etudiant> getListetudiant() {
        return listetudiant;
    }

    public void setListetudiant(List<Etudiant> listetudiant) {
        this.listetudiant = listetudiant;
    }
    
}
