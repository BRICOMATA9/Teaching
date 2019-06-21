<!DOCTYPE html>
<!--
	Auteurs : Clément LARIVIERE	TD10
			  Théo MERCIER		TD04
			  Antoine PAINCHAUX TD01
-->


<html lang="fr">
<!-- Header -->
<?php include("header.php");?>
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

if ($connected == true && $_SESSION['statut']=="Admin")
{
	header('Location: compte.php');
}else
{
	include("connection_page.php");
}
?>

<!-- footer -->
<?php include("footer.php");?>

</html>