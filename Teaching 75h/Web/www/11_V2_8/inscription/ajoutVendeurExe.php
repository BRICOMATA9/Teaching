<?php

session_start();
$statut_connect = "vendeur";
$database = "ece_amazon";
$_SESSION['statut']="Vendeur";


try
{
$bdd = new PDO('mysql:host=localhost;dbname=ece_amazon;charset=utf8', 'root', 'root');
}
catch (Exception $e)
{
      die('Erreur : ' . $e->getMessage());
}


$req = $bdd->prepare('INSERT INTO users(email, password, pseudo, fName, lName) VALUES(:email, :password, :pseudo, :fName, :lName)');
$req->execute(array(
	'email' => $_POST['email'],
	'password' => $_POST['password'],
	'pseudo' => $_POST['pseudo'],
	'fName' => $_POST['fName'],
	'lName' => $_POST['lName']
	));

//recuperer l'id du dernier truc inseré
$mail=0;

$reponse = $bdd->query('SELECT MAX(lastDate) as lastDate, email FROM users GROUP BY email ORDER BY lastDate DESC LIMIT 1');	


while ($donnees = $reponse->fetch())
{
	$mail=$donnees['email'];
}

$req1 = $bdd->prepare('INSERT INTO sellers(emailUser, photoLink, backPictureLink) VALUES(:emailUser, :photoLink, :backPictureLink)');
$req1->execute(array(
	'emailUser' => $mail,
	'photoLink' => 'Apppic',
	'backPictureLink' => 'Apbpic'
	));

	$reponse->closeCursor();


	header('Location: ../mon_compte/subscribe.php?statut=crea')

?>