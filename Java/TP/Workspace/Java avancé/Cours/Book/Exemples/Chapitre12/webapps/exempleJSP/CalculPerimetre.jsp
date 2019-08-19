
<!-- 
#	Le livre de Java 1er langage
#	A. Tasso
#	Chapitre 12 : Java et Internet
#	Section  : De l'utilité du langage JSP
#	Fichier  : calculperimetre.jsp
-->

<html>
<head>
<title>Un JSP pour calculer le perimetre d'un cercle</title>
</head>

<body>
<%! public double perimetre(int rayon) { return 2*Math.PI*rayon;} %>


<%  
    String parametre = request.getParameter("rayon");
    if ( parametre != null ) {
      int r=Integer.parseInt(parametre); 
      double p = perimetre(r) ; 
%>
      <P> Le cercle de rayon <%=r%> a pour perimetre <%=p%> </P>
<% 
    }
    else {
%>
      <P> Erreur  : Placez la valeur du rayon en parametre <BR>  
          Exemple : http://localhost:8080/exempleJSP/CalculPerimetre.jsp?rayon=10 </P>
<%
    }
%>



</body>
</html>
