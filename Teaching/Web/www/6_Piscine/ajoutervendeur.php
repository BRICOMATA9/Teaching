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
        </div>
<?php 



$database="ece_amazon";
$db_handle = mysqli_connect('localhost', 'root', '');  
$db_found = mysqli_select_db($db_handle, $database);

$mail=$_POST['mail'];
$mdp=$_POST['mdp'];
$nom=$_POST['nom'];
$prenom=$_POST['prenom'];
$photo=$_POST['photo'];
$photocouv=$_POST['photocouv'];


$requete="SELECT * FROM vendeur WHERE mail='$mail'";
$data=mysqli_query($db_handle,$requete);
    if( $result =  mysqli_fetch_assoc( $data ) )
        echo "Un compte utilisant cette adresse mail existe deja.";
    else 
    {
        $nouveau="INSERT INTO vendeur (nom, prenom,  mail, mdp,photo,photocouv) VALUES ('$nom', '$prenom',  '$mail', '$mdp','$photo','$photocouv')";
        $inserer=mysqli_query($db_handle,$nouveau);
    }
    header('Location:AdminGestion.php');


?>


</body>
</html>