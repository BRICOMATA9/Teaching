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

	$id=$_GET['id'];

	$re = $bdd->prepare('DELETE FROM photoLinks WHERE id_item="'.$id.'"');
	$req = $bdd->prepare('DELETE FROM books WHERE id_item="'.$id.'"');
	$req2 = $bdd->prepare('DELETE FROM music WHERE id_item="'.$id.'"');
	$req3 = $bdd->prepare('DELETE FROM clothing WHERE id_item="'.$id.'"');
	$req4 = $bdd->prepare('DELETE FROM sports_hobbies WHERE id_item="'.$id.'"');
	$req5 = $bdd->prepare('DELETE FROM items WHERE id="'.$id.'"');


	$re->execute();
	$req->execute();
	$req2->execute();
	$req3->execute();
	$req4->execute();
	$req5->execute();

	echo $id;

	//echo 'hello' . $_GET['id'];
	header ('Location: admin_item.php');
	exit();
?>