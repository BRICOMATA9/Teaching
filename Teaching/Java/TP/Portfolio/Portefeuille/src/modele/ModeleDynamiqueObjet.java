package modele;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.ListIterator;

import javax.swing.table.AbstractTableModel;

import org.jfree.data.time.Day;
import org.jfree.data.time.Second;

import controleur.Graphique_journalier_totalportefeuille;
import controleur.Graphique_mensuel_totalportefeuille;
import vue.Panel_interface;


public class ModeleDynamiqueObjet extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	public final static ArrayList< Portefeuille> Portefeuille = new ArrayList< Portefeuille>();
	private final String[] entetes = {"Entreprises","ID YahooFinance", "Quantite", "valeur unitaire","Total","Alertes","Risques"};
	@SuppressWarnings("rawtypes")
	private static  ArrayList liste_resume_achatvente = new ArrayList();
	public final static Timer_rafraichissement timer = new Timer_rafraichissement();
	static Calendar calendar = new GregorianCalendar();
	static Date date=new Date();
	public static ArrayList<Integer> row_a_colorier= new ArrayList<Integer>();
	public static ArrayList<String> entreprise_color = new ArrayList<String>();
	public static ArrayList<Integer> ligne_a_risque = new ArrayList<Integer>();

	public ModeleDynamiqueObjet() {
		super();

	}
	public int getRowCount() {
		return Portefeuille.size();
	}

	public int getColumnCount() {
		return entetes.length;
	}

	public String getColumnName(int columnIndex) {
		return entetes[columnIndex];
	}

	public void addLigne(Portefeuille value) {
		Portefeuille.add(value);
		int rowIndex = Portefeuille.size()-1;
		fireTableRowsInserted(rowIndex, rowIndex);
	}


	public Class<?> getColumnClass(int column) {
		return getValueAt(0, column).getClass();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void remplirarraylistavecentreprisesdutableau(ArrayList arraylist){
		for(int i=0;i<Panel_interface.tableau.getRowCount();i++){
			arraylist.add(Panel_interface.tableau.getValueAt(i, 0));
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void remplirarraylistavecIDdutableau(ArrayList arraylist){
		for(int i=0;i<Panel_interface.tableau.getRowCount();i++){
			arraylist.add(Panel_interface.tableau.getValueAt(i,1));
		}
	}


	public static String recupererIDavecnomentreprise(String nomentreprise){
		String IDentreprise = null;
		for(int i=0;i<Panel_interface.tableau.getRowCount();i++){
			if(Panel_interface.tableau.getValueAt(i, 0).equals(nomentreprise)){
				IDentreprise = Panel_interface.tableau.getValueAt(i, 1).toString();
			}
		}
		return IDentreprise;
	}


	public static String recuperernomavecIDentreprise(String IDentreprise){
		String nomentreprise = null;
		for(int i=0;i<Panel_interface.tableau.getRowCount();i++){
			if(Panel_interface.tableau.getValueAt(i, 1).equals(IDentreprise)){
				nomentreprise = Panel_interface.tableau.getValueAt(i, 0).toString();
			}
		}
		return nomentreprise;
	}
	public static void mettretotalportefeuilledanslabel(){
		Panel_interface.label_total_portefeuille.setText("Total Portefeuille : "+ floor(calcultotalportefeuille(),2) + " euros");;
	}

	public static void rafraichirtotalportefeuille(){
		Panel_interface.totalportefeuille = floor(calcultotalportefeuille(),2);
		Panel_interface.label_total_portefeuille.setText("Total Portefeuille : "+ Panel_interface.totalportefeuille + " euros");
		Date date = new Date();
		DateFormat shortDateFormat = DateFormat.getDateTimeInstance(
				DateFormat.SHORT,
				DateFormat.MEDIUM);

		Gestion_base_de_donnee.stockertotaldansbase(shortDateFormat.format(date), Panel_interface.totalportefeuille);
		Graphique_journalier_totalportefeuille.s1.addOrUpdate(new Second(),Panel_interface.totalportefeuille);
		Graphique_mensuel_totalportefeuille.s1_mensuel.addOrUpdate(new Day(),Panel_interface.totalportefeuille);
	}

	public static double calcultotalportefeuille(){
		double total = 0;
		for (int i=0;i<Panel_interface.tableau.getRowCount();i++){
			double t = Double.parseDouble(Panel_interface.tableau.getValueAt(i, 4).toString().replace("euros", ""));
			total += t;
			//System.out.println("total"+total);
		}
		return total;	
	}

	public static double floor(double a, int n) {
		double p = Math.pow(10.0, n);
		return Math.floor((a*p)+0.5) / p;
	}


	public  void removePortefeuille(int rowIndex) {
		Portefeuille.remove(rowIndex);
		fireTableRowsDeleted(rowIndex, rowIndex);

	}
	@SuppressWarnings("unchecked")
	public static void updatehistoriqueachatvente(String resume){
		Panel_interface.modelelistehistorique.clear();
		liste_resume_achatvente.add(resume);
		Panel_interface.modelelistehistorique.removeAllElements();
		ListIterator<String> iterator = liste_resume_achatvente.listIterator(liste_resume_achatvente.size());
		while(iterator.hasPrevious()){
			String item = iterator.previous();
			Panel_interface.modelelistehistorique.addElement(item);
		} 
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		switch(columnIndex){
		case 0:
			return Portefeuille.get(rowIndex).getNom();
		case 1:
			return Portefeuille.get(rowIndex).getID();
		case 2:
			return Portefeuille.get(rowIndex).getnombre_actions();
		case 3:
			return Portefeuille.get(rowIndex).getvaleur_action();
		case 4 : 
			return Portefeuille.get(rowIndex).getTotal();

		default:
			return null; //Ne devrait jamais arriver
		}
	}

	public void setValueAt(Object value, int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			Portefeuille.get(rowIndex).setNom((String) value);
			fireTableCellUpdated(rowIndex, 0);
			break;
		case 1:
			Portefeuille.get(rowIndex).setID((String) value);
			fireTableCellUpdated(rowIndex, 1);
			break;
		case 2:
			Portefeuille.get(rowIndex).setnombre_actions((int) value);
			fireTableCellUpdated(rowIndex, 2);
			break;
		case 3:
			Portefeuille.get(rowIndex).setvaleur_action((String) value);
			fireTableCellUpdated(rowIndex, 3);
			break;
		case 4 :
			Portefeuille.get(rowIndex).setTotal((String) value);
			fireTableCellUpdated(rowIndex, 4);
			break;
		

		}

	}
}