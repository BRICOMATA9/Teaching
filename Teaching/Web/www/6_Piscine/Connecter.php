<html>
    <head>
        <style>
            .navtext {
                color : blue;
                font-size: 300%;
                padding: 2px;
                text-decoration : none;
            }
            .navtext:hover {
                background-color: lightblue;
            }
            .active {
                background-color: #4CAF50;
                color : blue;
                font-size: 300%;
                padding: 2px;
                text-decoration : none;
            }
            
            #logo
            {
                background-color : red;
                width : max-width;
                height : 100;
            }

            .deconnexion{
                text-align: center; 
                float:right;
                font-size:150%;
            }
            
        </style>
    </head>

<?php
session_start();
$database="ece_amazon";
$db_handle = mysqli_connect('localhost', 'root', '');  
$db_found = mysqli_select_db($db_handle, $database);

$mail=$_POST['mail'];
$mdp=$_POST['mdp'];

$requete="SELECT * FROM utilisateur WHERE mail='$mail' AND mdp='$mdp'";
$data=mysqli_query($db_handle,$requete);
  	if( $result =  mysqli_fetch_assoc( $data ) )
    {
    	$_SESSION['pseudo']=$mail;
    	header('Location: index.php');
        exit();
    }else{
        $requete="SELECT * FROM vendeur WHERE mail='$mail' AND mdp='$mdp'";
        $data=mysqli_query($db_handle,$requete);
        if($result =  mysqli_fetch_assoc( $data )){
            if($result["mail"] == 'Admin@gmail.com')
            {
                $_SESSION['pseudo']=$mail;
                header('Location: AdminGestion.php');
                exit();
            }

            $_SESSION['pseudo']=$mail;
           header('Location: VendreGestion.php');
            exit();
        }else {
            echo '<body>
        
                <div id="logo">
                    <a class="deconnexion" href="deconnecter.php">Deconnexion</a>
                    <img src="ECEamazon.png" alt="ECEamazon" />
                </div>
        
        <div style= "background-color : red; position: sticky; top: 0;">
            <a class = "navtext" href="index.php">Home</a>
            <a class = "navtext" href="selcategorie.php">Categories</a>
            <a class = "navtext" href="VenteFlash.php">Vente flash</a>
            <a class = "navtext" href="Vendre.php">Vendre</a>
            <a class = "active" href="Compte.php">Votre compte</a>
            <a class = "navtext" href="Panier.php">Panier</a>
            <a class = "navtext" href="Admin.php">Admin</a>
        </div>';
            echo '<h2> Mot de passe ou adresse mail incorrect. </h2>
                <a  href="nouveaucompte.php">pas encore inscrit ?</a>';
    }
}
?>
</body>
</html>