<?php
	session_start();
	$_SESSION["email"]=isset($_SESSION["email"])? $_SESSION["email"] : "";
	
	$database= "projetweb";
	$db_handle = mysqli_connect('localhost', 'root', '');
	$db_found = mysqli_select_db($db_handle, $database);

	$sqlType = array(); 
	  
	$sql = 'SELECT * FROM `connexion` WHERE `email` = "'.$_SESSION["email"].'" ' ;  

	if($db_found)
	{
		//$result = mysqli_query($db_handle,$sql ); 
		$type = mysqli_query($db_handle, $sql);
	}

?>

<!DOCTYPE html>
<html>
<head>
	<title>Vendeur Page</title>
	<meta charset="utf-8">  
	<meta name="viewport" content="width=device-width, initial-scale=1">      
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">  
	<link rel="stylesheet" type="text/css" href="jolie.css">
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>  
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script> 
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
</head>
<body>

	<!-- Constitution d'une navbar --> 
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  		<a class="navbar-brand" href="menu_principal.php"> <h2> ECE Amazon </h2> </a> 
		<div class="collapse navbar-collapse" id="main-navigation">
			        
		</div> 
	</nav>

	<?php 
	//Récupération et association de tout les email dans un tableau associatif 
	while ($row = mysqli_fetch_array($type, MYSQLI_ASSOC))
	{
    	 $sqlType[] = $row['type'];;
	} 

	for($i=0;$i< count($sqlType) ;$i++) 
    {     
		//Si l'Utilisateur est un vendeur 
		if($sqlType[$i]=="Vendeur")
		{
			//Récupérer les infos du vendeur 
			$sqltout="SELECT * FROM `".$sqlType[$i]."` WHERE (email_vendeur ='".$_SESSION["email"]."')";
			$result2= mysqli_query($db_handle, $sqltout);
			while ($row = mysqli_fetch_array($result2, MYSQLI_ASSOC))
			{
			//Affichage de toutes ses informations
				echo '<img src= '.$row['photo_vendeur'].'width="84" height="84"><br>';
				echo "email:  ".$row['email_vendeur'].						   "<br>";
				echo "nom:".$row['nom_vendeur'].							   "<br>";	
				echo "prenom: ".$row['prenom_vendeur'].						   "<br>"; 
			}
		}

		//Si l'Utilisateur est un Admin 
		if($sqlType[$i]=="Admin")
		{
			//Récupérer les infos du Admin
			$sqltout="SELECT * FROM `".$sqlType[$i]."` WHERE (email_admin ='".$_SESSION["email"]."')";
			$result2= mysqli_query($db_handle, $sqltout);

			while ($row = mysqli_fetch_array($result2, MYSQLI_ASSOC))
			{
				//Affichage de toutes ses informations
				echo "email:  ".$row['email_admin'].	"<br>";
				echo "nom: {$row['nom_admin']}".		"<br>";	
			}
		}

		//Si l'Utilisateur est un Client 
		if($sqlType[$i]=="Client")
		{
			//Récupérer les infos du Client
			$sqltout='SELECT * FROM `'.$sqlType[$i].'` WHERE email_client ="'.$_SESSION["email"].'" ';
			$result2= mysqli_query($db_handle, $sqltout);

			while ($row = mysqli_fetch_array($result2, MYSQLI_ASSOC))
			{
				//Affichage de toutes ses informations
				echo "email:  ".$row['email_client'].			  "<br>";
				echo "nom: {$row['nom_client']}".				  "<br>";
				echo "prenom: {$row['prenom_client']}".			  "<br>";
				echo "adresse postale: {$row['adresse_postale']}"."<br>";
				echo "code_postale: {$row['code_postale']}".	  "<br>";
				echo "ville: {$row['ville']}".					  "<br>";
				echo "pays: {$row['pays']}".					  "<br>";
				echo "numero_tel: {$row['numero_tel']}".		  "<br>";
			}
		}
	}
	
?>
	
</body>
</html
