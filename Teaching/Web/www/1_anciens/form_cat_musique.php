<title>Musique</title>

<form action="ajout_musique.php" method="post" enctype="multipart/form-data">
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
        <td>artiste</td>
        <td><input type="text" name="artiste"></td>
        </tr>

        <tr>
        <td>genre</td>
        <td><input type="text" name="genremus"></td>
        </tr>

        <tr>
        <td>album</td>
        <td><input type="text" name="album"></td>
        </tr>
               
        <tr>
        <td colspan="2" align="center">
        <input type="submit" name="additem" value="valider"></td>
        </tr>        

        
        
    </table>
</form>


