package services;

import java.util.List;
import entities.Professeur;
import repositories.ProfesseurRepository;

public class ProfesseurService {
    private ProfesseurRepository professeurRepository=new ProfesseurRepository();

   

    public void addProfesseur(Professeur professeur) {
        professeurRepository.insert(professeur);
    }

    public List<Professeur> listProfesseurs() {
        return professeurRepository.selectAll();
    }
}
