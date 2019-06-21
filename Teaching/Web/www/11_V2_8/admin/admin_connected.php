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
#bouton1
{
	float:left;
	margin-left : 10%;
	margin-right : 5%;
}#bouton2
{
	float:left ;
}

#bouton3
{
	float:left ;
	margin-right : 10%;
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
			
<div class="container-fluid" id="block_info">
	<?php

	if ($connected == true && $_SESSION['statut']=="Admin")
	{?>
		<a id="bouton1" class="btn btn-primary btn-lg" href="admin_item.php" role="button">Gestion d'Articles &raquo;</a>
		<a id="bouton2" class="btn btn-info btn-lg" href="admin_vendeur.php" role="button">Gestion de Vendeurs &raquo;</a>
		<h3><br></h3><br><br><br>
		<p><a id="bouton3" class="btn btn-danger btn-lg" href="deconnexion.php" role="button">Déconnexion &raquo;</a></p>
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
