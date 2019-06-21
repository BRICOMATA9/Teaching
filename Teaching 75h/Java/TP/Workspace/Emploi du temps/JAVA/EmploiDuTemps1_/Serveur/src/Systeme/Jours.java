package Systeme;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.*;

public class Jours implements Serializable{
	
	
	private Date jour1;
	private Date jour2;
	private Date jour3;
	private Date jour4;
	private Date jour5;
	static final SimpleDateFormat formatsemaine =  new SimpleDateFormat("w",new Locale("fr","FR"));
	static final SimpleDateFormat formatjour =  new SimpleDateFormat("EEEE dd/MM",new Locale("fr","FR"));
	TimeZone cet = TimeZone.getTimeZone( "CET" );

	public Jours(GregorianCalendar maintenant){	
		formatsemaine.setTimeZone(cet);
		formatjour.setTimeZone(cet);
		maintenant.setFirstDayOfWeek(GregorianCalendar.MONDAY);
		/* Trouver le premier jour (sa date) de la semaine */
		if (maintenant.get(GregorianCalendar.DAY_OF_WEEK)>6){
			maintenant.add(GregorianCalendar.DAY_OF_WEEK,(+9-maintenant.get(GregorianCalendar.DAY_OF_WEEK)));
		}
		else {

			maintenant.add(GregorianCalendar.DAY_OF_WEEK,+2-maintenant.get(GregorianCalendar.DAY_OF_WEEK));
		}
	
		jour1 = maintenant.getTime();
		maintenant.add(GregorianCalendar.DAY_OF_WEEK,+1);
		jour2 = maintenant.getTime();
		maintenant.add(GregorianCalendar.DAY_OF_WEEK,+1);
		jour3 = maintenant.getTime();
		maintenant.add(GregorianCalendar.DAY_OF_WEEK,+1);
		jour4 = maintenant.getTime();
		maintenant.add(GregorianCalendar.DAY_OF_WEEK,+1);
		jour5 = maintenant.getTime();
	}
	/**
	 * Méthode qui retourne le premier jour, lundi
	 * @return jour1 - java.util.Date
	 */
	public Date getJour1() {
		return jour1;
	}
	/**
	 * Méthode qui retourne le deuxième jour, mardi
	 * @return jour2 - java.util.Date
	 */
	public Date getJour2() {
		return jour2;
	}
	/**
	 * Méthode qui retourne le troisième jour, mercredi
	 * @return jour3 - java.util.Date
	 */
	public Date getJour3() {
		return jour3;
	}
	/**
	 * Méthode qui retourne le quatrième jour, jeudi
	 * @return jour4 - java.util.Date
	 */
	public Date getJour4() {
		return jour4;
	}
	/**
	 * Méthode qui retourne le cinquième jour, vendredi
	 * @return jour5 - java.util.Date
	 */
	public Date getJour5() {
		return jour5;
	}
	/**
	 * Méthode qui prend en paramètre le numéro du jour (1-5) et renvoi la date
	 * @param i - int
	 * @return Date - java.util.Date
	 */
	public Date getJours(int i)
	{
		Date d=null;
		switch (i)
		{
			case 1: d=jour1;break;
			case 2:d=jour2;break;
			case 3:d=jour3;break;
			case 4:d=jour4;break;
			case 5:d=jour5;break;
		}
		return d;
	}
	/**
	 * Méthode qui retourne le premier jour en format texte (en francais)
	 * @return jour1 - String 
	 */
	public String getStringJour1() {
		return formatjour.format(jour1);
	}
	/**
	 * Méthode qui retourne le deuxième jour en format texte (en francais)
	 * @return jour2 - String 
	 */
	public String getStringJour2() {
		return formatjour.format(jour2);
	}
	/**
	 * Méthode qui retourne le troisième jour en format texte (en francais)
	 * @return jour3 - String 
	 */
	public String getStringJour3() {
		return formatjour.format(jour3);
	}
	/**
	 * Méthode qui retourne le quatrième jour en format texte (en francais)
	 * @return jour4 - String 
	 */
	public String getStringJour4() {
		return formatjour.format(jour4);
	}
	/**
	 * Méthode qui retourne le cinquième jour en format texte (en francais)
	 * @return jour5 - String 
	 */
	public String getStringJour5() {
		return formatjour.format(jour5);
	}
	/**
	 * Méthode qui retourne le numéro de semaine en format texte
	 * @return semaine - String 
	 */
	public String getStringSemaine() {
		return formatsemaine.format(jour1);
	}
	/**
	 * Méthode qui retourne le numéro de semaine d'après en format texte
	 * @return semaine - String 
	 */
	public String getStringSemaineproch() {
		
		return Integer.toString(Integer.parseInt(formatsemaine.format(jour1))+1);
	}
	/**
	 * Méthode qui retourne le numéro de semaine précédente en format texte
	 * @return semaine - String 
	 */
	public String getStringSemaineprec() {
		
		return Integer.toString(Integer.parseInt(formatsemaine.format(jour1))-1);
	}
}

