
package unisa.is.helpseller.Service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unisa.is.helpseller.Entity.Recensione;
import unisa.is.helpseller.Repo.RecensioneRepo;

/**
 *  Classe contenente tutti i servizi relativi all'entity Recensione
 *
 */
@Service
@Transactional
public class RecensioneService {
	@Autowired
    private final RecensioneRepo recensioneRepo;
    
    @Autowired
    public RecensioneService(RecensioneRepo recensioneRepo) {this.recensioneRepo = recensioneRepo;}

    /**
     * metodo per il recupero di tutti le istanze presenti nel DB
     * @return List<Recensione> lista di oggetti entity
     */
    public List<Recensione> findAll() {
        return recensioneRepo.findAll();
    }

    /**
     * metodo per il recupero di una istanza dal DB dato in input il suo ID
     * @param id    intero ID dell'entità ricercata
     * @return oggetto prelevato dal DB, se presente
     */
    public Recensione findId(int id) {
        return recensioneRepo.findId(id);
    }

    /**
     * metodo per la rimozione di una istanza dato l'id
     * @param id    id dell'entità da rimuovere
     * @return int id dell'entità rimossa
     */
    public int deleteId(int id) {
    	return recensioneRepo.deleteId(id);
    }

    /**
     * metodo per l'inserimento di un'istanza nel DB
     * @param Recensione oggetto entity da inserire nel DB
     * @return int id dell'entità aggiunta
     */
    public int insert(Recensione rec) {
    	return recensioneRepo.saveAndFlush(rec).getId();
    }

    /**
     * metodo per l'update di una entità presente nel DB
     * @param Recensione oggetto entity da modificare nel DB
     * @return int id dell'entity modificata
     */
    public int udpate(Recensione rec) {
    	return recensioneRepo.update(rec.getTesto(), rec.getVoto(), rec.getData(), rec.getIdProdotto(), rec.getIdDistributore(), rec.getId());
    }

    /**
     * metodo di ricerca delle recensioni dato un prodotto
     * @param id del prodotto
     * @return lista contente oggetti delle recensioni recuperate
     */
    public List<Recensione> findRecensioniByProdotto(int id) {
        return recensioneRepo.findRecensioniByProdotto(id);
    }
}
