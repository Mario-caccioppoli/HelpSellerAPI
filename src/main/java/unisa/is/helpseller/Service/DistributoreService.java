package unisa.is.helpseller.Service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unisa.is.helpseller.Entity.Distributore;
import unisa.is.helpseller.Repo.DistributoreRepo;

/**
 *  Classe contenente tutti i servizi relativi all'entity Distributore
 *
 */
@Service
@Transactional
public class DistributoreService {

    @Autowired
    private final DistributoreRepo distributoreRepo;

    @Autowired
    public DistributoreService(DistributoreRepo distributoreRepo) {
        this.distributoreRepo = distributoreRepo;
    }

    /**
     * metodo per il recupero di tutti le istanze presenti nel DB
     * @return List<Distributore> lista di oggetti entity
     */
    public List<Distributore> findAll() {
        return distributoreRepo.findAll();
    }

    /**
     * metodo per il recupero di una istanza dal DB dato in input il suo ID
     * @param id    intero ID dell'entità ricercata
     * @return oggetto prelevato dal DB, se presente
     */
    public Distributore findId(int id) {
        return distributoreRepo.findId(id);
    }

    /**
     * metodo per la rimozione di una istanza dato l'id
     * @param id    id dell'entità da rimuovere
     * @return int id dell'entità rimossa
     */
    public int deleteId(int id) {
        return distributoreRepo.deleteId(id);
    }

    /**
     * metodo per l'inserimento di un'istanza nel DB
     * @param Distributore oggetto entity da inserire nel DB
     * @return int id dell'entità aggiunta
     */
    public int insert(Distributore d) {
        return distributoreRepo.saveAndFlush(d).getId();
    }

    /**
     * metodo per l'update di una entità presente nel DB
     * @param Distributore oggetto entity da modificare nel DB
     * @return int id dell'entity modificata
     */
    public int update(Distributore d) {
        return distributoreRepo.update(d.getUsername(), d.getEmail(), d.getPassword(), d.getNome(), d.getCognome(),
                d.getTelefono(), d.getIndirizzoSede(), d.getIdOrdineProva(), d.getvat(), d.getId());
    }

    /**
     * metodo per il recupero della password data una mail
     * @param email stringa contenente l'email dell'oggetto di cui recuperare la password
     * @return String contenente la password recuperata
     */
    public String recuperoPassword(String email) {
        return distributoreRepo.recuperoPassword(email);
    }
}
