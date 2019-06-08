package DAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import javax.swing.JOptionPane;

import BDD.Etudiant;
import SQL.DB;
import SQL.SQL;

public class EtudiantDAO implements IDAO<Etudiant> {
    private DB db;
	private SQL queryString = new SQL();

    private EtudiantDAO() {
    	db = DB.getInstance();
    }
    private static IDAO<Etudiant> iEtudiantDAO;

    public static IDAO<Etudiant> getInstance() {
        if (iEtudiantDAO == null) {
            iEtudiantDAO = new EtudiantDAO();
        }
        return iEtudiantDAO;
    }

	public Stream<Etudiant> getAll(){
		List<Etudiant> listProfs = new ArrayList<Etudiant>();
		try{
			String[] table = { "Etudiant" };
			String t = queryString.Query_Select(table, etudiantAtt, "");
			ResultSet resultProfs = db.Get_DB( t);
			while (resultProfs.next()) {
				Etudiant etudiant = new Etudiant();			
				etudiant.setIdPersonne(resultProfs.getInt(1));
				etudiant.setNom(resultProfs.getString(2));
				etudiant.setPrenom(resultProfs.getString(3));
				etudiant.setLogin(resultProfs.getString(4));
				etudiant.setMdp(resultProfs.getString(5));
				etudiant.setIdGroupe(GroupeDAO.getInstance().getById(resultProfs.getInt(6)));
				listProfs.add(etudiant);
			}
		}catch(Exception x){
			JOptionPane.showMessageDialog(null,x.getMessage(),"Erreur",JOptionPane.ERROR_MESSAGE);
		}
		return listProfs.stream();
	}
    
	public <V> Etudiant getById(V idPersonne){
		Etudiant etudiant = new Etudiant();
		try{
			String[] table = { "Etudiant" };
			String t = queryString.Query_Select(table, etudiantAtt, "idPersonne = '"+idPersonne+"'");
			ResultSet resultProfs = db.Get_DB( t);
			while (resultProfs.next()){
				etudiant.setIdPersonne(resultProfs.getInt(1));
				etudiant.setNom(resultProfs.getString(2));
				etudiant.setPrenom(resultProfs.getString(3));
				etudiant.setLogin(resultProfs.getString(4));
				etudiant.setMdp(resultProfs.getString(5));
				etudiant.setIdGroupe(GroupeDAO.getInstance().getById(resultProfs.getInt(6)));
			}
		}catch(Exception x){
			JOptionPane.showMessageDialog(null,x.getMessage(),"Erreur",JOptionPane.ERROR_MESSAGE);
		}
		return etudiant;
	}
	
	public Stream<Integer> getId(){
		List<Integer> listProfs = new ArrayList<Integer>();
		try{
			String[] table = { "Etudiant" };
			String[] champ = { "idPersonne" };
			String t = queryString.Query_Select(table, champ, "");
			ResultSet resultProfs = db.Get_DB( t);
			while (resultProfs.next())
				listProfs.add(resultProfs.getInt(1));
		}catch(Exception x){
			JOptionPane.showMessageDialog(null,x.getMessage(),"Erreur",JOptionPane.ERROR_MESSAGE);
		}
		return listProfs.stream();
	}
	
	public void ajouter(Etudiant etudiant) throws Exception {
		String t = queryString.Query_Insert("Etudiant", etudiantAtt, etudiantVal(etudiant));
		if (db.Execute_DB(t)) System.out.println("Ok!");
	}

	public Boolean supprimer(Etudiant etudiant) throws Exception {
		String conditionE = "idPersonne= '" + etudiant.getIdPersonne() + "'";
		String tE = queryString.Query_Delete("Etudiant", conditionE);
		return (db.Execute_DB(tE));
	}

	public Boolean modifier(Etudiant etudiant) throws Exception {
		String condition = "idPersonne = '" + etudiant.getIdPersonne() + "'";
		String t = queryString.Query_Update("Etudiant", etudiantAtt, etudiantVal(etudiant), condition);
		return (db.Execute_DB(t));
	}
	
	private String[] etudiantAtt = { "idPersonne", "nom", "prenom","login","mdp","idGroupe" };
	private String[] etudiantVal(Etudiant etudiant) {
		String[] res = new String[6];
		res[0] = etudiant.getIdPersonne().toString();
		res[1] = etudiant.getNom();
		res[2] = etudiant.getPrenom();
		res[3] = etudiant.getLogin();
		res[4] = etudiant.getMdp();
		res[5] = etudiant.getIdGroupe().getIdGroupe().toString();
		return res;
	}

}
