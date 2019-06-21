

	<!-- Pour la navbar à remettre partout presque --> 
	
	<!-- Pour l'icone --> 
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">


	<!-- Le bootstrap --> 
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>


	<link rel="stylesheet" type="text/css" href="jolie.css">

	


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
		          	

		          			<li class="dropdown-submenu">
		          				<a class="dropdown-item" href="#"> Livres </a>
		          				<ul class="dropdown-menu">
		          							<li> <a class="dropdown-item" href="#"> Educatif </a> </li>
		          							<li> <a class="dropdown-item" href="#"> BD/Manga </a></li>
							                <li> <a class="dropdown-item" href="#"> Roman    </a></li>
							    </ul> 
							</li>

							<!-- Pour diviser les différentes catégories --> 
		          			<div class="dropdown-divider"></div>


		          			<li class="dropdown-submenu">
		          				<a class="dropdown-item" href="#"> Vêtements </a>
		          				<ul class="dropdown-menu">
		          							<li> <a class="dropdown-item" href="#"> Lingerie </a> </li>
		          							<li> <a class="dropdown-item" href="#"> Jogging </a></li>
							                <li> <a class="dropdown-item" href="#"> Jean    </a></li>
							    </ul>
		          			</li>

		          			<!-- Pour diviser les différentes catégories --> 
		          			<div class="dropdown-divider"></div>


		          			<li class="dropdown-submenu">
		          				<a class="dropdown-item" href="#"> Sports & Loisirs </a>
		          				<ul class="dropdown-menu">
		          							<li> <a class="dropdown-item" href="#"> Pêches   </a> </li>
		          							<li> <a class="dropdown-item" href="#"> Volley   </a></li>
							                <li> <a class="dropdown-item" href="#"> Basket    </a></li>
							    </ul>
							</li>

							<!-- Pour diviser les différentes catégories --> 
		          			<div class="dropdown-divider"></div>


		          			<li class="dropdown-submenu">
		          				<a class="dropdown-item" href="#"> Musique </a>
		          				<ul class="dropdown-menu">
		          							<li> <a class="dropdown-item" href="#"> Rock      </a> </li>
		          							<li> <a class="dropdown-item" href="#"> OST Animu </a></li>
							                <li> <a class="dropdown-item" href="#"> Jazz      </a></li>
							    </ul>
		          			</li>


		        		</ul>
		      		</div>

		    	</ul>

		    	
		    	<!-- Tout ce qui se trouve à droite de la nav bar --> 
		    	<form class="form-inline my-2 my-lg-0">
		      
		      		<input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
		      		<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
		            
					<a class="nav-link" disabled="disabled"> <i class="fas fa-shopping-basket fa-3x"></i> </a>
					<button class="btn btn-outline-success my-2 my-sm-0" >
						<a class="nav-link" href="connexion.php" >  Connexion </a>
		 			</button> 

		    	</form>
		  	</div>

		</nav>