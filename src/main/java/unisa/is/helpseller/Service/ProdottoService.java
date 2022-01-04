
package unisa.is.helpseller.Service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unisa.is.helpseller.Entity.Prodotto;
import unisa.is.helpseller.Repo.ProdottoRepo;

@Service
@Transactional
public class ProdottoService {
    private final ProdottoRepo prodottoRepo;
    
    @Autowired
    public ProdottoService(ProdottoRepo prodottoRepo) {this.prodottoRepo = prodottoRepo;}
    
    public Prodotto addProdotto(Prodotto a) {
        return prodottoRepo.save(a);
    }
    
    public List<Prodotto> findAllProdotto() {
        return prodottoRepo.findAll();
    }
    
    public Prodotto updateProdotto(Prodotto a) {
        return prodottoRepo.save(a);
    }
    
    public Prodotto findProdottoById(long id) {
        return prodottoRepo.getById(id);
    }
    
    public void deleteProdotto(Long id) {
        prodottoRepo.deleteById(id);
    }
    
}
