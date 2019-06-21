<?php

require_once("../Première version ECEAmazon/hearder.php"); 


$mail_acheteur = isset($_POST["mail_acheteur"])? $_POST["mail_acheteur"] : "";
$motdepasse_acheteur = isset($_POST["motdepasse_acheteur"])? $_POST["motdepasse_acheteur"] : "";

//identification de la base de données
$database = "gestion";

// connection base de données

$db_handle = mysqli_connect('localhost', 'root', '');
$db_found = mysqli_select_db($db_handle, $database);

if (isset($_POST["Login"]))
 {
	if ($mail_acheteur&&$motdepasse_acheteur)
	{
	if ($db_found) {
		$sql="SELECT*FROM acheteur WHERE ((mail_acheteur='$mail_acheteur') AND (motdepasse_acheteur='$motdepasse_acheteur'))";
		$res=mysqli_query($db_handle,$sql);
		$donnee=mysqli_fetch_array($res);
		if ($donnee)
	{
		header('Location:accueil.html');

	}
	else
	{
		?>
		<script type="text/javascript">alert("Utilisateur introuvable, veuillez réessayer")</script>
		<?php
	}
	
	mysqli_close($db_handle);
}
}
}

?>
<!DOCTYPE html> 
<html> 
<head> 
	<meta charset="utf-8"> 
	<title>Identifiez-vous</title> 
	   <link rel="stylesheet" href="votre_compte.css" />
	<script type="text/javascript" src="votre_compte.js"> </script>
</head> 

<body>

	   
	   <div id="container">
	   <form action="" method="POST"> 
	    <h1> Connexion </h1>
	   <table> 
	          <tr>   
	                <td>Mail:</td>    
	                <td><input type="text" placeholder="Entrez votre pseudo" name="mail_acheteur"/></td>               
	          </tr>    
	          <tr>  <td>Password:</td>    
	                <td><input type="password"placeholder="Entrez votre mot de passe" name="motdepasse_acheteur"/></td>   
	          </tr>               
	          <tr>                      
	          	    <td colspan="2" align="center">                          
	          	    <input type="submit" name="Login">                      
	          	    </td>                 
	          </tr> 
	          <tr>
	          <a href="creer_compte.php" rel="nofollow noopener noreferrer" target="_blank">Pas encore inscrit ?</a>
	   </table>  
	   </form> 
	</div>
</body> 
</html>