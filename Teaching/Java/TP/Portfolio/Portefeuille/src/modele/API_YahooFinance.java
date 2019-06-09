package modele;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.histquotes.HistoricalQuote;
import yahoofinance.histquotes.Interval;

public class API_YahooFinance {



	public static String recuperernom(String identreprise) throws IOException{

		Stock stocksymbole=YahooFinance.get(identreprise);
		String nomentreprise=stocksymbole.getName();
		return nomentreprise;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static ArrayList<Double> recupererhistorique(String identreprise) throws IOException{
		ArrayList liste= new ArrayList();
		//On recupere la date d'ajourdhui avec un Calendar.

		GregorianCalendar calendar = new GregorianCalendar(Locale.FRANCE);	
		int mois_dernier = (calendar.get((Calendar.MONTH)))-1;
		int anneeactuelle = calendar.get(Calendar.YEAR);
		int jour_actuel = calendar.get(Calendar.DAY_OF_MONTH);
		GregorianCalendar calendrier = new GregorianCalendar(anneeactuelle,mois_dernier,jour_actuel);

		Stock google = YahooFinance.get(identreprise,calendrier,Interval.DAILY);

		List<HistoricalQuote> googleHistQuotes = google.getHistory();
		for (int i=0;i<googleHistQuotes.size();i++){
			liste.add(googleHistQuotes.get(i).toString());  
		}

		return liste;
	}



	public static Double valeuraction(String identreprise) throws IOException{
		Stock stock = YahooFinance.get(identreprise);
		BigDecimal price = stock.getQuote().getPrice();
		double pricedouble = price.doubleValue();

		return pricedouble;
	}

}
