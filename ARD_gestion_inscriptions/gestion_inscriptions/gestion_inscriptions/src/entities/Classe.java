package entities;
import java.util.List;

public class Classe {
    private int id;
    private String libelle;
    private Professeur professeur;
    public Classe() {
    }
    //OneToMany Une Classe peut avoir plusieurs Etudiants
    private List<Etudiant> EtudiantsInscrits;
    public List<Etudiant> getEtudiantsInscrits(int annee) {
        return EtudiantsInscrits;
    }
    public void setEtudiantsInscrits(List<Etudiant> etudiantsInscrits) {
        EtudiantsInscrits = etudiantsInscrits;
    }
    //ManyToOne une Classe peut avoir un objet de type professeur
    public Professeur getProfesseur() {
        return professeur;
    }
    // Setter pour affecter un professeur à la classe
    public void setProfesseur(Professeur professeur) {
        this.professeur = professeur;
    }
    

    // Getters and setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    public void inscrireEtudiant(Etudiant etudiant, int annee) {
        
        throw new UnsupportedOperationException("Unimplemented method 'inscrireEtudiant'");
    }


}
