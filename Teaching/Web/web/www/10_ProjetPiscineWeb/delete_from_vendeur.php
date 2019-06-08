<?php

  $database= "projetweb";
  $db_handle = mysqli_connect('localhost', 'root', '');
  $db_found = mysqli_select_db($db_handle, $database);
  $id=$_GET["id"];
  if($db_found)
  {
     $sql="DELETE FROM item WHERE id_item='$id'";
	   $sql2="DELETE FROM mes_ventes WHERE id_item='$id'";
	  
  }

  else 
  {
    echo "Database not found";
  }

          $result = mysqli_query($db_handle, $sql); 
 		      $result2 = mysqli_query($db_handle, $sql2); 
          header('Location:http://127.0.0.1/ProjetPiscineWeb/gerer_mes_stocks.php');
          exit();
?>