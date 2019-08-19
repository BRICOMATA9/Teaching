/*
#	Le livre de Java 1er langage
#	A. Tasso
#	Chapitre 12 : Java et Internet
#	Section  : Une application côté serveur : la servlet
#	Fichier  : CalculPerimetre.java
#	Class    : CalculPerimetre
*/
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class CalculPerimetre extends HttpServlet {
    public void doGet( HttpServletRequest req, HttpServletResponse rep)
	        throws IOException, ServletException {
	 rep.setContentType("text/html");
	 PrintWriter pw = rep.getWriter();
	 pw.println("<html>");
	 pw.println("<head>");
	 pw.println("<title> Une toute première servlet </title>");
	 pw.println("</head>");
	 pw.println("<body bgcolor='white'>");
	 if (req.getParameter("rayon") == null) {
		pw.print("<font size=+1> ");		
		pw.println("J'ai besoin de connaitre la valeur du rayon !</font>");
	 }
	 else {
		int tmp=Integer.parseInt(req.getParameter("rayon"));
		Cercle C = new Cercle(0, 0, tmp);
		double p = C.périmètre();
		pw.println("Le cercle de rayon "+tmp+" a pour périmètre "+ p);
	 }
	 pw.println("</body>");
	 pw.println("</html>");
    }
}