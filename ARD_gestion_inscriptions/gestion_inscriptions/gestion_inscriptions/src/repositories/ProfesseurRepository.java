package repositories;

import java.sql.ResultSet;
import java.util.ArrayList;

import core.Database;
import entities.Classe;
import entities.Professeur;

public class ProfesseurRepository extends Database{
    //"INSERT INTO `professeur` (`nom_complet_professeur`, `grade`, `classe_id`) VALUES (?,?,?)";
    private final String SQL_INSERT="INSERT INTO `professeur` (`nom_complet_professeur`, `grade`, `classe_id`) VALUES (?,?,?)";
    private final String SQL_SELECT_ALL="SELECT * FROM `professeur` pr, classe cl WHERE pr.classe_id=cl.id_classe";
    
      public void insert(Professeur professeur){
        ouvrirConnexion();
        initPrepareStatement(SQL_INSERT);
          try {
             
             //statement.setString(1, professeur.getNci());
             statement.setString(1, professeur.getNomComplet());
             statement.setString(2, professeur.getGrade());
             statement.setInt(3, professeur.getClasse().getId());
              executeUpdate();
             fermerConnexion();
          } catch (Exception e) 
           {
            //System.out.println("Erreur de chargement du Driver");
            e.printStackTrace();
           }
          }




      public ArrayList<Professeur>  selectAll(){
        ArrayList<Professeur> professeurs=new ArrayList<>();
        ouvrirConnexion();
         initPrepareStatement(SQL_SELECT_ALL);
         ResultSet rs= executeSelect();
    try {
        
         while (rs.next()) {
             Classe classe=new Classe();
             classe.setId(rs.getInt("id_classe"));
             classe.setLibelle(rs.getString("libellé"));
             Professeur professeur=new Professeur();
             //professeur.setId(rs.getInt("id_professeur"));
             professeur.setNci(rs.getInt("Nci_professeur"));
             professeur.setNomComplet(rs.getString("nom_complet_professeur"));
             professeur.setGrade(rs.getString("grade"));
             professeur.setClasse(classe);
             professeurs.add(professeur);
         }
         rs.close();
         conn.close();
    } catch (Exception e) {
         //System.out.println("Erreur de chargement du Driver");
         e.printStackTrace();
    }
       return professeurs;
     }




     public Professeur selectByclasse(int id) {
          // TODO Auto-generated method stub
          throw new UnsupportedOperationException("Unimplemented method 'selectByclasse'");
     }
     
     
}
