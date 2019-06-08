/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Etudiant;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hajji
 */
public class ModelTableEtudiant {
    DefaultTableModel m;

    public ModelTableEtudiant() {
        m= new DefaultTableModel();
    }

    public void addColumn(String column)
    {
        m.addColumn(column);
    }
    
    public void addRow(Etudiant e)
    {
        m.addRow(new Object[]{e.getId(),e.getNom(),e.getPrenom(),e.getNiveau(),e.getGroupe().getLibelle()});
    }
    
    public DefaultTableModel Get()
    {
        return m;
    }
}
