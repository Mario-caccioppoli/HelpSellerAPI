
package unisa.is.helpseller.Service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unisa.is.helpseller.Entity.Distributore;
import unisa.is.helpseller.Repo.DistributoreRepo;

@Service
@Transactional
public class DistributoreService {
    private final DistributoreRepo distributoreRepo;
    
    @Autowired
    public DistributoreService(DistributoreRepo distributoreRepo) {this.distributoreRepo = distributoreRepo;}
    
    public Distributore addDistributore(Distributore a) {
        return distributoreRepo.save(a);
    }
    
    public List<Distributore> findAllDistributore() {
        return distributoreRepo.findAll();
    }
    
    public Distributore updateDistributore(Distributore a) {
        return distributoreRepo.save(a);
    }
    
    public Distributore findDistributoreById(long id) {
        return distributoreRepo.getById(id);
    }
    
    public void deleteDistributore(Long id) {
        distributoreRepo.deleteById(id);
    }
    
}
