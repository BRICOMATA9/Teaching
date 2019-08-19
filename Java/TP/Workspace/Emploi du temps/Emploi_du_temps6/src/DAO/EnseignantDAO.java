package DAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import javax.swing.JOptionPane;

import BDD.Enseignant;
import SQL.DB;
import SQL.SQL;

public class EnseignantDAO implements IDAO<Enseignant>{
    private DB db;
	private SQL queryString = new SQL();

    private EnseignantDAO() {
    	db = DB.getInstance();
    }
    
    private static IDAO<Enseignant> iEnseignantDAO;

    public static IDAO<Enseignant> getInstance() {
        if (iEnseignantDAO == null) {
            iEnseignantDAO = new EnseignantDAO();
        }
        return iEnseignantDAO;
    }
    
	public Stream<Enseignant> getAll(){
		List<Enseignant> listProfs = new ArrayList<Enseignant>();
		try{
			String[] table = { "Enseignant" };
			String t = queryString.Query_Select(table, enseignantAtt, "");
			ResultSet resultProfs = db.Get_DB(t);
			while (resultProfs.next()) {
				Enseignant prof = new Enseignant();			
				prof.setIdPersonne(resultProfs.getInt(1));
				prof.setNom(resultProfs.getString(2));
				prof.setPrenom(resultProfs.getString(3));
				prof.setLogin(resultProfs.getString(4));
				prof.setMdp(resultProfs.getString(5));
				prof.setGrade(resultProfs.getString(6));
				listProfs.add(prof);
			}
		}catch(Exception x){
			JOptionPane.showMessageDialog(null ,x.getMessage(),"Erreur",JOptionPane.ERROR_MESSAGE);
		}
		return listProfs.stream();
	}
    
	public <V> Enseignant getById(V idPersonne){
		Enseignant enseignant = new Enseignant();
		try{
			String[] table = { "Enseignant" };
			String t = queryString.Query_Select(table, enseignantAtt, "idPersonne = '"+idPersonne+"'");
			ResultSet resultProfs = db.Get_DB( t);
			while (resultProfs.next()){
				enseignant.setIdPersonne(resultProfs.getInt(1));
				enseignant.setNom(resultProfs.getString(2));
				enseignant.setPrenom(resultProfs.getString(3));
				enseignant.setLogin(resultProfs.getString(4));
				enseignant.setMdp(resultProfs.getString(5));
				enseignant.setGrade(resultProfs.getString(6));
			}
		}catch(Exception x){
			JOptionPane.showMessageDialog(null,x.getMessage(),"Erreur",JOptionPane.ERROR_MESSAGE);
		}
		return enseignant;
	}
	
	public Stream<Integer> getId(){
		List<Integer> listProfs = new ArrayList<Integer>();
		try{
			String[] table = { "Enseignant" };
			String[] champ = { "idPersonne" };
			String t = queryString.Query_Select(table, champ, "");
			ResultSet resultProfs = db.Get_DB(t);
			while (resultProfs.next())
				listProfs.add(resultProfs.getInt(1));
		}catch(Exception x){
			JOptionPane.showMessageDialog(null ,x.getMessage(),"Erreur",JOptionPane.ERROR_MESSAGE);
		}
		return listProfs.stream();
	}
	
	public void ajouter(Enseignant enseignant) throws Exception {
		String t = queryString.Query_Insert("Enseignant", enseignantAtt, enseignantVal(enseignant));
		if (db.Execute_DB(t)) System.out.println("Ok!");
	}

	public Boolean supprimer(Enseignant enseignant) throws Exception {
		String conditionE = "idPersonne= '" + enseignant.getIdPersonne() + "'";
		String t = queryString.Query_Delete("Enseignant", conditionE);
		return (db.Execute_DB(t));
	}

	public Boolean modifier(Enseignant enseignant) throws Exception {
		String condition = "idPersonne= '" + enseignant.getIdPersonne() + "'";
		String t = queryString.Query_Update("Enseignant", enseignantAtt, enseignantVal(enseignant), condition);
		return (db.Execute_DB(t));
	}
	
	private String[] enseignantAtt = { "idPersonne", "nom", "prenom","login","mdp","grade" };
	private String[] enseignantVal(Enseignant enseignant) {
		String[] res = new String[6];
		res[0] = enseignant.getIdPersonne().toString();
		res[1] = enseignant.getNom();
		res[2] = enseignant.getPrenom();
		res[3] = enseignant.getLogin();
		res[4] = enseignant.getMdp();
		res[5] = enseignant.getGrade();
		return res;
	}
}
