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

	$reponse = $bdd->query('SELECT email,password FROM users INNER JOIN buyers ON users.email=buyers.emailUser');

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
		$_SESSION['connected']=true;
		$_SESSION['statut']="Acheteur";
		header('Location: ajoutCart.php?statut=connect&id='.$_GET['id'].'&emailB='.$_POST['email']);
		exit();
	}else
	{
		header('Location: loginBuyer.php?id='.$_GET['id']);
		exit();
	}
	

?>