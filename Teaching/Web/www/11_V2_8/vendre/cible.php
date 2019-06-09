<?php 

if ($_GET['choix']=='livre')
{
	header('Location: ajoutLivre.php');
	exit();
} 
elseif($_GET['choix']=='musique')
{
	header('Location: ajoutMusic.php');
	exit();

}
elseif($_GET['choix']=='vetement')
{
	header('Location: ajoutVet.php');
	exit();
}
elseif($_GET['choix']=='spo_act')
{
	header('Location: ajoutSpo_Act.php');
	exit();
}

?>