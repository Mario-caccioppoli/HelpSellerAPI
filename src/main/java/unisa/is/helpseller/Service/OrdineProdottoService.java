
package unisa.is.helpseller.Service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unisa.is.helpseller.Entity.OrdineProdotto;
import unisa.is.helpseller.Entity.Prodotto;
import unisa.is.helpseller.Repo.OrdineProdottoRepo;

/**
 *  Classe contenente tutti i servizi relativi all'entity OrdineProdotto
 *
 */
@Service
@Transactional
public class OrdineProdottoService {
	@Autowired
    private final OrdineProdottoRepo ordineProdottoRepo;
    
    @Autowired
    public OrdineProdottoService(OrdineProdottoRepo ordineProdottoRepo) {this.ordineProdottoRepo = ordineProdottoRepo;}

    /**
     * metodo per il recupero di tutti le istanze presenti nel DB
     * @return List<OrdineProdotto> lista di oggetti entity
     */
    public List<OrdineProdotto> findAll() {
        return ordineProdottoRepo.findAll();
    }

    /**
     * metodo per il recupero di una istanza dal DB dato in input il suo ID
     * @param ordProd
     * @return oggetto prelevato dal DB, se presente
     */
    public OrdineProdotto findId(OrdineProdotto ordProd) {
        return ordineProdottoRepo.findId(ordProd.getIdOrdine(), ordProd.getIdProdotto());
    }

    /**
     * metodo per la rimozione di una istanza dato l'id
     * @param ordProd id dell'entità da rimuovere
     * @return int id dell'entità rimossa
     */
    public int deleteId(OrdineProdotto ordProd) {
    	return ordineProdottoRepo.deleteId(ordProd.getIdOrdine(), ordProd.getIdProdotto());
    }

    /**
     * metodo per l'inserimento di un'istanza nel DB
     * @param ordProd OrdineProdotto oggetto entity da inserire nel DB
     * @return int id dell'entità aggiunta
     */
    public int insert(OrdineProdotto ordProd) {
    	return ordineProdottoRepo.insert(ordProd.getIdOrdine(), ordProd.getIdProdotto(), ordProd.getQuantitaOrdine(), ordProd.getPrezzo(), ordProd.getPrezzoUnitario());
    }

    /**
     * metodo per l'update di una entità presente nel DB
     * @param ordProd OrdineProdotto oggetto entity da modificare nel DB
     * @return int id dell'entity modificata
     */
    public int udpate(OrdineProdotto ordProd) {
    	return ordineProdottoRepo.update(ordProd.getIdOrdine(), ordProd.getIdProdotto(), ordProd.getQuantitaOrdine(), ordProd.getPrezzo(), ordProd.getPrezzoUnitario());
    }

    /**
     * metodo di ricerca dato l'id di un ordine
     * @param id_ordine id dell'ordine
     * @return lista contenente le entità OrdineProdotto recuperate
     */
    public List<OrdineProdotto> findDettagliOrdine(int id_ordine) {
       return ordineProdottoRepo.findDettagliOrdine(id_ordine);
    }

    /**
     * metodo di ricerca dato l'id di un prodotto
     * @param id_ordine id del prodotto
     * @return lista contenente le entità OrdineProdotto recuperate
     */
    public List<Prodotto> findDettagliProdotto(int id_ordine) {
       return ordineProdottoRepo.findDettagliProdotto(id_ordine);
    }

    public List<Object[]> findDettagliOrdineProdotto(int id_ordine) {
        return ordineProdottoRepo.findDettagliOrdineProdotto(id_ordine);
    }

    /**
     * metodo per il report di un anno dato in input
     * @param anno intero dell'anno
     * @return somma complessiva del valore degli ordini dell'anno
     */
   public Integer findReportAnnuale(Integer anno) {
       return ordineProdottoRepo.findReportAnnuale(anno);
   }

    /**
     * metodo per il report di un mese di una azienda
     * @param anno intero del mese, l'anno e l'id dell'zienda
     * @return somma complessiva del valore degli ordini
     */
   public Integer findReportMensile(String mese, Integer anno, Integer id_azienda) {
       return ordineProdottoRepo.findReportMensile(mese, anno, id_azienda);
   }

    /**
     * metodo per il report di un anno di una azienda
     * @param anno intero dell'anno, l'id dell'azienda
     * @return somma complessiva del valore degli ordini dell'anno
     */
   public Integer findReportAnnualeAzienda(Integer anno, Integer id_azienda) {
       return ordineProdottoRepo.findReportAnnualeAzienda(anno, id_azienda);
   }
    /**
     * metodo per il report di un mese
     * @param anno intero del mese e dell'anno
     * @return somma complessiva del valore degli ordini del mese
     */
   public Integer findReportMensileGruppo(String mese, Integer anno) {
       return ordineProdottoRepo.findReportMensileGruppo(mese, anno);
   }
   
   /**
    * metodo per trovare gli anni in cui esistono ordinazioni
    * @return lista di interi che rappresentano gli anni, dal più recente
    */
   public List<Integer> findAnniOrdini() {
       return ordineProdottoRepo.findAnniOrdini();
   }

}
