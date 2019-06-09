<?php

$identifian =$_POST['identi'];
$soumet =$_POST['Ajouter_cet_article'];

if($soumet){
	$database = "article";
	$db_found = new mysqli("localhost","root", "", $database );
    if ($db_found) {

		$SQL = $db_found->prepare("DELETE FROM article  WHERE ID=?");

		$SQL->bind_param('s',$identifian);
		$SQL->execute();

		$SQL->close();
		$db_found->close();

		print "ROW DELETED";
	}
	else {
		print "Database NOT Found ";
	}
}


















?>
