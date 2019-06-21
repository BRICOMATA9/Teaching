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
<?php
    
    session_start();
    $user = $_SESSION['user'];

    //on identifie notre BDD
    $database = 'ece_amazon';

    //connectez-vous dans votre BDD
    //Rappel: votre serveur = localhost et votre login = root et votre password = <rien>
    $db_handle = mysqli_connect('localhost', 'root', '');
    $db_found = mysqli_select_db($db_handle, $database);

    if (isset($_POST['button_ajout'])) {

        //Récupération des données entrées par le vendeur
        $nom = isset($_POST["nom"])? $_POST["nom"] : "";
        $activite = isset($_POST["activite"])? $_POST["activite"] : "";
        $age = isset($_POST["age"])? $_POST["age"] : "";
        $lieu = isset($_POST["lieu"])? $_POST["lieu"] : "";
        $date = isset($_POST["date"])? $_POST["date"] : "";
        $description = isset($_POST["description"])? $_POST["description"] : "";
        $photos = isset($_POST["photos"])? $_POST["photos"] : "";
        $photo2 = isset($_POST["photo2"])? $_POST["photo2"] : "";
        $video = isset($_POST["video"])? $_POST["video"] : "";
        $prix = isset($_POST["prix"])? $_POST["prix"] : "";
        $stock = isset($_POST["stock"])? $_POST["stock"] : "";
        
        if($description == $nom){
            $error = "Veuillez différencier le nom de la description.";
        }
        
        else if((!empty($nom)) AND (!empty($age)) AND (!empty($date)) AND (!empty($lieu)) AND (!empty($description)) AND (!empty($photos)) AND (!empty($prix)) AND (!empty($stock))){

            if ($db_found) {
                
                //recherche parmis les loisirs si ce nom exite déjà 
                $sql = "SELECT * FROM sports_loisir WHERE nom = '$nom'";
                $result = mysqli_query($db_handle, $sql);
                //si pas de résultat
                if (mysqli_num_rows($result) == 0) {
                    
                    //recherche parmis les vêtements si ce nom exite déjà 
                    $sql = "SELECT * FROM sports_loisir WHERE description = '$description'";
                    $result = mysqli_query($db_handle, $sql);
                    //si pas de résultat
                    if (mysqli_num_rows($result) == 0) {

                        //recherche du vendeur connecté
                        $sql = "SELECT * FROM vendeurs WHERE email = '$user'";
                        $result = mysqli_query($db_handle, $sql);
                        $data = mysqli_fetch_array($result);
                        $ID_vendeur = $data['ID'];

                        //insertion du nouveau loisir
                        $sql = "INSERT INTO sports_loisir(ID_vendeur,nom,age,activite,date,lieu,photos,photo2,description,video,prix,stock,nb_vendus,date_ligne) VALUES ('$ID_vendeur','$nom','$age','$activite','$date','$lieu','$photos','$photo2','$description','$video','$prix','$stock',0,NOW())";
                        //$sql1 = "INSERT INTO panier(nom,quantite,total) VALUES ('$nom','$quantite',0)";
                        $result = mysqli_query($db_handle, $sql); 

                        $valid = "Votre loisir ". $nom ." a été ajouté à la vente !";
                    
                    } else {
                        $error = "Cette description existe déjà.";
                    }
                        
                } else {
                    $error = "Cet article existe déjà sous ce nom.";
                }

            } else {
                echo "Database not found.";
            }
        } else {
            $error .= "Veuillez remplir tous les champs non optionnels.";
        }
    }
    //fermer la connexion
    mysqli_close($db_handle);
?>

<!DOCTYPE html>
<html>
<head>
    <!-- TITRE A CHANGER POUR CHAQUE PAGE -->
    <title>Ajout Sport et Loisir | ECE Amazon</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    <!-- LIEN VERS LA PAGE DE CSS A CHANGER SELON LA PAGE -->
    <link rel="stylesheet" type="text/css" href="ajout_item.css">
    <script type="text/javascript">
        $(document).ready(function() {
            $("#accept").click(function() {
               if($("#submitbtn").is(':disabled')) {
                   $("#submitbtn").removeAttr('disabled'); 
               } else {
                   $("#submitbtn").attr('disabled','disabled');
               } 
            });
        });
    </script>
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
        <div class="container">
            <!-- Titre -->
            <h2 class="titre">Mettre en vente un loisir</h2>
            
            <!-- Découpage de la page en grille -->
            <div class="row">   
                <!-- Bouton retour -->
                <div class="col-lg-3 col-md-3 col-sm-12">
                    <a class="lien" href="ajout_item.php"><button style="background-color:#4B4341;padding:5px 20px 5px 20px" type="button" class="btn btn-secondary btn-sm">Retour</button></a>
                </div>
                <div class="col-lg-6 col-md-6 col-sm-12" style="background-color:white">
                    <center>
                    <!-- Formulaire Vêtement -->
                    <form method="post">
                        <table>
                            <tr>
                                <td>Nom de l'article: </td>
                                <td><input type="text" name="nom"></td>
                            </tr>
                            <tr>
                                <td>Activité: </td>
                                <td>
                                    <select name="activite">
                                        <option value="Détente">Détente</option>   
                                        <option value="Parc d'attraction">Parc d'attractions</option>
                                        <option value="Plein air">Plein air</option>
                                        <option value="Sortie culturelle">Sortie culturelle</option>
                                        <option value="Sport">Sport</option>            
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td>Âge: </td>
                                <td><input type="number" name="age"></td>
                            </tr>
                            <tr>
                                <td>Date: </td>
                                <td><input type="Date" name="date"></td>
                            </tr>
                            <tr>
                                <td>Lieu: </td>
                                <td><input type="text" name="lieu"></td>
                            </tr>
                            <tr>
                                <td>Description: </td>
                                <td><textarea name="description" rows="5"></textarea></td>
                            </tr>
                            <tr>
                                <td>Nom de la photo principale: </td>
                                <td><input type="text" name="photos"></td>
                            </tr> 
                            <tr>
                                <td>Nom de la deuxième photo(option): </td>
                                <td><input type="text" name="photo2"></td>
                            </tr>
                            <tr>
                                <td>Nom de la vidéo(option): </td>
                                <td><input type="text" name="video"></td>
                            </tr>
                            <tr>
                                <td>Prix (en €): </td>
                                <td><input type="number" name="prix"></td>
                            </tr>
                            <tr>
                                <td>Taille du stock: </td>
                                <td><input type="number" name="stock"></td>
                            </tr>
                            <br>
                            <tr>
                                <td colspan="2" align="center">
                                    <br><p class="text-warning">
                                        <?php echo $error; ?>
                                    </p>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2" align="center">
                                    <p class="text-success">
                                        <?php echo $valid; ?>
                                    </p>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <input id="accept" name="accept" type="checkbox" value="y"> Je valide mon annonce.
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2" align="center">
                                    <br><input class="next btn btn-secondary btn-block btn-sm" style="background-color:#F6745A;border:grey" id="submitbtn" name="button_ajout" disabled="disabled" type="submit" value="Soumettre"><br><br>
                                </td>
                            </tr>
                        </table>
                    </form>
                    </center>
                </div>
                <div class="col-lg-3 col-md-3 col-sm-12">
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