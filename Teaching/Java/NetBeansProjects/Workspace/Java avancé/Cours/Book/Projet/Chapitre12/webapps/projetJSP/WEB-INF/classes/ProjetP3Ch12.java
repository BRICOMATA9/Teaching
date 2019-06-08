/*
#	Le livre de Java 1er langage
#	A. Tasso
#	Chapitre 12 :Java et Internet
#	Section  : Projet  
#	Fichier  : ProjetP3Ch12.java
#	Class    : ProjetP3Ch12
*/

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ProjetP3Ch12 extends HttpServlet {
        Compte C = new Compte(0,"0",'c') ;
	public void doGet( HttpServletRequest req, HttpServletResponse rep) throws IOException, ServletException {
	 String données = "";
	 FileWriter fichier;
	 String mot[] = new String[5], numcpte;
	 double valinit;
	 char type;
	 int nbmot=0, choix = 0;
	 for (Enumeration e = req.getParameterNames(); e.hasMoreElements();)
		données = données + req.getParameter((String)e.nextElement())+';';
	 if (données != null)  {
		StringTokenizer st = new StringTokenizer(données,";");
		int i=0;
		nbmot=st.countTokens();
		mot = new String[nbmot];
		while (st.hasMoreTokens()) {
			mot[i] = st.nextToken();
			if (mot[i].equalsIgnoreCase("creer")) choix=1;
			else if (mot[i].equalsIgnoreCase("afficher")) choix=2;
			i++;
		}
	 }
	 rep.setContentType("text/html");
	 PrintWriter pw = rep.getWriter();
	 pw.println("<html>");
	 pw.println("<head>");
	 pw.println("<title> Gestion de Comptes </title>");
	 pw.println("</head>");
	 pw.println("<body bgcolor='white'>");
	 pw.println("<font face='Arial, Helvetica, sans-serif' size='+1'>");
	 pw.println("Création de compte </font><br><br>");
	 switch (choix)	{
		case 1 :
			if(nbmot > 3) {
				valinit=Double.parseDouble(mot[0]);
				numcpte=mot[1];
				type = mot[3].charAt(0);
				C = new Compte(valinit, numcpte, type) ;  
				pw.println(C.afficherCpte());
			}
			else pw.println("<P> Vous avez oublié de saisir le type du compte ! <BR>");
		break;
		case 2 :
			numcpte=mot[0];
			if(numcpte.compareTo(C.getNuméroCpte()) == 0)
				pw.println(C.afficherCpte()); 
			else pw.println("Ce numéro n'existe pas");
		break;
	 }
	 pw.println("<P><A HREF='http://localhost:8080/projetJSP/CB.html'> Créer un autre compte </A>");
	 pw.println("</body>");
	 pw.println("</html>");
	}
	public void doPost( HttpServletRequest req, HttpServletResponse rep) throws IOException, ServletException {
	}
}
