
package unisa.is.helpseller.Service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unisa.is.helpseller.Entity.OrdineProdotto;
import unisa.is.helpseller.Repo.OrdineProdottoRepo;

@Service
@Transactional
public class OrdineProdottoService {
    private final OrdineProdottoRepo ordineProdottoRepo;
    
    @Autowired
    public OrdineProdottoService(OrdineProdottoRepo ordineProdottoRepo) {this.ordineProdottoRepo = ordineProdottoRepo;}
    
    public OrdineProdotto addOrdineProdotto(OrdineProdotto a) {
        return ordineProdottoRepo.save(a);
    }
    
    public List<OrdineProdotto> findAllOrdineProdotto() {
        return ordineProdottoRepo.findAll();
    }
    
    public OrdineProdotto updateOrdineProdotto(OrdineProdotto a) {
        return ordineProdottoRepo.save(a);
    }
    
    public OrdineProdotto findOrdineProdottoById(long id) {
        return ordineProdottoRepo.getById(id);
    }
    
    public void deleteOrdineProdotto(Long id) {
        ordineProdottoRepo.deleteById(id);
    }
    
}
