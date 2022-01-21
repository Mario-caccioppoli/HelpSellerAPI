
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
	@Autowired
    private final ScontoProdottoRepo scontoProdottoRepo;
    
    @Autowired
    public ScontoProdottoService(ScontoProdottoRepo scontoProdottoRepo) {this.scontoProdottoRepo = scontoProdottoRepo;}

    public List<ScontoProdotto> findAll() {
        return scontoProdottoRepo.findAll();
    }
    
    public List<ScontoProdotto> findAllScontoProdotto() {
        return scontoProdottoRepo.findAllScontoProdotto();
    }
    
    public List<ScontoProdotto> findBySconto(int id) {
        return scontoProdottoRepo.findBySconto(id);
    }
    
    public List<ScontoProdotto> findByProdotto(int id) {
        return scontoProdottoRepo.findByProdotto(id);
    }
    
    public int deleteId(int id_prodotto, int id_sconto) {
    	return scontoProdottoRepo.deleteId(id_prodotto, id_sconto);
    }
    
    public int insert(ScontoProdotto scontoProd) {
    	return scontoProdottoRepo.insert(scontoProd.getIdSconto(), scontoProd.getIdProdotto());
    }
    
    public int udpate(ScontoProdotto updated, ScontoProdotto old) {
    	return scontoProdottoRepo.update(updated.getIdSconto(), updated.getIdProdotto(), old.getIdSconto(), old.getIdProdotto());
    }
    
    public List<Object[]> findProdottiScontatiAzienda(String nome, int id_azienda) {
        return scontoProdottoRepo.findProdottiScontatiAzienda(nome, id_azienda);
    }
}
