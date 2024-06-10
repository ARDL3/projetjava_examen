package repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import core.Database;
import entities.Classe;

public class ClasseRepository extends Database {

    private final String SQL_INSERT = "INSERT INTO `classe` (`libellé`) VALUES (?)";
    private final String SQL_SELECT_ALL = "SELECT * FROM `classe`";
    private final String SQL_SELECT_ID = "SELECT * FROM `classe` WHERE `id_classe` = ?";

    public void insert(Classe classe) {
        try {
            ouvrirConnexion();
            initPrepareStatement(SQL_INSERT);
            statement.setString(1, classe.getLibelle());
            executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'insertion de la classe : " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                fermerConnexion();
            } catch (SQLException e) {
                System.out.println("Erreur lors de la fermeture de la connexion : " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    public List<Classe> selectAll() {
        List<Classe> classes = new ArrayList<>();
        ResultSet rs = null;
        try {
            ouvrirConnexion();
            initPrepareStatement(SQL_SELECT_ALL);
            rs = executeSelect();
            while (rs.next()) {
                Classe classe = new Classe();
                classe.setId(rs.getInt("id_classe"));
                classe.setLibelle(rs.getString("libellé"));
                classes.add(classe);
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la sélection des classes : " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
            } catch (SQLException e) {
                System.out.println("Erreur lors de la fermeture du ResultSet : " + e.getMessage());
                e.printStackTrace();
            }
            try {
                fermerConnexion();
            } catch (SQLException e) {
                System.out.println("Erreur lors de la fermeture de la connexion : " + e.getMessage());
                e.printStackTrace();
            }
        }
        return classes;
    }

    public Classe selectById(int id) {
        Classe classe = null;
        ResultSet rs = null;
        try {
            ouvrirConnexion();
            initPrepareStatement(SQL_SELECT_ID);
            statement.setInt(1, id);
            rs = executeSelect();
            if (rs.next()) {
                classe = new Classe();
                classe.setId(rs.getInt("id_classe"));
                classe.setLibelle(rs.getString("libellé"));
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la sélection de la classe par ID : " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
            } catch (SQLException e) {
                System.out.println("Erreur lors de la fermeture du ResultSet : " + e.getMessage());
                e.printStackTrace();
            }
            try {
                fermerConnexion();
            } catch (SQLException e) {
                System.out.println("Erreur lors de la fermeture de la connexion : " + e.getMessage());
                e.printStackTrace();
            }
        }
        return classe;
    }
}
