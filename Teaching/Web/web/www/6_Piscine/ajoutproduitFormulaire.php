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

            .deconnexion{
                text-align: center; 
                float:right;
                font-size:150%;
            }
            
            #logo
            {
                background-color: red;
                width : max-width;
                height : 100;
            }
            
            
            #photo_produit
            {
                width:400px;
                height:400px;
                float : left;
            }
            #information
            {
               background-color: #67B59A;
            }
            #name
            {
                font-size: 300%;
                margin-top: 0em;
            }
            .vitrine_description
            {
                overflow: auto;
                overflow-x: hidden;
                height:142px;
                word-wrap: break-word;
            }
            footer
            {
                background: green;
                font-size: 60%;
            }
            
        </style>
    </head>
    
<?php

session_start();
$database="ece_amazon";
$db_handle = mysqli_connect('localhost', 'root', '');  
$db_found = mysqli_select_db($db_handle, $database);
$mail = $_SESSION["pseudo"];

$requete="SELECT * FROM vendeur WHERE mail= '$mail'";
    $data=mysqli_query($db_handle,$requete);
    if($result =  mysqli_fetch_assoc( $data )){

        while( $result =  mysqli_fetch_assoc( $data ))
        {
        echo '
    <body background="'. $result['photocouv'] .'">
        <div id="logo">
            <a href="index.php"><img  src="ECEamazon.png" alt="ECEamazon" /></a>';
        
                echo '<img style="float : right" src="' . $result['photo'] . '" alt="profilepic"/>';
                echo '<a style="float : right;font-size: 200%">' . $result['nom'] . '</a></div>';
            }
        
        
        
        echo '<div style= "background-color : red; position: sticky; top: 0;">
            <a class = "active" href="index.php">Home</a>
            <a class = "navtext" href="selcategorie.php">Categories</a>
            <a class = "navtext" href="VenteFlash.php">Vente flash</a>
            <a class = "navtext" href="Vendre.php">Vendre</a>
            <a class = "navtext" href="Compte.php">Votre compte</a>
            <a class = "navtext" href="Panier.php">Panier</a>
            <a class = "navtext" href="Admin.php">Admin</a>
            <a class="deconnexion" href="deconnecter.php">Deconnexion</a>
        </div>
        <a style="font-size : 250%"> Ajouter un produit</a><br/>
        <form action="ajoutproduit.php" method="post">
        <table>
            <tr>
                <td>Nom du produit</td>
                <td><input type="text" name="nom"/></td>
            </tr>
            <tr>
                <td>Description du produit</td>
                <td><input type="text" name="description"/></td>
            </tr>
            <tr>
                <td>Ajouter une image</td>
                <td><input type="text" name="photo" value="images/"/></td>
            </tr>
            <tr>
                <td>Prix</td>
                <td><input type="texts" name="prix"/></td>
            </tr>
            <tr>
                <td> Categorie </td>
                <td>
                     <select name="categorie">  
                        <option value="" selected="selected"> Choisissez une categorie </option>
                        <option value="Livre">Livre</option>
                        <option value="Musique">Musique</option>
                        <option value="Vetement">Vetement</option>
                        <option value="Sport et Loisirs">Sport et Loisirs</option>
                    </select>
                <td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Valider"/></td>
            </tr>
        </table>
    </form>';
        
    
    }else echo '<a style="font-size=197%">Veuillez vous connectez</a>';
      
    ?>
        
    </body>
    <footer>
         ECE_AMAZON.COM © tous droits reserves <br>
        2019 Flimon Zachary, Therre Mikhali, Brunelle Sebastien <br>
        Pour toute demande d'information/ signalement de problème de fonctionnement, merci de contacter l'administrateur du site a l'adresse
        <a href="Admin@gmail.com"> Admin@gmail.com </a>
    </footer>
</html>