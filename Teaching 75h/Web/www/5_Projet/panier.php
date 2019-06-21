<?php
session_start();
$bdd = new PDO('mysql:host=localhost;dbname=ece_amazon', 'root', '');

$typecarte = isset($_POST["typecarte"])?$_POST["typecarte"] : "";
$numerocarte = isset($_POST["numerocarte"])?$_POST["numerocarte"] : "";
$nomcarte = isset($_POST["nomcarte"])?$_POST["nomcarte"] : "";
$expirationmois = isset($_POST["expirationmois"])?$_POST["expirationmois"] : "";
$expirationannee = isset($_POST["expirationannee"])?$_POST["expirationannee"] : "";
$cvv = isset($_POST["cvv"])?intval($_POST["cvv"]) : "";
$iduser = 0;

function getInfoItem($iditem, $bdd, $typeInfo)
{
	//echo $iditem."voici l'id";
	$getnomitem = $bdd->prepare("SELECT * FROM items WHERE ID = ?");
	$getnomitem->execute(array($iditem));
	$infoitem = $getnomitem->fetch();
	return $infoitem[$typeInfo];

}

if($_SESSION['type'] != "VENDEUR")
{
	if(isset($_SESSION['id']))
	{
		$iduser = $_SESSION['id'];
	}
	else { $iduser = 0; }

	$reqpanier = $bdd->prepare("SELECT * FROM paniers WHERE IDAcheteur = ?");
	$reqpanier->execute(array($iduser));
	$nbpanier = $reqpanier->rowCount();
	//echo "nb ditem dans le panier : ".$nbpanier;
}

if(isset($_POST['payer']))
{
	if (!empty($numerocarte) AND !empty($nomcarte) AND !empty($cvv))
	{
		echo "tt champs rempli <br>";
		$verifcarte = $bdd->prepare("SELECT * FROM cartes WHERE TypeCarte = ? AND Carte = ? AND CVV = ? AND Titulaire LIKE ? AND ExpMois = ? AND ExpAn = ?");
		$verifcarte->execute(array($typecarte, $numerocarte, $cvv, $nomcarte, $expirationmois, $expirationannee));
		$carteexiste = $verifcarte->rowCount();
		if ($carteexiste == 1)
		{
			echo "la carte existe <br>";
			$deletepanier = $bdd->prepare("DELETE FROM paniers WHERE IDAcheteur = ?");
			$deletepanier->execute(array($iduser));
			//header("Location : endgame.php?id=".$iduser);
		}
		else { echo "mauvaise carte<br>"; }
	}
}


?>
<!DOCTYPE html>
<html>
<head>
	<title>Votre Panier</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
 	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"> 
 	<link rel="stylesheet" type="text/css" href="vente.css">
 	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		 $(document).ready(function(){
		 $('.header').height($(window).height());
		 });

		function checktaille(object) {
		    if (object.value.length > object.max.length)
		     	object.value = object.value.slice(0, object.max.length);
		  	}

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
		<?php
			if (isset($_SESSION['id']) AND $_SESSION['type'] == "VENDEUR")
			{
				echo "Vous n'êtes ni acheteur ni administrateur. Connectez ou inscrivez vous en tant qu'acheteur ou administrateur. <br><br><br>";
				echo "<a href=\"deconnexion.php\"><input type = \"submit\" value = \"Se deconnecter\"/></a> <br><br><br><br><br>";
			}
			else
			{
			?>
				<div class="container">
		    		<?php
			    	if ($nbpanier != 0)
					{
					?>
					<div class="row">
						<div class="col-md-8">
							<?php
							if (!isset($_SESSION['id']))
							{
									echo "ntes pas co, veuillez vous connecter/vous inscrire";
									echo "s'inscrire";?>

									<a href="inscriptionpayer.php"><input type = "submit" value = "S'inscrire"/></a>
									<?php
							}
							else
							{
								if ($carteexiste == 1)
								{
									echo "merci pour cet achat! <br>";
									echo"<a href=\"accueil.php\"><input type = \"submit\" value = \"Acceuil\"/></a>";
								}
								else
								{
								?>
									<form action="" method="post">
								<table>
									<tr>
										<td>Paiement :</td>
									</tr>
									<tr>
						                <td>Type de carte de paiement : </td>
						                <td><select name = "typecarte">
						                        <option value ="1">VISA</option>
						                        <option value ="2">MasterCard</option>
						                        <option value ="3">AmericanExpress</option>
						                        <option value ="4">Paypal</option>
						                    </select>
						                </td>
						            </tr>
								   	<tr>    
								 		<td>Numéro de carte :</td>   
									  	<td><input type="number" oninput="checktaille(this)" name="numerocarte" placeholder="Numéro" max="9999999999999999" value="<?php echo "$numerocarte" ?>" /></td> 
									  	<td>
											<?php 
												if(empty($numerocarte) && isset($_POST["payer"])) { echo "Veuillez remplir le champ 'Numéro de carte'. <br>"; }	 
											?>
										</td>           
								    </tr>  
								    <tr>    
								   		<td>Nom apparaissant sur la carte :</td>
								     	<td><input type="text" name="nomcarte" placeholder="Nom" value="<?php echo "$nomcarte" ?>" /></td>  
								      	<td>
											<?php 
												if(empty($nomcarte) && isset($_POST["payer"])) { echo "Veuillez remplir le champ 'Nom'. <br>"; }
											?>
										</td>   
								    </tr>
								    <tr>    
								   		<td>Date d'expiration :</td>   
								      	<td><select name = "expirationmois">
								      		<?php
								      			for ($i = 0; $i < 12; $i++)
								      			{
								      				echo "<option value=".($i+1).">".($i+1)."</option>";
								      			}
								      		?>
						                </select>
					                    <select name = "expirationannee">
					                    	<?php
								      			for ($i = 0; $i < 12; $i++)
								      			{
								      				echo "<option value=".($i+2019).">".($i+2019) ."</option>";
								      			}
								      		?>
					                    </select></td> 
								    </tr> 
									<tr>    
									   	<td>Code de sécurité :</td>   
									    <td><input oninput="checktaille(this)" type="number" min="1" max="9999" name="cvv" placeholder = "CVV" value="<?php echo "$cvv" ?>" /></td>  
								        <td>
											<?php 
												if(empty($cvv) && isset($_POST["payer"])) { echo "Veuillez remplir le champ 'Code'. <br>"; }
											?>
										</td>  
							        </tr>
							        <tr>
										<td>   
										<input type="submit" name="payer" value="Payer">
										</td>
									</tr>		
								</table>
								</form>

								<?php
								}
								?>
								
								
							<?php
							}
							?>
						</div>
						<div class="col-md-4">
							<ul class="list-group mb-4">
								<?php
								$total=0;
								while ($infospanier = $reqpanier->fetch())
								{
									$total =$total+ getInfoItem($infospanier['IDItem'], $bdd, 'Prix')*$infospanier['Quantite'];
									?>
									<li class="list-group-item">
										<div>
											<img class="rounded doublepad float-right" src="articles/<?php echo getInfoItem($infospanier['IDItem'], $bdd, 'Photo'); ?>" height="115" >
											<h6 class="my-0"><?php echo getInfoItem($infospanier['IDItem'], $bdd, 'NomItem');  ?></h6>
											<small class="text-muted"><?php echo getInfoItem($infospanier['IDItem'], $bdd, 'Description') ?><br></small>
											<small class="text-muted">Quantité : <?php echo $infospanier['Quantite'] ?><br></small>
											<span class = "text-success"><?php echo (getInfoItem($infospanier['IDItem'], $bdd, 'Prix')*$infospanier['Quantite'])."€ (".getInfoItem($infospanier['IDItem'], $bdd, 'Prix'); ?>€)</span><br>
											<?php if (!isset($carteexiste) OR (isset($carteexiste) AND $carteexiste == 0)) { echo "<a href=\"suppitempanier.php?id=".$infospanier['IDItem']."\"><small><button type=\"button\" class=\"btn btn-sm btn-outline-danger\">Supprimer</button></small></a>"; } ?>
											
											
										</div>

										
									</li>
									<?php
								}

								?>
								<li class="list-group-item d-flex justify-content-between">
					              <span>Total</span>
					              <strong><?php echo $total."€"; ?></strong>
					            </li>
							</ul>
						</div>
					</div>
					<?php	
					} // fin du if (panier == 0)
					else
					{
						echo "Votre panier est vide <br><br><br><br><br><br><br><br><br>";
					}
					?>
				</div>
					<?php
					
			}
		?>
	</div>
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
