package vue;
 
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
 
import javax.swing.JTable;

public class TableMouseListener extends MouseAdapter {
     
    private JTable table;
     
    public TableMouseListener(JTable table) {
        this.table = table;
    }
     
    @Override
    public void mousePressed(MouseEvent event) {

       if(event.getButton()==MouseEvent.BUTTON3){
    	
    	     Point point = event.getPoint();
    	        int currentRow = table.rowAtPoint(point);
    	        table.setRowSelectionInterval(currentRow, currentRow);
    	        table.setComponentPopupMenu( new Jpopupmenu());	
       }
        
        int ligne =table.getSelectedRow();
		String cellule = table.getValueAt(ligne,0).toString();
		if(event.getClickCount()%1 == 0 && event.isPopupTrigger()==false){

			for(int i=0;i<Panel_interface.combo_box_achat_vente.getItemCount();i++){
				if(Panel_interface.combo_box_achat_vente.getItemAt(i).equals(cellule)){
					Panel_interface.combo_box_achat_vente.setSelectedIndex(i);
				}
			}
			String cellules =table.getValueAt(ligne,1).toString();
			Interface_JavaFX_Swing.loadURL("https://fr.finance.yahoo.com/q?s="+ cellules+"#yfi_rt_quote_summary");
		}
    }
}