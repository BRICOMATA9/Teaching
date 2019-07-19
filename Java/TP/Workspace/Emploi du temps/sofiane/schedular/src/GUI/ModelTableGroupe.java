/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Groupe;
import Entities.Salle;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hajji
 */
public class ModelTableGroupe {
    DefaultTableModel m;

    public ModelTableGroupe() {
        m= new DefaultTableModel();
    }

    public void addColumn(String column)
    {
        m.addColumn(column);
    }
    
    public void addRow(Groupe g)
    {
        m.addRow(new Object[]{g.getId(),g.getLibelle(),g.getListetudiant().size()});
    }
    
    public DefaultTableModel Get()
    {
        return m;
    }
}
