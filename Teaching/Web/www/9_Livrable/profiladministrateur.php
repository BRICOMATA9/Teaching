<!-- gestion du profil administrateur avec la base de données -->
<?php 
session_start();


if($_SESSION['Email'] == NULL || $_SESSION['Email'] == ""){
  header('Location: index.html');

}


?>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
  <meta name="generator" content="Jekyll v3.8.5">
  <title>Votre profil</title><!-- titre de la barre de navigation internet -->

  <link rel="canonical" href="https://getbootstrap.com/docs/4.3/examples/checkout/">

  <!-- Bootstrap core CSS -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

  <!-- Style de la page internet -->
  <style>
  .bd-placeholder-img {
    font-size: 1.125rem;
    text-anchor: middle;
    -webkit-user-select: none;
    -moz-user-select: none;
    -ms-user-select: none;
    user-select: none;
  }
  @media (min-width: 768px) {
    .bd-placeholder-img-lg {
      font-size: 3.5rem;
    }
  }
  
  #menu-deroulant, #menu-deroulant ul {
    padding: 0;
    margin: 0;
    list-style: none;
  }
  #menu-deroulant {
    /* on centre le menu dans la page */
    text-align: center;
  }
  #menu-deroulant li {
    /* on place les liens du menu horizontalement */
    display: inline-block;
  }
  #menu-deroulant ul li {
    /* on enlève ce comportement pour les liens du sous menu */
    display: inherit;
  }
  #menu-deroulant a {
    text-decoration: none;
    display: block;
    /**color: #FFFFFF;*/
  }
  #menu-deroulant ul {
    position: absolute;
    /* on cache les sous menus complètement sur la gauche */
    left: -999em;
    text-align: left;
    z-index: 1000;
  }
  #menu-deroulant li:hover ul {
    /* Au survol des li du menu on replace les sous menus */
    left: auto;
  }
</style>
<!-- Custom styles for this template -->
<link href="album.css" rel="stylesheet">
</head>


<body>
  <!-- tete de notre site -->
  <header>
    <!-- Barre de navigation de notre site -->
    <nav class="navbar navbar-expand-lg fixed-top navbar-dark bg-info">
      <!-- bouton qui revient a notre page d'accueil -->
      <a href="index.html" class="navbar-brand d-flex align-items-center">
        <img src="img/pierre.png"></a>
        <button class="navbar-toggler p-0 border-0" type="button" data-toggle="offcanvas">
          <span class="navbar-toggler-icon"></span>
        </button>

        <div class="navbar-collapse offcanvas-collapse" id="navbarsExampleDefault">
          <ul class="navbar-nav mr-auto">
            <!-- menu deroulant qui affiche les differentes categories -->
            <ul id="menu-deroulant">
              <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle text-white" href="categories.html" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Catégories</a>
                <ul>
                  <li><a class="text-dark" href="livres.php">Livres</a></li>
                  <li><a class="text-dark" href="musique.php">Musique</a></li>
                  <li><a class="text-dark"href="vetements.php">Vêtements</a></li>
                  <li><a class="text-dark" href="sport.php">Sport et Loisirs</a></li>
                </ul>

              </li>
            </ul>
            <!-- bouton des ventesflash -->
            <a class="nav-link text-white" href="ventesflash.php">Ventes Flash</a>
          </ul>
          
          <form class="form-inline my-2 my-lg-0">
            <!-- bouton du panier -->
            <a href="panier.php" class="btn btn-lg btn-info"><img src=img/panier.png></a> 
            <!-- bouton deconnexion -->
            <a class="nav-link text-white" href="deco.php">Se déconnecter</a>
          </form>
        </div>
      </nav>
      
    </header>

    <br/> <br/>

    <section class="jumbotron text-center">
      <!-- Milieu de page de notre site -->
      
      <div class="py-5 text-center text-info">
        <h2>Votre Profil</h2>
        <p class="lead">Vous êtes administrateur et vendeur sur A MA ZONE ? Vous pouvez gérer les vendeurs et mettre en vente un ou plusieurs articles !</p>
      </div>
    </section>

    <div class="container">
      <!-- Affichage du profil administrateur -->
      <div class="row"> 
        <div class="col-md-6">
          <h4>Votre profil</h4>
          <!--<p><img src="img/bose.png"></p><br/><br/>  -->    <p><img src=<?php echo $_SESSION['Photo']; ?>></p><br/><br/> 



        </div>
        <div class="col-md-">
          <p><br/><br/>Nom: <?php echo $_SESSION['Nom']; ?> <br/>Prénom: <?php echo $_SESSION['Prenom']; ?> <br/> Pseudo: <?php echo $_SESSION['Pseudo']; ?><br/>E-mail: <?php echo $_SESSION['Email']; ?> </p> <!-- affichage des informations personnelles du vendeur -->
        </div>
      </div>

    </div>



    <div class="content">
      <div class="row">
        <div class="col-md-4">
        </div>
        <div class="col-md-4">
          <div class="card mb-4 shadow-sm">
            <a href="gerervendeurs.php"><img src="img/administrateur.jpg" alt="responsive" class="img-thumbnail"></a> 
            <div class="card-body">
              <p class="card-text"> Gérer les vendeurs </p><!-- boutons pour gerer les vendeur -->
              <div class="d-flex justify-content-between align-items-center">
              </div>
            </div>
          </div>    

          <div class="col-md-4">
          </div>
        </div>
        
        
      </div>



      <div class="content">
        <div class="row">
          <div class="col-md-1">
          </div>
          <div class="col-md-5">
            <div class="card mb-4 shadow-sm">
              <a href="itemsenvente.php"><img src="img/itemsenvente.jpg" alt="responsive" class="img-thumbnail"></a> 
              <div class="card-body">
                <p class="card-text"> Voir tous vos articles en vente</p><!-- bouton pour voir tous les articles en vente sur le site -->
                <div class="d-flex justify-content-between align-items-center">
                </div>
              </div>
            </div>
          </div>
          
          <div class="col-md-5">
            <div class="card mb-4 shadow-sm">
              <a href="ajouterItems.php"><img src="img/ajouteritems.jpg" alt="responsive" class="img-thumbnail"></a> 
              <div class="card-body">
                <p class="card-text"> Ajouter un ou plusieurs articles</p><!-- abouton pour ajouter un ou plusieurs articles sur le site -->
                <div class="d-flex justify-content-between align-items-center">
                </div>
              </div>
            </div>
          </div>
          <div class="col-md-1">
          </div>
        </div>


      </div>




      <!-- pied de page de notre site --> 
      <footer class="my-5 pt-5 text-muted text-center text-small">
        <p class="mb-1">Site A MA ZONE &copy; ECE A MA ZONE_2019</p>
        <ul class="list-inline">
          <li class="list-inline-item"><a href="#">Privacy</a></li>
          <li class="list-inline-item"><a href="#">Terms</a></li>
          <li class="list-inline-item"><a href="#">Support</a></li>
        </ul>
        <!-- liens de nos reseaux sociaux-->
        <p>Ou nous retrouver? Visiter notre<a href="https://www.facebook.com/A-MA-ZONE-2302826419965406/"> Facebook</a> ou notre page <a href="https://www.instagram.com/amazoneece/?hl=fr">Instagram</a>.</p>
        <p class="float-right">
          <a href="#">Haut de page</a><!-- bouton qui ramene en haut de la page -->
        </p>
      </footer>

    </div>

    <script src="form-validation.js"></script></body>
</html><!-- fin du html -->