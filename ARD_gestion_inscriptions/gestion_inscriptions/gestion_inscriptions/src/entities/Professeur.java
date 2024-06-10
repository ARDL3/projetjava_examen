package entities;

public class Professeur {
    
    private int nci;
    private String nomComplet;
    private String grade;
    
    private Classe classe;
    public Professeur() {
    }
    
    //OneToMany Une Professeur peut avoir plusieurs Classes
    //private List<Classe> classes;

    

    // Getters and setters
    public int getNci() {
        return nci;
    }

    public void setNci(int nci) {
        this.nci = nci;
    }

    public String getNomComplet() {
        return nomComplet;
    }

    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
    public Classe getClasse() {
        return classe;
    }
    public void setClasse(Classe classe) {
        this.classe = classe;
    }
}
