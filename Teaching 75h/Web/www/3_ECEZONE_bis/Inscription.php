<?php
session_start();
define('DB_SERVER', 'localhost');
define('DB_USER', 'root');
define('DB_PASS', '');


//identifier le nom de base de données 
$database = "testzone";
 //connecter l'utilisateur dans BDD
$db_handle = mysqli_connect(DB_SERVER,DB_USER,DB_PASS);
$db_found = mysqli_select_db($db_handle, $database);
//si le BDD existe, faire le traitement
if ($db_found) {
		$Email=$_POST['email'];
		$Nom=$_POST['nom'];
		$Prenom=$_POST['prenom'];
	 	$Adresse=$_POST['adresse'];
		$Mot_de_passe=$_POST['mot_de_passe'];
		$Ville=$_POST['ville'];
		$Code_postal=$_POST['code_postal'];
		$Pays=$_POST['pays'];
		$Telephone=$_POST['telephone'];
		$Modeconnexion = $_POST['modeconnexion'];

		//le stockage dans la base de donnée precisement dans la table utilisateur
		mysqli_query($db_handle, "INSERT INTO utilisateur SET Email='$Email',Nom='$Nom',Prenom='$Prenom',Adresse='$Adresse',Mot_de_passe='$Mot_de_passe',Ville='$Ville',Code_postal='$Code_postal',Pays='$Pays',Telephone='$Telephone',Modeconnexion='$Modeconnexion'");
		header('Location: Connexion.html');
		

}//end if
//si le BDD n'existe pas
else{
	echo"Database not found";
}//end else
//fermer la connection
 mysqli_close($db_handle);

?>