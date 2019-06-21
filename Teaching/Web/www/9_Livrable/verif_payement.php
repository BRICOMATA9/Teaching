<!-- php qui permet de verifier que le numero de la carte bancaire rentré correspond au numéro de carte de l'acheteur dans la base de données-->  
<?php 

//connexion serveur 
session_start();
define('DB_SERVER', 'localhost');
define ('DB_USER', 'root');
define ('DB_PASS', 'root');

$numcarte = $_POST["num_carte"];

// identifier le nom de la base de données 

$database = "Projetweb";
//connecter l'utilsateur dans la BDD
$db_handle = mysqli_connect (DB_SERVER, DB_USER, DB_PASS);
$db_found = mysqli_select_db ($db_handle, $database);

// si la BDD existe, faire le traitement

if ($db_found) {
    $sql = "SELECT* FROM Acheteur WHERE Paiement='".$numcarte."' AND Email ='".$_SESSION["Email"]."'";
    $result = mysqli_query ($db_handle, $sql);


    while ($data = mysqli_fetch_assoc($result)){



        if(mysqli_num_rows ($result) == 1){
            header('Location: message.php');
        }
        else {
            header('Location: index.html');

        }
    }
    }//end if

// si la BDD n'existe pas 
    else {
        echo 'Database not found';
    }

// Fermer la connection 
    mysqli_close($db_handle);




    ?>

