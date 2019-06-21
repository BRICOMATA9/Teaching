<?php
session_start();
$bdd = new PDO('mysql:host=localhost;dbname=ece_amazon', 'root', '');

$iditem = intval($_GET['id']); // id item
$iduser = 0; 
if (isset($_SESSION['id'])) { $iduser = $_SESSION['id']; } //id user

$suppitem = $bdd->prepare("SELECT Quantite FROM paniers WHERE IDAcheteur = ? AND IDItem = ?");
$suppitem->execute(array($iduser, $iditem));


//while ($infositemsupp = $suppitem->fetch())
while ($quantitepanier = $suppitem->fetch())
{
    $quant = $quantitepanier['Quantite'];

    $getOldQuant = $bdd->prepare("SELECT Quantite FROM items WHERE ID = ?");
    $getOldQuant->execute(array($iditem));
    $oldquant = $getOldQuant->fetch();
    echo "ancienne quant = ".$oldquant['Quantite']."<br>";
    echo "quantite du panier = ".$quantitepanier['Quantite']."<br>";
    $quant +=$oldquant['Quantite'];
    echo "nouvelle quantite = ".$quant."<br>";

    $updatequantite = $bdd->prepare("UPDATE items SET Quantite = ? WHERE ID = ?");
    $updatequantite->execute(array($quant, $iditem));

}
$suppitem = $bdd->prepare("DELETE FROM paniers WHERE IDAcheteur = ? AND IDItem = ?");
$suppitem->execute(array($iduser, $iditem));

header("Location: panier.php");
?>