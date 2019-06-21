<!DOCTYPE html>
<!--
	Auteurs : Clément LARIVIERE	TD10
			  Théo MERCIER		TD04
			  Antoine PAINCHAUX TD01
-->
<html lang="fr">

<!-- Header -->
<?php include("header.php");?>

<?php session_start(); ?>

<style type="text/css">
	#all_blocks
	{
		display : block;
		float : center;
		align-items:center;
	}

	#itemAffbook
	{
		background-color:#e9ecef;
		display : block;
		text-align:left;
		margin:10px;
		padding:5px;
		border: solid grey;
		width: 250px;
		height: auto;
		min-height : 450px;
		float:left;
		p 
		{
			font-size: 80%;
		}
		
	}
	#itemAffmusic
	{
		background-color:#e9ecef;
		display : block;
		text-align:left;
		margin:10px;
		padding:5px;
		border: solid grey;
		width: 250px;
		height: auto;
		min-height : 450px;
		float:left;
		p 
		{
			font-size: 80%;
		}
		
	}
	#itemAffclothing
	{
		background-color:#e9ecef;
		display : block;
		text-align:left;
		margin:10px;
		padding:5px;
		border: solid grey;
		width: 250px;
		height: auto;
		min-height : 450px;
		float:left;
		p 
		{
			font-size: 80%;
		}
	}
	#itemAffsport
	{
		background-color:#e9ecef;
		display : block;
		text-align:left;
		margin:10px;
		padding:5px;
		border: solid grey;
		width: 250px;
		height: auto;
		min-height : 450px;
		float:left;
		p 
		{
			font-size: 80%;
		}
	}

	#block_bouton
	{
		display:block;
		position : absolute;
		bottom : 0; 
		margin:10px;
	}
	#attributs
	{
		font-size: 90%;
	}
	
	footer
	{
		display : block;
	}
	h3
	{
		color:orange;
		text-align: center;
	}
	
</style>

<?php
function subMyString( $contenu, $limite, $separateur = '...' ) {
    if( strlen($contenu) >= $limite ) {
        $contenu = substr( $contenu, 0, $limite );
        $contenu = substr( $contenu, 0, strrpos($contenu, ' ') );
        $contenu .= $separateur;
    }
     
    return $contenu;
}
?>

<body>
	<main role="main">

		<div class="jumbotron">
			<div class="container">
			  <h1 class="display-3">Ventes Flash</h1>
			  <p>Ici, retrouvez le produit le plus vendu pour chaque catégories ! <br>Dans cette e-boutique, nous nous efforçons de vous proposer les meilleurs articles aux meilleurs prix ! </p>
			</div>
		</div>


		<div class="container">

			<div id="all_blocks">
				<?php

		

				try
				{
				  $bddb = new PDO('mysql:host=localhost;dbname=ece_amazon;charset=utf8', 'root', 'root');
				}
				catch (Exception $e)
				{
					die('Erreur : ' . $e->getMessage());
				}

				$requeteBook='SELECT COUNT(s.id_item) as nbVentes ,s.id_item as coucou FROM items i INNER JOIN books b ON i.id=b.id_item INNER JOIN salesHistory s ON b.id_item=s.id_item GROUP BY s.id_item ORDER BY nbVentes desc LIMIT 1';

				$reponseBook = $bddb->query($requeteBook);	

				$idbestSb=0;
				while ($donneesBook = $reponseBook->fetch())
				{

					$idbestSb=$donneesBook['coucou'];

				}

				$requeteBook = 'SELECT * FROM items INNER JOIN books ON items.id=books.id_item WHERE id=' . $idbestSb;

				$reponseBook = $bddb->query($requeteBook);	

				while ($donneesBook = $reponseBook->fetch())
				{
					?>
					<div class="col-md-4" id="itemAffbook">
						<h3> Best-Sellers <br> Livre</h3>
						<p>
							<div id="block_titre" class = "container">
								<h4><?php echo $donneesBook['name']; ?></h4>
							</div>
							<div id="block_principal" class = "container">
								<table>
									<tr>
									<td id="attributs">Prix :</td>
									<td><?php echo $donneesBook['price']; echo "€"?></td>
									</tr>

									<tr>
									<td id="attributs">Auteur :</td>
									<td id="attributs"><?php echo $donneesBook['author']; ?></td>
									</tr>

									<tr>
									<td id="attributs">Etat :</td>
									<td id="attributs"><?php echo $donneesBook['shape']; ?></td>
									</tr>
									
									<tr>
									<td id="attributs"><br></td>
									</tr>

								</table>
								<?php echo subMyString( $donneesBook['description'], 100, '...' ); ?>
							</div>
							<div id="block_bouton" class = "container">
								<a class="btn btn-warning" id="bouton_annonce" href="../Article/pageArticleBook.php?id=<?php echo $donneesBook['id'] ?>" role="button">Voir l'offre &raquo;</a>
							</div>
						</p>
					</div>

				<?php
					}
					$reponseBook->closeCursor(); // Termine le traitement de la requête
				?>

				<?php


				try
				{
				  $bddm = new PDO('mysql:host=localhost;dbname=ece_amazon;charset=utf8', 'root', 'root');
				}
				catch (Exception $e)
				{
					die('Erreur : ' . $e->getMessage());
				}

				$requeteMusic='SELECT COUNT(s.id_item) as nbVentes ,s.id_item as coucou FROM items i INNER JOIN music b ON i.id=b.id_item INNER JOIN salesHistory s ON b.id_item=s.id_item GROUP BY s.id_item ORDER BY nbVentes desc LIMIT 1';

				$reponseMusic = $bddm->query($requeteMusic);	

				$idbestSm=0;
				while ($donneesMusic = $reponseMusic->fetch())
				{

					$idbestSm=$donneesMusic['coucou'];

				}

				$requeteMusic = 'SELECT * FROM items INNER JOIN music ON items.id=music.id_item WHERE id=' . $idbestSm;

				$reponseMusic = $bddm->query($requeteMusic);	

				while ($donneesMusic = $reponseMusic->fetch())
				{
					?>
					<div class="col-md-4" id="itemAffmusic">
						<h3> Best-Sellers Musique</h3>
						<p>
							<div id="block_titre" class = "container">
								<h4><?php echo $donneesMusic['name']; ?></h4>
							</div>
							<div id="block_principal" class = "container">
								<table>
									<tr>
									<td id="attributs">Prix :</td>
									<td><?php echo $donneesMusic['price']; echo "€"?></td>
									</tr>

									<tr>
									<td id="attributs">Artiste :</td>
									<td id="attributs"><?php echo $donneesMusic['artist']; ?></td>
									</tr>

									<tr>
									<td id="attributs">Etat :</td>
									<td id="attributs"><?php echo $donneesMusic['shape']; ?></td>
									</tr>
									
									<tr>
									<td id="attributs"><br></td>
									</tr>

								</table>
								<?php echo subMyString( $donneesMusic['description'], 100, '...' ); ?>
							</div>
							<div id="block_bouton" class = "container">
								<a class="btn btn-warning" id="bouton_annonce" href="../Article/pageArticleMusic.php?id=<?php echo $donneesMusic['id'] ?>" role="button">Voir l'offre &raquo;</a>
							</div>
						</p>
					</div>

				<?php
					}
					$reponseMusic->closeCursor(); // Termine le traitement de la requête
				?>



				<?php


				try
				{
				  $bddv = new PDO('mysql:host=localhost;dbname=ece_amazon;charset=utf8', 'root', 'root');
				}
				catch (Exception $e)
				{
					die('Erreur : ' . $e->getMessage());
				}

				$requeteVet='SELECT COUNT(s.id_item) as nbVentes ,s.id_item as coucou FROM items i INNER JOIN clothing b ON i.id=b.id_item INNER JOIN salesHistory s ON b.id_item=s.id_item GROUP BY s.id_item ORDER BY nbVentes desc LIMIT 1';

				$reponseVet = $bddv->query($requeteVet);	

				$idbestSv=0;
				while ($donneesVet = $reponseVet->fetch())
				{

					$idbestSv=$donneesVet['coucou'];

				}

				$requeteVet = 'SELECT * FROM items INNER JOIN clothing ON items.id=clothing.id_item WHERE id=' . $idbestSv;

				$reponseVet = $bddv->query($requeteVet);	

				while ($donneesVet = $reponseVet->fetch())
				{
					?>
					<div class="col-md-4" id="itemAffclothing">
						<h3> Best-Sellers Vêtement</h3>
						<p>
							<div id="block_titre" class = "container">
								<h4><?php echo subMyString($donneesVet['name'],40,'...'); ?></h4>
							</div>
							<div id="block_principal" class = "container">
								<table>
									<tr>
									<td id="attributs">Prix :</td>
									<td><?php echo $donneesVet['price']; echo "€"?></td>
									</tr>

									<tr>
									<td id="attributs">Type :</td>
									<td id="attributs"><?php echo $donneesVet['type']; ?></td>
									</tr>

									<tr>
									<td id="attributs">Taille :</td>
									<td id="attributs"><?php echo $donneesVet['size']; ?></td>
									</tr>

									<tr>
									<td id="attributs">Etat :</td>
									<td id="attributs"><?php echo $donneesVet['shape']; ?></td>
									</tr>
									
									<tr>
									<td id="attributs"><br></td>
									</tr>

								</table>
								<?php echo subMyString( $donneesVet['description'], 100, '...' ); ?>
							</div>
							<div id="block_bouton" class = "container">
								<a class="btn btn-warning" id="bouton_annonce" href="../Article/pageArticleClothings.php?id=<?php echo $donneesVet['id'] ?>" role="button">Voir l'offre &raquo;</a>
							</div>
						</p>
					</div>

				<?php
					}
					$reponseVet->closeCursor(); // Termine le traitement de la requête
				?>



				<?php


				try
				{
				  $bdds = new PDO('mysql:host=localhost;dbname=ece_amazon;charset=utf8', 'root', 'root');
				}
				catch (Exception $e)
				{
					die('Erreur : ' . $e->getMessage());
				}

				$requeteSport='SELECT COUNT(s.id_item) as nbVentes ,s.id_item as coucou FROM items i INNER JOIN sports_hobbies b ON i.id=b.id_item INNER JOIN salesHistory s ON b.id_item=s.id_item GROUP BY s.id_item ORDER BY nbVentes desc LIMIT 1';

				$reponseSport = $bdds->query($requeteSport);	

				$idbestSs=0;
				while ($donneesSport = $reponseSport->fetch())
				{

					$idbestSs=$donneesSport['coucou'];

				}

				$requeteSport = 'SELECT * FROM items INNER JOIN sports_hobbies ON items.id=sports_hobbies.id_item WHERE id=' . $idbestSs;

				$reponseSport = $bdds->query($requeteSport);	

				while ($donneesSport = $reponseSport->fetch())
				{
					?>
					<div class="col-md-4" id="itemAffsport">
						<h3> Best-Seller Sport & Loisir</h3>
						<p>
							<div id="block_titre" class = "container">
								<h4><?php echo subMyString($donneesSport['name'],40,'...'); ?></h4>
							</div>
							<div id="block_principal" class = "container">
								<table>
									<tr>
									<td id="attributs">Prix :</td>
									<td><?php echo $donneesSport['price']; echo "€"?></td>
									</tr>

									<tr>
									<td id="attributs">Secteur :</td>
									<td id="attributs"><?php echo $donneesSport['type']; ?></td>
									</tr>

									<tr>
									<td id="attributs">Etat :</td>
									<td id="attributs"><?php echo $donneesSport['shape']; ?></td>
									</tr>
									
									<tr>
									<td id="attributs"><br></td>
									</tr>

								</table>
								<?php echo subMyString( $donneesSport['description'], 100, '...' ); ?>
							</div>
							<div id="block_bouton" class = "container">
								<a class="btn btn-warning" id="bouton_annonce" href="../Article/pageArticleSports.php?id=<?php echo $donneesSport['id'] ?>" role="button">Voir l'offre &raquo;</a>
							</div>
						</p>
					</div>

				<?php
					}
					$reponseSport->closeCursor(); // Termine le traitement de la requête
				?>







			</div>

			<hr>
		</div> <!-- /container -->
	</main>
</body>

<!-- Footer -->
<!--<=?php include("footer.php");?>-->

</html>
