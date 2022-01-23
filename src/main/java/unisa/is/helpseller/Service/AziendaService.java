package unisa.is.helpseller.Service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unisa.is.helpseller.Entity.Azienda;
import unisa.is.helpseller.Repo.AziendaRepo;

/**
 *  Classe contenente tutti i servizi relativi all'entity Azienda
 *
 */

@Service
@Transactional
public class AziendaService {

    @Autowired
    private final AziendaRepo aziendaRepo;

    @Autowired
    public AziendaService(AziendaRepo aziendaRepo) {
        this.aziendaRepo = aziendaRepo;
    }

    /**
     * metodo per il recupero di tutti le istanze presenti nel DB
     * @return List<Azienda> lista di oggetti entity
     */
    public List<Azienda> findAll() {
        return aziendaRepo.findAll();
    }

    /**
     * metodo per il recupero di una istanza dal DB dato in input il suo ID
     * @param id    intero ID dell'entità ricercata
     * @return oggetto prelevato dal DB, se presente
     */
    public Azienda findId(int id) {
        return aziendaRepo.findId(id);
    }

    /**
     * metodo per la rimozione di una istanza dato l'id
     * @param id    id dell'entità da rimuovere
     * @return int id dell'entità rimossa
     */
    public int deleteId(int id) {
        return aziendaRepo.deleteId(id);
    }

    /**
     * metodo per l'inserimento di un'istanza nel DB
     * @param Azienda oggetto entity da inserire nel DB
     * @return int id dell'entità aggiunta
     */
    public int insert(Azienda a) {
        return aziendaRepo.saveAndFlush(a).getId();
    }

    /**
     * metodo per l'update di una entità presente nel DB
     * @param Azienda oggetto entity da modificare nel DB
     * @return int id dell'entity modificata
     */
    public int update(Azienda a) {
        return aziendaRepo.update(a.getEmail(), a.getPassword(), a.getNomeAzienda(), a.getIndirizzo(), a.getvat(), a.getDescrizione(), a.getLogo(), a.getId());
    }

    /**
     * metodo di ricerca dato il nome dell'azienda
     * @param nome Stringa contenente il nome dell'azienda
     * @return  List<Azienda> lista di oggetti recuperati
     */
    public List<Azienda> findAziendeByNome(String nome) {
        return aziendaRepo.findAziendeByNome(nome);
    }

    /**
     * metodo di ricerca dato l'id del prodotto
     * @param id_prodotto   variabile int contenente l'id del prodotto
     * @return  oggetto dell'azienda produttrice del prodotto
     */
    public Azienda findAziendaByProdotto(int id_prodotto) {
        return aziendaRepo.findAziendaByProdotto(id_prodotto);
    }

    /**
     * metodo per il recupero della password data una mail
     * @param email stringa contenente l'email dell'oggetto di cui recuperare la password
     * @return String contenente la password recuperata
     */
    public String recuperoPassword(String email) {
        return aziendaRepo.recuperoPassword(email);
    }
}
