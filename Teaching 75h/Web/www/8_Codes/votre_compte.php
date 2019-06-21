<!-- PHP USER CONNECTE -->
<?php 
session_start();

/**PARTIE USER CONNECTE**/

//Variable "user" pour savoir si l'utilisateur est connecte
//Partie USER
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
            if($data['ID'] == 6){   //si c'est un admin
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


    /** PHP PARTIE HEADER VOTRE COMPTE **/
    //Variables récupérer de la page connexion.php et qu'on réutilisera dans page changement_mdp.php
    $_SESSION['email2'] = $_SESSION['email'];
    $_SESSION['mdp2'] = $_SESSION['mdp'];

    $sql = "SELECT * FROM acheteurs WHERE connexion = 1";
    $result = mysqli_query($db_handle, $sql);
    //Si trouvée
    if(mysqli_num_rows($result) != 0){ 
        //on recupere les données de cette personne (tous les données de la ligne) 
        $data = mysqli_fetch_array($result);
        $ID = $data['ID'];
        $nom = $data['nom'];
        $prenom = $data['prenom'];
        $adresse1 = $data['adresse1'];
        $adresse2 = $data['adresse2'];
        $ville = $data['ville'];
        $code_postal = $data['code_postal'];
        $pays = $data['pays'];
        $num_tel = $data['num_tel'];
        $email = $data['email'];
        $ID_carte = $data['ID_carte'];
        //On cherche les données de la carte bancaire
        $sql = "SELECT * FROM cartes_bancaires WHERE ID = '$ID_carte' ";
        $result = mysqli_query($db_handle, $sql);
        //on recupere les données de la carte 
        $data = mysqli_fetch_array($result);
        $type_carte = $data['type_carte'];
        $num_carte = $data['num_carte'];
        $date_exp = $data['date_exp'];
    } 
    else { //Si aucune personne connecté trouvée
            $nom = "<br/> non trouve";
    }
?>

<html>
<head>
    <title>Votre Compte | ECE Amazon</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="mon_profil.css">

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



    <header>
        <div class="container" >
           <form method="POST" action="">
                <h2 class="titre">Compte de <?php if(isset($nom)) { if($nom != 'non trouve') { echo "<b>$nom $prenom</b>"; } } ?> </h2>
                <div id="wallpaper">
                <div class="formulaire">
                    <!-- Affichage infos de l'acheteur à partir de la BDD-->
                    <p><u>Voici vos coordonnées</u> : </p>
                    <p>Nom : <?php if(isset($nom)) { if($nom != 'non trouve') { echo "<b>$nom</b>"; } } ?> </p>
                    <p>Prénom : <?php if(isset($prenom)) { if($prenom != 'non trouve') { echo "<b>$prenom</b>"; } } ?> </p>
                    <p>Adresse : <?php if(isset($adresse1)) { if($adresse1 != 'non trouve') { echo "<b>$adresse1</b>"; } } ?> </p>
                    <p>Complément d'adresse : <?php if(isset($adresse2)) { if($adresse2 != 'non trouve') { echo "<b>$adresse2</b>"; } } ?> </p>
                    <p>Ville : <?php if(isset($ville)) { if($ville != 'non trouve') { echo "<b>$ville</b>"; } } ?> </p>
                    <p>Code Postal : <?php if(isset($code_postal)) { if($code_postal != 'non trouve') { echo "<b>$code_postal</b>"; } } ?> </p>
                    <p>Pays : <?php if(isset($pays)) { if($pays != 'non trouve') { echo "<b>$pays</b>"; } } ?> </p>
                    <p>Numéro de telephone : <b>0</b><?php if(isset($num_tel)) { if($num_tel != 'non trouve') { echo "<b>$num_tel</b>"; } } ?> </p> 
                    <p>Adresse mail : <?php if(isset($email)) { if($email != 'non trouve') { echo "<b>$email</b>"; } } ?> </p>
                    <!--Lien pour changer son mot de passe-->
                    <br/>
                    <img src="cle.jpg" alt="icone_cle" height="30px" width="30px"/><a href="changement_mdp.php"> Changer de mot de passe</a><br/>
                    <!--Données carte bancaire--> 
                    <p><br/><u>Voici les informations de votre carte bancaire</u> : </p>
                    <?php
                    if($ID_carte != 0){
                        echo "<p>Type de carte : <b>".$type_carte."</b></p>";
                        echo "<p>Numéro carte : <b>*************".substr($num_carte, -3)."</b></p>";
                        echo "<p>Date d'expiration: <b>".$date_exp."</b></p>";

                    }
                    else{
                        echo "<p>Votre carte bancaire n'a pas encore ete enregistre.";
                    }
                    ?>

                </div>
                </div>
            </form>
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
} 
else {
     echo "Database not found.";
}
mysqli_close($db_handle);
?>