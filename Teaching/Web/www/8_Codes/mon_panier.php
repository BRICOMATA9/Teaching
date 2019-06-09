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
<!DOCTYPE html>
<!-- OUVERTURE DE LA BDD POUR ENSUITE UTILISER PHP DANS LE CODE-->
<html>
<head>
    <!-- TITRE A CHANGER POUR CHAQUE PAGE -->
    <title>Panier | ECE Amazon</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    <!-- LIEN VERS LA PAGE DE CSS A CHANGER SELON LA PAGE -->
    <link rel="stylesheet" type="text/css" href="mon_panier.css">
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
            <h2 class="titre">Mon panier</h2>
            <div class="row" style="padding:30px 0px 30px 0px">
                <div class="col-lg-8 col-md-9 col-sm-12 article">
                    <?php
                        //variable 
                        $sous_total=0;
        
                        //recherche des derniers vêtements mis en ligne
                        $sql = "SELECT * FROM panier";
                        $result = mysqli_query($db_handle, $sql);
                        while($data = mysqli_fetch_array($result)){ 
                            $quantite = $data['quantite'];

                            //recherche des vêtements dans le panier
                            $sql1 = "SELECT * FROM vetements WHERE nom IN (SELECT nom FROM panier WHERE nom = nom)";
                            $result = mysqli_query($db_handle, $sql1);
                            while($data1 = mysqli_fetch_array($result)){ 

                                //block contenant un seul article
                                echo '<div class="article">';   
                                $_SESSION['nom_sessionV'] = $data1['nom'];
                                echo '<h5 class="nom_article"><a style="color:#F6745A" href="redirection_vetements.php">' . $data1['nom'] . '</a></h5><br>';
                                echo '<h5 class="prix_article">' . $data1['prix'] . ' €</h5>';
                                print '<img class="img_article" src="'. $data1['photos'] .'" alt="' . $data1['photos']. '">';
                                echo "Genre: " . $data1['genre'] . '<br>';
                                echo "Couleur: " . $data1['couleur'] . '<br>';
                                echo "Taille: " . $data1['taille'] . '<br>';
                                echo "Type: " . $data1['type'] . '<br>';
                                echo "Modèle: " . $data1['modele'] . '<br>';
                                echo "Matière: " . $data1['matiere'] . '<br>';
                                
                                //récupération de la quantite
                                $nom = $data1['nom'];
                                $sql11 = "SELECT * FROM panier WHERE nom='$nom'";
                                $result11 = mysqli_query($db_handle, $sql11);
                                $data11 = mysqli_fetch_array($result11); 
                                $quantite = $data11['quantite'];
                                echo "<B>Quantité: " . $quantite . '</B><br>';
                                                                
                                //calcul prix
                                $sous_total += $data1['prix'] * $quantite;
                                
                                //bouton pour supprimer ou ajouter des articles
                                echo'<p></p>';
                                echo '<form style="clear:both;color:dimgrey" method="post">';
                                echo '<tr><td>Quantité: </td>';
                                echo '<td><input type="number" name="nb"></td></tr>';
                                echo '<tr>';
                                echo '<br><td><input type="radio" id="1" name="choix" value="'.$data1['description'].'">';
                                echo '<label for="1">Ajouter au panier</label></td>';
                                echo '</tr><br>';
                                echo '<tr>';
                                echo '<td><input type="radio" id="2" name="choix" value="'.$data1['nom'].'">';
                                echo '<label for="2">Supprimer cet article</label></td>';
                                echo '</tr><br>';
                                echo '<tr><td><input type="submit" style="background-color:red;color:white" class="btn btn-sm" name="valider" value="Valider"></td></tr></form>';
                                echo '</div><br>';

                                //espace blanc entre les articles
                                echo '<div class="row" style="background-color:white"><p></p></div>';
                            }

                            //recherche des livres dans le panier
                            $sql2 = "SELECT * FROM livres WHERE nom IN (SELECT nom FROM panier WHERE nom = nom)";
                            $result = mysqli_query($db_handle, $sql2);
                            while($data2 = mysqli_fetch_array($result)){

                                //block contenant un seul article
                                echo '<div class="article">';   
                                echo '<h5 class="nom_article">' . $data2['nom'] . '</h5><br>';
                                echo '<h5 class="prix_article">' . $data2['prix'] . ' €</h5>';
                                print '<img class="img_article" src="'. $data2['photos'] .'" alt="' . $data2['photos']. '">';
                                echo $data2['auteur'] . '<br>';
                                echo $data2['annee_publication'] . '<br>';
                                echo "Edition: " . $data2['edition'] . '<br>';
                                
                                //récupération de la quantite
                                $nom = $data2['nom'];
                                $sql11 = "SELECT * FROM panier WHERE nom='$nom'";
                                $result11 = mysqli_query($db_handle, $sql11);
                                $data11 = mysqli_fetch_array($result11); 
                                $quantite = $data11['quantite'];
                                echo "<B>Quantité: " . $quantite . '</B><br>';
                                                                
                                //calcul prix
                                $sous_total += $data2['prix'] * $quantite;
                                
                                //bouton pour supprimer ou ajouter des articles
                                echo'<p></p>';
                                echo '<form style="clear:both;color:dimgrey" method="post">';
                                echo '<tr><td>Quantité: </td>';
                                echo '<td><input type="number" name="nb"></td></tr>';
                                echo '<tr>';
                                echo '<br><td><input type="radio" id="1" name="choix" value="'.$data2['description'].'">';
                                echo '<label for="1">Ajouter au panier</label></td>';
                                echo '</tr><br>';
                                echo '<tr>';
                                echo '<td><input type="radio" id="2" name="choix" value="'.$data2['nom'].'">';
                                echo '<label for="2">Supprimer cet article</label></td>';
                                echo '</tr><br>';
                                echo '<tr><td><input type="submit" style="background-color:red;color:white" class="btn btn-sm" name="valider" value="Valider"></td></tr></form>';
                                echo '</div><br>';

                                //espace blanc entre les articles
                                echo '<div class="row" style="background-color:white"><p></p></div>';
                            }

                            //recherche des sports et loisir dans le panier
                            $sql3 = "SELECT * FROM sports_loisir WHERE nom IN (SELECT nom FROM panier WHERE nom = nom)";
                            $result = mysqli_query($db_handle, $sql3);
                            while($data3 = mysqli_fetch_array($result)){

                                //block contenant un seul article
                                echo '<div class="article">';   
                                echo '<h5 class="nom_article">' . $data3['nom'] . '</h5><br>';
                                echo '<h5 class="prix_article">' . $data3['prix'] . ' €</h5>';
                                print '<img class="img_article" src="'. $data3['photos'] .'" alt="' . $data3['photos']. '">';
                                echo "Activité: " . $data3['activite'] . '<br>';
                                echo "Lieu: " . $data3['lieu'] . '<br>';
                                echo "Date: " . $data3['date'] . '<br>';
                                
                                //récupération de la quantite
                                $nom = $data3['nom'];
                                $sql11 = "SELECT * FROM panier WHERE nom='$nom'";
                                $result11 = mysqli_query($db_handle, $sql11);
                                $data11 = mysqli_fetch_array($result11); 
                                $quantite = $data11['quantite'];
                                echo "<B>Quantité: " . $quantite . '</B><br>';
                                                                
                                //calcul prix
                                $sous_total += $data3['prix'] * $quantite;
                                
                                //bouton pour supprimer ou ajouter des articles
                                echo'<p></p>';
                                echo '<form style="clear:both;color:dimgrey" method="post">';
                                echo '<tr><td>Quantité: </td>';
                                echo '<td><input type="number" name="nb"></td></tr>';
                                echo '<tr>';
                                echo '<br><td><input type="radio" id="1" name="choix" value="'.$data3['description'].'">';
                                echo '<label for="1">Ajouter au panier</label></td>';
                                echo '</tr><br>';
                                echo '<tr>';
                                echo '<td><input type="radio" id="2" name="choix" value="'.$data3['nom'].'">';
                                echo '<label for="2">Supprimer cet article</label></td>';
                                echo '</tr><br>';
                                echo '<tr><td><input type="submit" style="background-color:red;color:white" class="btn btn-sm" name="valider" value="Valider"></td></tr></form>';
                                echo '</div><br>';
                                
                                //espace blanc entre les articles
                                echo '<div class="row" style="background-color:white"><p></p></div>';

                            }

                            //recherche des musiques dans le panier
                            $sql4 = "SELECT * FROM musique WHERE nom IN (SELECT nom FROM panier WHERE nom = nom)";
                            $result = mysqli_query($db_handle, $sql4);
                            while($data4 = mysqli_fetch_array($result)){

                                //block contenant un seul article
                                echo '<div class="article">';   
                                $_SESSION['nom_sessionM'] = $data4['nom'];
                                echo '<h5 class="nom_article"><a style="color:#F6745A" href="redirection_vetements.php">' . $data4['nom'] . '</a></h5><br>';
                                echo '<h5 class="prix_article">' . $data4['prix'] . ' €</h5>';
                                print '<img class="img_article" src="'. $data4['photos'] .'" alt="' . $data4['photos']. '">';
                                echo $data4['artiste'] . '<br>';
                                echo "Année de sortie: " . $data4['annee_sortie'] . '<br>';
                                echo "Genre: " . $data4['genre'] . '<br>';
                                echo "Genre: " . $data4['genre'] . '<br>';
                                
                                //récupération de la quantite
                                $nom = $data4['nom'];
                                $sql11 = "SELECT * FROM panier WHERE nom='$nom'";
                                $result11 = mysqli_query($db_handle, $sql11);
                                $data11 = mysqli_fetch_array($result11); 
                                $quantite = $data11['quantite'];
                                echo "<B>Quantité: " . $quantite . '</B><br>';
                                                                
                                //calcul prix
                                $sous_total += $data4['prix'] * $quantite;
                                
                                //bouton pour supprimer ou ajouter des articles
                                echo'<p></p>';
                                echo '<form style="clear:both;color:dimgrey" method="post">';
                                echo '<tr><td>Quantité: </td>';
                                echo '<td><input type="number" name="nb"></td></tr>';
                                echo '<tr>';
                                echo '<br><td><input type="radio" id="1" name="choix" value="'.$data4['description'].'">';
                                echo '<label for="1">Ajouter au panier</label></td>';
                                echo '</tr><br>';
                                echo '<tr>';
                                echo '<td><input type="radio" id="2" name="choix" value="'.$data4['nom'].'">';
                                echo '<label for="2">Supprimer cet article</label></td>';
                                echo '</tr><br>';
                                echo '<tr><td><input type="submit" style="background-color:red;color:white" class="btn btn-sm" name="valider" value="Valider"></td></tr></form>';
                                echo '</div><br>';

                                //espace blanc entre les articles
                                echo '<div class="row" style="background-color:white"><p></p></div>';
                            }
                        }
                    ?>
                    <?php
                        //l'utilisateur appuie sur valider
                        if(isset($_POST['valider'])){

                            //On prend la valeur du type radio et la quantité saisie par l'utilisateur
                            $choix = $_POST["choix"];
                            $nb = $_POST["nb"];

                            //Si l'user veut supprimer l'article
                            $sql = "SELECT * FROM panier WHERE nom = '$choix'";
                            $result = mysqli_query($db_handle,$sql);
                            
                            if(mysqli_num_rows($result) != 0){
                                
                                //on recherche la quantité de cet article
                                $data = mysqli_fetch_assoc($result);
                                $max = $data['quantite'];

                                //si l'utilisateur n'a pas rentrer de quantité
                                if(empty($nb)){
                                    $msg .= "Veuillez rentrer une quantité.";

                                //si l'utilisateur a rentré une trop grande quantité
                                } else if ($nb>$max){
                                    $msg .= "Veuillez rentrer une quantité inférieure à ". $max.".";

                                //si la quantité est bonne
                                } else {

                                        //on supprime la quantité d'articles dans le panier
                                        $sql = "UPDATE panier SET quantite = quantite - '$nb' WHERE nom = '$choix'";
                                        $result = mysqli_query($db_handle,$sql);

                                        //suppression de l'article si quantité est nulle
                                        $sql = "DELETE FROM panier WHERE quantite=0";
                                        $result = mysqli_query($db_handle,$sql);

                                        echo '<script language="Javascript">document.location.replace("mon_panier.php");</script>';
                                    }  

                            //si l'user a décidé d'ajouter au panier
                            } else {
                                
                                    //on ajoute la quantité d'articles dans le panier
                                    $sql = "UPDATE panier SET quantite = quantite + '$nb' WHERE description = '$choix'";
                                    $result = mysqli_query($db_handle,$sql);
                                    
                                    echo '<script language="Javascript">document.location.replace("mon_panier.php");</script>';
                                }
                            }
                        ?> 
                    <tr>
                        <td colspan="2" align="center" style="background-color:none">
                            <p class="text-danger">
                                <?php echo $msg; ?>
                            </p>
                        </td>
                    </tr>
                </div>
                <div class="col-lg-1 col-md-1 col-sm-12">
                    <p></p>
                </div>
                <!-- COLONNE RECAPITULATIVE SUR LE COTE DROIT -->
                <div class="col-lg-3 col-md-3 col-sm-12 recap">
                    <h3 style="color:brown;text-align:center;border-bottom: 2px solid brown">Récapitulatif</h3><br>
                    <?php
                        //affichage des quantités et des noms d'article
                        $sql = "SELECT * FROM panier";
                        $result = mysqli_query($db_handle, $sql);
                        while($data = mysqli_fetch_array($result)){  
                            echo '<p style="padding-left:10px"><em>' . $data['quantite'] . ' x ' . $data['nom'] . '</em><p>';
                        }
                        
                        //affichage du sous_total
                        echo '<br><h5 id="total"> SOUS TOTAL : ' . $sous_total . ' €</h5><br>';
        
                        //affichage des frais de livraison
                        if($sous_total>=60){
                            echo '<br><h6>Frais de livraison: </h6>';
                            echo '<center><h6><B>offerts à partir de 60€</B></h6></center><br>';
                            $sous_total2 = $sous_total;
                            
                        } else {
                            if($sous_total>0){
                                echo '<h6>Frais de livraison : <B>7€</B></h6><br><br>';
                                $sous_total2 = $sous_total + 7;
                            }
                        }
        
                        //modification dans la BBD panier du total
                        $sql = "UPDATE panier SET total = '$sous_total2'";
                        $result = mysqli_query($db_handle, $sql);
                    ?>
                    <!-- FORMULAIRE CODE PROMO --> 
                    <form method="post">
                        <tr>
                            <td>Code promotionnel:</td>
                        </tr>
                        <tr>
                            <td><input type="text" name="code_promo"></td>
                            <td><input type="submit" name="OK" value="OK" class="btn btn-sm" style="background-color:white;border:1px solid grey"></td><br>
                        </tr>
                    </form> 
                    <?php
                        if(isset($_POST['OK'])){
                            
                            //on récupère le code promo saisi
                            $code_promo = isset($_POST["code_promo"])? $_POST["code_promo"] : "";
                            
                            $sous_totalB = $sous_total2 - ($sous_total2*0.1);
                            $sous_totalH = $sous_total2 - 15;

                            //si il est non vide
                            if(!empty($code_promo)){
                                //si est correct et un code promo n'a pas déjà été appliqué
                                if(($code_promo == "BIENVENUE19") && ($sous_total2 > $sous_totalB)){
                                    echo '<center><br><p class="text-success">VOUS OBTENEZ 10% SUR VOTRE COMMANDE !</p></center>';
                                    $sous_total2 = $sous_totalB;
                                    
                                    //modification dans la BBD panier du total
                                    $sql = "UPDATE panier SET total = '$sous_totalB'";
                                    $result = mysqli_query($db_handle, $sql);
                                    
                                } else if(($code_promo == "HAPPY") && ($sous_total2 > $sous_totalH) && ($sous_total2 > 15)){
                                    echo '<center><br><p class="text-success">VOUS OBTENEZ 15€ DE REDUCTION !</p></center>';
                                    $sous_total2 = $sous_totalH;
                                    
                                    //modification dans la BBD panier du total
                                    $sql = "UPDATE panier SET total = '$sous_totalH'";
                                    $result = mysqli_query($db_handle, $sql);
                                    
                                } else {
                                    echo '<br><p class="text-danger">Non valide.</p>';
                                }
                            }
                        }
        
                        //modification dans la BBD panier du total
                        $sql = "UPDATE panier SET total = '$sous_total2'";
                        $result = mysqli_query($db_handle, $sql);
                    
                        $_SESSION['total_panier'] = $sous_total2;
                    ?>
                    
                    <!-- AFFICHAGE DU TOTAL -->
                    <br><h4 id="total">TOTAL : <?php echo $sous_total2; ?> €</h4><br>
                    
                    <!-- boutton pour payer -->
                    <?php
                        if($user==""){
                            echo '<a href="connexion.php">';
                        } else {
                            echo '<a href="paiement.php">';
                        }
        
                        $sql="SELECT * FROM panier";
                        $result = mysqli_query($db_handle, $sql);
                        if (mysqli_num_rows($result) != 0) {
                            
                            echo '<button class="btn btn-block" id="paiement">PAIEMENT</button></a><br>';
                            
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