/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Enseignant;
import Entities.Groupe;
import java.util.List;
import Interfaces.IEnseignantDAO;
import Utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *

    
 * @author hajji
 */
public class EnseignantDAO implements IEnseignantDAO{
    private Connection connection;

    private EnseignantDAO() {
        connection = DataSource.getInstance().getConnection();
    }
    private static IEnseignantDAO iEnseignantDAO;

    public static IEnseignantDAO getInstance() {
        if (iEnseignantDAO == null) {
            iEnseignantDAO = new EnseignantDAO();
        }
        return iEnseignantDAO;
    }
    @Override
    public boolean insertEnseignant(Enseignant e) {
        String requete = "insert into enseignant (id,nom,prenom,specialite) values (?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, e.getId());
            ps.setString(2, e.getNom());
            ps.setString(3, e.getPrenom());
            ps.setString(4, e.getSpecialite());
            ps.executeUpdate();
            System.out.println("Ajout Enseignant effectuée avec succès");
            return true;
        } catch (SQLException ex) {
            System.out.println("erreur lors de l'insertion de l'Enseignant" + ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean updateEnseignant(Enseignant e) {
        String requete = "update enseignant set  nom=?, prenom=?, specialite=? where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);

            ps.setString(1, e.getNom());
            ps.setString(2, e.getPrenom());
            ps.setString(3, e.getSpecialite());
            ps.setInt(4, e.getId());
            ps.executeUpdate();
            System.out.println("Mise à jour enseignant effectuée avec succès");
            return true;
        } catch (SQLException ex) {
            System.out.println("erreur lors de la mise à jour enseignant " + ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteEnseignantById(int id) {
        String requete = "delete from enseignant where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Suppression enseignant effectuée avec succès");
            return true;
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression de l'enseignant " + ex.getMessage());
            return false;
        }
    }

    @Override
    public Enseignant findEnseignantById(int id) {
        Enseignant e = new Enseignant();
        String requete = "select * from enseignant where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                e.setId(resultat.getInt(1));
                e.setNom(resultat.getString(2));
                e.setPrenom(resultat.getString(3));
                e.setSpecialite(resultat.getString(4));
            }
            return e;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche de l'enseignant par id " + ex.getMessage());
            return null;
        }
    }

    @Override
    public int findEnseignantByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Enseignant> displayGroupEnseignant(Groupe g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Enseignant> displayAllEnseignant() {
        List<Enseignant> listeEnseignant = new ArrayList<Enseignant>();
        String requete = "select * from enseignant";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
                Enseignant e = new Enseignant();
                e.setId(resultat.getInt(1));
                e.setNom(resultat.getString(2));
                e.setPrenom(resultat.getString(3));
                e.setSpecialite(resultat.getString(4));

                listeEnseignant.add(e);
            }
            return listeEnseignant;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des enseignants " + ex.getMessage());
            return null;
        }
    }
}
