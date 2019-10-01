package DAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import BDD.Salle;
import SQL.DB;
import SQL.SQL;

public class SalleDAO implements IDAO<Salle> {

    private DB db;
	private SQL queryString = new SQL();

    private SalleDAO() {
    	db = DB.getInstance();
    }
    private static IDAO<Salle> iSalleDAO;

    public static IDAO<Salle> getInstance() {
        if (iSalleDAO == null) {
            iSalleDAO = new SalleDAO();
        }
        return iSalleDAO;
    }
    
    public <V> Salle getById1(V idSalle) throws Exception {
    	Salle salle = new Salle();
		String[] table = { "Salle" };
		String t = queryString.Query_Select(table, salleAtt, "idSalle = '"+idSalle+"'");
		ResultSet result = db.Get_DB( t);
		while (result.next()) {
			salle.setIdSalle(result.getInt(1));
			salle.setType(result.getString(2));
			salle.setCapacite(result.getInt(3));
			salle.setIdBatiment(BatimentDAO.getInstance().getById(result.getInt(4)));
			//salle.setSuccesseur(this.getById(result.getInt(5)));
			//salle.setPredecesseur(this.getById(result.getInt(6)));
		}
    	return salle;
    }
    
    public <V> Salle getById(V idSalle) throws Exception {
    	Salle salle = new Salle();
		String[] table = { "Salle" };
		String t = queryString.Query_Select(table, salleAtt, "idSalle = '"+idSalle+"'");
		ResultSet result = db.Get_DB( t);
		while (result.next()) {
			salle.setIdSalle(result.getInt(1));
			salle.setType(result.getString(2));
			salle.setCapacite(result.getInt(3));
			salle.setIdBatiment(BatimentDAO.getInstance().getById(result.getInt(4)));	
			salle.setSuccesseur(getById1(result.getInt(5)));	
			salle.setPredecesseur(getById1(result.getInt(6)));
		}
    	return salle;
    }
    
	public Stream<Salle> getAll() throws Exception {
		List<Salle> listAllSalle = new ArrayList<Salle>();
		String[] table = { "Salle" };
		String t = queryString.Query_Select(table, salleAtt, "");
		ResultSet result = db.Get_DB( t);
		while (result.next()) {
			Salle salle = new Salle();
			salle.setIdSalle(result.getInt(1));
			salle.setType(result.getString(2));
			salle.setCapacite(result.getInt(3));
			salle.setIdBatiment(BatimentDAO.getInstance().getById(result.getInt(4)));		
			salle.setSuccesseur(getById(result.getInt(5)));	
			salle.setPredecesseur(getById(result.getInt(6)));	
			listAllSalle.add(salle);
		}
		return listAllSalle.stream();
	}
    
	public Stream<Integer> getId()throws Exception {
		List<Integer> listAllSalle = new ArrayList<Integer>();
			String[] table = { "Salle" };
			String[] champ = { "idSalle" };
			String t = queryString.Query_Select(table, champ, "");
			ResultSet result = db.Get_DB( t);
			while (result.next()) 		
				listAllSalle.add(result.getInt(1));
		return listAllSalle.stream();
	}
	
	public Boolean ajouter(Salle salle) throws Exception {
		String t = queryString.Query_Insert("Salle", salleAtt, salleVal(salle));
		return (db.Execute_DB(t));
	}

	public Boolean supprimer(Salle salle) throws Exception {
		String condition = "idSalle = '" + salle.getIdSalle() + "'";
		String t = queryString.Query_Delete("Salle", condition);
		return (db.Execute_DB(t));
	}

	public Boolean modifier(Salle salle) throws Exception {
		String condition = "idSalle = '" + salle.getIdSalle() + "'";
		String t = queryString.Query_Update("Salle", salleAtt, salleVal(salle), condition);
		return (db.Execute_DB(t));
	}
	
	private String[] salleAtt = { "idSalle","type","capacite","idBatiment","successeur","predecesseur" };
	private String[] salleVal(Salle salle) {
		String[] res = new String[6];
		res[0] = salle.getIdSalle().toString();
		res[1] = salle.getType();
		res[2] = salle.getCapacite().toString();
		res[3] = salle.getIdBatiment().getIdBatiment().toString();
		res[4] = salle.getSuccesseur().getIdSalle()==null?"NULL":salle.getSuccesseur().getIdSalle().toString();
		res[5] = salle.getPredecesseur().getIdSalle()==null?"NULL":salle.getPredecesseur().getIdSalle().toString();
		//System.out.println(res[0]+" "+res[1]+" "+res[2]+" "+res[3]+" "+res[4]+" "+res[5]);
		return res;
	}
    
}
