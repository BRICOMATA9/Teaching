/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Entities.Enseignant;
import Entities.Groupe;
import java.util.List;

/**
 *
 * @author hajji
 */
public interface IEnseignantDAO {
    boolean insertEnseignant(Enseignant e);

    boolean updateEnseignant(Enseignant e);

    boolean deleteEnseignantById(int id);

    Enseignant findEnseignantById(int id);

    int findEnseignantByName(String name);
    
    List<Enseignant> displayGroupEnseignant(Groupe g);

    List<Enseignant> displayAllEnseignant();
}
