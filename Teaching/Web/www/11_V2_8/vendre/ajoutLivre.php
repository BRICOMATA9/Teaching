<!DOCTYPE html>
<html>

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
		  <h1 class="display-3">Informations du livre que vous souhaitez vendre :</h1>
		</div>
</div>

<body class="container-fluid">
	<div id="block_form" class="form-group">
	
		<form action="ajoutLivreExe.php" method="post">
			<table>
				<tr>
				<td><label for="name">Nom : </label></td>
				<td><input type="text" name="name" autofocus required /></td>
				</tr>

				<tr>
				<td><label for="price">Prix : </td>
				<td><input type="text" name="price" required /></td>
				</tr>

				<tr>
				<td><label for="shape">Etat : </td>
				<td><input type="text" name="shape" required /></td>
				</tr>

				<tr>
				<td><label for="description">Description : </td>
				<td><input type="text" name="description" required /></td>
				</tr>

				<tr>
				<td><label for="videoLink">Lien vidéo : </td>
				<td><input type="text" name="videoLink" /></td>
				</tr>

				<tr>
				<td><label for="quantity">Quantité : </td>
				<td><input type="text" name="quantity" required /></td>
				</tr>

				<tr>
				<td><label for="author">Auteur : </td>
				<td><input type="text" name="author" required /></td>
				</tr>

				<tr>
				<td><label for="editor">Éditeur : </td>
				<td><input type="text" name="editor" required /></td>
				</tr>

				<tr>
				<td><label for="nbPage">Nombre de pages : </td>
				<td><input type="text" name="nbPage"required  /></td>
				</tr>

				<tr>
				<td><label for="size">Taille : </td>
				<td><input type="text" name="size" required /></td>
				</tr>

				<tr>
				<td><label for="langue">Langue : </td>
				<td><input type="text" name="langue" required /></td>
				</tr>

				<tr>
				<td><label for="reDate">Date de sortie : </td>
				<td><input type="text" name="reDate" required  /></td>
				</tr>

				<tr>
				<td><label for="category">Catégorie : </td>
				<td><input type="text" name="category" required /></td>
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