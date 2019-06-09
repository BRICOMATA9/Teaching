<?php
// Code pour pouvoir ajouter des items
require_once("../Première version ECEAmazon/hearder.php"); 

?>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8"/>
	<meta name="viewport" content="width=device-width">
	<title> Vendeur Connecté</title>
	<link rel="stylesheet" href="vendeur_connecte.css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<!-- script qui permet de modifier la couleur du body -->
<script type="text/javascript">
$(document).ready(function()
          {
var pdbl = $("body");
pdbl.dblclick(function()
          {
pdbl.toggleClass( "dbl" );
      });
      });
</script>
<!-- fin du script -->
</head>
<body>
	
<h1> Bienvenue cher vendeur!</h1>



	   <br> <br> <br> <br>
	 <div id="tableau">
	 	<p style="color:black";><b>Tableau de bord</b></p>
	 <a href="http://localhost/Première version ECEAmazon/ajout.php"><input type="button" name="ajouter" value="ajouter des items"></a>
		<a href="http://localhost/Première version ECEAmazon/supprime.php"><input type="button" name="supprimer" value="supprimer des items"></a>
	</div>

<br><br><br><br>

	<p style="color:black";><b><i>Cliquez ici pour modifier la couleur</i></b></p>


		

</body>
</html>
