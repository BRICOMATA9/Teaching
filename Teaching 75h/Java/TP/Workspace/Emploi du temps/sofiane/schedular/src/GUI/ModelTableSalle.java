/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Salle;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hajji
 */
public class ModelTableSalle {
    DefaultTableModel m;

    public ModelTableSalle() {
        m= new DefaultTableModel();
    }

    public void addColumn(String column)
    {
        m.addColumn(column);
    }
    
    public void addRow(Salle s)
    {
        m.addRow(new Object[]{s.getId(),s.getLibelle(),s.getType(),s.getCapacite()});
    }
    
    public DefaultTableModel Get()
    {
        return m;
    }
}
