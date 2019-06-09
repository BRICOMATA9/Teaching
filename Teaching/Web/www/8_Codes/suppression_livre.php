<?php 
	session_start();

	//Variable récupérer de la page "produits_vendeur"
	if(isset($_SESSION['ID_L'])){
    	$ID = $_SESSION['ID_L'];
	}
	else{
	    $ID = "";
	}

	//identifier votre BDD
    $database = "ece_amazon";
    //connectez-vous dans votre BDD
    $db_handle = mysqli_connect('localhost', 'root', '');
    $db_found = mysqli_select_db($db_handle, $database);
    //Si la BDD est trouvée
    if($db_found){
		
	    $sql = "DELETE FROM livres WHERE ID = '$ID' ";
	    $result = mysqli_query($db_handle,$sql);

	    //redirection vers la meme page pour la rafraichir
	    header("Location: produits_vendeur.php"); 
	} 
	else {	//affichage d'erreur si la BDD non trouvée et fermeture de la BDD
	     echo "Database not found.";
	}
mysqli_close($db_handle);
?> 