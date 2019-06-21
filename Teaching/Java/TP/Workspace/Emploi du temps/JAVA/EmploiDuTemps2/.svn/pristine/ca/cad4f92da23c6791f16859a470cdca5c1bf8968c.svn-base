
<%@ page import="java.sql.*" import="Service.ServiceEmploi"
	import="Model.*"%>
<%@ page import="javax.sql.*" import="java.util.*"
	import="java.util.Date" import="java.text.*"
	import= "java.util.Map.Entry"%>
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
<% 
  
   ServiceEmploi service = new ServiceEmploi();
  List<Sceance> listAllSceance = new ArrayList<Sceance>();
  listAllSceance = service.findAllSceance();
   //String nameClasse = listNameClasse.get(Integer.parseInt(request
			//.getParameter("menu3"))-1);
 //  Classe classe = service.findClasseByName(nameClasse);
   SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
   SimpleDateFormat formatT = new SimpleDateFormat("HH:mm:ss");

%>
<table width="" height="380" border="0" bordercolor="#000000" style="border:1px:solid">
  <tr>
    <td width="1114" height="100"><img src="img/bannerEDT1.png" width="1106" /></td>
  </tr>
  <tr valign="top">
    <td height="10" bgcolor="#99BDC9">&nbsp;</td>
    </tr>
  <tr valign="top">
  <td height="178"><table width="1120" height="227" border="0">
    <tr bgcolor="#3399FF">
      <td width="1114" height="21" bgcolor="#3399FF" class="Style3">Acces direct</td>
      </tr>
	<tr valign="top">
      <td width="1114" height="200" class="Style3"><table width="1116" border="0">
        <tr>
          <td width="1110" colspan="2">&nbsp;</td>
          </tr>
		  <tr>
          <td colspan="2"><table width="1111" border="1" bordercolor="#666666">
            <tr>
              <td width="63" bgcolor="#0066FF"><span class="Style12">Id</span></td>
              <td width="410" bgcolor="#0066FF"><span class="Style12">Cours</span></td>
              <td width="410" bgcolor="#0066FF"><span class="Style12">Id Emploi Du Temps</span></td>
              <td width="410" bgcolor="#0066FF"><span class="Style12">Date</span></td>
               <td width="410" bgcolor="#0066FF"><span class="Style12">Temps</span></td>
             </tr>
         <%for (Sceance sceance:listAllSceance) { %>
          <tr>
          <td width="63" bgcolor="#0066FF"><span class="Style12"><% 
            	out.print(sceance.getId());
              %></span></td>
          <td width="410" bgcolor="#0066FF"><span class="Style12"><% 
            	 out.print(sceance.getModule().getName());
              %></span></td>
          <td width="410" bgcolor="#0066FF"><span class="Style12"><% 
            	 out.print(sceance.getIdEmploi());
              %></span></td>
          <td width="410" bgcolor="#0066FF"><span class="Style12"><% 
            	out.print(format.format(sceance.getDate()));
              %></span></td>
              <td width="410" bgcolor="#0066FF"><span class="Style12"><% 
            	out.print(formatT.format(sceance.getTime()));
              %></span></td> 
              </tr>
              <% }%> 
		<form  method="post"><table width="669" border="0"><table width="670" border="0">
            <tr>
              <td width="184"><span class="Style4">Ajouter un Sceance</span> </td>
              <td width="476"><input type="submit" name="Submit" value="Ajouter un Sceance " onclick="form.action='enregistrer.jsp';" /></td>
            </tr>
          </table></td>
          </tr>
        <tr>
         
        </tr>
      </table>
    
	    <table width="1119" border="0">
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
    <td bgcolor="#3399FF"><div align="right"><span class="Style2"><a href="index.html">Home</a> | <a href="index.jsp">Admin</a></span></div></td>
  </tr>
</table>
</center>
</body>
</html>
