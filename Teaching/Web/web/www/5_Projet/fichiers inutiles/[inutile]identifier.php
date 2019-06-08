<?php     
	$prenom   = isset($_POST["prenom"])?$_POST["prenom"] : ""; 
	$nom   = isset($_POST["nom"])?$_POST["nom"] : "";
	$adresse   = isset($_POST["adresse"])?$_POST["adresse"] : "";
	$infopaie   = isset($_POST["infopaie"])?$_POST["infopaie"] : "";
  $phone  = isset($_POST["phone"])?$_POST["phone"] : "";
  

   
 
    $erreur = ""; 
 
    if($prenom == "") {$erreur .= "Le champ Prénom est vide. <br>";}
    if($nom == "") {$erreur .= "Le champ Nom est vide. <br>";}     
     if($adresse == "") {$erreur .= " Le champ Adresse est vide. <br>";}    
      if($infopaie == "") {$erreur .= "Le champ Information de paiement est vide. <br>";}    
       if($phone== "") {$erreur .= "Le champ Téléphone est vide. <br>";} 

      

    
 
    if ($erreur == "") {         echo "Formulaire valide. <br>";  
      }     else {         echo "Erreur : $erreur";     } ?> 