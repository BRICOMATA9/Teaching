<?php
  require_once("../Première version ECEAmazon/hearder.php"); 

?>


<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Livre</title>
	<link rel="stylesheet" type="text/css" href="designaccueil.css">
	<link rel="stylesheet" type="text/css" href="livre.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
     <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    

</head>
<body>

	

	<form method="post" action="ajouter.php">
        <td>
            <tr>ID : <input type="text" name="identi"></tr><br/><br/><br/>
            <tr>Nom de l'article : <input type="text" name="nom_article"></tr><br/><br/><br/>
            <tr>Image associé : <input type="text" name="imag"></tr><br/><br/><br/>
            <tr>Description : <input type="text" name="descri"></tr><br/><br/><br/>
            <tr>Prix : <input type="number" name="prix_article"></tr><br/><br/><br/>
            <tr>Type : <input type="text" name="type_article"></tr><br/><br/><br/>

            <tr><input type="submit" name="Ajouter_cet_article"></tr>



        </td>
        
    </form>
    <div id="error"></div>


	 

</body>
</html>