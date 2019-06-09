<!DOCTYPE html>
<!--
	Auteurs : Clément LARIVIERE	TD10
			  Théo MERCIER		TD04
			  Antoine PAINCHAUX TD01
-->
<?php
	$database = "ece_amazon";

	try
	{
		$bdd = new PDO('mysql:host=localhost;dbname=ece_amazon;charset=utf8', 'root', 'root');
	}
	catch (Exception $e)
	{
		die('Erreur : ' . $e->getMessage());
	}

	$reqSup = $bdd->prepare('DELETE FROM cart');
	$reqSup->execute();
	session_destroy();
	session_start();
	$_SESSION['connected'] = false;
	$_SESSION['statut'] = array();
	header('Location: ../index.html');
	exit();
?>