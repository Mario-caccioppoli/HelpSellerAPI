
package unisa.is.helpseller.Service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unisa.is.helpseller.Entity.Ordine;
import unisa.is.helpseller.Repo.OrdineRepo;

/**
 *  Classe contenente tutti i servizi relativi all'entity Amministratore
 *
 */
@Service
@Transactional
public class OrdineService {
	@Autowired
    private final OrdineRepo ordineRepo;
    
    @Autowired
    public OrdineService(OrdineRepo ordineRepo) {this.ordineRepo = ordineRepo;}

    /**
     * metodo per il recupero di tutti le istanze presenti nel DB
     * @return List<Ordine> lista di oggetti entity
     */
    public List<Ordine> findAll() {
        return ordineRepo.findAll();
    }

    /**
     * metodo per il recupero di una istanza dal DB dato in input il suo ID
     * @param id    intero ID dell'entità ricercata
     * @return oggetto prelevato dal DB, se presente
     */
    public Ordine findId(int id) {
        return ordineRepo.findId(id);
    }

    /**
     * metodo per la rimozione di una istanza dato l'id
     * @param id    id dell'entità da rimuovere
     * @return int id dell'entità rimossa
     */
    public int deleteId(int id) {
    	return ordineRepo.deleteId(id);
    }

    /**
     * metodo per l'inserimento di un'istanza nel DB
     * @param Ordine oggetto entity da inserire nel DB
     * @return int id dell'entità aggiunta
     */
    public int insert(Ordine ord) {
    	return ordineRepo.saveAndFlush(ord).getId();
    }

    /**
     * metodo per l'update di una entità presente nel DB
     * @param Ordine oggetto entity da modificare nel DB
     * @return int id dell'entity modificata
     */
    public int update(Ordine ord) {
    	return ordineRepo.update(ord.getCommento(), ord.getStato(), ord.getIdDistributore(), ord.getDataConsegna(), ord.getDataOrdinazione(), ord.getId());
    }

    /**
     * metodo per il recupero degli ordini dato un distributore
     * @param id_distributore id del distributore
     * @return lista degli ordini recuperati
     */
    public List<Ordine> findOrdiniByDistributore(int id_distributore) {
        return ordineRepo.findOrdiniByDistributore(id_distributore);
    }

    /**
     * metodo per il recupero degli ordini data un'azienda
     * @param id_azienda id dell'azienda
     * @return lista degli ordini recuperati
     */
    public List<Ordine> findOrdiniByAzienda(int id_azienda) {
        return ordineRepo.findOrdiniByAzienda(id_azienda);
    }
}
