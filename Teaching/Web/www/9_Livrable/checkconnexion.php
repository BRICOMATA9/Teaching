<?php 

//php pour verifier si lutilisateur qui se co est dans la bdd
session_start(); //session ouverte
// identification au serveur
define('DB_SERVER', 'localhost');
define ('DB_USER', 'root');
define ('DB_PASS', 'root');

$emailacheteur = $_POST["mail"];
$passwordacheteur = $_POST["password"];

// identifier le nom de la base de données 
$database = "Projetweb";
//connecter l'utilsateur dans la BDD
$db_handle = mysqli_connect (DB_SERVER, DB_USER, DB_PASS);
$db_found = mysqli_select_db ($db_handle, $database);

// si la BDD existe, faire le traitement
if ($db_found) {
	$sql = "SELECT* FROM Acheteur WHERE Email ='".$emailacheteur."' AND Password ='". $passwordacheteur."'";
	$result = mysqli_query ($db_handle, $sql);

	while ($data = mysqli_fetch_assoc($result)){

		if(mysqli_num_rows ($result)== 1){
			session_start();
	                // On s'amuse à créer quelques variables de session dans $_SESSION
			$_SESSION['Email'] = $data['Email'];
			$_SESSION['Nom'] = $data['Nom'];
			$_SESSION['Pseudo'] = $data['PseudoVendeur'];
			$_SESSION['Prenom'] = $data['Prenom'];
			$_SESSION['Statut'] = "Acheteur";


			header('Location: paiement.php');


		}
		else {
			header('Location:' . $_SERVER['HTTP_REFERER']);
		}

	}

                // On démarre la session AVANT d'écrire du code HTML





    }//end if

// si la BDD n'existe pas 
    else {
    	echo 'Database not found';
    }

// Fermer la connection 
    mysqli_close($db_handle);



//Fermer le php
    ?> 
