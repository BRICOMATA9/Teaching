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

        }else{
            $requete="SELECT * FROM vendeur WHERE mail= '$mail'";
            $data=mysqli_query($db_handle,$requete);
            if ($result =  mysqli_fetch_assoc( $data )) {
             echo '
    <body background="'. $result['photocouv'] .'">
        <div id="logo">
            <a href="index.php"><img  src="ECEamazon.png" alt="ECEamazon" /></a>';
        
                echo '<img style="float : right" src="' . $result['photo'] . '" alt="profilepic"/>';
                echo '<a style="float : right;font-size: 200%">' . $result['nom'] . '</a></div>';
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
            }
        }
        }else

        echo'
        <div id="logo"><img src="ECEamazon.png" alt="ECEamazon" /></div>
        
        <div style= "background-color : red; position: sticky; top: 0;">
            <a class = "active" href="index.php">Home</a>
            <a class = "navtext" href="selcategorie.php">Categories</a>
            <a class = "navtext" href="VenteFlash.php">Vente flash</a>
            <a class = "navtext" href="Vendre.php">Vendre</a>
            <a class = "navtext" href="Compte.php">Votre compte</a>
            <a class = "navtext" href="Panier.php">Panier</a>
            <a class = "navtext" href="Admin.php">Admin</a>
        </div>';
        ?>
    </body>
</html>