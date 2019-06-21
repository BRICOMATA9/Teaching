<?php

  $database= "projetweb";
  $db_handle = mysqli_connect('localhost', 'root', '');
  $db_found = mysqli_select_db($db_handle, $database);
  $id=$_GET["id"];
  if($db_found)
  {
     $sql="DELETE FROM item WHERE id_item='$id'";
  }

  else 
  {
    echo "Database not found";
  }

          $result = mysqli_query($db_handle, $sql); 
          header('Location:http://127.0.0.1/ProjetPiscineWeb/affichagetest.php');
          exit();
?>