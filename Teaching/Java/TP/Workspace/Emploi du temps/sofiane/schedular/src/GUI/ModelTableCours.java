/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Cours;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hajji
 */
public class ModelTableCours {
       DefaultTableModel m;

    public ModelTableCours() {
        m= new DefaultTableModel();
    }

    public void addColumn(String column)
    {
        m.addColumn(column);
    }
    
    public void addRow(Cours c)
    {
        m.addRow(new Object[]{});
    }
    
    public DefaultTableModel Get()
    {
        return m;
    }
}
