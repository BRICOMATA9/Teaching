<?php 
//php pour la connexion vendeur
session_start();//session start

define('DB_SERVER', 'localhost');
define ('DB_USER', 'root');
define ('DB_PASS', 'root');

$emailvendeur = $_POST["mail"];
$passwordvendeur = $_POST["password"];

// identifier le nom de la base de données 

$database = "Projetweb";
//connecter l'utilsateur dans la BDD
$db_handle = mysqli_connect (DB_SERVER, DB_USER, DB_PASS);
$db_found = mysqli_select_db ($db_handle, $database);

// si la BDD existe, faire le traitement

if ($db_found) {
    $sql = "SELECT* FROM Vendeur WHERE Email = '". $emailvendeur."' AND Password = '". $passwordvendeur. "'";
    $result = mysqli_query ($db_handle, $sql);
    if(mysqli_num_rows ($result)==1){
        while ($data = mysqli_fetch_assoc($result)){
                // On démarre la session AVANT d'écrire du code HTML
            session_destroy();
            session_start();

                // On s'amuse à créer quelques variables de session dans $_SESSION
            $_SESSION['Email'] = $data['Email'];
            $_SESSION['Nom'] = $data['Nom'];
            $_SESSION['Pseudo'] = $data['PseudoVendeur'];
            $_SESSION['Prenom'] = $data['Prenom'];
            $_SESSION['Statut'] = "Vendeur";
            $_SESSION['Photo'] = $data["Photo"];
            $_SESSION['Admin'] = $data["Admin"];

            header('Location: profilvendeur.php');


            }// end while
        } else {

            header('Location: connexionvendeur1.php?action=message');

        }


    }//end if

// si la BDD n'existe pas 
    else {
        echo 'Database not found';
    }

// Fermer la connection 
    mysqli_close($db_handle);
    ?>