
<%@ page import ="java.sql.*" %>
<%@ page import ="javax.sql.*" %>
<%
String user=request.getParameter("userid");
session.putValue("userid",user);
String pwd=request.getParameter("pwd");
String fname=request.getParameter("fname");
String lname=request.getParameter("lname");
String email=request.getParameter("email");
Class.forName("com.mysql.jdbc.Driver");
java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
Statement st= con.createStatement();
ResultSet rs;
int i=st.executeUpdate("insert into users values ('"+user+"','"+pwd+"','"+fname+"','"+lname+"','"+email+"')");

%>

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
      <td width="672" height="21" class="Style3">Acces direct</td>
      <td width="433" class="Style3"><center><marquee behavior="alternate">Compte cr&eacute;e avec succes - Bienvenue ! </marquee></center></td>
    </tr>
	<tr valign="top">
      <td width="672" height="200" class="Style3"><form action="" method="get"><table width="669" border="0">
        <tr>
          <td width="179">&nbsp;</td>
          <td width="480">&nbsp;</td>
        </tr>
        <tr>
          <td><span class="Style4">Chosir la promotion</span></td>
          <td><select name="menu1" onchange="MM_jumpMenu('parent',this,0)">
            <option>Promotion 16 RSC</option>
            <option>Promotion 16 SIM</option>
            <option>Promotion 17</option>
            <option>Preparatoire promotion 18</option>
          </select></td>
        </tr>
        <tr>
          <td>&nbsp;</td>
          <td>&nbsp;</td>
        </tr>
        <tr>
          <td><span class="Style4">Voir la liste des cours</span></td>
          <td><label>
            <input type="submit" name="Submit3" value="Voir la liste de tous les cours " />
          </label></td>
        </tr>
      </table>
      </form>
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
      <td width="433" class="Style3"><form action="login.jsp" method="post">
        <table width="433" border="0">
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
                    <a href="#" class="Style6"><a href="recuperer.html"><span class="Style6">Mot de passe oublier?</span> </a><br />
                    <div align="center">
                      <input type="submit" name="Submit" value="Connexion" />
                      </div>
                  </label></td>
                  <td width="205"><span class="Style12">
                    <label>
                    <a href="reg.html" class="Style6">Cr&eacute;e un compte</a>
                    <div align="center">
                      <input type="reset" name="Submit2" value="Annuler" />
                      </div>
                  </label></td>
                </tr>
              </table>              </td>
            </tr>
        </table>
      </form>
	  <div align="center"><img src="img/cadena.jpg" width="94" height="72" />          </div>
      </td>
    </tr>
  </table></td>
    </tr>
  <tr>
    <td bgcolor="#3399FF"><div align="right"><span class="Style2"><a href="index.html">Home</a> | <a href="index.html">Admin</a> | <a href="#">Plan | Apropos </a> </span></div></td>
  </tr>
</table>
</center>
</body>
</html>
