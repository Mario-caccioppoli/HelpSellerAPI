
package unisa.is.helpseller.Service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unisa.is.helpseller.Model.Ordine;
import unisa.is.helpseller.Repo.OrdineRepo;

@Service
@Transactional
public class OrdineService {
    private final OrdineRepo ordineRepo;
    
    @Autowired
    public OrdineService(OrdineRepo ordineRepo) {this.ordineRepo = ordineRepo;}
    
    public Ordine addOrdine(Ordine a) {
        return ordineRepo.save(a);
    }
    
    public List<Ordine> findAllOrdine() {
        return ordineRepo.findAll();
    }
    
    public Ordine updateOrdine(Ordine a) {
        return ordineRepo.save(a);
    }
    
    public Ordine findOrdineById(long id) {
        return ordineRepo.getById(id);
    }
    
    public void deleteOrdine(Ordine a) {
        ordineRepo.delete(a);
    }
    
}
