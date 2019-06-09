/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Cours;
import Entities.Enseignant;
import Entities.Groupe;
import Interfaces.ICoursDAO;
import Interfaces.IEnseignantDAO;
import Utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hajji
 */
public class CoursDAO implements ICoursDAO{
    private Connection connection;

    private CoursDAO() {
        connection = DataSource.getInstance().getConnection();
    }
    private static ICoursDAO iCoursDAO;

    public static ICoursDAO getInstance() {
        if (iCoursDAO == null) {
            iCoursDAO = new CoursDAO();
        }
        return iCoursDAO;
    }
    @Override
    public boolean insertCours(Cours c) {
       String requete = "insert into cours (id,enseignant,groupe,matiere) values (?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, c.getId());
            ps.setInt(2, c.getEnseignant().getId());
            ps.setInt(3, c.getGroupe().getId());
            ps.setString(4, c.getMatiere());
            ps.executeUpdate();
            System.out.println("Ajout cours effectuée avec succès");
            return true;
        } catch (SQLException ex) {
            System.out.println("erreur lors de l'insertion de cours" + ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean updateCours(Cours c) {
        String requete = "update cours set  enseignant=?, groupe=?, matiere=? where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);

            ps.setInt(1, c.getEnseignant().getId());
            ps.setInt(2, c.getGroupe().getId());
            ps.setString(3, c.getMatiere());
            ps.setInt(4, c.getId());
            ps.executeUpdate();
            System.out.println("Mise à jour cours effectuée avec succès");
            return true;
        } catch (SQLException ex) {
            System.out.println("erreur lors de la mise à jour cours " + ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteCoursById(int id) {
        String requete = "delete from cours where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Suppression cours effectuée avec succès");
            return true;
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression de cours " + ex.getMessage());
            return false;
        }
    }

    @Override
    public Cours findCoursById(int id) {
        Cours c = new Cours();
        String requete = "select * from cours where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                c.setId(resultat.getInt(1));
                Enseignant e=EnseignantDAO.getInstance().findEnseignantById(resultat.getInt(2));
                c.setEnseignant(e);
                Groupe g=GroupeDAO.getInstance().findGroupeById(resultat.getInt(3));
                c.setGroupe(g);
                c.setMatiere(resultat.getString(4));
            }
            return c;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche de cours par id " + ex.getMessage());
            return null;
        }
    }

    @Override
    public int findCoursByLibelle(String libelle) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Cours> displayAllCours() {
        List<Cours> listeCours = new ArrayList<Cours>();
        String requete = "select * from cours";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
                Cours c = new Cours();
                c.setId(resultat.getInt(1));
                c.setEnseignant(EnseignantDAO.getInstance().findEnseignantById(resultat.getInt(2)));
                c.setGroupe(GroupeDAO.getInstance().findGroupeById(resultat.getInt(3)));
                c.setMatiere(resultat.getString(4));

                listeCours.add(c);
            }
            return listeCours;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des cours " + ex.getMessage());
            return null;
        }
    }
    
}
