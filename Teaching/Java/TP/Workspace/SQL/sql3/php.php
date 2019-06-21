
formulaire


<form action="search.php" method="post">
<input type="text" name="search" size="100" style="font-size: 12px;"><br><br>
<input type="radio" name="option" value="all" style="border: none; font-size: 12px;" checked>Rechercher tous les mots<br>
<input type="radio" name="option" value="one" style="border: none; font-size: 12px;">Rechercher un de ces mots<br>
<input type="radio" name="option" value="sentence" style="border: none; font-size: 12px;">Rechercher l'expression exacte
		
<br><br>
<input type="submit" value="Rechercher" style="font-size: 12px; position: relative; left: 20px;">
</form>


fonction de création de requête


function requete($table, $champs, $select, $order, $sens, $limit_start, $limit_nb, $count = '')
{
	// option de recherche
	$option = $_POST['option'];
	// texte de recherche
	$search = $_POST['search'];
		
	// si c'est le premier appel de la fonction
	if(!isset($fonction_requete))
	{
		static $fonction_requete = 1;
		
		// si "Rechercher tous les mots" ou "Rechercher un de ces mots"
		if($option == 'all' || $option == 'one')
		{
			// liste des mots
			$mots = explode(' ', $search);
			
			// sépararateur
			if($option == 'all')
				$sep = ' AND ';
			else
				$sep = ' OR ';
		} // if($option == 'all' || $option == 'one')
		// "Rechercher l'expression exacte"
		else
		{
			$mots = $search;
			$sep = '';
		}
	} // if(!isset($fonction_requete))
	
	if(!is_array($champs))
		$champs = array($champs);
	
	if($option == 'all' || $option == 'one')
	{
		// pour savoir si on en est à la première itération ou non
		$i = 0;
		
		// pour tous les mots
		foreach($mots as $mot)
		{
			if(!$i)
			{
				$search = '~#^!|!^#~ LIKE \'%' . $mot . '%\'';
				$i = 1;
			}
			else
				$search .= $sep . '~#^!|!^#~ LIKE \'%' . $mot . '%\'';
		} // foreach($mots as $mot)
	} // if($option == 'all' || $option == 'one')
	else if($option == 'sentence')
		$search = '~#^!|!^#~ LIKE \'%' . $mots . '%\'';
		
	$i = 0;
	
	// début de requête
	if(empty($count))
		$req_search = 'SELECT ' . $select . ' FROM ' . $table . ' WHERE ';
	else
		$req_search = 'SELECT count(' . $count . ') FROM ' . $table . ' WHERE ';
	
	// ajout des champs
	foreach($champs as $champ)
	{
		if(!$i)
		{
			$req_search .= '( ' . str_replace('~#^!|!^#~', $champ, $search) .' ) ';
			$i = 1;
		}
		else
			$req_search .= 'OR ( ' . str_replace('~#^!|!^#~', $champ, $search) .' ) ';
	}
	
	if(empty($count))
		$req_search .= "ORDER BY $order $sens LIMIT $limit_start, $limit_nb";
	
	return $req_search;
}


Paramètres:


$table: table dans laquelle effectuer la requête
$champs: champs dans lesquels la recherche est effectuées (si plusieurs champs, $champs est un tableau)
$select: champs à récupérer
$order: champ de classement
$sens: ASC ou DESC
$limit_start: départ
$limit_nb: nombre d'enregistrements sélectionnés 
$count: paramètre optionnel: Si est vide ou non-passé, la requête est crée normalement. Sinon, il désigne le champ pour créer la requête count() 

En simplifé, la requête est générée comme ceci:
SELECT $champs FROM $table WHERE ... ORDER BY $order $sens LIMIT $limit_start, $limit_nb  


Exemple


$requete = requete('table', array('champ1', 'champ2', 'champ3'), 'id, champ4', 'id', 'DESC', 10, 25);
$result = mysql_query($requete);
