<!DOCTYPE html>
<html>
<head>
	<style>
            .navtext {
                color : blue;
                font-size: 300%;
                padding: 2px;
                text-decoration : none;
            }
            .navtext:hover {
                background-color: lightblue;
            }
            .active {
                background-color: #4CAF50;
                color : blue;
                font-size: 300%;
                padding: 2px;
                text-decoration : none;
            }
            
            #logo
            {
                background-color : red;
                width : max-width;
                height : 100;
            }
            .fenetre {
                width :200 px;
                height : 200 px;
                border-style: solid;
                border-width: 1px;
                margin : 5 px;
            }
            footer
            {
                background: green;
                font-size: 60%;
            }
            
        </style>
</head>
<body>
	<?php
        session_start();
        ?>
        <div id="logo"><img src="ECEamazon.png" alt="ECEamazon" /></div>
        
        <div style= "background-color : red; position: sticky; top: 0;">
            <a class = "navtext" href="index.php">Home</a>
            <a class = "navtext" href="selcategorie.php">Categories</a>
            <a class = "navtext" href="VenteFlash.php">Vente flash</a>
            <a class = "navtext" href="Vendre.php">Vendre</a>
            <a class = "navtext" href="Compte.php">Votre compte</a>
            <a class = "navtext" href="Panier.php">Panier</a>
            <a class = "active" href="AdminGeston.php">Admin</a>
        </div>

	<form action="ajoutervendeur.php" method="post">
		Nom: <input type="text" name="nom">	<br>
		Prenom: <input type="text" name="prenom"> <br>
		Mail: <input type="text" name="mail"> <br>
		Mot de passe: <input type="text" name="mdp"> <br>
		Photo de couverture: <input type="text" name="photocouv"> <br>
		Photo: <input type="text" name="photo"> <br>
		<input type="submit" value="Ajouter le vendeur">
	</form>
	</body>
    <footer>
         ECE_AMAZON.COM © tous droits reserves <br>
        2019 Flimon Zachary, Therre Mikhali, Brunelle Sebastien <br>
        Pour toute demande d'information/ signalement de problème de fonctionnement, merci de contacter l'administrateur du site a l'adresse
        <a href="Admin@gmail.com"> Admin@gmail.com </a>
    </footer>
</html>
