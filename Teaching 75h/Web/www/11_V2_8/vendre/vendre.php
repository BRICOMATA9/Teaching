<!DOCTYPE html>
<html lang="fr">

<!-- Header -->

<?php 
session_start();

//$_SESSION['connected'];
//Variable Connecté
if (isset ($_SESSION['connected'])) //Si connecté défini auparavant => $connected prend sa valeur
{
	$connected = $_SESSION['connected'];
	if ($_SESSION['connected']==true)
	{
		
	}else if ($_SESSION['connected']==false)
	{
		$connected = false;
	}else if ($_SESSION['connected']==null)
	{
		$connected = false;
	}
}else //Sinon affichage page de connection
{
	$connected = false;
}
?>

<?php

if ($connected == true)
{
	include("header.php");
	?>
	<style>
			#block_form
			{
				display : block;
				width : 20rem;
				padding-left: 80px;

				
			}
			#button_form
			{
				padding-left: 120px;
				float:left;
				display : block;
			}
			.container-fluid
			{
				padding-left : 0px;
				padding-right : 0px;
			}
	</style><?php
	if ($_SESSION['statut']=="Vendeur")
	{
		?>
		<div class="jumbotron">
				<div class="container">
				  <h1 class="display-3">Quelle catégorie d'item souhaitez-vous ajouter ?</h1>
				</div>
		</div>

		<body class="container-fluid">
			
			<div id="block_form" class="form-group">
				<FORM method="get" action="cible.php" >
					<SELECT name="choix"  id="selecteur" class="form-control">
						<option value ="livre">Livre</option>
						<option value ="musique">Musique</option>
						<option value ="vetement">Vetement</option>
						<option value ="spo_act">Sport et Activité</option>
					</SELECT>
			</div>
			<div id="button_form">
				<p>
					<br>
					<input id="button" type="submit" name="submit" value="Valider" class="btn btn-primary btn-lg"><br>
				</p>
				</FORM>
			</div>
		</body>
		<?php
	}else
	{
		?>
		<div class="jumbotron">
				<div class="container">
				  <h1 class="display-3">Vendre</h1>
				</div>
		</div>

		<body class="container-fluid">
			<h3>L'utilisateur n'est pas un vendeur.</h3>
		</body>
		<?php
	}
}else
{
	include("header.php");
	include("connection_page.php");
}
?>

<?php include("footer.php");?>


</html>