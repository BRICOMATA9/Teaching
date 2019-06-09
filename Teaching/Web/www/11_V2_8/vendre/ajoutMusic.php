<!DOCTYPE html>
<html lang="fr">

<?php include("header.php");?>
<style>
	#block_form
	{
		display : block;
		width : 10rem;
		padding-left: 80px;

		
	}
	#button_form
	{
		padding-left: 300px;
		
		float:left;
		display : block;
	}
	.container-fluid
	{
		padding-left : 0px;
		padding-right : 0px;
	}
	label
	{
		text-align : right;
		margin-right: 20px;
		width : 200px;
		display : block;
	}
</style>

<div class="jumbotron">
		<div class="container-fluid">
		  <h1 class="display-3">Informations du disque que vous souhaitez vendre :</h1>
		</div>
</div>

<body class="container-fluid">
	<div id="block_form" class="form-group">
		<form action="ajoutMusicExe.php" method="post">
			<table>
				<tr>
				<td><label for="name">Nom :</label></td>
				<td><input type="text" name="name" autofocus required /></td>
				</tr>

				<tr>
				<td><label for="price">Prix :</label></td>
				<td><input type="text" name="price" required /></td>
				</tr>

				<tr>
				<td><label for="shape">État :</label></td>
				<td><input type="text" name="shape" required /></td>
				</tr>

				<tr>
				<td><label for="description">Description :</label></td>
				<td><input type="text" name="description" required /></td>
				</tr>

				<tr>
				<td><label for="videoLink">Lien vidéo :</label></td>
				<td><input type="text" name="videoLink" /></td>
				</tr>

				<tr>
				<td><label for="quantity">Quantité :</label></td>
				<td><input type="text" name="quantity" required /></td>
				</tr>

				<tr>
				<td><label for="artist">Artiste :</label></td>
				<td><input type="text" name="artist" required /></td>
				</tr>

				<tr>
				<td><label for="label">Label :</label></td>
				<td><input type="text" name="label" required /></td>
				</tr>

				<tr>
				<td><label for="reDate">Date de sortie :</label></td>
				<td><input type="text" name="reDate" required /></td>
				</tr>

				<tr>
				<td><label for="genre">Genre :</label></td>
				<td><input type="text" name="genre" required /></td>
				</tr>

				<tr>
				<td><label for="type">Type :</label></td>
				<td><input type="text" name="type" required /></td>
				</tr>
				

			</table>
	</div>
		
	<div id="button_form">
		<p>
			<br>
			<input id="button" type="submit" name="submit" value="Valider" class="btn btn-primary btn-lg"><br>
		</p>
	</div>
	</form>
</body>

<!-- Footer -->
<?php include("footer.php");?>

</html>