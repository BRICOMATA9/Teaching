<?php
//php pour ajouter des items a la bdd
session_start(); //session ouverte

if($_GET["action"]=="supp"){
	$workwith = $_SESSION['newvaleueonthecart'];

	$workwith[$_GET["id"]] = $workwith[$_GET["id"]]-1;
	

	header('Location: panier.php');
	$_SESSION['newvaleueonthecart'] = $workwith;


} elseif ($_GET["action"]=="supprimeritems"){

	define('DB_SERVER', 'localhost');
	define ('DB_USER', 'root');
	define ('DB_PASS', 'root');

				// identifier le nom de la base de données 
	$database = "Projetweb";
				//connecter l'utilsateur dans la BDD
	$db_handle = mysqli_connect (DB_SERVER, DB_USER, DB_PASS);
	$db_found = mysqli_select_db ($db_handle, $database);
	$newStock = 0;

				// si la BDD existe, faire le traitement
	if ($db_found) {
		$sql = "SELECT * FROM Items WHERE Id ='".$_GET["id"]."'";
		$result = mysqli_query ($db_handle, $sql);
		while ($data = mysqli_fetch_assoc($result)){

			$newStock = $data["Stock"]-1; 
			if($newStock == 0){
				$sql2 = "DELETE FROM Items WHERE Id ='".$_GET["id"]."'";
				$result2 = mysqli_query ($db_handle, $sql2);
				header('Location: itemsenvente.php');

			} else {
				$sql23 = "UPDATE Items SET Stock ='".$newStock."' WHERE Id ='".$_GET["id"]."'";
				$result23 = mysqli_query ($db_handle, $sql23);
				header('Location: itemsenvente.php');

			}

			
		}//end while
	}//end if

				// si la BDD n'existe pas 
	else {
		echo 'Database not found';
	}

				// Fermer la connection 
				    mysqli_close($db_handle);


} else {


					if($_GET["Stock"]-$_GET["Panier"] <=0){

						header('Location:' . $_SERVER['HTTP_REFERER']);
		//header('Location: index.html');



					} else {

						if (isset($_SESSION['newvaleueonthecart'])) {


							$workwith = $_SESSION['newvaleueonthecart'];

					//array_push($workwith, $_GET["id"]);
							if(isset($workwith[$_GET["id"]])){		
								$workwith[$_GET["id"]] = $workwith[$_GET["id"]]+1;
							}
							else {
								$workwith[$_GET["id"]] = 1;
							}

						}
						else {
							$workwith = array();
							$workwith[$_GET["id"]] = 1;

						}

						unset($workwith[0]);
						$_SESSION['newvaleueonthecart'] = $workwith;


						header('Location:' . $_SERVER['HTTP_REFERER']);





					} 

					

				}

//fermeture du php
				?> 
