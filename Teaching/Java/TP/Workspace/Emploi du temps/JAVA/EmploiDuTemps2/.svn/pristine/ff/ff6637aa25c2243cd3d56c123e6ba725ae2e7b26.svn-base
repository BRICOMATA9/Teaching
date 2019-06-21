
<%@ page import="java.sql.*" import="Service.ServiceEmploi"
	import="Model.*"%>
<%@ page import="javax.sql.*" import="java.util.*"
	import="java.util.Date" import="java.text.*"
	import= "java.util.Map.Entry"%>
<jsp:useBean id="afficheModule" class="Model.Module" scope="request" />

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
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
.Style8 {color: #333333; font-size: 12px; }
.Style11 {
	font-family: "Times New Roman", Times, serif;
	color: #AD0432;
	font-size: 12px;
}
.Style12 {color: #FFFFFF}
.Style17 {font-size: 14px; color: #000000;}
.Style18 {font-size: 16px}
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
<%//Find Emploi de classe
List<String> listNameClasse = new ArrayList<String>();
List<String> listNamePromotion = new ArrayList<String>();
List<Module> listAllModule = new ArrayList<Module>();
ServiceEmploi service = new ServiceEmploi();
SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
SimpleDateFormat formatT = new SimpleDateFormat("HH:mm:ss");
listNamePromotion = service.findNameOfAllPromotion();
listNameClasse = service.findNameOfAllClasse();
String string1 = listNamePromotion.get(Integer.parseInt(request
		.getParameter("menu1")) - 1);
String string2 = listNameClasse.get(Integer.parseInt(request
		.getParameter("menu2")) - 1);
EmploiDuTemps emploi = new EmploiDuTemps();
emploi = service.findEmploiByPromotionAndClasse(string1, string2);
Calendar cal = Calendar.getInstance();
Date date = new Date();
cal.setTime(date);
int WEEK_OF_YEAR=cal.get(Calendar.WEEK_OF_YEAR);
cal.set(Calendar.DAY_OF_WEEK, 1);
Date[] daysOfWeek = new Date[7];
for (int i = 0; i < 7; i++) {
    daysOfWeek[i] = cal.getTime();
    cal.add(Calendar.DAY_OF_MONTH, 1);
}
 %>

<table width="" height="380" border="0" bordercolor="#000000" style="border:1px:solid">
  <tr>
    <td width="1114" height="100"><img src="img/bannerEDT1.png" width="1106" /></td>
  </tr>
  <tr valign="top">
    <td height="10" bgcolor="#99BDC9">
          </td>
    </tr>
  <tr valign="top">
  <td height="178"><table width="1120" height="227" border="0">
    <tr bgcolor="#3399FF">
      <td width="1114" height="21" bgcolor="#3399FF" class="Style3"><%out.println(string2);%></td>
      </tr>
	<tr valign="top">
      <td width="1114" height="200" class="Style3"><table width="1116" border="0">
        <tr>
          <td width="1110" colspan="2">&nbsp;</td>
          </tr>
		  <tr>
          <td colspan="2"><table width="1111" border="1" bordercolor="#666666">
            <tr>
              <td width="81" bgcolor="#0066FF"><span class="Style12">heures</span></td>
              <td width="159" bgcolor="#0066FF"><span class="Style12">Lundi <%out.println(format.format(daysOfWeek[1]));%> </span></td>
              <td width="179" bgcolor="#0066FF"><span class="Style12">Mardi <%out.println(format.format(daysOfWeek[2]));%> </span></td>
              <td width="180" bgcolor="#0066FF"><span class="Style12">Mercredi <%out.println(format.format(daysOfWeek[3]));%> </span></td>
              <td width="151" bgcolor="#0066FF"><span class="Style12">Jeudi <%out.println(format.format(daysOfWeek[4]));%> </span></td>
              <td width="165" bgcolor="#0066FF"><span class="Style12">Vendredi <%out.println(format.format(daysOfWeek[5]));%> </span></td>
              <td width="166" bgcolor="#0066FF"><span class="Style12">Samedi <%out.println(format.format(daysOfWeek[6]));%> </span></td>
              </tr>
            <tr>
              <td width="81" bgcolor="#0066FF"><span class="Style12">08:00:00</span></td>
               
               <%
               for (int i =1; i<7; i++) {
               		%><td width="81" bgcolor="#0066FF"><span class="Style12">
               		<% for (Sceance sceance : emploi.getListSceance()){
   	  					if(format.format(sceance.getDate()).equals(format.format(daysOfWeek[i])) 
   	  								&& formatT.format(sceance.getTime()).equals("08:00:00")){ %>
   	  				<a href="voircours.jsp?idModule=<%=sceance.getModule().getId()%>">
   	  				<%out.println(sceance.getModule().getName());
   	  					}
   	  				}
               }%></a></span></td>
            </tr>
            <tr>
              <td width="81" bgcolor="#0066FF"><span class="Style12">14:00:00</span></td>
               <%
               for (int i =1; i<7; i++) {
               		%><td width="81" bgcolor="#0066FF"><span class="Style12">
               		<% for (Sceance sceance : emploi.getListSceance()){
   	  					if(format.format(sceance.getDate()).equals(format.format(daysOfWeek[i])) 
   	  								&& formatT.format(sceance.getTime()).equals("02:00:00")){ %>
   	  				<a href="voircours.jsp?idModule=<%=sceance.getModule().getId()%>">
   	  				<% out.println(sceance.getModule().getName());
   	  					}
   	  				}
               }%></a></span></td>
            </tr>
			
          </table></td>
          </tr>
        <tr>
         
        </tr>
      </table>
    
	    <table width="1119" border="0">
          <tr>
            <td class="Style11"> <div align="right" class="Style18"><a href="afficher2.jsp?idEmploi=<%=emploi.getId()%>&idWeek=<%=WEEK_OF_YEAR-1%>">Pr&eacute;c&eacute;dent</a> |<a href="afficher2.jsp?idEmploi=<%=emploi.getId()%>&idWeek=<%=WEEK_OF_YEAR+1%>"> Suivant</a> </div></td>
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
      </tr>
  </table></td>
    </tr>
  <tr>
    <td bgcolor="#3399FF"><div align="right"><span class="Style2"><a href="index.jsp">Home</a> | <a href="index.jsp">Admin</a> | <a href="#">Plan | Apropos </a> </span></div></td>
  </tr>
</table>
</center>
</body>
</html>
