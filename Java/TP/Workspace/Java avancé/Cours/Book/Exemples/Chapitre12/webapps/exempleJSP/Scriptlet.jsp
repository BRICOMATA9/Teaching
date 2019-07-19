<!-- 
#	Le livre de Java 1er langage
#	A. Tasso
#	Chapitre 12 : Java et Internet
#	Section  : De l'utilité du langage JSP
#	Fichier  : Scriptlet.jsp
-->

<html>
<head>
<title>Un JSP pour calculer le perimetre d'un cercle</title>
</head>
<body>
<%! int r = -1 ; %> 
<%! public double perimetre(int rayon) { return 2*Math.PI*rayon;} %>

<%-- debut de la scriptlet --%>
<%  
	if ( r == -1 ) {
		out.println("Erreur : <BR> ");
		out.println("La valeur du rayon est négative ! <BR> ");
		out.println("Veuillez réactualiser la page SVP.<BR> ");
	}
	else {
		double p = perimetre(r) ; 
		out.println("Le cercle de rayon "+r+" a pour perimetre "+p); 
	}
        r++ ;
%>
<%-- fin de la scriptlet --%>
</body>
</html>

