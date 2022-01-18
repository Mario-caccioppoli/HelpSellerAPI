
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
	@Autowired
    private final ProdottoRepo prodottoRepo;
    
    @Autowired
    public ProdottoService(ProdottoRepo prodottoRepo) {this.prodottoRepo = prodottoRepo;}
    
    public List<Prodotto> findAll() {
        return prodottoRepo.findAll();
    }

    public Prodotto findId(int id) {
        return prodottoRepo.findId(id);
    }
    
    public int deleteId(int id) {
    	return prodottoRepo.deleteId(id);
    }
    
    public int insert(Prodotto prod) {
    	return prodottoRepo.saveAndFlush(prod).getId();
    }
    
    public int udpate(Prodotto prod) {
    	return prodottoRepo.update(prod.getNomeProdotto(), prod.getPrezzo(), prod.getDescrizione(), 
                prod.getQuantita(), prod.getImmagine(), prod.getPeso(), prod.getVolume(), prod.getIdAzienda(), prod.getQuantitaMinima(), prod.getId());
    }
    
    public List<Prodotto> findProdottiByAzienda(int id_azienda) {
       return prodottoRepo.findProdottiByAzienda(id_azienda);
    }
    
    public List<Prodotto> findProdottiByNome(String nome) {
        return prodottoRepo.findProdottiByNome(nome);
    }
    
    public List<Prodotto> findProdottiByNomeInAzienda(String nome, int id_azienda) {
        return prodottoRepo.findProdottiByNomeInAzienda(nome, id_azienda);
    } 
    
    public List<Prodotto> findProdottiInOrdine(int id_ordine) {
        return prodottoRepo.findProdottiInOrdine(id_ordine);
    }
    
    public List<Prodotto> findProdottiBySconto(int id_sconto) {
        return prodottoRepo.findProdottiBySconto(id_sconto);
    }
    
    public List<Prodotto> findProdottiByIdInAzienda(int id_prodotto, int id_azienda) {
        return prodottoRepo.findProdottiByIdInAzienda(id_prodotto, id_azienda);
    }
    

}
