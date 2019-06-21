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
            footer
            {
                background: green;
                font-size: 60%;
            }
            
        </style>
    </head>
    <body>
        <div id="logo"><img src="ECEamazon.png" alt="ECEamazon" /></div>
        
        <div style= "background-color : red; position: sticky; top: 0;">
            <a class = "navtext" href="index.php">Home</a>
            <a class = "navtext" href="selcategorie.php">Categories</a>
            <a class = "navtext" href="VenteFlash.php">Vente flash</a>
            <a class = "navtext" href="Vendre.php">Vendre</a>
            <a class = "active" href="Compte.php">Votre compte</a>
            <a class = "navtext" href="Panier.php">Panier</a>
            <a class = "navtext" href="Admin.php">Admin</a>
        </div>
        <div>
            <h1> Créer un nouveau compte </h1>
            <form action="fonction_nouvel_utilisateur.php" method="post">
                <table>
                    <tr>
                        <td>Adresse mail :</td>
                        <td><input type="text" name="mail"/></td>
                    </tr>
                    <tr>
                        <td>Mot de passe :</td>
                        <td><input type="text" name="mdp"/></td>
                    </tr>
                     <tr>
                        <td>Nom :</td>
                        <td><input type="text" name="nom"/></td>
                    </tr>
                     <tr>
                        <td>Prenom :</td>
                        <td><input type="text" name="prenom"/></td>
                    </tr>
                     <tr>
                        <td>Numero de telephoone :</td>
                        <td><input type="text" name="telephone"/></td>
                    </tr>
                     <tr>
                        <td>Adresse :</td>
                        <td><input type="text" name="adresse"/></td>
                    </tr>
                    <tr>
                        <td>Type de carte :</td>
                        <td><input type="text" name="type_carte"/></td>
                    </tr>
                    <tr>
                        <td>Possesseur de la carte :</td>
                        <td><input type="text" name="nomcarte"/></td>
                    </tr>

                    <tr>
                        <td>Numero de la carte :</td>
                        <td><input type="number" name="numerocarte"/></td>
                    </tr>
                    <tr>
                        <td>Type de carte :</td>
                        <td><input type="text" name="typecarte"/></td>
                    </tr>
                     <tr>
                        <td>Date d'expiration de la carte :</td>
                        <td><input type="date" name="datecarte"/></td>
                    </tr>
                     <tr>
                        <td>Code de securite de la carte (code de 3 ou 4 chiffres au dos de votre carte) :</td>
                        <td><input type="number" name="codecarte"/></td>
                    </tr>
                    <tr>
                        <td colspan="2"><input type="submit" value="Valider"/></td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
    <footer>
         ECE_AMAZON.COM © tous droits reserves <br>
        2019 Flimon Zachary, Therre Mikhali, Brunelle Sebastien <br>
        Pour toute demande d'information/ signalement de problème de fonctionnement, merci de contacter l'administrateur du site a l'adresse
        <a href="Admin@gmail.com"> Admin@gmail.com </a>
    </footer>
</html>