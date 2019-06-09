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

    $total = $_SESSION['total_panier'];

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
<html>
<head>
    <!-- TITRE A CHANGER POUR CHAQUE PAGE -->
    <title>Paiement | ECE Amazon</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    <!-- LIEN VERS LA PAGE DE CSS A CHANGER SELON LA PAGE -->
    <link rel="stylesheet" type="text/css" href="menu.css">
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
            <center><br>
            <h2 style="border-bottom: 2px solid #F6745A;color:black">Paiement</h2>
            </center>
            <!-- On affiche le montant du paiement -->
            <h5><u><br>Montant du total :</u><span style="color:green"> <?php echo $total; ?>€</span></h5>
            <div class="row" style="padding-top:30px"></div>
            <div class="row" style="padding-bottom:30px">
                <div class="col-lg-4 col-md-4 col-sm-12"></div>
                <div class="col-lg-8 col-md-8 col-sm-12">
                <?php
                    //on recherche les infos de l'acheteur connecté
                    $sql = "SELECT * FROM acheteurs WHERE email = '$user'";
                    $result = mysqli_query($db_handle, $sql);
                    $data = mysqli_fetch_assoc($result);
                    $nom_ach = $data['nom'];
                    $prenom_ach = $data['prenom'];
                    $adresse1_ach = $data['adresse1'];
                    $adresse2_ach = $data['adresse2'];
                    $ville_ach = $data['ville'];
                    $code_postal_ach = $data['code_postal'];
                    $pays_ach = $data['pays'];
                    $num_tel_ach = $data['num_tel'];
                    $ID_carte_ach = $data['ID_carte'];
        
                    //on recherche la carte de l'acheteur si il l'a enregistré
                    $sql = "SELECT * FROM cartes_bancaires WHERE ID = '$ID_carte_ach'";
                    $result = mysqli_query($db_handle, $sql);
                    if (mysqli_num_rows($result) != 0) {
                        
                        //on affiche ces infos
                        $data = mysqli_fetch_assoc($result);
                        $type_carte_ach = $data['type_carte'];
                        $num_carte_ach = $data['num_carte'];
                        $nom_carte_ach = $data['nom_carte'];
                        $date_exp_ach = $data['date_exp'];
                        $code_secu_ach = $data['code_secu'];

                    //si pas de carte enregistrée on affiche rien
                    } else {
                        $type_carte_ach = "";
                        $num_carte_ach = "";
                        $nom_carte_ach = "";
                        $date_exp_ach = "";
                        $code_secu_ach = "";
                    }
                ?>                   
                    <form method="post"> 
                        <table>
                            <tr>
                                <td colspan="2"><h5>Veuillez saisir vos coordonnées pour la livraison: </h5></td>
                            </tr>
                            <tr>
                                <td>Nom: </td>
                                <td><input type="text" name="nom" value="<?php echo $nom_ach; ?>"></td>
                            </tr>
                            <tr>
                                <td>Prénom: </td>
                                <td><input type="text" name="prenom" value="<?php echo $prenom_ach; ?>"></td>
                            </tr>
                            <tr>
                                <td>Adresse ligne 1: </td>
                                <td><input type="text" name="adresse1" value="<?php echo $adresse1_ach; ?>"></td>
                            </tr>
                            <tr>
                                <td>Adresse ligne 2: </td>
                                <td><input type="text" name="adresse2" value="<?php echo $adresse2_ach; ?>"></td>
                            </tr>
                            <tr>
                                <td>Ville: </td>
                                <td><input type="text" name="ville" value="<?php echo $ville_ach; ?>"></td>
                            </tr>
                            <tr>
                                <td>Code postal: </td>
                                <td><input type="text" name="code_postal" value="<?php echo $code_postal_ach; ?>"></td>
                            </tr>
                            <tr>
                                <td>Pays: </td>
                                <td><input type="text" name="pays" value="<?php echo $pays_ach; ?>"></td>
                            </tr>
                            <tr>
                                <td>Numéro de téléphone: </td>
                                <td><input type="text" name="num_tel" value="<?php echo $num_tel_ach; ?>"></td>
                            </tr>
                            <tr>
                                <td>Lieu de livraison: </td>
                                <td>
                                    <select name="delivery">
                                        <option>Domicile</option>
                                        <option>Point relais</option>                                     
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2"><br><h5>Veuillez saisir vos informations pour le paiement: </h5></td>
                            </tr>
                            <tr>
                                <td colspan="2"class="text-warning">Verifier le type de la carte.</td>
                            </tr>
                            <tr>
                                <td>Type de carte: </td>
                                <td>
                                    <select name="type_carte">
                                        <option value="Visa">Visa</option>
                                        <option value="MasterCard">MasterCard</option>
                                        <option value="American Express">American Express</option>
                                        <option value="Paypal">Paypal</option>                                        
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td>Numéro de la carte: </td>
                                <td><input type="number" name="num_carte" value="<?php echo $num_carte_ach; ?>"></td>
                            </tr>
                            <tr>
                                <td>Nom affiché sur la carte: </td>
                                <td><input type="text" name="nom_carte" value="<?php echo $nom_carte_ach; ?>"></td>
                            </tr>
                            <tr>
                                <td>Date d'expiration: </td>
                                <td><input type="Date" name="date_exp" value="<?php echo $date_exp_ach; ?>"></td>
                            </tr>
                            <tr>
                                <td>Code: </td>
                                <td><input type="number" name="code_secu" value="<?php echo $code_secu_ach; ?>"></td>
                            </tr>
                            <tr>
                                <td>Enregistrer votre carte ? </td>
                                <td>
                                    <select name="record">
                                        <option value="Oui">Oui</option>
                                        <option value="Non">Non</option>                                     
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2" align="center">
                                 <br/><input type="submit" style="background-color:#F6745A;border:none;margin-bottom:40px" name="button_pay" class="btn btn-secondary btn-block" value="Valider le paiement"></td>
                            </tr>
                        </table>
                    </form>
                    <?php 
                        //si clic sur valider le paiement
                        if(isset($_POST['button_pay'])){
                            
                            $nom_ach = $_POST['nom'];
                            $prenom_ach = $_POST['prenom'];
                            $adresse1_ach = $_POST['adresse1'];
                            $adresse2_ach = $_POST['adresse2'];
                            $ville_ach = $_POST['ville'];
                            $code_postal_ach = $_POST['code_postal'];
                            $pays_ach = $_POST['pays'];
                            $num_tel_ach = $_POST['num_tel'];

                            $type_carte_ach = $_POST['type_carte'];
                            $num_carte_ach = $_POST['num_carte'];
                            $nom_carte_ach = $_POST['nom_carte'];
                            $date_exp_ach = $_POST['date_exp'];
                            $code_secu_ach = $_POST['code_secu'];
                            
                            $record = $_POST['record'];
                            
                            //erreur telephone
                            if($num_tel_ach>9999999999){
                                $error .= "Numéro de téléphone invalide.<br>";
                            }
                            //erreur code postal
                            if($code_postal_ach>99999){
                                $error .= "Code postal invalide.<br>";
                            }
                            //erreur numero de carte
                            if($num_carte_ach>9999999999999999){
                                $error .= "Numéro de carte invalide.<br>";
                            }
                            
                            //erreur code securité de la carte
                            if($code_secu_ach > 9999){
                                $error .= "Code de sécurité de la carte invalide.<br>";
                                
                            //si tous les champs sont remplis
                            } else if ((!empty($nom_ach)) && (!empty($prenom_ach)) && (!empty($adresse1_ach)) && (!empty($ville_ach)) && (!empty($code_postal_ach)) && (!empty($pays_ach)) && (!empty($num_tel_ach)) && (!empty($nom_carte_ach)) && (!empty($date_exp_ach)) && (!empty($code_secu_ach))) {
                                
                                //enregistrement de la carte
                                if($record == "Oui"){
                                    
                                    $sql = "INSERT INTO cartes_bancaires(type_carte, num_carte, nom_carte, date_exp, code_secu) VALUES ('$type_carte_ach', '$num_carte_ach', '$nom_carte_ach', '$date_exp_ach', '$code_secu_ach')";
                                    $result = mysqli_query($db_handle, $sql);
                                    $data = mysqli_fetch_array($result);
                                    $ID_carte = $data['ID'];
                                    
                                    $sql = "UPDATE acheteurs SET ID_carte='$ID_carte' WHERE email='$user'";
                                    $result = mysqli_query($db_handle, $sql);
                                    
                                }
                                
                                //on vérifie la carte bancaire
                                $sql = "SELECT * FROM cartes_bancaires WHERE nom_carte='$nom_carte_ach' AND num_carte='$num_carte_ach' AND type_carte='$type_carte_ach' AND date_exp='$date_exp_ach' AND code_secu='$code_secu_ach'";
                                $result = mysqli_query($db_handle, $sql);
                                if (mysqli_num_rows($result) != 0) {
                                
                                
                                //recherche des vêtements dans le panier
                                $sql = "SELECT * FROM panier WHERE nom IN ( SELECT nom FROM vetements WHERE nom = nom)";
                                $result = mysqli_query($db_handle, $sql);
                                //prix de l'article et ID_vendeur
                                while($data = mysqli_fetch_array($result)){

                                    //recherche de la quantité du produit
                                    $nom_article = $data['nom'];
                                    $quantite = $data['quantite'];
                                    
                                    //on modifie le stock
                                    $sql1 = "UPDATE vetements SET stock = stock - '$quantite' WHERE nom='$nom_article')";
                                    $result = mysqli_query($db_handle, $sql1); 

                                    //on modifie le nb vendus de l'article
                                    $sql1 = "UPDATE vetements SET nb_vendus = nb_vendus + '$quantite' WHERE nom='$nom_article')";
                                    $result = mysqli_query($db_handle, $sql1);
                                }
                                    
                                //recherche des vetements dans le panier
                                $sql = "SELECT * FROM vetements WHERE nom IN ( SELECT nom FROM panier WHERE nom = nom)";
                                $result = mysqli_query($db_handle, $sql);
                                //prix de l'article et ID_vendeur
                                while($data = mysqli_fetch_array($result)){

                                    //recherche de la quantité du produit et du prix
                                    $prix = $data['prix'];
                                    $nom_article = $data['nom'];
                                    $ID_vendeur = $data['ID_vendeur'];
                                    
                                    //on modifie le solde du vendeur en fct de la quantité
                                    $sql1 = "UPDATE vendeurs SET solde = solde + '$prix' * '$quantite' WHERE ID = '$ID_vendeur'";
                                    $result = mysqli_query($db_handle, $sql1);  

                                    //on modifie le nb de ventes du vendeur
                                    $sql1 = "UPDATE vendeurs SET nb_ventes = nb_ventes + '$quantite' WHERE ID = '$ID_vendeur'";
                                    $result = mysqli_query($db_handle, $sql1); 
                                }
                                
                                //recherche des livres dans le panier
                                $sql = "SELECT * FROM panier WHERE nom IN ( SELECT nom FROM livres WHERE nom = nom)";
                                $result = mysqli_query($db_handle, $sql);
                                //prix de l'article et ID_vendeur
                                while($data = mysqli_fetch_array($result)){

                                    //recherche de la quantité du produit
                                    $nom_article = $data['nom'];
                                    $quantite = $data['quantite'];
                                    
                                    //on modifie le stock
                                    $sql1 = "UPDATE livres SET stock = stock - '$quantite' WHERE nom='$nom_article')";
                                    $result = mysqli_query($db_handle, $sql1); 

                                    //on modifie le nb vendus de l'article
                                    $sql1 = "UPDATE livres SET nb_vendus = nb_vendus + '$quantite' WHERE nom='$nom_article')";
                                    $result = mysqli_query($db_handle, $sql1);
                                }
                                    
                                //recherche des livres dans le panier
                                $sql = "SELECT * FROM livres WHERE nom IN ( SELECT nom FROM panier WHERE nom = nom)";
                                $result = mysqli_query($db_handle, $sql);
                                //prix de l'article et ID_vendeur
                                while($data = mysqli_fetch_array($result)){

                                    //recherche de la quantité du produit et du prix
                                    $prix = $data['prix'];
                                    $nom_article = $data['nom'];
                                    $ID_vendeur = $data['ID_vendeur'];
                                    
                                    //on modifie le solde du vendeur en fct de la quantité
                                    $sql1 = "UPDATE vendeurs SET solde = solde + '$prix' * '$quantite' WHERE ID = '$ID_vendeur'";
                                    $result = mysqli_query($db_handle, $sql1);  

                                    //on modifie le nb de ventes du vendeur
                                    $sql1 = "UPDATE vendeurs SET nb_ventes = nb_ventes + '$quantite' WHERE ID = '$ID_vendeur'";
                                    $result = mysqli_query($db_handle, $sql1); 
                                }
                                
                                //recherche des sports et loisir dans le panier
                                $sql = "SELECT * FROM panier WHERE nom IN ( SELECT nom FROM sports_loisir WHERE nom = nom)";
                                $result = mysqli_query($db_handle, $sql);
                                //prix de l'article et ID_vendeur
                                while($data = mysqli_fetch_array($result)){

                                    //recherche de la quantité du produit
                                    $nom_article = $data['nom'];
                                    $quantite = $data['quantite'];
                                    
                                    //on modifie le stock
                                    $sql1 = "UPDATE sports_loisir SET stock = stock - '$quantite' WHERE nom='$nom_article')";
                                    $result = mysqli_query($db_handle, $sql1); 

                                    //on modifie le nb vendus de l'article
                                    $sql1 = "UPDATE sports_loisir SET nb_vendus = nb_vendus + '$quantite' WHERE nom='$nom_article')";
                                    $result = mysqli_query($db_handle, $sql1);
                                }
                                    
                                //recherche des sports et loisir dans le panier
                                $sql = "SELECT * FROM musique WHERE nom IN ( SELECT nom FROM sports_loisir WHERE nom = nom)";
                                $result = mysqli_query($db_handle, $sql);
                                //prix de l'article et ID_vendeur
                                while($data = mysqli_fetch_array($result)){

                                    //recherche de la quantité du produit et du prix
                                    $prix = $data['prix'];
                                    $nom_article = $data['nom'];
                                    $ID_vendeur = $data['ID_vendeur'];
                                    
                                    //on modifie le solde du vendeur en fct de la quantité
                                    $sql1 = "UPDATE vendeurs SET solde = solde + '$prix' * '$quantite' WHERE ID = '$ID_vendeur'";
                                    $result = mysqli_query($db_handle, $sql1);  

                                    //on modifie le nb de ventes du vendeur
                                    $sql1 = "UPDATE vendeurs SET nb_ventes = nb_ventes + '$quantite' WHERE ID = '$ID_vendeur'";
                                    $result = mysqli_query($db_handle, $sql1); 
                                }
                                
                                //recherche des musiques dans le panier
                                $sql = "SELECT * FROM panier WHERE nom IN ( SELECT nom FROM musique WHERE nom = nom)";
                                $result = mysqli_query($db_handle, $sql);
                                //prix de l'article et ID_vendeur
                                while($data = mysqli_fetch_array($result)){

                                    //recherche de la quantité du produit
                                    $nom_article = $data['nom'];
                                    $quantite = $data['quantite'];
                                    
                                    //on modifie le stock
                                    $sql1 = "UPDATE musique SET stock = stock - '$quantite' WHERE nom='$nom_article')";
                                    $result = mysqli_query($db_handle, $sql1); 

                                    //on modifie le nb vendus de l'article
                                    $sql1 = "UPDATE musique SET nb_vendus = nb_vendus + '$quantite' WHERE nom='$nom_article')";
                                    $result = mysqli_query($db_handle, $sql1);
                                }
                                    
                                //recherche des musique dans le panier
                                $sql = "SELECT * FROM musique WHERE nom IN ( SELECT nom FROM panier WHERE nom = nom)";
                                $result = mysqli_query($db_handle, $sql);
                                //prix de l'article et ID_vendeur
                                while($data = mysqli_fetch_array($result)){

                                    //recherche de la quantité du produit et du prix
                                    $prix = $data['prix'];
                                    $nom_article = $data['nom'];
                                    $ID_vendeur = $data['ID_vendeur'];
                                    
                                    //on modifie le solde du vendeur en fct de la quantité
                                    $sql1 = "UPDATE vendeurs SET solde = solde + '$prix' * '$quantite' WHERE ID = '$ID_vendeur'";
                                    $result = mysqli_query($db_handle, $sql1);  

                                    //on modifie le nb de ventes du vendeur
                                    $sql1 = "UPDATE vendeurs SET nb_ventes = nb_ventes + '$quantite' WHERE ID = '$ID_vendeur'";
                                    $result = mysqli_query($db_handle, $sql1); 
                                }

                                
                                    //suppression de la totalité du panier
                                    $sql = "DELETE FROM panier";
                                    $result = mysqli_query($db_handle, $sql);
                                
                                } else {
                                    $error .= "Carte bancaire inconnue.<br>";
                                }
                                    
                                echo '<script language="Javascript">document.location.replace("paiement_ok.php");</script>';  
                                    
                            } else {
                                $error .= "Remplissez tous les champs.<br>";
                            }
                                    
                            echo '<p class="text-danger">'.$error.'</p>';
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