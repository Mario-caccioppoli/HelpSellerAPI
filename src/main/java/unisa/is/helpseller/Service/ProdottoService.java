
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
    
    public List<Prodotto> findAll() {
        return prodottoRepo.findAll();
    }

    public Prodotto findId(int id) {
        return prodottoRepo.findId(id);
    }
    
    public void deleteId(int id) {
        prodottoRepo.deleteId(id);
    }
    
    public void insert(Prodotto prod) {
        prodottoRepo.insert(prod.getNomeProdotto(), prod.getPrezzo(), prod.getDescrizione(), 
                prod.getQuantita(), prod.getImmagine(), prod.getPeso(), prod.getVolume(), prod.getIdAzienda(), prod.getQuantitaMinima());
    }
    
    public void udpate(Prodotto prod) {
        prodottoRepo.update(prod.getNomeProdotto(), prod.getPrezzo(), prod.getDescrizione(), 
                prod.getQuantita(), prod.getImmagine(), prod.getPeso(), prod.getVolume(), prod.getIdAzienda(), prod.getQuantitaMinima(), prod.getId());
    }
    
    public List<Prodotto> findProdottiByAzienda(int id_azienda) {
       return prodottoRepo.findProdottiByAzienda(id_azienda);
    }
}
