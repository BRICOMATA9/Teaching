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
            .fenetre {
                width :200 px;
                height : 200 px;
                border-style: solid;
                border-width: 1px;
                margin : 5 px;
                float: left;
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

         $recupere_image="SELECT * FROM vendeur WHERE nom='Hina'";
         $faire=mysqli_query($db_handle,$recupere_image);
         $affiche=mysqli_fetch_assoc( $faire );

        echo '<body background="'. $affiche['photocouv'] .'">
        <div id="logo"><img src="ECEamazon.png" alt="ECEamazon" /></div>
        
        <div style= "background-color : red; position: sticky; top: 0;">
            <a class = "navtext" href="index.php">Home</a>
            <a class = "navtext" href="selcategorie.php">Categories</a>
            <a class = "navtext" href="VenteFlash.php">Vente flash</a>
            <a class = "navtext" href="Vendre.php">Vendre</a>
            <a class = "navtext" href="Compte.php">Votre compte</a>
            <a class = "navtext" href="Panier.php">Panier</a>
            <a class = "active" href="Admin.php">Admin</a>
        </div>
        <div style="float:right">
            <a href="ajoutervendeur_menu.php">ajouter un vendeur</a> <br>
            <a class="deconnexion" href="deconnecter.php">Deconnexion</a>
        </div>';
        

        
        $requete="SELECT * FROM vendeur";
        $data=mysqli_query($db_handle,$requete);

        echo'<br>';
          while( $result =  mysqli_fetch_assoc( $data ) )
        {
                $vendeur=$result['nom'];
                $photo=$result['photo'];

                if($result['mail']!='Admin@gmail.com'){
                    echo '<div class="fenetre">
                                    <img src='.$photo.' alt="profilepic"/>
                                    <a style="float = top"> '.$vendeur.' </a>
                                    <form action="suppvendeur.php?id='.$vendeur.'" method="post">
                                        <input type="submit" value="Supprimer"/>
                                    </form>
                                </div>';
                    }
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


<!-- a automatiser -->

