<?php 

if ($_GET['choix']=='vendeur')
{
	header('Location: ajoutVendeur.php');
	exit();
} 
elseif($_GET['choix']=='acheteur')
{
	header('Location: ajoutAcheteur.php');
	exit();

}

?>