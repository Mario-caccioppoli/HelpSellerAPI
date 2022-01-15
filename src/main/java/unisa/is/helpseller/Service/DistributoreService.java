
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
	@Autowired
    private final DistributoreRepo distributoreRepo;
    
    @Autowired
    public DistributoreService(DistributoreRepo distributoreRepo) {this.distributoreRepo = distributoreRepo;}

    public List<Distributore> findAll() {
        return distributoreRepo.findAll();
    }

    public Distributore findId(int id) {
        return distributoreRepo.findId(id);
    }
    
    public void deleteId(int id) {
        distributoreRepo.deleteId(id);
    }
    
      public void insert(Distributore d) {
        distributoreRepo.insert(d.getUsername(), d.getEmail(), d.getPassword(), d.getNome(), d.getCognome(), 
                d.getTelefono(), d.getIndirizzoSede(), d.getIdOrdineProva(), d.getvat());
    }
    
      public void update(Distributore d) {
        distributoreRepo.update(d.getUsername(), d.getEmail(), d.getPassword(), d.getNome(), d.getCognome(), 
                d.getTelefono(), d.getIndirizzoSede(), d.getIdOrdineProva(), d.getvat(), d.getId());
    }
}
