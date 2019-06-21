<?php
session_start();

$bdd = new PDO('mysql:host=127.0.0.1;dbname=ece_amazon', 'root', '');

if(isset($_SESSION['id'])) {
   $requser = $bdd->prepare("SELECT * FROM comptes WHERE ID = ?");
   $requser->execute(array($_SESSION['id']));
   $infoscompte = $requser->fetch();
   if(isset($_POST['newpseudo']) AND !empty($_POST['newpseudo']) AND $_POST['newpseudo'] != $infoscompte['Pseudonyme']) {
      
      $newpseudo = htmlspecialchars($_POST['newpseudo']);
      $insertpseudo = $bdd->prepare("UPDATE comptes SET Pseudonyme = ? WHERE ID = ?");
      $insertpseudo->execute(array($newpseudo, $_SESSION['id']));
      header('Location: profil.php?id='.$_SESSION['id']);
   }
   if(isset($_POST['newmail']) AND !empty($_POST['newmail']) AND $_POST['newmail'] != $infoscompte['Email']) {
      $newmail = htmlspecialchars($_POST['newmail']);
      $insertmail = $bdd->prepare("UPDATE comptes SET Email = ? WHERE ID = ?");
      $insertmail->execute(array($newmail, $_SESSION['id']));
      header('Location: profil.php?id='.$_SESSION['id']);
   }
   if(isset($_POST['newphone']) AND !empty($_POST['newphone']) AND $_POST['newphone'] != $infoscompte['Telephone']) {
      
      $newphone = htmlspecialchars($_POST['newphone']);
      $insertphone = $bdd->prepare("UPDATE comptes SET Telephone = ? WHERE ID = ?");
      $insertphone->execute(array($newphone, $_SESSION['id']));
      header('Location: profil.php?id='.$_SESSION['id']);
   }
   if(isset($_POST['newadresse']) AND !empty($_POST['newadresse']) AND $_POST['newadresse'] != $infoscompte['Adresse']) {
      
      $newadresse = htmlspecialchars($_POST['newadresse']);
      $insertadresse = $bdd->prepare("UPDATE comptes SET Adresse = ? WHERE ID = ?");
      $insertadresse->execute(array($newadresse, $_SESSION['id']));
      header('Location: profil.php?id='.$_SESSION['id']);
   }
   if(isset($_POST['newville']) AND !empty($_POST['newville']) AND $_POST['newville'] != $infoscompte['Ville']) {
      
      $newville = htmlspecialchars($_POST['newville']);
      $insertville = $bdd->prepare("UPDATE comptes SET Ville = ? WHERE ID = ?");
      $insertville->execute(array($newville, $_SESSION['id']));
      header('Location: profil.php?id='.$_SESSION['id']);
   }
   if(isset($_POST['newpays']) AND !empty($_POST['newpays']) AND $_POST['newpays'] != $infoscompte['Pays']) {
      
      $newpays = htmlspecialchars($_POST['newpays']);
      $insertpays = $bdd->prepare("UPDATE comptes SET Pays = ? WHERE ID = ?");
      $insertpays->execute(array($newpays, $_SESSION['id']));
      header('Location: profil.php?id='.$_SESSION['id']);
   }
   if(isset($_POST['newmdp1']) AND !empty($_POST['newmdp1']) AND isset($_POST['newmdp2']) AND !empty($_POST['newmdp2'])) {
      $mdp1 = htmlspecialchars($_POST['newmdp1']);
      $mdp2 = htmlspecialchars($_POST['newmdp2']);
      if($mdp1 == $mdp2) {
         $insertmdp = $bdd->prepare("UPDATE comptes SET MotDePasse = ? WHERE ID = ?");
         $insertmdp->execute(array($mdp1, $_SESSION['id']));
         header('Location: profil.php?id='.$_SESSION['id']);
      } else {
         $msg = "Vos deux mdp ne correspondent pas !";
      }
   }
    if(isset($_FILES['photoprofil']) AND !empty($_FILES['photoprofil']['name'])) {
      $tailleMax = 2097152;
      $extensionsValides = array('jpg', 'jpeg', 'png');
      if($_FILES['photoprofil']['size'] <= $tailleMax) {
         $extensionUpload = strtolower(substr(strrchr($_FILES['photoprofil']['name'], '.'), 1));
         if(in_array($extensionUpload, $extensionsValides)) {
            $chemin = "photosprofil/".$_SESSION['id'].".".$extensionUpload;
            $resultat = move_uploaded_file($_FILES['photoprofil']['tmp_name'], $chemin);
            if($resultat) {
               $updateavatar = $bdd->prepare('UPDATE comptes SET PhotoProfil = :photoprofil WHERE ID = :id');
               $updateavatar->execute(array(
                  'photoprofil' => $_SESSION['id'].".".$extensionUpload,
                  'id' => $_SESSION['id']
                  ));
               header('Location: profil.php?id='.$_SESSION['id']);
            } else {
               $msg = "Erreur durant l'importation de votre photo de profil";
            }
         } else {
            $msg = "Votre photo de profil doit être au format jpg, jpeg, gif ou png";
         }
      } else {
         $msg = "Votre photo de profil ne doit pas dépasser 2Mo";
      }
    }
    if(isset($_FILES['photobg']) AND !empty($_FILES['photobg']['name']))
    {
      $tailleMax = 2097152;
      $extensionsValides = array('jpg', 'jpeg', 'png');
      if($_FILES['photobg']['size'] <= $tailleMax) {
         $extensionUpload = strtolower(substr(strrchr($_FILES['photobg']['name'], '.'), 1));
         if(in_array($extensionUpload, $extensionsValides)) {
            $chemin = "photosbackground/".$_SESSION['id'].".".$extensionUpload;
            $resultat = move_uploaded_file($_FILES['photobg']['tmp_name'], $chemin);
            if($resultat) {
               $updateavatar = $bdd->prepare('UPDATE comptes SET PhotoBack = :photobg WHERE ID = :id');
               $updateavatar->execute(array(
                  'photobg' => $_SESSION['id'].".".$extensionUpload,
                  'id' => $_SESSION['id']
                  ));
               header('Location: profil.php?id='.$_SESSION['id']);
            } else {
               $msg = "Erreur durant l'importation de votre photo de background";
            }
         } else {
            $msg = "Votre photo de background doit être au format jpg, jpeg, gif ou png";
         }
      } else {
         $msg = "Votre photo de background ne doit pas dépasser 2Mo";
      }
    }
?>

<html>
<head>
   <title>Edition Profil</title>
   <meta charset="utf-8">
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <link rel="stylesheet"
   href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
   <link rel="stylesheet" type="text/css" href="vente.css">
   <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
   <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
   <script type="text/javascript">
       $(document).ready(function(){
       $('.header').height($(window).height());
       });
   </script>
</head>
<body>
<nav class="navbar navbar-expand-md">      
    <a href = "accueil.php"><img class="Eceamazon" src="images/logo.png" width="80" height="80"></a>
    <div class="collapse navbar-collapse" id="main-navigation">
        <ul class="navbar-nav">
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">Catégories</a>
                <div class="dropdown-menu">
                    <a class="dropdown-item" href="categories.php?type=Livre">Livres</a>
                    <a class="dropdown-item" href="categories.php?type=Musique">Musique</a>
                    <a class="dropdown-item" href="categories.php?type=Vetement">Vêtements</a>
                    <a class="dropdown-item" href="categories.php?type=Loisir">Sports & Loisir</a>
                    <a class="dropdown-item" href="categories.php?type=All">Toutes les catégories</a>
                </div>
            </li>
            <li class="nav-item dropdown" >
                <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">Ventes flash</a>
                <div class="dropdown-menu">
                    <a class="dropdown-item" href="venteflash.php">Livres</a>
                    <a class="dropdown-item" href="venteflash.php">Musique</a>
                    <a class="dropdown-item" href="venteflash.php">Vêtements</a>
                    <a class="dropdown-item" href="venteflash.php">Sports & Loisir</a>
                    <a class="dropdown-item" href="venteflash.php">Toutes les catégories</a>
                </div>
            </li>
            <li class="nav-item"><a class="nav-link" href="vente.php">Vendre</a></li>
            <li class="nav-item"><a class="nav-link" href = "profil.php?id=<?php echo $_SESSION['id'] ?>"><img  width="50" height="50" src="images/team.png"></a></li>
            <li class="nav-item"><a class="nav-link" href = "panier.php"><img  width="50" height="50" src="images/cart.png"></a></li>
        </ul>
    </div>
</nav>

   <div id="section">

       <div align="center">
         <h2>Edition de mon profil</h2>
         <div align="left">

            <form method="POST" action="" enctype="multipart/form-data">
               <table>
         <tr>
                <td>Pseudo : </td>
                <td> <input class="form-control" type="text" name="newpseudo" placeholder="Pseudo" value="<?php echo $infoscompte['Pseudonyme']; ?>" >
                </td>
            </tr>
         <tr>
            <td>Mail : </td>   
            <td><input class="form-control" type="text" name="newmail" placeholder="Mail" value="<?php echo $infoscompte['Email']; ?>" >
            </td>
            
                
         </tr>
         <tr>
            <td>Téléphone: </td>   
            <td><input class="form-control" type="text" name="newphone" placeholder="Phone" value="<?php echo $infoscompte['Telephone']; ?>" >
            </td>
            
                
         </tr>
         <tr>
            <td>Adresse : </td>   
            <td><input class="form-control" type="text" name="newadresse" placeholder="Adresse" value="<?php echo $infoscompte['Adresse']; ?>" >
            </td>
            
                
         </tr>
         <tr>
            <td>Ville : </td>   
            <td><input class="form-control" type="text" name="newville" placeholder="Ville" value="<?php echo $infoscompte['Ville']; ?>">
            </td>
            
                
         </tr>
               <tr>
            <td>Pays : </td>   
            <td><input class="form-control" type="text" name="newpays" placeholder="Pays" value="<?php echo $infoscompte['Pays']; ?>" >
            </td>
            
                
         </tr>

         </tr>
               <tr>
            <td>Mot de passe :</td>   
            <td><input class="form-control" type="password" name="newmdp1" placeholder="Mot de passe">
            </td>
            
                
         </tr>

         </tr>
               <tr>
            <td>Confirmation - mot de passe :</td>   
            <td><input class="form-control" type="password" name="newmdp2" placeholder="Confirmation du mot de passe">
            </td>
            
                
         </tr>

         </tr>
               <tr>
            <td>Photo de Profil : </td>   
            <td><input class="form-control" type="file" name="photoprofil"></td>
         </tr>
       </tr>
            <tr>
            <td>Photo de Fond : </td>   
            <td><input class="form-control" type="file" name="photobg"></td>
         </tr>
         <tr>
               <td>
               <input class="btn btn-outline-primary" type="submit" value="Mettre à jour mon profil !">
            </td>
         </tr>
        
         
          </table>
            </form>
            <?php if(isset($msg)) { echo $msg; } ?>
         </div>

   </div>

   
<footer class="page-footer">
   <div class="container">
      <div class="row">
         <div class="col-lg-8 col-md-8 col-sm-12">
            <h6 class="text-uppercase font-weight-bold">Information additionnelle</h6>
            <p>
               Info1
            </p>
            <p>
               Info2
            </p>
         </div>
         <div class="col-lg-4 col-md-4 col-sm-12">
            <h6 class="text-uppercase font-weight-bold">Contact</h6>
            <p>
               37, quai de Grenelle, 75015 Paris, France <br>
               info@webDynamique.ece.fr <br>
               +33 01 02 03 04 05 <br>
               +33 01 03 02 05 04
            </p>
         </div>
      </div>
   </div>
   <div class="footer-copyright text-center">&copy; 2019 Copyright | Droit d'auteur: webDynamique.ece.fr</div>
</footer>
      
</body>
</html>
<?php   
}
else {
   header("Location: connexion.php");
}
?>
