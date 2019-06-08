<?php
session_start();

$bdd = new PDO('mysql:host=localhost;dbname=ece_amazon', 'root', '');


if(isset($_GET['id']) AND $_GET['id'] > 0) 
{
   $iduser = intval($_GET['id']);
   $requser = $bdd->prepare('SELECT * FROM comptes WHERE ID = ?');
   $requser->execute(array($iduser));
   $infoscompte = $requser->fetch();
?>
<html>
<head>
   <title>Profil de <?php echo $infoscompte['Pseudonyme']; ?> </title>
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
       body {
          padding: 0px;
          margin: 0px;
          background: #f2f6e9;
          <?php if ($infoscompte['PhotoBack'] != "") { ?> background: url('photosbackground/<?php echo $infoscompte['PhotoBack']; ?>'); 
        <?php } ?>
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

   <div id="section">

       <div align="center">
         <h2>Profil de <?php echo $infoscompte['Pseudonyme']; ?> </h2>
         <br /><br />
         <?php
         if (!empty($infoscompte['PhotoProfil']))
         
         {
            ?>
            <img src="photosprofil/<?php echo $infoscompte['PhotoProfil']; ?>" width="150"/> 
         <?php
         }
         
         ?>
         <br />
         Pseudo = <?php echo $infoscompte['Pseudonyme']; ?>
         <br />
         Type de compte = <?php echo $infoscompte['TypeCompte']; ?>
         <br />
         Mail = <?php echo $infoscompte['Email']; ?>
         <br />
         Telephone = <?php echo $infoscompte['Telephone']; ?>
         <br />
         Adresse = <?php echo $infoscompte['Adresse']; ?>
         <br />
         Ville = <?php echo $infoscompte['Ville']; ?>
         <br />
         Pays = <?php echo $infoscompte['Pays']; ?>
         <br />
         <?php
         if(isset($_SESSION['id']) AND $infoscompte['ID'] == $_SESSION['id']) {
         ?>
         <br />
         <p>
      <a class="btn btn-primary" href="editionprofil.php">Editer mon profil</a>
      <a class="btn btn-primary" href="deconnexion.php">Se deconnecter</a>
   </p>
         
         <?php
         }
         ?>
         <p>
      <a  class="btn btn-secondary" href="accueil.php">Accueil</a>
        <?php
        if (isset($_SESSION['id']) AND $_SESSION['type'] == "ADMINISTRATEUR" AND $infoscompte['TypeCompte'] == "VENDEUR")
        {
        ?>
          <a class = "btn btn-outline-danger" href="suppcompte.php?id=<?php echo $infoscompte['ID'] ?>">Supprimer le vendeur</a>
        <?php
        }
        ?>
      
   </p>
      </div>
         </div>

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
else {
   header("Location: connexion.php");
}
?>



