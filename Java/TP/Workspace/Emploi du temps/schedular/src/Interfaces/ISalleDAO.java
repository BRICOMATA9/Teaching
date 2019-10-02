/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Entities.Salle;
import java.util.List;

/**
 *
 * @author hajji
 */
public interface ISalleDAO {

    boolean insertSalle(Salle s);

    boolean updateSalle(Salle s);

    boolean deleteSalleById(int id);

    Salle findSalleById(int id);

    int findSalleByLibelle(String libelle);

    List<Salle> displayAllSalle();
}
