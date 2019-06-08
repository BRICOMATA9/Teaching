<?php
session_start();

$database="ece_amazon";
$db_handle = mysqli_connect('localhost', 'root', '');  
$db_found = mysqli_select_db($db_handle, $database);

$article=$_GET['id'];
$requete="SELECT * FROM panier WHERE id='$article'";
$action=mysqli_query($db_handle,$requete);
$result=mysqli_fetch_assoc($action);
$quantite_ini=$result['quantite'];
$quantite_nouv=$quantite_ini-1;
$decrementer="UPDATE panier SET quantite='$quantite_nouv'";
mysqli_query($db_handle,$decrementer);
header('Location:Panier.php');
?>