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


        $requete="SELECT * FROM panier";
        $data=mysqli_query($db_handle,$requete);
        while( $result =  mysqli_fetch_assoc( $data ) )
        {
           
           $article=$result['nom'];
            echo    '<div id="information"><h1 id="name">' . $result["nom"] . '</h1>';
            echo    '<a> prix = </a></br><a style="font-size :250%;">' . $result["prix"] . 'euro</a></br>';
            echo    '<h2> description : </h2> <div class="vitrine_description">'
                        . $result["description"] . '</div></br>';
            echo    '<h3> Quantite:' .$result["quantite"]. '<h3></div>';
            echo '<a href="supp_panier.php?id='.$result['id'].'"> Supprimer tous les '.$article.' du panier </a>';
            echo '<br> <br>';
            echo '<a href="supp_un_panier.php?id='.$result['id'].'"> Supprimer un '.$article.' du panier </a>';
            echo '<br> <br> <br> <br>';
        }

        echo 'Le montant de votre panier est de ';

        $calcul="SELECT * FROM panier";
        $parcourir=mysqli_query($db_handle,$calcul);
        $total=0;
        while($result=mysqli_fetch_assoc($parcourir))
        {
            $nombre=$result['quantite'];
            $cout=$result['prix'];
            $total=$total+$nombre*$cout;
        }

        $Procéder = "Procéder a l'achat";
    
        echo    '<a style="font-size :250%;">' . $total. 'euro</a> <br>';
        echo '<a href="Acheter.php">' . $Procéder . '</a></div>';

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
                        <a class = "navtext" href="index.php">Home</a>
                        <a class = "navtext" href="selcategorie.php">Categories</a>
                        <a class = "navtext" href="VenteFlash.php">Vente flash</a>
                        <a class = "navtext" href="Vendre.php">Vendre</a>
                        <a class = "navtext" href="Compte.php">Votre compte</a>
                        <a class = "active" href="Panier.php">Panier</a>
                        <a class = "navtext" href="Admin.php">Admin</a>
                        <a class="deconnexion" href="deconnecter.php">Deconnexion</a>
                    </div>';

                echo '<div> 
                        <h3> Vous etes connecte en tant que vendeur. Vous ne pouvez pas acheter de produits avec un compte vendeur. </h3>
                        <h3> Vous souhaitez acquerir un produit du site? Creez un compte client! </h3>';
         }
        
    }
}else{

        echo'
        <div id="logo"><img src="ECEamazon.png" alt="ECEamazon" /></div>
        
        <div style= "background-color : red; position: sticky; top: 0;">
            <a class = "navtext" href="index.php">Home</a>
            <a class = "navtext" href="selcategorie.php">Categories</a>
            <a class = "navtext" href="VenteFlash.php">Vente flash</a>
            <a class = "navtext" href="Vendre.php">Vendre</a>
            <a class = "navtext" href="Compte.php">Votre compte</a>
            <a class = "active" href="Panier.php">Panier</a>
            <a class = "navtext" href="Admin.php">Admin</a>
        </div>';

         $requete="SELECT * FROM panier";
        $data=mysqli_query($db_handle,$requete);
        while( $result =  mysqli_fetch_assoc( $data ) )
        {
           
           $article=$result['nom'];
            echo    '<div id="information"><h1 id="name">' . $result["nom"] . '</h1>';
            echo    '<a> prix = </a></br><a style="font-size :250%;">' . $result["prix"] . 'euro</a> <br>';
            echo    '<h2> description : </h2> <div class="vitrine_description">'
                        . $result["description"] . '</div></br>';
            echo    '<h3> Quantite:' .$result["quantite"]. '<h3></div>';
            echo '<a href="supp_panier.php?id='.$result['id'].'"> Supprimer tous les '.$article.' du panier </a>';
            echo '<br> <br>';
            echo '<a href="supp_un_panier.php?id='.$result['id'].'"> Supprimer un '.$article.' du panier </a>';
            echo '<br> <br> <br> <br>';
        }

        echo 'Le montant de votre panier est de ';

        $calcul="SELECT * FROM panier";
        $parcourir=mysqli_query($db_handle,$calcul);
        $total=0;
        while($result=mysqli_fetch_assoc($parcourir))
        {
            $nombre=$result['quantite'];
            $cout=$result['prix'];
            $total=$total+$nombre*$cout;
        }
        echo    '<a style="font-size :250%;">' . $total. 'euro</a> <br>';
        echo '<a href="Compte.php" style="font_size=228%">veulliez vous connecter pour acheter</a>';
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