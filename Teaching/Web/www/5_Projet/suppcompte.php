<?php
session_start();
$bdd = new PDO('mysql:host=localhost;dbname=ece_amazon', 'root', '');

$iduser = intval($_GET['id']); // id item

if (isset($_SESSION['id']) AND $_SESSION['type'] == "ADMINISTRATEUR")
{
	// Supprime les items des paniers
	$suppcompte = $bdd->prepare("DELETE FROM paniers WHERE IDVendeur = ?");
	$suppcompte->execute(array($iduser));

	// Suprime les items 
	$suppcompte = $bdd->prepare("DELETE FROM items WHERE IDVendeur = ?");
	$suppcompte->execute(array($iduser));

	// Supprime le compte
	$suppcompte = $bdd->prepare("DELETE FROM comptes WHERE ID = ?");
	$suppcompte->execute(array($iduser));
	header("Location: categories.php");
}
else { header("Location: profil.php?id=".$iduser); }


?>