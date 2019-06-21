package DAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import javax.swing.JOptionPane;

import BDD.Salle;
import SQL.DB;
import SQL.SQL;

public class SalleDAO implements IDAO<Salle>{

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
    
    public <V> Salle getById(V idSalle) throws Exception{
    	Salle salle = new Salle();
		String[] table = { "Salle" };
		String t = queryString.Query_Select(table, salleAtt, "idSalle = '"+idSalle+"'");
		ResultSet result = db.Get_DB( t);
		while (result.next()) {
			salle.setIdSalle(result.getInt(1));
			salle.setCapacite(result.getInt(2));
			salle.setIdBatiment(BatimentDAO.getInstance().getById(result.getInt(3)));			
		}
    	return salle;
    }
    
	public Stream<Salle> getAll(){
		List<Salle> listAllSalle = new ArrayList<Salle>();
		try{
			String[] table = { "Salle" };
			String t = queryString.Query_Select(table, salleAtt, "");
			ResultSet result = db.Get_DB( t);
			while (result.next()) {
				Salle salle = new Salle();
				salle.setIdSalle(result.getInt(1));
				salle.setCapacite(result.getInt(2));
				salle.setIdBatiment(BatimentDAO.getInstance().getById(result.getInt(3)));			
				listAllSalle.add(salle);
			}
		}catch(Exception x){
			JOptionPane.showMessageDialog(null,x.getMessage(),"Erreur",JOptionPane.ERROR_MESSAGE);
		}
		return listAllSalle.stream();
	}
    
	public Stream<Integer> getId(){
		List<Integer> listAllSalle = new ArrayList<Integer>();
		try{
			String[] table = { "Salle" };
			String[] champ = { "idSalle" };
			String t = queryString.Query_Select(table, champ, "");
			ResultSet result = db.Get_DB( t);
			while (result.next()) 		
				listAllSalle.add(result.getInt(1));
		}catch(Exception x){
			JOptionPane.showMessageDialog(null,x.getMessage(),"Erreur",JOptionPane.ERROR_MESSAGE);
		}
		return listAllSalle.stream();
	}
	
	public void ajouter(Salle salle) throws Exception {
		String t = queryString.Query_Insert("Salle", salleAtt, salleVal(salle));
		if (db.Execute_DB(t)) System.out.println("Ok!");
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
	
	private String[] salleAtt = { "idSalle","capacite","idBatiment" };
	private String[] salleVal(Salle salle) {
		String[] res = new String[3];
		res[0] = salle.getIdSalle().toString();
		res[1] = salle.getCapacite().toString();
		res[2] = salle.getIdBatiment().getIdBatiment().toString();
		return res;
	}
    
}
