
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

//quand on clique sur le bouton "précédent"
$('.prev').click(function(){
i--;
if (i >= 0){
$img.css('display', 'none');
$currentImg = $img.eq(i);
$currentImg.css('display', 'block');
} else {
i = 0;
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

//quand on clique sur le bouton "précédent"
$('.prev').click(function(){
i--;
if (i >= 0){
$img.css('display', 'none');
$currentImg = $img.eq(i);
$currentImg.css('display', 'block');
} else {
i = 0;
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

<script type="text/javascript" >
$(document).ready(function(){
var $livres = $('#vetements');
var $img = $('#vetements img');
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

//quand on clique sur le bouton "précédent"
$('.prev').click(function(){
i--;
if (i >= 0){
$img.css('display', 'none');
$currentImg = $img.eq(i);
$currentImg.css('display', 'block');
} else {
i = 0;
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



<script type="text/javascript" >
$(document).ready(function(){
var $livres = $('#sportsloisirs');
var $img = $('#sportsloisirs img');
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

//quand on clique sur le bouton "précédent"
$('.prev').click(function(){
i--;
if (i >= 0){
$img.css('display', 'none');
$currentImg = $img.eq(i);
$currentImg.css('display', 'block');
} else {
i = 0;
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
<!-- finnnnnnnnnnnnnnnnnnnnnnn-->
</head>
<body>


	 










</body>
</html>