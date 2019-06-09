<?php
session_start();
$database="ece_amazon";
$db_handle = mysqli_connect('localhost', 'root', '');  
$db_found = mysqli_select_db($db_handle, $database);

$mail=$_POST['mail'];
$mdp=$_POST['mdp'];
$nom=$_POST['nom'];
$prenom=$_POST['prenom'];
$adresse=$_POST['adresse'];
$telephone=$_POST['telephone'];
$nomcarte=$_POST['nomcarte'];
$numerocarte=$_POST['numerocarte'];
$typecarte=$_POST['typecarte'];
$datecarte=$_POST['datecarte'];
$codecarte=$_POST['codecarte'];

if(!isset($_POST['nomcarte']))
{
	echo '<h2> Veuillez saisir le nom du possesseur de la carte</h2>';
	header('Location:nouveaucompe.php');
	exit();
}
if(!isset($_POST['numerocarte']))
{
	echo '<h2> Veuillez saisir le numero de votre carte</h2>';
	header('Location:nouveaucompe.php');
	exit();
}
if(!isset($_POST['typecarte']))
{
	echo '<h2> Veuillez saisir le type de la carte</h2>';
	header('Location:nouveaucompe.php');
	exit();
}
if(!isset($_POST['datecarte']))
{
	$phrase="d'expiration";
	echo '<h2> Veuillez saisir la date '.$phrase.' de la carte</h2>';
	header('Location:nouveaucompe.php');
	exit();
}
if(!isset($_POST['codecarte']))
{
	echo '<h2> Veuillez saisir le code de securite de la carte</h2>';
	header('Location:nouveaucompe.php');
	exit();
}
$requete="SELECT * FROM utilisateur WHERE email='$mail'";
$data=mysqli_query($db_handle,$requete);
  	if( $result =  mysqli_fetch_assoc( $data ) )
		echo "Un compte utilisant cette adresse mail existe deja.";
	else 
	{
		$nouveau="INSERT INTO utilisateur (Nom, Prenom, Adresse, Numero, mail, mdp,nomcarte,numerocarte,typecarte,datecarte,codecarte) VALUES ('$nom', '$prenom', '$adresse', '$telephone', '$mail', '$mdp','$nomcarte','$numerocarte','$typecarte','$datecarte','$codecarte')";
		$inserer=mysqli_query($db_handle,$nouveau);
	}
    header('Location: Compte.php');
    exit();
?>
<!-- bien rediriger le programme vers compte-->