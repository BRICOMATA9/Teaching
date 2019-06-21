<?php include("header.php");?>

<?php session_start(); 

$connected=$_SESSION['connected'];
$email=$_SESSION['adresseMail'];

if ($connected == true)
{
	if ($_SESSION['statut']=="Acheteur")
	{
		header('Location: ajoutCart.php?id='.$_GET['id'].'&emailB='.$email);
		exit();
	}else
	{
		?>
		<h3><br><br>L'utilisateur n'est pas un acheteur.</h3>
		<?php
	}

}else if ($connected == false)
{
	header('Location: loginBuyer.php?id='.$_GET['id']);
	exit();
}else if ($connected == NULL)
{
	$connected = false;
	header('Location: loginBuyer.php?id='.$_GET['id']);
	exit();
}
?>
