<?php

	session_start();

	$_SESSION["email"]=isset($_SESSION["email"])? $_SESSION["email"] : "";
/////////////////TEST////////////////
	//$mail="stagiaire@gmail.com";
/////////////////////////////////////
	$database= "projetweb";
	$db_handle = mysqli_connect('localhost', 'root', '');
	$db_found = mysqli_select_db($db_handle, $database);

	$sqlType = array(); 
	  
	$sql = 'SELECT type FROM `connexion` WHERE `email` ="'.$_SESSION["email"].'" ';  
	
	if($db_found)
	{
		$type = mysqli_query($db_handle, $sql);
	}

	//Verification que c'est bien un acheteur.
	while ($row = mysqli_fetch_array($type, MYSQLI_ASSOC))
	{
    	 $sqlType[] = $row['type'];
	} 

	//Ce n'est pas un client
	if ($sqlType[0] != "Client" )
	{
		header('Location: http://127.0.0.1/ProjetPiscineWeb/menu_principal.php');
		exit();

	}
	//C'est un client
	else
	{
		//Cherche tt dans la bbd panier tt les comandes du client
		$tableau_nom=array(); 
		$tableau_photo=array();
		$tableau_description=array();
		$tableau_video=array(); 
		$tableau_prix=array();
		$tableau_quantite=array(); 
		$total=0; 
		$sql = 'SELECT id_item, quantite FROM `commande` WHERE email_client="'.$_SESSION["email"].'"';  
		$result1 = mysqli_query($db_handle, $sql);
		while ($row = mysqli_fetch_array($result1, MYSQLI_ASSOC))
			{
				$tableauid[]=$row['id_item'];
				$tableau_quantite[]=$row['quantite'];
			}
		$sql1 = 'SELECT * FROM item WHERE id_item=';
		for ($i=0; $i < count($tableauid) ; $i++) 
		{
			$sql1='SELECT * FROM item WHERE id_item='.$tableauid[$i];
			$result1= mysqli_query($db_handle, $sql1);

			while ($row = mysqli_fetch_assoc($result1))
			{
			$tableau_nom[]= $row['nom_item'];
			$tableau_photo[]= $row['photos_item'];
			$tableau_description[]= $row['description_item'];
			$tableau_video[]= $row['video_item'];
			$tableau_prix[]= $row['prix_item'];
//////////////DEBEUG///////////////////////////////////////////////////////////////	
			/*echo"<br>////////////////////////////////////////////<br>";
			echo"FICHE ITEM<br>";
			echo"nom_item: ".$tableau_nom[$i]."<br>";
			echo"description_item: ".$tableau_description[$i]."<br>";
			echo"photos_item: ".$tableau_photo[$i]."<br>";
			echo"video_item: ".$tableau_video[$i]."<br>";
			echo"prix_item: ".$tableau_prix[$i]."<br>";
			echo"stock_item: ".$tableau_quantite[$i]."<br>";*/
//////////////DEBEUG///////////////////////////////////////////////////////////////			
			}
		}
		//////////////DEBEUG///////////////////////////////////////////////////////////////
		//echo"id_client: ".$mail."<br>";
		//////////////DEBEUG///////////////////////////////////////////////////////////////
	}?>

<!DOCTYPE html>
<html>
<head>
	<title>Page Panier</title>
	<meta charset="utf-8">  
	<meta name="viewport" content="width=device-width, initial-scale=1">      
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">  
	<link rel="stylesheet" type="text/css" href="jolie.css">
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>  
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script> 
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
	<style type="text/css">
		#final{
			margin-left: 200px;
		}
	</style>
</head>


<body>
	<!-- Création de la barre en haut de l'écran --> 
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">

  		<a class="navbar-brand" href="menu_principal.php"> <h2> ECE Amazon </h2> </a> 
		<div class="collapse navbar-collapse" id="main-navigation">
	
			<!-- Titre de la page --> 
			<ul class="navbar-nav">             
				<li class="nav-item"><a class="nav-link" href=""> <h1> Mon panier </h1></a> </li>       
			</ul> 

		</div> 

	</nav>
	
	<?php 
	$lol=sizeof($tableauid);
	for ($i=0; $i < $lol ; $i++)
	{
	?>
		<div class="container">   
              <div class="row">
                <div class="col-lg-12">
                   <div class="card bg-light">
                     <div class="thumbnail">
                        <!-- endroit où mettre les images venue de la database --> 
                        <div class="image">
				 			<?php 
				 			if(isset($tableau_photo[$i]))
							{
								echo "<img src='".$tableau_photo[$i]."'width=200, height=400>"; 
							}?>
						</div>

						<div class="caption">

							<br>
							<h3 class= "ItemTitre">
								<?php 
								if(isset($tableau_nom[$i]))
									{
								echo $tableau_nom[$i]; 
								}?>
							 </h3>
							
							<h5 class="descrip">
								<?php if(isset($tableau_description[$i]))
									{
								echo $tableau_description[$i]; 
									}
				  				?>
							</h5>
							<h5 class="descrip">
								<?php if(isset($tableau_prix[$i]))
									{
									
										$montant=$tableau_prix[$i]*$tableau_quantite[$i];
										echo "Prix Unitaire : ".$tableau_prix[$i]."$  "; 
										echo "Quantité : ".$tableau_quantite[$i]."  "; 
										echo "Côut totale : ".$montant."$"; 
										$total=$montant+$total;

									}
				  				?>
							</h5>

                        </div>

						  
                     </div>      
                  </div>
                  <br>
                </div>
            </div> 
		</div>
<?php }   ?>     

<div id="final">
         <h5 class="descrip">
			<?php
				echo "Côut total : ".$total."$";
			?>
		</h5>
		<div >
      		<a href="verifCB.php?id=<?php echo $total;?>">Passer la commande</a>
      	</div>

 </div>
	
</body>

</html>
