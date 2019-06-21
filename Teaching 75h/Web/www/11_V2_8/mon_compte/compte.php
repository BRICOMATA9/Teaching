<!DOCTYPE html>
<!--
	Auteurs : Clément LARIVIERE	TD10
			  Théo MERCIER		TD04
			  Antoine PAINCHAUX TD01
-->
<html lang="fr">

<style>
#bouton_historique
{
	display : block;
	float : right;
}

</style>

<?php 

include("header.php");
session_start();

?>

<main role="main">

	<?php

		$database = "ece_amazon";

		try
		{
		  $bdd = new PDO('mysql:host=localhost;dbname=ece_amazon;charset=utf8', 'root', 'root');
		}
		catch (Exception $e)
		{
			die('Erreur : ' . $e->getMessage());
		}
		  
		$adressEmail = $_SESSION['adresseMail'];
		$reponse = $bdd->query('SELECT * FROM users INNER JOIN buyers ON users.email=buyers.emailUser WHERE email="'.$adressEmail.'"');


		while ($donnees = $reponse->fetch())
		{
	?>


			  <!-- Main jumbotron for a primary marketing message or call to action -->
			<div class="jumbotron">
				<div class="container">
				  <h1 class="display-3">Compte acheteur : Bonjour <?php echo $donnees['fName']; ?></h1>
				</div>
			</div>
			
			<div class="container-fluid" id="block_info">
				<?php 
					$_SESSION['prenom']=$donnees['fName'];
					$_SESSION['name']=$donnees['lName'];
					$_SESSION['email']=$donnees['email'];
					$_SESSION['rue']=$donnees['adress'];
					$_SESSION['ville']=$donnees['city'];
					$_SESSION['pays']=$donnees['country'];
					$_SESSION['code_postal']=$donnees['postCode'];

				?>
				  <h3><br>Voici vos informations :</h3><br>
				  <a  id="bouton_historique" class="btn btn-primary btn-lg" href="../historique/historique.php" role="button">Historique &raquo;</a>
				  <p><strong>Prénom :</strong> <?php echo $donnees['fName']; ?></p>
				  <p><strong>Nom :</strong> <?php echo $donnees['lName']; ?></p>
				  <p><strong>Pseudo :</strong> <?php echo $donnees['pseudo']; ?></p>
				  <p><strong>Adresse e-mail :</strong> <?php echo $donnees['email']; ?></p>
				  <p><strong>Numéro de téléphon :</strong> 0<?php echo $donnees['phone']; ?></p>
				  <p><strong>Adresse postale :</strong> <br><strong>Rue :</strong> <?php echo $donnees['adress']; ?><br><strong>Code Postal :</strong> <?php echo $donnees['postCode']; ?><br><strong>Pays :</strong> <?php echo $donnees['country']; ?><br></p>
				  <h1><br></h1>
				  <p><a class="btn btn-primary btn-lg" href="modification_compte.php" role="button">Modifier vos informations &raquo;</a></p>
				  <p><a class="btn btn-danger btn-lg" href="deconnexion.php" role="button">Déconnexion &raquo;</a></p>
			</div>
			
			  <?php
		}

				$reponse->closeCursor(); // Termine le traitement de la requête

			?>
</main>

</html>