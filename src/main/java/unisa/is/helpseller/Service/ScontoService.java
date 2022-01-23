
package unisa.is.helpseller.Service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unisa.is.helpseller.Entity.Sconto;
import unisa.is.helpseller.Repo.ScontoRepo;

/**
 *  Classe contenente tutti i servizi relativi all'entity Sconto
 *
 */
@Service
@Transactional
public class ScontoService {
	@Autowired
    private final ScontoRepo scontoRepo;
    
    @Autowired
    public ScontoService(ScontoRepo scontoRepo) {this.scontoRepo = scontoRepo;}

    /**
     * metodo per il recupero di tutti le istanze presenti nel DB
     * @return List<Amministratore> lista di oggetti entity
     */
    public List<Sconto> findAll() {
        return scontoRepo.findAll();
    }

    /**
     * metodo per il recupero di una istanza dal DB dato in input il suo ID
     * @param id    intero ID dell'entità ricercata
     * @return oggetto prelevato dal DB, se presente
     */
    public Sconto findId(int id) {
        return scontoRepo.findId(id);
    }

    /**
     * metodo per la rimozione di una istanza dato l'id
     * @param id    id dell'entità da rimuovere
     * @return int id dell'entità rimossa
     */
    public int deleteId(int id) {
    	return scontoRepo.deleteId(id);
    }

    /**
     * metodo per l'inserimento di un'istanza nel DB
     * @param Sconto oggetto entity da inserire nel DB
     * @return int id dell'entità aggiunta
     */
    public int insert(Sconto sc) {
    	 return scontoRepo.saveAndFlush(sc).getId();
    	//return scontoRepo.insert(sc.getPercentuale(), sc.getTipo(), sc.getQuantita(), sc.getIdAzienda(), sc.getDataFine(), sc.getDataInizio());
    }

    /**
     * metodo per l'update di una entità presente nel DB
     * @param Sconto oggetto entity da modificare nel DB
     * @return int id dell'entity modificata
     */
    public int udpate(Sconto sc) {
    	return scontoRepo.update(sc.getNomeSconto(), sc.getPercentuale(), sc.getTipo(), sc.getQuantita(), sc.getIdAzienda(), 
                sc.getDataFine(), sc.getDataInizio(), sc.getId());
    }

    /**
     * metodo di ricerca data l'azienda
     * @param id_azienda
     * @return lista degli sconti recuperati
     */
    public List<Sconto> findScontiByAzienda(int id_azienda) {
       return scontoRepo.findScontiByAzienda(id_azienda);
    }

    /**
     * metodo di ricerca dato il tipo
     * @param tipo dello sconto
     * @return lista degli sconti recuperati
     */
    public List<Sconto> findScontiByTipo(String tipo) {
        return scontoRepo.findScontiByTipo(tipo);
    }

    /**
     * metodo di ricerca dato il tipo e l'azienda
     * @param tipo
     * @param id_azienda
     * @return lista degli sconti recuperati
     */
    public List<Sconto> findScontiAziendaByTipo(String tipo, int id_azienda) {
        return scontoRepo.findScontiAziendaByTipo(tipo, id_azienda);
    }

    /**
     * metodo di ricerca dato il nome e l'azienda
     * @param nome_sconto
     * @param id_azienda
     * @return lista degli sconti recuperati
     */
    public List<Sconto> findScontiByNomeInAzienda(String nome_sconto, int id_azienda) {
        return scontoRepo.findScontiByNomeInAzienda(nome_sconto, id_azienda);
    }
    
}
