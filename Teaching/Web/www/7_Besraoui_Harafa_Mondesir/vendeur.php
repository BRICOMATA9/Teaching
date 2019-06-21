<?php

require_once("../Première version ECEAmazon/hearder.php"); 

$pseudo_vendeur = isset($_POST["pseudo_vendeur"])? $_POST["pseudo_vendeur"] : "";
$mail_vendeur = isset($_POST["mail_vendeur"])? $_POST["mail_vendeur"] : "";

//identification de la base de données
$database = "gestion";

// connection base de données

$db_handle = mysqli_connect('localhost', 'root', '');
$db_found = mysqli_select_db($db_handle, $database);

if (isset($_POST["Login"]))
 {
	if ($pseudo_vendeur&&$mail_vendeur)
	{
	if ($db_found) {
		$sql="SELECT*FROM vendeur WHERE ((pseudo_vendeur='$pseudo_vendeur') AND (mail_vendeur='$mail_vendeur'))";
		$res=mysqli_query($db_handle,$sql);
		$donnee=mysqli_fetch_array($res);
		if ($donnee)
	{
		header('Location:vendeur_connecte.php');

	}
	else
	{
		?>
		<script type="text/javascript">alert("Vendeur introuvable, veuillez contacter l'administrateur")</script>
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
	<title> Vendeur </title>
	<meta charset="utf-8">
	 <link rel="stylesheet" href="vendeur.css" />
</head>
<body>
	 
	   <div id="container">
	   <form action="" method="POST"> 
	    <h1> Connexion </h1>
	   <table> 
	          <tr>   
	                <td>Mail:</td>    
	                <td><input type="text" placeholder="Entrez votre pseudo" name="pseudo_vendeur"/></td>               
	          </tr>    
	          <tr>  <td>Password:</td>    
	                <td><input type="text"placeholder="Entrez votre mail" name="mail_vendeur"/></td>   
	          </tr>               
	          <tr>                      
	          	    <td colspan="2" align="center">                          
	          	    <input type="submit" name="Login" value="Login">                      
	          	    </td>                 
	          </tr> 
	          <tr>
	   </table>  
	   </form> 
	</div>

</body>
</html>