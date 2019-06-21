<?php

$nomItem = isset($_POST["nomItem"])?$_POST["nomItem"] : "";
$photosUrl = isset($_POST["photosUrl"])?$_POST["photosUrl"] : "";
$videoUrl = isset($_POST["videoUrl"])?$_POST["videoUrl"] : "";
$quantite = isset($_POST["quantite"])?$_POST["quantite"] : "";
$description = isset($_POST["description"])?$_POST["description"] : "";
$prix = isset($_POST["prix"])?$_POST["prix"] : "";
$typeItem = isset($_POST["typeItem"])?$_POST["typeItem"] : "";
$nomVendeur = isset($_POST["nomVendeur"])?$_POST["nomVendeur"] : "";

$erreur = "";
$database = "ece_amazon";

// Vérification des champs
if($nomItem == "") {
  $erreur .= "Veuillez indiquer le nom de votre article.";
}
if($photosUrl == "") {
  $erreur .= "Veuillez ajouter au moins une image";
}


// Vérification dans la base de donnée
if ($erreur == "") {
  $db_handle = mysqli_connect('localhost', 'root', '');
  $db_found = mysqli_select_db($db_handle, $database);
  if ($_POST["creationCompte"]) {
    if ($db_found) {

      $sql = "SELECT * FROM items";
      if ($nomItem != "") {
        $sql .= " WHERE NomItem LIKE '%$nomItem%'";
        if ($email != "") {
          $sql .= " AND NomVendeur LIKE '%$nomVendeur%'";
        }
      }
      $result = mysqli_query($db_handle, $sql);
      if (mysqli_num_rows($result) != 0) {
        echo "Il vous reste encore des items de même type en vente. Voulez vous augmenter la quantité de cet objet en vente?<br> ";
      }
      else {
        $sql = "INSERT INTO items(Pseudonyme, Email, MotDePasse, TypeCompte) VALUES('$pseudo', '$email', '$passw1', '$type')";
        $result = mysqli_query($db_handle, $sql);
        echo "Bienvenue " .$pseudo ."! <br> Votre profil a été créé avec succès. <br><br>";

        $sql = "SELECT * FROM comptes";
        if ($pseudo != "") {
          $sql .= " WHERE Pseudonyme LIKE '%$pseudo%'";
        }
        $result = mysqli_query($db_handle, $sql);
        while ($data = mysqli_fetch_assoc($result)) {
          echo "Informations sur le compte créé: <br><br>";
          echo "Type de compte : " . $type . "<br>";
          echo "Pseudonyme: " . $data['Pseudonyme'] . "<br>";
          echo "Email: " . $data['Email'] . "<br>";
          echo "Mot de Passe: " . $data['MotDePasse'] . "<br>";
        }
      }
    }
    else {
      echo "Base de donnée non trouvée <br>";
    }
  }
} else {
  echo "Erreur : $erreur";
}
?>