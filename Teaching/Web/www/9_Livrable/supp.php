<?php 


$Email = $_GET["Email"];

	define('DB_SERVER', 'localhost');
	define ('DB_USER', 'root');
	define ('DB_PASS', 'root');

				// identifier le nom de la base de données 
	$database = "Projetweb";
				//connecter l'utilsateur dans la BDD
	$db_handle = mysqli_connect (DB_SERVER, DB_USER, DB_PASS);
	$db_found = mysqli_select_db ($db_handle, $database);

				// si la BDD existe, faire le traitement
	if ($db_found) {


				$sql2 = "DELETE FROM Vendeur WHERE Email ='".$Email."'";
				$result2 = mysqli_query ($db_handle, $sql2);
				header('Location: supprimervendeur.php');



			
	}//end if

				// si la BDD n'existe pas 
	else {
		echo 'Database not found';
	}

				// Fermer la connection 
				    mysqli_close($db_handle);

?>

