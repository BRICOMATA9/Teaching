<!DOCTYPE html>
<!--
	Auteurs : Clément LARIVIERE	TD10
			  Théo MERCIER		TD04
			  Antoine PAINCHAUX TD01
-->
<html lang="fr">

<?php include("header.php");?>

<?php 
///METTRE REQUETE SQL
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
		$reponseAdmin = $bdd->query('SELECT * FROM users INNER JOIN admins ON users.email=admins.emailUser WHERE email="'.$adressEmail.'"');

		while ($donnees = $reponseAdmin->fetch())
		{
	?>

			  <!-- Main jumbotron for a primary marketing message or call to action -->
			<div class="jumbotron">
				<div class="container">
				  <h1 class="display-3">Compte Admin : Bonjour <?php echo $donnees['fName']; ?></h1>
				</div>
			</div>
			
			<div class="container-fluid" id="block_info">
				  <h3><br>Voici vos informations :</h3><br>
				  <p><strong>Prénom : </strong> <?php echo $donnees['fName'];?></p>
				  <p><strong>Nom : </strong><?php echo $donnees['lName']; ?></p>
				  <p><strong>Adresse e-mail : </strong><?php echo $donnees['email']; ?></p>
				  <p><strong>Role : </strong><?php echo $donnees['role']; ?></p>
				  <br>
				  <p><a class="btn btn-primary btn-lg" href="modification_compte.php" role="button">Modifier vos informations &raquo;</a></p>
				  <p><a class="btn btn-danger btn-lg" href="deconnexion.php" role="button">Déconnexion &raquo;</a></p>
			</div>
			
			  <?php
		}

				$reponseAdmin->closeCursor(); // Termine le traitement de la requête

			?>
</main>

</html>