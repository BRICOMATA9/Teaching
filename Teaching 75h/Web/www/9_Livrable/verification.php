<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
  <meta name="generator" content="Jekyll v3.8.5">
  <!-- titre de la barre de navigation internet -->
  <title>Vérification</title>

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
    
    <section class="jumbotron text-center">
      <!-- Milieu de page de notre site -->  
      <br/> <br/>
      <div class="py-5 text-center text-info">
        <h2>Vérification</h2>
        <p class="lead"></p>
      </div>
    </section>
    
    <div class="container"> 
      <!-- Formulaire de vérification de l'acheteur-->  
      <div class="row">
        <div class="col-md-12 order-md-1">
          <form class="needs-validation" action="checkconnexion.php" method="POST">
            
            <div class="row">
              <div class="col-md-3 mb-3">
              </div>
              <div class="col-md-6 mb-3">
                <label for="mail">E-mail</label><!-- Ajouter un email et obligation de renter une valeur -->  
                <input type="text" class="form-control" id="mail" name = "mail" placeholder="E-mail" value="" required>
                <div class="invalid-feedback">
                  Valid first name is required.
                </div>
              </div>
              <div class="col-md-3 mb-3">
              </div>
            </div>
            
            
            <div class="row">
              <div class="col-md-3 mb-3">
              </div>
              <div class="col-md-6 mb-3">
                <label for="mp">Mot de passe</label><!-- Ajouter un mp et obligation de rentrer une valeur-->  
                <input type="password" class="form-control" id="mp" name ="password" placeholder="Mot de passe" value="" required>
                <div class="invalid-feedback">
                  Valid first name is required.
                </div>
              </div>
              <div class="col-md-3 mb-3">
              </div>
            </div>
            
            <div class="row">
              <div class="col-md-3 mb-3">
              </div>
              <div class="col-md-6 mb-3">
                <button class="btn btn-light btn-outline-info btn-lg btn-block" type="submit">Valider</button><!-- bouton qui valide la vérification -->  
              </div>
              <div class="col-md-3 mb-3">
              </div>
            </div>   
            
          </form>

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
      </div>
    </div>
  </body>
</html><!-- fin du html -->