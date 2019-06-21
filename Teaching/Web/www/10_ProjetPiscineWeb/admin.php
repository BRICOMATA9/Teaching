<?php
  //Partie Bootstrap
  session_start();

  //Si une personne est connéctée 
  if(isset($_SESSION['email']))
  {
    //Vérification si c'est vraiment un admin.
    $nom_admin =isset($_POST["nom_admin"])? $_POST["nom_admin"] : "";
    $database= "projetweb";
    $db_handle = mysqli_connect('localhost', 'root', '');
    $db_found = mysqli_select_db($db_handle, $database);

    if($db_found)
    {
      $sql = "SELECT * FROM `admin`";
    }
    else 
    {
      echo "Database not found";
    }

    $result = mysqli_query($db_handle, $sql);
    //Verification de la bonne réception des données
    if (mysqli_num_rows($result) == 0) 
    {
        echo "admin not found";
    } 
    else 
    {
      //Récupération du nom du/des admin(s)
      while ($data = mysqli_fetch_assoc($result)) 
      {
        $nom_admin=$data["nom_admin"];
      }
    }
  }
  else
  {
    //Si non redirection menu principale  
    header('Location:http://127.0.0.1/ProjetPiscineWeb/menu_principale.php');
  }

?>
<!-- Bootstrap --> 
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="admin.css">

<body>
   <div id="header">
      <form method="post" action="">

        <!-- Bouton permettant de se déconnecter de Admin --> 
        <input type="submit" value="Deconnexion" class="btn float-left" name="deconnexion">
        <?php
        if (isset($_POST['deconnexion'])) 
        {
            header('Location:http://127.0.0.1/ProjetPiscineWeb/deconnexion.php');
            exit();
        }
        ?>
        <!-- Contenue de la banderole du haut  --> 
        <h1>Bienvenue dans la page Administrateur</h1>

      </form>
   </div>


   <div id="conteneur">
       <!-- Permet d'afficher les données de l'admniiqtrateur --> 
      <div id="liste">
          <ul>
            <br>
               <li>
                   Nom de l'administrateur: <?php echo $nom_admin?>
               </li>
            <br>
              <li>
                  Email administrateur: <?php echo $_SESSION['email'];?>
              </li>
          </ul>
      </div>
      <br><br>

      <!-- Affiche le bouton pour afficher les items --> 
      <div class="d-flex justify-content-center">
        <form method="post" action="">
          <input type="submit" value="Ajouter ou supprimer un Item" class="btn float-right btn-ajout" name="ajoutitem">
            <?php
              if (isset($_POST['ajoutitem'])) 
                  {
                    header('Location:http://127.0.0.1/ProjetPiscineWeb/affichagetest.php');
                    exit();
                  }
            ?>
        </form>
      </div>
      <br><br>

      <!-- Affiche le bouton pour afficher la liste des vendeurs --> 
      <div class="d-flex justify-content-center">
        <form method="post" action="">
          <input type="submit" value="Ajouter ou supprimer un vendeur" class="btn float-right btn-ajout" name="vendeur">
            <?php
              if (isset($_POST['vendeur'])) 
                  {
                    //Redirection vers la page de la liste des vendeurs  -->  
                    header('Location:http://127.0.0.1/ProjetPiscineWeb/listevendeur.php');
                    exit();
                  }
            ?>
        </form>
      </div>

   </div>
</body>