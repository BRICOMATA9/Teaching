<?php
session_start();

$database="ece_amazon";
$db_handle = mysqli_connect('localhost', 'root', '');  
$db_found = mysqli_select_db($db_handle, $database);

$article=$_GET['id'];
$requete="DELETE FROM panier WHERE id='$article'";
mysqli_query($db_handle,$requete);
header('Location:Panier.php');
?>