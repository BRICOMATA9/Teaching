/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Enseignant;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hajji
 */
public class ModelTableEnseignant {
     DefaultTableModel m;

    public ModelTableEnseignant() {
        m= new DefaultTableModel();
    }

    public void addColumn(String column)
    {
        m.addColumn(column);
    }
    
    public void addRow(Enseignant e)
    {
        m.addRow(new Object[]{e.getId(),e.getNom(),e.getPrenom(),e.getSpecialite()});
    }
    
    public DefaultTableModel Get()
    {
        return m;
    }
}
