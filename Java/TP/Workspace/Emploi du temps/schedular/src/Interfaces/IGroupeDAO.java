/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Entities.Groupe;
import java.util.List;

/**
 *
 * @author hajji
 */
public interface IGroupeDAO {
    boolean insertGroupe(Groupe g);

    boolean updateGroupe(Groupe g);

    boolean deleteGroupeById(int id);

    Groupe findGroupeById(int id);

    int findGroupeByLibelle(String libelle);

    List<Groupe> displayAllGroupe();
}
