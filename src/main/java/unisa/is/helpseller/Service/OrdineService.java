
package unisa.is.helpseller.Service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unisa.is.helpseller.Entity.Ordine;
import unisa.is.helpseller.Repo.OrdineRepo;

@Service
@Transactional
public class OrdineService {
    private final OrdineRepo ordineRepo;
    
    @Autowired
    public OrdineService(OrdineRepo ordineRepo) {this.ordineRepo = ordineRepo;}
    
    public List<Ordine> findAll() {
        return ordineRepo.findAll();
    }
    
    public Ordine findId(int id) {
        return ordineRepo.findId(id);
    }
    
    public void deleteId(int id) {
        ordineRepo.deleteId(id);
    }
    
    public void insert(Ordine ord) {
        ordineRepo.insert(ord.getCommento(), ord.getStato(), ord.getIdDistributore(), ord.getIdOrdineProva(), ord.getDataConsegna(), ord.getDataOrdinazione());
    }
    
    public void update(Ordine ord) {
        ordineRepo.update(ord.getCommento(), ord.getStato(), ord.getIdDistributore(), ord.getIdOrdineProva(), ord.getDataConsegna(), ord.getDataOrdinazione(), ord.getId());
    }
    
}
