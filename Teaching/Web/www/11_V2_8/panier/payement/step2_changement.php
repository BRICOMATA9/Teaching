<!DOCTYPE html>
<!--
	Auteurs : Clément LARIVIERE	TD10
			  Théo MERCIER		TD04
			  Antoine PAINCHAUX TD01
-->
<html lang="fr">

<!--Header-->
<?php include("header.php");?>

<?php session_start(); 
$_SESSION['email'] = $_POST['email'];
?>

<style>
#button_payment
{
	margin-top : 1%;
	margin-left : 1%;
	
}

#block_form
{
	diplay : block;
	margin-left : 10%;
}


</style>

<main role="main">
	
	<div class="jumbotron">
		<div class="container">
			
			<h1 class="display-3">Règlement de votre panier</h1>
		</div>
	</div>
	<div class="progress">
		<div class="progress-bar" role="progressbar" style="width: 50%" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100"></div>
	</div>
	<div class="container-fluid">
		<div id="block_form" class="form-group">
			<br>
			<h2>Étape 2 : Votre Adresse de Livraison</h2>
			<small id="emailHelp" class="form-text text-muted">Nous ne partagerons jamais vos informations avec qui que ce soit !</small>
			<br>
			<form action="step3.php" method="post">
				<div class="form-group">
						<label for="adresse1">Rue :</label>
						<input type="text" class="form-control w-25" id="adresse" aria-describedby="emailHelp" placeholder="ex : 53 impasse des Lilas" autofocus required>
				</div>
				<div class="form-group">
						<label for="adresse2">Ville :</label>
						<input type="text" class="form-control w-25" id="ville" aria-describedby="emailHelp" placeholder="ex : Paris" required>
				</div>
				<div class="form-group">
						<label for="code_postal">Code Postal :</label>
						<input type="text" class="form-control w-25" id="code_postal" aria-describedby="emailHelp" pattern="\d{5}" title="Doit être 5 chiffres" min="0" placeholder="ex : 75000" required>
				</div>
				<div class="form-group">
						<label for="pays">Pays :</label>
						<input type="text" class="form-control w-25" id="pays" aria-describedby="emailHelp" placeholder="ex : France" required>
				</div>
			  <button id="button_payment" type="submit" class="btn btn-primary">Étape suivante &raquo;</button>
			</form>
		</div>
	</div>
</main>

<!--Footer-->
<?php include("footer.php");?>

</html>