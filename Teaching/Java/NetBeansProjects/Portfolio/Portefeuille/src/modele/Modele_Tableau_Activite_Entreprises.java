package modele;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;



public class Modele_Tableau_Activite_Entreprises extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	public final static ArrayList< Tableau_Activite_Entreprise> Activite_Entreprise = new ArrayList< Tableau_Activite_Entreprise>();
	private final String[] entetes = {"Activites","Bouton"};


	public Modele_Tableau_Activite_Entreprises() {
		super();

	}
	public int getRowCount() {
		return Activite_Entreprise.size();
	}

	public int getColumnCount() {
		return entetes.length;
	}

	public String getColumnName(int columnIndex) {
		return entetes[columnIndex];
	}

	public void addLigne(Tableau_Activite_Entreprise value) {
		Activite_Entreprise.add(value);
		int rowIndex = Activite_Entreprise.size()-1;
		fireTableRowsInserted(rowIndex, rowIndex);
	}


	public Class<?> getColumnClass(int column) {
		return getValueAt(0, column).getClass();
	}




	public static double floor(double a, int n) {
		double p = Math.pow(10.0, n);
		return Math.floor((a*p)+0.5) / p;
	}


	public  void removePortefeuille(int rowIndex) {
		Activite_Entreprise.remove(rowIndex);
		fireTableRowsDeleted(rowIndex, rowIndex);
	}
	public boolean isCellEditable(int row, int col){
		  //On appelle la méthode getValueAt qui retourne la valeur d'une cellule
		  //Et on effectue un traitement spécifique si c'est un JButton
		  if(getValueAt(0, col) instanceof JButton)
		    return false;
		  return true; 
		}

	public Object getValueAt(int rowIndex, int columnIndex) {
		switch(columnIndex){
		case 0:
			return Activite_Entreprise.get(rowIndex).getActivite();
		case 1:
			return 0;
		default:
			return null; //Ne devrait jamais arriver
		}
	}

	public void setValueAt(Object value, int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			Activite_Entreprise.get(rowIndex).setActivite((String) value);
			fireTableCellUpdated(rowIndex, 0);
			break;
		}
	}
}