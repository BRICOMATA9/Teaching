<?php
session_start();
$bdd = new PDO('mysql:host=localhost;dbname=ece_amazon', 'root', '');


$IDAcheteur = 0;
$itemajoute = 0;


//echo " quantite  " . $quantite . "<br>";

if(isset($_GET['id']) AND $_GET['id'] > 0) 
{
    $iditem = intval($_GET['id']);
    $reqitem = $bdd->prepare('SELECT * FROM items WHERE ID = ?');
    $reqitem->execute(array($iditem));
    $infositem = $reqitem->fetch();

    if (isset($_POST["ajouterPanier"]))
    {
        $quantite = isset($_POST['quantite'])?$_POST["quantite"] : "";
        echo "bonsoir _post";
        if (isset($_SESSION['id']))
        {
            $IDAcheteur = intval($_SESSION['id']);
        }
        else { $IDAcheteur = 0; }
        
        $verifItemPanier = $bdd->prepare("SELECT * from paniers WHERE IDAcheteur = ? AND IDItem = ?");
        $verifItemPanier->execute(array($IDAcheteur, $iditem));
        $nbrow = $verifItemPanier->rowCount();

        if ($nbrow == 0)
        {
            echo "<br>no item already<br>";
            $addpanier = $bdd->prepare("INSERT INTO paniers(IDAcheteur, IDItem, Quantite, IDVendeur) VALUES (?, ?, ?, ?)");
            $addpanier->execute(array($IDAcheteur, $iditem, $quantite, $infositem['IDVendeur']));
        }
        else
        {
            echo "<br>an item already<br>";
            $reqQuantitePanier = $bdd->prepare("SELECT * from paniers WHERE IDAcheteur = ? AND IDItem = ?");
            $reqQuantitePanier->execute(array($IDAcheteur, $iditem));
            $infoQuantitePanier = $reqQuantitePanier->fetch();
            $newQuant = $quantite + $infoQuantitePanier['Quantite'];

            $addpanier = $bdd->prepare("UPDATE paniers SET Quantite = ? WHERE IDAcheteur = ? AND IDItem = ?");
            $addpanier->execute(array($newQuant, $IDAcheteur, $iditem));
        }

        $quantiterestante = $infositem['Quantite']-$quantite;
        echo "il reste ".$quantiterestante." items <br>";
   
        $updatequantite = $bdd->prepare("UPDATE items SET Quantite = ? WHERE ID = ?");
        $updatequantite->execute(array($quantiterestante, $iditem));
        echo "quantite updated <br>";
        $itemajoute = 1;
        $iditem = intval($_GET['id']);
        $reqitem = $bdd->prepare('SELECT * FROM items WHERE ID = ?');
        $reqitem->execute(array($iditem));
        $infositem = $reqitem->fetch();
    }

?>
<!DOCTYPE html>
<html>
<head>
    <title> <?php echo $infositem['NomItem']; ?></title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet"
    href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="vente.css">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    <script type="text/javascript">
         $(document).ready(function(){
         $('.header').height($(window).height());
         });
    </script>
    <style type="text/css">
        .doublepad {
            box-shadow: 1px 1px 4px rgba(0, 0, 0, 0.4);
            border:1px solid #8b919c;
            }
    </style>
</head>
<body>
<nav class="navbar navbar-expand-md">      
    <a href = "accueil.php"><img class="Eceamazon" src="images/logo.png" width="80" height="80"></a>
    <div class="collapse navbar-collapse" id="main-navigation">
        <ul class="navbar-nav">
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">Catégories</a>
                <div class="dropdown-menu">
                    <a class="dropdown-item" href="categories.php?type=Livre">Livres</a>
                    <a class="dropdown-item" href="categories.php?type=Musique">Musique</a>
                    <a class="dropdown-item" href="categories.php?type=Vetement">Vêtements</a>
                    <a class="dropdown-item" href="categories.php?type=Loisir">Sports & Loisir</a>
                    <a class="dropdown-item" href="categories.php?type=All">Toutes les catégories</a>
                </div>
            </li>
            <li class="nav-item dropdown" >
                <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">Ventes flash</a>
                <div class="dropdown-menu">
                    <a class="dropdown-item" href="venteflash.php">Livres</a>
                    <a class="dropdown-item" href="venteflash.php">Musique</a>
                    <a class="dropdown-item" href="venteflash.php">Vêtements</a>
                    <a class="dropdown-item" href="venteflash.php">Sports & Loisir</a>
                    <a class="dropdown-item" href="venteflash.php">Toutes les catégories</a>
                </div>
            </li>
            <li class="nav-item"><a class="nav-link" href="vente.php">Vendre</a></li>
            <li class="nav-item"><a class="nav-link" href = "profil.php?id=<?php echo $_SESSION['id'] ?>"><img  width="50" height="50" src="images/team.png"></a></li>
            <li class="nav-item"><a class="nav-link" href = "panier.php"><img  width="50" height="50" src="images/cart.png"></a></li>
        </ul>
    </div>
</nav>
<div id="container">
    <div class="section">
        <form action="" method="post">
            <br>
            <img  src="articles/<?php echo $infositem['Photo']?>" height="300" ><br>
            <?php   
                echo "Nom : " . $infositem['NomItem']. "<br>"; 
                echo "Video : " . $infositem['Video']. "<br>";
                echo "Description : " . $infositem['Description']. "<br>";
                echo "Prix : " . $infositem['Prix']. "<br>";
                echo "Quantité : " . $infositem['Quantite']. "<br>";
                echo "Profil du vendeur : ";
            ?>
                
            <a class = "btn btn-outline-secondary" href="profil.php?id=<?php echo $infositem['IDVendeur'] ?>">Profil du vendeur</a>
                
                <select class="form-control col-sm-1" name="quantite" id="sel1">
                    <?php
                    for ($i = 1; $i<$infositem['Quantite']+1; $i++)
                    {
                        echo "<option value=".$i.">".$i ."</option>";
                    }
                    ?>
                </select>
            <?php
            if ($infositem['TypeItem'] == "Livre")
            {
                echo "Auteur : " . $infositem['Auteur']. "<br>";
            }
            if ($infositem['TypeItem'] == "Musique")
            {
                echo "Artiste : " . $infositem['Artiste']. "<br>";
            }
            if ($infositem['TypeItem'] == "Vetement")
            {
                echo "Genre : " . $infositem['Genre']. "<br>";
                echo "Couleur : " . $infositem['Couleur']. "<br>";
                if ($infositem['TypeVetement'] == "Chaussures")
                {
                    echo "Pointure : " . $infositem['Pointure']. "<br>";
                }
                if ($infositem['TypeVetement'] == "Habits")
                {
                    echo "Taille : " . $infositem['Taille']. "<br>";
                }
            }

            if($_SESSION['type'] != "VENDEUR" AND (!isset($quantiterestante)) OR $quantiterestante != 0)
            {
                ?>
                <input type = "submit" value = "Ajouter au panier" name="ajouterPanier"/>
                <?php
                if ($itemajoute == 1)
                {
                    echo "vous ajoutez ".$quantite. " ".$infositem['NomItem']. " a votre panier";
                }
            }
            else if ($quantiterestante == 0)
            {
                if ($_SESSION['type'] == "VENDEUR") {
                    echo "Les vendeurs ne sont pas autorisés à acheter. (sauf admin) <br>";
                }
                else {  echo "RUPTURE DE STOCK"; }
                
               
            }
            ?>
        </form>
        

    </div>
</div>
    
    <p>
        <a href="accueil.php">Retour</a> à la page d'accueil.
    </p>
</div>
    
<footer class="page-footer">
    <div class="container">
        <div class="row">
            <div class="col-lg-8 col-md-8 col-sm-12">
                <h6 class="text-uppercase font-weight-bold">Information additionnelle</h6>
                <p>
                    Info1
                </p>
                <p>
                    Info2
                </p>
            </div>
            <div class="col-lg-4 col-md-4 col-sm-12">
                <h6 class="text-uppercase font-weight-bold">Contact</h6>
                <p>
                    37, quai de Grenelle, 75015 Paris, France <br>
                    info@webDynamique.ece.fr <br>
                    +33 01 02 03 04 05 <br>
                    +33 01 03 02 05 04
                </p>
            </div>
        </div>
    </div>
    <div class="footer-copyright text-center">&copy; 2019 Copyright | Droit d'auteur: webDynamique.ece.fr</div>
</footer>
</body>
</html>
<?php
}
?>
