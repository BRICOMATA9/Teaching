<!DOCTYPE html>
<!--
	Auteurs : Clément LARIVIERE	TD10
			  Théo MERCIER		TD04
			  Antoine PAINCHAUX TD01
-->
<html lang="fr">
<!-- Header -->
<?php 
include("header.php");
session_start();
$statut = "modif";
?>


<main role="main">

	<!-- Main jumbotron for a primary marketing message or call to action -->
	<div class="jumbotron">
		<div class="container">
		  <h1 class="display-3">Modifiez de vos informations</h1>
		</div>
	</div>
	<div class="container-fluid" id="block_info">
		  <p class="h2"><br>Vos informations :</p>
		  <form  id="emailForm"action="subscribe.php?statut=modif" method="POST" name="emailForm">
			  <label for="user_name">Prénom :</label> <input type="text" id="user_name" name="user_name" autofocus required><br>
			  <label for="user_surname">Nom :</label> <input type="text" id="user_surname" name="user_surname" required><br>
		  <input id="button" type="submit" name="submit" value="Enregistrer" class="btn btn-primary btn-lg"><br>
		  </form>
		  <?php //METTRE LA REQUETE DE MODIFICATION SQL?>
	</div>
</main>


<!-- footer -->
<?php include("footer.php");?>

</html>