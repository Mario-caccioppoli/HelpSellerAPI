
package unisa.is.helpseller.Service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unisa.is.helpseller.Entity.Trasporto;
import unisa.is.helpseller.Repo.TrasportoRepo;

/**
 *  Classe contenente tutti i servizi relativi all'entity Trasporto
 *
 */
@Service
@Transactional
public class TrasportoService {
	@Autowired
    private final TrasportoRepo trasportoRepo;
    
    @Autowired
    public TrasportoService(TrasportoRepo trasportoRepo) {this.trasportoRepo = trasportoRepo;}

    /**
     * metodo per il recupero di tutti le istanze presenti nel DB
     * @return List<Amministratore> lista di oggetti entity
     */
    public List<Trasporto> findAll() {
        return trasportoRepo.findAll();
    }

    /**
     * metodo per il recupero di una istanza dal DB dato in input il suo ID
     * @param id    intero ID dell'entità ricercata
     * @return oggetto prelevato dal DB, se presente
     */
    public Trasporto findId(int id) {
        return trasportoRepo.findId(id);
    }

    /**
     * metodo per la rimozione di una istanza dato l'id
     * @param id    id dell'entità da rimuovere
     * @return int id dell'entità rimossa
     */
    public int deleteId(int id) {
       return trasportoRepo.deleteId(id);
    }

    /**
     * metodo per l'inserimento di un'istanza nel DB
     * @param tr Trasporto oggetto entity da inserire nel DB
     * @return int id dell'entità aggiunta
     */
    public int insert(Trasporto tr) {
    	return trasportoRepo.saveAndFlush(tr).getId();
    }

    /**
     * metodo per l'update di una entità presente nel DB
     * @param tr Trasporto oggetto entity da modificare nel DB
     * @return int id dell'entity modificata
     */
    public int udpate(Trasporto tr) {
    	return  trasportoRepo.update(tr.getIdOrdine(), tr.getDataConsegna(), tr.getIndirizzoConsegna(), tr.getQuantitaMinima(), tr.getId());
    }
}
