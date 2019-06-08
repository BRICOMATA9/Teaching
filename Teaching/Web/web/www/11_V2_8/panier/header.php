<!DOCTYPE html>
<!--
	Auteurs : Clément LARIVIERE	TD10
			  Théo MERCIER		TD04
			  Antoine PAINCHAUX TD01
-->
<html lang="fr">
<head>
	<title>ECE Amazon : Le site d'e-commerce de l'École Centrale d'Électronique</title>
	<meta charset="utf-8">
	<meta name="description" content="Site officiel d'e-commerce de l'École Centrale d'Électronique">
	<meta name="keywords" content="ECE, e-commerce, Amazon, ECE, Paris, Campus, Eiffel, Campus Eiffel">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="../styles/index.css">
	<link rel="stylesheet" type="text/css" href="../styles/panier.css">
	<link rel="shortcut icon" href="../images/logo.gif">
	
	<link rel="canonical" href="https://getbootstrap.com/docs/4.3/examples/jumbotron/">

    <!-- Bootstrap core CSS -->

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
    </style>
	
</head>

<header>
	<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark" id="main-navigation">
		<a class="navbar-brand" href="../index.html"><img alt= "Logo d'ECE Amazon" height="70" src="../images/logo.gif" width="70"></a>
		<button class="navbar-toggler navbar-dark" type="button" data-toggle="collapse" data-target="#main-navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		
		<div class="collapse navbar-collapse" id="navbarsExampleDefault">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item dropdown">
					<a class="nav-link dropdown-toggle" id="categorie" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Catégories</a>
					<div class="dropdown-menu" aria-labelledby="categorie">
						<a class="dropdown-item" href="../categorie/livres.php">Livres</a>
						<a class="dropdown-item" href="../categorie/musiques.php">Musiques</a>
						<a class="dropdown-item" href="../categorie/vetements.php">Vêtements</a>
						<a class="dropdown-item" href="../categorie/sports_loisirs.php">Sports & Loisirs</a>
					</div>
				</li>
				
				<li class="nav-item"><a class="nav-link" href="../venteFlash/venteFlash.php">Ventes Flash</a></li>
				<li class="nav-item"><a class="nav-link" href="../vendre/vendre.php">Vendre</a></li>
				<li class="nav-item"><a class="nav-link" href="../mon_compte/mon_compte.php">Votre Compte</a></li>
				<li class="nav-item"><a class="nav-link" href="../admin/admin.php">Admin</a></li>
				<!--<li a class="nav-item mb-3 my-2 my-lg-0" href="#"><img alt= "Panier" height="50" src="images/panier.gif" width="50"></li>-->
			</ul>
			<a class="btn btn-bd-download d-none d-lg-inline-block mb-3 my-2 my-lg-0" href="panier.php"><img alt= "Panier" height="50" src="../images/panier.gif" width="50"></a>
		</div>
	</nav>
</header>

</html>