<!DOCTYPE html>

<?php include("header.php");?>

<?php session_start();?>

<html>
<head>
	<title>Connection / Inscription</title>
</head>

<div class="jumbotron">
		<div class="container">
		  <h1 class="display-3">Vous devez vous connecter en tant qu'acheteur!</h1>
		</div>
</div>

<body>

<div class="container-fluid" id="block_info">
	<p> Vous n'avez toujours pas de compte ? Rendez-vous sur la page <a href="../mon_compte/mon_compte.php">Votre Compte </a>pour en créer un !
	<p class="h2">Vos identifiants :</p>

	<form  id="emailForm" action="loginBuyerEXE.php?id=<?php echo $_GET['id'] ?>" method="POST" name="emailForm">
		<label for="user_name">Adresse email :</label> <input type="text" id="email" name="email" autofocus required><br>
		<label for="user_surname">Mot de Passe :</label> <input type="password" id="password" name="password" required><br>
		<input id="button" type="submit" name="submit" value="Valider" class="btn btn-primary btn-lg"><br>
	</form>

</div>

</body>
</html>