<!DOCTYPE html>
<!--
	Auteurs : Clément LARIVIERE	TD10
			  Théo MERCIER		TD04
			  Antoine PAINCHAUX TD01
-->
<html lang="fr">
<?php
session_start();
function subMyString( $contenu, $limite, $separateur = '...' ) {
    if( strlen($contenu) >= $limite ) {
        $contenu = substr( $contenu, 0, $limite );
        $contenu = substr( $contenu, 0, strrpos($contenu, ' ') );
        $contenu .= $separateur;
    }
     
    return $contenu;
}
?>

<main role="main">

<!-- Header -->
<?php include("header.php");?>

<!-- Main jumbotron for a primary marketing message or call to action -->
<div class="jumbotron">
	<div class="container">
		<h1 class="display-3">Historique de vos achats</h1>
	</div>
</div>
			
<div class="container-fluid" id="block_info">
	<?php
	$database = "ece_amazon";
	try
	{
	  $bdd = new PDO('mysql:host=localhost;dbname=ece_amazon;charset=utf8', 'root', 'root');
	}
	catch (Exception $e)
	{
		die('Erreur : ' . $e->getMessage());
	}
		  
	$reponse = $bdd->query('SELECT * FROM ordersHistory WHERE buyer="'.$_SESSION['email'].'"');
	?>
	<table class="table table-hover ">
		<thead class="thead-dark">
			<tr>
				<th scope="col">Nom</th>
				<th scope="col">Prix</th>
				</tr>
		</thead>
		<tbody>
			<?php

			while ($donnees = $reponse->fetch())
				{
					?>
					<tr>
						<td><?php echo subMyString($donnees['productName'], 100);?></td>
						<td><?php echo $donnees['price']; echo "€"?></td>
					</tr>	
					<?php
				}
				$reponse->closeCursor(); // Termine le traitement de la requête
				?>
			</tbody>
		</table>
		<h3><br></h3>
		<p><a class="btn btn-danger btn-lg" href="../mon_compte/deconnexion.php" role="button">Déconnexion &raquo;</a></p>



</div>
</main>

<!-- footer -->
<?php include("footer.php");?>
</html>
