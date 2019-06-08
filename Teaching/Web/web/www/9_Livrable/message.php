<?php 
//php qui affiche le message apres le paiement

session_start(); // Session ouverte

// connexion au serveur
define('DB_SERVER', 'localhost');
define ('DB_USER', 'root');
define ('DB_PASS', 'root');

        // identifier le nom de la base de données 
$database = "Projetweb";
        //connecter l'utilsateur dans la BDD
$db_handle = mysqli_connect (DB_SERVER, DB_USER, DB_PASS);
$db_found = mysqli_select_db ($db_handle, $database);
$newStock = 0;
$id_ = 0;
$workwith = $_SESSION['newvaleueonthecart'];

        // si la BDD existe, faire le traitement

if ($db_found) {

 $sql = "SELECT * FROM Items WHERE Id IN (".implode(',',array_keys($_SESSION['newvaleueonthecart'])).")";

                //$sql = "SELECT * FROM Items WHERE Id ='".$_GET["id"]."'";
 $result = mysqli_query ($db_handle, $sql);
 while ($data = mysqli_fetch_assoc($result)){


  $newStock = $data["Stock"]-$workwith[$data["Id"]]; 
  if($newStock == 0){
    $sql2 = "DELETE FROM Items WHERE Id ='".$data["Id"]."'";
    $result2 = mysqli_query ($db_handle, $sql2);
                        //header('Location: itemsenvente.php');

  } else {
    $sql23 = "UPDATE Items SET Stock ='".$newStock."' WHERE Id ='".$data["Id"]."'";
    $result23 = mysqli_query ($db_handle, $sql23);
                          //header('Location: itemsenvente.php');

  }
  $StockVendu = $data["StockVendu"] + $workwith[$data["Id"]];
  $sql6 = "UPDATE Items SET StockVendu ='".$StockVendu."' WHERE Id ='".$data["Id"]."'";
  $result6 = mysqli_query ($db_handle, $sql6);


  
                    }//end while
            }//end if

        // si la BDD n'existe pas 
            else {
              echo 'Database not found';
            }

        // Fermer la connection 
            mysqli_close($db_handle);




            ?>


            <html lang="en">
            <head>
              <meta charset="utf-8">
              <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
              <meta name="description" content="">
              <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
              <meta name="generator" content="Jekyll v3.8.5">
              <title>Message</title> <!--Titre barre de navigation internet-->

              <link rel="canonical" href="https://getbootstrap.com/docs/4.3/examples/checkout/">

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
              /* on centre le menu dans la page */
              #menu-deroulant {
                /* on centre le menu dans la page */    text-align: center;
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
                  </button>  <!-- Bouton qui revient a notre page d'accueil -->

                  <div class="navbar-collapse offcanvas-collapse" id="navbarsExampleDefault">
                    <ul class="navbar-nav mr-auto">
                      <ul id="menu-deroulant"> <!--Menu deroulant qui affiche les differentes categories-->
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
                    
                    <form class="form-inline my-2 my-lg-0">
                      <a href="panier.php" class="btn btn-lg btn-info"><img src=img/panier.png></a> <!--Bouton panier-->
                      <a class="nav-link text-white" href="deco.php">Se déconnecter</a>  <!--Bouton deconnexion-->
                    </form>
                  </div>
                </nav>
                
              </header>
              <br/> <br/>
              <section class="jumbotron text-center">
                <!--Milieu de page de notre site internet-->
                
                <div class="py-5 text-center text-info">
                  <h2>Transaction réussie</h2>
                  <p class="lead"></p>
                </div>
              </section>
              
              
              <div class="container">      
               
                <div class="text-center "> <!--Affichage du message de transaction reussi-->
                  <p>Un mail de confirmation vous a été envoyé a l'adresse suivante : <?php session_start(); echo $_SESSION["Email"]; ?> </br>Votre commande sera livrée sous un délai de 6 à 9 jours. Merci pour votre commande !<br>Voici l'adresse de livraison : <?php echo $_SESSION["Adresselivraison"]; ?> <?php session_start(); echo $_SESSION["CodePostal"]; ?> <?php session_start(); echo $_SESSION["Ville"]; ?> </p> 
                  <b>A bientôt !</b>
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
              </footer>
            </div> 
          </body>

          </html>


<?php session_start(); session_destroy(); ?> <!--Destruction de la session -->