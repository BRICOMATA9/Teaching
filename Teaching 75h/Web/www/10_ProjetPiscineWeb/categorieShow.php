<?php session_start();


$categorie = $_GET["categorie"]; 
$ss_cate = $_GET["sous"]; 

//Recupere la catégorie de l'objet 


?> 
<?php require "navbar.php"?> 

<!DOCTYPE html>
<html>
<head>
	<title> ECE amazon </title>
	
	<!-- Pour le Bootstrap -->
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

    <link rel="stylesheet" type="text/css" href="jolie.css">
    <!-- https://www.php.net/manual/fr/function.require.php --> 
	

	<!--Partie sql --> 
	<?php 

	  $tableautout = array();

	  $database= "projetweb";
	  $db_handle = mysqli_connect('localhost', 'root', '');
	  $db_found = mysqli_select_db($db_handle, $database);

	  
	  if($db_found)
	  { 
	  	
		
		
		if ( $ss_cate != "none" )
		{
			
			$result = mysqli_query($db_handle, 'SELECT photos_item, nom_item, id_item, prix_item FROM item WHERE `categorie_item` = "'.$categorie.'" AND `sous_categorie` = "'.$ss_cate.'" '); 
		}
		//Si c'est les soldes on prend les articles qui se sont le mieux vendus pour les afficher 
		else if ( $categorie == 'Solde' )
		{
			$result = mysqli_query($db_handle, 'SELECT * FROM `item` WHERE`categorie_item` = "Livre" ORDER BY `item`.`stock_item` ASC'); 
			$resultChanson = mysqli_query($db_handle, 'SELECT * FROM `item` WHERE`categorie_item` = "Chanson" ORDER BY `item`.`stock_item` ASC'); 
			$resultSport = mysqli_query($db_handle, 'SELECT * FROM `item` WHERE`categorie_item` = "Sport_Loisir" ORDER BY `item`.`stock_item` ASC'); 
			$resultVetement = mysqli_query($db_handle, 'SELECT * FROM `item` WHERE`categorie_item` = "Vetement" ORDER BY `item`.`stock_item` ASC');

			$tableauChanson = array();
			$tableauSport = array();
			$tableauVetement = array();

		}
		else if (isset($_POST['search'])) 
        {
        	$recherche=isset($_POST['recherche'])? $_POST['recherche']: "";
		    if($db_found)
	 		{
	    		$result = mysqli_query($db_handle, "SELECT photos_item, nom_item, id_item, prix_item FROM item WHERE nom_item LIKE '$recherche%'");  
	  		}
	  		else 
	 		{
	    		echo "Database not found";
	  		}
	  	}
		else
		{   
	       $result = mysqli_query($db_handle, 'SELECT photos_item, nom_item, id_item, prix_item FROM item WHERE `categorie_item` = "'.$categorie.'" ');
	    }
	  }
	  else 
	  {
	    echo "Database not found";
	  }
	  while ($row = mysqli_fetch_array($result, MYSQLI_ASSOC))
	  {
	       $tableautout[] = $row;
	  }
	  if ( $categorie == 'Solde')
	  {
		  while ($row = mysqli_fetch_array($result, MYSQLI_ASSOC))
		  {
		      $tableautout[] = $row;
		  }
		  while ($row = mysqli_fetch_array($result, MYSQLI_ASSOC))
		  {
		      $tableautout[] = $row;
		  }
		 	while ($row = mysqli_fetch_array($result, MYSQLI_ASSOC))
		  {
		      $tableautout[] = $row;
		  }
	  }

	

	?> 

</head>

<body>
	<br>
		<div>
			<center>  <h1 style="background-image:linear-gradient(to right, purple, lightblue); color: white; "> <?php echo $categorie ?>  </h1> </center>
		</div>
		<br>
		<div id="carousel">

	  		<div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
	     		 <ol class="carousel-indicators">
	        		<li  data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
	       		    <li  data-target="#carouselExampleIndicators" data-slide-to="1"></li>
	        		<li  data-target="#carouselExampleIndicators" data-slide-to="2"></li>
	      		 </ol>
	    
		    	<div class="carousel-inner">
		      
			        <?php  // livres carousel 
				        if ( $categorie == 'Livre')
				        {
				        	echo '

				        	 <div class="carousel-item active"> 

				      		<!-- https://pixabay.com/fr/photos/animaux-fantasy-composer-livres-2739386/ -->
					          <img class="d-block w-100" src="images/Livres.jpg" alt="First slide">

					          	<div class="carousel-caption d-none d-md-block">
			    					<h2 id="surlignage"> Un livre = un aventure  </h2>
			    					<p  id="surlignage"> Résistrez vous aux aventures qui vous tendent les bras ? </p>
			  					</div>
					        </div>

					        <div class="carousel-item">
					        
					          <img class="d-block w-100" src="images/Livres2.jpg" alt="Second slide"> 
				        		<!--  https://wall.alphacoders.com/big.php?i=394862&lang=French --> 
					      	
					          	<div class="carousel-caption d-none d-md-block">

			    					<h3 id="surlignage"> Les livres ça pique et peut couper ! </h3>
			    					<p id="surlignage"> Découvrez nos derniers titres Horrifique !  </p>
			  					</div>
					        </div>
					   		
					        <div class="carousel-item">
				      		<!-- https://imgur.com/gallery/Su5sb --> 
					          <img class="d-block w-100" src="images/Livres3.jpg" alt="Third slide">
					          <div class="carousel-caption d-none d-md-block">
			    					<h3 id="surlignage"> Vous le reconnaissez ? </h3>
			    					<p  id="surlignage"> LoveCraft est à l honneur cette semaine venez vite ! </p>
			  					</div>
					        </div>

					     
				   
				    	</div>';
				    	} 

				    	//  Sports & Loisirs  
				    	else if ( $categorie == 'Sport_Loisir')
				        {

				    		echo '

				    		 <div class="carousel-item active"> 

				      			<!-- https://pixabay.com/fr/photos/animaux-fantasy-composer-livres-2739386/ -->
					          	<img class="d-block w-100" src="images/runningF2.jpg" alt="First slide">

					          	<div class="carousel-caption d-none d-md-block">
			    					<h2 id="surlignage"> Courez ! Vivez ! Gagnez !  </h2>
			    					<p  id="surlignage"> Découvrez les chaussure de running hautes performances ! </p>
			  					</div>
					        </div>

					        <div class="carousel-item">
				      		<!-- https://www.goodfon.com/download/situacii-muzhchina-paren-sport/1920x1080/ --> 
					          <img class="d-block w-100" src="images/Sport2.jpg" alt="Third slide">
					          <div class="carousel-caption d-none d-md-block">
			    					<h3 id="surlignage"> Toujours plus haut ! </h3>
			    					<p  id="surlignage"> Promotion choc ! Bonnes affaires !  </p>
			  					</div>
					        </div>

					        <!-- https://pixabay.com/fr/photos/en-cours-d-ex%C3%A9cution-sprint-498257/ --> 
					        <div class="carousel-item" >
					          <img class="d-block w-100" src="images/Sport1.jpg" alt="Fourth slide">
					          <div class="carousel-caption d-none d-md-block">
			    					<h3 id="surlignage"> Sportif et connecté sont les maitres mots de la nouvelle génération !  </h3>
			    					<p  id="surlignage"> Motivation !  </p>
			  					</div>
					        </div>
				   
				    		</div>';
				    	}

				    	//  Musique  
				    	else if ( $categorie == 'Chanson')
				        {

				    		echo '
				    		<div class="carousel-item active"> 

					          	<img class="d-block w-100" src="images/Musique.jpg" alt="First slide">

					          	<div class="carousel-caption d-none d-md-block">
			    					<h2 id="surlignage"> Que la musique vous emporte !  </h2>
			    					<p  id="surlignage"> Vynile et Cd en vente à prix minis koeur </p>
			  					</div>
					        </div>

					        <div class="carousel-item">
				      		<!-- all credit to johnny Halydays https://www.pinterest.es/pin/456271005990532586/ --> 
					          <img class="d-block w-100" src="images/johny.jpg" alt="Second slide">
					          <div class="carousel-caption d-none d-md-block">
			    					<h3 id="surlignage"> Toujours dans nos coeurs ! </h3>
			    					<p  id="surlignage"> Moins Trente pourcent sur tout les articles Johnny!  </p>
			  					</div>
					        </div>

					        <!-- https://www.hdwallpaper.nu/daft-punk-wallpapers/--> 
					        <div class="carousel-item" >
					          <img class="d-block w-100" src="images/classique.jpg" alt="Third slide">
					          <div class="carousel-caption d-none d-md-block">
			    					<h3 id="surlignage"> Que la musique nous emporte !  </h3>
			    					<p  id="surlignage"> BOUM BOUM BOUM !   </p>
			  					</div>
					        </div>
				   
				    		</div>';

				    	}
				    	//  vetement  
				    	else if ( $categorie == 'Vetement')
				        {

				    		echo '
				    		<div class="carousel-item active"> 

				      			<!-- https://pixabay.com/fr/photos/animaux-fantasy-composer-livres-2739386/ -->
					          	<img class="d-block w-100" src="images/vetementsFV2.jpg" alt="First slide">

					          	<div class="carousel-caption d-none d-md-block">
			    					<h2 id="surlignage"> Epanouissez vous  </h2>
			    					<p  id="surlignage"> Nouvelles promos sur les haches de guerre !!  </p>
			  					</div>
					        </div>

					        <div class="carousel-item">
				      		<!-- http://www.bianoti.com/fonds-decran-femme-magnifique.html --> 
					          <img class="d-block w-100" src="images/Femme1.jpg" alt="Second slide">
					          <div class="carousel-caption d-none d-md-block">
			    					<h3 id="surlignage"> Venez comme vous êtes ! </h3>
			    					<p  id="surlignage"> Le deuxième T-shirt acheté le troisieme offert  </p>
			  					</div>
					        </div>

					        <div class="carousel-item">
					          <img class="d-block w-100" src="images/vetementsH2.jpg" alt="Third slide">
					          <div class="carousel-caption d-none d-md-block">
			    					<h3 id="surlignage">Comme le dit si bien McDonalds: Venez comme vous êtes ! </h3>
			    					<p  id="surlignage"> Ventes Flash sur les moumoutes à poil ras koeur </p>
			  					</div>
					        </div>
				   
				    		</div>';

				    	}
				    	else if ( $categorie == 'Solde')
				    	{
				    		echo '
				    		<div class="carousel-item active"> 

				      			<!-- https://www.ilovetablette.com/soldes-hiver-2016-notre-selection-de-tablettes-a-petit-prix-68393/ -->
					          	<img class="d-block w-100" src="images/Solde.jpg" alt="First slide">

					          	<div class="carousel-caption d-none d-md-block">
			    					<h2 id="surlignage"> Profitez en !!!   </h2>
			    					<p  id="surlignage"> Il n y en aura pas pour tout le monde !   </p>
			  					</div>
					        </div>

					        <div class="carousel-item"> 

				      			<!-- https://www.ilovetablette.com/soldes-hiver-2016-notre-selection-de-tablettes-a-petit-prix-68393/ -->
					          	<img class="d-block w-100" src="images/Solde2.jpg" alt="Second slide">

					          	<div class="carousel-caption d-none d-md-block">
			    					<h2 id="surlignage">  1..2...3.... Partez !!  </h2>
			    					<p  id="surlignage"> Immanquable vous il y en a pour tout les gouts !!!   </p>
			  					</div>
					        </div>


					        <div class="carousel-item"> 

				      			<!-- https://www.kanpai.fr/societe-japonaise/shiba-inu-star-chiens-japonais -->
					          	<img class="d-block w-100" src="images/Solde3.jpg" alt="Third slide">

					          	<div class="carousel-caption d-none d-md-block">
			    					<h2 id="surlignage">  Maintenant que vous l avez vue achetez </h2>
			    					<p  id="surlignage"> Parce que c est quand même très mignon il faut craquer pour ses accessoires  </p>
			  					</div>
					        </div>

					        '; 
				    	}
		    		 
		    		?>
	   
		   		<!-- Pour le bouton prev --> 
			    <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
			      <span class="carousel-control-prev-icon" aria-hidden="true"></span>
			      <span class="sr-only">Previous</span>
			    </a>
		   		
		   		<!-- Pour le bouton next --> 
			    <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
			      <span class="carousel-control-next-icon" aria-hidden="true"></span>
			      <span class="sr-only">Next</span>
			    </a>

	  		</div>
	  	
	</div>

	<!-- https://ludovicscribe.fr/blog/galerie-images-bootstrap --> 
	<div id="objet" >
		<br>
		<br>

		<!-- Limiter les le défilement à 3 -->  
		<!--  Pour afficher tout les objets --> 
		<?php
		if ( $categorie == 'Solde')
		{ ?> 

			<div style="border-radius: 10px; background-color: rgba(0, 0, 0, 0.2) ">
				<br>
				<p> <h1 style="font-family: serif; font-style: normal; font-weight: 500;  "> <center> Les meilleurs de nos éditions </center></h1> </p>
				<?php
					for($i=0;$i< count($tableautout) ;$i++) : 
		              require "rowObjet.php"; 
		         	endfor;
		         ?> 
		         <br>
	     	</div>

	          
		<?php }  
		else if( count($tableautout) != 0 ) {
			 for($i=0;$i< count($tableautout) ;$i++) : 
	              require "rowObjet.php"; 
	         endfor; 
	     }
	     else 
	     {echo' 
	    
	     	<h3> <center> <strong> Oups ! aucun article ne correspond mais voici un canard à la place </strong> </center> </h3>
	     	<br>
	     	<div class="col-sm-12 col-md-12 col-lg-12 "> 
	     		<center> <img src="images/duck.jpg" class="img-thumbnail" > </center>
	     	</div>' ;
	     	 
	     }
        ?>


            </div>
        </div>
       
		<br>
		<br>
		<br>
		<br>
	</div>

	<!-- source TP d'info -->
	<footer class="page-footer">
		<div class="container">
			<div class="row">
		
				<div class="col-lg-8 col-md-8 col-sm-12">
					<h6 class="text-uppercase font-weight-bold"> Information additionnelle </h6>
					<p>
						Ce site a été conçu dans le cadre du projet piscine 2019. Il a été conçu par les enseignants: Hina Manolo, JP Segado, Elisabeth Rendler et toute l’équipe du projet « piscine » de web dynamique. Que la force soit avec nous et bonne nage !! *bloubloublou*
					</p>

					<p>
						Une piscine est un bassin artificiel, étanche, rempli d'eau et dont les dimensions permettent à un être humain de s'y plonger au moins partiellement. Une piscine se différencie d'une cuve ou d'une baignade par ses équipements de filtration (pompe, filtre...). Il existe différents types de piscine dont les caractéristiques varient en fonction de leurs destinations  et de leur usage.
					</p>
				</div>

				<div class="col-lg-4 col-md-4 col-sm-12">
					<h6 class="text-uppercase font-weightbold">Contact</h6>
					<p>
						37, quai de Grenelle, 75015 Paris, France <br>
						info@webDynamique.ece.fr <br>
						+33 01 02 03 04 05 <br>
						+33 01 03 02 05 04
					</p>
				</div>

			</div>
	
		<div class="footer-copyright text-center">&copy; 2019 Copyright | Droit
			d'auteur: webDynamique.ece.fr</div>
	</footer>
</body>
</html>


