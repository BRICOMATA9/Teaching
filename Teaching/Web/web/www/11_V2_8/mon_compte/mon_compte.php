<!DOCTYPE html>
<!--
	Auteurs : Clément LARIVIERE	TD10
			  Théo MERCIER		TD04
			  Antoine PAINCHAUX TD01
-->


<html lang="fr">
<!-- Header -->
<!-- Variables -->
<?php 
///METTRE REQUETE SQL
session_start();
$_SESSION['connected'];
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
	if($_SESSION['statut']=="Admin")
	{
		//include("header.php");
		include("../admin/compte.php");
	}else if($_SESSION['statut']=="Acheteur")
	{
		//include("header.php");
		include("compte.php");
	}else if($_SESSION['statut']=="Vendeur")
	{
		//include("header.php");
		include("../vendre/compte.php");
	}

}else if ($connected == false)
{
	include("header.php");
	include("connection_page.php");
}
?>

<!-- footer -->
<?php include("footer.php");?>

</html>