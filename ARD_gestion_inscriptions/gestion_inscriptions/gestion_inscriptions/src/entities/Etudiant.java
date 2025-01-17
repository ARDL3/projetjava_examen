package entities;

public class Etudiant {
    private String matricule;
    private String nomComplet;
    private String tuteur;
    private Classe classe;

    //OneToMany
    
    public Etudiant() {
    }
    

    // Getters and setters
    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getNomComplet() {
        return nomComplet;
    }

    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }

    public String getTuteur() {
        return tuteur;
    }

    public void setTuteur(String tuteur) {
        this.tuteur = tuteur;
    }
    public Classe getClasse() {
        return classe;
    }


    public void setClasse(Classe classe) {
        this.classe = classe;
    }
    
}
