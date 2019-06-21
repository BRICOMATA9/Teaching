<?php

    session_start();

    //Partie USER
    if(isset($_SESSION['nom_sessionM'])){
        $nom = $_SESSION['nom_sessionM'];
    }
    else{
        $nom = "";
    }
    //identifier votre BDD
    $database = "ece_amazon";
    //connectez-vous dans votre BDD
    $db_handle = mysqli_connect('localhost', 'root', '');
    $db_found = mysqli_select_db($db_handle, $database);

    //Si la BDD est trouvée
    if($db_found){
        $sql = "SELECT * FROM musique WHERE nom = '$nom'";
        $result = mysqli_query($db_handle,$sql);
        
        header("Location: fiche_produit_musique.php");
    } else {
        echo "Database not found";
    }

?>