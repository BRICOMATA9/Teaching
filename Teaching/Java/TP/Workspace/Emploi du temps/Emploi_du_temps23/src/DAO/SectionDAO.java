package DAO;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import BDD.Section;
import SQL.DB;
import SQL.SQL;

public class SectionDAO implements IDAO<Section> {
	
    private DB db;
	private SQL queryString = new SQL();
	private SimpleDateFormat formatterDate = new SimpleDateFormat("yy-MM-dd");

    private SectionDAO() {
    	db = DB.getInstance();
    }
    private static IDAO<Section> iSectionDAO;

    public static IDAO<Section> getInstance() {
        if (iSectionDAO == null) {
            iSectionDAO = new SectionDAO();
        }
        return iSectionDAO;
    }
	
	public Stream<Section> getAll() throws Exception{
		List<Section> listPromo = new ArrayList<Section>();
		String[] table = { "Section" };
		String t = queryString.Query_Select(table, sectionAtt, "");
		ResultSet result = db.Get_DB(t);
		while (result.next()) {
			Section promo = new Section();
			promo.setIdSection(result.getInt(1));
			promo.setAnnee((Date) formatterDate.parse(result.getString(2)));
			listPromo.add(promo);
		}
		return listPromo.stream();
	}

	public <V>Section getById(V idSection) throws Exception{
		Section section = new Section();
		String[] table = { "Section" };
		String t = queryString.Query_Select(table, sectionAtt, "idSection = '"+idSection+"'");
		ResultSet result = db.Get_DB(t);
		while (result.next()) {
			section.setIdSection(result.getInt(1));
			section.setAnnee((Date) formatterDate.parse(result.getString(2)));
		}
		
		return section;
	}
	
	public Stream<Integer> getId() throws Exception{
		List<Integer> listPromo = new ArrayList<Integer>();
		String[] table = { "Section" };
		String[] champ = { "idSection" };
		String t = queryString.Query_Select(table, champ, "");
		ResultSet result = db.Get_DB(t);
		while (result.next()) 
			listPromo.add(result.getInt(1));
		return listPromo.stream();
	}
	
	public Boolean ajouter(Section section) throws Exception {
		String t = queryString.Query_Insert("Section", sectionAtt, sectionVal(section));
		return (db.Execute_DB(t));
	}

	public Boolean supprimer(Section Section) throws Exception {
		String condition = "idSection = '" + Section.getIdSection() + "'";
		String t = queryString.Query_Delete("Section", condition);
		return (db.Execute_DB(t));
	}

	public Boolean modifier(Section section) throws Exception {
		String condition = "idSection = '" + section.getIdSection() + "'";
		String t = queryString.Query_Update("Section", sectionAtt, sectionVal(section), condition);
		return (db.Execute_DB(t));
	}
	
	private String[] sectionAtt = { "idSection","annee" };
	private String[] sectionVal(Section section) {
		String[] res = new String[2];
		res[0] = section.getIdSection().toString();
		res[1] = formatterDate.format(section.getAnnee());
		return res;
	}
}
