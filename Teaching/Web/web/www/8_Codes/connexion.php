<!-- PHP USER CONNECTE -->
<?php 
session_start();

//Variable "user" qui indiquera si l'utilisateur est connecte
$user = "";

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
            else {  // si ce n'est pas l'admin
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
    else { //si c'est un acheteur
        $data = mysqli_fetch_array($result);
        $user_acheteur = $data['email'];
        
        //donc ce n'est ni un vendeur ni un admin
        $user_vendeur = "";
        $user_admin = "";
    }

    /** PARTIE HEADER CONNEXION **/
    //on recupere les données venant de la page HTML (Rappel: $_POST = "name" de <input> de la page HTML)
    $pseudo = isset($_POST["pseudo"])? $_POST["pseudo"] : "";
    $email = isset($_POST["email"])? $_POST["email"] : "";
    $mdp = isset($_POST["mdp"])? $_POST["mdp"] : "";

    //Variables session qu'on a besoin pour les pages mon_profil.php et votre_compte.php
    $_SESSION['email'] = $email;
    $_SESSION['mdp'] = $mdp;

    //si on a appuyé sur le boutton "Se connecter"
    if (isset($_POST['button_connexion'])) {
        //Verification si des cases sont vides
    	if(empty($_POST["pseudo"]) AND empty($_POST["email"]) AND empty($_POST["mdp"])) {
            $erreur = "Tous les champs n'ont pas ete remplis.";
        }
        else{
    		// on vérifie si le champ "Pseudo" n'est pas vide
    		if(empty($_POST["pseudo"])) {
    	        $erreur = "Le champ Pseudo est vide.";
    	    }
    	    else {
    	        // on vérifie si le champ "Email" n'est pas vide
    	        if(empty($_POST["email"])) {
    	            $erreur = "Le champ Email est vide.";
    	        } 
    	        else{
    	        	// on vérifie si le champ "Mot de passe" n'est pas vide
    	        	if(empty($_POST["mdp"])) {
    	            	$erreur = "Le champ Mot de passe est vide.";
    	        	}
    	        	else {
    		      
    		            // on fait la requête dans la table "vendeurs" de la BDD pour rechercher si ces données rentrées existent et correspondent
    		            $sql = "SELECT * FROM vendeurs WHERE pseudo = '$pseudo' AND email = '$email' AND mdp = '$mdp'";
    		            $result = mysqli_query($db_handle, $sql);
    		            // si il y a un résultat, mysqli_num_rows() nous donnera alors 1, sinon retourne 0 
    		            if(mysqli_num_rows($result) == 0) {
    		                // on fait la requête dans la table "acheteurs" de la BDD pour rechercher si ces données rentrées existent et correspondent
                            $sql = "SELECT * FROM acheteurs WHERE email = '$email' AND mdp = '$mdp'";
                            $result = mysqli_query($db_handle, $sql);
                            // si il y a un résultat, mysqli_num_rows() nous donnera alors 1, sinon retourne 0 résultat
                            if(mysqli_num_rows($result) == 0) {
                                $erreur = "Le pseudo, l'email ou le mot de passe est incorrect, le compte n'a pas ete trouve.";
                            }
                            else{
                                //on le connecte et on modifie la valeur de "connexion" en 1 dans la BDD
                                $sql = "UPDATE acheteurs SET connexion = 1 WHERE email = '$email'";
                                $result = mysqli_query($db_handle, $sql);

                                //on selectionne les données de la personne
                                $sql = "SELECT * FROM acheteurs WHERE email = '$email' AND mdp = '$mdp'";
                                $result = mysqli_query($db_handle, $sql);

                                //on recupere les données de cette personne (tous les données de la ligne) 
                                $data = mysqli_fetch_array($result);
                                $ID = $data['ID'];

                                //on recupere l'email dans une variable session "user"
                                $_SESSION['user'] = $data['email']; 
                                if(isset($_SESSION['user'])){
                                    $user = $_SESSION['user'];
                                }

                                //redirection vers une autre page
                                header("Location: votre_compte.php?id=".$ID); 
                            }
    		            }
    		            else {
                            //on le connecte et on modifie la valeur de "connexion" en 1 dans la BDD 
                            $sql = "UPDATE vendeurs SET connexion = 1 WHERE email = '$email'";
                            $result = mysqli_query($db_handle, $sql);

                            //on selectionne les données de la personne
                            $sql = "SELECT * FROM vendeurs WHERE email = '$email'";
                            $result = mysqli_query($db_handle, $sql);

                            //on recupere les données de cette personne (tous les données de la ligne) 
                            $data = mysqli_fetch_array($result);
                            $ID = $data['ID'];

                            //on recupere l'email dans une variable session "user"
                            $_SESSION['user'] = $data['email'];
                            if(isset($_SESSION['user'])){
                                $user = $_SESSION['user'];
                            }

                            if($pseudo == "admin"){ //si c'est l'admin
                                //redirection vers page administration.php
                                header("Location: administration.php?id=".$ID);
                            }
                            else{ //si c'est une simple vendeur
                                //redirection vers page mon_profil.php
                                header("Location: mon_profil.php?id=".$ID); 
                            }
                        }
                    }   
    	        }
            }
        }
    }

?> 

<html>
<html>
<head>
    <title>Connexion | ECE Amazon</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="connexion.css">
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
        <h2 class="titre">Connexion</h2>
        <div align="center" class="formulaire">
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12">
                    <form action="" method="POST">  <!-- action vide car code php est dans le meme fichier-->
                        <table>
                            <tr>
                                <td><br/><label for="pseudo">Pseudo :</label></td>
                                <td><br/><input type="text" placeholder="Votre pseudo" name="pseudo" value="<?php if(isset($pseudo)) { echo $pseudo; } ?>"></td> <!--value pour laisser l'affichage de ce qui a été rentrer--> 
                            </tr>
                            <tr>
                                <td><br/><label for="email">Email :</label></td>
                                <td><br/><input type="email" placeholder="Votre mail" name="email" value="<?php if(isset($email)) { echo $email; } ?>"></td>
                            </tr>
                            <tr>
                                <td><br/><label for="mdp"> Mot de passe :</label></td>
                                <td><br/><input type="password" placeholder="Entrez votre mdp" name="mdp"></td>
                            </tr>
                            <tr>
                                <td colspan="2" align="center">
                                 <br/><input class="nextbutton btn btn-secondary btn-block btn-sm" type="submit" name="button_connexion" value="Se connecter"></td>
                            </tr>
		                    <tr><td colspan="2" align="center"><p>___________________________________________</p></td></tr>
                            <tr><td colspan="2" align="center"><br/>Vous n'êtes toujours pas inscrit ?</td></tr>
		                    <tr>
		                        <td colspan="2" align="center">
		                            <a href="inscription.php"><input class="nextbutton btn btn-secondary btn-block btn-sm" type="button" value="S'inscrire"></a>
		                        </td>
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
    //affichage d'erreur si la BDD non trouvée et fermeture de la BDD
} 
else {
    echo "Database not found.";
}
mysqli_close($db_handle);
?>