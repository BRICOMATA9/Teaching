<!-- PHP USER CONNECTE -->
<?php 
    session_start();

    //Partie USER
    if(isset($_SESSION['user'])){
        $user = $_SESSION['user'];
    }
    else{
        $user = "";
    }

    //article
    $nom = $_SESSION['nom_sessionM'];   

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
    <title>Fiche Produit | ECE Amazon</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    <!-- LIEN VERS LA PAGE DE CSS A CHANGER SELON LA PAGE -->
    <link rel="stylesheet" type="text/css" href="fiche_produit.css">

    <script type="text/javascript"> 
        $(document).ready(function(){
            $('body').css('background-image','url(<?php echo $fond; ?>)');
            $('.fondheader').css('background-color','white');
        });
    </script>

    <script type="text/javascript">
        //fonctions pour le carrousel d'images
        $(document).ready(function(){
            var $carrousel = $('#carrousel img');
            var $img = $('#carrousel img');
            var $indexImg = $img.length - 1;
            var i = 0; //compteur
            var $currentImg = $img.eq(i); //image courante
            $img.css('display', 'none');
            $currentImg.css('display', 'block');
            
            //quand on clique sur le bouton "suivant"
            $('.next').click(function(){
                i++;
                if (i <= $indexImg){
                    $img.css('display', 'none');
                    $currentImg = $img.eq(i);
                    $currentImg.css('display', 'block');
                } else {
                    i = $indexImg;
                }
            });
            //quand on clique sur le bouton "précédent"
            $('.prev').click(function(){
                i--;
                if (i >= 0){
                    $img.css('display', 'none');
                    $currentImg = $img.eq(i);
                    $currentImg.css('display', 'block');
                } else {
                    i = 0;
                }
            });    
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
            <div class="row">
                <!-- partie gauche -->
                <div class="col-lg-8 col-md-8 col-sm-12" id="carrousel"> 
                        <!-- affichage des images sur la fiche produit -->
                        <?php
                            $sql = "SELECT * FROM musique WHERE nom = '$nom'";
                            $result = mysqli_query($db_handle, $sql);
                            while($data = mysqli_fetch_assoc($result)){
                                echo '<ul>';
                                print '<li><center><img class="img" src="'. $data['photos'] .'" alt="' . $data['photos']. '" height="350px"></center></li>';
                                if($data['photo2'] != ""){
                                    print '<li><center><img class="img" src="'. $data['photo2'] .'" alt="' . $data['photo2']. '" height="350px"></center></li>';
                                }
                                echo '</ul>';
                        ?>
                    <!-- boutons sous la photo Précédent/Suivant -->
                    <center>
                        <input type="button" value="Précédent" class="prev btn btn-sm push">
                        <input type="button" value="Suivant" class="next btn btn-sm push">
                    </center>
                    <?php
                            if($data['video'] != ""){
                                echo '<center><iframe src="' . $data['video'] . '"></iframe></center>';
                            }
                        }
                    ?>
                </div>
                <!-- partie droite -->
                <div class="col-lg-4 col-md-4 col-sm-12" id="infos">
                        <!-- affichage des infos du produit -->
                        <?php
                            $sql = "SELECT * FROM musique WHERE nom = '$nom'";
                            $result = mysqli_query($db_handle, $sql);
                            while($data = mysqli_fetch_assoc($result)){
                                echo '<h4 class="nom_article">'. $data ["nom"] . '</h4>';
                                echo "<br>Artiste: " . $data['artiste'] . '<br>';
                                echo "Date de sortie: " . $data['annee_sortie'] . '<br>';
                                echo "Genre: " . $data['genre'] . '<br>';
                                echo '<br><p class="text-justify" style="font-style:italic;padding-right:10px">' . "Description: " . $data['description'] . '</p><br>';
                                echo '<p id="prix">' . $data['prix'] . '€</p><br>';
                            }
                        ?>
                    <!-- formulaire pour récupérer la quantité -->
                    <form method="post">
                        <tr>
                            <td>Quantité: </td>
                            <td><input type="number" name="quantite"></td>
                        </tr>
                        <tr>
                           <br><br><input type="submit" class="btn btn-block" id="ajout" name="ajoutP" value="Ajouter au panier">
                        </tr>
                    </form><br>
                    <?php
                        //si le bouton "ajouter au panier" est cliqué
                        if (isset($_POST['ajoutP'])) {
                            
                            //on récupère la quantité
                            $quantite = isset($_POST["quantite"])? $_POST["quantite"] : "";
                            
                            //si la quantité n'est pas entrée
                            if(($quantite == "") || ($quantite==0)){
                                echo '<p class="text-danger"><em>Veuillez entrer une quantité.</em></p>';
                            }
                            
                            //si une quantité est entrée
                            else {
                                $sql = "SELECT * FROM musique WHERE nom = '$nom'";
                                $result = mysqli_query($db_handle, $sql);
                                while($data = mysqli_fetch_array($result)){
                                    
                                    $description = $data['description'];
                                    
                                    //si la quantité entrée est supérieure au stock du produit
                                    if($quantite > $data['stock']){
                                        echo '<p class="text-danger"><em>Pas assez de stock.</em></p>';
                                    }
                                    
                                    //si la quantité est correct
                                    else {
                                        //on insert ce produit dans le panier
                                        $sql = "SELECT * FROM panier WHERE nom = '$nom'";
                                        $result = mysqli_query($db_handle, $sql);
                                        if(mysqli_num_rows($result) == 0){
                                            //on insert ce produit dans le panier
                                            $sql1 = "INSERT INTO panier(nom,description,quantite,total) VALUES ('$nom','$description','$quantite',0)";
                                            $result = mysqli_query($db_handle, $sql1);
                                            
                                        } else {
                                            //on modifie la quantite de ce produit dans le panier
                                            $sql1 = "UPDATE panier SET quantite = quantite + '$quantite' WHERE nom = '$nom'";
                                            $result = mysqli_query($db_handle, $sql1);
                                        }
                                        
                                        //message de confirmation
                                        echo '<p class="text-success"><em>Produit ajouté au panier</em></p>';
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