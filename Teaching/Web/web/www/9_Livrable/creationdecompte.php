<?php 
//php pour creer un compte vendeur
//connexion au serveur

session_start();
define('DB_SERVER', 'localhost');
define ('DB_USER', 'root');
define ('DB_PASS', 'root');

$nom = $_POST["Nom"]; 
$prenom = $_POST["prenom"];

$pseudo = $_POST["Pseudo"];

$email = $_POST["Email"];
$mdp = $_POST["mdp"];

// identifier le nom de la base de données 
$database = "Projetweb";
//connecter l'utilsateur dans la BDD
$db_handle = mysqli_connect (DB_SERVER, DB_USER, DB_PASS);
$db_found = mysqli_select_db ($db_handle, $database);

// si la BDD existe, faire le traitement

if ($db_found) {
    $sql = "INSERT INTO `Vendeur` (`Admin`, `Email`, `PseudoVendeur`, `Password`, `Nom`, `Prenom`, `Photo`, `Fondecran`) VALUES ('Non','" .$email. "','". $pseudo. "','".$mdp."', '" .$nom. "','".$prenom."', 'photodeprofil.jpg', 'photodeprofil.jpg')";

   # session_destroy();
    #session_start();
                // On s'amuse à créer quelques variables de session dans $_SESSION
    #$_SESSION['Email'] = $email;
    #$_SESSION['Nom'] = $nom;
    #$_SESSION['Pseudo'] = $pseudo;
    #$_SESSION['Prenom'] = $prenom;
    #$_SESSION['Statut'] = "Vendeur";


    $result = mysqli_query($db_handle, $sql);
    header('Location: connexionvendeur1.php');
    }//end if

// si la BDD n'existe pas 
    else {
        echo 'Database not found';
    }

// Fermer la connection 
    mysqli_close($db_handle);
    ?>








