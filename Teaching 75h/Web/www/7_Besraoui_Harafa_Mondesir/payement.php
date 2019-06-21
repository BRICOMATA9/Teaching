<?php
if (isset($_POST['submit']))
	
	{
$numero_carte=($_POST['numero_carte']);
$type_carte=($_POST['type_carte']);
$nom_personne=($_POST['nom_personne']);
$date_expiration=($_POST['date_expiration']);
$cryptogramme=($_POST['cryptogramme']);
 if ($numero_carte&&$type_carte&&$nom_personne&&$date_expiration&&$cryptogramme)
 {
 	$database = "gestion";
 	$db_handle = mysqli_connect('localhost','root', '');
$db_found = mysqli_select_db($db_handle, $database);
 if ($db_found)
    {

               
         $query="INSERT INTO payment(numero_carte,type_carte,nom_personne,date_expiration_cryptogramme) VALUES('$numero_carte','$type_carte','$nom_personne','$date_expiration','$cryptogramme')"; 
         $res=mysqli_query($db_handle,$query);
         mysqli_close($db_handle); 
         header('Location:accueil.html');

?>
    <script type="text/javascript">alert('Commande validé')</script>
<?php


     }

 }

}
?>

<!DOCTYPE html> 
<html> 
<head> 
       <title>Payement</title>  
       <meta charset="utf-8">  
       <link rel="stylesheet" href="payement.css" />
    
</head> 
<body>   

<!-- Les différents onglets -->
<h1 class="logo"><img src="logo_ece_amazon1.png" alt="Logo de ECE AMAZON" height=" 150" width="200"></h1>
 <div id="colonne2">
    	    <form action="/search" id="searchthis" method="Post">
    	        <input id="search" name="q" type="text" placeholder="" />
    	        <input id="search-btn" type="submit" value="Rechercher" />
    	    </form>
    	</div>
	<br><br><br><br><br><br><br><br>
	<div id="nav">      
	  <a href="categories.html">Categories</a>        
	  <a href="ventes_flash.html">Ventes Flash</a>        
	  <a href="vendre.html">Vendre</a>       
	  <a href="votre_compte.html">Votre Compte</a>
	  <a href="panier.html"><img src="panier.png" height=" 50" width="50"></a>  
	  <a href="aide.html">Aide</a>
	   </div> 
	

	          <h3>Procédez au moyen de payement</h3>  
	          <form method="POST" action=""> 


	          	 <table>  
	                 
	                 	   <tr>      
	                 	   	        <td>Numéro de Carte:</td>      
	                 	   	        <td><input type="text" name="numero_carte"></td>     
	                 	   </tr>

	                 	   <tr>      
	                 	   	        <td>Type de Carte:</td>      
	                 	   	        <td><select name="type_carte">
	                 	   	        	<option value='master_card' > Master Card</option>
	                 	   	        	<option value='visa' > Visa</option>
	                 	   	        	<option value='american_express' > American Express</option>
	                 	   	        	<option value='paypal' > PayPal</option>

	                 	   	        </select>></td>     
	                 	   </tr>   
	                 	   <tr>      
	                 	   	        <td>Nom:</td>      
	                 	   	        <td><input type="text" name="nom_personne"></td>     
	                 	   </tr>
	                 	           
	                 	   <tr>      
	                 	   	        <td>Date d'expiration :</td>      
	                 	   	        <td><input type="date" name="date_expiration"></td>     
	                 	   </tr>
	                 	   <tr>      
	                 	   	        <td>Mot de passe :</td>      
	                 	   	        <td><input type="text"placeholder="Exemple : 634" name="cryptogramme"></td>     
	                 	   </tr>
	                 	   
	                 	   <tr>      
	                 	   	        <td colspan="2" align="center"><input type="submit" name="submit" ></td>     
	                 	   </tr>    
	                 </table>  

	           </form>    
</body> 
</html> 
