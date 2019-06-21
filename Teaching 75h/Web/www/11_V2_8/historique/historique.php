<!DOCTYPE html>
<!--
	Auteurs : Clément LARIVIERE	TD10
			  Théo MERCIER		TD04
			  Antoine PAINCHAUX TD01
-->
<?php 
session_start();

if ($_SESSION['statut']=="Vendeur")
{
	header('Location: historique_ventes.php');
	exit();
}else if($_SESSION['statut']=="Acheteur")
{
	header('Location: historique_achats.php');
	exit();
}
?>