package DAO;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import javax.swing.JOptionPane;

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
	public Stream<Cours> getAll(){
		List<Cours> listAllCours = new ArrayList<Cours>();
		try{
			String[] table = { "Cours" };
			String t = queryString.Query_Select(table, coursAtt, "")+ " ORDER BY dateDebut, heureDebut";
			ResultSet result = db.Get_DB( t);
			while (result.next()) {
				Cours cours = new Cours();
				cours.setIdModule(ModuleDAO.getInstance().getById(result.getString(1)));
				cours.setIdSalle(SalleDAO.getInstance().getById(result.getInt(2)));
				cours.setIdEnseignant(EnseignantDAO.getInstance().getById(result.getInt(3)));
				cours.setIdSection(SectionDAO.getInstance().getById(result.getInt(4)));
				cours.setDateDebut((Date) formatterDate.parse(result.getString(5)));
				cours.setHeureDebut((Date) formatterTime.parse(result.getString(6)));
				cours.setDuree((Date) formatterTime.parse(result.getString(7)));
				listAllCours.add(cours);
			}
		}catch(Exception x){
			JOptionPane.showMessageDialog(null,x.getMessage(),"Erreur",JOptionPane.ERROR_MESSAGE);
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
	
	public void ajouter(Cours cours) throws Exception {
		String t = queryString.Query_Insert("Cours", coursAtt, coursVal(cours));
		if (db.Execute_DB(t)) System.out.println("Ok!");
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
	
	private String[] coursAtt = {"idModule","idSalle","idEnseignant","idSection","dateDebut","heureDebut","durree" };
	private String[] coursVal(Cours cours) {
		String[] res = new String[7];
		res[0] = cours.getIdModule().getIdModule().toString();
		res[1] = cours.getIdSalle().getIdSalle().toString();
		res[2] = cours.getIdEnseignant().getIdPersonne().toString();
		res[3] = cours.getIdSection().getIdSection().toString();
		res[4] = formatterDate.format(cours.getDateDebut());
		res[5] = formatterTime.format(cours.getHeureDebut());
		res[6] = formatterTime.format(cours.getDuree());
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
