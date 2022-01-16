
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
	@Autowired
    private final OrdineRepo ordineRepo;
    
    @Autowired
    public OrdineService(OrdineRepo ordineRepo) {this.ordineRepo = ordineRepo;}
    
    public List<Ordine> findAll() {
        return ordineRepo.findAll();
    }
    
    public Ordine findId(int id) {
        return ordineRepo.findId(id);
    }
    
    public int deleteId(int id) {
    	return ordineRepo.deleteId(id);
    }
    
    public int insert(Ordine ord) {
    	return ordineRepo.insert(ord.getCommento(), ord.getStato(), ord.getIdDistributore(), ord.getDataConsegna(), ord.getDataOrdinazione());
    }
    
    public int update(Ordine ord) {
    	return ordineRepo.update(ord.getCommento(), ord.getStato(), ord.getIdDistributore(), ord.getDataConsegna(), ord.getDataOrdinazione(), ord.getId());
    }
    
    public List<Ordine> findOrdiniByDistributore(int id_distributore) {
        return ordineRepo.findOrdiniByDistributore(id_distributore);
    }
    
    public List<Ordine> findOrdiniByAzienda(int id_azienda) {
        return ordineRepo.findOrdiniByAzienda(id_azienda);
    }
}
