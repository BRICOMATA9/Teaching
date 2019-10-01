package DAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import BDD.Batiment;
import SQL.DB;
import SQL.SQL;

public class BatimentDAO implements IDAO<Batiment>{
    private DB db;
	private SQL queryString = new SQL();
    private static IDAO<Batiment> iBatimentDAO;
	
    private BatimentDAO() {
    	db = DB.getInstance();
    }

    public static IDAO<Batiment> getInstance() {
        if (iBatimentDAO == null) {
        	iBatimentDAO = new BatimentDAO();
        }
        return iBatimentDAO;
    }
    
    public <V> Batiment getById(V idBatiment) throws Exception{
    	Batiment batiment = new Batiment();
		String[] table = { "Batiment" };
		String t = queryString.Query_Select(table, batimentAtt, "idBatiment = '"+idBatiment+"'");
		ResultSet result = db.Get_DB( t);
		while (result.next()) {
			batiment.setIdBatiment(result.getInt(1));
		}
    	return batiment;
    }
	
	public Stream<Batiment> getAll() throws Exception{
		List<Batiment> listAllBatiment = new ArrayList<Batiment>();
			String[] table = { "Batiment" };
			String t = queryString.Query_Select(table, batimentAtt, "");
			ResultSet result = db.Get_DB( t);
			while (result.next()) {
				Batiment batiment = new Batiment();
				batiment.setIdBatiment(result.getInt(1));
				listAllBatiment.add(batiment);
			}
		return listAllBatiment.stream();
	}
	
	public Stream<Integer> getId() throws Exception{
		List<Integer> listAllBatiment = new ArrayList<Integer>();
			String[] table = { "Batiment" };
			String[] champ = { "idBatiment" };
			String t = queryString.Query_Select(table, champ, "");
			ResultSet result = db.Get_DB( t);
			while (result.next())
				listAllBatiment.add(result.getInt(1));
		return listAllBatiment.stream();
	}
	

	public Boolean ajouter(Batiment batiment) throws Exception {
		String t = queryString.Query_Insert("Batiment", batimentAtt, batimentVal(batiment));
		return (db.Execute_DB(t));
	}

	public Boolean supprimer(Batiment salle) throws Exception {
		String condition = "idBatiment = '" + salle.getIdBatiment() + "'";
		String t = queryString.Query_Delete("Batiment", condition);
		return (db.Execute_DB(t));
	}

	public Boolean modifier(Batiment salle) throws Exception {
		String condition = "idBatiment = '" + salle.getIdBatiment() + "'";
		String t = queryString.Query_Update("Batiment", batimentAtt, batimentVal(salle), condition);
		return db.Execute_DB(t);
	}
	
	private String[] batimentAtt = { "idBatiment" };
	private String[] batimentVal(Batiment batiment) {
		String[] res = new String[1];
		res[0] = batiment.getIdBatiment().toString();
		return res;
	}
}
