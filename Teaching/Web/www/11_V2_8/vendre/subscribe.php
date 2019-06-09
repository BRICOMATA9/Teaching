<!DOCTYPE html>
<!--
	Auteurs : Clément LARIVIERE	TD10
			  Théo MERCIER		TD04
			  Antoine PAINCHAUX TD01
-->
<html lang="fr">

<?php 
//Header
include("header.php");

//Session
session_start();


//GET
$statut = $_GET['statut'];

$_SESSION['connected'] = true;
?>
<main role="main">

		<?php 

	if($statut=='modif')
	{
		try
		{
			$bdd = new PDO('mysql:host=localhost;dbname=ece_amazon;charset=utf8', 'root', 'root');
		}
		catch (Exception $e)
		{
		    die('Erreur : ' . $e->getMessage());
		}

		$sql = 'UPDATE users SET fName="'.$_POST['user_name'].'",lName="'.$_POST['user_surname'].'" WHERE email= "'.$_SESSION['email'].'"';
		$stmt = $bdd->prepare($sql);

		$stmt->execute();



	$reponse = $bdd->query('SELECT * FROM users WHERE email="'.$_SESSION['email'].'"');
	while ($donnees = $reponse->fetch())
	{
			$_SESSION['prenom']=$donnees['fName'];
			$_SESSION['name']=$donnees['lName'];
			$_SESSION['email']=$donnees['email'];
	}
	}


	?>

	<div class="jumbotron">
		<div class="container">
		<?php 
		if ($statut=='connect')
		{
			echo '<h1 class="display-3">Connexion réussi</h1>';
		}else if ($statut=='modif')
		{
			echo '<h1 class="display-3">Modification de vos informations</h1>';
		}else if ($statut=='crea')
		{
			echo '<h1 class="display-3">Inscription complète</h1>';
		}?>
		</div>
	</div>
	<div class="container-fluid" id="block_principal">
		<?php
		if ($statut=='connect')
		{
			echo '<h3>Informations vérifiées !</h3>';
		}else if ($statut=='modif')
		{
			echo '<h3>Informations enregistrées !</h3>';
		}
		else if ($statut=='crea')
		{
			echo '<h3>Informations enregistrées !</h3>';
		}
		?>
		<br>
		<br>
		  <p><a class="btn btn-primary btn-lg" href="mon_compte.php" role="button">Afficher mon profil &raquo;</a></p>
		  <p><a class="btn btn-primary btn-lg" href="vendre.php" role="button">Vendre un produit &raquo;</a></p>
		
	</div>
</main>


<!-- footer -->
<?php include("footer.php");?>

</html>