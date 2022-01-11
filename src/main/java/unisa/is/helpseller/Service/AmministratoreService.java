
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
    
    public List<Amministratore> findAll() {
        return amministratoreRepo.findAll();
    }
    
    public Amministratore findId(int id) {
        return amministratoreRepo.findId(id);
    }
    
    public void deleteId(int id) {
        amministratoreRepo.deleteId(id);
    }
    
    public void insert(Amministratore a) {
        amministratoreRepo.insert(a.getUsername(), a.getEmail(), a.getPassword());
    }
    
    public void udpate(Amministratore a) {
        amministratoreRepo.update(a.getUsername(), a.getEmail(), a.getPassword(), a.getId());
    }
    
}
