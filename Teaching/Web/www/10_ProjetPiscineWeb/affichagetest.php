<?php 
session_start();
if(isset($_SESSION['email']))
{

  $tableauid = array();
  $tableauphoto= array();
  $tableaunom= array();
  $tableaudescrip=array();

  $database= "projetweb";
  $db_handle = mysqli_connect('localhost', 'root', '');
  $db_found = mysqli_select_db($db_handle, $database);

  
  if($db_found)
  {
    $result = mysqli_query($db_handle, "SELECT photos_item, id_item, nom_item, description_item FROM item "); 
  }
  else 
  {
    echo "Database not found";
  }
  while ($data = mysqli_fetch_assoc($result))
  {
       $tableauid[] = $data['id_item'];
       $tableauphoto[] =$data['photos_item'];
       $tableaunom[]= $data['nom_item'];
       $tableaudescrip[]=$data['description_item'];
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
<link rel="stylesheet" type="text/css" href="ajoutsuppitem.css"> 
<style type="text/css">
  .image
  {
    float: left;
     margin-right: 10px;
  }
</style> 

<!-- Pour retourner à la page admin --> 
<script type="text/javascript">
  function change()
  {
    window.location.href = "http://127.0.0.1/ProjetPiscineWeb/admin.php";
  }
</script>
</head>

<body>
   <div id="header">
    <div id="boutonadmin">
    <button onclick="change()">  Retour admin</button>
    </div>
    <form method="post" action="">
      <input type="submit" value="Liste Vendeur" class="btn float-left btn-vendeur" name="ajoutitem">
      <?php
        if (isset($_POST['ajoutitem'])) 
            {
                header('Location:http://127.0.0.1/ProjetPiscineWeb/listevendeur.php');
                exit();              
            }
      ?>
    </div>
      <!-- Le formulaire pour ajouter un objet --> 
    <div id="contenu">

        <h1>Formulaire d'ajout</h1>
          <div class="form-group row">
          <label class="col-sm-2 col-form-label">Nom de l'objet</label>
              <div class="col-sm-10">
              <input type="text" class="form-control" name="nom" placeholder="Nom de l'objet">
              </div>
          </div>

          <div class="form-group row">
          <label class="col-sm-2 col-form-label">Photo</label>
              <div class="col-sm-10">
              <input type="text" class="form-control" name="photo" placeholder="Url photo">
              </div>
          </div>

          <div class="form-group row">
              <label class="col-sm-2 col-form-label">Description</label>
              <div class="col-sm-10">
                  <textarea class="form-control form-control-sm" name="description" rows="2"> </textarea>
              </div>
          </div>

          <br>
          <p style="text-align: center;"> Pour ajouter une vidéo veuillez utiliser le lien partagé via youtube (intégrer) ou un autre site.</p> 
          <div class="form-group row">
              <label class="col-sm-2 col-form-label">Vidéo</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="video" placeholder="Url video">
                </div>
          </div>

          <div class="form-group row">
              <label class="col-sm-2 col-form-label">Category</label>
              <div class="col-sm-10">
                <select name="category">
                    <option value="Livre">Livre</option>
                    <option value="Vetement">Vetement</option>
                    <option value="Chanson">Chanson</option>
                    <option value="Sport_Loisir">Sport_Loisir</option> 
                </select>
              </div>
          </div>

        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Sous-Category</label>
              <div class="col-sm-10">
                <input type="text" class="form-control form-control-sm" id="sous_category" placeholder="Sous-Category">
              </div>
         </div>

        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Prix</label>
              <div class="col-sm-10">
                <input type="number" class="form-control form-control-sm" name="prix" placeholder="Prix" value="0">
              </div>
        </div>

        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Stock</label>
              <div class="col-sm-10">
                <input type="number" class="form-control form-control-sm" name="stock" placeholder="nombre d'objet" max="500" value="0">
              </div>
        </div>

        <div class="form-group">
            <input type="submit" class="btn btn-primary" value="Ajouter" name="envoie"></input>
             <?php
                 //Envoi des données
                 if (isset($_POST['envoie'])) 
                   {

                      $nom_objet =isset($_POST["nom"])? $_POST["nom"]: "";
                      $photo =isset($_POST["photo"])? $_POST["photo"]: "";
                      $description=isset($_POST["description"])? $_POST["description"]: "";
                      $video=isset($_POST["video"])? $_POST["video"]: "";
                      $category=isset($_POST["category"])? $_POST["category"]: "";
                      $sous_category=isset($_POST["sous_category"])? $_POST["sous_category"]: "";
                      $prix=isset($_POST["prix"])? $_POST["prix"]: 0;
                      $stock=isset($_POST["stock"])? $_POST["stock"]: 0;
                      $database= "projetweb";
                      $db_handle = mysqli_connect('localhost', 'root', '');
                      $db_found = mysqli_select_db($db_handle, $database);

                      if($db_found)
                      {
                        $sql = "INSERT INTO `item` (`id_item`,`nom_item`, `photos_item`, `description_item`, `video_item`, `categorie_item`, `sous_categorie`, `prix_item`, `stock_item`,`id_commande`, `email_admin`, `id_mesventes`, `email_client`) VALUES (DEFAULT,'$nom_objet', '$photo', '$description', '$video', '$category', '$sous_category', '$prix', '$stock',0,'',0,'')";
                      }
                      else 
                      {
                        echo "Database not found";
                      }

                      //Permet de rediriger la page vers la page admin.php et traitement de la requête SQL 
                      $result = mysqli_query($db_handle, $sql);
                      header('Location:http://127.0.0.1/ProjetPiscineWeb/admin.php');
                      exit();
                   }
              ?>
          </div>
        </form>
      </div>


      <!-- Affichage des données et possibilité de suppression --> 
      <div id="conteneur">

        <?php for($i=0;$i<count($tableauid);$i++) : ?>
          
          <div class="container">   
              <div class="row">
                  <div class="col-lg-12">
                    <div class="card bg-light">
                      <div class="thumbnail">
                        <!-- endroit où mettre les images venue de la database --> 
                        <div class="image">
                        <?php echo "<img src=  '$tableauphoto[$i]' width=300, height=200 >" ?>
                        </div>
                            
                        <div class="caption">
                        <br>
                            <h3 class= "ItemTitre"><?php echo $tableaunom[$i]; ?></h3>
                            <h5 class="descrip"><?php echo $tableaudescrip[$i]; ?></h5>
                        </div>
                          
                        <!-- Envoi vers la page delete.php --> 
                        <a href="delete.php?id=<?php echo $tableauid[$i];?>">Suppprimer</a>

                     </div>      
                  </div>
                  <br>
                </div>
            </div>
          </div>
         <?php endfor; ?>

</body>
</html>