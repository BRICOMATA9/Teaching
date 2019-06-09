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
            
            ul{
                list-style-type: none;
                margin: 0;
                padding: 0;
            }
            li{
                font-size: 500%;
            }
            
        </style>
    </head>
    <body>
        <div id="logo"><img src="ECEamazon.png" alt="ECEamazon" /></div>
        
        <div style= "background-color : red; position: sticky; top: 0;">
            <a class ="navtext" href="index.html">Home</a>
            <a class ="navtext" href="selcategorie.html">Categories</a>
            <a class = "active" href="VenteFlash.html">Vente flash</a>
            <a class ="navtext" href="Vendre.php">Vendre</a>
            <a class ="navtext" href="Compte.html">Votre compte</a>
            <a class ="navtext" href="Panier.php">Panier</a>
            <a class ="navtext" href="Admin.php">Admin</a>
        </div>
    </body>
</html>

        <?php

        $database="ece_amazon";
        $db_handle = mysqli_connect('localhost', 'root', '');  
        $db_found = mysqli_select_db($db_handle, $database);

        $id=$_GET["id"];
        $requete="SELECT * FROM article WHERE id='$id'";
        $data=mysqli_query($db_handle,$requete);
        while( $result =  mysqli_fetch_assoc( $data ) )
        {
            $nom = $result["Nom"] ;
            $prix = $result["Prix"] ;
            $description=$result["Description"];
            $decrementer=$result["Quantite"];
            $incrementer=$result["Vente"];

        }
        
        $requeto = "SELECT * FROM panier WHERE id='$id'";
        $verif=mysqli_query($db_handle,$requeto);
        if($test = mysqli_fetch_assoc( $verif ))
        {
            $yoyo= $test["quantite"]+1;
            $requete4="UPDATE panier SET quantite = '$yoyo' WHERE id = '$id'";
            mysqli_query($db_handle,$requete4);

        }

        else
        {
            echo "ok";
            echo $nom;
            $nouveau="INSERT INTO panier (nom,prix,quantite,id,description) VALUES ('$nom', '$prix','1', '$id', '$description')";
            $inserer=mysqli_query($db_handle,$nouveau);
        }

        header('Location: selcategorie.php');
        ?>
   

