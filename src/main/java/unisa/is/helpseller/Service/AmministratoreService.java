
package unisa.is.helpseller.Service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unisa.is.helpseller.Model.Amministratore;
import unisa.is.helpseller.Repo.AmministratoreRepo;

@Service
@Transactional
public class AmministratoreService {
    private final AmministratoreRepo amministratoreRepo;
    
    @Autowired
    public AmministratoreService(AmministratoreRepo amministratoreRepo) {this.amministratoreRepo = amministratoreRepo;}
    
    public Amministratore addAmministratore(Amministratore a) {
        return amministratoreRepo.save(a);
    }
    
    public List<Amministratore> findAllAmministratore() {
        return amministratoreRepo.findAll();
    }
    
    public Amministratore updateAmministratore(Amministratore a) {
        return amministratoreRepo.save(a);
    }
    
    public Amministratore findAmministratoreById(Long id) {
        return amministratoreRepo.getById(id);
    }
    
    public void deleteAmministratore(Long id) {
        amministratoreRepo.deleteById(id);
    }
    
}
