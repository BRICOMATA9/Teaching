/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Groupe;
import Interfaces.IGroupeDAO;
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
public class GroupeDAO implements IGroupeDAO{
    private Connection connection;

    private GroupeDAO() {
        connection = DataSource.getInstance().getConnection();
    }
    private static IGroupeDAO iGroupeDAO;

    public static IGroupeDAO getInstance() {
        if (iGroupeDAO == null) {
            iGroupeDAO = new GroupeDAO();
        }
        return iGroupeDAO;
    }
    @Override
    public boolean insertGroupe(Groupe g) {
        String requete = "insert into groupe (id,libelle) values (?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, g.getId());
            ps.setString(2, g.getLibelle());
            ps.executeUpdate();
            System.out.println("Ajout groupe effectuée avec succès");
            return true;
        } catch (SQLException ex) {
            System.out.println("erreur lors de l'insertion de groupe" + ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean updateGroupe(Groupe g) {
        String requete = "update groupe set  libelle=? where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);

            ps.setString(1, g.getLibelle());
            ps.setInt(2, g.getId());
            ps.executeUpdate();
            System.out.println("Mise à jour groupe effectuée avec succès");
            return true;
        } catch (SQLException ex) {
            System.out.println("erreur lors de la mise à jour groupe " + ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteGroupeById(int id) {
        String requete = "delete from groupe where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Suppression groupe effectuée avec succès");
            return true;
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression de groupe " + ex.getMessage());
            return false;
        }
    }

    @Override
    public Groupe findGroupeById(int id) {
        Groupe g = new Groupe();
        String requete = "select * from groupe where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                g.setId(resultat.getInt(1));
                g.setLibelle(resultat.getString(2));
            }
            g.setListetudiant(EtudiantDAO.getInstance().displayGroupEtudiant(g));
            return g;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche de groupe par id " + ex.getMessage());
            return null;
        }
    }

    @Override
    public Groupe findGroupeByLibelle(String libelle) {
        Groupe g = new Groupe();
        String requete = "select * from groupe where libelle=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, libelle);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                g.setId(resultat.getInt(1));
                g.setLibelle(resultat.getString(2));
            }
            g.setListetudiant(EtudiantDAO.getInstance().displayGroupEtudiant(g));
            return g;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche de groupe par libelle " + ex.getMessage());
            return null;
        }
    }

    @Override
    public List<Groupe> displayAllGroupe() {
        List<Groupe> listegroupe = new ArrayList<Groupe>();
        String requete = "select * from groupe";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
                Groupe g = new Groupe();
                g.setId(resultat.getInt(1));
                g.setLibelle(resultat.getString(2));
                g.setListetudiant(EtudiantDAO.getInstance().displayGroupEtudiant(g));
                listegroupe.add(g);
            }
            return listegroupe;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des groupes " + ex.getMessage());
            return null;
        }
    }
    
}
