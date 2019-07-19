<!-- 
#	Le livre de Java 1er langage
#	A. Tasso
#	Chapitre 12 : Java et Internet
#	Section  : De l'utilité du langage JSP
#	Fichier  : Expression.jsp
-->

<HTML>

<head>
<title>Expression.jsp</title>
</head>

<BODY>

<%-- Déclaration de la fonction perimetre() --%> 
<%! public double perimetre(int rayon) { return 2*Math.PI*rayon;} %>

<%-- Exemple d'une expression simple --%> 
3 * 7 = <%= 3 * 7 %> <BR>

<%-- Exemple d'une expression utilisant la fonction perimetre() --%> 
Le perimetre vaut <%= perimetre(5)%>

</BODY>
</HTML> 
