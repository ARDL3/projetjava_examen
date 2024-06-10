package services;

import entities.Classe;
import entities.Etudiant;
import repositories.EtudiantRepository;
import java.util.List;

public class EtudiantService {
    private EtudiantRepository etudiantRepository = new EtudiantRepository();
    
    public void addEtudiant(Etudiant etudiant) {
        etudiantRepository.insert(etudiant);
    }

    public List<Etudiant> listEtudiants() {
        return etudiantRepository.selectAll();
    }

    public List<Etudiant> listEtudiantsParClasse(Classe classe) {
        return etudiantRepository.selectByClasse(classe);
    }
}
