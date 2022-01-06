
package unisa.is.helpseller.Service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unisa.is.helpseller.Entity.Amministratore;
import unisa.is.helpseller.Repo.AmministratoreRepo;

@Service
@Transactional
public class AmministratoreService {
    private final AmministratoreRepo amministratoreRepo;
    
    @Autowired
    public AmministratoreService(AmministratoreRepo amministratoreRepo) {this.amministratoreRepo = amministratoreRepo;}
    
    public List<Amministratore> findAllAmministratore() {
        return amministratoreRepo.findAll();
    }
    
    public Amministratore findAmministratore(int id) {
        return amministratoreRepo.findId(id);
    }
    
    public void deleteAmministratore(int id) {
        amministratoreRepo.deleteId(id);
    }
    
}
