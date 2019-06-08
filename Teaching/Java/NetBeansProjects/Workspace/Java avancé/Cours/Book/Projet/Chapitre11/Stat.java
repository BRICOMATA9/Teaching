/*
#	Le livre de Java 1er langage
#	A. Tasso
#	Chapitre 11 : Dessiner des objets
#	Section  : Projet  - Les types utilisés dans cette applications sont définis dans le répertoire commun
#	Fichier  : Stat.java
#	Class    : Stat
*/

import java.awt.*;
public class Stat  {
  Compte cpte;
  private double prctDiv, prctLoy, prctAli;
  public Stat(Compte c) {
	 cpte = c;
	}
	private  double pourcentage(double nb, double t){
		double    prct = 0;
		if (t > 0) prct = (double) nb / t  * 100;
		return prct;
	}
  public void statParMotif() {
		double totCredit=0;
		double totDiv=0, totLoy=0, totAli=0;
		for(int i = 0; i <= cpte.combienLignes() ; i++){
			if (cpte.quelleLigne(i).quelleValeur() > 0) 
				totCredit = totCredit +  cpte.quelleLigne(i).quelleValeur();
			if (cpte.quelleLigne(i).quelMotif().equalsIgnoreCase("Divers"))
				totDiv = totDiv + Math.abs(cpte.quelleLigne(i).quelleValeur());
			if (cpte.quelleLigne(i).quelMotif().equalsIgnoreCase("Loyer"))
				totLoy = totLoy +  Math.abs(cpte.quelleLigne(i).quelleValeur());
			if (cpte.quelleLigne(i).quelMotif().equalsIgnoreCase("Alimentation"))
				totAli = totAli +  Math.abs(cpte.quelleLigne(i).quelleValeur());
		} 
		prctAli = pourcentage(totAli, totCredit);
		prctLoy = pourcentage(totLoy, totCredit);
		prctDiv = pourcentage(totDiv, totCredit);
		System.out.print("A : "+prctAli+ "L : "+prctLoy+ "D : "+prctDiv); 
  }
 public void dessine(Graphics g)  {
		statParMotif();
		g.setColor(Color.darkGray);
		g.drawString("Compte n° : " + cpte.quelNuméroDeCompte(), 100, 50);
		g.drawString("Crédit", 105, 220);
		g.drawString("Débit", 160, 220);
		g.setColor(Color.blue);
	g.fillRect(100,100,50,100);
	int reste = (int) (100 - prctLoy - prctDiv - prctAli);
	g.setColor(Color.green.darker().darker());
		g.fillRect(150,100+reste,50,(int)prctLoy);
		g.drawString("Loyer", 210, 95+(int)prctLoy+reste);
		g.setColor(Color.magenta);
		g.fillRect(150,100+(int)prctLoy+reste,50,(int)prctAli);
		g.drawString("Alimentation", 210, 95+(int)(prctLoy+prctAli)+reste);
		g.setColor(Color.red);
		g.fillRect(150,100+(int)(prctLoy+prctAli)+reste,50,(int)prctDiv);
		g.drawString("Divers", 210, 95+(int)(prctLoy+prctAli+prctDiv)+reste);
	}
}