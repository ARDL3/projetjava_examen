package repositories;


import java.sql.ResultSet;
import java.util.ArrayList;

import core.Database;
import entities.Inscription;

public class InscriptionRepository extends Database{
    
private final String SQL_INSERT="INSERT INTO `inscription` (`année`,``) VALUES (?,?) ";
private final String SQL_SELECT_ALL="SELECT * FROM `inscription`  ";

public void insert(Inscription inscription){
         
    try {
       ouvrirConnexion();
       initPrepareStatement(SQL_INSERT);
       statement.setInt(1, inscription.getAnnee());
       statement.setObject(2, inscription.getEtudiant());
       fermerConnexion();
    } catch (Exception e) 
     {
      System.out.println("Erreur de chargement du Driver");
     }
    }
public ArrayList<Inscription>  selectAll(){
        ArrayList<Inscription> inscriptions=new ArrayList<>();
    try {
        ouvrirConnexion();
         initPrepareStatement(SQL_SELECT_ALL);
         ResultSet rs= executeSelect();
         while (rs.next()) {
             Inscription inscription=new Inscription();
             inscription.setAnnee(rs.getInt("année"));
             //inscription.setLibelle(rs.getString("libellé"));
             inscriptions.add(inscription);
         }
         rs.close();
        fermerConnexion();
    } catch (Exception e) {
         System.out.println("Erreur de chargement du Driver");
         
    }
       return inscriptions;
     }
}
