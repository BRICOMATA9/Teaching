<!-- PHP USER CONNECTE -->
<?php 
    session_start();
    
    //$user = "admin@ece.amazon.fr";
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
                
            } 
            else { //ce n'est pas un admin
                $user_admin = "";
            }
            
        } //si ce n'est pas une vendeur
        else {
            $user_vendeur = "";
        }
    
        $user_acheteur = "";
        
    } 
    else { //si c'est un acheteur
        $data = mysqli_fetch_array($result);
        $user_acheteur = $data['email'];

        //donc ce n'est ni un vendeur ni un admin
        $user_vendeur = "";
        $user_admin = "";
    }
?>

<!DOCTYPE html>
<html>
<head>
    <!-- TITRE A CHANGER POUR CHAQUE PAGE -->
    <title>Administration | ECE Amazon</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    <!-- LIEN VERS LA PAGE DE CSS A CHANGER SELON LA PAGE -->
    <link rel="stylesheet" type="text/css" href="administration.css">
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
        <div class="container">
            <!-- Titre de la page -->
            <h2 class="titre">Compte Administrateur</h2>
            <!-- Boutons d'ajouts (vendeur ou produit) -->
            <div class="row">
                <div class="col-lg-6 col-md-6 col-sm-12">
                    <center><a class="lien" href="ajout_item.php"><button type="button" class="add btn btn-primary">Vendre un produit</button></a></center>
                </div>
                <div class="col-lg-6 col-md-6 col-sm-12">
                    <center><a class="lien" href="ajout_vendeur.php"><button type="button" class="add btn btn-success">Ajouter un vendeur</button></a></center>
                </div>
            </div>
            <!-- division de la page en 3 colonnes -->
            <div class="row">
                <!-- 1ère colonnes : Affichage des vendeurs -->
                <div class="col-lg-3 col-md-3 col-sm-12" style="background-color:#A02831;margin-bottom:30px">
                    <p></p>
                    <?php
                        //recherche de tous les vendeurs
                        $sql = "SELECT * FROM vendeurs WHERE ID !=6 ";
                        $result = mysqli_query($db_handle, $sql);
                        while($data = mysqli_fetch_assoc($result)){
                            
                            //affichage de certains attributs des vendeurs
                            echo '<p style="background-color:#FCAB9C;padding:10px">';
                            print '<img style="float:left;padding-right:10px" src="'. $data['photo'] .'" alt="' . $data['photo']. '" class="img-fluid" width=20%>';
                            echo "Pseudo: " . $data['pseudo'] . '<br>';
                            echo "Nom: " . $data['nom'] . '<br>';
                            echo "Email: " . $data['email'] . '<br>';   
                            echo "Solde: " . $data['solde'] . '€<br>'; 
                            echo "Nombre de ventes: " . $data['nb_ventes'] . '<br>'; 
                            echo '<form style="padding:5px 10px 5px 10px;color:white" method="post">';
                            echo '<tr>';
                            echo '<td><input type="radio" id="1" name="choix" value="'.$data['pseudo'].'">';
                            echo '<label for="1">Voir ses produits</label></td>';
                            echo '</tr><br>';
                            echo '<tr>';
                            echo '<td><input type="radio" id="2" name="choix" value="'.$data['email'].'">';
                            echo '<label for="2">Supprimer ce vendeur</label></td>';
                            echo '</tr><br>';
                            echo '<tr><td><center><input type="submit" style="background-color:black;color:white" class="btn btn-sm" name="valider" value="Valider"></center></td></tr></form>';
                            echo '</p>';
                        }
                    ?>       
                    <?php
                        if(isset($_POST['valider'])){
                            
                            $choix = $_POST['choix'];
                                                        
                            //si l'admin a décidé de supprimer
                            $sql = "SELECT * FROM vendeurs WHERE email = '$choix'";
                            $result = mysqli_query($db_handle,$sql);
                            if(mysqli_num_rows($result) != 0){   
                                
                                //suppression du vendeur
                                $sql = "DELETE FROM vendeurs WHERE email = '$choix'";
                                $result = mysqli_query($db_handle,$sql);
                                echo '<script language="Javascript">document.location.replace("administration.php");</script>';
                            }
                        }
                    ?> 
                </div>
                
                <!-- 2ème colonnes : Affichage des produits dépendant du vendeur cliqué -->
                <div class="col-lg-3 col-md-3 col-sm-12" style="padding:40px 0px 40px 10px">
                    <?php
                        if(isset($_POST['valider'])){
                            
                            $choix = $_POST['choix'];
                            
                            //si l'admin a décidé de voir les produits du vendeur
                            $sql = "SELECT * FROM vendeurs WHERE pseudo = '$choix'";
                            $result = mysqli_query($db_handle,$sql);
                            if(mysqli_num_rows($result) != 0){
                                
                                //récupération de la variable ID_vendeur
                                $data = mysqli_fetch_assoc($result);
                                $ID_vendeur = $data['ID'];

                                //recherche des vêtements vendus par le vendeur cliqué
                                $sql = "SELECT * FROM vetements WHERE ID_vendeur='$ID_vendeur'";
                                $result = mysqli_query($db_handle, $sql);
                                //affichage sous forme de liste non ordonnée
                                print '<ul>';
                                //affichage de la requête
                                while($data = mysqli_fetch_assoc($result)){
                                    echo '<h5 style="color:#A02831">VETEMENTS</h5>';
                                    print '<li>';
                                    print '<h6 style="color:#F6745A"><u>' . $data['nom'] . '</u></h6>';
                                    echo '<form method="post">';
                                    echo '<tr>';
                                    echo '<td><input type="radio" id="1" name="choix2" value="'.$data['nom'].'">';
                                    echo '<label for="1">Voir</label></td>';
                                    echo '</tr><br>';
                                    echo '<tr>';
                                    echo '<td><input type="radio" id="2" name="choix2" value="'.$data['description'].'">';
                                    echo '<label for="2">Supprimer</label></td>';
                                    echo '</tr><br>';
                                    echo '<tr><td><input type="submit" style="background-color:black;color:white" class="btn btn-sm" name="valider2" value="Valider"></td></tr></form>';
                                    print '</li><br><br>';
                                }

                                //recherche des musiques vendues par le vendeur cliqué
                                $sql = "SELECT * FROM musique WHERE ID_vendeur='$ID_vendeur'";
                                $result = mysqli_query($db_handle, $sql);
                                //affichage de la requête
                                while($data = mysqli_fetch_assoc($result)){
                                    echo '<h5 style="color:#A02831">MUSIQUE</h5>';
                                    print '<li>';
                                    print '<h6 style="color:#F6745A"><u>' . $data['nom'] . '</u></h6>';
                                    echo '<form method="post">';
                                    echo '<tr>';
                                    echo '<td><input type="radio" id="1" name="choix2" value="'.$data['nom'].'">';
                                    echo '<label for="1">Voir</label></td>';
                                    echo '</tr><br>';
                                    echo '<tr>';
                                    echo '<td><input type="radio" id="2" name="choix2" value="'.$data['description'].'">';
                                    echo '<label for="2">Supprimer</label></td>';
                                    echo '</tr><br>';
                                    echo '<tr><td><input type="submit" style="background-color:black;color:white" class="btn btn-sm" name="valider2" value="Valider"></td></tr></form>';
                                    print '</li><br><br>';
                                }

                                //recherche des livres vendus par le vendeur cliqué
                                $sql = "SELECT * FROM livres WHERE ID_vendeur='$ID_vendeur'";
                                $result = mysqli_query($db_handle, $sql);
                                //affichage de la requête
                                while($data = mysqli_fetch_assoc($result)){
                                    echo '<h5 style="color:#A02831">LIVRES</h5>';
                                    print '<li>';
                                    print '<h6 style="color:#F6745A"><u>' . $data['nom'] . '</u></h6>';
                                    echo '<form method="post">';
                                    echo '<tr>';
                                    echo '<td><input type="radio" id="1" name="choix2" value="'.$data['nom'].'">';
                                    echo '<label for="1">Voir</label></td>';
                                    echo '</tr><br>';
                                    echo '<tr>';
                                    echo '<td><input type="radio" id="2" name="choix2" value="'.$data['description'].'">';
                                    echo '<label for="2">Supprimer</label></td>';
                                    echo '</tr><br>';
                                    echo '<tr><td><input type="submit" style="background-color:black;color:white" class="btn btn-sm" name="valider2" value="Valider"></td></tr></form>';
                                    print '</li><br><br>';
                                }

                                //recherche des sports et loisir vendus par le vendeur cliqué
                                $sql = "SELECT * FROM sports_loisir WHERE ID_vendeur='$ID_vendeur'";
                                $result = mysqli_query($db_handle, $sql);
                                //affichage de la requête
                                while($data = mysqli_fetch_assoc($result)){
                                    echo '<h5 style="color:#A02831">SPORTS ET LOISIR</h5>';
                                    print '<li>';
                                    print '<h6 style="color:#F6745A"><u>' . $data['nom'] . '</u></h6>';
                                    echo '<form method="post">';
                                    echo '<tr>';
                                    echo '<td><input type="radio" id="1" name="choix2" value="'.$data['nom'].'">';
                                    echo '<label for="1">Voir</label></td>';
                                    echo '</tr><br>';
                                    echo '<tr>';
                                    echo '<td><input type="radio" id="2" name="choix2" value="'.$data['description'].'">';
                                    echo '<label for="2">Supprimer</label></td>';
                                    echo '</tr><br>';
                                    echo '<tr><td><input type="submit" style="background-color:black;color:white" class="btn btn-sm" name="valider2" value="Valider"></td></tr></form>';
                                    print '</li><br><br>';
                                }
                                print '</ul>';
                                
                            }
                        }
                    ?>
                </div>
                    
                <!-- 3ème colonne : Affichage de la description dépendant du produit -->
                <div class="col-lg-6 col-md-6 col-sm-12" style="padding-top:50px">
                    <?php
        
                        if(isset($_POST['valider2'])){
                            
                            $choix = $_POST['choix2'];

                            //si l'admin a décidé de voir plus d'infos sur le produit
                            $sql = "SELECT * FROM vetements WHERE nom = '$choix'";
                            $result = mysqli_query($db_handle,$sql);
                            if(mysqli_num_rows($result) != 0){   

                                while($data = mysqli_fetch_assoc($result)){
                                    echo '<div style="background-color:lightyellow">';
                                    echo '<h4 style="color:#F6745A;text-align:center;padding-top:30px">'.$data['nom'] . '</h4><br>';
                                    echo '<p style="text-align:center;padding:0px 20px 0px 20px"><em>'.$data['description'] . '</em></p>';
                                    echo '<B><p style="padding-left:60px">';
                                    echo "Genre: " .$data['genre'] . '<br>';
                                    echo "Couleur: " .$data['couleur'] . '<br>';
                                    echo "Taille: " .$data['taille'] . '<br>';
                                    echo "Type: " .$data['type'] . '<br>';
                                    echo "Modèle: " .$data['modele'] . '<br>';
                                    echo "Matière: " .$data['matiere'] . '<br>';
                                    echo'</p></B>';
                                    print '<center><img class="img" src="'. $data['photos'] .'" alt="' . $data['photos']. '" height="350px"></center>';
                                    if($data['photo2'] != ""){
                                        print '<br><center><img class="img" src="'. $data['photo2'] .'" alt="' . $data['photo2']. '" height="350px"></center>';
                                    }
                                    if($data['video'] != ""){
                                        echo '<br><center><iframe src="' . $data['video'] . '"></iframe></center>';
                                    } 
                                    echo '<br><B><p style="padding-left:60px">';
                                    echo "Prix de l'article: " .$data['prix'] . ' €<br>';
                                    echo "Stock: ".$data['stock'] . '<br>';
                                    echo "Nombre d'articles vendus: ".$data['nb_vendus'] . '<br>';
                                    echo "Date de mise en ligne: ".$data['date_ligne'] . '<br><br>'; 
                                    echo '</B></p></div>';
                                }

                            } else {

                                //si l'admin a décidé de voir plus d'infos sur le produit
                                $sql = "SELECT * FROM livres WHERE nom = '$choix'";
                                $result = mysqli_query($db_handle,$sql);
                                if(mysqli_num_rows($result) != 0){   

                                    while($data = mysqli_fetch_assoc($result)){
                                        echo '<div style="background-color:lightyellow">';
                                    echo '<h4 style="color:#F6745A;text-align:center;padding-top:30px">'.$data['nom'] . '</h4><br>';
                                        echo '<p style="text-align:center;padding:0px 20px 0px 20px"><em>'.$data['description'] . '</em></p>';
                                        echo '<B><p style="padding-left:60px">';
                                        echo "Auteur: " .$data['auteur'] . '<br>';
                                        echo "Année de publication: " .$data['annee_publication'] . '<br>';
                                        echo "Edition: " .$data['edition'] . '<br>';
                                        echo "Type: " .$data['type'] . '<br>';
                                        echo "Genre: " .$data['genre'] . '<br>';
                                        echo'</p></B>';
                                        print '<center><img class="img" src="'. $data['photos'] .'" alt="' . $data['photos']. '" height="350px"></center>';
                                        if($data['photo2'] != ""){
                                            print '<br><center><img class="img" src="'. $data['photo2'] .'" alt="' . $data['photo2']. '" height="350px"></center>';
                                        }
                                        if($data['video'] != ""){
                                            echo '<br><center><iframe src="' . $data['video'] . '"></iframe></center>';
                                        } 
                                        echo '<br><B><p style="padding-left:60px">';
                                        echo "Prix de l'article: " .$data['prix'] . ' €<br>';
                                        echo "Stock: ".$data['stock'] . '<br>';
                                        echo "Nombre d'articles vendus: ".$data['nb_vendus'] . '<br>';
                                        echo "Date de mise en ligne: ".$data['date_ligne'] . '<br><br>'; 
                                        echo '</B></p></div>';
                                    }

                                } else {

                                    //si l'admin a décidé de voir plus d'infos sur le produit
                                    $sql = "SELECT * FROM musique WHERE nom = '$choix'";
                                    $result = mysqli_query($db_handle,$sql);
                                    if(mysqli_num_rows($result) != 0){   

                                        while($data = mysqli_fetch_assoc($result)){
                                            echo '<div style="background-color:lightyellow">';
                                            echo '<h4 style="color:#F6745A;text-align:center;padding-top:30px">'.$data['nom'] . '</h4><br>';
                                            echo '<p style="text-align:center;padding:0px 20px 0px 20px"><em>'.$data['description'] . '</em></p>';
                                            echo '<B><p style="padding-left:60px">';
                                            echo "Artiste: " .$data['artiste'] . '<br>';
                                            echo "Année de sortie: " .$data['annee_sortie'] . '<br>';
                                            echo "Genre: " .$data['genre'] . '<br>';
                                            echo'</p></B>';
                                            print '<center><img class="img" src="'. $data['photos'] .'" alt="' . $data['photos']. '" height="350px"></center>';
                                            if($data['photo2'] != ""){
                                                print '<br><center><img class="img" src="'. $data['photo2'] .'" alt="' . $data['photo2']. '" height="350px"></center>';
                                            }
                                            if($data['video'] != ""){
                                                echo '<br><center><iframe src="' . $data['video'] . '"></iframe></center>';
                                            } 
                                            echo '<br><B><p style="padding-left:60px">';
                                            echo "Prix de l'article: " .$data['prix'] . ' €<br>';
                                            echo "Stock: ".$data['stock'] . '<br>';
                                            echo "Nombre d'articles vendus: ".$data['nb_vendus'] . '<br>';
                                            echo "Date de mise en ligne: ".$data['date_ligne'] . '<br><br>'; 
                                            echo '</B></p></div>';
                                        }
                                        
                                    } else {

                                        //si l'admin a décidé de voir plus d'infos sur le produit
                                        $sql = "SELECT * FROM sports_loisir WHERE nom = '$choix'";
                                        $result = mysqli_query($db_handle,$sql);
                                        if(mysqli_num_rows($result) != 0){   

                                            while($data = mysqli_fetch_assoc($result)){
                                                echo '<div style="background-color:lightyellow">';
                                                echo '<h4 style="color:#F6745A;text-align:center;padding-top:30px">'.$data['nom'] . '</h4><br>';
                                                echo '<p style="text-align:center;padding:0px 20px 0px 20px"><em>'.$data['description'] . '</em></p>';
                                                echo '<B><p style="padding-left:60px">';
                                                echo "Activité: " .$data['activite'] . '<br>';
                                                echo "Date: " .$data['date'] . '<br>';
                                                echo "Lieu: " .$data['lieu'] . '<br>';
                                                echo "Âge: " .$data['age'] . '<br>';
                                                echo'</p></B>';
                                                print '<center><img class="img" src="'. $data['photos'] .'" alt="' . $data['photos']. '" height="350px"></center>';
                                                if($data['photo2'] != ""){
                                                    print '<br><center><img class="img" src="'. $data['photo2'] .'" alt="' . $data['photo2']. '" height="350px"></center>';
                                                }
                                                if($data['video'] != ""){
                                                    echo '<br><center><iframe src="' . $data['video'] . '"></iframe></center>';
                                                } 
                                                echo '<br><B><p style="padding-left:60px">';
                                                echo "Prix de l'article: " .$data['prix'] . ' €<br>';
                                                echo "Stock: ".$data['stock'] . '<br>';
                                                echo "Nombre d'articles vendus: ".$data['nb_vendus'] . '<br>';
                                                echo "Date de mise en ligne: ".$data['date_ligne'] . '<br><br>'; 
                                                echo '</B></p></div>';
                                            }
                                        
                                        //SUPPRESSION DE L'ARTICLE
                                        } else {
                                            
                                                $sql = "SELECT * FROM vetements WHERE description = '$choix'";
                                                $result = mysqli_query($db_handle,$sql);
                                                if(mysqli_num_rows($result) != 0){   

                                                    $sql = "DELETE FROM vetements WHERE description = '$choix'";
                                                    $result = mysqli_query($db_handle,$sql);
                                                    echo '<script language="Javascript">document.location.replace("administration.php");</script>';
                                            
                                            } else {

                                                    $sql = "SELECT * FROM livres WHERE description = '$choix'";
                                                    $result = mysqli_query($db_handle,$sql);
                                                    if(mysqli_num_rows($result) != 0){   

                                                        $sql = "DELETE FROM livres WHERE description = '$choix'";
                                                        $result = mysqli_query($db_handle,$sql);
                                                        echo '<script language="Javascript">document.location.replace("administration.php");</script>';
                                                        
                                                
                                                    } else {
                                                    
                                                        $sql = "SELECT * FROM musique WHERE description = '$choix'";
                                                        $result = mysqli_query($db_handle,$sql);
                                                        if(mysqli_num_rows($result) != 0){   

                                                            $sql = "DELETE FROM musique WHERE description = '$choix'";
                                                            $result = mysqli_query($db_handle,$sql);
                                                            echo '<script language="Javascript">document.location.replace("administration.php");</script>';
                                                        
                                                        } else {
                                                      
                                                            $sql = "SELECT * FROM sports_loisir WHERE description = '$choix'";
                                                            $result = mysqli_query($db_handle,$sql);
                                                            if(mysqli_num_rows($result) != 0){   

                                                                $sql = "DELETE FROM sports_loisir WHERE description = '$choix'";
                                                                $result = mysqli_query($db_handle,$sql);
                                                                echo '<script language="Javascript">document.location.replace("administration.php");</script>';
                                                            }
                                                        }
                                                    }
                                                }
                                            }   
                                        }
                                    }
                                }
                            }
                    ?> 
                </div>
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