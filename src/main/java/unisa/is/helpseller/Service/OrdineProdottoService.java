
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

    public OrdineProdotto findId(OrdineProdotto ordProd) {
        return ordineProdottoRepo.findId(ordProd.getIdOrdine(), ordProd.getIdProdotto());
    }
    
    public void deleteId(OrdineProdotto ordProd) {
        ordineProdottoRepo.deleteId(ordProd.getIdOrdine(), ordProd.getIdProdotto());
    }
    
    public void insert(OrdineProdotto ordProd) {
        ordineProdottoRepo.insert(ordProd.getIdOrdine(), ordProd.getIdProdotto(), ordProd.getQuantita(), ordProd.getPrezzo(), ordProd.getPrezzoUnitario());
    }
    
    public void udpate(OrdineProdotto ordProd) {
        ordineProdottoRepo.update(ordProd.getIdOrdine(), ordProd.getIdProdotto(), ordProd.getQuantita(), ordProd.getPrezzo(), ordProd.getPrezzoUnitario());
    }
}
