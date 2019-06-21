<?php
session_start();

$bdd = new PDO('mysql:host=localhost;dbname=ece_amazon', 'root', '');

$IDVendeur = intval($_GET['id']);
$categorie = isset($_POST["categorie"])?$_POST["categorie"] : "";

$nomitem = isset($_POST["nomitem"])?$_POST["nomitem"] : "";
$prix = isset($_POST["prix"])?$_POST["prix"] : "";
$quantite = isset($_POST["quantite"])?$_POST["quantite"] : "";
$description = isset($_POST["description"])?$_POST["description"] : "";
$photo = isset($_POST["photo"])?$_POST["photo"] : "";
$video = isset($_POST["video"])?$_POST["video"] : "";

//$itemcree = 0;
$mauvaisformat = 0;
$imgtropgrande = 0;

if ($categorie == 1) { $categorie ="Livre";  }
if ($categorie == 2) { $categorie ="Musique"; }
if ($categorie == 3) { $categorie ="Vetement"; }
if ($categorie == 4) { $categorie ="Loisir"; }


if (isset($_POST["ajouterItem"]))
{
	$itemcree = 0;
	if (!empty($nomitem) AND !empty($prix) AND !empty($quantite) AND !empty($description) AND !empty($_FILES['photo']['name']))
	{
		$tailleMax = 2097152; // Equivaut à 2Mo
		$extensionsValides = array('jpg', 'jpeg', 'png');
		if($_FILES['photo']['size'] <= $tailleMax)
		{
			$extensionUpload = strtolower(substr(strrchr($_FILES['photo']['name'], '.'), 1));
			if(in_array($extensionUpload, $extensionsValides))
			{
				if ($categorie == "Livre")
				{
					$auteur = isset($_POST["auteur"])?$_POST["auteur"] : "";
					if (!empty($auteur))
					{
						$ajoutItem = $bdd->prepare("INSERT INTO items(NomItem, Prix, Description, Quantite, TypeItem, Auteur, IDVendeur) VALUES (?, ?, ?, ?, ?, ?, ?)");
						$ajoutItem->execute(array($nomitem, $prix, $description, $quantite, $categorie, $auteur, $_SESSION['id']));
						$itemcree = 1;
					}
				}
				if ($categorie == "Musique")
				{
					$artiste = isset($_POST["artiste"])?$_POST["artiste"] : "";
					if (!empty($artiste))
					{
						$ajoutItem = $bdd->prepare("INSERT INTO items(NomItem, Prix, Description, Quantite, TypeItem, Artiste, IDVendeur) VALUES (?, ?, ?, ?, ?, ?, ?)");
						$ajoutItem->execute(array($nomitem, $prix, $description, $quantite, $categorie, $artiste, $_SESSION['id']));
						$itemcree = 1;
					}
				}
				if ($categorie == "Vetement")
				{
					$typevet = isset($_POST["typevet"])?$_POST["typevet"] : "";
					$genre = isset($_POST["genre"])?$_POST["genre"] : "";
					$couleur = isset($_POST["couleur"])?$_POST["couleur"] : "";

					if (!empty($genre) AND !empty($couleur)) 
					{
						if ($typevet == 1) // chaussures
						{
							$typevet ="chaussures";
							$pointure = isset($_POST["pointure"])?$_POST["pointure"] : "";
							if (!empty($pointure))
							{
								$ajoutItem = $bdd->prepare("INSERT INTO items(NomItem, Prix, Description, Quantite, TypeItem, TypeVetement, Genre, Couleur, Pointure, IDVendeur) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
								$ajoutItem->execute(array($nomitem, $prix, $description, $quantite, $categorie, $typevet, $genre, $couleur, $pointure));
								$itemcree = 1;
							}
						}
						if ($typevet == 2) // habits
						{
							$typevet ="habits";
							$taillev = isset($_POST["taillev"])?$_POST["taillev"] : "";
							if(!empty($taillev))
							{
								$ajoutItem = $bdd->prepare("INSERT INTO items(NomItem, Prix, Description, Quantite, TypeItem, TypeVetement, Genre, Couleur, Taille, IDVendeur) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
								$ajoutItem->execute(array($nomitem, $prix, $description, $quantite, $categorie, $typevet, $genre, $couleur, $taillev, $_SESSION['id']));
								$itemcree = 1;
							}
						}
					}
				}
				if ($categorie == "Loisir")
				{
					$ajoutItem = $bdd->prepare("INSERT INTO items(NomItem, Prix, Description, Quantite, TypeItem, IDVendeur) VALUES (?, ?, ?, ?, ?, ?)");
					$ajoutItem->execute(array($nomitem, $prix, $description, $quantite, $categorie, $_SESSION['id']));
					$itemcree = 1;
				}
				echo $itemcree;
				if ($itemcree == 1)
				{
					$reqid = $bdd->query("SELECT * FROM items ORDER BY items . ID DESC LIMIT 1");
					//$reqid = $bdd->query("SELECT * FROM items HAVING MAX(ID)");
					$maxid = $reqid->fetch();
					//echo "id max = ". $maxid['ID']. "<br>";
					$chemin = "articles/".$maxid['ID'].".".$extensionUpload;
					$resultat = move_uploaded_file($_FILES['photo']['tmp_name'], $chemin);
					if ($resultat)
					{
						$ajoutimg = $bdd->prepare("UPDATE items SET Photo = ? WHERE ID = ?");
						$ajoutimg->execute(array($maxid['ID'].".".$extensionUpload, $maxid['ID']));
						//$ajoutimg = $bdd->prepare('UPDATE items SET Photo = :photo WHERE ID = :id');
						//$ajoutimg->execute(array(
						//	'photo' => $maxid['ID'].".".$extensionUpload
						//	'id' => $maxid['ID']
						//));
						//echo "image ajoutee !!! <br>";
					}
				}
			} else { $mauvaisformat = 1; }
		} else { $imgtropgrande = 1; }
	}
}


?>
<!DOCTYPE html>
<html> 
<head> 
	<meta charset="utf-8"> 
	<title>Vendre un objet</title>
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

		function typeItem() {
			var pos = document.getElementById("select_base").value;
			if (pos == 1) {
				document.getElementById("livre").style.display = "block";
				document.getElementById("musique").style.display = "none";
				document.getElementById("vetement").style.display = "none";
				document.getElementById("chaussures").style.display = "none";
				document.getElementById("habits").style.display = "none";
			}
			if (pos == 2) {
				document.getElementById("livre").style.display = "none";
				document.getElementById("musique").style.display = "block";
				document.getElementById("vetement").style.display = "none";
				document.getElementById("chaussures").style.display = "none";
				document.getElementById("habits").style.display = "none";

			}
			if (pos == 3) {

				document.getElementById("livre").style.display = "none";
				document.getElementById("musique").style.display = "none";
				document.getElementById("vetement").style.display = "block";
				document.getElementById("chaussures").style.display = "block";
				document.getElementById("habits").style.display = "none";
				

			}
			if (pos == 4) {
				document.getElementById("livre").style.display = "none";
				document.getElementById("musique").style.display = "none";
				document.getElementById("vetement").style.display = "none";
				document.getElementById("habits").style.display = "block";
				document.getElementById("chaussures").style.display = "none";
				document.getElementById("habits").style.display = "none";
			}
		}

		function typeVet() {
			var pos2 = document.getElementById("select_base2").value;
			if (pos2 == 1) {
				document.getElementById("habits").style.display = "none";
				document.getElementById("chaussures").style.display = "block";

			}
			if (pos2 == 2) {
				document.getElementById("habits").style.display = "block";
				document.getElementById("chaussures").style.display = "none";	
			}
		}
	</script>
	<style type="text/css">
		#livre { display: block; }
		#musique { display: none; }
		#vetement { display: none; }
		#chaussures { display: none; }
		#habits { display: none; }

	</style>
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
	
</head>
<body>
	<div id="section">
	<?php
	if (isset($_SESSION['type']) AND ($_SESSION['type'] == "VENDEUR" OR $_SESSION['type'] == "ADMINISTRATEUR"))
	{
		if (isset($itemcree) && $itemcree == 1)
		{
			echo "Votre article a bien ete ajoute.<br><br><br><br><br><br>";
			echo "<a href=\"vente.php\"><input type = \"submit\" value = \"Rajouter un article\"/></a> <br><br><br><br>";
			echo "</div>";
		}
		if (!isset($itemcree) OR $itemcree != 1)
		{


	?>
	
		<form action="" method="post" enctype="multipart/form-data">
			<h2>Vente d'un objet</h2>
			<table>            
				<tr>   
					<td>Catégories :</td>    
					<td>
						<select class="form-control" name="categorie" id="select_base" onchange="typeItem()">
							<option value="1">Livre</option>
							<option value="2">Musique</option>
							<option value="3">Vêtement</option>
							<option value="4">Loisir & Sport</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>Nom : </td>
					<td><input class="form-control" type="text" name="nomitem" placeholder="Nom" value="<?php echo "$nomitem" ?>"></td>
					<td>
						<?php 
						if(empty($nomitem) AND isset($_POST["ajouterItem"])) { echo "Veuillez remplir le champ 'Nom'. <br>"; }
						?>
					</td>
				</tr>
				<tr>
					<td>Prix à l'unité : </td>
					<td><input class="form-control" type="number" step="any" name="prix" min="1" placeholder="Prix" value="<?php echo "$prix" ?>"></td>
					<td>
						<?php 
						if(empty($prix) AND isset($_POST["ajouterItem"])) { echo "Veuillez remplir le champ 'Prix'. <br>"; }
						?>
					</td>
				</tr>
				<tr>
					<td>Quantité : </td>
					<td><input class="form-control" type="number" min="1" max="10" name="quantite" value="<?php echo "$quantite" ?>"></td>
					<td>
						<?php 
						if(empty($quantite) AND isset($_POST["ajouterItem"])) { echo "Veuillez remplir le champ 'Quantité'. <br>"; }
						?>
					</td>
				</tr>
				<tr>
					<td>Description : </td>
					<td><textarea class="form-control" placeholder="Description" name="description" ><?php echo "$description" ?></textarea></td>
					<td>
						<?php 
						if(empty($description) AND isset($_POST["ajouterItem"])) { echo "Veuillez remplir le champ 'Description'. <br>"; }
						?>
					</td>

				</tr>
				<tr>
					<td>Photo :</td>
					<td><input class="form-control" type="file" id="photo" name="photo"></td>
					<td>
						<?php 
						if(empty($_FILES['photo']['name']) AND isset($_POST["ajouterItem"])) { echo "Veuillez ajouter une image. <br>"; }
						if ($mauvaisformat == 1) { "L'image doit être au format .jpg, .jpeg ou .png. <br>"; }
						if ($imgtropgrande == 1) { "L'image ne doit pas dépasser 2 Mo. <br>"; }
						?>
					</td>
					
				</tr>
				<tr>
					<td>Vidéo (facultatif):</td>
					<td><input class="form-control" type="file" id="video" name="video" accept="image2/mov, image2/mp4"></td>
					<td>
					</td>
				</tr>
			</table>

			<table id = "livre">
				<tr>
					<td>Auteur du livre : </td>
					<td><input class="form-control" type="text" name="auteur" placeholder="Auteur" value="<?php echo "$auteur" ?>"></td>
					<td>
						<?php 
						if(empty($auteur) AND isset($_POST["ajouterItem"])) { echo "Veuillez remplir le champ 'Auteur'. <br>"; }
						?>
					</td>
				</tr>
			</table>

			<table id = "musique">
				<tr>
					<td>Artiste :</td>
					<td><input class="form-control" type="text" name="artiste" placeholder = "Artiste" value="<?php echo "$artiste" ?>"></td>
					<td>
						<?php 
						if(empty($artiste) AND isset($_POST["ajouterItem"])) { echo "Veuillez remplir le champ 'artiste'. <br>"; }
						?>
					</td>
				</tr>
			</table>

			<table id = "vetement">

				<tr>
					<td>Type de vêtement :</td>
					<td><select class="form-control" name ="typevet" id="select_base2" onchange="typeVet()">
						<option value="1">Chaussures</option>
						<option value="2">Habits</option></select>
					</td>
				</tr>
				<tr>
					<td>Vêtement pour :</td>
					<td><select class="form-control" name="genre">
						<option value="Femme">Femme</option>
						<option value="Homme">Homme</option></select>
					</td>
				</tr>
				<tr>
					<td>Couleur :</td>
					<td><input class="form-control" type="text" name="couleur" placeholder="Couleur" value="<?php echo "$couleur" ?>"></td>
					<td>
						<?php 
						if(empty($couleur) AND isset($_POST["ajouterItem"])) { echo "Veuillez remplir le champ 'Couleur'. <br>"; }
						?>
					</td>
				</tr>
			</table>

			<table id = "habits">
				<tr>
					<td>Taille :</td>
					<td><select class="form-control" type="text" name="taillev">
						<option value ="XS">XS</option>
						<option value ="S">S</option>
						<option value ="M">M</option>
						<option value ="L">L</option>
						<option value ="XL">XL</option></select>
					</td>
				</tr>
			</table>

			<table id = "chaussures">
				<tr>
					<td>Pointure :</td>
					<td><input class="form-control" type="number" name="pointure" placeholder="Pointure" value="<?php echo "$pointure" ?>"></td>
					<td>
						<?php 
						if(empty($pointure) AND isset($_POST["ajouterItem"])) { echo "Veuillez remplir le champ 'Pointure'. <br>"; }
						?>
					</td>
				</tr>
			</table>

			<table>
				<tr>       
					<td colspan="2" align="center">
						<input class="btn btn-outline-success" type="submit" name="ajouterItem" value="Mise en vente">
					</td>  
				</tr>
			</table>
		</form>

		<p>
			<br>
			<br>
			<br>
			<a href="accueil.php"><input class ="btn btn-outline-secondary" type = "submit" value = "Accueil"/></a>
		</p>
	</div>
	<?php
		}
	}
	else
	{
		if (!isset($_SESSION['id']))
		{ 
			echo "<br>Vous n'êtes pas connecté. <br><br>"
			?>
			<a href="inscription.php"><input class ="btn btn-outline-secondary" type = "submit" value = "S'inscrire"/></a>
			<a href="connexion.php"><input class ="btn btn-outline-secondary" type = "submit" value = "Se connecter"/></a>
			<?php
			echo "<br><br><br><br><br></div>";
		}
		if (isset($_SESSION['id']) AND $_SESSION['type'] == "ACHETEUR")
		{
			echo "Vous n'êtes ni vendeur ni administrateur. Connectez ou inscrivez vous en tant que vendeur ou administrateur. <br><br><br>";
			echo "<a href=\"deconnexion.php\"><input type = \"submit\" value = \"Se deconnecter\"/></a> <br><br><br><br><br>";
		}
	}
	?>


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
