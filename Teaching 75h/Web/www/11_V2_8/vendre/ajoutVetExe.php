<?php

$database = "ece_amazon";

session_start();

try
{
$bdd = new PDO('mysql:host=localhost;dbname=ece_amazon;charset=utf8', 'root', 'root');
}
catch (Exception $e)
{
      die('Erreur : ' . $e->getMessage());
}

$adressEmail = $_SESSION['adresseMail'];
echo $adressEmail;

$req = $bdd->prepare('INSERT INTO items(name,price, shape, videoLink, description, quantity,seller) VALUES(:name,:price, :shape, :videoLink, :description, :quantity,:seller)');
$req->execute(array(
	'name' => $_POST['name'],
	'shape' => $_POST['shape'],
	'videoLink' => $_POST['videoLink'],
	'description' => $_POST['description'],
	'price' => $_POST['price'],
	'quantity' => $_POST['quantity'],
	'seller'=>$adressEmail
	));

//recuperer l'id du dernier truc inseré
$idcloth=0;


$reponse = $bdd->query('SELECT MAX(id) as id FROM items');	


while ($donnees = $reponse->fetch())
{
	$idcloth=$donnees['id'];
}


$req1 = $bdd->prepare('INSERT INTO clothing(id_item, brand, type,genre, size,material,color) VALUES(:id_item,:brand, :type,:genre, :size,:material,:color)');
$req1->execute(array(
	'id_item' => $idcloth,
	'brand' => $_POST['brand'],
	'type' => $_POST['type'],
	'genre' => $_POST['genre'],
	'size' => $_POST['size'],
	'material' => $_POST['material'],
	'color' => $_POST['color']

	));

	$reponse->closeCursor();

?>