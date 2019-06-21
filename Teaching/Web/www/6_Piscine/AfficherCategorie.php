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
               float: left;
               width: 68%;
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
if(isset($_SESSION["pseudo"])){
$mail = $_SESSION["pseudo"];

$requete="SELECT * FROM utilisateur WHERE mail= '$mail'";
$data=mysqli_query($db_handle,$requete);
if($result =  mysqli_fetch_assoc( $data )){
        echo '
    <body>
        <div id="logo">
            <a class="deconnexion" href="deconnecter.php">Deconnexion</a>
            <img src="ECEamazon.png" alt="ECEamazon" />
        </div>
        
        <div style= "background-color : red; position: sticky; top: 0;">
            <a class = "active" href="index.php">Home</a>
            <a class = "navtext" href="selcategorie.php">Categories</a>
            <a class = "navtext" href="VenteFlash.php">Vente flash</a>
            <a class = "navtext" href="Vendre.php">Vendre</a>
            <a class = "navtext" href="Compte.php">Votre compte</a>
            <a class = "navtext" href="Panier.php">Panier</a>
            <a class = "navtext" href="Admin.php">Admin</a>
        </div>';
        
        $categorie=$_POST['categorie'];
        
        if(isset($_POST['categorie']))
            $requete="SELECT * FROM article WHERE Categorie LIKE '%$categorie%'";
        else
            $requete="SELECT * FROM article";
        $data=mysqli_query($db_handle,$requete);
        while( $result =  mysqli_fetch_assoc( $data ) )
        {
            $article=$result['id'];
            $photo=$result['Photo'];
            echo    "<div id='photo_produit'><img src= $photo alt='Photoproduit'></div>";
            echo    '<div id="information"><h1 id="name">' . $result["Nom"] . '</h1><br>';
            echo    '<a> prix = </a></br><a style="font-size :250%;">' . $result["Prix"] . 'euro</a></br>';
            echo    '<h2> description : </h2> <div class="vitrine_description">'
                    . $result["Description"] . '</div></br>';
            echo    '<a href="ajouter_panier.php?id='.$article.'"> <img src="panier.png" width=100 height=50" /> </a></div>';
        }
    echo '</body>';
}else
{
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
        </div>';

        $categorie=$_POST['categorie'];
        
        if(isset($_POST['categorie']))
            $requete="SELECT * FROM article WHERE Categorie LIKE '%$categorie%'";
        else
            $requete="SELECT * FROM article";
        $data=mysqli_query($db_handle,$requete);
        while( $result =  mysqli_fetch_assoc( $data ) )
        {
            $article=$result['id'];
            $photo=$result['Photo'];
            echo    "<div id='photo_produit'><img src= $photo alt='Photoproduit'></div>";
            echo    '<div id="information"><h1 id="name">' . $result["Nom"] . '</h1><br>';
            echo    '<a> prix = </a></br><a style="font-size :250%;">' . $result["Prix"] . 'euro</a></br>';
            echo    '<h2> description : </h2> <div class="vitrine_description">'
                    . $result["Description"] . '</div></br></div>';
       
        }
        echo '</body>';
        
    
    }
    }
    }else{ echo '<body>
        <div id="logo"><img src="ECEamazon.png" alt="ECEamazon" /></div>
        
        <div style= "background-color : red; position: sticky; top: 0;">
            <a class ="navtext" href="index.php">Home</a>
            <a class ="active" href="selcategorie.php">Categories</a>
            <a class ="navtext" href="VenteFlash.php">Vente flash</a>
            <a class ="navtext" href="Vendre.php">Vendre</a>
            <a class ="navtext" href="Compte.php">Votre compte</a>
            <a class ="navtext" href="Panier.php">Panier</a>
            <a class ="navtext" href="Admin.php">Admin</a>
        </div>';
        
        $categorie=$_POST['categorie'];
        
        if(isset($_POST['categorie']))
            $requete="SELECT * FROM article WHERE Categorie LIKE '%$categorie%'";
        else
            $requete="SELECT * FROM article";
        $data=mysqli_query($db_handle,$requete);
        while( $result =  mysqli_fetch_assoc( $data ) )
        {
            $article=$result['id'];
            $photo=$result['Photo'];
            echo    "<div id='photo_produit'><img src= $photo alt='Photoproduit'></div>";
            echo    '<div id="information"><h1 id="name">' . $result["Nom"] . '</h1><br>';
            echo    '<a> prix = </a></br><a style="font-size :250%;">' . $result["Prix"] . 'euro</a></br>';
            echo    '<h2> description : </h2> <div class="vitrine_description">'
                    . $result["Description"] . '</div></br>';
            echo   '<a href="ajouter_panier.php?id='.$article.'"> <img src="panier.png" width=100 height=50" /> </a></div>';
        }
        echo '</body>';
    }


?>
<footer>
        ECE_AMAZON.COM © tous droits reserves <br>
        2019 Flimon Zachary, Therre Mikhali, Brunelle Sebastien <br>
        Pour toute demande d'information/ signalement de problème de fonctionnement, merci de contacter l'administrateur du site a l'adresse
        <a href="Admin@gmail.com"> Admin@gmail.com </a>
    </footer>
    </html>
