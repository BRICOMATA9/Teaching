<!-- 
#	Le livre de Java 1er langage
#	A. Tasso
#	Chapitre 12 : Java et Internet
#	Section  : ... et des JavaBeans
#	Fichier  : CalculPerimetreBean.jsp
-->
<html>


<head>
<title>Un Java Bean pour calculer le perimetre d'un cercle</title>
</head>

<body>

<jsp:useBean id="C" class="librairieDeBean.CercleBean"/>
<jsp:setProperty name="C" property="rayon" param="r"/>

Le cercle de rayon <jsp:getProperty name="C" property="rayon" /> a un périmètre de <jsp:getProperty name="C" property="perimetre" />
</body>
</html>
