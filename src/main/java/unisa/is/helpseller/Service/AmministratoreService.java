
package unisa.is.helpseller.Service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unisa.is.helpseller.Entity.Amministratore;
import unisa.is.helpseller.Repo.AmministratoreRepo;

/**
 *  Classe contenente tutti i servizi relativi all'entity Amministratore
 *
 */

@Service
@Transactional
public class AmministratoreService {
	@Autowired
    private final AmministratoreRepo amministratoreRepo;
    
    @Autowired
    public AmministratoreService(AmministratoreRepo amministratoreRepo) {this.amministratoreRepo = amministratoreRepo;}

    /**
     * metodo per il recupero di tutti le istanze presenti nel DB
     * @return List<Amministratore> lista di oggetti entity
     */
    public List<Amministratore> findAll() {
        return amministratoreRepo.findAll();
    }

    /**
     * metodo per il recupero di una istanza dal DB dato in input il suo ID
     * @param id    intero ID dell'entità ricercata
     * @return oggetto prelevato dal DB, se presente
     */
    public Amministratore findId(int id) {
        return amministratoreRepo.findId(id);
    }

    /**
     * metodo per la rimozione di una istanza dato l'id
     * @param id    id dell'entità da rimuovere
     * @return int id dell'entità rimossa
     */
    public int deleteId(int id) {
        return amministratoreRepo.deleteId(id);
    }

    /**
     * metodo per l'inserimento di un'istanza nel DB
     * @param a Amministratore oggetto entity da inserire nel DB
     * @return int id dell'entità aggiunta
     */
    public int insert(Amministratore a) {
    	return amministratoreRepo.saveAndFlush(a).getId();
    }

    /**
     * metodo per l'update di una entità presente nel DB
     * @param a Amministratore oggetto entity da modificare nel DB
     * @return int id dell'entity modificata
     */
    public int udpate(Amministratore a) {
    	return amministratoreRepo.update(a.getUsername(), a.getEmail(), a.getPassword(), a.getId());
    }

    /**
     * metodo per il recupero della password data una mail
     * @param email stringa contenente l'email dell'oggetto di cui recuperare la password
     * @return String contenente la password recuperata
     */
    public String recuperoPassword(String email) {
        return amministratoreRepo.recuperoPassword(email);
    }
}
