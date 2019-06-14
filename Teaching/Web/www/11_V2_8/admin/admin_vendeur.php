<!DOCTYPE html>
<!--
	Auteurs : Clément LARIVIERE	TD10
			  Théo MERCIER		TD04
			  Antoine PAINCHAUX TD01
-->
<html lang="fr">

<?php

session_start();
$_SESSION['connected'];

if (isset ($_SESSION['connected'])) //Si connecté défini auparavant => $connected prend sa valeur
{
	$connected = $_SESSION['connected'];
	if ($_SESSION['connected']==true)
	{
		//$name = $_SESSION['user_name'];
		//$surname = $_SESSION['user_surname'];
		//$email = $_SESSION['email'];
		//$adresse1 = $_SESSION['rue'];
		//$adresse2 = $_SESSION['codepost'];
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


function subMyString( $contenu, $limite, $separateur = '...' ) {
    if( strlen($contenu) >= $limite ) {
        $contenu = substr( $contenu, 0, $limite );
        $contenu = substr( $contenu, 0, strrpos($contenu, ' ') );
        $contenu .= $separateur;
    }
     
    return $contenu;
}
?>

<style>
header
{
	padding-top: 2.3rem;
}

#boutonInfo
{
	float:right;
}
#boutonInfo2
{
	float:right;
	margin-bottom : 1%;
	margin-right : 1%;
}
</style>

<main role="main">

<!-- Header -->
<?php include("header.php");?>

<!-- Main jumbotron for a primary marketing message or call to action -->
<div class="jumbotron">
	<div class="container">
		<h1 class="display-3">Espace Administrateur</h1>
		<?php if($_SESSION['statut']=="Admin")
		{
			?><a id="boutonInfo" class="btn btn-primary btn-lg" href="mon_compte.php" role="button">Information de compte &raquo;</a><?php
		}?>
	</div>
</div>
<a id="boutonInfo2" class="btn btn-info btn-lg" href="admin_connected.php" role="button">Retour à la gestion d'administrateur &raquo;</a>
			
<div class="container-fluid" id="block_info">
	<?php

	if ($connected == true && $_SESSION['statut']=="Admin")
	{
		$database = "ece_amazon";

		try
		{
		  $bdd = new PDO('mysql:host=localhost;dbname=ece_amazon;charset=utf8', 'root', 'root');
		}
		catch (Exception $e)
		{
			die('Erreur : ' . $e->getMessage());
		}
			  
		$reponse = $bdd->query('SELECT * FROM users INNER JOIN sellers on users.email=sellers.emailUser');
		?>
		<table class="table table-hover ">
			<thead class="thead-dark">
				<tr>

					<th scope="col">email</th>
					<th scope="col"> </th>
					<th scope="col"> </th>
				</tr>
			</thead>
			<tbody>
				<?php
				while ($donnees = $reponse->fetch())
				{
					?>
					<tr>
						<td><?php echo $donnees['email'];?></td>
						<td><a class="btn btn-danger btn-lg" href="supprimer_vendeur.php?id=<?php echo $donnees['email'] ?>"  role="button">Supprimer &raquo;</a></td>
					</tr>	
					<?php
				}
				$reponse->closeCursor(); // Termine le traitement de la requête
				?>
			</tbody>
		</table>
		<h3><br></h3>
		<p><a class="btn btn-danger btn-lg" href="deconnexion.php" role="button">Déconnexion &raquo;</a></p>
		<?php
	}else
	{
		?>
		<h3>Aucun administrateur n'est connecté !</h3>
		<?php
	}
	?>


</div>
			

</main>

</html>