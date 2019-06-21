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
    session_start();
    $database="ece_amazon";
    $db_handle = mysqli_connect('localhost', 'root', '');  
    $db_found = mysqli_select_db($db_handle, $database);

    if(!isset($_SESSION['pseudo']))
    {
        echo '<a href="Compte.php"> Veuillez vous connecter </a> ';
    }

    else
    {
        $requete="SELECT * FROM panier";
        $data=mysqli_query($db_handle,$requete);
        while($result=mysqli_fetch_assoc( $data ))
        {
            $id=$result["id"];
            $decrementer=$result['quantite'];

            $quantite="SELECT * FROM article WHERE id='$id'";
            $compter=mysqli_query($db_handle,$quantite);
            $combien=mysqli_fetch_assoc( $compter );
            $quantite_ini=$combien['Quantite'];
            $vente_ini=$combien['Vente'];
            $nouv_quan=$quantite_ini-$decrementer;
            $nouv_vent=$vente_ini+$decrementer;
            $requete="UPDATE article SET Quantite='$nouv_quan' WHERE id='$id'";
            mysqli_query($db_handle,$requete);
            $requete2="UPDATE article SET Vente='$nouv_vent' WHERE id='$id'";
            mysqli_query($db_handle,$requete2);

           
        }
        $vider="DELETE FROM panier";
        $data=mysqli_query($db_handle,$vider);

        $verifier="SELECT * FROM article";
        $parcourir=mysqli_query($db_handle,$verifier);
        while($result=mysqli_fetch_assoc( $parcourir ))
        {
            $supprimer="DELETE FROM article WHERE Quantite='0'";
            mysqli_query($db_handle,$supprimer);
        }

    }
    header('Location: index.php');


?>