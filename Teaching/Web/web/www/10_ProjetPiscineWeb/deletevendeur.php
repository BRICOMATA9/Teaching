<?php

  $database= "projetweb";
  $db_handle = mysqli_connect('localhost', 'root', '');
  $db_found = mysqli_select_db($db_handle, $database);
  $id=$_GET["id"];
  if($db_found)
  {
     $sql3="SELECT * FROM vendeur WHERE email_vendeur='$id'";
     $sql="DELETE FROM vendeur WHERE email_vendeur='$id'";
     $sql2="DELETE FROM connexion WHERE email='$id'";
  }

  else 
  {
    echo "Database not found";
  }

          $result2 = mysqli_query($db_handle, $sql3);

          while ($data = mysqli_fetch_assoc($result2))
          {
            $id_stock=$data['id_ventes'];
            echo $id_stock;
          }

          $result2=mysqli_query($db_handle,"DELETE FROM item WHERE id_mesventes='$id_stock'");
          $result = mysqli_query($db_handle, $sql); 
          $result = mysqli_query($db_handle, $sql2);
          header('Location:http://127.0.0.1/ProjetPiscineWeb/listevendeur.php');
          exit();
?>