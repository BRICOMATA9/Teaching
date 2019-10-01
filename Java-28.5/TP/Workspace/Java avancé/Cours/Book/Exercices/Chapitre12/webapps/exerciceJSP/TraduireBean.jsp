<!-- 
#	Le livre de Java 1er langage
#	A. Tasso
#	Chapitre 12 : Java et Internet
#	Exercice : 12.6
#	Fichier  : Livre.jsp
-->
<html>


<head>
<title>Un Java Bean pour traduire une phrase</title>
</head>

<body>

<jsp:useBean id="P"  class="librairieDeBean.Phrase"/>
<jsp:setProperty name="P" property="phrase" param="param"/>
<BR>J'ai compris : <jsp:getProperty name="P" property="phrase" /> 
</body>
</html>
