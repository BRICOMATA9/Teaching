package bdd;

import java.io.Serializable;
import java.sql.Time;
import java.util.GregorianCalendar;

/**
 * Classe Creneau qui contient la date, l'heure du début, la durée et donc l'heure de la fin du créneau.
 * @author Tonya Vo Thanh & Alexander Remen
 *
 */
public class Creneau implements Serializable{

	public static final int AVANT = 0;
	public static final int APRES = 1;
	public static final int ERREUR = 2;
	private GregorianCalendar  Datedebut; //contient date et heure début
    private Time Duree;
	
    
	/**
	 * Constructeur d'un créneau
	 * @param jour - au format dd/mm/yyyy
	 * @param heureDeb - au format hh:mm
	 * @param duree - au format hh:mm
	 * @throws Exception 
	 */
	public Creneau (String jour, String heureDeb, String duree) throws Exception
	{
		String tmpJ [] = jour.split("/");
		if (tmpJ.length!=3) throw new Exception("Creation creneau : Erreur format date");
		String tmpH [] = heureDeb.split(":");
		if (tmpH.length!=2) throw new Exception("Creation creneau : Erreur format heure début");
		String tmpD [] = duree.split(":");
		if (tmpD.length!=2) throw new Exception("Creation creneau : Erreur format duree");
		
		int month = Integer.parseInt(tmpJ[1]);
		//if(month==12) month=0;
		month--;
		Datedebut = new GregorianCalendar (Integer.parseInt(tmpJ[2]),month, Integer.parseInt(tmpJ[0]), Integer.parseInt(tmpH[0]), Integer.parseInt(tmpH[1]));
		Duree = Time.valueOf(duree+":00");
	}
	/**
	 * Méthode qui retourne la date en String
	 * @return la date en String
	 */
	public String date() {
		int month = Datedebut.get(GregorianCalendar.MONTH);
		//if(month==0) month=12;
		month++;
		return Datedebut.get(GregorianCalendar.DAY_OF_MONTH)+"/"+month+"/"+Datedebut.get(GregorianCalendar.YEAR);
	}
	/**
	 * Méthode qui retourne l'heure en String
	 * @return l'heure du début du créneau
	 */
	public String heure() {
		int minute = Datedebut.get(GregorianCalendar.MINUTE);
		String min=""+minute;
		if(minute<10)min="0"+minute;
		return Datedebut.get(GregorianCalendar.HOUR_OF_DAY)+":"+min;
	}
	/**
	 * Méthode qui retourne l'heure de la fin du créneau en String
	 * @return l'heure de la fin du créneau en String
	 */
	public String heureFin()
	{
		int heure = (Datedebut.get(GregorianCalendar.HOUR_OF_DAY)+Duree.getHours());
		int minutes = Datedebut.get(GregorianCalendar.MINUTE)+Duree.getMinutes();
		if(minutes>60)
		{
			minutes=minutes-60;
			heure++;
		}
		String min=""+minutes;
		if(minutes<10)min="0"+minutes;
		
		
		return heure+":"+min;		
	}
	/**
	 * Méthode qui retourne la durée en String
	 * @return la durée en String
	 */
	public String duree() {
		return Duree.toString().substring(0, 5);
	}
	
	/**
	 * Méthode qui retourne la date en GregorianCalendar
	 * @return la date en GregorianCalendar
	 */
	public GregorianCalendar getDate()
	{
		return new GregorianCalendar(Datedebut.get(GregorianCalendar.YEAR),Datedebut.get(GregorianCalendar.MONTH),Datedebut.get(GregorianCalendar.DAY_OF_MONTH));
	}
	
	/**
	 * Méthode qui retourne la date debut en GregorianCalendar
	 * @return la date en GregorianCalendar
	 */
	public GregorianCalendar getDatedebut() {
		return Datedebut;
	}

	/**
	 * Méthode qui configure la date
	 * @param datedebut la datedebut à mettre
	 */
	public void setDatedebut(GregorianCalendar datedebut) {
		Datedebut = datedebut;
	}

	/**
	 * Méthode qui retourne la durée
	 * @return la durée
	 */
	public Time getDuree() {
		return Duree;
	}

	/**
	 * Méthode pour configurer la durée du creneau
	 * @param duree la durée à configurer
	 */
	public void setDuree(Time duree) {
		Duree = duree;
	}
	
	/**
	 * Méthode qui renvoit la date en string
	 * @param date
	 * @return le string de la date
	 */
	public static String DatetoString(GregorianCalendar date) {
		int month = date.get(GregorianCalendar.MONTH);
		month++;
		int minute = date.get(GregorianCalendar.MINUTE);
		String min=""+minute;
		if(minute<10)min="0"+minute;
		return date.get(GregorianCalendar.DAY_OF_MONTH)+"/"+month+"/"+date.get(GregorianCalendar.YEAR)+" "+date.get(GregorianCalendar.HOUR_OF_DAY)+":"+min;
	}

	/**
	 * Méthode qui retourne la Date fin
	 * @return la date fin
	 */
	public GregorianCalendar getDateFin()
	{
		int heure = (Datedebut.get(GregorianCalendar.HOUR_OF_DAY)+Duree.getHours());
		int minutes = Datedebut.get(GregorianCalendar.MINUTE)+Duree.getMinutes();
		if(minutes>60)
		{
			minutes=minutes-60;
			heure++;
		}
		GregorianCalendar DateFin = new GregorianCalendar(Datedebut.get(GregorianCalendar.YEAR),Datedebut.get(GregorianCalendar.MONTH),Datedebut.get(GregorianCalendar.DAY_OF_MONTH),heure,minutes);
		
		return DateFin;
	}
	
	/**
	 * Méthode qui compare le créneau à un autre
	 * @param c créneau à comparer
	 * @return Creneau.ERREUR si c'est en même temps, Creneau.AVANT si c'est avant, Creneau.APRES si c'est apres 
	 */
	public int compare(Creneau c)
	{		
		int retour=ERREUR;
		
		if((this.Datedebut.before(c.getDatedebut())) && (this.getDateFin().before(c.getDatedebut())))
		{
				retour=AVANT;			
		}
		else if((this.Datedebut.after(c.getDatedebut()))&& (this.Datedebut.after(c.getDateFin()))) 
		{
			retour=APRES;
		}
		return retour;
	}
	
	/**
	 * Méthode qui retourne true si c'est vrai, false si c'est pas vrai
	 * @param creneau le creneau à comparer
	 * @return true si ils sont égaux, false si ils ne sont pas égaux
	 */
	public boolean egal(Creneau creneau) {
		Boolean ok = true;
		if(Datedebut.compareTo(creneau.getDatedebut())!=0) ok=false;
		if(Duree.compareTo(creneau.getDuree())!=0) ok= false;
		return ok;
	}
	
}
