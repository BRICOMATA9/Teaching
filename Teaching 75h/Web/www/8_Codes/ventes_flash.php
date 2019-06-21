<!-- PHP USER CONNECTE -->
<?php 
    session_start();
    
    //Partie USER
    //Partie USER
    if(isset($_SESSION['user'])){
        $user = $_SESSION['user'];
    }
    else{
        $user = "";
    }
    
        
    //identifier votre BDD
    $database = "ece_amazon";
    //connectez-vous dans votre BDD
    $db_handle = mysqli_connect('localhost', 'root', '');
    $db_found = mysqli_select_db($db_handle, $database);
    //Si la BDD est trouvée
    if($db_found){
        
    //recherche d'une connexion
    //on recherche dans les acheteurs
    $sql0 = "SELECT * FROM acheteurs WHERE connexion = 1";
    $result = mysqli_query($db_handle,$sql0);
    if(mysqli_num_rows($result) == 0){ //si ce n'est pas un acheteur
        //on recherche dans les vendeurs
        $sql0 = "SELECT * FROM vendeurs WHERE connexion = 1";
        $result = mysqli_query($db_handle,$sql0);
        if(mysqli_num_rows($result) != 0){ //si c'est un vendeur
            
            //on recherche dans les vendeurs
            $data = mysqli_fetch_array($result);
            $user_vendeur = $data['email'];
            
            //fond
            $fond = $data['fond'];

            //on recherche si c'est un admin
            if($data['ID'] == 6){
                $user_admin = $data['email'];
                
            } else {
                $user_admin = "";
            }
            
        } else {
            $user_vendeur = "";
        }
    
        $user_acheteur = "";
        
    } else { //si c'est un acheteur
        $data = mysqli_fetch_array($result);
        $user_acheteur = $data['email'];
        
        //donc ce n'est ni un vendeur ni un admin
        $user_vendeur = "";
        $user_admin = "";
    }
?>


<!-- OUVERTURE DE LA BDD POUR ENSUITE UTILISER PHP DANS LE CODE -->
<?php
    //identifier votre BDD
    $database = "ece_amazon";
    //connectez-vous dans votre BDD
    $db_handle = mysqli_connect('localhost', 'root', '');
    $db_found = mysqli_select_db($db_handle, $database);
    //Si la BDD est trouvée
    if($db_found){
?>

<!DOCTYPE html>
<html>
<head>
    <!-- TITRE A CHANGER POUR CHAQUE PAGE -->
    <title>Menu | ECE Amazon</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <!-- LIEN VERS LA PAGE DE CSS A CHANGER SELON LA PAGE -->
    <link rel="stylesheet" type="text/css" href="ventes_flash.css">
    <script type="text/javascript"> 
        $(document).ready(function(){
            $('body').css('background-image','url(<?php echo $fond; ?>)');
            $('.fondheader').css('background-color','white');
        });
    </script>
</head>
    
<body>
    <!-- BARRE DE NAVIGATION A CONSERVER POUR CHAQUE PAGE -->
    <nav class="navbar navbar-expand-md">
        <!-- Logo du site -->
        <a class="navbar-brand" href="menu.php"><img src="logo.png" alt="logo" height="70px" width="70px"></a>
        <!-- Hamburger des items lorsque la fenêtre rétrécit -->
        <button class="navbar-toggler navbar-dark" type="button" data-toggle="collapse" data-target="#navbarCategories">
            <span class="navbar-toggler-icon"></span>
        </button>
        <!-- Pages du site accessibles via le menu -->
        <div class="collapse navbar-collapse" id="navbarCategories">
            <ul class="navbar-nav mr-auto">
                <!-- item Catégories qui se déroule pour laisser paraître ses sous-items -->
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="navbarDropdown" role="button" data-toggle="dropdown">Catégories</a>
                    <!-- Sous-items -->
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="livres.php?click0=1">Livres</a>
                        <a class="dropdown-item" href="musique.php?click0=1">Musique</a>
                        <a class="dropdown-item" href="vetements.php?click0=1">Vêtements</a>
                        <a class="dropdown-item" href="sports_et_loisir.php?click0=1">Sports et Loisir</a>
                    </div>
                </li>
                <!-- item Ventes Flash -->
                <li class="nav-item">
                    <a class="nav-link" href="ventes_flash.php">Ventes Flash</a>
                </li>
                <!-- item Vendre -->
                <li class="nav-item">
                    <?php
                       if($user == ""){
                           echo '<a class="nav-link" href="connexion.php">';
                       } else if(($user == $user_vendeur) && ($user != $user_admin)){
                           echo '<a class="nav-link" href="ajout_item.php">'; 
                       } else if(($user == $user_acheteur) || ($user == $user_admin)){
                           echo '<a class="nav-link" href="#">';
                       }
                        echo 'Vendre</a>';
                    ?>
                </li>
                <!-- item Votre compte -->
                <li class="nav-item">
                    <?php
                       if($user == ""){
                           echo '<a class="nav-link" href="connexion.php">';
                       } else if($user == $user_acheteur){
                          echo '<a class="nav-link" href="votre_compte.php">'; 
                       } else if($user == $user_vendeur){
                            echo '<a class="nav-link" href="#">'; 
                       }
                        echo 'Votre compte</a>';
                    ?>
                </li>
                <!-- item Mon profil-->
                <li class="nav-item">
                    <?php
                       if($user == ""){
                           echo '<a class="nav-link" href="connexion.php">';
                       } else if($user == $user_vendeur){
                            echo '<a class="nav-link" href="mon_profil.php">'; 
                       } else if($user == $user_acheteur){
                            echo '<a class="nav-link" href="#">';
                       }
                        
                        echo 'Mon profil</a>';
                    ?>
                </li>
            </ul>
            <!-- item Connexion/Inscription à gauche -->
            <p class="nav-item left">
                <?php
                    if($user == ""){
                        echo '<a class="nav-link" href="connexion.php">Connexion | Inscription</a>';
                    } else {
                        echo '<form method="post" class="deco"><input style="background-color:#A02831;border:none" type="submit" class="nav-link" name="deconnect" value="'.$user.' | Déconnexion"></form>'; 
                    }
                ?>
                <!-- DECONNEXION -->
                <?php
                    if(isset($_POST['deconnect'])){
                        $sql="UPDATE vendeurs SET connexion = 0 WHERE email = '$user'";
                        $result = mysqli_query($db_handle,$sql);
                        
                        $sql="UPDATE acheteurs SET connexion = 0 WHERE email = '$user'";
                        $result = mysqli_query($db_handle,$sql);
                        
                        $_SESSION['user'] = "";
                        $user = $_SESSION['user'];
                        echo '<script language="Javascript">document.location.replace("menu.php");</script>';
                    }
                ?>
            <!-- item Mon panier -->
             <p class="nav-item left">
                 <?php
                    if(($user == "")||($user==$user_acheteur)){
                        echo '<a class="nav-link" href="mon_panier.php">';
                    
                    } else {
                        echo '<a class="nav-link" href="#">'; 
                    }
               
                    echo '<img src="panier.png" alt="logo" height="30px" width="25px"></a>';
                 ?>
            </p>
        </div>
    </nav> <!-- FIN DE LA BARRE DE NAVIGATION -->
    
    <!-- DEBUT DU HEADER : CE QUE L'ON DOIT ADAPTER/MODIFIER POUR CHAQUE PAGE -->
    <header>
        <div class="container-fluid">
            <!-- Première Ligne pour la bannière -->
            <!-- toujours garde le paragraphe pour avoir un espace au dessus de la bannière -->

            <div class="row">
                <!-- Affichage de la bannière -->
                <div>
                    <img src="ventes_flash.jpg" alt="Ventes Flash" class="img-fluid" width=100%>
                </div>
            </div>
            
            <!-- 2ème ligne pour afficher les derniers produits mis en vente -->
            <br>
            <div class="row">
                <h2>Ventes Flash</h2>
            </div>
            <br><br>
            <div class="row">
                <?php
                    //recherche des derniers vêtements mis en ligne
                   $sql = "SELECT * FROM vetements WHERE nb_vendus = (SELECT MAX(nb_vendus) FROM vetements)";
                            $result = mysqli_query($db_handle, $sql);

                            while($data = mysqli_fetch_array($result)){
                                $_SESSION['nom_sessionV'] = $data['nom'];
                                //Affichage de l'image des produits
                                echo '<div class="col-md-3 col-sm-6">';
                                echo '<div class="product-grid">';
                                echo '<div class="product-image">';
                                print '<img src="'. $data['photos'] .'" alt="' . $data['photos']. '" class="img-fluid"';
                                echo '<span class="product-trend-label"></span>';
                                echo '<ul class="social">
                                        <li><a href="" data-tip="Add to cart"><i class="fa fa-shopping-cart"></i></a></li>
                                        <li><a href="fiche_produit_vetements.php" data-tip="Quick view"><i class="fa fa-search"></i></a></li>
                                    </ul>';
                                echo '</div>';
                                echo '<div class="product-content">';
                                echo '<center><h5 style="color:#f6745a" class="title">'.$data['nom'].'</h5></center>';
                                echo '<center><h5><B>'  . $data['prix'] . '€ </B></h5></center></br></br>';
                                echo '</div>';
                                echo '</div>';
                                echo '</div>';
                                
                            }
                    //recherche des derniers albums
                    $sql = "SELECT * FROM musique WHERE nb_vendus = (SELECT MAX(nb_vendus) FROM musique)";
                     $result = mysqli_query($db_handle, $sql);

                            while($data = mysqli_fetch_array($result)){
                                $_SESSION['nom_sessionM'] = $data['nom'];
                                //Affichage de l'image des produits
                                echo '<div class="col-md-3 col-sm-6">';
                                echo '<div class="product-grid">';
                                echo '<div class="product-image">';
                                print '<img src="'. $data['photos'] .'" alt="' . $data['photos']. '" class="img-fluid"';
                                echo '<span class="product-trend-label"></span>';
                                echo '<ul class="social">
                                        <li><a href="" data-tip="Add to cart"><i class="fa fa-shopping-cart"></i></a></li>
                                        <li><a href="fiche_produit_musique.php" data-tip="Quick view"><i class="fa fa-search"></i></a></li>
                                    </ul>';
                                echo '</div>';
                                echo '<div class="product-content">';
                                echo '<center><h5 style="color:#f6745a" class="title">'.$data['nom'].'</h5></center>';
                                echo '<center><h5><B>'  . $data['prix'] . '€ </B></h5></center></br></br>';
                                echo '</div>';
                                echo '</div>';
                                echo '</div>';
                                
                            }
                            
        
                    //recherche des derniers livres mis en ligne
                    $sql = "SELECT * FROM livres WHERE nb_vendus = (SELECT MAX(nb_vendus) FROM livres)";
                    $result = mysqli_query($db_handle, $sql);

                            while($data = mysqli_fetch_array($result)){
                                $_SESSION['nom_sessionL'] = $data['nom'];
                                //Affichage de l'image des produits
                                echo '<div class="col-md-3 col-sm-6">';
                                echo '<div class="product-grid">';
                                echo '<div class="product-image">';
                                print '<img src="'. $data['photos'] .'" alt="' . $data['photos']. '" class="img-fluid"';
                                echo '<span class="product-trend-label"></span>';
                                echo '<ul class="social">
                                        <li><a href="" data-tip="Add to cart"><i class="fa fa-shopping-cart"></i></a></li>
                                        <li><a href="redirection_livres.php" data-tip="Quick view"><i class="fa fa-search"></i></a></li>
                                    </ul>';
                                echo '</div>';
                                echo '<div class="product-content">';
                                echo '<center><h5 style="color:#f6745a" class="title">'.$data['nom'].'</h5></center>';
                                echo '<center><h5><B>'  . $data['prix'] . '€ </B></h5></center></br></br>';
                                echo '</div>';
                                echo '</div>';
                                echo '</div>';
                                
                            }
        
                    //recherche des derniers sports et loisirs mise en ligne
                    $sql = "SELECT *  FROM sports_loisir WHERE nb_vendus = (SELECT MAX(nb_vendus) FROM sports_loisir)";
                            $result = mysqli_query($db_handle, $sql);

                            while($data = mysqli_fetch_array($result)){
                                $_SESSION['nom_sessionS'] = $data['nom'];
                                //Affichage de l'image des produits
                                echo '<div class="col-md-3 col-sm-6">';
                                echo '<div class="product-grid">';
                                echo '<div class="product-image">';
                                print '<img src="'. $data['photos'] .'" alt="' . $data['photos']. '" class="img-fluid"';
                                echo '<span class="product-trend-label"></span>';
                                echo '<ul class="social">
                                        <li><a href="" data-tip="Add to cart"><i class="fa fa-shopping-cart"></i></a></li>
                                        <li><a href="redirection_sportsloisir.php" data-tip="Quick view"><i class="fa fa-search"></i></a></li>
                                    </ul>';
                                echo '</div>';
                                echo '<div class="product-content">';
                                echo '<center><h5 style="color:#f6745a" class="title">'.$data['nom'].'</h5></center>';
                                echo '<center><h5><B>'  . $data['prix'] . '€ </B></h5></center></br></br>';
                                echo '</div>';
                                echo '</div>';
                                echo '</div>';
                                
                            }
                  
                ?>
        
            </div>    
        </div>
    </header>
    
<!-- BARRE DE FOOTER A CONSERVER POUR CHAQUE PAGE -->
    <footer class="footer_page">
        <div class="container">
            <div class="row">
                <!-- Informations supplémentaires -->
                <div class="col-lg-4 col-md-4 col-sm-12">
                    <h6 class="text-uppercase font-weight-bold">Informations additionnelles</h6> 
                    <p><b>Livraison</b> <br/> Sous 3 - 5 jours ouvrables, à domicile ou en point relais, sous presentation d'un justificatif de la commande et d'une pièce d'identité. </p> 
                    <p><b>Remboursement</b> <br/> Retour et échange gratuit sous un délais de 30 jours à partir de la réception du colis.</p>
                </div>
                <!-- Contact et connexion administration -->
                <div class="col-lg-4 col-md-4 col-sm-12">
                    <h6 class="text-uppercase font-weight-bold">Nous contacter</h6>
                    <p>
                        37, quai de Grenelle, 75015 Paris, France <br>
                        <a class="bottom" href="mailto:contact@ece-amazon.fr">contact@ece-amazon.fr</a><br>
                        +330102030405<br>
                    </p>
                    <h6>
                        <?php
                           if($user == ""){
                                echo '<a class="bottom" href="connexion.php">';
                           } else if($user == $user_admin){
                                echo '<a class="bottom" href="administration.php">'; 
                           } else {
                                echo '<a class="bottom" href="#">'; 
                           }
                            echo 'Connexion Administrateur</a>';
                        ?>
                     </h6>
                </div>
                <!-- Formulaire de contact -->
                <div class="col-lg-4 col-md-4 col-sm-12">
                    <h6 class="text-uppercase font-weight-bold">Des questions ? Contactez-nous !</h6>

                    <form method="POST" action="" >
                        <table>
                            <td><tr><div class="form-group"><input type="text" class="form-control" placeholder="Votre nom:" name="nom"> </div></tr></td>
                            <td><tr><div class="form-group"><input type="email" class="form-control" placeholder="Courriel:" name="email"></div></tr></td>
                            <td><tr><div class="form-group"><textarea class="form-control" rows="4" name="commentaires" placeholder="Vos commentaires"></textarea></div></tr> </td>
                            <td><tr><input type="submit" class="envoie btn btn-secondary btn-block" name="button_commentaires" value="Envoyer" ></tr></td>
                        </table>
                    </form>
                    <?php
                        if (isset($_POST['button_commentaires'])) {
                            //Verification si des cases sont vides
                            if(empty($_POST["nom"]) AND empty($_POST["email"]) AND empty($_POST["commentaires"])) {
                                $erreur = '<font color="red">Tous les champs nont pas été remplis. </font>';
                            }
                            else{
                                // on vérifie si le champ "nom" n'est pas vide
                                if(empty($_POST["nom"])) {
                                    $erreur = '<font color="red">Le champ nom est vide.</font>';
                                }
                                else {
                                    // on vérifie si le champ "Email" n'est pas vide
                                    if(empty($_POST["email"])) {
                                        $erreur = '<font color="red">Le champ Email est vide.</font>';
                                    } 
                                    else{
                                        // on vérifie si le champ "Commentaires" n'est pas vide
                                        if(empty($_POST["commentaires"])) {
                                            $erreur = '<font color="red">Le champ Commentaires est vide.<font>';
                                        }
                                        else{
                                            $erreur = '<font color="green">Votre message a bien été envoyé !</font';
                                        }
                                    }
                                }
                            }
                        }
                        if(isset($erreur)) {
                            echo $erreur;
                        }
                    ?>
                </div>
            </div>
            <!-- Copyright -->
            <div class="footer-copyright text-center">&copy; 2019 Copyright | Droit d'auteur: Equipe 36 Projet Web Dynamique
            </div>
        </div>
    </footer> <!-- FIN BARRE DE FOOTER -->
</body>
</html>

<!-- FERMETURE DE LA BDD -->
<?php    
    //affichage d'erreur si la BDD non trouvée et fermeture de la BDD
    } else {
         echo "Database not found.";
    }

    mysqli_close($db_handle);
?>
<!-- FERMETURE DE LA BDD -->
<?php    
    //affichage d'erreur si la BDD non trouvée et fermeture de la BDD
    } else {
         echo "Database not found.";
    }

    mysqli_close($db_handle);
?>