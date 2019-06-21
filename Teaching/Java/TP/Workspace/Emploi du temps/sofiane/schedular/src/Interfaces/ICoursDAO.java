/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Entities.Cours;
import java.util.List;

/**
 *
 * @author hajji
 */
public interface ICoursDAO {
    boolean insertCours(Cours c);

    boolean updateCours(Cours c);

    boolean deleteCoursById(int id);

    Cours findCoursById(int id);

    int findCoursByLibelle(String libelle);

    List<Cours> displayAllCours();
}
