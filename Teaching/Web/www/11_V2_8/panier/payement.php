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
$prixTot = $_POST['prixTot'];
$_SESSION['prixTot'] = $prixTot;
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
				<div class="progress-bar" role="progressbar" style="width: 25%" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
			</div>
	<div class="container-fluid">
		<?php include('payement/step1_base.php'); ?>
	</div>
</main>

<!--Footer-->
<?php include("footer.php");?>

</html>