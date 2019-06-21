/*
#	Le livre de Java 1er langage
#	A. Tasso
#	Chapitre 12 : Java et Internet
#	Section  : Exercice 12.2
#	Fichier  : Traduction.java
#	Class    : Traduction
*/

import java.io.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Traduire extends HttpServlet {
	public void doGet( HttpServletRequest req, HttpServletResponse rep)
	throws IOException, ServletException {
		rep.setContentType("text/html");
		PrintWriter pw = rep.getWriter();
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title> Une servlet pour traduire </title>");
		pw.println("</head>");
		pw.println("<body bgcolor='white'>");
		if (req.getParameter("phrase") == null) {
			pw.print("<font size=+1> ");		
			pw.println("Je n'ai pas de phrase à traduire!</font>");
		}
		else {
			String phrase = req.getParameter("phrase");
			phrase = phrase.replace('a', '*');
			phrase = phrase.replace('o', '!');
			phrase = phrase.replace('e', '%');
			pw.println("J'ai compris :" + phrase);
		}
		pw.println("</body>");
		pw.println("</html>");
	}
	public void doPost( HttpServletRequest req, HttpServletResponse rep)
	throws IOException, ServletException {
		rep.setContentType("text/html");
		PrintWriter pw = rep.getWriter();
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title> Une servlet pour traduire </title>");
		pw.println("</head>");
		pw.println("<body bgcolor='white'>");
		if (req.getParameter("phrase") == null) {
			pw.print("<font size=+1> ");		
			pw.println("Je n'ai pas de phrase à traduire!</font>");
		}
		else {
			String phrase = req.getParameter("phrase");
			phrase = phrase.replace('a', '*');
			phrase = phrase.replace('o', '!');
			phrase = phrase.replace('e', '%');
			pw.println("J'ai compris :" + phrase);
		}
		pw.println("</body>");
		pw.println("</html>");
	 }
}