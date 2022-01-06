
package unisa.is.helpseller.Service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unisa.is.helpseller.Entity.ScontoProdotto;
import unisa.is.helpseller.Repo.ScontoProdottoRepo;

@Service
@Transactional
public class ScontoProdottoService {
    private final ScontoProdottoRepo scontoProdottoRepo;
    
    @Autowired
    public ScontoProdottoService(ScontoProdottoRepo scontoProdottoRepo) {this.scontoProdottoRepo = scontoProdottoRepo;}

    public List<ScontoProdotto> findAll() {
        return scontoProdottoRepo.findAll();
    }
    
    public ScontoProdotto findId(int id) {
        return scontoProdottoRepo.findId(id);
    }
    
    public void deleteId(int id) {
        scontoProdottoRepo.deleteId(id);
    }
    
}
