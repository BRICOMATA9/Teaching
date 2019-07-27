<%@ page import="java.sql.*" import="Service.ServiceEmploi"
	import="Model.*"%>
<%@ page import="javax.sql.*" import="java.util.*"
	import="java.util.Date" import="java.text.*"
	import= "java.util.Map.Entry"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<style type="text/css">

.ds_box {
	background-color: #FFF;
	border: 1px solid #000;
	position: absolute;
	z-index: 32767;
}

.ds_tbl {
	background-color: #FFF;
}

.ds_head {
	background-color: #333;
	color: #FFF;
	font-family: Arial, Helvetica, sans-serif;
	font-size: 13px;
	font-weight: bold;
	text-align: center;
	letter-spacing: 2px;
}

.ds_subhead {
	background-color: #CCC;
	color: #000;
	font-size: 12px;
	font-weight: bold;
	text-align: center;
	font-family: Arial, Helvetica, sans-serif;
	width: 32px;
}

.ds_cell {
	background-color: #EEE;
	color: #000;
	font-size: 13px;
	text-align: center;
	font-family: Arial, Helvetica, sans-serif;
	padding: 5px;
	cursor: pointer;
}

.ds_cell:hover {
	background-color: #F3F3F3;
} /* This hover code won't work for IE */

</style>


<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>.:: Emploi du temps &agrave; l'IFI ::.</title>
<style type="text/css">
<!--
.Style2 {color: #333333}
a:link {
	text-decoration: none;
	color: #000000;
}
a:visited {
	text-decoration: none;
}
a:hover {
	text-decoration: none;
}
a:active {
	text-decoration: none;
}
.Style3 {
	color: #FFFFFF;
	font-family: Arial, Helvetica, sans-serif;
	font-weight: bold;
}
.Style4 {color: #000000}
.Style8 {color: #333333; font-size: 12px; }
.Style11 {
	font-family: "Times New Roman", Times, serif;
	color: #AD0432;
	font-size: 12px;
}
-->
</style>
<script type="text/JavaScript">
<!--
function MM_jumpMenu(targ,selObj,restore){ //v3.0
  eval(targ+".location='"+selObj.options[selObj.selectedIndex].value+"'");
  if (restore) selObj.selectedIndex=0;
}
//-->
</script>
</head>

<body><center>
<table width="" height="380" border="0" bordercolor="#000000" style="border:1px:solid">
  <tr>
    <td width="1114" height="100"><img src="img/bannerEDT1.png" width="1106" /></td>
  </tr>
  <tr valign="top">
    <td height="10" bgcolor="#99BDC9">&nbsp;</td>
    </tr>
  <tr valign="top">
  <td height="178"><table width="1115" height="227" border="0">
    <tr bgcolor="#AD0432">
      <td width="672" height="21" class="Style3">Administration</td>
      <td width="433" class="Style3"><center>
        Emploi du temps de l'IFI 
      </center></td>
    </tr>
	<tr valign="top">
      <td width="672" height="200" class="Style3"><form action="" method="get"><table width="669" border="0">
        <tr>
          <td width="147">&nbsp;</td>
          <td width="512"> </td>
        </tr>
        <tr>
          <td><span class="Style4">&nbsp;id Seance </span></td>
          <td><label>
            <input type="text" name="textfield" width="140"/>
          </label></td>
        </tr>
        <tr>
          <td ><span class="Style4">&nbsp;Module</span></td>
          <td><label><select name="menu1" style="width : 180">
              <option >Choisir le module</option>
			              </select>
            
          </label></td>
        </tr>
		<tr>
          <td width="147"><span class="Style4">&nbsp;Date</span></td>
          <td width="512"><label>
          <input onclick="ds_sh(this);" name="date" readonly="readonly" style="cursor: text" />
          </label></td>
        </tr>
        <tr>
          <td><span class="Style4">&nbsp;Heure</span></td>
          <td><label>
            <select name="menu2" style="width : 180">
              <option s>Trenche d'heures</option>
            </select>
          </label></td>
        </tr>
        <tr>
          <td ><span class="Style4">&nbsp;Emploi du temps </span></td>
          <td><select name="menu3" onchange="MM_jumpMenu('parent',this,0)">
            <option>&nbsp; Choisir  l'Emploi</option>
          </select></td>
        </tr>
        <tr>
          <td height="21" colspan="2"><span class="Style4"></span>            <table width="495" border="0">
            <tr>
              <td width="489"><hr /></td>
            </tr>
          </table>            </td>
          </tr>
		
		 <tr>
          <td height="51" colspan="2"><span class="Style4"></span>            <table width="404" border="0">
            <tr>
              <td width="191"><label>
               <center> <input type="submit" name="Submit" value="Enregistrer" /> </center>
              </label></td>
              <td width="203"><label>
                <center><input type="reset" name="Submit2" value="Annuler" /></center>
              </label></td>
            </tr>
          </table>            
            <label>            </label></td>
          </tr>
      </table>
          </form>
          <form action="cours.html" method="post"><table width="669" border="0"><table class="ds_box" cellpadding="0" cellspacing="0" id="ds_conclass" style="display: none;">
<tr><td id="ds_calclass">
</td></tr>
</table>

<script type="text/javascript">
// <!-- <![CDATA[

// Project: Dynamic Date Selector (DtTvB) - 2006-03-16
// Script featured on JavaScript Kit- http://www.javascriptkit.com
// Code begin...
// Set the initial date.
var ds_i_date = new Date();
ds_c_month = ds_i_date.getMonth() + 1;
ds_c_year = ds_i_date.getFullYear();

// Get Element By Id
function ds_getel(id) {
	return document.getElementById(id);
}

// Get the left and the top of the element.
function ds_getleft(el) {
	var tmp = el.offsetLeft;
	el = el.offsetParent
	while(el) {
		tmp += el.offsetLeft;
		el = el.offsetParent;
	}
	return tmp;
}
function ds_gettop(el) {
	var tmp = el.offsetTop;
	el = el.offsetParent
	while(el) {
		tmp += el.offsetTop;
		el = el.offsetParent;
	}
	return tmp;
}

// Output Element
var ds_oe = ds_getel('ds_calclass');
// Container
var ds_ce = ds_getel('ds_conclass');

// Output Buffering
var ds_ob = ''; 
function ds_ob_clean() {
	ds_ob = '';
}
function ds_ob_flush() {
	ds_oe.innerHTML = ds_ob;
	ds_ob_clean();
}
function ds_echo(t) {
	ds_ob += t;
}

var ds_element; // Text Element...

var ds_monthnames = [
'Janvier', 'Février', 'Mars', 'Avril', 'Mai', 'Juin',
'Juillet', 'Aout', 'Septembre', 'Octobre', 'Novembre', 'Décembre'
]; // You can translate it for your language.

var ds_daynames = [
'Dim', 'Lun', 'Mar', 'Me', 'Jeu', 'Ven', 'Sam'
]; // You can translate it for your language.

// Calendar template
function ds_template_main_above(t) {
	return '<table cellpadding="3" cellspacing="1" class="ds_tbl">'
	     + '<tr>'
		 + '<td class="ds_head" style="cursor: pointer" onclick="ds_py();">&lt;&lt;</td>'
		 + '<td class="ds_head" style="cursor: pointer" onclick="ds_pm();">&lt;</td>'
		 + '<td class="ds_head" style="cursor: pointer" onclick="ds_hi();" colspan="3">[Fermer]</td>'
		 + '<td class="ds_head" style="cursor: pointer" onclick="ds_nm();">&gt;</td>'
		 + '<td class="ds_head" style="cursor: pointer" onclick="ds_ny();">&gt;&gt;</td>'
		 + '</tr>'
	     + '<tr>'
		 + '<td colspan="7" class="ds_head">' + t + '</td>'
		 + '</tr>'
		 + '<tr>';
}

function ds_template_day_row(t) {
	return '<td class="ds_subhead">' + t + '</td>';
	// Define width in CSS, XHTML 1.0 Strict doesn't have width property for it.
}

function ds_template_new_week() {
	return '</tr><tr>';
}

function ds_template_blank_cell(colspan) {
	return '<td colspan="' + colspan + '"></td>'
}

function ds_template_day(d, m, y) {
	return '<td class="ds_cell" onclick="ds_onclick(' + d + ',' + m + ',' + y + ')">' + d + '</td>';
	// Define width the day row.
}

function ds_template_main_below() {
	return '</tr>'
	     + '</table>';
}

// This one draws calendar...
function ds_draw_calendar(m, y) {
	// First clean the output buffer.
	ds_ob_clean();
	// Here we go, do the header
	ds_echo (ds_template_main_above(ds_monthnames[m - 1] + ' ' + y));
	for (i = 0; i < 7; i ++) {
		ds_echo (ds_template_day_row(ds_daynames[i]));
	}
	// Make a date object.
	var ds_dc_date = new Date();
	ds_dc_date.setMonth(m - 1);
	ds_dc_date.setFullYear(y);
	ds_dc_date.setDate(1);
	if (m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12) {
		days = 31;
	} else if (m == 4 || m == 6 || m == 9 || m == 11) {
		days = 30;
	} else {
		days = (y % 4 == 0) ? 29 : 28;
	}
	var first_day = ds_dc_date.getDay();
	var first_loop = 1;
	// Start the first week
	ds_echo (ds_template_new_week());
	// If sunday is not the first day of the month, make a blank cell...
	if (first_day != 0) {
		ds_echo (ds_template_blank_cell(first_day));
	}
	var j = first_day;
	for (i = 0; i < days; i ++) {
		// Today is sunday, make a new week.
		// If this sunday is the first day of the month,
		// we've made a new row for you already.
		if (j == 0 && !first_loop) {
			// New week!!
			ds_echo (ds_template_new_week());
		}
		// Make a row of that day!
		ds_echo (ds_template_day(i + 1, m, y));
		// This is not first loop anymore...
		first_loop = 0;
		// What is the next day?
		j ++;
		j %= 7;
	}
	// Do the footer
	ds_echo (ds_template_main_below());
	// And let's display..
	ds_ob_flush();
	// Scroll it into view.
	ds_ce.scrollIntoView();
}

// A function to show the calendar.
// When user click on the date, it will set the content of t.
function ds_sh(t) {
	// Set the element to set...
	ds_element = t;
	// Make a new date, and set the current month and year.
	var ds_sh_date = new Date();
	ds_c_month = ds_sh_date.getMonth() + 1;
	ds_c_year = ds_sh_date.getFullYear();
	// Draw the calendar
	ds_draw_calendar(ds_c_month, ds_c_year);
	// To change the position properly, we must show it first.
	ds_ce.style.display = '';
	// Move the calendar container!
	the_left = ds_getleft(t);
	the_top = ds_gettop(t) + t.offsetHeight;
	ds_ce.style.left = the_left + 'px';
	ds_ce.style.top = the_top + 'px';
	// Scroll it into view.
	ds_ce.scrollIntoView();
}

// Hide the calendar.
function ds_hi() {
	ds_ce.style.display = 'none';
}

// Moves to the next month...
function ds_nm() {
	// Increase the current month.
	ds_c_month ++;
	// We have passed December, let's go to the next year.
	// Increase the current year, and set the current month to January.
	if (ds_c_month > 12) {
		ds_c_month = 1; 
		ds_c_year++;
	}
	// Redraw the calendar.
	ds_draw_calendar(ds_c_month, ds_c_year);
}

// Moves to the previous month...
function ds_pm() {
	ds_c_month = ds_c_month - 1; // Can't use dash-dash here, it will make the page invalid.
	// We have passed January, let's go back to the previous year.
	// Decrease the current year, and set the current month to December.
	if (ds_c_month < 1) {
		ds_c_month = 12; 
		ds_c_year = ds_c_year - 1; // Can't use dash-dash here, it will make the page invalid.
	}
	// Redraw the calendar.
	ds_draw_calendar(ds_c_month, ds_c_year);
}

// Moves to the next year...
function ds_ny() {
	// Increase the current year.
	ds_c_year++;
	// Redraw the calendar.
	ds_draw_calendar(ds_c_month, ds_c_year);
}

// Moves to the previous year...
function ds_py() {
	// Decrease the current year.
	ds_c_year = ds_c_year - 1; // Can't use dash-dash here, it will make the page invalid.
	// Redraw the calendar.
	ds_draw_calendar(ds_c_month, ds_c_year);
}

// Format the date to output.
function ds_format_date(d, m, y) {
	// 2 digits month.
	m2 = '00' + m;
	m2 = m2.substr(m2.length - 2);
	// 2 digits day.
	d2 = '00' + d;
	d2 = d2.substr(d2.length - 2);
	// YYYY-MM-DD
//	return y + '-' + m2 + '-' + d2;
	return d2 + '-' + m2 + '-' + y;
}

// When the user clicks the day.
function ds_onclick(d, m, y) {
	// Hide the calendar.
	ds_hi();
	// Set the value of it, if we can.
	if (typeof(ds_element.value) != 'undefined') {
		ds_element.value = ds_format_date(d, m, y);
	// Maybe we want to set the HTML in it.
	} else if (typeof(ds_element.innerHTML) != 'undefined') {
		ds_element.innerHTML = ds_format_date(d, m, y);
	// I don't know how should we display it, just alert it to user.
	} else {
		alert (ds_format_date(d, m, y));
	}
}

// And here is the end.

// ]]> -->
</script>



Veuillez entrez une date : <br />


<table width="670" border="0">
            <tr>
              <td width="184">&nbsp;</td>
              <td width="476">&nbsp;</td>
            </tr>
          </table> </form>
	    <table width="670" border="0">
          <tr>
            <td class="Style11">&nbsp;</td>
          </tr>
          <tr>
            <td class="Style8">&nbsp;</td>
          </tr>
		   <tr>
            <td class="Style11">Projet con&ccedil;u dans le cadre du cours de Genie logiciel avanc&eacute; </td>
          </tr>
          <tr>
            <td class="Style8">Par : Ha, Selain, Tuan et Rip </td>
          </tr>
        </table></td>
      <td width="433" class="Style3"><h1 style="font-family:Verdana,Arial; font-weight:normal">Calendrier du mois</h1>
 
<center><script type="text/javascript">
<!--
var d = new Date();
var dm = d.getMonth() + 1;
var dan = d.getYear();
if(dan < 999) dan+=1900;
calendrier(dm,dan);
 
function calendrier(mois,an) {
nom_mois = new Array
("Janvier","F&eacute;vrier","Mars","Avril","Mai","Juin","Juillet",
"Ao&ucirc;t","Septembre","Octobre","Novembre","D&eacute;cembre");
jour = new Array ("Lu","Ma","Me","Je","Ve","Sa","Di");
 
var police_entete = "Verdana,Arial"; /* police entête de calendrier  */
var taille_pol_entete = 3;           /* taille de police 1-7 entête de calendrier  */
var couleur_pol_entete = "#FFFF00";     /* couleur de police entête de calendrier  */
var arrplan_entete = "#000066";        /* couleur d'arrière plan entête de calendrier  */
var police_jours = "Verdana,Arial"; /* police affichage des jours  */
var taille_pol_jours = 3;           /* taille de police 1-7 affichage des jours  */
var coul_pol_jours = "#000000";     /* couleur de police affichage des jours  */
var arrplan_jours = "#D0F0F0";        /* couleur d'arrière plan affichage des jours  */
var couleur_dim = "red";        /* couleur de police pour dimanches  */
var couleur_cejour = "#FFFF00";        /* couleur d'arrière plan pour aujourd'hui  */
 
var maintenant = new Date();
var ce_mois = maintenant.getMonth() + 1;
var cette_annee = maintenant.getYear();
if(cette_annee < 999) cette_annee+=1900;
var ce_jour = maintenant.getDate();
var temps = new Date(an,mois-1,1);
var Start = temps.getDay();
if(Start > 0) Start--;
else Start = 6;
var Stop = 31;
if(mois==4 ||mois==6 || mois==9 || mois==11 ) --Stop;
if(mois==2) {
 Stop = Stop - 3;
 if(an%4==0) Stop++;
 if(an%100==0) Stop--;
 if(an%400==0) Stop++;
}
document.write('<table border="3" cellpadding="1" cellspacing="1">');
var entete_mois = nom_mois[mois-1] + " " + an;
inscrit_entete(entete_mois,arrplan_entete,couleur_pol_entete,taille_pol_entete,police_entete);
var nombre_jours = 1;
for(var i=0;i<=5;i++) {
  document.write("<tr>");
  for(var j=0;j<=5;j++) {
    if((i==0)&&(j < Start))
     inscrit_cellule("&#160;",arrplan_jours,coul_pol_jours,taille_pol_jours,police_jours);
    else {
      if(nombre_jours > Stop)
        inscrit_cellule("&#160;",arrplan_jours,coul_pol_jours,taille_pol_jours,police_jours);
      else {
        if((an==cette_annee)&&(mois==ce_mois)&&(nombre_jours==ce_jour))
         inscrit_cellule(nombre_jours,couleur_cejour,coul_pol_jours,taille_pol_jours,police_jours);
        else
         inscrit_cellule(nombre_jours,arrplan_jours,coul_pol_jours,taille_pol_jours,police_jours);
        nombre_jours++;
        }
      }
    }
    if(nombre_jours > Stop)
      inscrit_cellule("&#160;",arrplan_jours,couleur_dim,taille_pol_jours,police_jours);
    else {
      if((an==cette_annee)&&(mois==ce_mois)&&(nombre_jours==ce_jour))
        inscrit_cellule(nombre_jours,couleur_cejour,couleur_dim,taille_pol_jours,police_jours);
      else
        inscrit_cellule(nombre_jours,arrplan_jours,couleur_dim,taille_pol_jours,police_jours);
      nombre_jours++;
    }
    document.write("<\/tr>");
  }
document.write("<\/table>");
}
 
function inscrit_entete(titre_mois,couleurAP,couleurpolice,taillepolice,police) {
document.write("<tr>");
document.write('<td align="center" colspan="7" valign="middle" bgcolor="'+couleurAP+'">');
document.write('<font size="'+taillepolice+'" color="'+couleurpolice+'" face="'+police+'"><b>');
document.write(titre_mois);
document.write("<\/b><\/font><\/td><\/tr>");
document.write("<tr>");
for(var i=0;i<=6;i++)
  inscrit_cellule(jour[i],couleurAP,couleurpolice,taillepolice,police);
document.write("<\/tr>");
}
 
function inscrit_cellule(contenu,couleurAP,couleurpolice,taillepolice,police) {
document.write('<td align="center" valign="middle" bgcolor="'+couleurAP+'">');
document.write('<font size="'+taillepolice+'" color="'+couleurpolice+'" face="'+police+'"><b>');
document.write(contenu);
document.write("<\/b><\/font><\/td>");
}
//-->
</script></center>
</td>
    </tr>
  </table></td>
    </tr>
  <tr>
    <td bgcolor="#3399FF"><div align="right"><span class="Style2"><a href="index.jsp">Home</a> | <a href="index.html">Admin </a> </span></div></td>
  </tr>
</table>
</center>
</body>
</html>
