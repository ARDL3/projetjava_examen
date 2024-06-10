package repositories;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import core.Database;
import entities.Classe;
import entities.Etudiant;

public class EtudiantRepository extends Database {

    private final String SQL_INSERT = "INSERT INTO `étudiant` (`nom_complet_étudiant`, `tuteur`, `classe_id`) VALUES (?, ?, ?)";
    private final String SQL_SELECT_ALL = "SELECT * FROM `étudiant`";
    private final String SQL_SELECT_BY_CLASSE = "SELECT * FROM `étudiant` WHERE `classe_id` = ?";

    public void insert(Etudiant etudiant) {
        try {
            ouvrirConnexion();
            initPrepareStatement(SQL_INSERT);
            statement.setString(1, etudiant.getNomComplet());
            statement.setString(2, etudiant.getTuteur());
            statement.setInt(3, etudiant.getClasse().getId());
            executeUpdate();
            fermerConnexion();
        } catch (Exception e) {
            System.out.println("Erreur de chargement du Driver");
            e.printStackTrace();
        }
    }

    public List<Etudiant> selectAll() {
        List<Etudiant> etudiants = new ArrayList<>();
        try {
            ouvrirConnexion();
            initPrepareStatement(SQL_SELECT_ALL);
            ResultSet rs = executeSelect();
            while (rs.next()) {
                Etudiant etudiant = new Etudiant();
                etudiant.setMatricule(rs.getString("matricule"));
                etudiant.setNomComplet(rs.getString("nom_complet_étudiant"));
                etudiant.setTuteur(rs.getString("tuteur"));
                // Assume we can fetch the class details somehow if needed
                etudiants.add(etudiant);
            }
            rs.close();
            fermerConnexion();
        } catch (Exception e) {
            System.out.println("Erreur de chargement du Driver");
            e.printStackTrace();
        }
        return etudiants;
    }

    public List<Etudiant> selectByClasse(Classe classe) {
        List<Etudiant> etudiants = new ArrayList<>();
        try {
            ouvrirConnexion();
            initPrepareStatement(SQL_SELECT_BY_CLASSE);
            statement.setInt(1, classe.getId());
            ResultSet rs = executeSelect();
            while (rs.next()) {
                Etudiant etudiant = new Etudiant();
                etudiant.setMatricule(rs.getString("matricule"));
                etudiant.setNomComplet(rs.getString("nom_complet_étudiant"));
                etudiant.setTuteur(rs.getString("tuteur"));
                etudiant.setClasse(classe); // Associate the class with the student
                etudiants.add(etudiant);
            }
            rs.close();
            fermerConnexion();
        } catch (Exception e) {
            System.out.println("Erreur de chargement du Driver");
            e.printStackTrace();
        }
        return etudiants;
    }
}
