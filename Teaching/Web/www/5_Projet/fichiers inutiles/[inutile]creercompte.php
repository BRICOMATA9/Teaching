<?php
$pseudo   = isset($_POST["pseudo"])?$_POST["pseudo"] : "";
$email   = isset($_POST["email"])?$_POST["email"] : "";
$passw1 = isset($_POST["passw1"])?$_POST["passw1"] : "";
$passw2 = isset($_POST["passw2"])?$_POST["passw2"] : "";
$type = isset($_POST["type"])?$_POST["type"] : "";

$erreur = "";
$database = "ece_amazon";
$existant = 0;
$cree = 0;


// Vérification des champs
/*if($pseudo == "") {
  $erreur .= "Veuillez remplir de champ 'Pseudonyme'. <br>";
}
if(filter_var($email ,FILTER_VALIDATE_EMAIL) == false) {
    $erreur .= "Format d'adresse non valide. <br>";
}
if($passw1 == "" || $passw2 == "" ) {
  $erreur .= "Veuillez remplir le(s) champ(s) 'Mot de Passe'. <br>";
}
if($passw1 != $passw2) {
  $erreur .= "Les Mots de passes ne correspondent pas. <br>";
}*/

// Vérification dans la base de donnée
//if ($erreur == "") {
$db_handle = mysqli_connect('localhost', 'root', '');
$db_found = mysqli_select_db($db_handle, $database);
if ($_POST["creationCompte"]) {
	if ($db_found) {
	  	$sql = "SELECT * FROM comptes WHERE Pseudonyme LIKE '$pseudo' OR Email LIKE '$email'";
	    $result = mysqli_query($db_handle, $sql);
	    //echo "$sql <br>";
	    //echo mysqli_num_rows($result) . " nb result recherche<br>";
	    if (mysqli_num_rows($result) != 0 ) { $existant = 1; } 
	    //Ajout du compte dans la base de données
	    else if ($pseudo != "" && $email != "" && $passw1 != "" && $passw2 != "" && $passw1 == $passw2) {
	      	$cree = 1;
	        $sql = "INSERT INTO comptes(Pseudonyme, Email, MotDePasse, TypeCompte) VALUES('$pseudo', '$email', '$passw1', '$type')";
	        $result = mysqli_query($db_handle, $sql);
	    }
  	} else {
      echo "Base de donnée non trouvée <br>";
    }
}
//}

?>
<!DOCTYPE html>
<html>
<head>
	<title>Créer un compte</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
 	<link rel="stylesheet"
 	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
 	<link rel="stylesheet" type="text/css" href="vente.css">
 	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		 $(document).ready(function(){
		 $('.header').height($(window).height());
		 });

		 function cacherForm() {
		 	if()
		 }
	</script>
	<style type="text/css">
		#showform { display: block; }
		#hideform { display: none; }
	</style>
</head>
<body>
	
	
	 	<nav class="navbar navbar-expand-md">      
		<a class="nav-link" href = "accueil.html"><img class="Eceamazon" src="images/logo.jpg" alt="plsthumb" width="80" height="80"><br>  
	 	<button class="navbar-toggler navbar-dark" type="button" data-toggle="collapse" data-target="#main-navigation">
	 		<span class="navbar-toggler-icon"></span>
	 	</button>
		 <div class="collapse navbar-collapse" id="main-navigation">
			 <ul class="navbar-nav">
				  <li class="nav-item"><a class="nav-link" href="catagories.html">Nos 4 Catégories</a></li>             
		    	 <li class="nav-item"><a class="nav-link" href="venteflash.html">Ventes flash</a></li>             
		    	 <li class="nav-item"><a class="nav-link" href="vente.html">Vendre</a></li>      
		    	 <li class="nav-item"><a class="nav-link" href="moncompte.html">Mon compte</a></li>  
		    	 <li class="nav-item"><a class="nav-link" href = "vente.html"><img  width="50" height="50" src="images/store.png"></a>
		    	</li>
			 </ul>
		 </div>
	</nav>
<div id="section">
	<form id="<?php if ($cree == 1) { echo "hideform";} else { echo "shoform";} ?>" action="creercompte.php" method="post">
		<h2>Inscrivez-vous !</h2>
		<table>
			<tr>
                <td>Type d'utilisateur : </td>
                <td><select name = "type">
                        <option value ="Acheteur">Acheteur</option>
                        <option value ="Vendeur">Vendeur</option>
                        <option value ="Administrateur">Administrateur</option>
                    </select>
                </td>
            </tr>
			<tr>
				<td>Pseudonyme : </td>   
				<td><input type="text" name="pseudo" value="<?php echo "$pseudo" ?>" /></td>
				
				<td>
					<?php 
						if($pseudo == "") { echo "Veuillez remplir de champ 'Pseudonyme'. <br>"; }
						if($existant == 1 /*&& ($pseudo != "" || $email !="")*/) { echo "Pseudonyme ou Email déjà existant dans la base de données <br>"; }
					?>
				</td>        
			</tr>
			<tr>   
				<td>Email : </td>  
				<td><input type="text" name="email" value="<?php echo "$email" ?>"/></td>
				<td>
					<?php
						if(!filter_var($email ,FILTER_VALIDATE_EMAIL)) { echo "Format d'adresse non valide. <br>"; }
					?>
				</td>
			</tr>
			<tr>   
				<td>Mot de Passe : </td>  
				<td><input type="password" name="passw1"/></td> 
				<td>
					<?php 
						if($passw1 == "" ) { echo "Veuillez remplir le champ 'Mot de Passe'. <br>"; }
						else if($passw1 != $passw2 && $passw2 != "") { echo "Les Mots de passes ne correspondent pas. <br>"; }
					?>
				</td>  
			</tr>
			<tr>   
				<td>Répéter le Mot de Passe : </td>  
				<td><input type="password" name="passw2"/></td> 
				<td>
					<?php 
						if($passw2 == "" ) { echo "Veuillez remplir le champ 'Mot de Passe'. <br>"; }
					?>
				</td> 
			</tr>
			<!--<tr>    
				<td>Prénom :</td>   
				<td><input type="text" name="prenom"/></td>            
			</tr>
			<tr>    
				<td>Nom :</td>   
				<td><input type="text" name="nom"/></td>   
			</tr>
			<tr>   
				<td>Adresse : </td> 
				<td><input type="text" name="adresse"/></td>   
			</tr> -->
			
			 <!--
			<tr>    
				<td>Informations de paiement : </td>  
				<td><input type="text" name="infopaie"/></td>
			</tr>
			<tr>    
				<td>Téléphone : </td>  
				<td><input type="text" name="phone"/></td>
			</tr> -->
			<tr>
				<td>   
				<input type="submit" name = "creationCompte" value="Créer mon compte">
				</td>
			</tr>
	</table>
</form>
<?php 
	if ($cree == true) {
		echo "Bienvenue " .$pseudo ."! <br> Votre profil a été créé avec succès. <br><br>";

        $sql = "SELECT * FROM comptes";
        if ($pseudo != "") {
          $sql .= " WHERE Pseudonyme LIKE '%$pseudo%'";
        }
        $result = mysqli_query($db_handle, $sql);
        while ($data = mysqli_fetch_assoc($result)) {
          echo "Informations sur le compte créé: <br><br>";
          echo "Type de compte : " . $type . "<br>";
          echo "Pseudonyme: " . $data['Pseudonyme'] . "<br>";
          echo "Email: " . $data['Email'] . "<br>";
          echo "Mot de Passe: " . $data['MotDePasse'] . "<br>";
        }
	}
?>
<p>
	<a href="accueil.html">Retour</a> à la page d'accueil.
</p>
	
</div>

	
<footer class="page-footer">
	<div class="container">
	 	<div class="row">
	 		<div class="col-lg-8 col-md-8 col-sm-12">
				<h6 class="text-uppercase font-weight-bold">Information additionnelle</h6>
				<p>
					Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque interdum quam odio, quis placerat ante luctus eu.
					Sed aliquet dolor id sapien rutrum, id vulputate quam iaculis.
				</p>
				<p>
					Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque interdum quam odio, quis placerat ante luctus eu.
					Sed aliquet dolor id sapien rutrum, id vulputate quam iaculis.
				</p>
	  		</div>
	 		<div class="col-lg-4 col-md-4 col-sm-12">
				<h6 class="text-uppercase font-weight-bold">Contact</h6>
				<p>
					37, quai de Grenelle, 75015 Paris, France <br>
					info@webDynamique.ece.fr <br>
					+33 01 02 03 04 05 <br>
					+33 01 03 02 05 04
				</p>
	 		</div>
		</div>
	</div>
	<div class="footer-copyright text-center">&copy; 2019 Copyright | Droit d'auteur: webDynamique.ece.fr</div>
</footer>
		
</body>
</html>