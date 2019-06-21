<?php
session_start();
$mail=$_SESSION['email'];
$bliat="'";
$database= "projetweb";
$db_handle = mysqli_connect('localhost', 'root', '');
$db_found = mysqli_select_db($db_handle, $database);
if($db_found)
{
  $sql = "SELECT * FROM `vendeur`  WHERE email_vendeur =  ";
  $sqlbis =$sql.$bliat.$mail.$bliat;
  $sql2 = "SELECT id_item FROM `mes_ventes` WHERE email_vendeur =  ";
  $sql2bis =$sql2.$bliat.$mail.$bliat;
  $sql3 = "SELECT photos_item FROM `item`";
}
else 
{
  echo "Database not found";
}


$result= mysqli_query($db_handle, $sqlbis)or die(mysqli_error($db_handle)); 
$result2 = mysqli_query($db_handle, $sql2bis)or die(mysqli_error($db_handle));
$result3 = mysqli_query($db_handle, $sql3 )or die(mysqli_error($db_handle)); 
 
if (mysqli_num_rows($result) == 0) 
{
    echo "vendeur not found";
} 
if (mysqli_num_rows($result) == 0) 
{
    echo "mes_ventes not found";
} 

if (mysqli_num_rows($result3) == 0) 
{
    echo "items not found";
} 	
else 
{
  while ($row =mysqli_fetch_assoc($result)) 
  {
	 
    $nom_vendeur = $row['nom_vendeur'];
	$prenom_vendeur = $row['prenom_vendeur'];  
	$photo_vendeur = $row["photo_vendeur"];
	$photo_fond = $row["photo_fond"];
	$id_mventes = $row["id_ventes"];
	 
  }
	//recupère l'ID de tt les items vendus par le vendeur
	while ($row1 = mysqli_fetch_assoc($result2))
	{
		//echo mysqli_num_rows($result2) ;
		$tableauIdItem = $row1['id_item'];
		//$sql4= "SELECT photos_item FROM `item` WHERE id_item=%";
   		while ($row2 = mysqli_fetch_array($result3, MYSQLI_ASSOC))
		{
   		 $tableauPhotoItem[] = $row2['photos_item'];
			//echo  $tableauPhotoItem[0];
		} 
	} 
	
		 }

?>

<!DOCTYPE html>
<html>
<head>
	<title>Vendeur Page</title>
	<meta charset="utf-8">  
	<meta name="viewport" content="width=device-width, initial-scale=1">      
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">  
	<!--<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">-->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="jolie.css">
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>  
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script> 
<!------------------------------------------------------------------------------------------------------------------------->
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------------------------------------------------------------------------------------------------------------------------->
</head>
<!------------------------------------------------------------------------------------------------------------------------->
<body background=<?php echo $photo_fond?> >
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  		<a class="navbar-brand" href="deconnexion.php"> <h2> Deconnexion </h2> </a> 
		<div class="collapse navbar-collapse" id="main-navigation">
			<img src=<?php echo $photo_vendeur?>  width="50" height="50">

			<ul class="navbar-nav">             
				
				<li class="nav-item"><a class="nav-link" href="http://127.0.0.1/ProjetPiscineWeb/monprofile">Mon Profil</a></li>
				<li class="nav-item"><a class="nav-link" href="http://127.0.0.1/ProjetPiscineWeb/gerer_mes_stocks.php">Mes Stocks</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Contact</a></li> 				 
				 
				<h2>Bienvenue <?php echo $prenom_vendeur?> <?php echo $nom_vendeur?></h2>
			</ul>       
		</div> 
	</nav>


<div class="container">   
			    <div class="row">
	<?php 

	  $tableautout = array();

	  $request="SELECT photos_item, nom_item, id_item, prix_item FROM item where id_mesventes= '".$id_mventes."'";
	  if($db_found)
	  {
	    $result = mysqli_query($db_handle,$request);
		
	  }
	  else 
	  {
	    echo "Database not found";
	  }
	  while ($row = mysqli_fetch_array($result, MYSQLI_ASSOC))
	  {
	       $tableautout[] = $row;
	  } 

	?> 

			    </div>
			</div>
	 <?php for($i=0;$i< count($tableautout) ;$i++) : ?>
            <?php  require "rowObjet.php"; ?>
        <?php endfor; ?>
<!------------------------------------------------------------------------------------------------------------------------->
				
</body>
</html