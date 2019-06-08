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

$req = $bdd->prepare('DELETE FROM books WHERE id_item=43');
$req2 = $bdd->prepare('DELETE FROM music WHERE id_item=43');
$req3 = $bdd->prepare('DELETE FROM clothing WHERE id_item=43');
$req4 = $bdd->prepare('DELETE FROM sports_hobbies WHERE id_item=43');
$req5 = $bdd->prepare('DELETE FROM items WHERE id=43');

$req->execute();
$req2->execute();
$req3->execute();
$req4->execute();
$req5->execute();

?>