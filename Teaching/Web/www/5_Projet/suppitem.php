<?php
session_start();
$bdd = new PDO('mysql:host=localhost;dbname=ece_amazon', 'root', '');

$iditem = intval($_GET['id']); // id item
$iduser = 0; 

if (isset($_SESSION['id'])) { $iduser = $_SESSION['id']; } //id user

$suppitem = $bdd->prepare("DELETE FROM paniers WHERE IDItem = ?");
$suppitem->execute(array($iditem));

$suppitem = $bdd->prepare("DELETE FROM items WHERE ID = ?");
$suppitem->execute(array($iditem));


header("Location: categories.php");
?>