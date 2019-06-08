<?php 
session_start();
if(isset($_SESSION['email']))
{

  $tableauid = array();
  $tableauphoto=array();
  $tableaunom=array();

  $database= "projetweb";
  $db_handle = mysqli_connect('localhost', 'root', '');
  $db_found = mysqli_select_db($db_handle, $database);
  
  if($db_found)
  {
    $result = mysqli_query($db_handle, "SELECT * FROM vendeur"); 
  }
  else 
  {
    echo "Database not found";
  }
  while ($data = mysqli_fetch_assoc($result))
  {
       $tableauid[] = $data['email_vendeur'];
       $tableauphoto[] =$data['photo_vendeur'];
       $tableaunom[]= $data['nom_vendeur'];
  }
 
}
else
{
  header('Location:http://127.0.0.1/ProjetPiscineWeb/menu_principale.php');
  exit();
}
?>

<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!DOCTYPE html>
<html>
<head>
<title>Formulaire</title>
<link rel="stylesheet" type="text/css" href="listevendeur.css"> 
<script type="text/javascript">
  function change()
  {
    window.location.href = "http://127.0.0.1/ProjetPiscineWeb/admin.php";
  }
</script>
</head>

<body>
   <div id="header">
    <form method="post" action="">
      <input type="submit" value="Liste objet" class="btn float-left btn-vendeur" name="ajoutvendeur">
      <?php
        if (isset($_POST['ajoutvendeur'])) 
            {
                header('Location:http://127.0.0.1/ProjetPiscineWeb/affichagetest.php');
                exit();              
            }
      ?>
    </form>
    </div>
    <div id="boutonadmin">
    <button onclick="change()">Retour admin</button>
    </div>
      <div id="contenu">
      <h1>Formulaire d'ajout Vendeur</h1>

      <form method="post" action="">
        <div class="form-group row">
        <label class="col-sm-2 col-form-label">Email du Vendeur</label>
            <div class="col-sm-10">
            <input type="text" class="form-control" name="mail" placeholder="Email">
            </div>
        </div>

        <form method="post" action="">
        <div class="form-group row">
        <label class="col-sm-2 col-form-label">Prenom du Vendeur</label>
            <div class="col-sm-10">
            <input type="text" class="form-control" name="prenom" placeholder="Preom du vendeur">
            </div>
        </div>

      <form method="post" action="">
        <div class="form-group row">
        <label class="col-sm-2 col-form-label">Nom du Vendeur</label>
            <div class="col-sm-10">
            <input type="text" class="form-control" name="nom" placeholder="Nom du vendeur">
            </div>
        </div>

        <form method="post" action="">
        <div class="form-group row">
        <label class="col-sm-2 col-form-label">Password</label>
            <div class="col-sm-10">
            <input type="text" class="form-control" name="mdp" placeholder="Password">
            </div>
        </div>

        <form method="post" action="">
        <div class="form-group row">
        <label class="col-sm-2 col-form-label">Photo de profil</label>
            <div class="col-sm-10">
            <input type="text" class="form-control" name="photoprofil" placeholder="Photo de profil">
            </div>
        </div>

        <form method="post" action="">
        <div class="form-group row">
        <label class="col-sm-2 col-form-label">Photo de fond</label>
            <div class="col-sm-10">
            <input type="text" class="form-control" name="photodefond" placeholder="Photo de fond">
            </div>
        </div>

    <div class="form-group">
      <input type="submit" class="btn btn-primary" value="Ajouter" name="envoi"></input>
      <?php
  if (isset($_POST['envoi'])) 
            {
              $email_vendeur=isset($_POST["mail"])? $_POST["mail"]: "";
              $prenom_vendeur=isset($_POST["prenom"])? $_POST["prenom"]: "";
              $nom_vendeur=isset($_POST["nom"])? $_POST["nom"]: "";
              $mdp=isset($_POST["mdp"])? $_POST["mdp"]: "";
              $photo_profil=isset($_POST["photoprofil"])? $_POST["photoprofil"]: "";
              $photo_fond=isset($_POST["photodefond"])? $_POST["photodefond"]: "";
              $database= "projetweb";
              $db_handle = mysqli_connect('localhost', 'root', '');
              $db_found = mysqli_select_db($db_handle, $database);

              if($db_found)
              {
                $sql = "INSERT INTO `vendeur`(`email_vendeur`,`prenom_vendeur`,`nom_vendeur`, `photo_vendeur`, `photo_fond`, `email`, `email_admin`, `id_ventes`) VALUES ('$email_vendeur', '$prenom_vendeur','$nom_vendeur','$photo_profil','$photo_fond','','',DEFAULT)";
                $sql2 = "INSERT INTO `connexion`(`email`,`password`,`type`,`email_admin`,`email_vendeur`,`email_acheteur`) VALUES ('$email_vendeur','$mdp','Vendeur','','','')";
              }
              else 
              {
                echo "Database not found";
              }

              $result = mysqli_query($db_handle, $sql);
              $result = mysqli_query($db_handle, $sql2);

              header('Location:http://127.0.0.1/ProjetPiscineWeb/admin.php');
              exit();
            }
   ?>
 </div>
    </form>
  </div>
   <div id="conteneur">
    <?php for($i=0;$i<count($tableauid);$i++) : ?>
      <div class="container">   
          <div class="row">
              <div class="col-lg-4">
                <div class="card bg-light">
            <div class="thumbnail">
              <!-- endroit où mettre les images venue de la database --> 
              <div class="image">
              <?php echo "<img src=  '$tableauphoto[$i]' width=300, height=200 >" ?>
              </div>
                        <div class="caption">
                          <br>
                          <h3 class= "ItemTitre"><?php echo $tableaunom[$i]; ?></h3>
                      </div>
                      <a href="deletevendeur.php?id=<?php echo $tableauid[$i];?>">Suppprimer</a>
                 </div>      
              </div>
              <br>
            </div>
    <?php endfor; ?>
   </div>
</body>
</html>