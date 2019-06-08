<!DOCTYPE html>
<html lang="fr">
<head>
	<title>Votre Compte</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--====Modification de la taille de l'écaran en fonction de la taille de l'écran===============================================================-->	
	<link rel="icon" type="image/png" href="images/icons/ece.png"/>
<!--Le logo à la barre du titre===================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/iconic/css/material-design-iconic-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="efonts/linearicons-v1.0.0/icon-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/slick/slick.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/MagnificPopup/magnific-popup.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/perfect-scrollbar/perfect-scrollbar.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="css/util.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
<!--===============================================================================================-->
</head>


<body class="animsition">
	
	<!-- Header -->
	<header class="header-v3">
		<!-- le menu dur la largeur de la page avec bootstrap 3 -->
		<div class="container-menu-desktop trans-03">
			<div class="wrap-menu-desktop">
				<nav class="limiter-menu-desktop p-l-45">

					<!-- Logo desktop -->		
					<a href="home-03.php" class="logo">
						<img src="images/icons/logo.png" alt="IMG-LOGO">
					</a>

					<!-- Menu desktop -->
					<div class="menu-desktop">
						<ul class="main-menu">
							<li>
								<a href="home-03.php">Acceuil</a>
							</li>

							<li>
								<a href="#">Magasin</a>
								<ul class="sub-menu">
									<li><a href='livre.php'>Livres</a></li>
									<li><a href='music.php'>Musiques</a></li>
									<li><a href='#'>Vêtements</a>
										<ul class="sub-menu">
											<li><a href='vfemme.php'>Femmes</a></li>
											<li><a href='vhommes.php'>Hommes</a></li>
										</ul>
									</li>
									<li><a href='sport.php'>Sport & Loisir</a></li>
								</ul>
							</li>

							<li class="label1" data-label1="hot">
								<a href="flash.php">Ventes Flash</a>
							</li>

							<li>
								<a href="about.html">A propos</a>
							</li>

							<li>
								<a href="#">Mon Compte</a>
								<ul class="sub-menu">
									<li><a href='achteur.html'>Achteur</a></li>
									<li><a href='admi.html'>Administateur</a></li>
									<li><a href='vendeur.html'>Vendeur</a></li>
								</ul>
							</li>

							<li>
								<a href="panier.php">Panier</a>
							</li>

						</ul>
					</div>	

					<!-- Icon header -->
					<div class="wrap-icon-header flex-w flex-r-m h-full">			
						<div class="flex-c-m h-full p-lr-19">
							<div class="icon-header-item cl0 hov-cl1 trans-04 p-lr-11 js-show-sidebar">
								<i class="zmdi zmdi-menu"></i>
							</div>
						</div>
					</div>
				</nav>
			</div>	
		</div>
	</header>

		<!-- Sidebar -->
	<aside class="wrap-sidebar js-sidebar">
		<div class="s-full js-hide-sidebar"></div>

		<div class="sidebar flex-col-l p-t-22 p-b-25">
			<div class="flex-r w-full p-b-30 p-r-27">
				<div class="fs-35 lh-10 cl2 p-lr-5 pointer hov-cl1 trans-04 js-hide-sidebar">
					<i class="zmdi zmdi-close"></i>
				</div>
			</div>

			<div class="sidebar-content flex-w w-full p-lr-65 js-pscroll">
				<ul class="sidebar-link w-full">
					<li class="p-b-13">
						<a href="home-03.php" class="stext-102 cl2 hov-cl1 trans-04">
							Accuiel
						</a>
					</li>

					<li class="p-b-13">
						<a href="#" class="stext-102 cl2 hov-cl1 trans-04">
							Coup de Coeur
						</a>
					</li>

					<li class="p-b-13">
						<a href="#" class="stext-102 cl2 hov-cl1 trans-04">
							Mon compte
						</a>
					</li>

					<li class="p-b-13">
						<a href="#" class="stext-102 cl2 hov-cl1 trans-04">
							Rembouresement
						</a>
					</li>

					<li class="p-b-13">
						<a href="#" class="stext-102 cl2 hov-cl1 trans-04">
							Aide & FAQs
						</a>
					</li>
				</ul>

				<div class="sidebar-gallery w-full p-tb-30">
					<span class="mtext-101 cl5">
						@ ECEAmazon
					</span>

					<div class="flex-w flex-sb p-t-36 gallery-lb">
						<!-- item gallery sidebar -->
						<div class="wrap-item-gallery m-b-10">
							<a class="item-gallery bg-img1" href="images/book1.jpg"
							data-lightbox="gallery"  
							style="background-image: url('images/book1.jpg');"></a>
						</div>

						<!-- item gallery sidebar -->
						<div class="wrap-item-gallery m-b-10">
							<a class="item-gallery bg-img1" href="images/book2.jpg"
							data-lightbox="gallery" 
							style="background-image: url('images/book2.jpg');"></a>
						</div>

						<!-- item gallery sidebar -->
						<div class="wrap-item-gallery m-b-10">
							<a class="item-gallery bg-img1" href="images/book3.jpg"
							data-lightbox="gallery" 
							style="background-image: url('images/book3.jpg');"></a>
						</div>

						<!-- item gallery sidebar -->
						<div class="wrap-item-gallery m-b-10">
							<a class="item-gallery bg-img1" href="images/music1.jpg" data-lightbox="gallery" 
							style="background-image: url('images/music1.jpg');"></a>
						</div>

						<!-- item gallery sidebar -->
						<div class="wrap-item-gallery m-b-10">
							<a class="item-gallery bg-img1" href="images/louis.jpg" data-lightbox="gallery" 
							style="background-image: url('images/louis.jpg');"></a>
						</div>

						<!-- item gallery sidebar -->
						<div class="wrap-item-gallery m-b-10">
							<a class="item-gallery bg-img1" href="images/fille.jpg" data-lightbox="gallery" 
							style="background-image: url('images/fille.jpg');"></a>
						</div>

						<!-- item gallery sidebar -->
						<div class="wrap-item-gallery m-b-10">
							<a class="item-gallery bg-img1" href="images/sport2.jpg" data-lightbox="gallery" 
							style="background-image: url('images/sport2.jpg');"></a>
						</div>

						<!-- item gallery sidebar -->
						<div class="wrap-item-gallery m-b-10">
							<a class="item-gallery bg-img1" href="images/muscu.jpg" data-lightbox="gallery" 
							style="background-image: url('images/muscu.jpg');"></a>
						</div>

						<!-- item gallery sidebar -->
						<div class="wrap-item-gallery m-b-10">
							<a class="item-gallery bg-img1" href="images/gallery-09.jpg" data-lightbox="gallery" 
							style="background-image: url('images/gallery-09.jpg');"></a>
						</div>
					</div>
				</div>

				<div class="sidebar-gallery w-full">
					<span class="mtext-101 cl5">
						A propos
					</span>

					<p class="stext-108 cl6 p-t-27">
						ECE Amazon est votre solution pour l'achat et vente en ligne parmis des millions de produits en stock.<br>
						Vos articles à petits prix dans plusieurs catégories:<br>
						Musique<br>
						Vêtements<br>
						Livres<br>
						Sports et Loisir<br>
						<br>
						ECE Amazon...Dream Shopping 
					</p>
				</div>
			</div>
		</div>
	</aside>

	

	


	<!-- Title page -->
	<section class="bg-img1 txt-center p-lr-15 p-tb-92" style="background-image: url('images/bg-01.jpg');">
		<h2 class="ltext-105 cl0 txt-center">
			Connectez-vous
		</h2>
	</section>	


	<!-- Content page -->
	<section class="bg0 p-t-104 p-b-116">
		<div class="container">
			<!-- le PHP pour le formulaire ---------------->

		<?php

		// identifier la BDD
 				$database = "projet_web";

 			//connectez-vous dans votre BDD
 			$db_handle = mysqli_connect('localhost', 'root', '');
 			$db_found = mysqli_select_db($db_handle, $database);


				//recuperer les donnees venant de la page HTML
			$nom = isset($_POST["nom"])?$_POST["nom"] : ""; //if then else
			$prenom = isset($_POST["prenom"])?$_POST["prenom"] : "";
			$email = isset($_POST["email"])?$_POST["email"] : "";
 			$num_carte= isset($_POST["numero_carte"])?$_POST["numero_carte"] : "";
 			$crypto = isset($_POST["cryptogramme"])?$_POST["cryptogramme"] : "";
 			$mdp = isset($_POST["mdp"])?$_POST["mdp"] : "";
 			$adresse = isset($_POST["adresse"])?$_POST["adresse"] : "";
 			

 			//vérification des champs du formulaire

 			$erreur = "";
 			if($nom == "") {$erreur .= "Le champ Nom est vide. <br>";}
 			if($prenom == "") {$erreur .= " Le champ Age est vide. <br>";}
 			if($num_carte == "") {$erreur .= "Le champ Numero de carte est vide. <br>";}
 			if($crypto == "") {$erreur .= "Le champ Cryptogramme est vide. <br>";}
 			if($email == "") {$erreur .= "Le champ email est vide. <br>";}
 			if($mdp == "") {$erreur .= "Le champ mot de passe est vide. <br>";}
 			if($adresse == "") {$erreur .= "Le champ adresse est vide. <br>";}
 			

 			if ($erreur == "") {
 			 
 				echo "Formulaire valide";
 		}
 					else 
 			{
 				echo "Erreur : $erreur";
 			}

 			if ($_POST["button"])
 			{
 				if($db_found) {
 					$sql = "SELECT * FROM 'acheteur'";
 					if ($email !=""){
 						//on cherche un utilasateur avec l'email et le mdp
 						$sql .= "WHERE Email LIKE '%$email%' ";
 						if ($mdp != "")
 						{ 
 							$sql .= "AND Mdp LIKE '%$mdp%' ";
 						}
 				}
 				$result = mysqli_query($db_handle, $sql);
						//regarder s'il y a de résultat
				if (mysqli_num_rows($result) != 0) {
					//le livre recherché n'existe pas
					echo "utilisateur existant";
					} 
 			
 				
 				else
 				{
 					$sql = "INSERT INTO acheteur(nom, prenom,numero_carte,cryptogramme, Email, Mdp, Adresse)
 					VALUES('$nom' , '$prenom' ,'$num_carte','$crypto','$email' , '$mdp' , '$adresse')";
 				$result = mysqli_query($db_handle, $sql);
 				echo "Vous etes bien inscrits." . "<br>";
 				}
 			}
 			}
 			
 			
 		
 		
			

			?>

	<!--=================================-->
			
		</div>
	</section>

		
	<!-- Footer -->
	<footer class="bg3 p-t-75 p-b-32">
		<div class="container">
			<div class="row">
				<div class="col-sm-6 col-lg-3 p-b-50">
					<h4 class="stext-301 cl0 p-b-30">
						Categories
					</h4>

					<ul>
						<li class="p-b-10">
							<a href="#" class="stext-107 cl7 hov-cl1 trans-04">
								Livres
							</a>
						</li>

						<li class="p-b-10">
							<a href="#" class="stext-107 cl7 hov-cl1 trans-04">
								Musiques
							</a>
						</li>

						<li class="p-b-10">
							<a href="#" class="stext-107 cl7 hov-cl1 trans-04">
								Vêtements
							</a>
						</li>

						<li class="p-b-10">
							<a href="#" class="stext-107 cl7 hov-cl1 trans-04">
								Sport & Loisirs
							</a>
						</li>
					</ul>
				</div>

				<div class="col-sm-6 col-lg-3 p-b-50">
					<h4 class="stext-301 cl0 p-b-30">
						Decouvrez nos offres
					</h4>

					<ul>
						<li class="p-b-10">
							<a href="stvalentin.php" class="stext-107 cl7 hov-cl1 trans-04">
								C'est le st-Valentin
							</a>
						</li>

						<li class="p-b-10">
							<a href="noel.php" class="stext-107 cl7 hov-cl1 trans-04">
								Noël
							</a>
						</li>
					</ul>
				</div>

				<div class="col-sm-6 col-lg-3 p-b-50">
					<h4 class="stext-301 cl0 p-b-30">
						Nos contacter
					</h4>

					<p class="stext-107 cl7 size-201">
						Vous avez des questions ? Venez nous voir au 37 Quai de Grenelle, 75015, Paris, France. Ou Apelez nous au : +33 7 56 89 78 74
					</p>

					<div class="p-t-27">
						<a href="#" class="fs-18 cl7 hov-cl1 trans-04 m-r-16">
							<i class="fa fa-facebook"></i>
						</a>

						<a href="#" class="fs-18 cl7 hov-cl1 trans-04 m-r-16">
							<i class="fa fa-instagram"></i>
						</a>

						<a href="#" class="fs-18 cl7 hov-cl1 trans-04 m-r-16">
							<i class="fa fa-pinterest-p"></i>
						</a>
					</div>
				</div>

				<div class="col-sm-6 col-lg-3 p-b-50">
					<h4 class="stext-301 cl0 p-b-30">
						Newsletter
					</h4>

					<form>
						<div class="wrap-input1 w-full p-b-4">
							<input class="input1 bg-none plh1 stext-107 cl7" type="text" name="email" placeholder="email@example.com">
							<div class="focus-input1 trans-04"></div>
						</div>

						<div class="p-t-18">
							<button class="flex-c-m stext-101 cl0 size-103 bg1 bor1 hov-btn2 p-lr-15 trans-04">
								Subscribe
							</button>
						</div>
					</form>
				</div>
			</div>

			<div class="p-t-40">
				<div class="flex-c-m flex-w p-b-18">
					<a href="#" class="m-all-1">
						<img src="images/icons/icon-pay-01.png" alt="ICON-PAY">
					</a>

					<a href="#" class="m-all-1">
						<img src="images/icons/icon-pay-02.png" alt="ICON-PAY">
					</a>

					<a href="#" class="m-all-1">
						<img src="images/icons/icon-pay-03.png" alt="ICON-PAY">
					</a>

					<a href="#" class="m-all-1">
						<img src="images/icons/icon-pay-04.png" alt="ICON-PAY">
					</a>

					<a href="#" class="m-all-1">
						<img src="images/icons/icon-pay-05.png" alt="ICON-PAY">
					</a>
				</div>
			</div>
		</div>
	</footer>



	<!-- Back to top -->
	<div class="btn-back-to-top" id="myBtn">
		<span class="symbol-btn-back-to-top">
			<i class="zmdi zmdi-chevron-up"></i>
		</span>
	</div>

<!--===============================================================================================-->	
	<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/bootstrap/js/popper.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/select2/select2.min.js"></script>
	<script>
		$(".js-select2").each(function(){
			$(this).select2({
				minimumResultsForSearch: 20,
				dropdownParent: $(this).next('.dropDownSelect2')
			});
		})
	</script>
<!--===============================================================================================-->
	<script src="vendor/MagnificPopup/jquery.magnific-popup.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/perfect-scrollbar/perfect-scrollbar.min.js"></script>
	<script>
		$('.js-pscroll').each(function(){
			$(this).css('position','relative');
			$(this).css('overflow','hidden');
			var ps = new PerfectScrollbar(this, {
				wheelSpeed: 1,
				scrollingThreshold: 1000,
				wheelPropagation: false,
			});

			$(window).on('resize', function(){
				ps.update();
			})
		});
	</script>
<!--===============================================================================================-->
	<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAKFWBqlKAGCeS1rMVoaNlwyayu0e0YRes"></script>
	<script src="js/map-custom.js"></script>
<!--===============================================================================================-->
	<script src="js/main.js"></script>

</body>
</html>