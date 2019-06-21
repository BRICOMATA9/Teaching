<?php

	session_start();

	try
	{
		$bdd = new PDO('mysql:host=localhost;dbname=ece_amazon;charset=utf8', 'root', 'root');
	}
	catch (Exception $e)
	{
	    die('Erreur : ' . $e->getMessage());
	}

	echo $_GET['id'];
	echo $_GET['emailB'];

	$req = $bdd->prepare("INSERT INTO cart(id_item,emailBuyer) VALUES(:id_item,:emailBuyer)");
	$req->execute(array(
		'id_item' => $_GET['id'],
		'emailBuyer' => $_GET['emailB']
		));

	header('Location: panier.php?id='.$_GET['id'].'&emailB='.$_GET['emailB']);

?>