

<?php session_start(); ?> 
<link rel="stylesheet" type="text/css" href="Item.css">

<?php 
	
	if (isset($_POST['search'])) 
    {
    	header('Location:http://127.0.0.1/ProjetPiscineWeb/menu_principal.php');
        exit();
    }
	$id = $_GET["id"];  

	$Article = array();
	$tableauVendeur = array();

	$database= "projetweb";
	$db_handle = mysqli_connect('localhost', 'root', '');
	$db_found = mysqli_select_db($db_handle, $database);
 
	if($db_found)
	{
	  $result = mysqli_query($db_handle, "SELECT * FROM item WHERE `id_item` = $id" ); 
	  $resultUser = mysqli_query($db_handle, "SELECT * FROM connexion" ); 
	}
	else 
	{
	  echo "Database not found";
	}
	while ($row = mysqli_fetch_array($result, MYSQLI_ASSOC))
	{
	     $Article[] = $row;
	} 
	while ($rowUser = mysqli_fetch_array($resultUser, MYSQLI_ASSOC))
	{
	    $tableauUser[] = $rowUser;
	} 

?> 

<!DOCTYPE html>
<html>
<head>
	<title> Article </title>

	<!-- La navbar --> 
	<?php
	//Verif si c'est un vendeur ou pas.
	$checkVendeur =false; 
	$checkClient = false; 

	for($i=0;$i< count($tableauUser) ;$i++)
	{
		if ( $_SESSION['email'] == $tableauUser[$i]['email'])
		{
			if( $tableauUser[$i]['type']=="Vendeur")
			{			
				 $checkVendeur = true; 
			}
			if( $tableauUser[$i]['type']=="Client")
			{			
				 $checkClient = true; 
			}
		}

	}

	//Si ce n'est pas un vendeur 
	if ( $checkVendeur == false)
	{
		require "navbar.php";
	}


	?>
	<br>
	<br>

	<!-- Pour l'ensemble des articles  via le site https://bootsnipp.com/snippets/orOGB --> 
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

	<div class="container-fluid">
			
		<div class="card">
			<div class="row">
				<aside class="col-sm-5 border-right">
						<article class="gallery-wrap"> 
							<div class="img-big-wrap"  >

								<div class="text-center"> 
									<br> 
										<?php echo '<img src='.$Article[0]['photos_item'].'>' ; ?>
								</div>  

								</div> <!-- slider-product.// -->

								<div class="text-center"> 
									<div class="img-small-wrap">
										<div class="item-gallery"> <?php echo '<img src='.$Article[0]['photos_item'].'>' ; ?> </div>
										<div class="item-gallery"> <img src=https://s3-ap-south-1.amazonaws.com/av-blog-media/wp-content/uploads/2018/02/github1.png> </div>
									</div>
								</div>

						</article> <!-- gallery-wrap .end// -->
				</aside>

				<aside class="col-sm-7">
					<article class="card-body p-5">
						<h3 class="title mb-3"> <?php echo $Article[0]['nom_item'] ?> </h3>

					<p class="price-detail-wrap"> 
						<span class="price h3 text-warning"> 
							<span class="num"> <?php echo $Article[0]['prix_item'] ?> </span> <span class="currency">US $</span>
						</span> 
						<span>/each </span> 
					</p>

					<!-- Description de l'article -->
					<dl class="item-property">
					  <dt> Description </dt>
					  <dd><p> <?php echo $Article[0]['description_item'] ?> </p></dd>
					</dl>

					<!-- Pour les catégorie --> 
					<?php if( $Article[0]['sous_categorie'] != "") {?>
						<dl class="param param-feature">
						  <dt>Model#</dt>
						  <dd> <?php echo $Article[0]['categorie_item'] ?> </dd>
						</dl>  

						<dl class="param param-feature">
						  <dt>Color</dt>
						  <dd>Black and white</dd>
						</dl>  
					<?php } ?>
					

					<!-- Pour les destionations --> 
					<dl class="param param-feature">
					  <dt>Delivery</dt>
					  <dd>Russia, USA, and Europe</dd>
					</dl>  <!-- item-property-hor .// -->


					<hr>
						<div class="row">
							<!-- colonne de 5 sm  -->
							<div class="col-sm-5">
								<!-- Pour sélectionner la quantité --> 
								<dl class="param param-inline">
								  <dt>Quantity: </dt>
								  <dd>
								  	<?php if ( $checkVendeur == false ) { 
								  	echo '
									<form name="testForm" id="testForm"  method="POST"  >
								
						<select class="form-control form-control-sm" name="Quantite1" style="width:70px;">
									  		<option> 1 </option>
									  		<option> 2 </option>
									  		<option> 3 </option>
									  		<option> 4 </option>
									  		<option> 5 </option>
									  		<option> 6 </option>
									  	</select> 
						<input type="submit" name="Quantite2" value=Choisir quantité autofocus  onclick="return true;">
								</form>';
									;
						 	$Quantite =isset($_POST["Quantite2"]); 
							echo $Quantite;
								  	 }
								  	 if ( $checkVendeur == true)
								  	 {
								  	 	echo '<p style="width:70px;">'.$Article[0]['stock_item'].' Quantité disponible </p>' ; 
								  	 } ?>  
								  </dd>
								</dl> 
							</div> 
								 
							<!-- Si c'est un vetement afficher  -->
							<?php if ( $Article[0]['categorie_item'] == "Vetement") { ?>
							<div class="col-sm-7">
								<dl class="param param-inline">
									  <dt>Size: </dt>
									  <dd>

									  	<!-- permet de faire l'alinéa --> 
									  	<label class="form-check form-check-inline">
										  <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio2" value="option2">
										  <span class="form-check-label">SM</span>
										</label>

										<!-- permet de faire l'alinéa --> 
										<label class="form-check form-check-inline">
										  <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio2" value="option2">
										  <span class="form-check-label">MD</span>
										</label>

										<!-- permet de faire l'alinéa --> 
										<label class="form-check form-check-inline">
										  <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio2" value="option2">
										  <span class="form-check-label">XXL</span>
										</label>
									  </dd>
								</dl>  
							</div> 
							<?php } ?>
						</div> <!-- row -->
						<hr>
						<?php 
					
							if ( $checkClient == true )
							{
								echo '
								<a href="" class="btn btn-lg btn-primary text-uppercase"> Buy now </a>
								<a href="" class="btn btn-lg btn-outline-primary text-uppercase"> <i class="fas fa-shopping-cart"></i> Add to cart </a> ';
								?>
							
						
								<form name="testForm" id="testForm"  method="POST"  >
								<input type="submit" name="btn" value="Add to cart" autofocus  onclick="return true;">
								</form>
							<?php
							if(isset($_POST['btn'])){
								echo "<script type=\"text/javascript\">var e document.getElementById('testForm'); e.action='test.php'; e.submit();
								
													</script>
												";
								
											 }
							
								//$quantite=0;
								if($Quantite!=0)
								{
								$sql2="INSERT INTO `commande`(`id_commande`, `id_item`,`email_client`, `quantite`) VALUES (DEFAULT,".$Article[0]['id_item'].",'".$_SESSION['email']."',".$Quantite.")";
								$result2=mysqli_query($db_handle,$sql2);
								}
								
								  
								
							}
							else if ( $checkVendeur == false)
							{	echo '
										<a href="connexion.php" class="btn btn-lg btn-primary text-uppercase"> Buy now </a>
										<a href="connexion.php" class="btn btn-lg btn-outline-primary text-uppercase"> <i class="fas fa-shopping-cart"></i> Add to cart </a> ';
							}
							
						?> 
					</article> <!-- card-body.// -->
				</aside> <!-- col.// -->
			</div> <!-- row.// -->
		</div> <!-- card.// -->

	</div>

	<br><br><br>

	<!-- ne pas afficher la ligne si pas de link vers vidéo --> 
	<?php if ( $Article[0]['video_item'] != null )
	{echo '
		<div class="container-fluid " >
			<div class="col-sm-12 border"">
				<br>
					<h3 class="title mb-3"> Check our video ;) </h3>
				<br>
				<div class="img-big-wrap" >
						<div class="text-center">
									<iframe width="560" height="315" src='. $Article[0]['video_item']  .' frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
						</div>
				</div>
				<br><br>
			</div>
		</div>'; 
	}?>
	<br><br><br>


	<!-- Le footer --> 
	<footer class="page-footer" style="background-color: black;">
		<div class="container" style="color: white;">
			<br>
			<div class="row">
				<div class="col-lg-8 col-md-8 col-sm-12" >

					<h6 class="text-uppercase font-weight-bold"> Information additionnelle</h6>
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

</head>
<body>

</body>
</html>