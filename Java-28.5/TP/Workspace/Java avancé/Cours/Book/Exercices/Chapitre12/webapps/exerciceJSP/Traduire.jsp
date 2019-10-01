<!-- 
#	Le livre de Java 1er langage
#	A. Tasso
#	Chapitre 12 : Java et Internet
#	Exercice : 12.3
#	Fichier  : Traduire.jsp
-->
<html>
<head>
<title>Un JSP pour traduire une phrase </title>
</head>
<body>
<%
	String p = request.getParameter("phrase");
	if ( p != null ) {
		p = p.replace('a', '*');
		p = p.replace('o', '!');
		p = p.replace('e', '%');
%>
<P> J'ai compris : <%=p%> </P>
<%
	}	else {
%>
<P> Erreur  : Vous avez oublié la phrase à traduire <BR>  
Exemple : http://localhost:8080/exerciceJSP/Traduire.jsp?phrase="petit a petit l'oiseau ... " </P>
<%
	}
%>
</body>
</html>
