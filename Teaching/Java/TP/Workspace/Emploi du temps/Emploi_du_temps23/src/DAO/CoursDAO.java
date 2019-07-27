package DAO;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import BDD.Cours;
import SQL.DB;
import SQL.SQL;

public class CoursDAO implements IDAO<Cours>{

    private DB db;
	private SQL queryString = new SQL();
	private SimpleDateFormat formatterDate = new SimpleDateFormat("yy-MM-dd");
	private SimpleDateFormat formatterTime = new SimpleDateFormat("HH:mm:ss");

    private CoursDAO() {
    	db = DB.getInstance();
    }
    private static IDAO<Cours> iCoursDAO;

    public static IDAO<Cours> getInstance() {
        if (iCoursDAO == null) {
            iCoursDAO = new CoursDAO();
        }
        return iCoursDAO;
    }
    
    @Override
	public Stream<Cours> getAll() throws Exception{
		List<Cours> listAllCours = new ArrayList<Cours>();
		String[] table = { "Cours" };
		String t = queryString.Query_Select(table, coursAtt, "")+ " ORDER BY dateDebut, heureDebut";
		ResultSet result = db.Get_DB( t);
		while (result.next()) {
			Cours cours = new Cours();
			cours.setIdModule(ModuleDAO.getInstance().getById(result.getString(1)));
			cours.setIdSalle(SalleDAO.getInstance().getById(result.getInt(2)));
			cours.setSalleBis(SalleDAO.getInstance().getById(result.getInt(3)));
			cours.setIdEnseignant(EnseignantDAO.getInstance().getById(result.getInt(4)));
			cours.setIdSection(SectionDAO.getInstance().getById(result.getInt(5)));
			cours.setDateDebut((Date) formatterDate.parse(result.getString(6)));
			cours.setHeureDebut((Date) formatterTime.parse(result.getString(7)));
			cours.setDuree((Date) formatterTime.parse(result.getString(8)));
			listAllCours.add(cours);
		}
		return listAllCours.stream();
	}
    
	public Stream<Integer> getId(){
		List<Integer> list = new ArrayList<Integer>();
		return list.stream();
	}
	public <V>Cours getById(V idCours) throws Exception{
		Cours cours = new Cours();
		return cours;
	}
	
	public Boolean ajouter(Cours cours) throws Exception {
		String t = queryString.Query_Insert("Cours", coursAtt, coursVal(cours));
		System.out.println(t);
		return (db.Execute_DB(t));
	}

	public Boolean supprimer(Cours cours) throws Exception {
		String cond =  condCours(cours);
		System.out.println(cond);
		String t = queryString.Query_Delete("Cours",cond);
		return (db.Execute_DB(t));
	}
	public Boolean modifier(Cours cours) throws Exception  {
		String t = queryString.Query_Update("Cours", coursAtt, coursVal(cours), condCours(cours));
		return (db.Execute_DB(t));
	}
	
	private String[] coursAtt = {"idModule","idSalle","salleBis","idEnseignant","idSection","dateDebut","heureDebut","durree" };
	private String[] coursVal(Cours cours) {
		String[] res = new String[8];
		res[0] = cours.getIdModule().getIdModule().toString();
		res[1] = cours.getIdSalle().getIdSalle().toString();
		res[2] = (cours.getSalleBis().getIdSalle()==null?"NULL":cours.getSalleBis().getIdSalle().toString());
		res[3] = cours.getIdEnseignant().getIdPersonne().toString();
		res[4] = cours.getIdSection().getIdSection().toString();
		res[5] = formatterDate.format(cours.getDateDebut());
		res[6] = formatterTime.format(cours.getHeureDebut());
		res[7] = formatterTime.format(cours.getDuree());
		return res;
	}
	
	private String condCours (Cours cours){
		return "idModule = '"+cours.getIdModule().getIdModule()+
		"' AND idSalle = '"+cours.getIdSalle().getIdSalle()+
		"' AND idEnseignant = '"+cours.getIdEnseignant().getIdPersonne()+
		"' AND idSection = '"+cours.getIdSection().getIdSection()+
		"' AND dateDebut = '"+formatterDate.format(cours.getDateDebut())+
		"' AND heureDebut = '"+formatterTime.format(cours.getHeureDebut())+"'";
	}
    
}
