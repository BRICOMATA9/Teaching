<?php
    session_start(); // Session ouverte
    ?>
    <html lang="en">
    <head>
      <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
      <meta name="description" content="">
      <title>Categories : tous les articles</title><!--Titre barre de navigation internet-->

      <link rel="canonical" href="https://getbootstrap.com/docs/4.3/examples/album/">

      <!-- Bootstrap core CSS -->

      <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

      <!--Style de la page internet-->
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
      /*Style du menu deroulant */ 
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
    <header><!-- tete de notre site -->
<!-- barre de navigation de notre site -->
     <nav class="navbar navbar-expand-lg fixed-top navbar-dark bg-info">
      <a href="index.html" class="navbar-brand d-flex align-items-center">
        <img src="img/pierre.png"></a>
        <button class="navbar-toggler p-0 border-0" type="button" data-toggle="offcanvas">
          <span class="navbar-toggler-icon"></span>
        </button> <!-- Bouton qui revient a notre page d'acceuil -->

        <div class="navbar-collapse offcanvas-collapse" id="navbarsExampleDefault">
          <ul class="navbar-nav mr-auto">
            <ul id="menu-deroulant"> <!--Menu deroulant qui affiche les differentes categorie-->
              <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle text-white" href="categories.html" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Catégories</a> 
                <ul>
                  <li><a class="text-dark" href="livres.php">Livres</a></li>
                  <li><a class="text-dark" href="musique.php">Musique</a></li>
                  <li><a class="text-dark"href="vetements.php">Vêtements</a></li>
                  <li><a class="text-dark" href="sport.php">Sport et Loisirs</a></li>
                </ul>

              </li>
            </ul>  <!--Bouton de ventes flash-->
            <a class="nav-link text-white" href="ventesflash.php">Ventes Flash</a>
          </ul>

          <form class="form-inline my-2 my-lg-0">  <!--Bouton du panier-->
            <a href="panier.php" class="btn btn-lg btn-info"><img src=img/panier.png></a> 
            <a class="nav-link text-white" href="deco.php">Se déconnecter</a>
          </form> <!--Bouton deconnexion-->
        </div>
      </nav>

   <!--   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
      

      <script type="text/javascript">
        $(document).ready(function(){

          $("#gotopanier").click(function() {
            document.location.href="panier.php"; 

          });
        });

      </script>

        <button type="button" class="btn btn-dark btn-lg" id = "gotopanier">Panier</button>


        <?php 

       /* if(isset($_SESSION['Email'])){
            echo "<form method='POST' action='deco.php'>
           <input type='submit' name='deco' class='btn btn-dark btn-lg' value = 'deco'>
             </form>";
        }
        else {

        }

*/
        ?>
      -->






    </header>
    <br/> <br/><br/>

<!-- 
  <section class="jumbotron text-center">
    <div class="container">
      <div class="text"> <h4> Voici la liste des articles toute categorie confondu : </h4></div>
    </div>
  </section>			-->

  <div class="container">

<!--Categorie de tous les produits-->
    <div class="row">
      <div class="col-lg-3">
        <h1 class="my-4"> </h1>
        <div class="list-group">
          <a href="categories_all.php" class="btn btn-dark btn-sm ">Tout</a> 
          <a href="#" class="btn btn-outline-dark btn-sm ">Vetements</a> 
          <a href="#" class="btn btn-outline-dark btn-sm ">Musique</a> 
          <a href="#" class="btn btn-outline-dark btn-sm ">Sport et loisirs</a> 
          <a href="#" class="btn btn-outline-dark btn-sm ">Livres</a> 
        </div>
      </div>


<!--Gestion du stock et du panier : on regarde le stock met dans le panier et enleve du stock et vice versa-->
      <script type="text/javascript">

        function onchecklesstocks(stockenquestion, nombredanslepanier){

          if(stockenquestion - nombredanslepanier <=0){
            alert("Stock : "+ stockenquestion + " Panier : "+ stockenquestion + " Il est donc impossible de rajouter cette item au panier car il y en virtuellement plus en Stock.");
          }

        }


      </script>

      <?php 
      session_start(); // session ouverte

      define('DB_SERVER', 'localhost');
      define ('DB_USER', 'root');
      define ('DB_PASS', 'root');

// identifier le nom de la base de données 
      $database = "Projetweb";
//connecter l'utilsateur dans la BDD
      $db_handle = mysqli_connect (DB_SERVER, DB_USER, DB_PASS);
      $db_found = mysqli_select_db ($db_handle, $database);

// si la BDD existe, faire le traitement

      $i = 0;
//$image = "img/BOSE.png";
      $Stock = array();
      $workwith = $_SESSION['newvaleueonthecart'];



      if ($db_found) {
        $sql = "SELECT* FROM Items WHERE Categorie = 'Sport et Loisirs'";
        $result = mysqli_query ($db_handle, $sql);
        while ($data = mysqli_fetch_assoc($result)){

          $Stock[$data["Id"]]= $data["Stock"];

          if($i<5){
            if($i%4 == 3){
              echo " </div> <div class='row'> <div class='col-lg-3 col-md-6 mb-3'>
              <h1 class='my-4'> </h1> </div>";
            }
          } else {
            if($i==6 || $i==9 || $i==12){
              echo " </div> <div class='row'> <div class='col-lg-3 col-md-6 mb-3'>
              <h1 class='my-4'> </h1> </div>";
            }
          }   


          if(isset($workwith[$data["Id"]])){

          }
          else {
            $workwith[$data["Id"]] = 0;
          }
          $stockvirtu = $data['Stock']-$workwith[$data["Id"]];
          echo " <div class='col-lg-3 col-md-6 mb-3'>
          <h1 class='my-4'> </h1>
          <a href='article.php?param=".$data["Id"]."'><img class='card-img-top' src='".$data["Photo"]."' alt=''></a>
          <div class='card-body'>
          <h5 class='card-title'>
          <a href='#'>". $data['Nom'] ."</a>
          </h5>

          <h6>".$data['Prix']."€</h6>
          <p class='card-text'>".$data['Description']." </p>
          <p class='card-text'>Stock virtuel: ".$stockvirtu." </p>

          <form method= 'POST' action = 'cart.php?id=". $data["Id"]."&Stock=".$Stock[$data["Id"]]."&Panier=".$workwith[$data["Id"]]."'> 
          <input type= 'submit' class='float-right btn btn-dark btn-sm' value='Ajouter au panier' name = 'addtocart' onClick='onchecklesstocks(".$Stock[$data["Id"]].",".$workwith[$data["Id"]].")' ></input> </br>
          </form>

          </div>
          <div class='card-footer'>
          <small class='text-muted'>&#9733; &#9733; &#9733; &#9733; &#9734;</small>
          </div>
          </div>";

          $i = $i +1;

            }// end while
    }//end if

// si la BDD n'existe pas 
    else {
      echo 'Database not found';
    }

// Fermer la connection 
    mysqli_close($db_handle);
    ?>

  </div>
</div>

<!--Pied de page avec toutes les informations necessaire-->
<footer class="my-5 pt-5 text-muted text-center text-small">
  <p class="mb-1">Site A MA ZONE &copy; ECE A MA ZONE_2019</p>
  <ul class="list-inline">
    <li class="list-inline-item"><a href="#">Privacy</a></li>
    <li class="list-inline-item"><a href="#">Terms</a></li>
    <li class="list-inline-item"><a href="#">Support</a></li>
  </ul>
   <!--liens vers nos reseaux sociaux -->
  <p>Ou nous retrouver? Visiter notre<a href="https://www.facebook.com/A-MA-ZONE-2302826419965406/"> Facebook</a> ou notre page <a href="https://www.instagram.com/amazoneece/?hl=fr">Instagram</a>.</p>
  <p class="float-right">
    <a href="#">Haut de page</a> <!--lien qui remonte en haut de la page -->
  </p>
</footer>



</body>

