<?php
//php pour livraison 
session_start(); //session ouverte


$_SESSION["Adresselivraison"] = $_POST["Adresse1"];
$_SESSION["Ville"] = $_POST["Ville"];
$_SESSION["CodePostal"] = $_POST["CodePostal"];

// ouvre la page verification apres
header('Location: verification.php');


?>

