<?php

require_once("../Première version ECEAmazon/hearder.php"); 
?>



<!DOCTYPE html>
<html>
<head>
	<title> ECE AMAZON</title>
	<meta charset="utf-8"/>
	<link rel="stylesheet" href="designaccueil.css" />
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<!-- Defilement automatique des images pour livre-->
<script type="text/javascript" >
$(document).ready(function(){
var $livres = $('#livres');
var $img = $('#livres img');
var $indexImg = $img.length - 1;
var i = 0; //compteur
var $currentImg = $img.eq(i); //image courante
$img.css('display', 'none');
$currentImg.css('display', 'block');
//quand on clique sur le bouton "suivant"
$('.next').click(function(){
i++;
if (i <= $indexImg){
$img.css('display', 'none');
$currentImg = $img.eq(i);
$currentImg.css('display', 'block');
} else {
i = $indexImg;
}
});

//defilement automatique
function slideImg(){
setTimeout(function() {
if (i < $indexImg) {
i++;
} else {
i = 0;
}
$img.css('display', 'none');
$currentImg = $img.eq(i);
$currentImg.css('display', 'block');
slideImg();
}, 4000);
}
slideImg();
});
</script>

<!-- Defilement automatique des images pour musique -->
<script type="text/javascript" >
$(document).ready(function(){
var $livres = $('#musique');
var $img = $('#musique img');
var $indexImg = $img.length - 1;
var i = 0; //compteur
var $currentImg = $img.eq(i); //image courante
$img.css('display', 'none');
$currentImg.css('display', 'block');
//quand on clique sur le bouton "suivant"
$('.next').click(function(){
i++;
if (i <= $indexImg){
$img.css('display', 'none');
$currentImg = $img.eq(i);
$currentImg.css('display', 'block');
} else {
i = $indexImg;
}
});

//defilement automatique
function slideImg(){
setTimeout(function() {
if (i < $indexImg) {
i++;
} else {
i = 0;
}
$img.css('display', 'none');
$currentImg = $img.eq(i);
$currentImg.css('display', 'block');
slideImg();
}, 4000);
}
slideImg();
});
</script>
<!-- Defilement automatique des images pour vetements -->
<script type="text/javascript" >
$(document).ready(function(){
var $livres = $('#vetements');
var $img = $('#vetements img');
var $indexImg = $img.length - 1;
var i = 0; //compteur
var $currentImg = $img.eq(i); //image courante
$img.css('display', 'none');
$currentImg.css('display', 'block');

//defilement automatique
function slideImg(){
setTimeout(function() {
if (i < $indexImg) {
i++;
} else {
i = 0;
}
$img.css('display', 'none');
$currentImg = $img.eq(i);
$currentImg.css('display', 'block');
slideImg();
}, 4000);
}
slideImg();
});
</script>


<!-- Defilement automatique des images pour sports et loisirs -->
<script type="text/javascript" >
$(document).ready(function(){
var $livres = $('#sportsloisirs');
var $img = $('#sportsloisirs img');
var $indexImg = $img.length - 1;
var i = 0; //compteur
var $currentImg = $img.eq(i); //image courante
$img.css('display', 'none');
$currentImg.css('display', 'block');

//defilement automatique
function slideImg(){
setTimeout(function() {
if (i < $indexImg) {
i++;
} else {
i = 0;
}
$img.css('display', 'none');
$currentImg = $img.eq(i);
$currentImg.css('display', 'block');
slideImg();
}, 4000);
}
slideImg();
});
</script>
<!-- fin du script-->
</head>
<body>

 
	 




<!-----------------Livres-------------------------->
<h1><a href="http://localhost/Première version ECEAmazon/livre.php"> Nos meilleures ventes "Livres"</a></h1>
<div id="livres">
	
<img src="livre1_probabilites.jpg" width="300" height="300">
<img src="livre2_analyse.jpg" width="300" height="300">
<img src="livre3_java.jpg" width="300" height="300">
</div>
<br>
<br>


<!----------------- Musique---------------------------->
<h1><a href="http://localhost/Première version ECEAmazon/musique.php"> Nos meilleures ventes "Musique"</a></h1>
<div id="musique">

<img src="musique1_relaxation.jpg" width="300" height="300">
<img src="musique2_meditation.jpg" width="300" height="300">
<img src="musique3_rock.jpg" width="300" height="300">
</div>
<br>
<br>

<!----------------Vetements----------------------------->

<h1><a href="http://localhost/Première version ECEAmazon/vetement.php"> Nos meilleures ventes "Vetements"</a></h1>
<div id="vetements"> 

<img src="vetement1_reveil.jpg" width="300" height="300">
<img src="vetement2_sciences.jpg" width="300" height="300">
<img src="vetement3_engineer.jpg" width="300" height="300">
<br>
<br>

</div>
<!------------------------------ Sports et Loisirs----------->
<h1><a href="http://localhost/Première version ECEAmazon/sport_loisir.php"> Nos meilleures ventes "Sports et Loisirs"</a></h1>
<div id="sportsloisirs"> 
<img src="loisir1_ski.jpg" width="300" height="300">
<img src="loisir2_espagne.jpg" width="300" height="300">
<br>
<br>


</div>



</body>
</html>
