<!DOCTYPE html>
<!--
	Auteurs : Clément LARIVIERE	TD10
			  Théo MERCIER		TD04
			  Antoine PAINCHAUX TD01
-->
<html lang="fr">

<div id="block_form" class="form-group">
			<br>
			<h2>Étape 1 : Votre identité</h2>
			<small id="emailHelp" class="form-text text-muted">Nous ne partagerons jamais vos informations avec qui que ce soit !</small>
			<br>
			<form action="payement/payement_step2.php" method="post">
				<div class="form-group">
					<label for="user_name">Prénom :</label>
					<p><?php echo $_SESSION['prenom']?></p>
				</div>
				<div class="form-group">
					<label for="user_surname">Nom :</label>
					<p><?php echo $_SESSION['name']?></p>
				</div>
				<div class="form-group">
					<label for="user_email">Email :</label>
					<p><?php echo $_SESSION['email']?></p>
				</div>
				<input type="hidden" name="prixTot" value="<?php $_POST['prixTot'];?>" />
				<p><a class="btn btn-secondary btn-lg" id="button_payment" href="payement/step1_changement.php" role="button">Modifier mes informations de facturaction pour cette commande &raquo;</a></p>
				<p><button id="button_payment" type="submit" class="btn btn-primary">Étape suivante &raquo;</button></p>
			</form>
			
</div>
	
</div>

</html>