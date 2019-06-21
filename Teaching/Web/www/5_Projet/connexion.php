<?php
session_start();

$bdd = new PDO('mysql:host=localhost;dbname=ece_amazon', 'root', '');

$pseudoconnexion = isset($_POST["pseudoconnexion"])?$_POST["pseudoconnexion"] : "";
$passwconnexion = isset($_POST["passwconnexion"])?$_POST["passwconnexion"] : "";


if(isset($_POST['seconnecter']))
{
   if(!empty($pseudoconnexion) AND !empty($passwconnexion))
   {
      $reqcompte = $bdd->prepare("SELECT * FROM comptes WHERE Pseudonyme = ? AND MotDePasse = ?");
      $reqcompte->execute(array($pseudoconnexion, $passwconnexion));
      $compteexiste = $reqcompte->rowCount();
      echo "compte existe ?". $compteexiste;
      if($compteexiste == 1) {
         $infoscompte = $reqcompte->fetch();
         $_SESSION['id'] = $infoscompte['ID'];
         $_SESSION['pseudo'] = $infoscompte['Pseudonyme'];
         $_SESSION['email'] = $infoscompte['Email'];
         $_SESSION['type'] = $infoscompte['TypeCompte'];
         header("Location: profil.php?id=".$_SESSION['id']);
      } else {
         $err = "Erreur lors de la saisie de l'email ou du mot de passe.";
      }
   } else {
      $err = "Veuillez remplir les champs 'Pseudonyme' et 'Mot de Passe'.";
   }
}
?>




<html>
<head>
   <title>Connexion</title>
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
         <h2>Connexion</h2>
         <br /><br />
         <form method="POST" action="">
          <div>
            <div class="row">
              <div class="col-md-4"></div>
              <div class="col-md-4">
                <label>Pseudonyme : </label>
                <input type="text" name="pseudoconnexion" placeholder="Pseudonyme" class="form-control" />
                <label>Mot de Passe : </label>
                <input type="password" name="passwconnexion" placeholder="Mot de passe" class="form-control"  />
              </div>
              <div class="col-md-4"></div>
            </div>
          </div>
            
            
            <br /><br />
            <input type="submit" class="btn btn-outline-primary" name="seconnecter" value="Se connecter !" />
         </form>
         <?php
         if(isset($err)) {
            echo '<font color="red">'.$err."</font>";
         }
         ?>

         <p>
      <a href="accueil.php"><input class ="btn btn-outline-secondary" type = "submit" value = "Accueil"/></a>
      <a href="inscription.php"><input class ="btn btn-outline-secondary" type = "submit" value = "S'inscrire"/></a>
   </p>

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