<?php


require_once("../Première version ECEAmazon/hearder.php"); 



if (isset($_POST['submit']))

	{
		$mail_acheteur=($_POST['mail_acheteur']);
		$nom_acheteur=($_POST['nom_acheteur']);
        $prenom_acheteur=($_POST['prenom_acheteur']);
        $adresse_acheteur=($_POST['adresse_acheteur']);
        $motdepasse_acheteur=($_POST['motdepasse_acheteur']);
        if ($mail_acheteur&&$nom_acheteur&&$prenom_acheteur&&$adresse_acheteur&&$motdepasse_acheteur)
        {
        	$database = "gestion";
 	        $db_handle = mysqli_connect('localhost', 'root', '');
            $db_found = mysqli_select_db($db_handle, $database);
            if ($db_found)
            {

               $query="INSERT INTO acheteur(mail_acheteur,nom_acheteur,prenom_acheteur,adresse_acheteur,motdepasse_acheteur) VALUES('$mail_acheteur','$nom_acheteur','$prenom_acheteur','$adresse_acheteur','$motdepasse_acheteur')"; 
               $res=mysqli_query($db_handle,$query);
               mysqli_close($db_handle);
             }
        }
    }
?>



      
              

<!DOCTYPE html> 
<html> 
<head> 
       <title>Nouveau client</title>  
       <meta charset="utf-8">  
       <link rel="stylesheet" href="creercompte.css" />
    
</head> 
<body>   




	<!-- Formulaire de création -->
	        <form method="post" action="creer_compte.php">   
	          <h3>Créez votre compte</h3>  
	           
	                 <table>  
	                 <tr>      
	                 	   	        <td>Adresse Mail:</td>      
	                 	   	        <td><input type="text" name="mail_acheteur"></td>     
	                 	   </tr>   
	                 	   <tr>      
	                 	   	        <td>Nom:</td>      
	                 	   	        <td><input type="text" name="nom_acheteur"></td>     
	                 	   </tr>
	                 	   <tr>      
	                 	   	        <td>Prénom:</td>      
	                 	   	        <td><input type="text" name="prenom_acheteur"></td>     
	                 	   </tr>
	                 	            
	                 	   <tr>      
	                 	   	        <td>Adresse :</td>      
	                 	   	        <td><input type="text" name="adresse_acheteur"></td>     
	                 	   </tr>
	                 	   <tr>      
	                 	   	        <td>Mot de passe :</td>      
	                 	   	        <td><input type="password" name="motdepasse_acheteur"></td>     
	                 	   </tr>
	                 	   
	                 	   <tr>      
	                 	   	        <td colspan="2" align="center"><input type="submit" name="submit" ></td>     
	                 	   </tr>    
	                 </table>   
	            </form>

	          
 
</body> 
</html> 
