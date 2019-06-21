
<?php

session_start();
$database="ece_amazon";
$db_handle = mysqli_connect('localhost', 'root', '');  
$db_found = mysqli_select_db($db_handle, $database);
$mail = $_SESSION["pseudo"];

$nom=$_POST['nom'];
$description=$_POST['description'];
$prix=$_POST['prix'];
$categorie=$_POST['categorie'];
$photo=$_POST['photo'];
    
if($categorie=="")
    echo '<a style="font-size:200%">Veuillez saisir une categorie</a>';
else
{
    $requete="SELECT * FROM article WHERE nom='$nom'";
    $data=mysqli_query($db_handle,$requete);
    if( $result =  mysqli_fetch_assoc( $data ) )
    {
    	$quantite=$result['quantite'];
    	$quantite=$quantite+1;
        $actualiser="UPDATE article SET Quantite='$quantite'";
        $quest=mysqli_query($db_handle,$actualiser);
    }
    else 
    {
    	$set_id="SELECT * FROM article ORDER BY id DESC";
    	$connaitre=mysqli_query($db_handle,$set_id);
    	$result =  mysqli_fetch_assoc( $connaitre );
    	$id=$result['id'];
    	$id=$id+1;
        $nouveau="INSERT INTO article (Nom, Description, Photo, Prix, Categorie, Quantite, Vente, id, Vendeur) VALUES ('$nom', '$description', '$photo', '$prix', '$categorie', '1', '0', '$id', '$mail')";
        $inserer=mysqli_query($db_handle,$nouveau);
        header('Location: VendreGestion.php');
    	exit();
    }
}
?>
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

?>
    
    </body>
</html>