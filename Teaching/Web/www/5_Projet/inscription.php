<?php
$bdd = new PDO('mysql:host=localhost;dbname=ece_amazon', 'root', '');

$pseudo = isset($_POST["pseudo"])?$_POST["pseudo"] : "";
$email = isset($_POST["email"])?$_POST["email"] : "";
$passw1 = isset($_POST["passw1"])?$_POST["passw1"] : "";
$passw2 = isset($_POST["passw2"])?$_POST["passw2"] : "";
$type = isset($_POST["type"])?$_POST["type"] : "";
$phone = isset($_POST["phone"])?$_POST["phone"] : "";
$adresse = isset($_POST["adresse"])?$_POST["adresse"] : "";
$ville = isset($_POST["ville"])?$_POST["ville"] : "";
$pays = isset($_POST["pays"])?$_POST["pays"] : "";

$erreur = "";
$cree = 0;
$passcorrpesond = 0;

if (isset($_POST["creationCompte"]))
{
	if ($passw1 == $passw2) { $passcorrpesond = 1; }
	// On cherche si le mail est dans la base (retourne le nb de lignes)
    $maildispo = $bdd->prepare("SELECT * FROM comptes WHERE Email = ?");
   	$maildispo->execute(array($email));
   	$mailexiste = $maildispo->rowCount();

	// On cherche si le pseudo est dans la base (retourne le nb de lignes)
   	$pseudodispo = $bdd->prepare("SELECT * FROM comptes WHERE Pseudonyme = ?");
   	$pseudodispo->execute(array($pseudo));
   	$pseudoexiste = $pseudodispo->rowCount();
	// Si tous les champs sont remplis
	if (!empty($pseudo) AND !empty($email) AND !empty($passw1) AND !empty($passw2) AND !empty($phone) AND !empty($adresse) AND !empty($ville) AND !empty($pays))
	{
		if(filter_var($email ,FILTER_VALIDATE_EMAIL))
		{
		   	// Si le pseudo n'existe pas, on continue la vérification
		   	if ($pseudoexiste == 0)
		   	{
		   		
		   		// Si le mail n'existe pas, on continue la vérification
		   		if($mailexiste == 0)
			   	{
			   		
			   		// Si les mots de passe sont identiques, on ajoute à la bdd
			   		
			   		if ($passw1 == $passw2)
			   		{
			   			$passcorrpesond = 1;
			   			$cree = 1;
			   			$ajoutcompte = $bdd->prepare("INSERT INTO comptes(Pseudonyme, Email, Telephone, Adresse, Ville, Pays, MotDePasse, TypeCompte) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
			   			$ajoutcompte->execute(array($pseudo, $email, $phone, $adresse, $ville ,$pays, $passw1, $type));
			   			
			   		}
			   	}
		   	}
		}
	}   
}

?>
<!DOCTYPE html>
<html>
<head>
	<title>Inscription</title>
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
    <a href = "accueil.php"><img class="Eceamazon" src="images/logo.png" width="80" height="80"></a>
    <div class="collapse navbar-collapse" id="main-navigation">
        <ul class="navbar-nav">
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">Catégories</a>
                <div class="dropdown-menu">
                    <a class="dropdown-item" href="categories.php?type=Livre">Livres</a>
                    <a class="dropdown-item" href="categories.php?type=Musique">Musique</a>
                    <a class="dropdown-item" href="categories.php?type=Vetement">Vêtements</a>
                    <a class="dropdown-item" href="categories.php?type=Loisir">Sports & Loisir</a>
                    <a class="dropdown-item" href="categories.php?type=All">Toutes les catégories</a>
                </div>
            </li>
            <li class="nav-item dropdown" >
                <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">Ventes flash</a>
                <div class="dropdown-menu">
                    <a class="dropdown-item" href="venteflash.php">Livres</a>
                    <a class="dropdown-item" href="venteflash.php">Musique</a>
                    <a class="dropdown-item" href="venteflash.php">Vêtements</a>
                    <a class="dropdown-item" href="venteflash.php">Sports & Loisir</a>
                    <a class="dropdown-item" href="venteflash.php">Toutes les catégories</a>
                </div>
            </li>
            <li class="nav-item"><a class="nav-link" href="vente.php">Vendre</a></li>
            <li class="nav-item"><a class="nav-link" href = "profil.php?id=<?php echo $_SESSION['id'] ?>"><img  width="50" height="50" src="images/team.png"></a></li>
            <li class="nav-item"><a class="nav-link" href = "panier.php"><img  width="50" height="50" src="images/cart.png"></a></li>
        </ul>
    </div>
</nav>
<div id="section">
	<form id="<?php if ($cree == 1) { echo "hideform";} else { echo "shoform";} ?>" action="" method="post">
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
				<td><input class="form-control" type="text" name="pseudo" placeholder = "Pseudonyme" value="<?php echo "$pseudo" ?>" /></td>
				
				<td>
					<?php 
						if(empty($pseudo) && isset($_POST["creationCompte"])) { echo "Veuillez remplir le champ 'Pseudonyme'. <br>"; }
						if($pseudoexiste == 1) { echo "Pseudonyme déjà existant dans la base de données <br>"; }
					?>
				</td>        
			</tr>
			<tr>   
				<td>Email : </td>  
				<td><input class="form-control" type="text" name="email" placeholder="Email" value="<?php echo "$email" ?>" /></td>
				<td>
					<?php
						if(!filter_var($email ,FILTER_VALIDATE_EMAIL) && isset($_POST["creationCompte"])) { echo "Format d'adresse non valide. <br>"; }
						if($mailexiste == 1) { echo "Email déjà existant dans la base de données <br>"; }
					?>
				</td>
			</tr>
			<td>Téléphone : </td>   
				<td><input class="form-control" type="text" name="phone" placeholder = "Phone" value="<?php echo "$phone" ?>" /></td>
				
				<td>
					<?php 
						if(empty($phone) && isset($_POST["creationCompte"])) { echo "Veuillez remplir le champ 'Téléphone'. <br>"; }
						 
					?>
				</td>        
			</tr>
			<td>Adresse : </td>   
				<td><input class="form-control" type="text" name="adresse" placeholder = "Adresse" value="<?php echo "$adresse" ?>" /></td>
				
				<td>
					<?php 
						if(empty($adresse) && isset($_POST["creationCompte"])) { echo "Veuillez remplir le champ 'Adresse'. <br>"; }
						 
					?>
				</td>        
			</tr>
			<td>Ville : </td>   
				<td><input class="form-control" type="text" name="ville" placeholder = "Ville" value="<?php echo "$ville" ?>" /></td>
				
				<td>
					<?php 
						if(empty($ville) && isset($_POST["creationCompte"])) { echo "Veuillez remplir le champ 'Ville'. <br>"; }
						 
					?>
				</td>        
			</tr>
			<td>Pays : </td>   
				<td><input class="form-control" type="text" name="pays" placeholder = "Pays" value="<?php echo "$Pays" ?>" /></td>
				
				<td>
					<?php 
						if(empty($pays) && isset($_POST["creationCompte"])) { echo "Veuillez remplir le champ 'Pays'. <br>"; }
						 
					?>
				</td>        
			</tr>
			<tr>   
				<td>Mot de Passe : </td>  
				<td><input class="form-control" type="password" name="passw1" placeholder="Mot de passe" /></td> 
				<td>
					<?php 
						if(empty($passw1) && isset($_POST["creationCompte"])) { echo "Veuillez remplir le champ 'Mot de Passe'. <br>"; }
						else if($passcorrpesond == 0 && isset($_POST["creationCompte"])) { echo "Les Mots de passe ne correspondent pas. <br>"; }
						
					?>
				</td>  
			</tr>
			<tr>   
				<td>Répéter le Mot de Passe : </td>  
				<td><input class="form-control" type="password" name="passw2" placeholder="Mot de passe" /></td> 
				<td>
					<?php 
						if(empty($passw2) && isset($_POST["creationCompte"])) { echo "Veuillez remplir le champ 'Mot de Passe'. <br>"; }
						else if($passcorrpesond == 0 && isset($_POST["creationCompte"])) { echo "Les Mots de passe ne correspondent pas. <br>"; }
					?>
				</td> 
			</tr>
			<tr>
				<td>   
				<input class="btn btn-outline-primary" type="submit" name = "creationCompte" value="Créer mon compte">
				</td>
			</tr>
	</table>
</form>
<?php 
	if ($cree == 1) {
		echo "Bienvenue " .$pseudo ."! <br> Votre profil a été créé avec succès. <br><br>";
		$infoscomptecree = $bdd->query("SELECT * FROM comptes WHERE Pseudonyme LIKE '$pseudo'");
		while($data = $infoscomptecree->fetch()) {
			echo "Informations sur le compte créé: <br><br>";
			echo "Type de compte : " . $data['TypeCompte']. "<br>";
			echo "Pseudonyme : " . $data['Pseudonyme']. "<br>";
			echo "Email : " . $data['Email']. "<br>";
			echo "Telephone : " . $data['Telephone']. "<br>";
			echo "Adresse : " . $data['Adresse']. "<br>";
			echo "Ville : " . $data['Ville']. "<br>";
			echo "Pays : " . $data['Pays']. "<br>";
			echo "Mot de Passe : " . $data['MotDePasse']. "<br>";
		}
	}
?>
<p>
	<a class="btn btn-outline-secondary" href="accueil.php">Accueil</a>
	
</p>
	
</div>

	
<footer class="page-footer">
	<div class="container">
	 	<div class="row">
	 		<div class="col-lg-8 col-md-8 col-sm-12">
				<h6 class="text-uppercase font-weight-bold">Information additionnelle</h6>
				<p>
					Info1
				</p>
				<p>
					Info2
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