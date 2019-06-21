<!DOCTYPE html>
<!--
	Auteurs : Clément LARIVIERE	TD10
			  Théo MERCIER		TD04
			  Antoine PAINCHAUX TD01
-->
<html lang="fr">

<!--Header-->
<?php include("header.php");?>

<?php session_start(); ?>

<style>
#button_payment
{
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
				<div class="progress-bar" role="progressbar" style="width: 25%" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
			</div>
	<div class="container-fluid">
		<div id="block_form" class="form-group">
			<br>
			<h2>Étape 1 : Votre identité</h2>
			<small id="emailHelp" class="form-text text-muted">Nous ne partagerons jamais vos informations avec qui que ce soit !</small>
			<br>
			<form action="step2_changement.php" method="post">
				<div class="form-group">
						<label for="user_name">Prénom :</label>
						<input type="text" class="form-control w-25" id="user_name" aria-describedby="emailHelp" placeholder="ex : Jean" autofocus required>
				</div>
				<div class="form-group">
						<label for="user_surname">Nom :</label>
						<input type="text" class="form-control w-25" id="user_surname" aria-describedby="emailHelp" placeholder="ex : Dupont" required>
				</div>
				<div class="form-group">
						<label for="user_email">Email :</label>
						<input type="email" class="form-control w-25" id="user_email" aria-describedby="emailHelp" placeholder="ex : jean.dupont@domaine.com" required>
				</div>
				<input type="hidden" name="prixTot" value="<?php $_POST['prixTot'];?>" />
			  <button id="button_payment" type="submit" class="btn btn-primary">Étape suivante &raquo;</button>
			</form>
		</div>
	</div>
</main>

<!--Footer-->
<?php include("footer.php");?>

</html>