

<link rel="stylesheet" type="text/css" href="jolie.css">

	<div class="container">   
			    <div class="row">

			    
			    	<?php if ( $i < count($tableautout) ) { ?> 

					<div class="col-sm-6 col-md-4 col-lg-4 mt-3">
				       <div class="card card-inverse card-info">
		                    <?php echo '<img src='.$tableautout[$i]['photos_item'].' class="img-thumbnail" >' ; ?> 
		                    <div class="card-block">
		                        
		                        <center>
		                        <h4 class="card-title"> <?php echo $tableautout[$i]['nom_item'] ?> </h4>
		                       	</center>

		                    </div>
		                    <div class="card-footer">
		                        <small> <h5 id ="Prix"> <strong>  <strong> <?php echo $tableautout[$i]['prix_item']." $" ?> </strong> </strong>  </h5> </small>
		                        <a href="Item.php?id= <?php echo $tableautout[$i]['id_item'] ?>">
			                        <button class="btn btn-info btn-block"> 
			                        	Details
			                         </button>
		                        </a>

		                    </div>
	                	</div>
	                </div>

			        <?php $i++ ?>
					<?php } ?>

					<?php if ( $i < count($tableautout) ) { ?> 
			    	
			    <div class="col-sm-6 col-md-4 col-lg-4 mt-3">
			       <div class="card card-inverse card-info">
	                    <?php echo '<img src='.$tableautout[$i]['photos_item'].' class="img-thumbnail" >' ; ?> 
	                    <div class="card-block">

	                        <center>
	                        <h4 class="card-title"> <?php echo $tableautout[$i]['nom_item'] ?> </h4>
	                        </center>
	                        
	                    </div>
	                    <div class="card-footer">
	                        <small>  <h5>  <strong> <?php echo $tableautout[$i]['prix_item']." $" ?> </strong> </h5> </small>
	                        <a href="Item.php?id= <?php echo $tableautout[$i]['id_item'] ?>">
		                        <button class="btn btn-info btn-block"> 
		                        	Details
		                         </button>
	                        </a>

	                    </div>
                	</div>
                </div>

			        <?php $i++ ?>
			        <?php }  ?> 

			        <?php if ( $i < count($tableautout) ) { ?> 
			    	
			    <div class="col-sm-6 col-md-4 col-lg-4 mt-3">
			       <div class="card card-inverse card-info">
	                    <?php echo '<img src='.$tableautout[$i]['photos_item'].' class="img-thumbnail" >' ; ?> 
	                    <div class="card-block">

	                        <center>
	                        <h4 class="card-title"> <?php echo $tableautout[$i]['nom_item'] ?> </h4>
	                        </center>

	                    </div>
	                    <div class="card-footer">
	                        <small> <h5>  <strong> <?php echo $tableautout[$i]['prix_item']." $" ?> </strong> </h5> </small>
	                        <a href="Item.php?id= <?php echo $tableautout[$i]['id_item'] ?>">
		                        <button class="btn btn-info btn-block"> 
		                        	Details
		                         </button>
	                        </a>

	                    </div>
                	</div>
                </div>
                
			    	<?php } ?> 
			        
			    
			    
			       
			    </div>

	</div>
