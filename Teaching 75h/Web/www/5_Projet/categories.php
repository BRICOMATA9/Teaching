<?php
session_start();
$bdd = new PDO('mysql:host=localhost;dbname=ece_amazon', 'root', '');
$type = array("Livre", "Musique", "Vetement", "Loisir", "All");
$passwconnexion = isset($_POST["passwconnexion"])?$_POST["passwconnexion"] : "";


if (isset($_GET['type']) AND ($_GET['type'] != ""))
{
	$idpage = htmlspecialchars($_GET['type']);
	for ($i=0; $i<5; $i++)
	{
		if ($idpage == $type[$i])
		{
			if ($i != 4)
			{
				$infos = $bdd->query("SELECT * FROM items WHERE TypeItem LIKE '$idpage' AND Quantite != 0");
				$titre = $type[$i];
			}
			else
			{
				$infos = $bdd->query("SELECT * FROM items WHERE Quantite != 0");
				$titre = "Toutes les catégories";
			}
		}
	}
?>
<!DOCTYPE html>
<html>
<head>
	<title><?php echo $titre; ?></title>
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
	</script>
	<style type="text/css">
		.doublepad {
			box-shadow: 1px 1px 4px rgba(0, 0, 0, 0.4);
		   	border:1px solid #8b919c;
			}
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

<div id="container">
	<div class="section">
		<br>
		<a href="categories.php?type=All"><input type = "submit" value = "Toutes les catégories"/></a>
		<a href="categories.php?type=Livre"><input type = "submit" value = "Livre"/></a>
		<a href="categories.php?type=Musique"><input type = "submit" value = "Musique"/></a>
		<a href="categories.php?type=Vetement"><input type = "submit" value = "Vetement"/></a>
		<a href="categories.php?type=Loisir"><input type = "submit" value = "Loisir & Sport"/></a>
		<br><br><br><br>

			<?php
			//Columns must be a factor of 12 (1,2,3,4,6,12)
			$nbCols = 3;
			$rowCount = 0;
			$largeurCol = 12 / $nbCols;
			?>
			<div class="container">
			<div class="row">
				
				<?php
				while($infositem = $infos->fetch()) 
				{
					?>
					<div class="col-md-<?php echo $largeurCol; ?>">
						<div align="center">
							<a href="item.php?id=<?php echo $infositem['ID']; ?>"><img class="doublepad" src="articles/<?php echo $infositem['Photo']?>" height="300" ></a>
							<div class="row">
								<div class="col-md-6">
									<h6><?php echo $infositem['NomItem']; ?></h6>
								</div>
								<div class="col-md-6">
									<h6> <?php echo $infositem['Prix']."€"?></h6>
								</div>
							</div>
							<?php 
							if (isset($_SESSION['id']) AND $_SESSION['type'] != "Acheteur")
							{
								echo "<div class=\"row\">";
								if (($_SESSION['type'] == "ADMINISTRATEUR") OR ($_SESSION['type'] == "VENDEUR" AND $infositem['IDVendeur'] == $_SESSION['id']))
								{
								?>
									<div class="col-md-2"></div>
									<div class="col-md-8"><a onclick="return confirm('Supprimer l\'article <?php echo $infositem['NomItem']; ?> ?');" href="suppitem.php?id=<?php echo $infositem['ID']; ?>"><p class="text-danger font-weight-bold">Supprimer l'article</p></a></div>
									<div class="col-md-2"></div>

								<?php
								}
								echo "</div>";
							}
							?>
							 
						</div>
					</div>
					<?php
					$rowCount++;
					if($rowCount % $nbCols == 0) { echo '</div><div class="row">'; }
				}?>
			</div>
		</div>
	</div>
</div>
	
	<p>
		<a href="accueil.php">Retour</a> à la page d'accueil.
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

<?php
} // fin du premier if
else
{
	header("Location: categories.php?type=All");
}
?>