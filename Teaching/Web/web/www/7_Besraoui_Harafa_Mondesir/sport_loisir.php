<?php
  require_once("../Première version ECEAmazon/hearder.php"); 

?>



<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Livre</title>
	
	<link rel="stylesheet" type="text/css" href="liste_articlelivre.css">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <link rel="stylesheet" 
         href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https//ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>

	

<?PHP



	
	$email = "sport";
	$email1 = "loisir";

	$database = "gestion";

	$db_found = new mysqli("localhost","root",  "", $database );

	if ($db_found) {

		$SQL = $db_found->prepare('SELECT * FROM article WHERE Type = ?|| Type = ?');
		$SQL->bind_param('ss', $email,$email1);
		$SQL->execute();

		

		$result = $SQL->get_result();

		if ($result->num_rows > 0) {

			while ( $db_field = $result->fetch_assoc() ) {
?>
				<div id="ligne1">
				    <div id="colonne11"><?php print $db_field['image'] . "<BR>";?><br/><br/><br/><br/></div>
			        <div id="colonne22"><?php print $db_field['nom'] . "<BR>";?><br/><?php print $db_field['description'] . "<BR>";?></div>
			        
                    <div id="colonne33"><?php print $db_field['prix'] . "<BR>";?>€
                    </div>
                    <div id="colonne44"><a href="<?php echo"panier.php?var=".$var.""?>"> <input type= "button"name="boutton" value="ajouter au panier"></a>
                    </div>

				</div><br/><br/><br/><br/><br/><br/><br/><br/>


<?php
			}

		}
		else {
			print "No records found";
		
		}
		$SQL->close();
		$db_found->close();

	}
	else {
		print "Database NOT Found ";
	}
?>




</body>
</html>