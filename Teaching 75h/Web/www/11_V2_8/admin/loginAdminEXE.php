<?php

	session_start();

	$exist=0;
	$statut="connect";
	$statut_connect = "admin";
	
	try
	{
		$bdd = new PDO('mysql:host=localhost;dbname=ece_amazon;charset=utf8', 'root', 'root');
	}
	catch (Exception $e)
	{
	    die('Erreur : ' . $e->getMessage());
	}

	$reponse = $bdd->query('SELECT email,password FROM users INNER JOIN admins ON users.email=admins.emailUser');

	echo '<script> alert('. $_POST['password'] . ')</script>';

	while ($donnees = $reponse->fetch())
	{
		if ($donnees['email']==$_POST['email'] && $donnees['password']==$_POST['password']) 
		{
			$exist=1;
		}
	}

	if($exist==1)
	{
		$_SESSION['adresseMail']=$_POST['email'];
		$_SESSION['statut']="Admin";
		header('Location: subscribe.php?statut=connect');
		exit();
	}else
	{
		header('Location: admin.php');
		exit();
	}
	

?>