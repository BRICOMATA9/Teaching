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
$idsp=0;


$reponse = $bdd->query('SELECT MAX(id) as id FROM items');	


while ($donnees = $reponse->fetch())
{
	$idsp=$donnees['id'];
}


$req1 = $bdd->prepare('INSERT INTO sports_hobbies(id_item, type) VALUES(:id_item,:type)');
$req1->execute(array(
	'id_item' => $idsp,
	'type' => $_POST['type']

	));

	$reponse->closeCursor();

?>