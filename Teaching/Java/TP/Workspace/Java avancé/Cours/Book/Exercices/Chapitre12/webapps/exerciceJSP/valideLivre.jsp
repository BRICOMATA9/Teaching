<!-- 
#	Le livre de Java 1er langage
#	A. Tasso
#	Chapitre 12 : Java et Internet
#	Exercice : 12.7
#	Fichier  : ValideLivre.jsp
-->

<jsp:useBean id="livre" class="librairieDeBean.Livre"/>
<!-- On attribue les valeurs passées en POST en initialisant le composant Livre -->

<jsp:setProperty name="livre" property="titre"/>
<jsp:setProperty name="livre" property="categorie"/>
<jsp:setProperty name="livre" property="isbn" param="numero"/>
<jsp:setProperty name="livre" property="nomAuteur" param="nom"/>
<jsp:setProperty name="livre" property="prenomAuteur" param="prenom"/>
<html>
<body>
<h1><font face=arial>Validation d'un livre</h1>
<hr>

<h3><font face=arial>Le livre...</h3>
<table>
<tr>
   <td><font face=arial size=2>Titre : </td>
   <td><font face=arial size=2 color=green><jsp:getProperty name="livre" property="titre"/></td>
</tr>
<tr>
   <td><font face=arial size=2>Catégorie : </td>
   <td><font face=arial size=2 color=green><jsp:getProperty name="livre" property="categorie"/></td>
</tr>
<tr>
   <td><font face=arial size=2>Le numero ISBN : </td>
   <td><font face=arial size=2 color=green><jsp:getProperty name="livre" property="isbn"/></td>
</tr>
<tr>
   <td><font face=arial size=2 color=red>Le code d'enregistrement : </td>
   <td><font face=arial size=2 color=red><jsp:getProperty name="livre" property="code" /></td>
</tr>
</table>
<h3><font face=arial>L'auteur...</h3>
<table>
<tr>
   <td><font face=arial size=2>Nom : </td>
   <td><font face=arial size=2 color=green><jsp:getProperty name="livre" property="nomAuteur"/></td>
</tr>
<tr>
   <td><font face=arial size=2>Prénom : </td>
   <td><font face=arial size=2 color=green><jsp:getProperty name="livre" property="prenomAuteur"/></td>
</tr>
</table>


</body>
</html>
