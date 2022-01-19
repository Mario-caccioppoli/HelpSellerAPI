
package unisa.is.helpseller.Service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import unisa.is.helpseller.Entity.OrdineProdotto;
import unisa.is.helpseller.Entity.Prodotto;
import unisa.is.helpseller.Repo.OrdineProdottoRepo;

@Service
@Transactional
public class OrdineProdottoService {
	@Autowired
    private final OrdineProdottoRepo ordineProdottoRepo;
    
    @Autowired
    public OrdineProdottoService(OrdineProdottoRepo ordineProdottoRepo) {this.ordineProdottoRepo = ordineProdottoRepo;}

    public List<OrdineProdotto> findAll() {
        return ordineProdottoRepo.findAll();
    }

    public OrdineProdotto findId(OrdineProdotto ordProd) {
        return ordineProdottoRepo.findId(ordProd.getIdOrdine(), ordProd.getIdProdotto());
    }
    
    public int deleteId(OrdineProdotto ordProd) {
    	return ordineProdottoRepo.deleteId(ordProd.getIdOrdine(), ordProd.getIdProdotto());
    }
    
    public int insert(OrdineProdotto ordProd) {
    	return ordineProdottoRepo.insert(ordProd.getIdOrdine(), ordProd.getIdProdotto(), ordProd.getQuantitaOrdine(), ordProd.getPrezzo(), ordProd.getPrezzoUnitario());
    }
    
    public int udpate(OrdineProdotto ordProd) {
    	return ordineProdottoRepo.update(ordProd.getIdOrdine(), ordProd.getIdProdotto(), ordProd.getQuantitaOrdine(), ordProd.getPrezzo(), ordProd.getPrezzoUnitario());
    }
    
    public List<OrdineProdotto> findDettagliOrdine(int id_ordine) {
       return ordineProdottoRepo.findDettagliOrdine(id_ordine);
    }
    
    public List<Prodotto> findDettagliProdotto(int id_ordine) {
       return ordineProdottoRepo.findDettagliProdotto(id_ordine);
    }
    
    public List<Object[]> findDettagliOrdineProdotto(int id_ordine) {
        return ordineProdottoRepo.findDettagliOrdineProdotto(id_ordine);
    }
    
   public Integer findReportAnnuale(Integer anno) {
       return ordineProdottoRepo.findReportAnnuale(anno);
   }
   
   public Integer findReportMensile(String mese, Integer anno, Integer id_azienda) {
       return ordineProdottoRepo.findReportMensile(mese, anno, id_azienda);
   }
   
   public Integer findReportAnnualeAzienda(Integer anno, Integer id_azienda) {
       return ordineProdottoRepo.findReportAnnualeAzienda(anno, id_azienda);
   }
   public Integer findReportMensileGruppo(String mese, Integer anno) {
       return ordineProdottoRepo.findReportMensileGruppo(mese, anno);
   }

}
