<?php 

	session_start();
	$mail= $_SESSION['email'];
	
	$tabCarte = array();

	$id=$_GET["id"];
	$database= "projetweb";
	$db_handle = mysqli_connect('localhost', 'root', '');
	$db_found = mysqli_select_db($db_handle, $database);
 
	if($db_found)
	{
	  $resultCarte = mysqli_query($db_handle, 'SELECT * FROM carte_bancaire WHERE `email_client` = "'.$mail.'" '); 
	}
	else 
	{
	  echo "Database not found";
	}
	while ($rowCarte = mysqli_fetch_array($resultCarte, MYSQLI_ASSOC))
	{
		//Besoin de récupérer les données pour les comparer 
	    $tabCarte[] = $rowCarte;
	} 
	//for($i=0;$i< count($tableautout) ;$i++) : 


?> 



<!-- DEsign from https://bootsnipp.com/snippets/v8j0A --> 
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<div>
 		<?php require "navbar.php"; ?> 	
</div>
<html>
    <head>
        <title> Payment Check </title>
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha256-k2/8zcNbxVIh5mnQ52A0r3a6jAgMGxFJFE2707UxGCk= sha512-ZV9KawG2Legkwp3nAlxLIVFudTauWuBpC10uEafMHYL0Sarrz5A7G79kXh5+5+woxQ5HM559XX2UZjMJ36Wplg==" crossorigin="anonymous">
    </head>

    <body style="font-family: 'Open Sans', sans-serif;">
    

    <div class="container">
        <div class="centered title"><h1> Payment </h1></div>
     </div>

     <!-- Pour le trait de division entre les div -->                           
     <hr class="featurette-divider"></hr>
	<form action="" method= "post" >
        <div class="container">

            <div class="row">
                <div class="col-md-6">

               	 	<div class="tab-content">
  					            
				       <br><br><br>
				       		<div class="form-group row">
				                <label class='control-label'> <h4> <strong> Nom du détenteur </strong>  </h4></label>
				                <input class='form-control' name="nom" type='text'>
			            	</div>
			            	<br>
				  			
			                <div class="form-group row">
				                <label class='control-label'> <h4> <strong> Numéros de la carte</strong>  </h4> </label>
				                <input autocomplete='off' name="numCarte" class='form-control card-number' size='20' type='text'>
			            	</div>

			                <br>


			                <div class="form-group row">
				            	<select name="type">
									<OPTION value= "Visa"> <h4> <strong> VISA </strong> </h4> </OPTION> 
									<OPTION value= "Mastercard" >  <h4>Mastercard </h4> </OPTION> 
					  			</select>
         					</div>
				  			
				  			<br>
				  			<br>
			           		<div class="col-sm-6 col-md-6 col-lg-6 ">

			           			<div class='form-group'>
			                		<label class='control-label'> <h4> <strong>Cryptogramme </strong>   </h4> </label>
				               		<input autocomplete='off' name="crypto" class='form-control card-cvc' placeholder='ex. 311' size='4' type='text'>
			            		</div>
			            		
				                <div class='form-group '>
					                <label class='control-label'> <h4> Expiration: </h4> </label>
					                <input class='form-control' name="expiration" placeholder='MM-AAAA' size='7' type='text'>
				            	</div>
			           		</div>

			           		<div class="form-group">
			            	<input type="submit" class="btn btn-primary btn btn-primary btn-lg btn-block" value="Continue →" name="envoie"> </input>
			            	 <?php
			                 //Envoi des données
			                 if (isset($_POST['envoie'])) 
			                   {

			                   	//Nom
			                      $nom_carte =isset($_POST["nom"])? $_POST["nom"]: "";
			                    //Numeros de carte 
			                      $num_carte =isset($_POST["numCarte"])? $_POST["numCarte"]: "";
			                    //Type de la carte
			                      $type_carte =isset($_POST["type"])? $_POST["type"]: "";
			                    //Cryprogramme
			                      $crypto_carte =isset($_POST["crypto"])? $_POST["crypto"]: "";
			                    //Expiration 
			                      $expiration_carte =isset($_POST["expiration"])? $_POST["expiration"]: "";
			                   
			                   	//recherche dans toutes les cartes du client 
			                      for($i=0;$i< count($tabCarte) ;$i++) :
			                      	
				                      //Compare si la carte rentré est la bonne.
				                      if ( $nom_carte    == $tabCarte[$i]['nom_affiche'] 
				                      	&& $num_carte    == $tabCarte[$i]['numero_carte']
										&& $type_carte   == $tabCarte[$i]['type']
										&& $crypto_carte == $tabCarte[$i]['code']
										&& $expiration_carte == $tabCarte[$i]['expiration'])
				                      	{
				                      		//Action à réaliser si bonne carte 
				                      		echo " C'est bien votre carte ! "; 
				                      	}

			                  	  endfor;
			                   }
			              ?>
            	</div>

			          
			         
              		</div>
        
               	<br><br><br>
                  
            	</div>
     			<br>
		        <div class="col-lg-6">
		         
			        <br><br>
			         
			        <div class="alert alert-info"">Please choose your method of payment and hit continue. You will then be sent down to pay using your selected payment option.</div>
			     
	          		<br><br><br>
	         
		         	<div class="jumbotron jumbotron-flat">
		    			<div class="center"><h2><i>Total à payer:</i></h2></div>
		           		<div class="paymentAmt"> <?php echo $id; ?>  €</div>
		        	</div>
		        	<hr class="featurette-divider"></hr>
		        	<div style="text-align: center; ">
		        		<img src="https://www.soudage.pro/wp-content/uploads/2016/12/logo-cb-300x300.png" class="img-thumbnail">
		        	</div>
		        	
        		</div>
				<br>

               	
					
            </div> 
            <br>
            <br>


            </form>
            <br>
            <br>

          	<hr class="featurette-divider"></hr>
        </div>

    </form>

    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>

    <footer class="page-footer">
		<div class="container">
			<div class="row">
		
				<div class="col-lg-8 col-md-8 col-sm-12">
					<h6 class="text-uppercase font-weight-bold"> Information additionnelle</h6>
					<p>
						Ce site a été conçu dans le cadre du projet piscine 2019. Il a été conçu par les enseignants: Hina Manolo, JP Segado, Elisabeth Rendler et toute l’équipe du projet « piscine » de web dynamique. Que la force soit avec nous et bonne nage !! *bloubloublou*
					</p>

					<p>
						Une piscine est un bassin artificiel, étanche, rempli d'eau et dont les dimensions permettent à un être humain de s'y plonger au moins partiellement. Une piscine se différencie d'une cuve ou d'une baignade par ses équipements de filtration (pompe, filtre...). Il existe différents types de piscine dont les caractéristiques varient en fonction de leurs destinations  et de leur usage.
					</p>
				</div>

				<div class="col-lg-4 col-md-4 col-sm-12">
					<h6 class="text-uppercase font-weightbold">Contact</h6>
					<p>
						37, quai de Grenelle, 75015 Paris, France <br>
						info@webDynamique.ece.fr <br>
						+33 01 02 03 04 05 <br>
						+33 01 03 02 05 04
					</p>
				</div>

			</div>
	
		<div class="footer-copyright text-center">&copy; 2019 Copyright | Droit
			d'auteur: webDynamique.ece.fr</div>
	</footer>
     

    </body>
</html>