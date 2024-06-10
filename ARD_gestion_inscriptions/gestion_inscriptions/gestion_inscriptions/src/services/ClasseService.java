package services;
import java.util.List;

import entities.Classe;
import repositories.ClasseRepository;

public class ClasseService {

    private ClasseRepository classeRepository=new ClasseRepository();
         public void addClasse(Classe classe){
            classeRepository.insert(classe);
         }
         public List<Classe> listerClasses(){
            return classeRepository.selectAll();
         }
         public Classe recherClasseParId(int id){
            return classeRepository.selectById(id);
         }
         
}


