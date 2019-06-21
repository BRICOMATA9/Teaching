<?php
session_start();

$bdd = new PDO('mysql:host=localhost;dbname=ece_amazon', 'root', '');

$num   = isset($_POST["num"])?$_POST["num"] : "";
$nom   = isset($_POST["nom"])?$_POST["nom"] : "";
$datexpi = isset($_POST["datexpi"])?$_POST["datexpi"] : "";
$code = isset($_POST["code"])?$_POST["code"] : "";


if (isset($_POST["payer"]))
{

}


if (isset($_SESSION['id']))
{

?>
<!DOCTYPE html>
<html>
<head>
	<title>Moyen de paiement</title>
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
		#showform { display: block; }
		#hideform { display: none; }
	</style>
	</script>
</head>
<body>
	 <nav class="navbar navbar-expand-md">      
		<a href = "accueil.php"><img class="Eceamazon" src="images/logo.jpg" width="80" height="80"></a>
		<div class="collapse navbar-collapse" id="main-navigation">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" href="categories.php">Nos 4 Catégories</a></li>             
				<li class="nav-item"><a class="nav-link" href="venteflash.php">Ventes flash</a></li>             
				<li class="nav-item"><a class="nav-link" href="vente.php">Vendre</a></li>      
				<li class="nav-item"><a class="nav-link" href="profil.php?id=<?php echo $_SESSION['id'] ?>">Mon compte</a></li>  
				<li class="nav-item"><a class="nav-link" href = "moyenpaiement.php"><img  width="50" height="50" src="images/store.png"></a>
				</li>
			</ul>
		</div>
	</nav>

	<div id="section">
	<h2>Moyen de paiement</h2>
	<form id="<?php if ($cree == 1) { echo "hideform";} else { echo "shoform";} ?>" action="" method="post"> 
	<table>
		<tr>

			<td>Veuillez compléter ces informations pour procéder au paiement : </td>

		</tr>
		<tr>
                <td>Type de carte de paiement : </td>
                <td><select name = "type">
                        <option value ="VISA">VISA</option>
                        <option value ="MasterCard">MasterCard</option>
                        <option value ="AmericanExpress">AmericanExpress</option>
                        <option value ="PayPal">Paypal</option>
                    </select>
                </td>
            </tr>

	   <tr>    
	 	<td>Numéro de la carte :</td>   
	  <td><input type="number" name="num" placeholder = "Numéro" value="<?php echo "$num" ?>" /></td>  
	  <td>
					<?php 
						if(empty($num) && isset($_POST["payer"])) { echo "Veuillez remplir le champ 'Numéro'. <br>"; }
						 
					?>
				</td>           
	   </tr>  

	    <tr>    
	   	<td>Nom affiché sur la carte :</td>   
	      <td><input type="text" name="nom" placeholder = "Nom" value="<?php echo "$nom" ?>" /></td>  
	      <td>
					<?php 
						if(empty($nom) && isset($_POST["payer"])) { echo "Veuillez remplir le champ 'Nom affiché sur la carte'. <br>"; }
						 
					?>
				</td> 
	       
	      </tr>  

	      <tr>    
	   	<td>Date d'expiration :</td>   
	      <td><input type="date" name="dateexpi" placeholder = "Date expiration" value="<?php echo "$dateexpi" ?>" /></td> 
	       <td>
					<?php 
						if(empty($dateexpi) && isset($_POST["payer"])) { echo "Veuillez remplir le champ 'Date expiration'. <br>"; }
						 
					?>
				</td>  
	      </tr> 

	       <tr>    
	   	<td>Code de sécurité :</td>   
	      <td><input type="text" name="code" placeholder = "Code" value="<?php echo "$code" ?>" /></td>  
	       <td>
					<?php 
						if(empty($code) && isset($_POST["payer"])) { echo "Veuillez remplir le champ 'Code'. <br>"; }
						 
					?>
				</td>  
	      </tr> 


	      <tr>
				<td>   
				<input type="submit" name = "payer" value="Payer">
				</td>
				
			</tr>
			
</table>
</form>

	<p>
		<a href="accueil.php"><input type = "submit" value = "Accueil"/></a>
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
}
else
{
	header("Location: connexionpayer.php");
}
?>