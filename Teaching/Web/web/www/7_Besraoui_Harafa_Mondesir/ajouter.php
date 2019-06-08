<?php

 
 $identifian =$_POST['identi'];
 $article_name =$_POST['nom_article'];
 $image_a =$_POST['imag'];
 $descript =$_POST['descri'];
 $pri =$_POST['prix_article'];
 $typ = $_POST['type_article'];
 $soumet =$_POST['Ajouter_cet_article'];



 
if($soumet){
	$database = "article";
	$db_found = new mysqli("localhost","root", "", $database );
    if ($db_found) {

		$SQL = $db_found->prepare("INSERT INTO article (ID,Nom,Image,Description, Prix, Type) VALUES (?, ?, ?, ?, ?, ?)");

		$SQL->bind_param('ssssds',$identifian,$article_name,$image_a,$descript,$pri,$typ);
		$SQL->execute();

		$SQL->close();
		$db_found->close();

		print "New row inserted";
	}
	else {
		print "Database NOT Found ";
	}
}
 



 ?>

