<?php

    //recuperer les données venant de la page HTML
    //le parametre de $_POST = "name" de <input> de votre page HTML

    $email = isset($_POST["email"])? $_POST["email"] : "";
    $motdepasse = isset($_POST["motdepasse"])? $_POST["motdepasse"] : "";

    //identifier votre BDD
    $database = "testzone";

    //connectez-vous dans votre BDD
    //Rappel: votre serveur = localhost et votre login = root et votre password = <rien>

    $db_handle = mysqli_connect('localhost', 'root', '');
    $db_found = mysqli_select_db($db_handle, $database);

    if ($_POST["connexion"]) {

        if ($db_found) {

            $sql = "SELECT * FROM utilisateur";

            if ($email != "") {

            //on cherche le livre avec les paramètres titre et auteur

                $sql .= " WHERE Email LIKE '%$email%'";

                if ($motdepasse != "") {

                    $sql .= " AND Mot_de_passe LIKE '%$motdepasse%'";
                }
            }

            $result = mysqli_query($db_handle, $sql);

            //regarder s'il y a de résultat
            if (mysqli_num_rows($result) == 0) {
                //le livre recherché n'existe pas
                echo "Email ou Mot de passe incorecte";
            } 

            else {

                //on trouve le livre recherché
                while ($data = mysqli_fetch_assoc($result)) {

                    echo "Bienvenue Mr " . $data['Nom'] . "<br>";
                    if($data["Modeconnexion"] == 0){
                        header('Location: Accueil_Acheteur.html');
  exit();
                        ##Redirection mode acheteur
                    }
                    if($data["Modeconnexion"] == 1){
                        header('Location: Accueil_Vendeur.html');
                        ##Redirection mode vendeur
                    }
                }
            }
        } 

        else {
        echo "Database not found";
        }
    }

    //fermer la connexion
    mysqli_close($db_handle);

?>
