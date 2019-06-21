<!DOCTYPE html>
<!--
	Auteurs : Clément LARIVIERE	TD10
			  Théo MERCIER		TD04
			  Antoine PAINCHAUX TD01
-->
<html lang="fr">

<!--Header-->
<?php include("header.php");?>

<?php session_start(); ?>

<style>
#button_payment
{
	margin-top : 1%;
	margin-left : 1%;
	
}

#block_form
{
	diplay : block;
	margin-left : 10%;
}


</style>

<main role="main">
	
	<div class="jumbotron">
		<div class="container">
			
			<h1 class="display-3">Règlement de votre panier</h1>
		</div>
	</div>
	<div class="progress">
		<div class="progress-bar" role="progressbar" style="width: 100%" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100"></div>
	</div>
	<div class="container-fluid">
		<div id="block_form" class="form-group">
			<br>
			<h2>Étape 4 : Achat confirmé !</h2>
			<p> Un email de confirmation va vous être envoyé à <?php echo $_SESSION['email']; ?>. <br> Merci de votre visite et à bientôt !</p>
			<img alt="validation" height="auto" src="../../images/validation.gif" width="auto">
			<?php 
			$subject = "Reçu de votre Commande ECE Amazone";
			$message = 'Merci d\'avoir commandé avec ECE Amazone ! \n Commande Confirmée : \n Vous avez été débité de' . $_SESSION['prixTot']. '€ \n \n Nous souhaitons vous revoir bientôt ! \n Cordialement, \n L\'équipe d\'ECE Amazone';		
			mail ($_SESSION['email'] , $subject , $message );
			?>
		</div>
	</div>



	<?php 

	try
	{
		$bdd = new PDO('mysql:host=localhost;dbname=ece_amazon;charset=utf8', 'root', 'root');
	}
	catch (Exception $e)
	{
	      die('Erreur : ' . $e->getMessage());
	}


	$reponse = $bdd->query('SELECT id_item FROM cart WHERE emailBuyer="'.$_SESSION['email'].'"');	
	while ($donnees = $reponse->fetch())
	{
		$sql='UPDATE items SET quantity = quantity -1 WHERE id ='.$donnees['id_item'] ;
		$bdd->exec($sql);
	}

	$reponse1 = $bdd->query('SELECT * FROM cart INNER JOIN items ON cart.id_item=items.id WHERE emailBuyer="'.$_SESSION['email'].'"');
	while ($don = $reponse1->fetch())
	{
		$req = $bdd->prepare('INSERT INTO ordersHistory(buyer,productName, price) VALUES(:buyer,:productName, :price)');
		$req->execute(array(
		'buyer' => $_SESSION['email'],
		'productName' => $don['name'],
		'price' => $don['price']
		));

		$req = $bdd->prepare('INSERT INTO salesHistory(seller,productName, price,id_item) VALUES(:seller,:productName, :price,:id_item)');
		$req->execute(array(
		'seller' => $don['seller'],
		'productName' => $don['name'],
		'price' => $don['price'],
		'id_item' => $don['id']
		));
	}

	$sql1='DELETE FROM cart WHERE emailBuyer ="'.$_SESSION['email'].'"';

	$bdd->exec($sql1);



	$bdd = null;


	?>


</main>

<!--Footer-->
<?php include("footer.php");?>

</html>