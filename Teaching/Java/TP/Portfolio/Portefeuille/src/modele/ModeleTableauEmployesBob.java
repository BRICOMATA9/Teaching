package modele;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.event.RowSorterEvent;
import javax.swing.event.RowSorterListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;


public class ModeleTableauEmployesBob extends AbstractTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String[] columnNames = {"Classement", "Employes", "Gain", "Valeur du Portefeuille"};
	private List<TableauEmployesBob> listEmployees;

	public ModeleTableauEmployesBob(List<TableauEmployesBob> listEmployees) {
		this.listEmployees = listEmployees;

		int indexCount = 1; 
		for (TableauEmployesBob employee : listEmployees) {
			employee.setIndex(indexCount++);
		}
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return listEmployees.size();
	}

	@Override
	public String getColumnName(int columnIndex) {
		return columnNames[columnIndex];
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		if (listEmployees.isEmpty()) {
			return Object.class;
		}
		return getValueAt(0, columnIndex).getClass();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		TableauEmployesBob employee = listEmployees.get(rowIndex);
		Object returnValue = null;

		switch (columnIndex) {
		case 0:
			returnValue = employee.getIndex();
			break;
		case 1:
			returnValue = employee.getEmployes();
			break;
		case 2:
			returnValue = employee.getGain();
			break;
		case 3:
			returnValue = employee.getValeur_portefeuille();
			break;
		default:
			throw new IllegalArgumentException("Invalid column index");
		}

		return returnValue;
	}

	@Override
	public void setValueAt(Object value, int rowIndex, int columnIndex) {
		TableauEmployesBob employee = listEmployees.get(rowIndex);
		if (columnIndex == 0) {
			employee.setIndex((int) value);
		}		
	}


	public static void MettreTriEnPlace(JTable table){
		table.setAutoCreateRowSorter(true);
		TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
		table.setRowSorter(sorter);
		List<RowSorter.SortKey> sortKeys = new ArrayList<>();				
		sortKeys.add(new RowSorter.SortKey(2, SortOrder.DESCENDING));
		sortKeys.add(new RowSorter.SortKey(1, SortOrder.DESCENDING));
		sorter.setSortKeys(sortKeys);
		sorter.addRowSorterListener(new RowSorterListener() {
			@Override
			public void sorterChanged(RowSorterEvent evt) {

				for (int i = 0; i < table.getRowCount(); i++) {
					table.setValueAt(i + 1, i, 0);
				}
			}
		});
		sorter.setSortable(0, false);
		sorter.setComparator(1, new Comparator<String>() {
			@Override
			public int compare(String name1, String name2) {
				return name1.compareTo(name2);
			}
		});
		sorter.sort();
	}
}
