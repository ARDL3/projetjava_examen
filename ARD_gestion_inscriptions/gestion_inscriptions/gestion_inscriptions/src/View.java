import java.util.List;
import java.util.Scanner;
import entities.Classe;
import entities.Etudiant;
import entities.Professeur;
import services.ClasseService;
import services.EtudiantService;
import services.ProfesseurService;

public class View {
    public static void main(String[] args) throws Exception {
        ClasseService classeService = new ClasseService();
        ProfesseurService professeurService = new ProfesseurService();
        EtudiantService etudiantService = new EtudiantService();
        Scanner scanner = new Scanner(System.in);
        int choix;
        do {
            System.out.println("++++++++GESTION DES INSCRIPTIONS++++++++");
            System.out.println("1-Creer une Classe");
            System.out.println("2-Lister les Classes");
            System.out.println("3-Ajouter un professeur et lui associer une classe");
            System.out.println("4-Lister les professeurs en affichant sa classe ");
            System.out.println("5-Inscrire un nouvel étudiant et lui associer une classe");
            System.out.println("6-Lister les étudiants inscrits");
            System.out.println("7-Lister les étudiants par classe");
            System.out.println("8-Quitter");
            choix = scanner.nextInt();
            scanner.nextLine();
            switch (choix) {
                case 1:
                    Classe classe = new Classe();
                    System.out.println("Entrer le libellé");
                    classe.setLibelle(scanner.nextLine());
                    classeService.addClasse(classe);
                    break;
                case 2:
                    List<Classe> classes = classeService.listerClasses();
                    for (Classe cl : classes) {
                        System.out.println("id: " + cl.getId());
                        System.out.println("Classe: " + cl.getLibelle());
                        System.out.println("==================================");
                    }
                    break;
                case 3:
                    System.out.println("ID de la classe");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // consomme la nouvelle ligne
                    classe = classeService.recherClasseParId(id);
                    if (classe == null) {
                        System.out.println("Erreur d'ID");
                    } else {
                        Professeur professeur = new Professeur();
                        System.out.println("Entrer le nom complet du professeur");
                        professeur.setNomComplet(scanner.nextLine());
                        System.out.println("Entrer le grade du professeur");
                        professeur.setGrade(scanner.nextLine());
                        professeur.setClasse(classe);
                        professeurService.addProfesseur(professeur);
                    }
                    break;
                case 4:
                    List<Professeur> professeurs = professeurService.listProfesseurs();
                    for (Professeur pr : professeurs) {
                        //System.out.println("Nci: " + pr.getNci());
                        System.out.println("Classe: " + pr.getClasse().getLibelle());
                        System.out.println("Nom du Professeur: " + pr.getNomComplet());
                        System.out.println("grade: " + pr.getGrade());
                        System.out.println("==================================");
                    }
                    break;
                case 5:
                    System.out.println("ID de la classe");
                    id = scanner.nextInt();
                    scanner.nextLine(); 
                    classe = classeService.recherClasseParId(id);
                    if (classe == null) {
                        System.out.println("Erreur d'ID");
                    } else {
                        Etudiant etudiant = new Etudiant();
                        System.out.println("Entrer le matricule");
                        etudiant.setMatricule(scanner.nextLine());
                        System.out.println("Entrer le nom complet");
                        etudiant.setNomComplet(scanner.nextLine());
                        System.out.println("Entrer le nom du tuteur");
                        etudiant.setTuteur(scanner.nextLine());
                        etudiant.setClasse(classe);
                        etudiantService.addEtudiant(etudiant);
                    }
                    break;
                case 6:
                    List<Etudiant> etudiants = etudiantService.listEtudiants();
                    for (Etudiant et : etudiants) {
                        System.out.println("Matricule: " + et.getMatricule());
                        System.out.println("Nom complet: " + et.getNomComplet());
                        System.out.println("Tuteur: " + et.getTuteur());
                        System.out.println("Classe: " + et.getClasse().getLibelle());
                        System.out.println("==================================");
                    }
                    break;
                case 7:
                    System.out.println("ID de la classe");
                    id = scanner.nextInt();
                    scanner.nextLine(); // consomme la nouvelle ligne
                    classe = classeService.recherClasseParId(id);
                    if (classe == null) {
                        System.out.println("Erreur d'ID");
                    } else {
                        etudiants = etudiantService.listEtudiantsParClasse(classe);
                        for (Etudiant et : etudiants) {
                            System.out.println("Matricule: " + et.getMatricule());
                            System.out.println("Nom complet: " + et.getNomComplet());
                            System.out.println("Tuteur: " + et.getTuteur());
                            System.out.println("==================================");
                        }
                    }
                    break;
            }
        } while (choix != 8);
        scanner.close();
    }
}
