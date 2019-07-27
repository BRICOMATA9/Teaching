<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" import="java.util.*" errorPage="" import="Service.ServiceEmploi"%>
<%@ page import="Model.*"%>
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
.Style13 {color: #AD0432}
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
</head>

<body>
<jsp:useBean id="moduleDetails" class="Model.Module" />
<jsp:setProperty 
    name="moduleDetails" 
    property="id"
    value='<%= request.getParameter("idModule") %>' />
 	<%ServiceEmploi service = new ServiceEmploi();
  		Professor professor = new Professor();
  		Module module = new Module();
  		module = service.findModuleById(moduleDetails.getId());
  		professor=service.findProfessorById(module.getIdProfessor());
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
      <td width="1114" height="21" bgcolor="#3399FF" class="Style3"></td>
      </tr>
	<tr valign="top">
      <td width="1114" height="200" class="Style3"><table width="1116" border="0">
        <tr>
          <td width="1110" colspan="2">&nbsp;</td>
          </tr>
		  <tr>
          <td colspan="2"><table width="1111" border="1" bordercolor="#666666">
            <tr><td width="81" bgcolor="#0066FF"><span>Nom de Module: <% out.println(module.getName()); %>
            </span></td></tr>
            <tr><td width="81" bgcolor="#0066FF"><span>Professeur:<a href="voirprofessors.jsp?idProfessor=<%=professor.getId()%>"> <%out.println(professor.getFirstName()+professor.getLastName());%>
            </a></span></td></tr>
            <tr>
              <td width="81" bgcolor="#0066FF"><span>Duree: <%out.println(module.getDuree()); %></span></td>
               </span></td>
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
    <td bgcolor="#3399FF"><div align="right"><span class="Style2"><a href="index.jsp">Home</a> | <a href="index.jsp">Admin</a></span></div></td>
  </tr>
</table>
</center>
</body>
</html>
