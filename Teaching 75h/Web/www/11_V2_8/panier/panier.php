<!DOCTYPE html>
<!--
	Auteurs : Clément LARIVIERE	TD10
			  Théo MERCIER		TD04
			  Antoine PAINCHAUX TD01
-->
<html lang="fr">

<!--Header-->
<?php include("header.php");?>

<?php session_start(); ?>

<style>

table {
	width: 90%;
	margin-left: 5%;
}
th {
	font-family: monospace;
	width: 50%;
	padding: 5px;
	background-color: #e9ecef;
	background-image: url(sky.jpg);
}
td {
	font-family: sans-serif;
	width: 50%;
	padding: 5px;
	text-align: left;
	background-color: #ffffff;
}
caption {
	font-family: sans-serif;
}
#erreur
{
	color:red;
	margin-left:5%;
	margin-right:5%;
}
#prixTot
{
	text-align: left;
	display: block;
	width: auto;
}
#button_payement
{
	margin-top : 3%;
	margin-left: 10%;
}

</style>

<main role="main">

	<div class="jumbotron">
					<div class="container">
						<h1 class="display-3">Votre Panier</h1>
					</div>
 				</div>

 				<table summary="panier">

 					<tr>
		    			<th>Nom</th>
		    			<th>Quantité</th>
		    			<th>Etat</th>
		    			<th>Prix</th>
		  			</tr>


	<?php

				$database = "ece_amazon";
				$prixTot=0;
				$quantiteProd=0;
				$quantProdu=0;
				$arrayID[]=0;
				$cond=0;
				
				try
				{
				  $bdd = new PDO('mysql:host=localhost;dbname=ece_amazon;charset=utf8', 'root', 'root');
				}
				catch (Exception $e)
				{
					die('Erreur : ' . $e->getMessage());
				}
				
				
				if ($_GET['emailB'] == NULL)
				{
					$adressEmail = $_SESSION['adresseMail'];
				}else
				{
					$adressEmail = $_GET['emailB'];
				}
				
				$reponse = $bdd->query('SELECT * FROM items INNER JOIN cart ON items.id=cart.id_item WHERE emailBuyer="'.$adressEmail.'"');

				while ($donnees = $reponse->fetch())
				{

			  				$quantiteProd=$bdd->query('SELECT COUNT(*) FROM cart WHERE id_item='.$donnees['id']);
			  				//echo $quantiteProd;

			  				while ($don = $quantiteProd->fetch())
			  				{
			  					$quantProdu=$don['COUNT(*)'];
			  				}

				  			foreach($arrayID as $elem)
				  			{
				  				if ($elem == $donnees['id'])
				  				{
				  					$cond=1;
				  				}
				  			}

				  			if ($quantProdu > $donnees['quantity'])
				  			{
				  				$cond=1;
				  				$reqSup = $bdd->prepare('DELETE FROM cart WHERE id_cart='.$donnees['id_cart']);
				  				$reqSup->execute();
				  				?><a id="erreur">Erreur : Le stock du produit est insuffisant. Le produit <?php echo $donnees['name']; ?> n'a pas été ajouté au panier.</a><br><br><?php
				  			}


			  			if($cond==0)
			  			{
							?>
							<tr>
					    	<td><?php echo $donnees['name']; ?></td>
					 		<td><?php echo $quantProdu; ?></td>
						    <td><?php echo $donnees['shape']; ?></td>
						    <td><?php echo $donnees['price']; ?> €</td>
						  	</tr>
							<?php $prixTot = $prixTot + $donnees['price']*$quantProdu; ?>
							<?php $arrayID[]=$donnees['id']; ?>
							<?php
			  			}

						  	
			  		
			  		$cond=0;
				}

				$reponse->closeCursor(); // Termine le traitement de la requête

			?>

		</table>

		<table>
			<tr>
		    	<th id="prixTot">Prix total : <?php echo $prixTot ?> € </th>
		  	</tr>
		</table>


		<form action="payement.php" method="post">
			<p>
				<input type="hidden" name="prixTot" value="$prixTot" />
				<input id="button_payement" type="submit" name="submit" value="Paiement &raquo;" class="btn btn-primary btn-lg"><br>
			</p>
		</form>

</main>

<!--Footer-->
<?php include("footer.php");?>

</html>