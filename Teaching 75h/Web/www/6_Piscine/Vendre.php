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
            footer
            {
                background-color: green;
                font-size: 60%;
            }
            
        </style>
    </head>
    <?php

    session_start();
    $database="ece_amazon";
    $db_handle = mysqli_connect('localhost', 'root', '');  
    $db_found = mysqli_select_db($db_handle, $database);

    if(isset($_SESSION["pseudo"])){
    $mail = $_SESSION["pseudo"];

    
    $requete="SELECT * FROM vendeur WHERE mail= '$mail'";
    $data=mysqli_query($db_handle,$requete);
    if ($result =  mysqli_fetch_assoc( $data )) {
        header('Location: VendreGestion.php');
        exit();
        }
    
    else
    {   
        echo '<div id="logo"><img src="ECEamazon.png" alt="ECEamazon" /></div>
            
            <div style= "background-color : red; position: sticky; top: 0;">
                <a class = "navtext" href="index.php">Home</a>
                <a class = "navtext" href="selcategorie.php">Categories</a>
                <a class = "navtext" href="VenteFlash.php">Vente flash</a>
                <a class = "active" href="Vendre.php">Vendre</a>
                <a class = "navtext" href="Compte.php">Votre compte</a>
                <a class = "navtext" href="Panier.php">Panier</a>
                <a class = "navtext" href="Admin.php">Admin</a>
                <a class="deconnexion" href="deconnecter.php">Deconnexion</a>
            </div>';
        echo '<h3> Vous etes connecter en tant que client, vous ne pouvez pas ajouter de produit a vendre </h3>';
        echo '<h3> Vous souhaitez vendre des articles sur ECE Amazon? Contactez notre administrateur pour creer un compte vendeur </h3>';   
    }
}
    else
    {

         echo'
            <div id="logo"><img src="ECEamazon.png" alt="ECEamazon" /></div>
            
            <div style= "background-color : red; position: sticky; top: 0;">
                <a class = "navtext" href="index.php">Home</a>
                <a class = "navtext" href="selcategorie.php">Categories</a>
                <a class = "navtext" href="VenteFlash.php">Vente flash</a>
                <a class = "active" href="Vendre.php">Vendre</a>
                <a class = "navtext" href="Compte.php">Votre compte</a>
                <a class = "navtext" href="Panier.php">Panier</a>
                <a class = "navtext" href="Admin.php">Admin</a>
            </div>
            <div>
            <h1> veuillez vous connecter</h1>
            <form action="Connecter.php" method="post">
                <table>
                    <tr>
                        <td>Adresse mail :</td>
                        <td><input type="text" name="mail"/></td>
                    </tr>
                    <tr>
                        <td>Mot de passe :</td>
                        <td><input type="text" name="mdp"/></td>
                    </tr>
                    <tr>
                        <td colspan="2"><input type="submit" value="Valider"/></td>
                    </tr>
                </table>
            </form>
        </div>';
    }
    ?>
    </body>
    <footer>
         ECE_AMAZON.COM © tous droits reserves <br>
        2019 Flimon Zachary, Therre Mikhali, Brunelle Sebastien <br>
        Pour toute demande d'information/ signalement de problème de fonctionnement, merci de contacter l'administrateur du site a l'adresse
        <a href="Admin@gmail.com"> Admin@gmail.com </a>
    </footer>
</html>
<!-- modifier l'adresse du header-->