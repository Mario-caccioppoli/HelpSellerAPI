
package unisa.is.helpseller.Service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unisa.is.helpseller.Model.ScontoProdotto;
import unisa.is.helpseller.Repo.ScontoProdottoRepo;

@Service
@Transactional
public class ScontoProdottoService {
    private final ScontoProdottoRepo scontoProdottoRepo;
    
    @Autowired
    public ScontoProdottoService(ScontoProdottoRepo scontoProdottoRepo) {this.scontoProdottoRepo = scontoProdottoRepo;}
    
    public ScontoProdotto addScontoProdotto(ScontoProdotto a) {
        return scontoProdottoRepo.save(a);
    }
    
    public List<ScontoProdotto> findAllScontoProdotto() {
        return scontoProdottoRepo.findAll();
    }
    
    public ScontoProdotto updateScontoProdotto(ScontoProdotto a) {
        return scontoProdottoRepo.save(a);
    }
    
    public ScontoProdotto findScontoProdottoById(long id) {
        return scontoProdottoRepo.getById(id);
    }
    
    public void deleteScontoProdotto(ScontoProdotto a) {
        scontoProdottoRepo.delete(a);
    }
    
}
