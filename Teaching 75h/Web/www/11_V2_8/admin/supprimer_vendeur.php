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
	echo $id;



	$reponse = $bdd->query('SELECT * FROM items i INNER JOIN sellers s ON i.seller=s.emailUser INNER JOIN users u ON s.emailUser = u.email WHERE seller="'.$id.'"');

	while ($donnees = $reponse->fetch())
		{
		$re = $bdd->prepare('DELETE FROM photoLinks WHERE id_item="'.$donnees['id'].'"');
		$req6 = $bdd->prepare('DELETE FROM books WHERE id_item="'.$donnees['id'].'"');
		$req2 = $bdd->prepare('DELETE FROM music WHERE id_item="'.$donnees['id'].'"');
		$req3 = $bdd->prepare('DELETE FROM clothing WHERE id_item="'.$donnees['id'].'"');
		$req4 = $bdd->prepare('DELETE FROM sports_hobbies WHERE id_item="'.$donnees['id'].'"');
		$req7 = $bdd->prepare('DELETE FROM items WHERE id="'.$donnees['id'].'"');


		$re->execute();
		$req6->execute();
		$req2->execute();
		$req3->execute();
		$req4->execute();
		$req7->execute();
	}



	echo $id;


	$req = $bdd->prepare('DELETE FROM sellers WHERE emailUser="'.$id.'"');
	$req5 = $bdd->prepare('DELETE FROM users WHERE email="'.$id.'"');
	$req->execute();
	$req5->execute();

	echo $id;

	//echo 'hello' . $_GET['id'];
	header ('Location: admin_vendeur.php');
	exit();
?>