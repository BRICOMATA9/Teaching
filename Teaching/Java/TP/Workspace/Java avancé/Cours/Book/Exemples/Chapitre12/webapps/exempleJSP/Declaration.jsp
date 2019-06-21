<!-- 
#	Le livre de Java 1er langage
#	A. Tasso
#	Chapitre 12 : Java et Internet
#	Section  : De l'utilité du langage JSP
#	Fichier  : Declaration.jsp
-->
<head> 
<title> Declaration.jsp </title> 
</head>
<HTML> 
<BODY>

<%-- Déclaration d'un entier --%> 
<%! int rayon = 5 ; %>

<%-- Déclaration d'une fonction --%> 
<%! public double perimetre(int r) { return 2*Math.PI*r;} %>

</BODY>
</HTML> 
