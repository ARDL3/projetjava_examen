package services;
import java.util.List;
import entities.Classe;
import entities.Etudiant;
import entities.Inscription;
import repositories.InscriptionRepository;

public class InscriptionService {
    private InscriptionRepository inscriptionRepository;

    public InscriptionService(InscriptionRepository inscriptionRepository) {
        this.inscriptionRepository = inscriptionRepository;
    }

    public void inscrireEtudiant(Etudiant etudiant, Classe classe, int annee) {
        inscriptionRepository.insert(null);;
    }

    public List<Inscription> listEtudiantsInscrits(int annee) {
        return inscriptionRepository.selectAll();
    }
}
