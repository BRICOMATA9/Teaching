

	<!-- Pour la navbar à remettre partout presque --> 
	
	<!-- Pour l'icone --> 
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">


	<!-- Le bootstrap --> 
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>


	<link rel="stylesheet" type="text/css" href="jolie.css">

	


	<!-- Pour voir si c'est un client ou non --> 
	<?php 
	  $_SESSION["email"] =  isset($_SESSION["email"])? $_SESSION["email"] : "";
	  $tableauClient = array();
	  $tableauCouple = array();
	  $tableauCate = array();




	  $database= "projetweb";
	  $db_handle = mysqli_connect('localhost', 'root', '');
	  $db_found = mysqli_select_db($db_handle, $database);

	   if($db_found)
	  {
	    $resultClient = mysqli_query($db_handle, "SELECT email_client FROM client ");  
	    $resultCouple = mysqli_query($db_handle, "SELECT DISTINCT `categorie_item`, `sous_categorie` from item ");
	    $resultCate = mysqli_query($db_handle, "SELECT DISTINCT `categorie_item` from item ");

	  }
	  else 
	  {
	    echo "Database not found";
	  }

	  while ($rowClient = mysqli_fetch_array($resultClient, MYSQLI_ASSOC))
	  {
	       $tableauClient[] = $rowClient;
	  }
	  while ($rowCouple = mysqli_fetch_array($resultCouple, MYSQLI_ASSOC))
	  {
	       $tableauCouple[] = $rowCouple;
	  }
	  while ($rowCate = mysqli_fetch_array($resultCate, MYSQLI_ASSOC))
	  {
	       $tableauCate[] = $rowCate;
	  }

	?>

	<!-- Pour le navbar login --> 
	<link rel="stylesheet" type="text/css" href="navbarLogin.css">

		<nav class="navbar navbar-expand-lg navbar-dark bg-dark">

	  		<a class="navbar-brand" href="menu_principal.php"> <h2> ECE Amazon </h2> </a>



		  	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		    	<ul class="navbar-nav mr-auto">
		    	
		      		<div class="nav-item dropdown">

		        			<a class="btn btn-secondary btn-lg dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true"> Catégorie </a>
		       
		       			<!-- Pour le dropdown -->
		       	 		<ul class="dropdown-menu multi-level" role="menu" aria-labelledby="dropdownMenu">
		          	
							<!-- Permet de créer le dropdown en fonction de la BDD --> 
		       	 			<?php for($i=0;$i< count($tableauCate) ;$i++) : ?>
		          			
			          			<li class="dropdown-submenu">
			          				<?php if ($tableauCate[$i]['categorie_item'] != null) { ?> 
				          				<a class="dropdown-item" href="categorieShow.php?categorie=<?php echo $tableauCate[$i]['categorie_item']; ?>&sous=none"> 		
				          					<?php echo $tableauCate[$i]['categorie_item']; ?>
				          				</a>

				          				
										<?php for($j=0;$j< count($tableauCouple) ;$j++) : ?>
					          					<!-- Si le couple possèdent une ss catégorie --> 
					          			<ul class="dropdown-submenu"> 
					          				<?php if ( $tableauCouple[$j]['categorie_item'] == $tableauCate[$i]['categorie_item']  &&  $tableauCouple[$j]['sous_categorie'] != null) { ?>
					      						<!-- Affichage des ss catégorie des catégorie --> 
					          					<li> 
					          						<a class="dropdown-item" href="categorieShow.php?categorie=<?php echo $tableauCate[$i]['categorie_item']; ?>&sous=<?php echo $tableauCouple[$j]['sous_categorie']; ?>">
					          					 		<?php echo $tableauCouple[$j]['sous_categorie']; ?>
					          					 	</a> 
					          					</li> 
					          				 
					          				<?php } ?>
					          			</ul>
					          			<?php endfor; ?> 
					          		<?php } ?>
					          		<!-- Pour diviser les différentes catégories --> 
			          			<div class="dropdown-divider"></div> 
					          	</li>
				          	
			          		<?php endfor; ?>
			          					
		        		</ul>
		      		</div>
		      		<div class="nav-item" > 
		      			<a href="categorieShow.php?categorie=Solde&sous=none">
		      				<img style="border-radius: 10px;" src="https://img.argentdubeurre.com/content/6749/feelunique-ventes-flash.jpg" height="50" > 
		      			</a>
		      		</div>


		    	</ul>

		    	
		    	<form class="form-inline my-2 my-lg-0" method="post" action="">
		      
		      		<input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" name="recherche">
		      		<input class="btn btn-outline-success my-2 my-sm-0" type="submit" name="search" value="Search"></input>

		      		<?php 

		      		$check =false; //Variable qui permet de ne pas passer 1 fois.
		      		for($i=0;$i< count($tableauClient) ;$i++)
		      		{
		      			if ( $_SESSION['email'] == $tableauClient[$i]['email_client'] )
		      			{
		      				$check =true;
		      				
		      			}
		      		}

		      		if ( $check == true )
		      		{
		      			echo '<a class="nav-link" href="panier.php"> <i class="fas fa-shopping-basket fa-3x"></i> </a>';
		      				echo '	<div class="btn-group">

						      			<button class="btn btn-outline-success my-2 my-sm-0" >
									   		<a class="nav-link" href="monprofile.php" >  Mon profil </a>
				 						</button>

						 				<button class="btn btn-outline-success my-2 my-sm-0" >
									   		<a class="nav-link" href="deconnexion.php" > Deconnexion </a>
				 						</button>

						 			</div>'; 
		      		}
		      		else
		      		{
		      			echo '<a class="nav-link" disabled="disabled"> <i class="fas fa-shopping-basket fa-3x"></i> </a>';
							    echo '<button class="btn btn-outline-success my-2 my-sm-0" >
							   				<a class="nav-link" href="connexion.php" >  Connexion </a>
		 							  </button>'; 
		      		}

		      		?>	
		    	</form>
		  	</div>
		</nav>
		