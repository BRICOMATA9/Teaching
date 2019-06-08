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
		<div class="progress-bar" role="progressbar" style="width: 75%" aria-valuenow="75" aria-valuemin="0" aria-valuemax="100"></div>
	</div>
	<div class="container-fluid">
		<div id="block_form" class="form-group">
			<br>
			<h2>Étape 3 : Vos Informations Bancaires</h2>
			<small id="emailHelp" class="form-text text-muted">Nous ne partagerons jamais vos informations avec qui que ce soit !</small>
			<br>
			<form action="step4.php" method="post">
				<div class="form-check form-check-inline">
					<input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio1" value="option1" required>
					<label class="form-check-label" for="inlineRadio1"><img alt= "Visa" height="20" src="../../images/visa.gif" width="50"></label>
				</div>
				<div class="form-check form-check-inline">
					<input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio2" value="option2" required>
					<label class="form-check-label" for="inlineRadio2"><img alt= "American Express" height="30" src="../../images/american.gif" width="50"></label>
				</div>
				<div class="form-check form-check-inline">
					<input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio3" value="option3" required>
					<label class="form-check-label" for="inlineRadio3"><img alt= "Master Card" height="30" src="../../images/mastercard.gif" width="50"></label>
				</div>
				<div class="form-group">
						<label for="id_card">N° de Carte :</label>
						<input type="number" class="form-control w-25" id="id_card" aria-describedby="emailHelp" min="0" pattern="\d{16}" placeholder="ex : XXXX XXXX XXXX XXXX" required>
				</div>
				<div class="form-group">
						<label for="security_code">Code de sécurité :</label>
						<input type="number" class="form-control w-25" id="security_code" aria-describedby="emailHelp" pattern="\d{3}" title="Doit être à 3 chiffres" min="0" placeholder="3 chiffres au dos de votre carte" required>
				</div>
				<div class="form-group">
						<label for="card_name">Nom du titulaire du compte :</label>
						<input type="text" class="form-control w-25" id="card_name" aria-describedby="emailHelp" placeholder="ex : JEAN DUPONT" required>
				</div>
			  <button id="button_payment" type="submit" class="btn btn-primary">Finalisez votre achat &raquo;</button>
			</form>
		</div>
	</div>
</main>

<!--Footer-->
<?php include("footer.php");?>

</html>