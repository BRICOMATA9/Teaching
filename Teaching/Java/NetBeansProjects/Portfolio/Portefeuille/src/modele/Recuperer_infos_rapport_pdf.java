package modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import com.lowagie.text.Anchor;
import com.lowagie.text.BadElementException;
import com.lowagie.text.Chapter;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.List;
import com.lowagie.text.ListItem;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Section;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class Recuperer_infos_rapport_pdf  {

	private static ResultSet rs;
	
	private static Statement st=SQLiteJDBC.connexionbddSQLITE();

	
	
	public static String recupererdate(String jour, String mois, int annee) {
		
		Date date1 = null;
		String date=jour+"/"+mois+"/"+annee;
		SimpleDateFormat fm = new SimpleDateFormat("dd/mm/yyyy");
		try {
			 date1 = fm.parse(date);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		
		return date;
	}


// -------------------------------  Recuperer informations par utilisateurs	--------------------------------//
	
	public static Paragraph informations_par_utilisateurs(String date_depart){
		//ON crée un chapitre qui va contenir un paragraphe par utilisateur
		Chapter  chapitre = new Chapter(2);
		Paragraph user= new Paragraph();
		ArrayList<String> userlist = liste_utilisateurs();
		Font gras =new Font(Font.HELVETICA  , 15, Font.BOLD| Font.ITALIC);
		
		for (int i=0;i<userlist.size();i++){
			//On ajoute un paragraphe pour chaque utilisateur au chapitre
			//chapitre.add(recuperer_infos_entreprises(userlist.get(i),date_depart));
			
			user.add(new Paragraph(userlist.get(i),gras));
			Rapport_PDF.addEmptyLine(user, 1);
			//chapitre.add(user);
			Paragraph alertes  = (recuperer_alertes(userlist.get(i),date_depart));
			Paragraph entreprises_risque =recuperer_entreprises_a_risque(userlist.get(i),date_depart);
			Paragraph ventes =recuperer_ventes(userlist.get(i),date_depart);
			Paragraph achats = recuperer_achats(userlist.get(i),date_depart);
			
			if((alertes.isEmpty()==true)&&(entreprises_risque.isEmpty()==true)&&(ventes.isEmpty()==true)&&(achats.isEmpty()==true)){
					
			
				user.add("Pas d'activite pendant cette periode");
				Rapport_PDF.addEmptyLine(user, 2);
			}
			else{
				user.add(alertes);
				user.add(entreprises_risque);
				user.add(ventes);
				user.add(achats);
			}
			
			}
		
		
		return user;
		
	}

	
	private static Paragraph recuperer_alertes(String utilisateur,String date_depart){
		//ArrayList<String> liste_alertes = new ArrayList<String>();
		Paragraph paragraphe_alertes = new Paragraph();
		//System.out.println("    date_depart   :  "+date_depart);
		//Recuperer alertes de aujourd'hui à date_dépar
		
		
		String sql="SELECT * FROM `tableau_alertes` WHERE `Utilisateur`='"+utilisateur+"'";
		try {
			rs=st.executeQuery(sql);
			
			
			
			while(rs.next()){
				String date = rs.getString("Date");	
				
				if(Formatage_Date.date_avant_datedepart(date, date_depart)==true){
					String entreprise = rs.getString("Entreprise");
					int valeur_alerte= rs.getInt("valeur_alerte");
					String date1 =""+date+"";
					String phrase ="Mise en place d'une alerte sur "+entreprise+" pour "+floor(valeur_alerte,2) +" euros";
					
						
					paragraphe_alertes.add(date1);
					Rapport_PDF.addEmptyLine(paragraphe_alertes, 1);
					paragraphe_alertes.add(phrase);
					Rapport_PDF.addEmptyLine(paragraphe_alertes, 1);
					
					//liste_alertes.add(date1);
					//liste_alertes.add(phrase);
					
				}
	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(" paragraphe_alertes  de"+utilisateur+": "+ paragraphe_alertes);
		
		return paragraphe_alertes ;
	}
	
	private static Paragraph recuperer_entreprises_a_risque(String utilisateur,String date_depart){
		//ArrayList<String> liste_entreprises_a_risque = new ArrayList<String>();
		Paragraph paragraphe_entreprises_a_risque = new Paragraph();
		//System.out.println("    date_depart   :  "+date_depart);
		//Recuperer alertes de aujourd'hui à date_dépar
	
		
		String sql="SELECT * FROM `Tableau_entreprises_a_risque` WHERE `Utilisateur`='"+utilisateur+"'";
		try {
			rs=st.executeQuery(sql);
			
			while(rs.next()){
				String date = rs.getString("Date");	
				if(Formatage_Date.date_avant_datedepart(date, date_depart)==true){
					String entreprise = rs.getString("Entreprise");
					String date1 =""+date+"";
					String phrase ="Signalement de "+entreprise+" comme etant a risque";
					
					paragraphe_entreprises_a_risque.add(date1);
					Rapport_PDF.addEmptyLine(paragraphe_entreprises_a_risque, 1);
					paragraphe_entreprises_a_risque.add(phrase);
					Rapport_PDF.addEmptyLine(paragraphe_entreprises_a_risque, 1);
					
					//liste_entreprises_a_risque.add(date1);
					//liste_entreprises_a_risque.add(phrase);
					
				}
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		System.out.println(" paragraphe_entreprises_a_risque de "+utilisateur+" : "+ paragraphe_entreprises_a_risque);

		return paragraphe_entreprises_a_risque;
}
	private static Paragraph recuperer_ventes(String utilisateur, String date_depart){
		//ArrayList<String> liste_ventes = new ArrayList<String>();
		Paragraph paragraphe_ventes = new Paragraph();
		//System.out.println("    date_depart   :  "+date_depart);
		//Recuperer alertes de aujourd'hui à date_dépar
		
		
		String sql="SELECT * FROM `Tableau_achat_vente` WHERE `Utilisateur`='"+utilisateur+"'";
		try {
			rs=st.executeQuery(sql);
			
			while(rs.next()){
				String date = rs.getString("Date");	
				String type=rs.getString("Type_transaction");
				if((Formatage_Date.date_avant_datedepart(date, date_depart)==true)&&(type.equals("Vente"))){
					String entreprise = rs.getString("Entreprises");
					int nombre_actions=rs.getInt("nombre_actions");
					
					String date1 =""+date+"";
					String phrase=" Vente de "+nombre_actions+" actions de "+entreprise +"";
					
					paragraphe_ventes.add(date1);
					Rapport_PDF.addEmptyLine(paragraphe_ventes, 1);
					paragraphe_ventes.add(phrase);
					Rapport_PDF.addEmptyLine(paragraphe_ventes, 1);
				
				}
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		System.out.println(" paragraphe_ventes  de "+utilisateur+" : "+ paragraphe_ventes);
	
		return paragraphe_ventes ;
	}
	private static Paragraph recuperer_achats(String utilisateur, String date_depart){
		//ArrayList<String> liste_ventes = new ArrayList<String>();
		Paragraph paragraphe_achats = new Paragraph();
		//System.out.println("    date_depart   :  "+date_depart);
		//Recuperer alertes de aujourd'hui à date_dépar
		
		
		String sql="SELECT * FROM `Tableau_achat_vente` WHERE `Utilisateur`='"+utilisateur+"'";
		try {
			rs=st.executeQuery(sql);
			
			while(rs.next()){
				String date = rs.getString("Date");	
				String type=rs.getString("Type_transaction");
				if((Formatage_Date.date_avant_datedepart(date, date_depart)==true)&&(type.equals("Achat"))){
					String entreprise = rs.getString("Entreprises");
					int nombre_actions=rs.getInt("nombre_actions");
					
					String date1 =""+date+"";
					String phrase=" Achat de "+nombre_actions+" actions de "+entreprise +" ";
				
					paragraphe_achats.add(date1);
					Rapport_PDF.addEmptyLine(paragraphe_achats, 1);
					paragraphe_achats.add(phrase);
					Rapport_PDF.addEmptyLine(paragraphe_achats, 1);
					
					
				}
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		//System.out.println(" paragraphe_achats  de "+utilisateur+" : "+ paragraphe_achats);
	
		return paragraphe_achats;
	}
	
	
/* --------------------------------------- Recuperer par entreprises ------------------------------------------
/-------------------------------------------------------------------------------------------------------------	
--------------------------------------------------------------------------------------------------------*/
	
	
	public static Paragraph informations_par_entreprise(String date_depart){
		Paragraph paragraphe_entreprise = new Paragraph();
		ArrayList<String> liste_entreprises = liste_entreprises();
		
		
		for(int i=0;i<liste_entreprises.size();i++){
			
			paragraphe_entreprise.add(recuperer_alertes_par_entreprise(liste_entreprises.get(i),date_depart));
			paragraphe_entreprise.add(recuperer_entreprises_a_risque_par_entreprise(liste_entreprises.get(i),date_depart));
			paragraphe_entreprise.add(recuperer_ventes_par_entreprise(liste_entreprises.get(i),date_depart));
			paragraphe_entreprise.add(recuperer_achats_par_entreprise(liste_entreprises.get(i),date_depart));
			
		}
				
		
		
		return paragraphe_entreprise;
		
	}
	
	private static Paragraph recuperer_alertes_par_entreprise(String entreprise,String date_depart){
		Paragraph paragraphe_alertes = new Paragraph();
		//System.out.println("    date_depart   :  "+date_depart);
		//Recuperer alertes de aujourd'hui à date_départ
		
		
		String sql="SELECT * FROM `tableau_alertes` WHERE `Entreprise`='"+entreprise+"'";
		try {
			rs=st.executeQuery(sql);
			
			
			
			while(rs.next()){
				String date = rs.getString("Date");	
				if(Formatage_Date.date_avant_datedepart(date, date_depart)==true){
					String utilisateur = rs.getString("Utilisateur");
					int valeur_alerte= rs.getInt("valeur_alerte");
					String date1 =""+date+"";
					String phrase =utilisateur+" a mis en place une alerte sur "+entreprise+" pour "+floor(valeur_alerte,2) +" euros";
				
					paragraphe_alertes.add(date1);
					Rapport_PDF.addEmptyLine(paragraphe_alertes, 1);
					paragraphe_alertes.add(phrase);
					Rapport_PDF.addEmptyLine(paragraphe_alertes, 1);
					
					
				}
	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(" paragraphe_alertes sur:"+entreprise+" : "+ paragraphe_alertes);
		
		return paragraphe_alertes ;
	}
	
	private static Paragraph recuperer_entreprises_a_risque_par_entreprise(String entreprise,String date_depart){
		//ArrayList<String> liste_entreprises_a_risque = new ArrayList<String>();
		Paragraph paragraphe_entreprises_a_risque = new Paragraph();
		//System.out.println("    date_depart   :  "+date_depart);
		//Recuperer alertes de aujourd'hui à date_dépar
	
		
		String sql="SELECT * FROM `Tableau_entreprises_a_risque` WHERE `Entreprise`='"+entreprise+"'";
		try {
			rs=st.executeQuery(sql);
			
			while(rs.next()){
				String date = rs.getString("Date");	
				if(Formatage_Date.date_avant_datedepart(date, date_depart)==true){
					String utilisateur = rs.getString("Utilisateur");
					String date1 =""+date+"";
					String phrase =utilisateur+"a signale l'entreprise "+entreprise+" comme etant a risque";
				
					paragraphe_entreprises_a_risque.add(date1);
					Rapport_PDF.addEmptyLine(paragraphe_entreprises_a_risque, 1);
					paragraphe_entreprises_a_risque.add(phrase);
					Rapport_PDF.addEmptyLine(paragraphe_entreprises_a_risque, 1);
					
					
					
				}
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		System.out.println(" paragraphe_entreprises_a_risque de "+entreprise+" : "+ paragraphe_entreprises_a_risque);

		return paragraphe_entreprises_a_risque;
}
	private static Paragraph recuperer_ventes_par_entreprise(String entreprise, String date_depart){
	
		Paragraph paragraphe_ventes = new Paragraph();
		//System.out.println("    date_depart   :  "+date_depart);
		//Recuperer alertes de aujourd'hui à date_dépar
		
		
		String sql="SELECT * FROM `Tableau_achat_vente` WHERE `Entreprises`='"+entreprise+"'";
		try {
			rs=st.executeQuery(sql);
			
			while(rs.next()){
				String date = rs.getString("Date");	
				String type=rs.getString("Type_transaction");
				if((Formatage_Date.date_avant_datedepart(date, date_depart)==true)&&(type.equals("Vente"))){
					String utilisateur = rs.getString("Utilisateur");
					int nombre_actions=rs.getInt("nombre_actions");
					
					String date1 =""+date+"";
					String phrase=utilisateur+" a vendu  "+nombre_actions+" de "+entreprise +"";
					
					paragraphe_ventes.add(date1);
					Rapport_PDF.addEmptyLine(paragraphe_ventes, 1);
					paragraphe_ventes.add(phrase);
					Rapport_PDF.addEmptyLine(paragraphe_ventes, 1);
					
					
					
				}
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		System.out.println(" paragraphe_ventes  de "+entreprise+" : "+ paragraphe_ventes);
	
		return paragraphe_ventes ;
	}
	
	private static Paragraph recuperer_achats_par_entreprise(String entreprise, String date_depart){
		//ArrayList<String> liste_ventes = new ArrayList<String>();
		Paragraph paragraphe_achats = new Paragraph();
		//System.out.println("    date_depart   :  "+date_depart);
		//Recuperer alertes de aujourd'hui à date_dépar
		
		
		String sql="SELECT * FROM `Tableau_achat_vente` WHERE `Entreprises`='"+entreprise+"'";
		try {
			rs=st.executeQuery(sql);
			
			while(rs.next()){
				String date = rs.getString("Date");	
				String type=rs.getString("Type_transaction");
				if((Formatage_Date.date_avant_datedepart(date, date_depart)==true)&&(type.equals("Achat"))){
					String utilisateur = rs.getString("Utilisateur");
					int nombre_actions=rs.getInt("nombre_actions");
					
					String date1 =""+date+"";
					String phrase=utilisateur+" a acheter "+nombre_actions+" actions de "+entreprise +" ";
					
					paragraphe_achats.add(date1);
					Rapport_PDF.addEmptyLine(paragraphe_achats, 1);
					paragraphe_achats.add(phrase);
					Rapport_PDF.addEmptyLine(paragraphe_achats, 1);
					
					
					
				}
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		System.out.println(" paragraphe_achats  de "+entreprise+" : "+ paragraphe_achats);
	
		return paragraphe_achats;
	}
	
	
	
	
	
	
	
	public static ArrayList<String> liste_entreprises(){
		ArrayList<String> liste_nom_entreprises = new ArrayList<String>();
		String sql ="SELECT * FROM `Liste_Entreprises_Yahoo_CAC40`";		
		try {
			rs=st.executeQuery(sql);
			while(rs.next()){
				String entreprise=rs.getString("Entreprises");
				if(liste_nom_entreprises.contains(entreprise)==false){
					liste_nom_entreprises.add(entreprise);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return liste_nom_entreprises;
	}
	
	
	public static ArrayList<String> liste_utilisateurs(){
		ArrayList<String> userlist = new ArrayList<String>();
		
		String sql1="SELECT * FROM `Tableau_Utilisateurs`";
		try {
			rs=st.executeQuery(sql1);
			while(rs.next()){
				String utilisateur = rs.getString("Utilisateurs");
				userlist.add(utilisateur);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("userlist : "+userlist);
		
		return userlist;
	}
	public static double floor(double a, int n) {
		double p = Math.pow(10.0, n);
		return Math.floor((a*p)+0.5) / p;
	}
}
