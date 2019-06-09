<?php 
session_start();

/**PARTIE USER CONNECTE**/

//Variable "user" pour savoir si l'utilisateur est connecte
if(isset($_SESSION['user'])){
    $user = $_SESSION['user'];
}
else{
    $user = "";
}

//Identification de notre BDD
$database = "ece_amazon";
//Connection à notre BDD
$db_handle = mysqli_connect('localhost', 'root', '');
$db_found = mysqli_select_db($db_handle, $database);

//Si la BDD est trouvée
if($db_found){
        
    //Partie RECHERCHE D'UN EVENTUEL UTILISATEUR CONNECTE
    //on recherche dans les acheteurs
    $sql0 = "SELECT * FROM acheteurs WHERE connexion = 1";
    $result = mysqli_query($db_handle,$sql0);
    if(mysqli_num_rows($result) == 0){ //si pas d'acheteur connecté
        //on recherche dans les vendeurs
        $sql0 = "SELECT * FROM vendeurs WHERE connexion = 1";
        $result = mysqli_query($db_handle,$sql0);
        if(mysqli_num_rows($result) != 0){ //si un vendeur est connecté
            
            //on récupère son email dans une variable
            $data = mysqli_fetch_array($result);
            $user_vendeur = $data['email'];
            
            //on récupère son fond dans une variable
            $fond = $data['fond'];

            //on recherche si c'est l'admin (car l'admin est sauvegardé dans la table "vendeurs" avec son id valant 6)
            if($data['ID'] == 6){	//si c'est un admin
                $user_admin = $data['email'];
                
            }
            else { // si ce n'est pas l'admin
                $user_admin = "";	
            }
        } 
        //personne n'est connecté
        else {
            $user_vendeur = "";	
            $user_admin = "";
        }   
        $user_acheteur = "";    
    } 
    else { //si un acheteur est connecté
        $data = mysqli_fetch_array($result);
        $user_acheteur = $data['email'];

        //donc ce n'est ni un vendeur ni un admin
        $user_vendeur = "";
        $user_admin = "";
    }


	/** PHP PARTIE HEADER INSCRIPTION **/
    if (isset($_POST['button_inscription'])) {	//si le bouton "S'inscrire" a été cliqué
        //on recupere les données rentrées dans le formulaire d'inscription (Rappel: $_POST = "name" de <input> de la page HTML)
        $utilisateur = isset($_POST["utilisateur"])? $_POST["utilisateur"] : "";
        $nom = isset($_POST["nom"])? $_POST["nom"] : "";
        $prenom = isset($_POST["prenom"])? $_POST["prenom"] : "";
        $pseudo = isset($_POST["pseudo"])? $_POST["pseudo"] : "";
        $adresse1 = isset($_POST["adresse1"])? $_POST["adresse1"] : "";
        $adresse2 = isset($_POST["adresse2"])? $_POST["adresse2"] : "";
        $ville = isset($_POST["ville"])? $_POST["ville"] : "";
        $code_postal = isset($_POST["code_postal"])? $_POST["code_postal"] : "";
        $pays = isset($_POST["pays"])? $_POST["pays"] : "";
        $num_tel = isset($_POST["num_tel"])? $_POST["num_tel"] : "";
        $email = isset($_POST["email"])? $_POST["email"] : "";
        $mdp = isset($_POST["mdp"])? $_POST["mdp"] : "";
        $mdp2 = isset($_POST["mdp2"])? $_POST["mdp2"] : "";
        
        //Verification si des cases sont vides
        if(!empty($_POST['nom']) AND !empty($_POST['prenom']) AND !empty($_POST['pseudo']) AND !empty($_POST['adresse1']) AND !empty($_POST['ville']) AND !empty($_POST['code_postal']) AND !empty($_POST['pays']) AND !empty($_POST['num_tel']) AND !empty($_POST['email']) AND !empty($_POST['mdp']) AND !empty($_POST['mdp2'])) {
        	//Verification si certaines cases ont plus de 255 caractères 
            if(strlen($nom) <= 255) {
                if(strlen($prenom) <= 255) {
                    if(strlen($pseudo) <= 255) {
                        if(strlen($adresse1) <= 255) {
                            if(strlen($adresse2) <= 255) {
                                if(strlen($ville) <= 255) {
                                    if(strlen($code_postal) <= 5) { //doit comporter moins de 5 chiffres
                                        if(strlen($pays) <= 255) {
                                            if(strlen($num_tel) == 10) { //doit comporter 10 chiffres
                                                if(strlen($num_tel) >= 8) { //doit comporter au minimum 8 caractères

                                                    //on verifie si ce mail est deja dans la table "vendeurs" de la BDD
                                                    $sql = "SELECT * FROM vendeurs";
                                                    if ($email != "") { //si le champ email est non vide
                                                        $sql .= " WHERE email = '$email'";	//on cherche la personne avec le paramètre email
                                                    }
                                                    $result = mysqli_query($db_handle, $sql);
                                                    if (mysqli_num_rows($result) == 0) { //si ce mail n'est pas dans la table "vendeurs"

                                                    	//on verifie si ce pseudo est deja dans la table "vendeurs" de la BDD
    	                                                $sql = "SELECT * FROM vendeurs";
    	                                                if ($pseudo != "") { //si le champ pseudo est non vide
    	                                                    $sql .= " WHERE pseudo = '$pseudo'";  //on cherche la personne avec le paramètre pseudo
    	                                                }
    	                                                $result = mysqli_query($db_handle, $sql);
    	                                                if (mysqli_num_rows($result) == 0) { //si ce pseudo n'est pas dans la table "vendeurs"

    	                                                    //on verifie si ce mail est deja dans la table "acheteurs" de la BDD
    	                                                    $sql = "SELECT * FROM acheteurs";
    	                                                    if ($email != "") { //si le champ email est non vide
    	                                                        $sql .= " WHERE email = '$email'";  //on cherche la personne avec le paramètre email
    	                                                    }
    	                                                    $result = mysqli_query($db_handle, $sql);
    	                                                    if (mysqli_num_rows($result) == 0) { //si ce mail n'est pas dans la table "acheteurs"

    	                                                        if($mdp == $mdp2) { //si les 2 mdp rentrés sont identiques
    	                                                            if ($utilisateur == 'vendeur') { //si l'utilisateur est un vendeur
    	                                                                $element = strpos($email,"@edu.ece.fr"); //les vendeurs doivent utiliser le mail de l'ECE
    	                                                                if($element != '') { //si l'email respecte la forme "@edu.ece.fr"

    	                                                                    //on sauvegarde les donnees de la personne dans la table "vendeurs" de la BDD
    	                                                                    $sql = "INSERT INTO vendeurs(email, pseudo, nom, mdp, solde, nb_ventes, ID_carte, connexion, photo, fond) 
    	                                                                            VALUES ('$email', '$pseudo', '$nom', '$mdp', 0, 0, 0, 0, '', '')";
    	                                                                    $result = mysqli_query($db_handle, $sql);
    	                                                                    $erreur = "Inscription terminée. <a href=\"connexion.php\">Se connecter</a>";
    	                                                                }
    	                                                                else{ 
    	                                                                    $erreur = "Votre email doit être sous la forme de <b>prenom.nom@edu.ece.fr</b>"; 
    	                                                                }
    	                                                            }
    	                                                            else {
    	                                                            	//si l'utilisateur est un acheteur, on insere ces infos dans la table "acheteurs" de la BDD
    	                                                                $sql = "INSERT INTO acheteurs(ID_carte, email, mdp, nom, prenom, adresse1, adresse2, ville, code_postal, pays, num_tel, connexion)
    	                                                                        VALUES (0, '$email', '$mdp', '$nom', '$prenom', '$adresse1', '$adresse2', '$ville', '$code_postal', '$pays', '$num_tel', 0)";
    	                                                                $result = mysqli_query($db_handle, $sql);
    	                                                                $erreur = "Inscription terminée. <a href=\"connexion.php\">Se connecter</a>"; 
    	                                                            }
    	                                                        }
    	                                                        else {
    	                                                            $erreur = "Vos mots de passes ne correspondent pas !";
    	                                                        }
    	                                                    }
    	                                                    else{
    	                                                        $erreur = "Ce mail existe déjà !";
    	                                                    }
    	                                                }
    	                                                else{
    	                                                	$erreur = "Ce pseudo existe déjà !";
    	                                                }
                                                    }
                                                    else{
                                                        $erreur = "Ce mail existe déjà !";
                                                    }
                                                }
                                                else{
                                                    $erreur = "Le mot de passe n'est pas suffisamment sécurisé : il doit comporter au minimum 8 caractères.";
                                                }
                                            }
                                            else{
                                                $erreur = "Le numéro de téléphone doit comporter 10 chiffres !"; 
                                            }
                                        }
                                        else{
                                            $erreur = "Le pays ne doit pas dépasser 255 caractères !";
                                        }
                                    }
                                    else{
                                        $erreur = "Le code postal ne doit pas dépasser 5 chiffres !";
                                    }
                                }
                                else{
                                    $erreur = "La ville ne doit pas dépasser 255 caractères !";
                                }
                            }
                            else{
                                $erreur = "Le complément d'adresse ne doit pas dépasser 255 caractères !";
                            }
                        }
                        else{
                            $erreur = "L'adresse ne doit pas dépasser 255 caractères !";
                        }
                    }
                    else{
                        $erreur = "Le pseudo ne doit pas dépasser 255 caractères !";
                    }
                }
                else{
                    $erreur = "Le prenom ne doit pas dépasser 255 caractères !";
                }
            }
            else{
                $erreur = "Le nom ne doit pas dépasser 255 caractères !";
            }
        }
        else{
            $erreur = "Tous les champs n'ont pas été remplis !";
        }
    }
?>

<html>
<head>
    <title>Inscription | ECE Amazon</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="inscription.css">

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
                        <a class="dropdown-item" href="livres.php">Livres</a>
                        <a class="dropdown-item" href="musique.php">Musique</a>
                        <a class="dropdown-item" href="vetements.php">Vêtements</a>
                        <a class="dropdown-item" href="sports_et_loisir.php">Sports et Loisir</a>
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
                        //une fois deconnecter, on se redirige vers le menu
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


    <header>
        <h2 class="titre">Inscription</h2>
        <div align="center" class="formulaire">
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12">
                    <form method="POST" action="">  <!-- action vide car code php est dans le meme fichier-->
                        <table>
                            <tr>
                                <td><label for="utilisateur">Utilisateur :</label></td>
                                <td> <!--Choix type d'utilisateur-->
                                    <select type="text" name="utilisateur">
                                        <option>vendeur</option>
                                        <option>acheteur</option>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td><br/><label for="nom">Nom :</label></td>
                                <td><br/><input type="text" placeholder="Votre nom" name="nom" value="<?php if(isset($nom)) { echo $nom; } ?>"></td> <!-- value pour laisser l'affichage de ce qui a été rentré--> 
                            </tr>
                            <tr>
                                <td><br/><label for="prenom">Prénom :</label></td>
                                <td><br/><input type="text" placeholder="Votre prénom" name="prenom" value="<?php if(isset($prenom)) { echo $prenom; } ?>"></td>
                            </tr>
                            <tr>
                                <td><br/><label for="pseudo">Pseudo :</label></td>
                                <td><br/><input type="text" placeholder="Votre pseudo" name="pseudo" value="<?php if(isset($pseudo)) { echo $pseudo; } ?>"></td>
                            </tr>
                            <tr>
                                <td><br/><label for="adresse1">Adresse (ligne 1) :</label></td>
                                <td><br/><input type="text" placeholder="Votre adresse" name="adresse1" value="<?php if(isset($adresse1)) { echo $adresse1; } ?>"></td>
                            </tr>
                            <tr>
                                <td><br/><label for="adresse2">Adresse (ligne 2) :</label></td>
                                <td><br/><input type="text" placeholder="Votre complément d'adresse" name="adresse2" value="<?php if(isset($adresse2)) { echo $adresse2; } ?>"></td>
                            </tr>
                            <tr>
                                <td><br/><label for="ville" >Ville :</label></td>
                                <td><br/><input type="text" placeholder="Votre ville" name="ville" value="<?php if(isset($ville)) { echo $ville; } ?>"></td>
                            </tr>
                            <tr>
                                <td><br/><label for="code_postal">Code Postal :</label></td>
                                <td><br/><input type="number" placeholder="Votre code postal" name="code_postal" value="<?php if(isset($code_postal)) { echo $code_postal; } ?>"></td>
                            </tr>
                            <tr>
                                <td><br/><label for="pays">Pays :</label></td>
                                <td><br/><input type="text" placeholder="Votre pays" name="pays" value="<?php if(isset($pays)) { echo $pays; } ?>"></td>
                            </tr>
                            <tr>
                                <td><br/><label for="num_tel">Numéro de téléphone :</label></td>
                                <td><br/><input type="number" placeholder="Votre numéro de téléphone" name="num_tel" value="<?php if(isset($num_tel)) { echo $num_tel; } ?>"></td>
                            </tr>
                            <tr>
                                <td><br/><label for="email">Email :</label></td>
                                <td><br/><input type="email" placeholder="Votre mail" name="email" value="<?php if(isset($email)) { echo $email; } ?>"></td>
                            </tr>
                            <tr>
                                <td><br/><label for="mdp">Mot de passe :</label></td>
                                <td><br/><input type="password" placeholder="Entrez votre mdp" name="mdp"></td>
                            </tr>
                            <tr>
                                <td><br/><label for="mdp2">Confirmez votre mot de passe :</label></td>
                                <td><br/><input type="password" placeholder="Entrez à nouveau votre mdp" name="mdp2"></td>
                            </tr>
                            <tr>
                                <td colspan="2" align="center"> <!-- bouton s'inscrire -->
                                 <br/><input class="nextbutton btn btn-secondary btn-block btn-sm" type="submit" name="button_inscription" value="S'inscrire"></td>
                            </tr>
                        </table>
                    </form>
                     <?php
                     //on afficher un message en cas d'erreur
                     if(isset($erreur)) {
                        echo '<font color="red">'.$erreur."</font>";
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
//affichage d'erreur si la BDD non trouvée
} 
else {
     echo "Database not found.";
}
mysqli_close($db_handle);
?>