<?php
session_start();
?>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!DOCTYPE html>
<html>
<head>
	<title>Login Page</title>

	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">

	<link rel="stylesheet" type="text/css" href="loginstyle.css">

	

</head>
<body>

<div class="conteneur">

	<!-- class d-flex bootstrap permet d'ordonner le conteneur au centre avec une hauteur -100pixels--> 
	<div class="d-flex justify-content-center h-100">
		<div id="box">
			<div id="haut">
				<h3>Connectez-vous</h3>
			</div>
			<div id="contenu">
				<form action="" method="POST">
					<!-- icone + champ utilisateur -->
					<div class="input-group form-group">
						<!-- prepend place l'icone avant le champ -->
						<div class="input-group-prepend">
							<!-- affiche l'icone web -->
							<span class="input-group-text"><i class="fas fa-at"></i></span>
						</div>
						<input type="text" class="form-control" placeholder="username" name="email">
						
					</div>

					<!-- icone + password -->
					<div class="input-group form-group">
						<!-- prepend place l'icone avant le champ -->
						<div class="input-group-prepend">
							<!-- affiche l'icone web -->
							<span class="input-group-text"><i class="fas fa-unlock"></i></span>
						</div>
						<input type="password" class="form-control" placeholder="password" name="mdp">
					</div>

					<div class="form-group">
						<input type="submit" value="Login" class="btn float-right btn-log" name="soumis">
						<?php
						if (isset($_POST['soumis'])) 
						{
								//Requête SQL pour les BDD 
							$mail =isset($_POST["email"])? $_POST["email"] : "";
							$mdp = isset($_POST["mdp"])? $_POST["mdp"] : "";
							$database= "projetweb";
							$db_handle = mysqli_connect('localhost', 'root', '');
        					$db_found = mysqli_select_db($db_handle, $database);

        					if($db_found)
							{
								$sql = "SELECT * FROM `connexion`";
							}
							else 
							{
								echo "Database not found";
							}

							$result = mysqli_query($db_handle, $sql);

							if (mysqli_num_rows($result) == 0) 
							{
								echo "connexion not found";
							} 
							else 
							{
								//Boucle permettant de vérifier si l'email entré est un:
								while ($data = mysqli_fetch_assoc($result)) 
								{
									//Admin
									if($data['email']==$mail && $data['password']==$mdp && $data['type']=="Admin")
									{
										$_SESSION['email'] = $mail;
										header('Location: http://127.0.0.1/ProjetPiscineWeb/admin.php');
										exit();
									}
									//Client 
									if($data['email']==$mail && $data['password']==$mdp && $data['type']=="Client")
									{
										$_SESSION['email'] = $mail;
										header('Location: http://127.0.0.1/ProjetPiscineWeb/menu_principal.php');
									}
									//Vendeur
									if($data['email']==$mail && $data['password']==$mdp && $data['type']=="Vendeur")
									{
										$_SESSION['email'] = $mail;
										header('Location: http://127.0.0.1/ProjetPiscineWeb/vendeur.php');
									}

								}
							}
						}
						?>
					</div>

					<div class="form-group">
						<input type="submit" value="Inscription" class="btn float-left btn-log" name="inscription">
						<?php
							if (isset($_POST['inscription'])) 
							{
								header('Location: http://127.0.0.1/ProjetPiscineWeb/inscription.php');
								exit();
							}
						?>
					</div>
					
				</form>
			</div>
		</div>
	</div>
</div>
</body>
</html>