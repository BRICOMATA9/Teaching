<?php

require_once("../Première version ECEAmazon/hearder.php");
?>


<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Panier</title>
	
	<link rel="stylesheet" type="text/css" href="panier.css">

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
    






<?php




$variable =$_GET["var"];

if($variable )
{
	$database = "gestion";

    $db_found = new mysqli("localhost","root",  "", $database );

    if ($db_found) {

		$tfk = $db_found->prepare('SELECT * FROM article WHERE iD = ?');
		$tfk->bind_param('s', $variable);
		$tfk->execute();

		

		$resulta = $tfk->get_result();

		if ($resulta->num_rows > 0) {
			
			while ( $db_field = $resulta->fetch_assoc() ) {

?>
           <div id="container">
           <div id="ligne1" class="ligne">
				<div id="colonne11" class="colonne">Votre panier</div>
				<div id="colonne22" class="colonne">description</div>
				<div id="colonne33" class="colonne">Prix</div>
				<div id="colonne44" class="colonne">Quantité</div>
				<div id="colonne55" class="colonne">Sous Total</div>
			</div>

			<div id="ligne2" class="ligne">
				<div id="colonne11" class="colonne"><?php print $db_field['image'] . "<BR>";?></div>
				<div id="colonne22" class="colonne"><?php print $db_field['nom'] . "<BR>";?><br/><?php print $db_field['description'] . "<BR>";?></div>
				<div id="colonne33" class="colonne"><?php print $db_field['prix'] . "<BR>";?>€</div>
				<form method="post" action="panier.php">
				<div id="colonne44" class="colonne"><select name="nombre" id="qtite">
					<option value='addi'>1</option>
					<option value='multi'>2</option>
					<option value='div'>3</option>
					<option value='sous'>4</option>
					<option value='addi'>5</option>
                    <option value='multi'>6</option>
                    <option value='div'>7</option>
                    <option value='sous'>8</option>
                    <option value='addi'>9</option>
                    <option value='multi'>10</option>
				   </select>
				</div>
				<div id="colonne55">Total: <br/><input type="button" name="commandea" value="Passer la commande"></div></form>
			</div>
		   </div>

			
	       
<?php
				
				$nombre=$_POST['nombre'];
				
                
                //test si on appuie sur le bouton
                if (isset($_POST['commandea']))
                 {
                          //on recupère la donnée stock
                          $sql=$db_found->prepare('SELECT stock from article WHERE iD=?');
                          $sql->bind_param('s',$variable);
                          $sql->execute();
                          $res=$sql->get_result();
                          $res1=$res-$nombre;
	
    	                  $sql1="UPDATE article Set stock='$res1'WHERE (iD='$variable'))";
		                  $res=mysqli_query($db_handle,$sql);
		                  $donnee=mysqli_fetch_array($res);
		                  if ($donnee)

		                 {

			                    header('Location:votre_comptepaiement.php');
		                 }
                 }



			}
		}
     }

}
else{

?>Le panier est vide!!!!!!!!
<?php
}


/* ICI, NOUS AURIONS DU AVOIR LA DECREMENTATION DU STOCK MAIS CELA N'EST PAS POSSIBLE CAR NOUS AURIONS DU UTILISER SESSION ET NOUS NOUS EN SOMMES RENDUES COMPTE QUE BIEN TROP TARD
$nombre=$_POST["nombre"];

// connection à la base de données
$database = "gestion";

// connection base de données

$db_handle = mysqli_connect('localhost', 'root', '');
$db_found = mysqli_select_db($db_handle, $database);

if (isset($_POST["commandea"]))
{
     $sql=$db_found->prepare('SELECT stock from article WHERE iD=?');
     $sql->bind_param('s',$variable);
     $sql->execute();
     $res=$sql->get_result();
     $res1=$res-$nombre;
	
    	$sql1="UPDATE article Set stock='$res1'WHERE (iD='$variable'))";
		$res=mysqli_query($db_handle,$sql);
		$donnee=mysqli_fetch_array($res);
		if ($donnee)

		{

			header('Location:payement.php');
		}
}
*/





































?>


</body>
</html>