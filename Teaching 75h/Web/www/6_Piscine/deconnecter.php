<?php
session_start();
session_unset();
session_destroy();
$database="ece_amazon";
$db_handle = mysqli_connect('localhost', 'root', '');  
$db_found = mysqli_select_db($db_handle, $database);
$vider="DELETE FROM panier";
mysqli_query($db_handle,$vider);
header('Location:index.php');
exit();
?>