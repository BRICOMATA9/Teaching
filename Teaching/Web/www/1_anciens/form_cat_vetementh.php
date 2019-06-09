<title>Ajouter Vetement</title>
<form action="ajout_veth.php" method="post" enctype="multipart/form-data">
    <table>
        <tr>
        <td>Nom du produit</td>
        <td><input type="text" name="nom"></td>
        </tr>
        
        <tr>
        <td>description:</td>
        <td><textarea name="description" rows="10" cols="30">description </textarea></td>
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
        <td>type</td>
        <td><input type="text" name="typevet"></td>
        </tr>

        <tr>
        <td>matiere</td>
        <td><input type="text" name="matiere"></td>
        </tr>

        <tr>
        <td>couleur</td>
        <td><input type="text" name="couleur"></td>
        </tr>

        <tr>
        <td>taille</td>
        <td><input type="number" name="taille" min="1" max="1000" value="38" step="0.5"></td>
        </tr>
                
        <tr>
        <td>genre</td>
        <td><select name="genrevet">
            <option value="1">femme</option>
            <option value="2">homme</option>
            </select>
        </td>
        </tr>
               
        <tr>
        <td colspan="2" align="center">
        <input type="submit" name="additem" value="valider"></td>
        </tr>        

        
        
    </table>
</form>