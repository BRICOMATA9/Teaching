<?php
session_start();
?>
<!DOCTYPE html>
<html>
<head>
  <head>
   <title>Connexion</title>
   <meta charset="utf-8">
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <meta content="text/html; charset=iso-8859-2" http-equiv="Content-Type">
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
   <style>
.mySlides {display:block;}
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


<header class="page-header header container-fluid">

<div class="description">

<div class="w3-content w3-section" style="max-width:5000px">
  
  <img class="mySlides" src="images/livres.jpg" style="width:100%">
  <img class="mySlides" src="images/sports.jpg" style="width:100%">
  <img class="mySlides" src="images/vetement.jpg" style="width:100%">
  <img class="mySlides" src="images/musique.jpg" style="width:100%">
<br>
<br>
  <a class="nav-link" href="venteflash.php"><button class="btn btn-outline-secondary btn-lg">Découvrez nos meilleures ventes dans nos 4 catégories!</button></a>
</div>

</div>
</header>


<script>
var myIndex = 0;
carousel();

function carousel() {
  var i;
  var x = document.getElementsByClassName("mySlides");
  for (i = 0; i < x.length; i++) {
    x[i].style.display = "none";  
  }
  myIndex++;
  if (myIndex > x.length) {myIndex = 1}    
  x[myIndex-1].style.display = "block";  
  setTimeout(carousel, 4000); 
}

</script>

<footer class="page-footer">
  <div class="container">
    <div class="row">
      
        
        </div>
      
        <h6 class="text-uppercase font-weight-bold">Contact</h6>
        <p>
          37, quai de Grenelle, 75015 Paris, France <br>
          info_amazon@contact.fr <br>
          
        </p>
      
    
  </div>
  <div class="footer-copyright text-center">&copy; 2019 Copyright | Droit d'auteur: amazon.fr</div>
</footer>


</body>
</html> 