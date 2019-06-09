<?php
  require_once("../Première version ECEAmazon/hearder.php"); 

?>


<!DOCTYPE html>
<html>
<head>
	<title>Administration</title>
	<meta charset="utf-8"/>
	<link rel="stylesheet" href="admin.css" />
	<script type="text/javascript" src="admin.js"> </script>
</head>
<body>



	   <!-- Informations d'authentification-->
 
	   	<div id="container">
	   
	    <h1> Connexion </h1>
	   <table> 
	          <tr>   
	                <td>Pseudo:</td>    
	                <td><input type="text" placeholder="Entrez votre pseudo" name="pseudo"/></td>               
	          </tr>    
	          <tr>  <td>Mot de passe:</td>    
	                <td><input type="password"placeholder="Entrez votre mot de passe" name="mdp"/></td>   
	          </tr>               
	          <tr>                      
	          	    <td colspan="2" align="center">                          
	          	    <a href="http://localhost/Première version ECEAmazon/administ.php"><input type="submit" value="submit"></a>                      
	          	    </td>                 
	          </tr>  
	   </table>  
	  
	</div>
</body> 
</html> 

</body>
</html>