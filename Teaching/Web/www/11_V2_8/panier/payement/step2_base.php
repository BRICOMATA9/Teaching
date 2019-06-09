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
			<form action="step3.php" method="post">
				<div class="form-group">
					<label for="rue">Rue :</label>
					<p><?php echo $_SESSION['rue'];?></p>
				</div>
				<div class="form-group">
					<label for="ville">Ville :</label>
					<p><?php echo $_SESSION['ville'];?></p>
				</div>
				<div class="form-group">
					<label for="code_postal">Code Postal :</label>
					<p><?php echo $_SESSION['code_postal'];?></p>
				</div>
				<div class="form-group">
					<label for="pays">Pays :</label>
					<p><?php echo $_SESSION['pays'];?></p>
				</div>
				<input type="hidden" name="prixTot" value="<?php $_POST['prixTot'];?>" />
				<p><a class="btn btn-secondary btn-lg" id="button_payment" href="step2_changement.php" role="button">Modifier mes informations de facturaction pour cette commande &raquo;</a></p>
				<p><button id="button_payment" type="submit" class="btn btn-primary">Étape suivante &raquo;</button></p>
			</form>
			
</div>
	
</div>

</html>