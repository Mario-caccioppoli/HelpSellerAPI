
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
	@Autowired
    private final AmministratoreRepo amministratoreRepo;
    
    @Autowired
    public AmministratoreService(AmministratoreRepo amministratoreRepo) {this.amministratoreRepo = amministratoreRepo;}
    
    public List<Amministratore> findAll() {
        return amministratoreRepo.findAll();
    }
    
    public Amministratore findId(int id) {
        return amministratoreRepo.findId(id);
    }
    
    public int deleteId(int id) {
        return amministratoreRepo.deleteId(id);
    }
    
    public int insert(Amministratore a) {
    	return amministratoreRepo.insert(a.getUsername(), a.getEmail(), a.getPassword());
    }
    
    public int udpate(Amministratore a) {
    	return amministratoreRepo.update(a.getUsername(), a.getEmail(), a.getPassword(), a.getId());
    }
    
}
