
package unisa.is.helpseller.Service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unisa.is.helpseller.Entity.ScontoProdotto;
import unisa.is.helpseller.Repo.ScontoProdottoRepo;
/**
 *  Classe contenente tutti i servizi relativi all'entity ScontoProdotto
 *
 */
@Service
@Transactional
public class ScontoProdottoService {
	@Autowired
    private final ScontoProdottoRepo scontoProdottoRepo;
    
    @Autowired
    public ScontoProdottoService(ScontoProdottoRepo scontoProdottoRepo) {this.scontoProdottoRepo = scontoProdottoRepo;}

    /**
     * metodo per il recupero di tutti le istanze presenti nel DB
     * @return List<ScontoProdotto> lista di oggetti entity
     */
    public List<ScontoProdotto> findAll() {
        return scontoProdottoRepo.findAll();
    }

    /**
     * metodo per il recupero di tutti le istanze presenti nel DB
     * @return List<ScontoProdotto> lista di oggetti entity
     */
    public List<ScontoProdotto> findAllScontoProdotto() {
        return scontoProdottoRepo.findAllScontoProdotto();
    }

    /**
     * metodo per il recupero di una istanza dal DB dato in input il suo ID
     * @param id    intero ID dell'entità ricercata
     * @return oggetto prelevato dal DB, se presente
     */
    public List<ScontoProdotto> findBySconto(int id) {
        return scontoProdottoRepo.findBySconto(id);
    }

    /**
     * metodo per il recupero di una istanza dal DB dato in input il suo ID
     * @param id    intero ID dell'entità ricercata
     * @return oggetto prelevato dal DB, se presente
     */
    public List<ScontoProdotto> findByProdotto(int id) {
        return scontoProdottoRepo.findByProdotto(id);
    }

    /**
     * metodo per la rimozione di una istanza dato l'id
     * @param id    id dell'entità da rimuovere
     * @return int id dell'entità rimossa
     */
    public int deleteId(int id_prodotto, int id_sconto) {
    	return scontoProdottoRepo.deleteId(id_prodotto, id_sconto);
    }

    /**
     * metodo per l'inserimento di un'istanza nel DB
     * @param ScontoProdotto oggetto entity da inserire nel DB
     * @return int id dell'entità aggiunta
     */
    public int insert(ScontoProdotto scontoProd) {
    	return scontoProdottoRepo.insert(scontoProd.getIdSconto(), scontoProd.getIdProdotto());
    }

    /**
     * metodo per l'update di una entità presente nel DB
     * @param ScontoProdotto oggetto entity da modificare nel DB
     * @return int id dell'entity modificata
     */
    public int udpate(ScontoProdotto updated, ScontoProdotto old) {
    	return scontoProdottoRepo.update(updated.getIdSconto(), updated.getIdProdotto(), old.getIdSconto(), old.getIdProdotto());
    }
    
    public List<Object[]> findProdottiScontatiAzienda(String nome, int id_azienda) {
        return scontoProdottoRepo.findProdottiScontatiAzienda(nome, id_azienda);
    }
}
