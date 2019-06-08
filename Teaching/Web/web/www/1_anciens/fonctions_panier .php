<?php

	function creerPanier(){

		// Tester si le panier existe , le panier sera une grosse variable SESSION
		 if (isset($_SESSION['panier'])) {

		 	// déclaration de variables utiles pour le panier
		 	$_SESSION['panier']=array(); //tableau
		 	$_SESSION['panier']['libelleProduit']= array(); // nom du produit , tableau à deux entrées
		 	$_SESSION['panier']['qteProduit']= array(); //quantité produit
		 	$_SESSION['panier']['prixProduit']= array(); //prix produit
		 	$_SESSION['panier']['verrou']=false; // Savoir si le panier est verrouillé par defaut =à faulse

		 	// TVA non ajoutée

		 }

		 return true; 
	}



	function ajouterActicle($libelleProduit,$qteProduit,$prixProduit){

		// tester si le panier est déjà créé et detecter si il est verouillé ou pas via la fct isVerouille()
		if (creerPanier() && !isVerouille() ) {
			
			$position_produit = array_search($libelleProduit,$_SESSION['panier']['libelleProduit']);

			//tester que le produit n'est pas déjà ajouté
			if ($position_produit !==false) {

				// si déjà ajouté, on incrémente la quantité
				$_SESSION['panier']['qteProduit'][$position_produit]+= $qteProduit;

			}else{
				array_push($_SESSION['panier']['libelleProduit'], $libelleProduit); // ajout de l'article -> ajout de valeur dans la variable session panier

				array_push($_SESSION['panier']['qteProduit'], $qteProduit);
				array_push($_SESSION['panier']['prixProduit'], $prixProduit);
			}

		}else{

			echo'Erreur, Veuillez contacter l administrateur';

		}
	}


	function modifierQteProduit ($libelleProduit,$qteProduit){

		// vérifié que le panier existe 
		if (creerPanier() && !isVerrouille()) {
			if ($qteProduit > 0) {
				
				$position_produit=array_search($_SESSION['panier']['libelleProduit'], $libelleProduit);

				if ($position_produit !== false) {
					$_SESSION['panier']['libelleProduit'][$position_produit] = $qteProduit; // qd bcp d'articles, on aura un tableau 

				}
			}else{

				supprimerArticle($libelleProduit);
			}
		}else{
			echo "Erreur, veuillez contacter l administrateur";
		}
	}


function supprimerArticle($libelleProduit){

	if (creerPanier() && !isVerrouille()) {
		
		//tableau temporaire pour enregistrer le panier avant de faire la suppression
		$tmp = array();
		$tmp['libelleProduit'] = array();
		$tmp['qteProduit'] = array();
		$tmp['prixProduit'] = array();
		$tmp['verrou'] = array();

		for ($i=0; $i <count($_SESSION['panier']['libelleProduit']) ; $i++) { 
			if ($_SESSION['panier']['libelleProduit'][$i] !== $libelleProduit) {
				array_push($_SESSION['panier']['libelleProduit'], $_SESSION['panier']['libelleProduit'][$i]); 
				array_push($_SESSION['panier']['qteProduit'], $_SESSION['panier']['qteProduit'][$i]);
				array_push($_SESSION['panier']['prixProduit'], $_SESSION['panier']['prixProduit'][$i]);
			}
		}

		$_SESSION['panier'] = $tmp;

		unset($tmp);

	}else{

		echo "Erreur, veuillez contacter un administrateur.";
	}
}



function montantGlobal(){

	$total = 0;

	for ($i=0; $i <count($_SESSION['panier']['libelleProduit']) ; $i++){

		$total += $_SESSION['panier']['qteProduit'][$i]*$_SESSION['panier']['prixProduit'][$i];
	}

	return $total;
}

// à modifier
function supprimerPanier(){

	if (isset($_SESSION['panier'])){

		unset($_SESSION['panier']);
	}

}


function isVerouille(){

	if (isset($_SESSION['panier']) && $_SESSION['panier']['verrou']){

		return true;

	}else{

		return false;
	}
}

function compterArticle(){

	 if (isset($_SESSION['panier'])){

	 	return count($_SESSION['panier']['libelleProduit']);
	
	 }else{

	 	return 0;
	 }

}
?>