package modele;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Formatage_Date {
	
	
	public static String mettredateenformepourstockage(Date date){
		String DateFinale;
		DateFormat shortDateFormat = DateFormat.getDateTimeInstance(
				DateFormat.SHORT,
				DateFormat.MEDIUM);
		DateFinale=shortDateFormat.format(date);
		return DateFinale;
	}

	public static String mettre_en_forme_date(String date){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy hh:mm:ss");
		Date d = null;
		try {
			d = sdf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		SimpleDateFormat sdf1 = new SimpleDateFormat("'Le ' dd/MM/yy ' a ' hh:mm:ss ' : '");
		String date_finale = sdf1.format(d);
		return date_finale;
	}

	public static int recuperer_heure(String date) throws ParseException{

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy hh:mm:ss");
		Date d = sdf.parse(date);

		Calendar cal =Calendar.getInstance();
		cal.setTime(d);
		int heure = cal.get(Calendar.HOUR);
		
	
		
		return heure;
	}
	public static int recuperer_minutes(String date) throws ParseException{

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy hh:mm:ss");
		Date d = sdf.parse(date);

		Calendar cal =Calendar.getInstance();
		cal.setTime(d);
		int minute = cal.get(Calendar.MINUTE);

	
		return minute;
	}
	public static int recuperer_secondes(String date) throws ParseException{

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy hh:mm:ss");
		Date d = sdf.parse(date);
	
		Calendar cal =Calendar.getInstance();
		cal.setTime(d);
		int seconde = cal.get(Calendar.SECOND);
	
	
		return seconde;
	}

	public static int recuperer_jour(String date) throws ParseException{

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy hh:mm:ss");
		Date d = sdf.parse(date);
		Calendar cal =Calendar.getInstance();
		cal.setTime(d);
		int jour = cal.get(Calendar.DAY_OF_MONTH);
		return jour;
	}
	public static int recuperer_mois(String date) throws ParseException{

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy hh:mm:ss");
		Date d = sdf.parse(date);
		Calendar cal =Calendar.getInstance();
		cal.setTime(d);
		int mois = cal.get(Calendar.MONTH);
		return mois;
	}
	public static int recuperer_annee(String date) throws ParseException{

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy hh:mm:ss");
		Date d = sdf.parse(date);
		Calendar cal =Calendar.getInstance();
		cal.setTime(d);
		int year = cal.get(Calendar.YEAR);
		return year;
	}
	public static Boolean recupererles30derniersjours(String date) throws ParseException{
		//On recupere seulement les 30 derniers jours pour tracer le graph du totalportefeuille
		Boolean format=false;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy hh:mm:ss");
		Date d = sdf.parse(date);
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, -1);
		Date moisprecedent = cal.getTime();
		if( moisprecedent.before(d)){

			format=true;
		}
		return format;
	}
	public static Boolean recuperer7derniersjours(String date) throws ParseException{
		Boolean format=false;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy hh:mm:ss");
		Date d= sdf.parse(date);
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH,-7);
		Date semainederniere = cal.getTime();
		if(semainederniere.before(d)){
			format=true;
		}
		return format;

	}
	public static Boolean recuperer24dernieresheures(String date) throws ParseException{
		//On recupere seulement les 30 derniers jours pour tracer le graph du totalportefeuille
		Boolean format=false;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy hh:mm:ss");
		Date d = sdf.parse(date);
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, -1);
		
		Date jourprecedent = cal.getTime();
		if( jourprecedent.before(d)){

			format=true;
		}
		return format;
	}
	
	public static Boolean date_avant_datedepart(String date,String date_depart){
		Boolean format=false;
		//System.out.print("date_depart"+date_depart);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date date_depart_formatee=null;
		
		try {
			date_depart_formatee = sdf.parse(date_depart);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("date_depart_formatee :"+date_depart_formatee);
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yy");
		Date date_a_recup = null;
		try{
			date_a_recup=sdf1.parse(date);
		}catch(ParseException e ){
			e.printStackTrace();
		}
		//System.out.println("date a recup : "+date_a_recup);
		if(date_a_recup.after(date_depart_formatee)){
			format = true;
			//System.out.println("date_a_recup "+date_a_recup+" est plus recente que date_depart_formatee "+date_depart_formatee+"");
		}
		
		return format;
	}
}
