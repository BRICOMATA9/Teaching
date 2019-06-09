<title>Faites votre choix</title>

<form action="ajout_livre.php" method="post" enctype="multipart/form-data">
    <table>
        <tr>
        <td>Nom du produit</td>
        <td><input type="text" name="nom"></td>
        </tr>
        
        <tr>
        <td>description:</td>
        <td><textarea name="description" rows="10" cols="30">...</textarea></td>
        </tr>
        
        <tr>
        <td>prix</td>
        <td><input type="number" name="prix" step="0.01"></td>
        </tr>
        
        <tr>
        <td>Photo</td>
        <td><input type="file" name="photo" id="fichier_a_uploader"></td>
        </tr>
        
        <tr>
        <td>quantite</td>
        <td><input type="number" name="quantite" min="1" max="10000"></td>
        </tr>
        
        
        <tr>
        <td>auteur</td>
        <td><input type="text" name="auteur"></td>
        </tr>

        <tr>
        <td>editeur</td>
        <td><input type="text" name="editeur"></td>
        </tr>

        <tr>
        <td>genre</td>
        <td><input type="text" name="genreliv"></td>
        </tr>

        <tr>
        <td>type</td>
        <td><input type="text" name="typeliv"></td>
        </tr>
               
        <tr>
        <td colspan="2" align="center">
        <input type="submit" name="additem" value="valider"></td>
        </tr>        

        
        
    </table>
</form>

