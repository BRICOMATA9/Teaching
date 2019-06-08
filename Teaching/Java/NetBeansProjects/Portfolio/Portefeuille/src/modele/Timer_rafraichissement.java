package modele;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.Timer;

import vue.Panel_interface;

public class Timer_rafraichissement {
	static int ligne_a_colorier;
	public static Timer createTimer ()
	{

		ActionListener action = new ActionListener ()
		{
					
			double valeuractionYahoo = 0;
			public void actionPerformed (ActionEvent event)
			{
				
				
				
				
				Gestion_alertes.colorierlignesalerte();	
				Gestion_achatvente_automatique.recupererachatventeautomatique();//recupere les achat/vente automatique dans la bdd et fait l'achat/ la vente si les conditions sont remplies
			
				
				for(int i=0;i<Panel_interface.tableau.getRowCount();i++){
					String ID = Panel_interface.tableau.getValueAt(i,1).toString();
				
					try {
						valeuractionYahoo = ModeleDynamiqueObjet.floor(API_YahooFinance.valeuraction(ID), 3);
					} catch (IOException e) {
						e.printStackTrace();
					}
					String valeuractiontableau1 = (Panel_interface.tableau.getValueAt(i,3).toString());
					valeuractiontableau1 =valeuractiontableau1.replace("euros", "");
					
					double valeuractiontableau =Double.parseDouble(valeuractiontableau1);
					if(valeuractiontableau != valeuractionYahoo){
						//System.out.println("La valeur de l'action de "+Panel_interface.tableau.getValueAt(i,0)+" a changee passant de"+valeuractiontableau+" a "+ valeuractionYahoo);
						
						String valeuractionYahoostring=valeuractionYahoo+"euros";
						Panel_interface.tableau.setValueAt(valeuractionYahoostring, i, 3);
						
						//update total
						String nombreactionstring = (Panel_interface.tableau.getValueAt(i,3).toString());
						nombreactionstring =nombreactionstring.replace("euros", "");
						double nombreaction = Double.parseDouble(nombreactionstring);
						double total = ModeleDynamiqueObjet.floor(nombreaction*valeuractionYahoo, 3);
						String totalstring = (total+"euros");
						Panel_interface.tableau.setValueAt(totalstring,i,4);
						
						Panel_interface.modele.fireTableDataChanged();
						ModeleDynamiqueObjet.rafraichirtotalportefeuille();
					
					}
					
				}
	
			}
		};

		//Le timer tic toutes les 2 minutes (120 secondes = 120 000 millisecondes)
		return new Timer (120000, action);
	} 
}