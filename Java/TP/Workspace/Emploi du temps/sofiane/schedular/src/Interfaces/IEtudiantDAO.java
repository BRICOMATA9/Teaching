/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Entities.Etudiant;
import Entities.Groupe;
import java.util.List;

/**
 *
 * @author hajji
 */
public interface IEtudiantDAO {
    
    boolean insertEtudiant(Etudiant e);

    boolean updateEtudiant(Etudiant e);

    boolean deleteEtudiantById(int id);

    Etudiant findEtudiantById(int id);

    int findEtudiantByName(String name);

    List<Etudiant> displayGroupEtudiant(Groupe g);
    
    List<Etudiant> displayAllEtudiant();
}
