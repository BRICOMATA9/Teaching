<?php
  if (isset($_POST['envoie'])) 
  {
              $mail =isset($_POST["mail"])? $_POST["mail"]: "";
              $mdp =isset($_POST["mdp"])? $_POST["mdp"]: "";
              $nom=isset($_POST["nom"])? $_POST["nom"]: "";
              $prenom=isset($_POST["prenom"])? $_POST["prenom"]: "";
              $adresse=isset($_POST["adresse"])? $_POST["adresse"]: "";
              $codepostal=isset($_POST["codepostal"])? $_POST["codepostal"]: 0;
              $ville=isset($_POST["ville"])? $_POST["ville"]:"";
              $pays=isset($_POST["pays"])? $_POST["pays"]:"";
              $telephone=isset($_POST["telephone"])? $_POST["telephone"]:0;
              
              //Connection à la database
              $database= "projetweb";
              $db_handle = mysqli_connect('localhost', 'root', '');
              $db_found = mysqli_select_db($db_handle, $database);

              //Si la Bdd est trouvé envoi de la requête 
              if($db_found)
              {
                //Ajout dans BDD client 
                $sql = "INSERT INTO `client`(`email_client`, `password`, `nom_client`, `prenom_client`, `adresse_postale`, `code_postale`, `ville`, `pays`, `numero_tel`, `email`) VALUES ('$mail','$mdp','$nom','$prenom','$adresse','$codepostal','$ville','$pays','$telephone','')";

                //Ajout dans BDD connexion 
                $sql2 = "INSERT INTO `connexion`(`email`,`password`,`type`,`email_admin`,`email_vendeur`,`email_acheteur`) VALUES ('$mail','$mdp','Client','','','')";

                //Ajout d'un panier
                $sql3 = 'INSERT INTO `panier`( `email_client`) VALUES ("'.$mail.'")  '; 
              }

              $result = mysqli_query($db_handle, $sql);
              $result = mysqli_query($db_handle, $sql2);
              $result = mysqli_query($db_handle, $sql3);

              $_SESSION['email'] = $mail;
              header('Location: http://127.0.0.1/ProjetPiscineWeb/menu_principal.php');
              exit();
      }
?>

<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
<link rel="stylesheet" type="text/css" href="inscription.css">

<!DOCTYPE html>
<html>
<head>

    <title>Inscription</title>

    

</head>
<body>

<!-- La navBar de inscrition --> 


  <!-- Pour la navbar à remettre partout presque --> 
  
  <!-- Pour l'icone --> 
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">


  <!-- Le bootstrap --> 
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>


  <link rel="stylesheet" type="text/css" href="jolie.css">


  <!-- Pour le navbar login --> 
  <link rel="stylesheet" type="text/css" href="navbarLogin.css">

    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">

        <a class="navbar-brand" href="menu_principal.php"> <h2> ECE Amazon </h2> </a>



        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav mr-auto">
          
              <div class="nav-item dropdown">

                  <a class="btn btn-secondary btn-lg dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true"> Catégorie </a>
           
                <!-- Pour le dropdown -->
                <ul class="dropdown-menu multi-level" role="menu" aria-labelledby="dropdownMenu">
                

                    <li class="dropdown-submenu">
                      <a class="dropdown-item" href="#"> Livres </a>
                      <ul class="dropdown-menu">
                            <li> <a class="dropdown-item" href="#"> Educatif </a> </li>
                            <li> <a class="dropdown-item" href="#"> BD/Manga </a></li>
                              <li> <a class="dropdown-item" href="#"> Roman    </a></li>
                  </ul> 
              </li>

              <!-- Pour diviser les différentes catégories --> 
                    <div class="dropdown-divider"></div>


                    <li class="dropdown-submenu">
                      <a class="dropdown-item" href="#"> Vêtements </a>
                      <ul class="dropdown-menu">
                            <li> <a class="dropdown-item" href="#"> Lingerie </a> </li>
                            <li> <a class="dropdown-item" href="#"> Jogging </a></li>
                              <li> <a class="dropdown-item" href="#"> Jean    </a></li>
                  </ul>
                    </li>

                    <!-- Pour diviser les différentes catégories --> 
                    <div class="dropdown-divider"></div>


                    <li class="dropdown-submenu">
                      <a class="dropdown-item" href="#"> Sports & Loisirs </a>
                      <ul class="dropdown-menu">
                            <li> <a class="dropdown-item" href="#"> Pêches   </a> </li>
                            <li> <a class="dropdown-item" href="#"> Volley   </a></li>
                              <li> <a class="dropdown-item" href="#"> Basket    </a></li>
                  </ul>
              </li>

              <!-- Pour diviser les différentes catégories --> 
                    <div class="dropdown-divider"></div>


                    <li class="dropdown-submenu">
                      <a class="dropdown-item" href="#"> Musique </a>
                      <ul class="dropdown-menu">
                            <li> <a class="dropdown-item" href="#"> Rock      </a> </li>
                            <li> <a class="dropdown-item" href="#"> OST Animu </a></li>
                              <li> <a class="dropdown-item" href="#"> Jazz      </a></li>
                  </ul>
                    </li>


                </ul>
              </div>

          </ul>

          
          <!-- Tout ce qui se trouve à droite de la nav bar --> 
          <form class="form-inline my-2 my-lg-0">
          
              <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
              <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                
          <a class="nav-link" disabled="disabled"> <i class="fas fa-shopping-basket fa-3x"></i> </a>
          <button class="btn btn-outline-success my-2 my-sm-0" >
            <a class="nav-link" href="connexion.php" >  Connexion </a>
          </button> 

          </form>
        </div>

  </nav>
<!-- Fin de la navbar inscription --> 


<div class="container">
<div class="card bg-light">
	
  <form action="" method="post">
	   <!-- Email -->
    <div class="form-group input-group">

  		  <div class="input-group-prepend">
  		      <span class="input-group-text"> <i class="fa fa-at"></i> </span>
  		  </div>
       <input name="mail" class="form-control" placeholder="e-mail" type="text">
  
    </div> 

    <!-- Mot de passe -->
    <div class="form-group input-group">
    
    		<div class="input-group-prepend">
    		    <span class="input-group-text"> <i class="fa fa-lock"></i> </span>
    		</div>
        <input name="mdp" class="form-control" placeholder="Mot de passe" type="text">
    
    </div> 

    <!-- Nom -->
    <div class="form-group input-group">
    		
        <div class="input-group-prepend">
    		    <span class="input-group-text"> <i class="fa fa-user"></i> </span>
    		</div>
        <input name="nom" class="form-control" placeholder="Nom" type="text">
    
    </div> 
    
    <!-- Prenom -->
    <div class="form-group input-group">

  		  <div class="input-group-prepend">
  		      <span class="input-group-text"> <i class="fa fa-user"></i> </span>
  		  </div>
        <input name="prenom" class="form-control" placeholder="Prenom" type="text">

    </div> 

    <!-- Adresse -->
    <div class="form-group input-group">

  		  <div class="input-group-prepend">
  		      <span class="input-group-text"> <i class="fa fa-home"></i> </span>
  		  </div>
        <input name="adresse" class="form-control" placeholder="Adresse" type="text">

    </div> 

    <!-- Code Postal -->
    <div class="form-group input-group">

  		  <div class="input-group-prepend">
  		      <span class="input-group-text"> <i class="fa fa-envelope"></i> </span>
  		  </div>
        <input name="codepostal" class="form-control" placeholder="Code postal" type="number" max="99999" min="0" value="0">

    </div> 

    <!-- Ville -->
    <div class="form-group input-group">

		    <div class="input-group-prepend">
		        <span class="input-group-text"> <i class="fa fa-building"></i> </span>
		    </div>
        <input name="ville" class="form-control" placeholder="Ville" type="text">

    </div> 

    <!-- Pays -->
    <div class="form-group input-group">

		    <div class="input-group-prepend">
		        <span class="input-group-text"> <i class="fa fa-plane"></i> </span>
		    </div>
        <input name="pays" class="form-control" placeholder="Pays" type="text">

    </div>

    <!-- Num tel -->
    <div class="form-group input-group">
		<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-phone"></i> </span>
		 </div>
        <input name="telephone" class="form-control" placeholder="Numéro de Téléphone" type="number" min="0" value="0">
    </div> 

    <!-- Envoi du formulaire --> 
    <div class="form-group">
      <input type="submit" class="btn btn-primary" value="Ajouter" name="envoie"></input>
</form>
</div> 
</div>
</body>