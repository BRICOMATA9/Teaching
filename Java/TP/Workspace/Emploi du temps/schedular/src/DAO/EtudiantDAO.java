/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Etudiant;
import Entities.Groupe;
import Interfaces.IEtudiantDAO;
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
public class EtudiantDAO implements IEtudiantDAO {

    private Connection connection;

    private EtudiantDAO() {
        connection = DataSource.getInstance().getConnection();
    }
    private static IEtudiantDAO iEtudiantDAO;

    public static IEtudiantDAO getInstance() {
        if (iEtudiantDAO == null) {
            iEtudiantDAO = new EtudiantDAO();
        }
        return iEtudiantDAO;
    }

    @Override
    public boolean insertEtudiant(Etudiant e) {
        String requete = "insert into etudiant (id,nom,prenom,niveau) values (?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, e.getId());
            ps.setString(2, e.getNom());
            ps.setString(3, e.getPrenom());
            ps.setString(4, e.getNiveau());
            ps.executeUpdate();
            System.out.println("Ajout etudiant effectuée avec succès");
            return true;
        } catch (SQLException ex) {
            System.out.println("erreur lors de l'insertion de l'etudiant " + ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean updateEtudiant(Etudiant e) {
        String requete = "update etudiant set  nom=?, prenom=?, niveau=? where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);

            ps.setString(1, e.getNom());
            ps.setString(2, e.getPrenom());
            ps.setString(3, e.getNiveau());
            ps.setInt(4, e.getId());
            ps.executeUpdate();
            System.out.println("Mise à jour etudiant effectuée avec succès");
            return true;
        } catch (SQLException ex) {
            System.out.println("erreur lors de la mise à jour etudiant " + ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteEtudiantById(int id) {
        String requete = "delete from etudiant where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Suppression etudiant effectuée avec succès");
            return true;
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression " + ex.getMessage());
            return false;
        }
    }

    @Override
    public Etudiant findEtudiantById(int id) {
        Etudiant e = new Etudiant();
        String requete = "select * from etudiant where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                e.setId(resultat.getInt(1));
                e.setNom(resultat.getString(2));
                e.setPrenom(resultat.getString(3));
                e.setNiveau(resultat.getString(4));
            }
            return e;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche deF etudiant par id " + ex.getMessage());
            return null;
        }
    }

    @Override
    public int findEtudiantByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Etudiant> displayGroupEtudiant(Groupe g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Etudiant> displayAllEtudiant() {
        List<Etudiant> listeEtudiant = new ArrayList<Etudiant>();
        String requete = "select * from etudiant";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
                Etudiant e = new Etudiant();
                e.setId(resultat.getInt(1));
                e.setNom(resultat.getString(2));
                e.setNom(resultat.getString(3));
                e.setNom(resultat.getString(4));

                listeEtudiant.add(e);
            }
            return listeEtudiant;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des etudiants " + ex.getMessage());
            return null;
        }
    }

}
