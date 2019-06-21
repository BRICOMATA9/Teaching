<?php

	session_start();

	$exist=0;
	$statut="connect";
	$statut_connect = "Acheteur";
	
	try
	{
		$bdd = new PDO('mysql:host=localhost;dbname=ece_amazon;charset=utf8', 'root', 'root');
	}
	catch (Exception $e)
	{
	    die('Erreur : ' . $e->getMessage());
	}

	$reponse = $bdd->query('SELECT * FROM users INNER JOIN buyers ON users.email=buyers.emailUser');

	echo '<script> alert('. $_POST['password'] . ')</script>';

	while ($donnees = $reponse->fetch())
	{
		if ($donnees['email']==$_POST['email'] && $donnees['password']==$_POST['password']) 
		{
			$exist=1;

			$_SESSION['prenom']=$donnees['fName'];
			$_SESSION['name']=$donnees['lName'];
			$_SESSION['email']=$donnees['email'];
			$_SESSION['rue']=$donnees['adress'];
			$_SESSION['ville']=$donnees['city'];
			$_SESSION['pays']=$donnees['country'];
			$_SESSION['code_postal']=$donnees['postCode'];
		}
	}

	if($exist==1)
	{
		$_SESSION['adresseMail']=$_POST['email'];
		$_SESSION['connected']=true;
		$_SESSION['statut']="Acheteur";
		header('Location: subscribe.php?statut=connect');
		exit();
	}else
	{
		header('Location: mon_compte.php');
		exit();
	}
	

?>