
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
    public List<ScontoProdotto> findAllScontoProdotto() {
        return scontoProdottoRepo.findAllScontoProdotto();
    }


    /**
     * metodo per la rimozione di una istanza dato l'id
     * @param id    id dell'entità da rimuovere
     * @return int id dell'entità rimossa
     */
    public int deleteId(int id_sconto) {
    	return scontoProdottoRepo.deleteId(id_sconto);
    }

    /**
     * metodo per l'inserimento di un'istanza nel DB
     * @param ScontoProdotto oggetto entity da inserire nel DB
     * @return int id dell'entità aggiunta
     */
    public int insert(int sconto, int prodotto) {
    	return scontoProdottoRepo.insert(sconto, prodotto);
    }

}
