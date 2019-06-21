<!DOCTYPE html>
<html>
<head>
    <title>Ajouter un produit</title>
    <meta charset="utf-8">




</head>
<body >

   

   
<form action="form_choix.php" method="post" enctype="multipart/form-data">
    <table>
        
        
        
        <tr>
        <td>categorie:</td>
        <td><select name="categorie">
                <option value="1">
                    Livres
                    
                </option>
                <option value="2">
                    Musiques
                </option>
                <option value="3">Vetements Femmes</option>
                <option value="4">Vetements Hommes</option>
                <option value="5">Sports et loisirs</option>
            </select>
        </td>
        </tr>

        <tr>
        <td colspan="2" align="center">
         <input type="submit" name="addchamp" value="suite"></td>
        </tr> 
        
    </table>
</form>
<?php
if (isset($_POST['addchamp']))
    {
    
    switch ($_POST['categorie']) {
                
            case 1:
                header('location:form_cat_livre.php');
                break;
            case 2:
                header('location:form_cat_musique.php');
                break;
            case 3:
                header('location:form_cat_vetementf.php');
                break;
            case 4:
                header('location:form_cat_vetementh.php');
                break; 
            case 5:
                header('location:form_cat_sport.php');
                break;   
        }

    }
?>

</body>
</html>
