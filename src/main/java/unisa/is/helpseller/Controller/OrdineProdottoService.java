
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

    public List<OrdineProdotto> findAll() {
        return ordineProdottoRepo.findAll();
    }

    public OrdineProdotto findId(int id) {
        return ordineProdottoRepo.findId(id);
    }
    
    public void deleteId(int id) {
        ordineProdottoRepo.deleteId(id);
    }
    
}
