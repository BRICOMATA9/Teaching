<!DOCTYPE html>

	<html>

		<head>
			<title>ECEZONE</title>
			<meta charset="utf-8"/>
		    <link href="Accueil_bis.css" rel="stylesheet" type="text/css" />
		</head>

		<body>    

            
			<h1 id="logo">

				 <img src="logo.png" alt="ECEZONE" width="200" height="50"/> 

			</h1> 

			<div id="header">

				<div id="searchbar">

					<h3><span class="text">Un produit en tête ?</span></h3>

					<form action="">
						<input class="champ" type="text" placeholder="Recherche..."/>
						<input class="bouton" type="button" value="Go" />
					</form>

				</div>

				<!--https://openclassrooms.com/forum/sujet/barre-de-recherche-html-css
					https://jsfiddle.net/stefde3/SVHyN/ -->

				<div class="menu">

					<select size="Categorie" onChange="location = this.options[this.selectedIndex].value;"> 

						<option value="Accueil.html">Categorie</option>
						<option value="Livre.php" >Livres</option>
						<option value="Musique.php" >Musique</option>
						<option value="Vetement.php" >Vetement</option>
						<option value="Sport.php" >Sports et Loisirs</option>

					</select>

					<br><br><br>

					<a href="Accueil_Acheteur.html"><img src="accueil.png" alt="Accueil" width="100" height="25"/></a>
					<a href="Connexion.html"><img src="panier.png" alt="Panier" width="100" height="25"/></a>
					<a href="Accueil_bis.html"><img src="deconnexion.png" alt="Deconnexion" width="150" height="25"/></a>
					<a href="#"><img src="admin.png" alt="Admin" width="100" height="25"/></a> 

					<br><br><br>

            </div>
            <div>
            	
				<?php
				//identifier le nom de base de données
				$database = "testzone";
				//connectez-vous dans votre BDD
				//Rappel : votre serveur = localhost | votre login = root | votre mot de pass = '' (rien)
				$db_handle = mysqli_connect('localhost', 'root','');
				$db_found = mysqli_select_db($db_handle, $database);
				//si le BDD existe, faire le traitement
				if ($db_found) {
					$sql = "SELECT * FROM produit WHERE Categorie LIKE 'Vetement'";
					$result = mysqli_query($db_handle, $sql);
					while ($data = mysqli_fetch_assoc($result)) {
						echo'<div id="toto"><b>Nom:</b>'. $data['Nom'] . '<br></div>';
						echo '<div id="toto"><b>Description:</b> ' . $data['Description'] . '<br></div>';
						echo '"<img src="'.$data['Photo'].'"  class ="center">"' ;
						echo '<div id="toto"><b>Prix:</b>' . $data['Prix'] . '</br></div>';
							
						}//end while 

					if(isset($_POST['go']) AND $_POST['go']=='Ajouter au panier')
				    {

		            mysqli_query($db_handle, "INSERT INTO panier SELECT id_produit, Photo FROM produit");
		            header('Location: Panier.php');

				    }

				}//end if
				//si le BDD n'existe pas
				else {
					echo "Database not found";
				}//end else
				//fermer la connection
				mysqli_close($db_handle);
				?>

				<form action="Vetement.php" method="POST">

					<input type="submit" value="Ajouter au panier" name="go"/> 
				
				</form>

			</div>
			
         </div>
        </body>
</html>