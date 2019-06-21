package SQL;

import java.sql.ResultSet;

import BDD.Enseignant;
import BDD.Etudiant;
import BDD.Personne;
import DAO.GroupeDAO;

public class Recherche {

	private DB db;
	private SQL queryString = new SQL();
	private String[] enseignantAtt = { "idPersonne", "nom", "prenom","login","mdp","grade" };
	private String[] etudiantAtt = { "idPersonne", "nom", "prenom","login","mdp","idGroupe" };

	public Recherche(DB db) {
		this.db=db;
	}

	public Personne login(String account, String password) throws Exception {
		System.out.println(account+" "+password);
		String[] table = { "Etudiant" };
		String[] fields = { "idPersonne" };
		String condition = "login= '" + account + "' AND mdp = '"+ password + "'";

		String t = queryString.Query_Select(table, etudiantAtt, condition);
		ResultSet result = db.Get_DB(t);
		Etudiant user = new Etudiant();
		while (result.next()){
			user.setIdPersonne(result.getInt(1));
			user.setNom(result.getString(2));
			user.setPrenom(result.getString(3));
			user.setLogin(result.getString(4));
			user.setMdp(result.getString(5));
			user.setIdGroupe(GroupeDAO.getInstance().getById(result.getInt(6)));
		}if (user.getIdPersonne() != null) {
			return user;
		} else {
			table[0] = "Enseignant";
			fields[0] = "idPersonne";
			condition = "login= '" + account + "' AND mdp = '"+ password + "'";
			t = queryString.Query_Select(table, enseignantAtt, condition);
			result = db.Get_DB(t);
			Enseignant user2 = new Enseignant();
			while (result.next()){
				user2.setIdPersonne(result.getInt(1));
				user2.setNom(result.getString(2));
				user2.setPrenom(result.getString(3));
				user2.setLogin(result.getString(4));
				user2.setMdp(result.getString(5));
				user2.setGrade(result.getString(6));
			}if (user2.getIdPersonne() != null) 
				return user2;
			 else
				throw new Exception("Login ou mot de passe incorrecte");
		}
	}
}
