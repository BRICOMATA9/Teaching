<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" import="java.util.*" errorPage="" import="Service.ServiceEmploi"%>
<jsp:useBean id="index" class="Service.ServiceEmploi" scope="request" />
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
.Style4 {color: #000000}
.Style6 {font-size: 12px}
.Style8 {color: #333333; font-size: 12px; }
.Style11 {
	font-family: "Times New Roman", Times, serif;
	color: #AD0432;
	font-size: 12px;
}
.Style12 {font-size: 12px; color: #000000; }
-->
</style>
<script type="text/JavaScript">
<!--
/* function MM_jumpMenu(targ,selObj,restore){ //v3.0
  eval(targ+".location='"+selObj.options[selObj.selectedIndex].value+"'");
  if (restore) selObj.selectedIndex=0;
} */
//-->
</script>
<script language = "JavaScript">
<!--

/* var totalboxes;

function setCount(count, target){

 totalbuttons=count;

// the next 3 lines are the main lines of this script
//remember to leave action field blank when defining the form
if(target == 0) document.myform.action="Affchier.jsp";
if(target == 1) document.myform.action="index.jsp";

}

function isReady(form) {


 for(var x=0 ; x<totalbuttons ; x++){


//if even one box is checked then return true
if(myform.submit[x].selected) return true;  
}  
 //default action : When even one was not checked then..
alert("Please check at least one checkbox..");
return false;

} */

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
      <td width="672" height="21" class="Style3">Acces direct</td>
      <td width="433" class="Style3"><center>Registration - Login</center></td>
    </tr>
	<tr valign="top">
      <td width="672" height="200" class="Style3">
 <form  method ="post" ><table width="673" border="0">
	   <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr align="center">
    <td width="99">&nbsp;</td>
    <td width="258"><select name="menu1" onchange="MM_jumpMenu('parent',this,0)">
      <option>Choisir la Promotion</option>
      <%
      	List<String> listNamePromotion = new ArrayList<String>();
      	ServiceEmploi service = new ServiceEmploi();
      	listNamePromotion = service.findNameOfAllPromotion();
      	for (String name : listNamePromotion){
      	%>
       <option value = "<%=listNamePromotion.indexOf(name)+1%>"><%out.print(name);%></option>
       <%}%>
    </select></td>
    <td width="302"><select name="menu2" onchange="MM_jumpMenu('parent',this,0)">
      <option>Choisir la classe</option>
      <% 
      	List<String> listNameClasse= new ArrayList<String>();
      	listNameClasse = service.findNameOfAllClasse();
      	for (String name : listNameClasse){
      	%>
       <option value = "<%=listNameClasse.indexOf(name)+1%>"><%out.print(name);%></option>
       <%}%>
    </select></td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr align="center">
    <td>&nbsp;</td>
    <td><label>
      <input type="submit" name="Submit" value="Voir Emploi du temps" onclick="form.action='afficher.jsp';"/>
    </label></td>
    <td><label>
      <input type="submit" name="Submit" value="Voir tous les cours" onclick="form.action='affichercours.jsp';"/>
    </label></td>
  </tr>
</table>
</form>
	    <table width="670" border="0">
          <tr>
            <td class="Style8">&nbsp;</td>
          </tr>
		   <tr>
            <td class="Style11">Projet con&ccedil;u dans le cadre du cours de Genie logiciel avanc&eacute; </td>
          </tr>
          <tr>
            <td class="Style8">Par : Ha, Selain, Tuan</td>
          </tr>
        </table></td>
      <td width="433" class="Style3"><form action= "cache_login.jsp" method="post" >
        <table width="433" border="0">
		 <tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td width="130"><span class="Style4">Login</span></td>
            <td width="293"><span class="Style4">
              <label>
              <input type="text" name="userid" />
              </label>
            </span></td>
          </tr>
          <tr>
            <td><span class="Style4">Password </span></td>
            <td><span class="Style4">
              <label>
              <input type="password" name="pwd" />
              </label>
            </span></td>
          </tr>
          <tr>
            <td height="27" colspan="2" valign="top"><span class="Style4"></span>
              <table width="416" border="0">
                <tr>
                  <td width="201" height="45"><span class="Style5">
                    <label>
                    <div align="center">
                      <input type="submit" name="Submit" value="Connexion"  />
                      </div>
                  </label></td>
                </tr>
              </table>              </td>
            </tr>
        </table>
      </form>
	  <div align="center"><img simport="Service.ServiceEmploi"rc="img/cadena.jpg" width="94" height="72" />          </div>
      </td>
    </tr>
  </table></td>
    </tr>
  <tr>
    <td bgcolor="#3399FF"><div align="right"><span class="Style2"><a href="index.jsp">Home</a> | <a href="index.jsp">Admin</a></span></div></td>
  </tr>
</table>
</center>
</body>
</html>
